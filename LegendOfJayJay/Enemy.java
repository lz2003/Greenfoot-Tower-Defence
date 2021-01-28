import greenfoot.*;
import java.awt.Color;
/**
 * Enemies make their way to Jay Jay the Dragon by following the path in the attempt to defeat/kill it. They are attacked by the towers that are guarding the path. If their health bar reaches 0, the enemy dies. 
 * Each different enemy has different stats and attacks. If they are successful in defeating Jay Jay, the level ends.
 *
 * @author Rachel Tong
 * @author Young Chen
 * @version 2021-01-26
 */
public class Enemy extends Sprite {

    public static final float 
        DEFAULT_HP = 1000,
        DEFAULT_RANGE = 50;
    private float speed = 1;//0.3f;
    private int nodeIndex = 0;
    private Node[] reroutedPath;
    private float hp, maxHp;
    private double distTravelled = 0;
    protected float range = 50, rangeSquared = 50 * 50;
    protected float coolDown = 0, coolDownTime;
    private boolean magRes = false, phyRes = false;
    
    private HPBar hpBar;
    private static final int HPBAR_WIDTH = 40, HPBAR_HEIGHT = 5;
    private static final Color HPBKG = new Color(255, 0, 0), HPFOR = new Color(0, 255, 0);
    protected double hpOffset = 50, velX, velY, angle;
    
    /**
     * Constructor for enemy
     * 
     * @param x         the x coordinate of the enemy
     * @param y         the y coordinate of the enemy
     * @param image     image representing the enemy
     */
    public Enemy(double x, double y, GreenfootImage image) {
        super(x, y, image, 100, 100, 1);
        setLocation(x, y);
        Global.manager.addEnemy(this);
        hp = DEFAULT_HP;
        maxHp = DEFAULT_HP;
        hpBar = new HPBar(x, y, HPBAR_WIDTH, HPBAR_HEIGHT, hp, HPBKG, HPFOR); 
    }
    
    /**
     * Constructor for enemy
     * 
     * @param x         the x coordinate of the enemy
     * @param y         the y coordinate of the enemy
     * @param image     image representing the enemy
     * @param hp        amount of health the enemy has
     * @param range     the range of the enemy attack
     * @param coolDown  time it takes in between enemy attacks 
     * @param speed     movement speed of the enemy
     * @param magRes    true if the enemy has resistance to magical damage
     * @param phyRes    true if the enemy has resistance to physical damage
     */
    public Enemy(double x, double y, GreenfootImage image, float hp, float range, float coolDown, float speed, boolean magRes, boolean phyRes) {
        super(x, y, image, 100, 100, 1);
        setLocation(x, y); 
        Global.manager.addEnemy(this);
        this.hp = hp;
        this.maxHp = hp;
        this.range = range;
        this.rangeSquared = (float) Math.pow(range, 2);
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
        float damageDealed = damage;
        if((typeMag && magRes) || (typePhy && phyRes))
        {
            damageDealed = damage * .1f;
            hp -= damageDealed;
        }
        else
        {
            hp -= damage;
        } 
        updateHP();
        Global.getManager().addMoney(damageDealed / 400f);
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
        /*
        if(hp < maxHp && maxHp - hp >= amount)
        {
            hp += amount;
        }
        else if(hp < maxHp && maxHp - hp < amount)
        {
            hp += maxHp -hp;
        }
        */
        hp = Math.min(hp + amount, maxHp);
        updateHP();
    }
    
    // attack function for the subclasses to shadow
    public void attack() {
    
    }
    
    /**
     * Updates the health bar to represent the current hp
     */
    protected void updateHP() {
        hpBar.setHP(hp);
    }

    /**
     * Enemy update method
     * @param delta Change in time since last update
     */
    public void _update(float delta) {
        movement(delta); 
        checkCanAttack(delta);
        hpBar.setLocation(getX(), getY() - hpOffset);
        updateHP();
    }

    /**
     * Receive broadcast from object manager
     * @param id broadcast magic number
     */
    public void _receiveBroadcast(int id) {
        if(id == ObjectManager.BROADCAST_REBUILD) {
            resetPath();
        }
    }

    /**
     * Whether or not the enemy can attack
     * @param delta change in time since last update
     */
    protected void checkCanAttack(float delta) {
        coolDown -= delta;
        if(Math2D.distanceSquared(Global.manager.getTargetX(), getX(), Global.manager.getTargetY(), getY()) < rangeSquared) {
            if(coolDown < 0) {
                attack();
                coolDown = coolDownTime;
            }   
        }
    }

    /**
     * Move
     * @param delta
     */
    private void movement(float delta) {
        if(isRemoved()) return;

        Node nextNode;

        nextNode = Global.manager.getPathNode(nodeIndex);
        
        if(nextNode == null) {
            return;
        }
        Point next = nextNode.getWorldLoc();
            
        moveTowards(next.x, next.y, delta);
        
        if(Math2D.distance(getX(), next.x, getY(), next.y) < speed + 5f) {
            nodeIndex++;
        }
    }

    /**
     * Move
     * @param x distance in x axis
     * @param y distance in y axis
     */
    public void translate(double x, double y) {
        setLocation(getX() + x, getY() + y);
        distTravelled += Math2D.distance(0, x, 0, y);
    }

    /**
     * Move towards location
     * @param x x location
     * @param y y location
     * @param magnitude distance
     */
    public void moveTowards(double x, double y, float magnitude) {
        this.angle = Math2D.angleTo(getX(), x, getY(), y);

        this.velX = speed *  Math.cos(angle);
        this.velY = speed * Math.sin(angle);
        
        translate(velX, velY);
    }

    /**
     * Reset path when path is rebuilt
     */
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
    
    /**
     * Called when enemy hp hits 0. Removes the enemy and hp bar from the game.
     */
    public void die() {
        Global.manager.removeEnemy(this);
        removeSprite();
        hpBar.remove();
    }

    /**
     * Get current node index in path
     * @return node index
     */
    public int getNodeIndex() {
        return nodeIndex; 
    }
}
