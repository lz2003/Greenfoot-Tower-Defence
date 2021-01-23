import greenfoot.*;
/**
 * Shoots fireballs at enemies.
 * 
 * @author Ryan Lin
 * @version (a version number or a date)
 */
public class FireballTower extends CombatTower 
{
    private static GreenfootImage[] sprite1 = {
        new GreenfootImage("images/tower/Fire/L1/0001.png"),
        new GreenfootImage("images/tower/Fire/L1/0002.png"),
        new GreenfootImage("images/tower/Fire/L1/0003.png"),
        new GreenfootImage("images/tower/Fire/L1/0004.png"),
        new GreenfootImage("images/tower/Fire/L1/0005.png"),
        new GreenfootImage("images/tower/Fire/L1/0006.png"),
        new GreenfootImage("images/tower/Fire/L1/0007.png"),
        new GreenfootImage("images/tower/Fire/L1/0008.png")
    };
    
    private static GreenfootImage[] sprite2 = {
        new GreenfootImage("images/tower/Fire/L2/0001.png"),
        new GreenfootImage("images/tower/Fire/L2/0002.png"),
        new GreenfootImage("images/tower/Fire/L2/0003.png"),
        new GreenfootImage("images/tower/Fire/L2/0004.png"),
        new GreenfootImage("images/tower/Fire/L2/0005.png"),
        new GreenfootImage("images/tower/Fire/L2/0006.png"),
        new GreenfootImage("images/tower/Fire/L2/0007.png"),
        new GreenfootImage("images/tower/Fire/L2/0008.png")
    };
    
    private static GreenfootImage[] sprite3 = {
        new GreenfootImage("images/tower/Fire/L3/0001.png"),
        new GreenfootImage("images/tower/Fire/L3/0002.png"),
        new GreenfootImage("images/tower/Fire/L3/0003.png"),
        new GreenfootImage("images/tower/Fire/L3/0004.png"),
        new GreenfootImage("images/tower/Fire/L3/0005.png"),
        new GreenfootImage("images/tower/Fire/L3/0006.png"),
        new GreenfootImage("images/tower/Fire/L3/0007.png"),
        new GreenfootImage("images/tower/Fire/L3/0008.png")
    };
    
    public void _update(float delta) {
        super._update(delta);
        setRotation();
    }
    
    private void setRotation() {
        int degrees = (int) Math.toDegrees(this.rotation);
        degrees += 720;
        degrees = degrees % 360;
        degrees += 22; // 45 / 2
        degrees = degrees / 45;
        degrees = degrees % 8;
        switch(getLevel()) {
            case 1:
                setImage(sprite1[degrees]);
                break;
            case 2:
                setImage(sprite2[degrees]);
                break;
            case 3:
                setImage(sprite3[degrees]);
                break;
        }
    }
    /**
     * Creates a tower that shoots fireballs at enemies.
     * @param x the x coordinate of the tower
     * @param y the y coordinate of the tower
     * @param iX the x index of the tower in the global grid
     * @param iY the y index of the tower in the global grid
     */
    public FireballTower(int x, int y, int iX, int iY)
    {
        super(x, y, iX, iY, 1, 200, 3000, new GreenfootImage[]{
            sprite1[0]});
            
        setDimensions(50, 120);
        setY(getY() - 25);     
            
    }

    /**
     * Attack enemies
     */
    protected void attack(Enemy e) {
        //fire fireball
        new Fireball(getX(), getY(), e, level);
    }
}
