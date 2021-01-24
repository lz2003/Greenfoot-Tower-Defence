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
        
    /**
     * Creates a Pillbox.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public Pillbox(int x, int y, int iX, int iY)
    {
        super(x, y, iX, iY, 1, 200, 3000, new GreenfootImage[]{new GreenfootImage("images/Cannon/cannon1.png"),new GreenfootImage("images/Cannon/cannon2.png"),new GreenfootImage("images/Cannon/cannon3.png")});
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
}
