import greenfoot.*;

/**
 * A structure that shoots projectiles at enemies.
 * 
 * @author Ryan Lin
 * @version (a version number or a date)
 */
public class Tower extends Slot 
{
    // instance variables - replace the example below with your own
    private int cost;
    private int range;
    private int level;
    private int frame;
    private int cooldown;
    
    public Tower(int x, int y) {
        super(x, y, 100, 100, true);
        setLocation(x, y);
    }
    
    /**
     * Get the next enemy targeted by this tower
     */
    private void getNextEnemy(){

    }
    
    /**
     * Level up the tower
     */
    private void levelup(){
        
    }
    
    /**
     * Fire a projectile
     */
    private void fire(){
        
    }
    
    /**
     * Get the cost of purchasing the tower
     * @return int cost
     */
    public int getCost(){
        return this.cost;
    }
    
    /**
     * Get the current level of the tower
     * @return int level
     */
    public int getLevel(){
        return this.level;
    }
}
