import greenfoot.*;
/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends Sprite 
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Background
     */
    public Background(int width, int height)
    {
        super(width/2, height/2, new GreenfootImage("grass.png"), width, height);
    }

}
