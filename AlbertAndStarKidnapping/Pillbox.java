import greenfoot.*;
/**
 * Write a description of class Pillbox here.
 * 
 * @author Ryan Lin
 * @version 2021
 */
public class Pillbox extends CombatTower 
{
    private static final float[]
        MAX_COOLDOWN = {4000, 3800, 3500},
        MAX_RANGE = {200, 220, 250};
        
    private static final GreenfootImage[][]sprite = {
        {
            new GreenfootImage("images/tower/Pillbox/L1/0001.png"),
            new GreenfootImage("images/tower/Pillbox/L1/0002.png"),
            new GreenfootImage("images/tower/Pillbox/L1/0003.png"),
            new GreenfootImage("images/tower/Pillbox/L1/0004.png"),
            new GreenfootImage("images/tower/Pillbox/L1/0005.png"),
            new GreenfootImage("images/tower/Pillbox/L1/0006.png"),
            new GreenfootImage("images/tower/Pillbox/L1/0007.png"),
            new GreenfootImage("images/tower/Pillbox/L1/0008.png")
        },
        {
            new GreenfootImage("images/tower/Pillbox/L2/0001.png"),
            new GreenfootImage("images/tower/Pillbox/L2/0002.png"),
            new GreenfootImage("images/tower/Pillbox/L2/0003.png"),
            new GreenfootImage("images/tower/Pillbox/L2/0004.png"),
            new GreenfootImage("images/tower/Pillbox/L2/0005.png"),
            new GreenfootImage("images/tower/Pillbox/L2/0006.png"),
            new GreenfootImage("images/tower/Pillbox/L2/0007.png"),
            new GreenfootImage("images/tower/Pillbox/L2/0008.png")
        },
        {
            new GreenfootImage("images/tower/Pillbox/L3/0001.png"),
            new GreenfootImage("images/tower/Pillbox/L3/0002.png"),
            new GreenfootImage("images/tower/Pillbox/L3/0003.png"),
            new GreenfootImage("images/tower/Pillbox/L3/0004.png"),
            new GreenfootImage("images/tower/Pillbox/L3/0005.png"),
            new GreenfootImage("images/tower/Pillbox/L3/0006.png"),
            new GreenfootImage("images/tower/Pillbox/L3/0007.png"),
            new GreenfootImage("images/tower/Pillbox/L3/0008.png")
        }
    };    
    
    /**
     * Creates a basic Pillbox.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public Pillbox(int x, int y, int iX, int iY)
    {
        this(x, y, iX, iY, 1);
    }

    /**
     * Creates a Pillbox with a custom level.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     * @param level the level of the tower
     */
    public Pillbox(int x, int y, int iX, int iY, int level)
    {
        super(sprite, MAX_RANGE, MAX_COOLDOWN, true, x, y, iX, iY, level);
        setDimensions(72, 74);
    }
    
    /**
     * Attack enemies
     */
    protected void attack(Enemy e)
    {
        //do something
        new RPG(getX(), getY(), e, level);
    }
    
    /**
     * Returns the string representation of Pillbox
     * @return name of Pillbox
     */
    public String toString(){
        return "RPG";
    }
    
    /**
     * Get the cost of Pillbox
     * @retrun the cost of Pillbox
     */
    public float getCost() {
        return Tower.COST_PILLBOX;
    }
}
