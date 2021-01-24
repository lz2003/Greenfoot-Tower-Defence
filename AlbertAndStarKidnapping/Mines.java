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
        MAX_RANGE = {0, 0, 0};
    private float goldPerSecond;
    /**
     * Creates a gold mine.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public Mines(int x, int y, int iX, int iY)
    {
        super(x, y, iX, iY, 1, 0, 1000, new GreenfootImage[]{
            new GreenfootImage("images/Gold Mine/goldMine1.png"),
            new GreenfootImage("images/Gold Mine/goldMine2.png"),
            new GreenfootImage("images/Gold Mine/goldMine3.png")});
        goldPerSecond = 1;
    }

    /**
     * Attack enemies
     */
    public void _update(float delta)
    {
        //produce gold
        System.out.println(goldPerSecond * delta);
        Global.getManager().addMoney(goldPerSecond * delta);
    }
    
    /**
     * Returns the string representation of Mine
     * @return name of Mine
     */
    public String toString(){
        return "Gold Mine";
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