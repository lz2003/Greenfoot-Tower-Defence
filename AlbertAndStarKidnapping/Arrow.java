import greenfoot.*;
/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends Projectile 
{
    // Change these later on
    private static final float[]
        MAX_DAMAGE = {200, 250, 350},
        MAX_SPEED = {7, 7, 9};
    
    private static GreenfootImage image = new GreenfootImage("projectiles/arrow1.png");
    /**
     * Constructor for Arrow class
     * 
     * @param x         the starting x coordinate
     * @param y         the starting y coordinate
     * @param target    the reference enemy target
     */
    public Arrow(double x, double y, Enemy target) {
        super(x, y, image, target);
        isMagic = false;
        damage = MAX_DAMAGE[0];
        speed = MAX_SPEED[0];
    }
    
    /**
     * Constructor for Arrow class
     * 
     * @param x         the starting x coordinate
     * @param y         the starting y coordinate
     * @param target    the reference enemy target
     * @param level     the level of the projectile
     */
    public Arrow(double x, double y, Enemy target, int level) {
        super(x, y, image, target);
        isMagic = false;
        if (level > 0 && level <= MAX_LEVEL) {
            damage = MAX_DAMAGE[level-1];
            speed = MAX_SPEED[level-1];
        } else {
            damage = MAX_DAMAGE[0];
            speed = MAX_SPEED[0];
        }
    }
}
