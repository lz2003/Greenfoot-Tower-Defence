import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button that displays an image.
 * 
 * @author Young Chen
 * @version 2021
 */
public abstract class ImageButton extends Button
{
    private GreenfootImage image;
    
    /**
     * Simple constructor for ImageButton class
     */
    public ImageButton(GreenfootImage image) {
        this(image, true);
    }
    
    /**
     * Constructor with option for no automatic scaling for ImageButton class
     * @param image The image to be displayed by the button.
     * @param autoscale Is the image going to be autoscaled to the default size
     */
    public ImageButton(GreenfootImage image, boolean autoscale) {
        this.image = image;
        setImage(image);
        if(autoscale)
            getImage().scale(75, 75);
    }
}
