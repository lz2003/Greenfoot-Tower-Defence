import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Sprite {
    private static final float 
        DEFAULT_HP = 100,
        DEFAULT_RANGE = 50;
    private float speed = 1;
    private int nodeIndex = 0;
    private Node[] reroutedPath;
    private float hp, maxHp;
    private double distTravelled = 0;
    private float range = 50, rangeSquared = 50 * 50;
    private float coolDown = 1, coolDownTime;
    private boolean magRes, phyRes;
    
    private HPBar hpBar;
    private static final int HPBAR_WIDTH = 100, HPBAR_HEIGHT = 20;
    private static final Color HPBKG = new Color(255, 0, 0), HPFOR = new Color(0, 255, 0);
    private double hpOffset = 50;
    public Enemy(double x, double y, GreenfootImage image) {
        super(x, y, image, 100, 100, 1);
        setLocation(x, y);
        Global.manager.addEnemy(this);
        hp = DEFAULT_HP;
        maxHp = DEFAULT_HP;
        hpBar = new HPBar(x, y, HPBAR_WIDTH, HPBAR_HEIGHT, hp, HPBKG, HPFOR); 
    }
    
    public Enemy(double x, double y, GreenfootImage image, float hp, float range, float coolDown, float speed, boolean magRes, boolean phyRes) {
        super(x, y, image, 100, 100, 1);
        setLocation(x, y);
        Global.manager.addEnemy(this);
        this.hp = hp;
        this.maxHp = hp;
        this.range = range;
        this.rangeSquared = (float) Math.pow(range, 2);
        this.coolDown = coolDown;
        this.coolDownTime = coolDown;
        this.speed = speed;
        this.magRes = magRes;
        this.phyRes = phyRes;
        hpBar = new HPBar(x, y, HPBAR_WIDTH, HPBAR_HEIGHT, hp, HPBKG, HPFOR); 
    }
    
    /**
     * Damage done to enemies to reduce hp
     * @param damage    the amount of damage being dealt
     * @param typeMag   true if the type of damage being dealt is magical
     * @param typePhy   true if the type of damage being dealth is physical
     */
    public void damage(float damage, boolean typeMag, boolean typePhy)
    {
        if((typeMag && magRes) || (typePhy && phyRes))
        {
            hp -= damage * 0.1f;
        }
        else
        {
            hp -= damage;
        }
        updateHP();
        if (hp <= 0)
        {
            die();
        }
    }
    
    /**
     * Heals enemy by a certain amount
     * @param amount    the amount of hp the enemy is healed
     */
    public void heal(float amount) {
        if(hp < maxHp && maxHp - hp >= amount)
        {
            hp += amount;
        }
        else if(hp < maxHp && maxHp - hp < amount)
        {
            hp += maxHp -hp;
        }
        updateHP();
    }
    
    // attack function for the subclasses to shadow
    public void attack() {
    
    }
    
    private void updateHP() {
        hpBar.setHP(hp);
    }
    
    public void _update(float delta) {
        movement(delta);
        checkCanAttack(delta);
        hpBar.setLocation(getX(), getY() - hpOffset);
        updateHP();
    }
    
    public void _receiveBroadcast(int id) {
        if(id == ObjectManager.BROADCAST_REBUILD) {
            resetPath();
        }
    }
    
    private void checkCanAttack(float delta) {
        coolDown -= delta;
        if(Math2D.distanceSquared(Global.manager.getTargetX(), getX(), Global.manager.getTargetY(), getY()) < rangeSquared) {
            if(coolDown < 0) {
                attack();
                coolDown = coolDownTime;
            }   
        }
    }
    
    private void movement(float delta) {
        if(isRemoved()) return;

        Node nextNode;

        nextNode = Global.manager.getPathNode(nodeIndex);
        
        if(nextNode == null) {
            return;
        }
        Point next = nextNode.getWorldLoc();
            
        moveTowards(next.x, next.y);
        
        if(Math2D.distance(getX(), next.x, getY(), next.y) < speed + 5f) {
            nodeIndex++;
        }
    }
    
    public void translate(double x, double y) {
        setLocation(getX() + x, getY() + y);
        distTravelled += Math2D.distance(0, x, 0, y);
    }
    
    public void moveTowards(double x, double y) {
        double angle = Math2D.angleTo(getX(), x, getY(), y);
        
        double velX = speed *  Math.cos(angle);
        double velY = speed * Math.sin(angle);
        
        translate(velX, velY);
    }
    
    private void resetPath() {
        Node[] path = Global.manager.getPath();
        
        float smallestDist = 999999999f;
        int index = 0;

        for(int i = 0; i < path.length; i++) {
            Node n = path[i];
            Point loc = n.getWorldLoc();

            float dist = Math2D.distanceSquared(loc.x, (float) getX(), loc.y, (float) getY());
            if(dist < smallestDist) {
                smallestDist = dist;
                index = i;

            }

        }

        if(Math.sqrt(smallestDist) < Global.SLOT_SIZE) {
            this.nodeIndex = index + 1; // + 1 so it doesn't go back whenever the path changes
        } else {
            this.nodeIndex = index;
        }
    }
    
    private void die() {
        Global.manager.removeEnemy(this);
        removeSprite();
        hpBar.remove();
    }
}
