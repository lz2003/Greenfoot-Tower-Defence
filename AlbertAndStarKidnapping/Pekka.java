import greenfoot.*;

/**
 * The Pekka is a large unit that has a large amount of health, large damage, and very slow. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pekka extends Enemy 
{
    private static GreenfootImage idle = new GreenfootImage("t1.png");
    /**
     * Constructor for Pekka
     * 
     * @param x         the x coordinate of Pekka
     * @param y         the y coordinate of Pekka
     */
    public Pekka(double x, double y) {
        super(x, y, idle, 500, 50, 3, 2f, false, false);
    }

}
