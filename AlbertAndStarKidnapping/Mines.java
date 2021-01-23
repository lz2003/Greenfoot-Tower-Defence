import greenfoot.*;
/**
 * Generates gold currency for the player.
 * 
 * @author Ryan Lin
 * @version (a version number or a date)
 */
public class Mines extends Tower 
{
    private float goldPerSecond;
    private long lastTime;
    /**
     * Creates a gold mine.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public Mines(int x, int y, int iX, int iY)
    {
<<<<<<< Updated upstream
        super(x, y, iX, iY, 1, 0, 1000, new GreenfootImage[]{new GreenfootImage("images/Gold Mine/goldmine1.png"),new GreenfootImage("images/Gold Mine/goldmine2.png"),new GreenfootImage("images/Gold Mine/goldmine3.png")});
        goldPerPeriod = 1;
=======
        super(x, y, iX, iY, 1, 0, 1000, new GreenfootImage[]{
            new GreenfootImage("images/Gold Mine/goldMine1.png"),
            new GreenfootImage("images/Gold Mine/goldMine2.png"),
            new GreenfootImage("images/Gold Mine/goldMine3.png")});
        goldPerSecond = 1;
        lastTime = System.currentTimeMillis();
>>>>>>> Stashed changes
    }

    /**
     * Attack enemies
     */
    protected void attack()
    {
        //produce gold
        long currentTime = System.currentTimeMillis();
        System.out.println(goldPerSecond * ((currentTime - lastTime)/(float)1000));
        Global.getManager().addMoney(goldPerSecond * ((currentTime - lastTime)/(float)1000));
        lastTime = currentTime;
    }
}
