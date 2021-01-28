import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button that takes the user back to the starting screen.
 * 
 * @author Young Chen
 * @version 2021
 */
public class HomeButton extends ImageButton
{
    private static final GreenfootImage image = new GreenfootImage("images/buttons/home/homeUnpressed.png");
    
    /**
     * Constructor for class HomeButton.
     */
    public HomeButton() {
        super(image);
    }
    
    /**
     * Return the user to the home screen.
     */
    public void onPress() {
        Global.getWorld().stopMusic();
        Greenfoot.setWorld(new Start());
    }
}
