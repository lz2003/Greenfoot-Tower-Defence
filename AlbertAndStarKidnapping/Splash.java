import greenfoot.*;
import java.util.ArrayList;
/**
 * Projectiles that can deal area of effect damage
 * 
 * @author Lucy Zhao
 * @version (a version number or a date)
 */
public class Splash extends Projectile 
{
    // Should be changed later on
    private double radius = 100;
    private ArrayList<Enemy> targets;
    // Animated explosion animation when it hits ?
    private Animation onHit; 
    // Potentially a instance variable for effects?
    
    /**
     * Constructor for Splash class
     * 
     * @param x         the starting x coordinate
     * @param y         the starting y coordinate
     * @param image     the sprite of the projectile
     * @param target    the reference enemy target
     */
    public Splash(double x, double y, GreenfootImage image, Enemy target) {
        super(x, y, image, target);
    }
    
    /**
     * Constructor for Splash class
     * 
     * @param x         the starting x coordinate
     * @param y         the starting y coordinate
     * @param image     the sprite of the projectile
     * @param target    the reference enemy target
     * @param onHit     animation when splash hits an enemy
     */
    public Splash(double x, double y, GreenfootImage image, Enemy target, Animation onHit) {
        super(x, y, image, target);
        // Intialize animation
    }
    
    /**
     * Overridden from the Projectile superclass. Finds multiple enemies
     */
    protected void checkCollision() {
        ArrayList<Enemy> enemies = Global.getManager().getEnemies();
        targets = new ArrayList<Enemy>();
        target = null;
        double smallestDist = getHeight()/2;
        for (Enemy e : enemies) {
            double dist = Math2D.distance(getX(), e.getX(), getY(), e.getY());
            // Find the enemy who is directly hit by the splash
            if (dist <= smallestDist) {
                smallestDist = dist;
                target = e;
                targets.add(e);
            } // Find enemies that are within the radius
            else if (dist <= radius) {
                targets.add(e);
            }
        }
        damageEnemy();
    }
    
    /**
     * Overridden from the Projectile superclass. Hurts multiple enemies
     */
    protected void damageEnemy() {
        // If the projectile directly hits an enemy, then hurt everyone in the radius
        if (target != null && !isRemoved()) {
            for (Enemy e: targets) {
                //e.damage(damage, isMagic, !isMagic);
                //System.out.println("HIT");
            }
            destroy();
        }
    }
    
    /**
     * Play an animation when the splash projectile hits a target
     */
    protected void explode() {
    }
}
