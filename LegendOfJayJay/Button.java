import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author Young Chen
 * @version 2021
 */
public abstract class Button extends Actor
{
    /**
     * Check for mouse clicks and act accordingly.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) {
            SoundManager.uiSounds(0);
            onPress();
        }
    }   
    
    /**
     * Action when the Button is pressed.
     */
    protected abstract void onPress();
}
