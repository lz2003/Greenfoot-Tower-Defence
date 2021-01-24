import greenfoot.*;
/**
 * Write a description of class Fireball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RPG extends Splash 
{
    // Change these later on
    private static final float[]
        MAX_DAMAGE = {400, 550, 700},
        MAX_RADIUS = {4000, 4000, 4000},
        MAX_SPEED = {9, 9, 9};
    
    private static Animation explosion = new Animation(new GreenfootImage[]{
        new GreenfootImage("images/explosion/0001.png"),
        new GreenfootImage("images/explosion/0002.png"),
        new GreenfootImage("images/explosion/0003.png"),
        new GreenfootImage("images/explosion/0004.png"),
        new GreenfootImage("images/explosion/0005.png"),
        new GreenfootImage("images/explosion/0006.png"),
    });     
    private static GreenfootImage explode = new GreenfootImage("images/explosion/0001.png");
    private static GreenfootImage image = new GreenfootImage("projectiles/rpg.png");
    /**
     * Constructor for Fireball class
     * 
     * @param x         the starting x coordinate
     * @param y         the starting y coordinate
     * @param target    the reference enemy target
     */
    public RPG(double x, double y, Enemy target) {
        super(x, y, image, target, explosion, explode);
        isMagic = true;
        damage = MAX_DAMAGE[0];
        speed = MAX_SPEED[0];
        radius = MAX_RADIUS[0];
    }
    
    /**
     * Constructor for Fireball class
     * 
     * @param x         the starting x coordinate
     * @param y         the starting y coordinate
     * @param target    the reference enemy target
     * @param level     the level of the projectile
     */
    public RPG(double x, double y, Enemy target, int level) {
        super(x, y, image, target, explosion, explode);
        isMagic = true;
        if (level > 0 && level <= MAX_LEVEL) {
            damage = MAX_DAMAGE[level-1];
            speed = MAX_SPEED[level-1];
            radius = MAX_RADIUS[level-1];
        } else {
            damage = MAX_DAMAGE[0];
            speed = MAX_SPEED[0];
            radius = MAX_RADIUS[0];
        }
    }
}
