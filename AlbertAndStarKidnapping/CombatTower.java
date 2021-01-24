import greenfoot.*;
/**
 * A tower that shoots projectiles.
 * 
 * @author Ryan Lin
 * @version (version)
 */
public abstract class CombatTower extends Tower 
{
    private boolean rotate;
    
    /**
     * Constructor for objects of class CombatTower
     * @param defaultImage the image that is shown when the tower is first constructed
     * @param rotate is the tower capable of rotating in eight directions to face the enemy
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public CombatTower(GreenfootImage defaultImage, boolean rotate, int x, int y, int iX, int iY)
    {
        this(defaultImage, rotate, x, y, iX, iY, 1);
    }
    
    /**
     * Constructor for objects of class CombatTower with a custom level
     * @param defaultImage the image that is shown when the tower is first constructed
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     * @param level the level of the tower
     */
    public CombatTower(GreenfootImage defaultImage, boolean rotate, int x, int y, int iX, int iY, int level)
    {
        super(defaultImage, x, y, iX, iY, level);
        this.rotate = rotate;
    }
    
    /**
     * Set Rotation
     */
    private void setRotation() {
        int degrees = (int) Math.toDegrees(this.rotation);
        degrees += 720;
        degrees = degrees % 360;
        degrees += 22; // 45 / 2
        degrees = degrees / 45;
        degrees = degrees % 8;
        setImage(getSpriteImage()[level-1][degrees]);
    }
    
    /**
     * Update the CombatTower
     */
    public void _update(float delta){
        super._update(delta);
        if(rotate) setRotation();
        Enemy enemy = getNextEnemy();
        if(canAct() && enemy != null){
            attack(enemy);
            resetCooldown();
        }
    }
    
    /**
     * Determines if the cooldown timer has expired
     */
    protected boolean canAct(){
        return System.currentTimeMillis() - this.lastTime >= getMaxCooldown()[level-1];
    }
    
    /**
     * Get the next enemy targeted by this tower
     * @return Enemy the closest enemy to the tower, null if no enemies exist
     */
    protected Enemy getNextEnemy() {
        double min = getMaxRange()[level-1];
        Enemy next = null;
        for(Enemy e: Global.manager.getEnemies()){
            double dist = Math2D.distance(e.getX(), this.getX(), e.getY(), this.getY());
            if(dist < getMaxRange()[level-1]){
                min = dist;
                next = e;
            }
        }
        this.rotation = next != null ? Math2D.angleTo(getX(), next.getX(), getY(), next.getY()) : this.rotation;
        return next;
    }
    
    /**
     * Attack enemies
     */
    protected abstract void attack(Enemy e);
}
