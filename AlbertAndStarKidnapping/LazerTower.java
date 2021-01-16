import greenfoot.*;
/**
 * Shoots Lazers at enemies.
 * 
 * @author Ryan Lin
 * @version (a version number or a date)
 */
public class LazerTower extends Tower 
{
    /**
     * Creates a tower that shoots lazers at enemies.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public LazerTower(int x, int y, int iX, int iY)
    {
        super(x, y, iX, iY, 1, 200, 1000, new GreenfootImage[]{new GreenfootImage("images/Hidden Tesla/hiddenTesla1.png"),new GreenfootImage("images/Hidden Tesla/hiddenTesla2.png"),new GreenfootImage("images/Hidden Tesla/hiddenTesla3.png")});
    }

    /**
     * Attack enemies
     */
    protected void attack()
    {
        //shoot lazers
        new Zap(getX(), getY(), getNextEnemy(), level);
    }
}
