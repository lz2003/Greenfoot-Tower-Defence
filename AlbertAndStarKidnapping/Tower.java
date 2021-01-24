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
        COST_ICEBALL = 550,
        COST_LASER = 850,
        COST_MINES = 150,
        COST_PILLBOX = 975;
    
    protected int level;
    protected long lastTime;
    protected int iX, iY;
    protected double rotation = 0;
    
    /**
     * Default constructor for tower.
     * @param defaultImage the default image of the tower that is displayed
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public Tower(GreenfootImage defaultImage, int x, int y, int iX, int iY){
        this(defaultImage, x, y, iX, iY, 1);
    }
    
    /**
     * Creates a tower.
     * @param defaultImage the default image of the tower that is displayed
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     * @param level the level of the tower
     */
    public Tower(GreenfootImage defaultImage, int x, int y, int iX, int iY, int level) {
        super(x, y, new GreenfootImage("images/temp.png"), 1);
        setLocation(x, y);
        this.iX = iX;
        this.iY = iY;
        this.level = level;
        this.lastTime = System.currentTimeMillis();
        Global.manager.addTower(this);
    }
    
    /**
     * Update the tower
     */
    public void _update(float delta) {
        
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
    private void levelup() {
        this.level = Math.max(this.level+1, MAX_LEVEL);
        setImage(getSpriteImage()[level][0]);
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
     * Get the maximum cooldown of the tower
     * @return an array containing the maximum cooldown of the tower
     */
    public abstract float[] getMaxCooldown();
    
    /**
     * Get the maximum range of the tower
     * @return an array containing the maximum cooldown of the tower
     */
    public abstract float[] getMaxRange();
    
    /**
     * Get 2D array of sprite images
     * @return 2D array of sprite images
     */
    public abstract GreenfootImage[][] getSpriteImage();
    
    /**
     * Get the cooldown at the current level
     * @return the cooldown in milliseconds of the tower
     */
    public float getCooldown(){
        return getMaxCooldown()[level-1];
    }
    
    /**
     * Get the maximum range at the current level
     * @return the maximum range of the tower
     */
    public float getRange(){
        return getMaxRange()[level-1];
    }
}
