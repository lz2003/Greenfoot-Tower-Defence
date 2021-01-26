import greenfoot.*;
/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
     * Constructor for objects of class Explosion
     */
    public Explosion(double x, double y) {
        super(x, y, explosion.getFrame(0), 4);
        Global.getManager().addObject(this);
        
        setAnimation(explosion, 0.1f);
    }

    
    public void _update(float delta) {
        animate(delta);
        
        if(getFrameIndex() >= getFrameCount() - 1) {
            Global.getManager().removeObject(this);
            removeSprite();
        }
    }
}
