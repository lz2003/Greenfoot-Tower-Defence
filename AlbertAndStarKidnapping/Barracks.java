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
}
