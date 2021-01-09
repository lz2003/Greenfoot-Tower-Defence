import greenfoot.*;

/**
 * Write a description of class Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tower extends Slot 
{
    // instance variables - replace the example below with your own
    private int x;

    public Tower(int x, int y) {
        super(x, y, 100, 100, true);
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
