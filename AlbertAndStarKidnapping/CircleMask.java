import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A mask used to display the radius around a tower.
 * 
 * @author Ryan Lin
 * @version (a version number or a date)
 */
public class CircleMask extends Sprite
{
    private static final String path = "images/newcircle32.png";
    
    public CircleMask(double x, double y, int radius)
    {
        super(x, y, new GreenfootImage(path), 2*radius, 2*radius, 10);
    }
    
    public void scale(int radius){
        scale(2*radius, 2*radius);
    }
}
