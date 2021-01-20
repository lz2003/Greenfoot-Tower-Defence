import greenfoot.*;
/**
 * Generates gold currency for the player.
 * 
 * @author Ryan Lin
 * @version (a version number or a date)
 */
public class Mines extends Tower 
{
    private int goldPerPeriod;
    
    /**
     * Creates a gold mine.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public Mines(int x, int y, int iX, int iY)
    {
        super(x, y, iX, iY, 1, 0, 1000, new GreenfootImage[]{new GreenfootImage("images/Gold Mine/goldmine1.png"),new GreenfootImage("images/Gold Mine/goldmine2.png"),new GreenfootImage("images/Gold Mine/goldmine3.png")});
        goldPerPeriod = 1;
    }

    /**
     * Attack enemies
     */
    protected void attack(Enemy e)
    {
        //produce gold
    }
}
