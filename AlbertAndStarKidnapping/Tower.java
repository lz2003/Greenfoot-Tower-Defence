import greenfoot.*;

/**
 * A structure that shoots projectiles at enemies.
 * 
 * @author Ryan Lin
 * @version (a version number or a date)
 */
public abstract class Tower extends Sprite 
{
    protected static final int MAX_LEVEL = 3;
    
    public static final int 
        COST_ARCHER = 250,
        COST_CANNON = 200,
        COST_BARRACKS = 800,
        COST_FIREBALL = 600,
        COST_ICEBALL = 400,
        COST_LASER = 850,
        COST_MINES = 75,
        COST_PILLBOX = 1525;
    
    protected int level;
    protected long lastTime;
    protected int iX, iY;
    protected double rotation = 0;
    protected GreenfootImage[][]image;
    protected float[]range;
    protected float[]cooldown;
    
    /**
     * Creates a tower.
     * @param image a 2D array of sprites
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     * @param level the level of the tower
     */
    public Tower(GreenfootImage[][]image, float[]range, float[]cooldown, int x, int y, int iX, int iY, int level) {
        super(x, y, image[Math2D.clamp(level, 1, Tower.MAX_LEVEL) - 1][0], 1);
        setLocation(x, y);
        this.image = image;
        this.range = range;
        this.cooldown = cooldown;
        this.iX = iX;
        this.iY = iY;
        this.level = level;
        this.lastTime = System.currentTimeMillis();
        Global.manager.addTower(this);
    }
    
    /**
     * Resets Cooldown Timer to zero.
     */
    protected void resetCooldown(){
        this.lastTime = System.currentTimeMillis();
    }
    
    /**
     * Level up the tower
     */
    public void levelup() {
        this.level = Math.min(this.level+1, MAX_LEVEL);
        setImage(image[level-1][0]);
    }
    
    /**
     * Get the current level of the tower
     * @return int level
     */
    public int getLevel() {
        return this.level;
    }
    
    /**
     * Get the x-index of this element in the grid
     * @return int x-index
     */
    public int getIX() {
        return this.iX;
    }
    
    /**
     * Get the y-index of this element in the gird
     * @return int y-index
     */
    public int getIY() {
        return this.iY;
    }
    
    /**
     * Removes the tower from the world
     */
    public void destroy() {
        removeSprite();
        Global.getManager().removeTower(this);
    }
    
    /**
     * Returns if the mouse is currently over this tower
     */
    public boolean isSelectedTower(){
        return Slot.getSelected().getIndex().x == iX && Slot.getSelected().getIndex().y == iY;
    }
    
    /**
     * Get the cooldown at the current level
     * @return the cooldown in milliseconds of the tower
     */
    public float getCooldown(){
        return cooldown[level-1];
    }
    
    /**
     * Get the maximum range at the current level
     * @return the maximum range of the tower
     */
    public float getRange(){
        return range[level-1];
    }
    
    public abstract float getCost();
}
