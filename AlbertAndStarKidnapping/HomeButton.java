import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HomeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HomeButton extends ImageButton
{
    private static final GreenfootImage image = new GreenfootImage("t1.png");
    
    public HomeButton() {
        super(image);
    }
    
    public void onPress() {
        Greenfoot.setWorld(new Start());
    }
}
