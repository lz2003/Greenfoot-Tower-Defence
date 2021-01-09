import greenfoot.*;

/**
 * Write a description of class BabyPekka here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BabyPekka extends Enemy 
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class BabyPekka
     */
    public BabyPekka(double x, double y, GreenfootImage image) {
        super(x, y, image);
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
