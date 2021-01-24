import greenfoot.*;
/**
 * Write a description of class Pillbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pillbox extends CombatTower 
{
    private static final float[]
        MAX_COOLDOWN = {1000, 900, 800},
        MAX_RANGE = {100, 150, 200};
        
    private static final GreenfootImage[][]sprite = {
        {
            new GreenfootImage("images/Cannon/cannon1.png")
        },
        {
            new GreenfootImage("images/Cannon/cannon2.png")
        },
        {
            new GreenfootImage("images/Cannon/cannon3.png")
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
        super(sprite, MAX_RANGE, MAX_COOLDOWN, false, x, y, iX, iY, level);
    }
    
    /**
     * Attack enemies
     */
    protected void attack(Enemy e)
    {
        //do something
        new Cannonball(getX(), getY(), e, level);
    }
    
    /**
     * Returns the string representation of Pillbox
     * @return name of Pillbox
     */
    public String toString(){
        return "Pillbox";
    }
}
