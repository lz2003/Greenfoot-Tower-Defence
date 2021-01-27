import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Text that disappears after a while
 *
 * @author Young Chen
 * @version 2021-01-26
 */
public class DissappearingText extends Label
{
    int alpha = 255;

    /**
     * Creates a disappearing text
     * @param text text string
     * @param x x location
     * @param y y location
     */
    public DissappearingText(String text, int x, int y) {
        super(text, 30);
        Global.getWorld().addObject(this, x, y);
    }
    /**
     * Actor act method
     */
    public void act() 
    {
        if(alpha < 1) {
            getWorld().removeObject(this);
        }
        getImage().setTransparency(alpha--);
    }    
}
