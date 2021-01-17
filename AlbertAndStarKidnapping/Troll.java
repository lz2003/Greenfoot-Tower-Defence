import greenfoot.*;

/**
 * The Troll is decently speedy and has resistance to physical damage. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Troll extends Enemy 
{
    /**
     * Constructor for Troll
     * 
     * @param x         the x coordinate of Troll
     * @param y         the y coordinate of Troll
     * @param image     image representing the Troll
     */
    public Troll(double x, double y, GreenfootImage image) {
        super(x, y, image, 200, 50, 2, 4f, false, true);
    }
}
