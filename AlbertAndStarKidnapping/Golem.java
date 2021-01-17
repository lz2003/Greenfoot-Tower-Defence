import greenfoot.*;

/**
 * The Golem is a tank unit with lots of health that has the abilty to split into two smaller versions of itself (one time) when it is defeated. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Golem extends Enemy 
{
    /**
     * Constructor for Golem
     * 
     * @param x         the x coordinate of Golem
     * @param y         the y coordinate of Golem
     * @param image     image representing the Golem
     */
    public Golem(double x, double y, GreenfootImage image) {
        super(x, y, image, 750, 50, 4, 1f, false, false);
    }
}
