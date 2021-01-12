import greenfoot.*;

/**
 * A structure that shoots projectiles at enemies.
 * 
 * @author Ryan Lin
 * @version (a version number or a date)
 */
public abstract class Tower extends Slot 
{
    private int cost;
    private int range;
    private int level;
    private int cooldown;
    private long lastTime;
    private GreenfootImage[]images;
    
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
        super(x, y, iX, iY, false, images[0]);
        setLocation(x, y);
        this.cost = cost;
        this.range = range;
        this.level = 1;
        this.cooldown = cooldown;
        this.images = images;
        this.lastTime = System.currentTimeMillis();
    }
    
    /**
     * Update the tower
     */
    public void _update(float delta) {
        if(canAct()){
            attack();
            resetCooldown();
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
    private Enemy getNextEnemy() {
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
    public int getCost(){
        return this.cost;
    }
    
    /**
     * Set the range of the tower
     */
    public void setRange(int range){
        this.range = range;
    }
    
    /**
     * Get the current level of the tower
     * @return int level
     */
    public int getLevel(){
        return this.level;
    }
}
