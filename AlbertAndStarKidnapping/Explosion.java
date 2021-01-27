import greenfoot.*;
/**
 * Explosion effect
 *
 * @author Young Chen
 * @version 2021-01-26
 */
public class Explosion extends Sprite 
{
    private static Animation explosion = new Animation(new GreenfootImage[]{
        new GreenfootImage("images/explosion/0001.png"),
        new GreenfootImage("images/explosion/0002.png"),
        new GreenfootImage("images/explosion/0003.png"),
        new GreenfootImage("images/explosion/0004.png"),
        new GreenfootImage("images/explosion/0005.png"),
        new GreenfootImage("images/explosion/0006.png"),
    });

    /**
     * Creates an explosion effect
     * @param x x location
     * @param y y location
     */
    public Explosion(double x, double y) {
        super(x, y, explosion.getFrame(0), 4);
        Global.getManager().addObject(this);
        
        setAnimation(explosion, 0.1f);
    }

    /**
     * Updates explosion animation
     * @param delta Change in time since last update
     */
    public void _update(float delta) {
        animate(delta);
        
        if(getFrameIndex() >= getFrameCount() - 1) {
            Global.getManager().removeObject(this);
            removeSprite();
        }
    }
}
