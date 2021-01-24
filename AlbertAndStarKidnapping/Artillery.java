import greenfoot.*;
/**
 * Shoots cannonballs at enemies.
 * 
 * @author Ryan Lin
 * @version (a version number or a date)
 */
public class Artillery extends CombatTower 
{
    private static final float[]
        MAX_COOLDOWN = {1000, 900, 800},
        MAX_RANGE = {100, 150, 200};
    
    private static final GreenfootImage[][] sprite = {
        {
            new GreenfootImage("images/tower/Cannon/L1/0001.png"),
            new GreenfootImage("images/tower/Cannon/L1/0002.png"),
            new GreenfootImage("images/tower/Cannon/L1/0003.png"),
            new GreenfootImage("images/tower/Cannon/L1/0004.png"),
            new GreenfootImage("images/tower/Cannon/L1/0005.png"),
            new GreenfootImage("images/tower/Cannon/L1/0006.png"),
            new GreenfootImage("images/tower/Cannon/L1/0007.png"),
            new GreenfootImage("images/tower/Cannon/L1/0008.png")
        },
        {
            new GreenfootImage("images/tower/Cannon/L2/0001.png"),
            new GreenfootImage("images/tower/Cannon/L2/0002.png"),
            new GreenfootImage("images/tower/Cannon/L2/0003.png"),
            new GreenfootImage("images/tower/Cannon/L2/0004.png"),
            new GreenfootImage("images/tower/Cannon/L2/0005.png"),
            new GreenfootImage("images/tower/Cannon/L2/0006.png"),
            new GreenfootImage("images/tower/Cannon/L2/0007.png"),
            new GreenfootImage("images/tower/Cannon/L2/0008.png")
        },
        {
            new GreenfootImage("images/tower/Cannon/L3/0001.png"),
            new GreenfootImage("images/tower/Cannon/L3/0002.png"),
            new GreenfootImage("images/tower/Cannon/L3/0003.png"),
            new GreenfootImage("images/tower/Cannon/L3/0004.png"),
            new GreenfootImage("images/tower/Cannon/L3/0005.png"),
            new GreenfootImage("images/tower/Cannon/L3/0006.png"),
            new GreenfootImage("images/tower/Cannon/L3/0007.png"),
            new GreenfootImage("images/tower/Cannon/L3/0008.png")
        }
    };
    
    /**
     * Creates a basic Artillery.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public Artillery(int x, int y, int iX, int iY)
    {
        this(x, y, iX, iY, 1);
    }
    
    /**
     * Creates an Artillery with a custom level.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     * @param level the level of the tower
     */
    public Artillery(int x, int y, int iX, int iY, int level)
    {
        super(sprite[Math2D.clamp(level, 1, Tower.MAX_LEVEL)][0], true, x, y, iX, iY, level);
            
        setDimensions(80, 80);
        setY(getY() - 5);
    }
    
    /**
     * Attack enemies
     */
    protected void attack(Enemy e) {
        //fire cannonball
        new Cannonball(getX(), getY(), e, level);
    }
    
    /**
     * Returns the string representation of Artillery
     * @return name of Artillery
     */
    public String toString(){
        return "Artillery";
    }
    
    /**
     * Get the maximum cooldown of the tower
     * @return an array containing the maximum cooldown of the tower
     */
    public float[] getMaxCooldown(){
        return MAX_COOLDOWN;
    }
    
    /**
     * Get the maximum range of the tower
     * @return an array containing the maximum cooldown of the tower
     */
    public float[] getMaxRange(){
        return MAX_RANGE;
    }
    
    /**
     * Get 2D array of sprite images
     * @return 2D array of sprite images
     */
    public GreenfootImage[][] getSpriteImage(){
        return sprite;
    }
}
