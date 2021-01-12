import greenfoot.*;
/**
 * Write a description of class Zap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zap extends Projectile 
{
    private static final float[]
        MAX_DAMAGE = {100, 150, 200, 250},
        MAX_SPEED = {1, 1, 2, 2};
    
    private static GreenfootImage image = new GreenfootImage("t1.png");
    
    /**
     * Constructor for Zap class
     * 
     * @param x         the starting x coordinate
     * @param y         the starting y coordinate
     * @param target    the reference enemy target
     */
    public Zap(double x, double y, Enemy target) {
        super(x, y, image, target);
        damage = MAX_DAMAGE[0];
        speed = MAX_SPEED[0];
    }
    
    /**
     * Constructor for Zap class
     * 
     * @param x         the starting x coordinate
     * @param y         the starting y coordinate
     * @param target    the reference enemy target
     * @param level     the level of the projectile
     */
    public Zap(double x, double y, Enemy target, int level) {
        super(x, y, image, target);
        if (level > 0 && level <= MAX_LEVEL) {
            damage = MAX_DAMAGE[level-1];
            speed = MAX_SPEED[level-1];
        } else {
            damage = MAX_DAMAGE[0];
            speed = MAX_SPEED[0];
        }
    }
}
