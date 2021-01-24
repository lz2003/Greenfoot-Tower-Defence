import greenfoot.*;
import java.util.*;
/**
 * Spawns NPCs to fight enemies on the path near the tower.
 * 
 * @author Ryan Lin 
 * @version (a version number or a date)
 */
public class Barracks extends CombatTower 
{
    private static final float[]
        MAX_COOLDOWN = {5000, 4200, 3800},
        MAX_RANGE = {300, 400, 500};
    public static final int MINIONS_PER_BARRACK = 3;
    private static int numBarracks = 0;
    /**
     * Creates a tower that spawns characters to fight enemies.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public Barracks(int x, int y, int iX, int iY)
    {
        super(x, y, iX, iY, 1, 200, 3000, new GreenfootImage[]{new GreenfootImage("images/Barracks/barracks1.png"), new GreenfootImage("images/Barracks/barracks2.png"), new GreenfootImage("images/Barracks/barracks3.png")});
        numBarracks++;
    }

    /**
     * Attack enemies
     */
    protected void attack(Enemy e) {
        // do nothing
    }
    
    /**
     * Spawn barbarian
     */
    protected void attack() {
        if(numBarracks * MINIONS_PER_BARRACK > Minion.getNumberOfMinions()) {
            new Minion(getX(), getY());
            resetCooldown();
        }
    }
    
    public void _update(float delta) {
        if(canAct()) {
            attack();
        }
    }
    
    public void destroy() {
        super.destroy();
        numBarracks--;
    }
    
    /**
     * Returns the string representation of Barracks
     * @return name of Barracks
     */
    public String toString(){
        return "Barracks";
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
