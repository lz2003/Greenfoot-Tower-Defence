import greenfoot.*;
/**
 * Shoots Iceballs at enemies.
 * 
 * @author Ryan Lin 
 * @version (a version number or a date)
 */
public class IceballTower extends CombatTower 
{
    private static final float[]
        MAX_COOLDOWN = {400, 360, 320},
        MAX_RANGE = {170, 190, 210};
    
    private static final GreenfootImage[][]sprite = {
        {
            new GreenfootImage("images/tower/Ice/L1/0001.png"),
            new GreenfootImage("images/tower/Ice/L1/0002.png"),
            new GreenfootImage("images/tower/Ice/L1/0003.png"),
            new GreenfootImage("images/tower/Ice/L1/0004.png"),
            new GreenfootImage("images/tower/Ice/L1/0005.png"),
            new GreenfootImage("images/tower/Ice/L1/0006.png"),
            new GreenfootImage("images/tower/Ice/L1/0007.png"),
            new GreenfootImage("images/tower/Ice/L1/0008.png")
        },
        {
            new GreenfootImage("images/tower/Ice/L2/0001.png"),
            new GreenfootImage("images/tower/Ice/L2/0002.png"),
            new GreenfootImage("images/tower/Ice/L2/0003.png"),
            new GreenfootImage("images/tower/Ice/L2/0004.png"),
            new GreenfootImage("images/tower/Ice/L2/0005.png"),
            new GreenfootImage("images/tower/Ice/L2/0006.png"),
            new GreenfootImage("images/tower/Ice/L2/0007.png"),
            new GreenfootImage("images/tower/Ice/L2/0008.png")
        },
        {
            new GreenfootImage("images/tower/Ice/L3/0001.png"),
            new GreenfootImage("images/tower/Ice/L3/0002.png"),
            new GreenfootImage("images/tower/Ice/L3/0003.png"),
            new GreenfootImage("images/tower/Ice/L3/0004.png"),
            new GreenfootImage("images/tower/Ice/L3/0005.png"),
            new GreenfootImage("images/tower/Ice/L3/0006.png"),
            new GreenfootImage("images/tower/Ice/L3/0007.png"),
            new GreenfootImage("images/tower/Ice/L3/0008.png")
        }
    };
    
    /**
     * Creates a basic IceballTower.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public IceballTower(int x, int y, int iX, int iY)
    {
        this(x, y, iX, iY, 1); 
    }
    
    /**
     * Creates an IceballTower with a custom level.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     * @param level the level of the tower
     */
    public IceballTower(int x, int y, int iX, int iY, int level)
    {
        super(sprite, MAX_RANGE, MAX_COOLDOWN, true, x, y, iX, iY, level); 
        setDimensions(50, 120);
        setY(getY() - 25);      
    }

    /**
     * Attack enemies
     */
    protected void attack(Enemy e)
    {
        //fire iceballs
        new Iceball(getX(), getY(), e, level);
    }
    
    /**
     * Returns the string representation of IceballTower
     * @return name of IceballTower
     */
    public String toString(){
        return "Iceball Tower";
    }
}
