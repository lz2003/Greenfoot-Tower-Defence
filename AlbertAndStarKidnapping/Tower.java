import greenfoot.*;

/**
 * A structure that shoots projectiles at enemies.
 * 
 * @author Ryan Lin
 * @version (a version number or a date)
 */
public abstract class Tower extends Sprite 
{
    public static final int 
        COST_ARCHER = 250,
        COST_CANNON = 200,
        COST_BARRACKS = 800,
        COST_FIREBALL = 600,
        COST_ICEBALL = 550,
        COST_LASER = 850,
        COST_MINES = 150,
        COST_PILLBOX = 975;
        
    protected int cost;
    protected int range;
    protected int level;
    protected int cooldown;
    protected long lastTime;
    protected int iX, iY;
    protected double rotation = 0;
    private GreenfootImage[]images;
    protected CircleMask mask;
    protected long lastClicked = 0;
    protected long timeDelay = 500;
    
    /**
     * Creates a tower.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     * @param cost the cost to upgrade the tower
     * @param range the range of the tower
     * @param cooldown the number of milliseconds after which a tower will complete an action
     * @param images an array of greenfoot images for each level of the tower
     */
    public Tower(int x, int y, int iX, int iY, int cost, int range, int cooldown, GreenfootImage[]images) {
        super(x, y, images[0], 1);
        setLocation(x, y);
        this.iX = iX;
        this.iY = iY;
        this.cost = cost;
        this.range = range;
        this.level = 1;
        this.cooldown = cooldown;
        this.images = images;
        this.lastTime = System.currentTimeMillis();
        Global.manager.addTower(this);
    }
    
    /**
     * Update the tower
     */
    public void _update(float delta) {
        
    }
    
    /**
     * Determines if the cooldown timer has expired
     */
    protected boolean canAct(){
        return System.currentTimeMillis() - this.lastTime >= cooldown;
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
        this.level = Math.max(this.level+1, images.length);
        setImage(images[this.level-1]);
    }

    /**
     * Get the cost of purchasing the tower
     * @return int cost
     */
    public int getCost() {
        return this.cost;
    }
    
    /**
     * Set the range of the tower
     */
    public void setRange(int range) {
        this.range = range;
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
}
