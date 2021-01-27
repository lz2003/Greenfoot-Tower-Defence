import greenfoot.*;
import java.util.*;
/**
 * Spawns NPCs to fight enemies on the path near the tower.
 * 
 * @author Young Chen
 * @version 2021
 */
public class Barracks extends Tower 
{
    private static final float[]
        MAX_COOLDOWN = {5000, 4000, 3000},
        MAX_RANGE = {30, 30, 30};
    
    private static final GreenfootImage[][]sprite = {
        {
            new GreenfootImage("images/tower/Barracks/barracks1.png")
        },
        {
            new GreenfootImage("images/tower/Barracks/barracks2.png")
        },
        {
            new GreenfootImage("images/tower/Barracks/barracks3.png")
        }
    };
    public static final int MINIONS_PER_BARRACK = 3;
    private static int numBarracks = 0;
    
    /**
     * Creates a basic Barracks.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public Barracks(int x, int y, int iX, int iY)
    {
        this(x, y, iX, iY, 1);
    }
    
    /**
     * Creates a Barracks with a custom level.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     * @param level the level of the tower
     */
    public Barracks(int x, int y, int iX, int iY, int level)
    {
        super(sprite, MAX_RANGE, MAX_COOLDOWN, x, y, iX, iY, level);
        numBarracks++;
        scale(53, 53);
    }
    
    /**
     * Spawn Minion
     */
    protected void attack() {
        //if there are less minions in the world than are permitted
        if(numBarracks * MINIONS_PER_BARRACK > Minion.getNumberOfMinions()) {
            //create a new minion and reset the cooldown timer
            new Minion(getX(), getY());
            resetCooldown();
        }
    }
    
    /**
     * Update the Barracks
     * @return delta the time in seconds since the last update call
     */
    public void _update(float delta) {
        //if the Barracks' cooldown timer is over, try to spawn minions
        if(canAct()) {
            attack();
        }
    }
    
    /**
     * Destroys the barracks
     */
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
     * Get the cost of a Barracks
     * @return the cost of a Barracks
     */
    public float getCost() {
        return Tower.COST_BARRACKS;
    }
}
