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
        super(width/2, height/2, new GreenfootImage("jay.png"), width, height);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
