import greenfoot.*;
/**
 * An enemy's boulder used to hurt Jay Jay
 * 
 * @author Young Chen
 * @version 2021
 */
public class Boulder extends EnemyProjectile 
{
    private static final GreenfootImage[] images= {
        new GreenfootImage("images/projectiles/rock/0001.png"),
        new GreenfootImage("images/projectiles/rock/0002.png"),
        new GreenfootImage("images/projectiles/rock/0003.png"),
        new GreenfootImage("images/projectiles/rock/0004.png"),
        new GreenfootImage("images/projectiles/rock/0005.png"),
        new GreenfootImage("images/projectiles/rock/0006.png"),
        new GreenfootImage("images/projectiles/rock/0007.png"),
        new GreenfootImage("images/projectiles/rock/0008.png"),
        new GreenfootImage("images/projectiles/rock/0009.png"),
        new GreenfootImage("images/projectiles/rock/0010.png"),
        new GreenfootImage("images/projectiles/rock/0011.png"),
        new GreenfootImage("images/projectiles/rock/0012.png"),
        new GreenfootImage("images/projectiles/rock/0013.png"),
        new GreenfootImage("images/projectiles/rock/0014.png"),
        new GreenfootImage("images/projectiles/rock/0015.png"),
        new GreenfootImage("images/projectiles/rock/0016.png"),
        new GreenfootImage("images/projectiles/rock/0017.png"),
        new GreenfootImage("images/projectiles/rock/0018.png"),
        new GreenfootImage("images/projectiles/rock/0019.png"),
        new GreenfootImage("images/projectiles/rock/0020.png")
    };
    
    private static final Animation anim = new Animation(images);

    /**
     * Constructor for objects of class Boulder
     */
    public Boulder(double x, double y, double angle) {
        super(x, y, images[0], angle, 1, 100, 0.8f);
        setAnimation(anim, 0.1f);
        scale(100, 100);

    }
    
    /**
     * Update method of Boulder class
     */
    public void _update(float delta) {
        if (isRemoved()) return;

        move(speed);
        checkCollision();
        checkWorldBounds();
        animate(delta);
    }

}
