import greenfoot.*;

/**
 * A structure that shoots projectiles at enemies.
 * 
 * @author Ryan Lin
 * @version (a version number or a date)
 */
public abstract class Tower extends Sprite 
{
    protected int cost;
    protected int range;
    protected int level;
    protected int cooldown;
    protected long lastTime;
    protected int iX, iY;
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
        super(x, y, images[0]);
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
        if(canAct() && getNextEnemy() != null){
            attack();
            resetCooldown();
        }
        if(Global.getManager().mouseDown() && System.currentTimeMillis() - lastClicked >= timeDelay){
            if(mask == null){
                if(isSelectedTower()){
                    mask = new CircleMask(getX(), getY(), range);
                    lastClicked = System.currentTimeMillis();
                    Global.world.towerText.setTower(this);
                    Global.world.towerLevel.setTower(this);
                }
            } else if(Global.getManager().mouseX() <= Global.world.canvasWidth && Global.getManager().mouseY() <= Global.world.canvasHeight){
                mask.removeSprite();
                mask = null;
                lastClicked = System.currentTimeMillis();
                Global.world.towerText.unlinkTower(this);
                Global.world.towerLevel.unlinkTower(this);
            }
        }
    }
    
    /**
     * Determines if the cooldown timer has expired
     */
    private boolean canAct(){
        return System.currentTimeMillis() - this.lastTime >= cooldown;
    }
    
    /**
     * Resets Cooldown Timer to zero.
     */
    private void resetCooldown(){
        this.lastTime = System.currentTimeMillis();
    }
    
    /**
     * Get the next enemy targeted by this tower
     * @return Enemy the closest enemy to the tower, null if no enemies exist
     */
    protected Enemy getNextEnemy() {
        double min = range;
        Enemy next = null;
        for(Enemy e: Global.manager.getEnemies()){
            double dist = Math2D.distance(e.getX(), this.getX(), e.getY(), this.getY());
            if(dist < min){
                min = dist;
                next = e;
            }
        }
        return next;
    }
    
    /**
     * Level up the tower
     */
    private void levelup() {
        this.level = Math.max(this.level+1, images.length);
        setImage(images[this.level-1]);
    }
    
    /**
     * Attack enemies
     */
    protected abstract void attack();

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
<<<<<<< Updated upstream
}
=======
    
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
<<<<<<< Updated upstream
}
>>>>>>> Stashed changes
=======
}
>>>>>>> Stashed changes
