import greenfoot.*;
/**
 * Shoots fireballs at enemies.
 * 
 * @author Ryan Lin
 * @version 2021
 */
public class FireballTower extends CombatTower 
{
    private static final float[]
        MAX_COOLDOWN = {1000, 900, 800},
        MAX_RANGE = {170, 190, 210};
        
    private static final GreenfootImage[][]sprite = {
        {
            new GreenfootImage("images/tower/Fire/L1/0001.png"),
            new GreenfootImage("images/tower/Fire/L1/0002.png"),
            new GreenfootImage("images/tower/Fire/L1/0003.png"),
            new GreenfootImage("images/tower/Fire/L1/0004.png"),
            new GreenfootImage("images/tower/Fire/L1/0005.png"),
            new GreenfootImage("images/tower/Fire/L1/0006.png"),
            new GreenfootImage("images/tower/Fire/L1/0007.png"),
            new GreenfootImage("images/tower/Fire/L1/0008.png")
        },
        {
            new GreenfootImage("images/tower/Fire/L1/0001.png"),
            new GreenfootImage("images/tower/Fire/L1/0002.png"),
            new GreenfootImage("images/tower/Fire/L1/0003.png"),
            new GreenfootImage("images/tower/Fire/L1/0004.png"),
            new GreenfootImage("images/tower/Fire/L1/0005.png"),
            new GreenfootImage("images/tower/Fire/L1/0006.png"),
            new GreenfootImage("images/tower/Fire/L1/0007.png"),
            new GreenfootImage("images/tower/Fire/L1/0008.png")
        },
        {
            new GreenfootImage("images/tower/Fire/L3/0001.png"),
            new GreenfootImage("images/tower/Fire/L3/0002.png"),
            new GreenfootImage("images/tower/Fire/L3/0003.png"),
            new GreenfootImage("images/tower/Fire/L3/0004.png"),
            new GreenfootImage("images/tower/Fire/L3/0005.png"),
            new GreenfootImage("images/tower/Fire/L3/0006.png"),
            new GreenfootImage("images/tower/Fire/L3/0007.png"),
            new GreenfootImage("images/tower/Fire/L3/0008.png")
        }
    };
    
    /**
     * Creates a basic FireballTower.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public FireballTower(int x, int y, int iX, int iY)
    {
        this(x, y, iX, iY, 1);   
    }
    
    /**
     * Creates a FireballTower with a custom level.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     * @param level the level of the tower
     */
    public FireballTower(int x, int y, int iX, int iY, int level)
    {
        super(sprite, MAX_RANGE, MAX_COOLDOWN, true, x, y, iX, iY, level);
        setDimensions(50, 120);
        setY(getY() - 25);
    }

    /**
     * Attack enemies
     */
    protected void attack(Enemy e) {
        //fire fireball
        new Fireball(getX(), getY(), e, level);
    }
    
    /**
     * Returns the string representation of FireballTower
     * @return name of FireballTower
     */
    public String toString(){
        return "Fireball Tower";
    }
    
    /**
     * Get the cost of a FireballTower
     * @return the cost of a FireballTower
     */
    public float getCost() {
        return Tower.COST_FIREBALL;
    }
}
