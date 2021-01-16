import greenfoot.*;
/**
 * Write a description of class Shells here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shells extends Splash 
{
    // Change these later on
    private static final float[]
        MAX_DAMAGE = {100, 150, 200},
        MAX_RADIUS = {100, 100, 120},
        MAX_SPEED = {5, 5, 7};
    
    private static GreenfootImage image = new GreenfootImage("projectiles/spikedball.png");
    /**
     * Constructor for Shells class
     * 
     * @param x         the starting x coordinate
     * @param y         the starting y coordinate
     * @param target    the reference enemy target
     */
    public Shells(double x, double y, Enemy target) {
        super(x, y, image, target);
        isMagic = false;
        damage = MAX_DAMAGE[0];
        speed = MAX_SPEED[0];
    }
    
    /**
     * Constructor for Shells class
     * 
     * @param x         the starting x coordinate
     * @param y         the starting y coordinate
     * @param target    the reference enemy target
     * @param level     the level of the projectile
     */
    public Shells(double x, double y, Enemy target, int level) {
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
