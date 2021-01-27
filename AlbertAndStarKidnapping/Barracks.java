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
        super(sprite, MAX_RANGE, MAX_COOLDOWN, false, x, y, iX, iY, level);
        numBarracks++;
        scale(53, 53);
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
    
    public float getCost() {
        return Tower.COST_BARRACKS;
    }
}
