import greenfoot.*;
/**
 * A tower that shoots projectiles.
 * 
 * @author Ryan Lin
 * @author Young Chen
 * @version 2021
 */
public abstract class CombatTower extends Tower 
{
    private boolean rotate;

    /**
     * Constructor for objects of class CombatTower with a custom level
     * @param image a 2D array of sprite images
     * @param range the range of the tower
     * @param cooldown the cooldown of the tower
     * @param rotate is the tower able to rotate to face the enemy
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     * @param level the level of the tower
     */
    public CombatTower(GreenfootImage[][]image, float[]range, float[]cooldown, boolean rotate, int x, int y, int iX, int iY, int level){
        super(image, range, cooldown, x, y, iX, iY, level);
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
        setImage(image[level-1][degrees]);
    }
    
    /**
     * Update the CombatTower
     */
    public void _update(float delta){
        super._update(delta);
        //if the image can be rotated set the image to the 
        if(rotate) setRotation();
        //Assign the next enemy to target to enemy variable
        Enemy enemy = getNextEnemy();
        //if the tower is finished with its cooldown and there is an enemy to attack
        if(canAct() && enemy != null){
            //attack the enemy and reset the cooldown timer of the CombatTower
            attack(enemy);
            resetCooldown();
        }
    }
    
    /**
     * Get the next enemy targeted by this tower
     * @return Enemy the next enemy targeted by this tower, null if no enemies exist
     */
    protected Enemy getNextEnemy() {
        double maxNodeIndex = -1;
        Enemy next = null;
        for(Enemy e: Global.manager.getEnemies()){
            //get the straight-line distance between the tower and the enemy
            double dist = Math2D.distance(e.getX(), this.getX(), e.getY(), this.getY());
            //Get the nodeIndex of the enemy (larger number means further along the path)
            int nodeIndex = e.getNodeIndex();
            //if the enemy is within the tower's range and the enemy's is further along the path than the previous maximum
            if(dist < range[level-1] && nodeIndex > maxNodeIndex){
                //make it the targeted enemy
                maxNodeIndex = nodeIndex;
                next = e;
            }
        }
        //if the enemy exists, make the tower rotate to face the enemy
        this.rotation = next != null ? Math2D.angleTo(getX(), next.getX(), getY(), next.getY()) : this.rotation;
        //return the enemy to target
        return next;
    }
    
    /**
     * Attack enemies
     */
    protected abstract void attack(Enemy e);
}
