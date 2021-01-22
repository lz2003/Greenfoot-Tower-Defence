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
    private static final GreenfootImage image = new GreenfootImage("images/minions/minion.png"); 
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
    private float cooldown = COOLDOWN_TIME;
    
    /**
     * Constructor for objects of class Minion
     */
    public Minion(double x, double y) {
        super(x, y, image, 50, 50, 1);
        numMinions++;
        Global.getManager().addMinion(this);
        hpBar = new HPBar(x, y, HPBAR_WIDTH, HPBAR_HEIGHT, lifeTime, HPBKG, HPFOR);
        updateHPBarLoc();
    }
    
    public void _update(float delta) {
        Enemy nearest = getClosestEnemy();
        
        if(nearest != null) {
            // Don't attack or move is in process of previous attack
            if(cooldown < 0) {
                // Don't move if attacking
                if(!attack(nearest))
                    moveTowards(nearest.getX(), nearest.getY(), speed);
            }
        }
        
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
