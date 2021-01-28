import greenfoot.*;

/**
 * A structure that shoots projectiles at enemies.
 * 
 * @author Ryan Lin
 * @version 2021
 */
public abstract class Tower extends Sprite 
{
    /**The maximum level of any tower.*/
    public static final int MAX_LEVEL = 3;
    /**Cost of Corresponding Tower.*/
    public static final int 
        COST_ARCHER = 250,
        COST_CANNON = 200,
        COST_BARRACKS = 800,
        COST_FIREBALL = 600,
        COST_ICEBALL = 400,
        COST_LASER = 850,
        COST_MINES = 75,
        COST_PILLBOX = 1525;
    /**The level of the tower.*/
    protected int level;
    /**The last time the cooldown timer was marked.*/
    protected long lastTime;
    /**The row of the grid that the tower is placed on.*/
    protected int iX;
    /**The column of the grid that the tower is placed on.*/
    protected int iY;
    /**The rotation image index.*/
    protected double rotation = 0;
    /**2D array of images of the tower: First dimension is level, second dimension is rotation.*/ 
    protected GreenfootImage[][]image;
    /**The maximum range of the tower, by level.*/
    protected float[]range;
    /**The cooldown time of the tower, by level.*/
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
        SoundManager.towerSounds(0);
    }
    
    /**
     * Resets Cooldown Timer to zero.
     */
    protected void resetCooldown(){
        this.lastTime = System.currentTimeMillis();
    }
    
    /**
     * Determines if the cooldown timer has expired
     */
    protected boolean canAct(){
        return System.currentTimeMillis() - this.lastTime >= cooldown[level-1];
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
        System.out.println("destroyed");
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
    
    /**
     * Get the cost of the tower
     * @return the cost of the tower
     */
    public abstract float getCost();
}
