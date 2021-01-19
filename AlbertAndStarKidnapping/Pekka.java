import greenfoot.*;

/**
 * The Pekka is a large unit that has a large amount of health, large damage, and very slow. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pekka extends Enemy 
{
    /**
     * Constructor for Pekka
     * 
     * @param x         the x coordinate of Pekka
     * @param y         the y coordinate of Pekka
     * @param image     image representing the Pekka
     */
    public Pekka(double x, double y, GreenfootImage image) {
        super(x, y, image, 500, 50, 3, 2f, false, false);
    }

}
