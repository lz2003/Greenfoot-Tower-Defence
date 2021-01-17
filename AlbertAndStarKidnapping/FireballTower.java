import greenfoot.*;
/**
 * Shoots fireballs at enemies.
 * 
 * @author Ryan Lin
 * @version (a version number or a date)
 */
public class FireballTower extends Tower 
{
    /**
     * Creates a tower that shoots fireballs at enemies.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public FireballTower(int x, int y, int iX, int iY)
    {
        super(x, y, iX, iY, 1, 200, 3000, new GreenfootImage[]{new GreenfootImage("images/Inferno Tower/infernoTower1.png"),new GreenfootImage("images/Inferno Tower/infernoTower2.png"),new GreenfootImage("images/Inferno Tower/infernoTower3.png")});
    }

    /**
     * Attack enemies
     */
    protected void attack() {
        //fire fireball
        new Fireball(getX(), getY(), getNextEnemy(), level);
    }
}
