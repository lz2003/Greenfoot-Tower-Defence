import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FastForwardButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FastForwardButton extends ImageButton
{
    private static final GreenfootImage image = new GreenfootImage("images/buttons/fastForward/fastForwardUnpressed.png");
    
    public FastForwardButton() {
        super(image);
    }
    
    public void onPress() {
        Global.getManager().getSpawner().nextLevel();
    }   
}
