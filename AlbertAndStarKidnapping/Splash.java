import greenfoot.*;

/**
 * Write a description of class Splash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Splash extends Projectile 
{
    // instance variables - replace the example below with your own
    private int x;

    public Splash(double x, double y, GreenfootImage image) {
        super(x, y, image);
        setLocation(x, y);
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
