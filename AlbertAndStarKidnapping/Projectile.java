import greenfoot.*;
import java.util.ArrayList;
/**
 * A projectile that hits enemies
 * 
 * @author Lucy Zhao
 * @version (a version number or a date)
 */
public abstract class Projectile extends Sprite 
{
    // Max level of the projectile
    protected static final int MAX_LEVEL = 3;
    
    protected float damage;
    protected float speed;
    protected Enemy target;
    protected boolean isMagic;
    
    /**
     * Constructor for Projectile class
     * 
     * @param x         the starting x coordinate
     * @param y         the starting y coordinate
     * @param image     the sprite of the projectile
     * @param target    the reference enemy target
     * @param id        the id of the projectile for sounds
     */
    public Projectile(double x, double y, GreenfootImage image, Enemy target, int id) {
        super(x, y, image, image.getWidth(), image.getHeight(), 1);
        setLocation(x, y);
        turnTowards(target.getX(), target.getY());
        Global.getManager().addProjectile(this);
        SoundManager.projectileSounds(id);
    }
    
    /**
     * Constructor for Projectile class
     * 
     * @param x         the starting x coordinate
     * @param y         the starting y coordinate
     * @param image     the sprite of the projectile
     * @param angle     angle of projectile
     * @param id        the id of the projectile for sounds
     */
    public Projectile(double x, double y, GreenfootImage image, double angle, int id) {
        super(x, y, image, image.getWidth(), image.getHeight(), 1);
        setLocation(x, y);
        setRotation(angle);
        Global.getManager().addProjectile(this);
        SoundManager.projectileSounds(id);
    }
    
    /**
     * Update method
     */
    public void _update(float delta) {
        if (isRemoved()) return;
        move(speed);
        checkCollision();
        checkWorldBounds();
    }
    
    /**
     * Checks if projectile has reached an enemy
     */
    protected void checkCollision() {
        ArrayList<Enemy> enemies = Global.getManager().getEnemies();
        target = null;
        // Can be changed if needed
        double smallestDist = getHeight() * getHeight() * 2;
        for (Enemy e : enemies) {
            double dist = Math2D.distanceSquared(getX(), e.getX(), getY(), e.getY());
            if (dist <= smallestDist) {
                smallestDist = dist;
                target = e;
            }
        }
        damageEnemy();
    }
    
    /**
     * Check if the projectile has reached the edge of the world
     * 
     * Might have to change this if we have a moving camera.
     */
    protected void checkWorldBounds() {
        if (getX() < 0 - 50|| getX() > Game.canvasWidth + 50) {
            destroy();
        } else if (getY() < 0 - 50|| getY() > Game.canvasHeight + 50) {
            destroy();
        }
    }
    
    /**
     * Damages the enemy
     */
    protected void damageEnemy() {
        if (target != null && !isRemoved()) {
            target.damage(damage, isMagic, !isMagic);
            destroy();
        }
    }
    
    /**
     * Destroys the projectile
     */
    protected void destroy() {
        if (!isRemoved()) {
            removeSprite();
            Global.getManager().removeProjectile(this);
        }
    }
}
