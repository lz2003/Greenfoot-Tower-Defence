import greenfoot.*;
/**
 * Shoots Iceballs at enemies.
 * 
 * @author Ryan Lin 
 * @version (a version number or a date)
 */
public class IceballTower extends Tower 
{
    /**
     * Creates a tower that shoots Iceballs at enemies.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public IceballTower(int x, int y, int iX, int iY)
    {
        super(x, y, iX, iY, 1, 200, 3000, new GreenfootImage[]{new GreenfootImage("images/Ice Tower/iceTower1.png"),new GreenfootImage("images/Ice Tower/iceTower2.png"),new GreenfootImage("images/Ice Tower/iceTower3.png")});
    }

    /**
     * Attack enemies
     */
    protected void attack()
    {
        //fire iceballs
        new Iceball(getX(), getY(), getNextEnemy(), level);
    }
}
