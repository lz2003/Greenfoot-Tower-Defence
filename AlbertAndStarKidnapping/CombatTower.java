import greenfoot.*;
/**
 * A tower that shoots projectiles.
 * 
 * @author Ryan Lin
 * @version (version)
 */
public abstract class CombatTower extends Tower 
{
    /**
     * Constructor for objects of class CombatTower
     */
    public CombatTower(GreenfootImage defaultImage, int x, int y, int iX, int iY)
    {
        this(defaultImage, x, y, iX, iY, 1);
    }
    
    /**
     * Constructor for objects of class CombatTower
     * 
     */
    public CombatTower(GreenfootImage defaultImage, int x, int y, int iX, int iY, int level)
    {
        super(defaultImage, x, y, iX, iY, level);
    }

    /**
     * Update the CombatTower
     */
    public void _update(float delta){
        super._update(delta);
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
