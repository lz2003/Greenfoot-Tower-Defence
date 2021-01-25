import greenfoot.*;
/**
 * Write a description of class EnemyProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyProjectile extends Projectile 
{
    /**
     * Constructor for Projectile class
     * 
     * @param x         the starting x coordinate
     * @param y         the starting y coordinate
     * @param image     the sprite of the projectile
     * @param angle     angle of projectile
     * @param id        the id of the projectile for sounds
     */
    public EnemyProjectile(double x, double y, GreenfootImage image, double angle, int id, float damage, float speed) {
        super(x, y, image, angle, 1);
        this.damage = damage;
        this.speed = speed;
    }
    
    /**
     * Does nothing
     */
    protected void damageEnemy() {
    }
    
    /**
     * Checks if projectile has reached an enemy
     */
    protected void checkCollision() {
        // Can be changed if needed
        double smallestDist = getHeight() * getHeight() * 2;
        JayJay e = Global.getManager().getJayJay();
        
        double dist = Math2D.distanceSquared(getX(), e.getX(), getY(), e.getY());
        if (dist <= smallestDist) {
            Global.getManager().damageJayJay(damage);
            destroy();
        }
    }
}
