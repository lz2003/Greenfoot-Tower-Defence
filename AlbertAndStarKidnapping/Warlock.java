import greenfoot.*;

/**
 * The warlock is a magical unit that has resistance to magical damage.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Warlock extends Enemy 
{
    /**
     * Constructor for Warlock
     * 
     * @param x         the x coordinate of Warlock
     * @param y         the y coordinate of Warlock
     * @param image     image representing the Warlock
     */
    public Warlock(double x, double y, GreenfootImage image) {
        super(x, y, image, 125, 50, 1, 3f, true, false);
    }
}
