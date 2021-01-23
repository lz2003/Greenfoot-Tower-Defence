import greenfoot.*;
/**
 * Write a description of class Pillbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pillbox extends CombatTower 
{
    /**
     * Creates a Pillbox.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public Pillbox(int x, int y, int iX, int iY)
    {
        super(x, y, iX, iY, 1, 200, 3000, new GreenfootImage[]{new GreenfootImage("images/Cannon/cannon1.png"),new GreenfootImage("images/Cannon/cannon2.png"),new GreenfootImage("images/Cannon/cannon3.png")});
    }

    /**
     * Attack enemies
     */
    protected void attack(Enemy e)
    {
        //do something
        new Cannonball(getX(), getY(), e, level);
    }
}
