import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Character class holds an image that can be changed
 * 
 * Rachel Tong 
 * @version Jan 2020
 */
public class Character extends Actor
{
    //Displayed image
    GreenfootImage myImage;
    
    /**
     * Constructor for Character class
     */
    public Character()
    {
        GreenfootImage myImage = getImage();
        setImage(myImage);
    }
    
    /**
     * Constructor for Character class
     * 
     * @param image     displayed image
     */
    public Character(GreenfootImage image)
    {
        GreenfootImage myImage = image;
        setImage(image);
    }
    
    /**
     * Changes the displayed image
     * 
     * @param display   new displayed image
     */
    public void updateImage(GreenfootImage display)
    {
        GreenfootImage myImage = display;
        setImage(display);
    }
    
    /**
     * Removes Character from the world 
     */
    public void finish()
    {
        if(this != null)
        {
            getWorld().removeObject(this);
        }
    }
}
