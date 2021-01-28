import greenfoot.*;
import java.util.ArrayList;
/**
 * Projectiles that can deal area of effect damage
 *
 * @author Lucy Zhao
 * @version 2021
 */
public class Splash extends Projectile 
{
    // Should be changed later on
    protected double radius = 5000;
    private ArrayList<Enemy> targets;
    protected Animation explosion;
    protected boolean exploding = false;
    protected Effect onHit;
    protected GreenfootImage explode;
    protected boolean hasExplosion = false;
    private static final int SPLASH_LIMIT = 8;

    /**
     * Constructor for Splash class
     * 
     * @param x         the starting x coordinate
     * @param y         the starting y coordinate
     * @param image     the sprite of the projectile
     * @param target    the reference enemy target
     * @param id        the id of the projectile for sounds
     */
    public Splash(double x, double y, GreenfootImage image, Enemy target, int id) {
        super(x, y, image, target, id);
    }
    
    /**
     * Constructor for Splash class
     * 
     * @param x         the starting x coordinate
     * @param y         the starting y coordinate
     * @param image     the sprite of the projectile
     * @param target    the reference enemy target
     * @param explosion animation when splash hits an enemy
     * @param explode   animation when splash hits an enemy
     * @param id        the id of the projectile for sounds
     */
    public Splash(double x, double y, GreenfootImage image, Enemy target, Animation explosion, GreenfootImage explode, int id) {
        super(x, y, image, target, id);
        // Intialize animation
        this.explosion = explosion;
        this.explode = explode;
        hasExplosion = true;
    }
    
    /**
     * Update method
     */
    public void _update(float delta) {
        if (isRemoved()) return;
        else if (exploding) {
            if (!onHit.isRemoved()) onHit._update(delta);
            else destroy();
        } else {
            move(speed);
            checkCollision();
            checkWorldBounds();
        }
    }
    
    /**
     * Overridden from the Projectile superclass. Finds multiple enemies
     */
    protected void checkCollision() {
        ArrayList<Enemy> enemies = Global.getManager().getEnemies();
        targets = new ArrayList<Enemy>();
        target = null;
        double smallestDist = getHeight() * getHeight() * 2;
        for (Enemy e : enemies) {
            double dist = Math2D.distanceSquared(getX(), e.getX(), getY(), e.getY());
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
            for (int i = 0; i < targets.size() && i < SPLASH_LIMIT; i++) {
                targets.get(i).damage(damage, isMagic, !isMagic);
            }
            if (hasExplosion) explode();
            else destroy();
        }
    }
    
    /**
     * Play an animation when the splash projectile hits a target
     */
    protected void explode() {
        onHit = new Effect(getX(), getY(), explode, explosion);
        setTransparency(0);
        exploding = true;
        SoundManager.projectileSounds(5);
    }
    
    /**
     * Destroys the projectile
     */
    protected void destroy() {
        if (!isRemoved()) {
            if (onHit != null && !onHit.isRemoved()) {
                onHit.removeSprite();
            }
            removeSprite();
            Global.getManager().removeProjectile(this);
        }
    }
}
