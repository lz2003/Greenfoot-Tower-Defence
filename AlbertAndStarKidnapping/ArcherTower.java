import greenfoot.*;
/**
 * Shoots arrows at enemies.
 * 
 * @author Ryan Lin
 * @version (a version number or a date)
 */
public class ArcherTower extends CombatTower 
{
    private static final float[]
        MAX_COOLDOWN = {1000, 900, 850},
        MAX_RANGE = {300, 340, 400};
    
    private static final GreenfootImage[][]sprite = {
        {
            new GreenfootImage("images/tower/Archer/L1/0001.png"),
            new GreenfootImage("images/tower/Archer/L1/0002.png"),
            new GreenfootImage("images/tower/Archer/L1/0003.png"),
            new GreenfootImage("images/tower/Archer/L1/0004.png"),
            new GreenfootImage("images/tower/Archer/L1/0005.png"),
            new GreenfootImage("images/tower/Archer/L1/0006.png"),
            new GreenfootImage("images/tower/Archer/L1/0007.png"),
            new GreenfootImage("images/tower/Archer/L1/0008.png")
        },
        {
            new GreenfootImage("images/tower/Archer/L2/0001.png"),
            new GreenfootImage("images/tower/Archer/L2/0002.png"),
            new GreenfootImage("images/tower/Archer/L2/0003.png"),
            new GreenfootImage("images/tower/Archer/L2/0004.png"),
            new GreenfootImage("images/tower/Archer/L2/0005.png"),
            new GreenfootImage("images/tower/Archer/L2/0006.png"),
            new GreenfootImage("images/tower/Archer/L2/0007.png"),
            new GreenfootImage("images/tower/Archer/L2/0008.png")
        },
        {
            new GreenfootImage("images/tower/Archer/L3/0001.png"),
            new GreenfootImage("images/tower/Archer/L3/0002.png"),
            new GreenfootImage("images/tower/Archer/L3/0003.png"),
            new GreenfootImage("images/tower/Archer/L3/0004.png"),
            new GreenfootImage("images/tower/Archer/L3/0005.png"),
            new GreenfootImage("images/tower/Archer/L3/0006.png"),
            new GreenfootImage("images/tower/Archer/L3/0007.png"),
            new GreenfootImage("images/tower/Archer/L3/0008.png")
        }
    };
    
    /**
     * Creates a basic ArcherTower.
     * @param x the x coordinate of the Archer Tower
     * @param y the y coordinate of the Archer Tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public ArcherTower(int x, int y, int iX, int iY)
    {
        this(x, y, iX, iY, 1);
    }
    
    /**
     * Creates an ArcherTower with a custom level.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     * @param level the level of the Tower
     */
    public ArcherTower(int x, int y, int iX, int iY, int level)
    {
        super(sprite, MAX_RANGE, MAX_COOLDOWN, true, x, y, iX, iY, level);
        setDimensions(60, 120);
        setY(getY() - 25);
    }

    /**
     * Attack enemies
     */
    protected void attack(Enemy e) {
        //Fire an arrow
        new Arrow(getX(), getY(), e, level);
    }
    
    /**
     * Returns the string representation of ArcherTower
     * @return name of ArcherTower
     */
    public String toString(){
        return "Archer Tower";
    }
    
    public float getCost() {
        return Tower.COST_ARCHER;
    }
}
