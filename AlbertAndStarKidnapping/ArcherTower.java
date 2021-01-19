import greenfoot.*;
/**
 * Shoots arrows at enemies.
 * 
 * @author Ryan Lin
 * @version (a version number or a date)
 */
public class ArcherTower extends Tower 
{
    /**
     * Creates a tower than shoots Arrows at physical Enemies.
     * @param x the x coordinate of the Archer Tower
     * @param y the y coordinate of the Archer Tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public ArcherTower(int x, int y, int iX, int iY)
    {
        super(x, y, iX, iY, 1, 200, 3000, new GreenfootImage[]{new GreenfootImage("images/Archer Tower/archerTower1.png"),new GreenfootImage("images/Archer Tower/archerTower2.png"), new GreenfootImage("images/Archer Tower/archerTower3.png")});
    }

    /**
     * Attack enemies
     */
    protected void attack() {
        //Fire an arrow
        new Arrow(getX(), getY(), getNextEnemy(), level);
    }
}
