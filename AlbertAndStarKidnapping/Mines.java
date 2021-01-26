import greenfoot.*;
/**
 * Generates gold currency for the player.
 * 
 * @author Ryan Lin
 * @version (a version number or a date)
 */
public class Mines extends Tower 
{
    private static final float[]
        MAX_COOLDOWN = {1000, 1000, 1000},
        MAX_RANGE = {30, 30, 30};
    
    private static GreenfootImage[][] sprite = {
        {
            new GreenfootImage("images/Gold Mine/goldMine1.png")
        },
        {
            new GreenfootImage("images/Gold Mine/goldMine2.png")
        },
        {
            new GreenfootImage("images/Gold Mine/goldMine3.png")
        }
    };
    private float goldPerSecond;
    /**
     * Creates a basic gold mine.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public Mines(int x, int y, int iX, int iY)
    {
        this(x, y, iX, iY, 1);
    }

    /**
     * Creates a gold mine with a custom level.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public Mines(int x, int y, int iX, int iY, int level)
    {
        super(sprite, MAX_RANGE, MAX_COOLDOWN, x, y, iX, iY, level);
        goldPerSecond = 1;
    }
    
    public void levelup() {
        super.levelup();
        goldPerSecond = level * 1;
    }
    
    /**
     * Attack enemies
     */
    public void _update(float delta)
    {
        //produce gold
        Global.getManager().addMoney(goldPerSecond * delta);
    }
    
    /**
     * Returns the string representation of Mine
     * @return name of Mine
     */
    public String toString(){
        return "Gold Mine";
    }
    
    public float getCost() {
        return Tower.COST_MINES;
    }
}