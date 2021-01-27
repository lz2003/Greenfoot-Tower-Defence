import greenfoot.*;
/**
 * A magical laserbeam that hits a single target
 * 
 * @author Lucy Zhao
 * @version 2021
 */
public class Zap extends Projectile 
{
    private static final float[]
        MAX_DAMAGE = {350, 400, 500},
        MAX_SPEED = {5, 7, 9};
    
    private static GreenfootImage image = new GreenfootImage("projectiles/zap1.png");
    
    /**
     * Constructor for Zap class
     * 
     * @param x         the starting x coordinate
     * @param y         the starting y coordinate
     * @param target    the reference enemy target
     */
    public Zap(double x, double y, Enemy target) {
        super(x, y, image, target, 4);
        isMagic = true;
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
        super(x, y, image, target, 4);
        isMagic = true;
        if (level > 0 && level <= MAX_LEVEL) {
            damage = MAX_DAMAGE[level-1];
            speed = MAX_SPEED[level-1];
        } else {
            damage = MAX_DAMAGE[0];
            speed = MAX_SPEED[0];
        }
    }
}
