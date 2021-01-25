import greenfoot.*;
/**
 * Shoots Lazers at enemies.
 * 
 * @author Ryan Lin
 * @version (a version number or a date)
 */
public class LazerTower extends CombatTower 
{
    private static final float[]
        MAX_COOLDOWN = {1000, 900, 800},
        MAX_RANGE = {100, 150, 200};
        
    private static final GreenfootImage[][]sprite = {
        {
            new GreenfootImage("images/tower/Laser/L1/0001.png"),
            new GreenfootImage("images/tower/Laser/L1/0002.png"),
            new GreenfootImage("images/tower/Laser/L1/0003.png"),
            new GreenfootImage("images/tower/Laser/L1/0004.png"),
            new GreenfootImage("images/tower/Laser/L1/0005.png"),
            new GreenfootImage("images/tower/Laser/L1/0006.png"),
            new GreenfootImage("images/tower/Laser/L1/0007.png"),
            new GreenfootImage("images/tower/Laser/L1/0008.png")
        },
        {
            new GreenfootImage("images/tower/Laser/L2/0001.png"),
            new GreenfootImage("images/tower/Laser/L2/0002.png"),
            new GreenfootImage("images/tower/Laser/L2/0003.png"),
            new GreenfootImage("images/tower/Laser/L2/0004.png"),
            new GreenfootImage("images/tower/Laser/L2/0005.png"),
            new GreenfootImage("images/tower/Laser/L2/0006.png"),
            new GreenfootImage("images/tower/Laser/L2/0007.png"),
            new GreenfootImage("images/tower/Laser/L2/0008.png")
        },
        {
            new GreenfootImage("images/tower/Laser/L3/0001.png"),
            new GreenfootImage("images/tower/Laser/L3/0002.png"),
            new GreenfootImage("images/tower/Laser/L3/0003.png"),
            new GreenfootImage("images/tower/Laser/L3/0004.png"),
            new GreenfootImage("images/tower/Laser/L3/0005.png"),
            new GreenfootImage("images/tower/Laser/L3/0006.png"),
            new GreenfootImage("images/tower/Laser/L3/0007.png"),
            new GreenfootImage("images/tower/Laser/L3/0008.png")
        }
    };
    
    /**
     * Creates a basic LazerTower
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public LazerTower(int x, int y, int iX, int iY)
    {
        this(x, y, iX, iY, 1);    
    }
    
    /**
     * Creates a LazerTower with a custom level.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     * @param level the level of the tower
     */
    public LazerTower(int x, int y, int iX, int iY, int level)
    {
        super(sprite, MAX_RANGE, MAX_COOLDOWN, true, x, y, iX, iY, level);
        setDimensions(60, 120);
        setY(getY() - 35);     
    }

    /**
     * Attack enemies
     */
    protected void attack(Enemy e)
    {
        //shoot lazers
        new Zap(getX(), getY(), e, level);
    }
    
    /**
     * Return the string representation of LazerTower
     * @return name of LazerTower
     */
    public String toString(){
        return "Laser Tower";
    }
}
