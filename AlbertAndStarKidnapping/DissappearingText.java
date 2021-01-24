import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DissappearingText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DissappearingText extends Label
{
    int alpha = 255;
    public DissappearingText(String text, int x, int y) {
        super(text, 30);
        Global.getWorld().addObject(this, x, y);
    }
    /**
     * Act - do whatever the DissappearingText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(alpha < 1) {
            getWorld().removeObject(this);
        }
        getImage().setTransparency(alpha--);
    }    
}
