import greenfoot.*;
/**
 * Wall that does nothing
 * 
 * @author Ryan Lin
 * @version 2021
 */
public class Wall extends Tower 
{
    private static final float[]
        MAX_COOLDOWN = {0, 0, 0},
        MAX_RANGE = {0, 0, 0};
    
    private static GreenfootImage[][] sprite = {
        {
            new GreenfootImage("images/tower/wall.png")
        },
        {
            new GreenfootImage("images/tower/wall2.png")
        },
        {
            new GreenfootImage("images/tower/wall3.png")
        }
    };

    /**
     * Creates a basic wall
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public Wall(int x, int y, int iX, int iY)
    {
        this(x, y, iX, iY, 1);
    }

    /**
     * Creates a wall
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public Wall(int x, int y, int iX, int iY, int level)
    {
        super(sprite, MAX_RANGE, MAX_COOLDOWN, x, y, iX, iY, level);
        scale(70, 70);
    }
    
    /**
     * Be a nice wall and do nothing
     */
    public void _update(float delta)
    {

    }
    
    /**
     * Returns the string representation of Wall
     * @return name of Wall
     */
    public String toString(){
        return "Wall";
    }
    
    public float getCost() {
        return 0;
    }
}