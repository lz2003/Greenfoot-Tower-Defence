import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class Minion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Minion extends Sprite
{
    private static Animation[] a0 = new Animation[] {
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/minions/0/0001.png"),
        new GreenfootImage("images/minions/0/0002.png"),
        new GreenfootImage("images/minions/0/0003.png"),
        new GreenfootImage("images/minions/0/0004.png"),
        new GreenfootImage("images/minions/0/0005.png"),
        new GreenfootImage("images/minions/0/0006.png"),
        new GreenfootImage("images/minions/0/0007.png"),
        new GreenfootImage("images/minions/0/0008.png"),
        new GreenfootImage("images/minions/0/0009.png"),
        new GreenfootImage("images/minions/0/0010.png"),
        new GreenfootImage("images/minions/0/0011.png"),
        new GreenfootImage("images/minions/0/0012.png"),
        new GreenfootImage("images/minions/0/0013.png"),
        new GreenfootImage("images/minions/0/0014.png"),
        new GreenfootImage("images/minions/0/0015.png"),
        new GreenfootImage("images/minions/0/0016.png"),
        new GreenfootImage("images/minions/0/0017.png"),
        new GreenfootImage("images/minions/0/0018.png"),
        new GreenfootImage("images/minions/0/0019.png"),
        new GreenfootImage("images/minions/0/0020.png")
    }),
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/minions/attack/0/0001.png"),
        new GreenfootImage("images/minions/attack/0/0002.png"),
        new GreenfootImage("images/minions/attack/0/0003.png"),
        new GreenfootImage("images/minions/attack/0/0004.png"),
        new GreenfootImage("images/minions/attack/0/0005.png"),
        new GreenfootImage("images/minions/attack/0/0006.png"),
        new GreenfootImage("images/minions/attack/0/0007.png"),
        new GreenfootImage("images/minions/attack/0/0008.png"),
        new GreenfootImage("images/minions/attack/0/0009.png"),
        new GreenfootImage("images/minions/attack/0/0010.png"),
        new GreenfootImage("images/minions/attack/0/0011.png"),
        new GreenfootImage("images/minions/attack/0/0012.png"),
        new GreenfootImage("images/minions/attack/0/0013.png"),
        new GreenfootImage("images/minions/attack/0/0014.png"),
        new GreenfootImage("images/minions/attack/0/0015.png"),
        new GreenfootImage("images/minions/attack/0/0016.png"),
        new GreenfootImage("images/minions/attack/0/0017.png"),
        new GreenfootImage("images/minions/attack/0/0018.png"),
        new GreenfootImage("images/minions/attack/0/0019.png"),
        new GreenfootImage("images/minions/attack/0/0020.png")
    })}; 
    
    private static Animation[] a90 = new Animation[] {
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/minions/90/0001.png"),
        new GreenfootImage("images/minions/90/0002.png"),
        new GreenfootImage("images/minions/90/0003.png"),
        new GreenfootImage("images/minions/90/0004.png"),
        new GreenfootImage("images/minions/90/0005.png"),
        new GreenfootImage("images/minions/90/0006.png"),
        new GreenfootImage("images/minions/90/0007.png"),
        new GreenfootImage("images/minions/90/0008.png"),
        new GreenfootImage("images/minions/90/0009.png"),
        new GreenfootImage("images/minions/90/0010.png"),
        new GreenfootImage("images/minions/90/0011.png"),
        new GreenfootImage("images/minions/90/0012.png"),
        new GreenfootImage("images/minions/90/0013.png"),
        new GreenfootImage("images/minions/90/0014.png"),
        new GreenfootImage("images/minions/90/0015.png"),
        new GreenfootImage("images/minions/90/0016.png"),
        new GreenfootImage("images/minions/90/0017.png"),
        new GreenfootImage("images/minions/90/0018.png"),
        new GreenfootImage("images/minions/90/0019.png"),
        new GreenfootImage("images/minions/90/0020.png")
    }),
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/minions/attack/90/0001.png"),
        new GreenfootImage("images/minions/attack/90/0002.png"),
        new GreenfootImage("images/minions/attack/90/0003.png"),
        new GreenfootImage("images/minions/attack/90/0004.png"),
        new GreenfootImage("images/minions/attack/90/0005.png"),
        new GreenfootImage("images/minions/attack/90/0006.png"),
        new GreenfootImage("images/minions/attack/90/0007.png"),
        new GreenfootImage("images/minions/attack/90/0008.png"),
        new GreenfootImage("images/minions/attack/90/0009.png"),
        new GreenfootImage("images/minions/attack/90/0010.png"),
        new GreenfootImage("images/minions/attack/90/0011.png"),
        new GreenfootImage("images/minions/attack/90/0012.png"),
        new GreenfootImage("images/minions/attack/90/0013.png"),
        new GreenfootImage("images/minions/attack/90/0014.png"),
        new GreenfootImage("images/minions/attack/90/0015.png"),
        new GreenfootImage("images/minions/attack/90/0016.png"),
        new GreenfootImage("images/minions/attack/90/0017.png"),
        new GreenfootImage("images/minions/attack/90/0018.png"),
        new GreenfootImage("images/minions/attack/90/0019.png"),
        new GreenfootImage("images/minions/attack/90/0020.png")
    })};  
    
    private static Animation[] a180 = new Animation[] {
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/minions/180/0001.png"),
        new GreenfootImage("images/minions/180/0002.png"),
        new GreenfootImage("images/minions/180/0003.png"),
        new GreenfootImage("images/minions/180/0004.png"),
        new GreenfootImage("images/minions/180/0005.png"),
        new GreenfootImage("images/minions/180/0006.png"),
        new GreenfootImage("images/minions/180/0007.png"),
        new GreenfootImage("images/minions/180/0008.png"),
        new GreenfootImage("images/minions/180/0009.png"),
        new GreenfootImage("images/minions/180/0010.png"),
        new GreenfootImage("images/minions/180/0011.png"),
        new GreenfootImage("images/minions/180/0012.png"),
        new GreenfootImage("images/minions/180/0013.png"),
        new GreenfootImage("images/minions/180/0014.png"),
        new GreenfootImage("images/minions/180/0015.png"),
        new GreenfootImage("images/minions/180/0016.png"),
        new GreenfootImage("images/minions/180/0017.png"),
        new GreenfootImage("images/minions/180/0018.png"),
        new GreenfootImage("images/minions/180/0019.png"),
        new GreenfootImage("images/minions/180/0020.png")
    }),
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/minions/attack/180/0001.png"),
        new GreenfootImage("images/minions/attack/180/0002.png"),
        new GreenfootImage("images/minions/attack/180/0003.png"),
        new GreenfootImage("images/minions/attack/180/0004.png"),
        new GreenfootImage("images/minions/attack/180/0005.png"),
        new GreenfootImage("images/minions/attack/180/0006.png"),
        new GreenfootImage("images/minions/attack/180/0007.png"),
        new GreenfootImage("images/minions/attack/180/0008.png"),
        new GreenfootImage("images/minions/attack/180/0009.png"),
        new GreenfootImage("images/minions/attack/180/0010.png"),
        new GreenfootImage("images/minions/attack/180/0011.png"),
        new GreenfootImage("images/minions/attack/180/0012.png"),
        new GreenfootImage("images/minions/attack/180/0013.png"),
        new GreenfootImage("images/minions/attack/180/0014.png"),
        new GreenfootImage("images/minions/attack/180/0015.png"),
        new GreenfootImage("images/minions/attack/180/0016.png"),
        new GreenfootImage("images/minions/attack/180/0017.png"),
        new GreenfootImage("images/minions/attack/180/0018.png"),
        new GreenfootImage("images/minions/attack/180/0019.png"),
        new GreenfootImage("images/minions/attack/180/0020.png")
    })}; 
    
    private static Animation[] a270 = new Animation[] {
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/minions/270/0001.png"),
        new GreenfootImage("images/minions/270/0002.png"),
        new GreenfootImage("images/minions/270/0003.png"),
        new GreenfootImage("images/minions/270/0004.png"),
        new GreenfootImage("images/minions/270/0005.png"),
        new GreenfootImage("images/minions/270/0006.png"),
        new GreenfootImage("images/minions/270/0007.png"),
        new GreenfootImage("images/minions/270/0008.png"),
        new GreenfootImage("images/minions/270/0009.png"),
        new GreenfootImage("images/minions/270/0010.png"),
        new GreenfootImage("images/minions/270/0011.png"),
        new GreenfootImage("images/minions/270/0012.png"),
        new GreenfootImage("images/minions/270/0013.png"),
        new GreenfootImage("images/minions/270/0014.png"),
        new GreenfootImage("images/minions/270/0015.png"),
        new GreenfootImage("images/minions/270/0016.png"),
        new GreenfootImage("images/minions/270/0017.png"),
        new GreenfootImage("images/minions/270/0018.png"),
        new GreenfootImage("images/minions/270/0019.png"),
        new GreenfootImage("images/minions/270/0020.png")
    }),
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/minions/attack/270/0001.png"),
        new GreenfootImage("images/minions/attack/270/0002.png"),
        new GreenfootImage("images/minions/attack/270/0003.png"),
        new GreenfootImage("images/minions/attack/270/0004.png"),
        new GreenfootImage("images/minions/attack/270/0005.png"),
        new GreenfootImage("images/minions/attack/270/0006.png"),
        new GreenfootImage("images/minions/attack/270/0007.png"),
        new GreenfootImage("images/minions/attack/270/0008.png"),
        new GreenfootImage("images/minions/attack/270/0009.png"),
        new GreenfootImage("images/minions/attack/270/0010.png"),
        new GreenfootImage("images/minions/attack/270/0011.png"),
        new GreenfootImage("images/minions/attack/270/0012.png"),
        new GreenfootImage("images/minions/attack/270/0013.png"),
        new GreenfootImage("images/minions/attack/270/0014.png"),
        new GreenfootImage("images/minions/attack/270/0015.png"),
        new GreenfootImage("images/minions/attack/270/0016.png"),
        new GreenfootImage("images/minions/attack/270/0017.png"),
        new GreenfootImage("images/minions/attack/270/0018.png"),
        new GreenfootImage("images/minions/attack/270/0019.png"),
        new GreenfootImage("images/minions/attack/270/0020.png")
    })}; 
    
    private static int numMinions = 0;
    private static float COOLDOWN_TIME = 2f;
    private double range = 200, attackRange = Math.pow(25, 2);
    private float lifeTime = 15;
    private double speed = 0.6;
    private static final int HPBAR_WIDTH = 40, HPBAR_HEIGHT = 5;
    private static final Color HPBKG = new Color(255, 0, 0), HPFOR = new Color(0, 255, 0);
    private int damage = 150;
    private HPBar hpBar;
    private static double hpOffset = 50;
    private float cooldown = 0;
    
    /**
     * Constructor for objects of class Minion
     */
    public Minion(double x, double y) {
        super(x, y, a0[0].getFrame(0), 50, 50, 1);
        numMinions++;
        Global.getManager().addMinion(this);
        hpBar = new HPBar(x, y, HPBAR_WIDTH, HPBAR_HEIGHT, lifeTime, HPBKG, HPFOR);
        updateHPBarLoc();
        
        scale(60, 60);
    }
    
    private static double overPi = 180./Math.PI;
    private int angle = 0;
    
    public void _update(float delta) {
        Enemy nearest = getClosestEnemy();
        
        if(nearest != null) {
            // Don't attack or move is in process of previous attack
            if(cooldown < 0) {
                // Don't move if attacking
                if(!attack(nearest))
                    moveTowards(nearest.getX(), nearest.getY(), speed);
            }
            
            angle = (int) (Math2D.angleTo(getX(), nearest.getX(), getY(), nearest.getY()) * overPi);
            angle += 720 + 45;
            angle = angle % 360;
            angle /= 90;
        }
        
        int index = 0;
        if(cooldown > 0) {
            index = 1;
        }
        
        switch(angle) {
            case 0:
                setAnimation(a0[index], 0.1f);
                break;
            case 1:
                setAnimation(a90[index], 0.1f);
                break;
            case 2:
                setAnimation(a180[index], 0.1f);
                break;
            case 3:
                setAnimation(a270[index], 0.1f);
                break;
        }

        animate(delta);
        
        cooldown -= delta;
        
        lifeTime -= delta;
        hpBar.setHP(lifeTime);
        updateHPBarLoc();
        
        if(lifeTime <= 0) {
            destroy();
            return;
        }
    }
    
    private boolean attack(Enemy nearest) {
       if(Math2D.distanceSquared(getX(), nearest.getX(), getY(), nearest.getY()) < attackRange) {
            nearest.damage(damage, false, false);
            cooldown = COOLDOWN_TIME;
            return true;
        }
        return false;
    }
    
    private void updateHPBarLoc() {
        hpBar.setLocation(getX(), getY() - hpOffset);
    }

    private Enemy getClosestEnemy() {
        double min = Math.pow(range, 2);
        Enemy next = null;
        for(Enemy e: Global.manager.getEnemies()){
            double dist = Math2D.distanceSquared(e.getX(), this.getX(), e.getY(), this.getY());
            if(dist < min){
                min = dist;
                next = e;
            }
        }
        
        return next;
    }
    
    public void destroy() {
        hpBar.remove();
        removeSprite();
        Global.getManager().removeMinion(this);
        numMinions--;
    }
    
    public static int getNumberOfMinions() {
        return numMinions;
    }
}
