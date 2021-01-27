import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ImageButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImageButton extends Button
{
    private GreenfootImage image;
    
    public ImageButton(GreenfootImage image) {
        this.image = image;
        setImage(image);
        getImage().scale(75, 75);
    }
    
    public ImageButton(GreenfootImage image, boolean autoscale) {
        this.image = image;
        setImage(image);
        if(autoscale)
            getImage().scale(75, 75);
    }
}
