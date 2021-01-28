import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TowerLabel here.
 * 
 * @author Ryan Lin
 * @version 2021
 */
public abstract class TowerLabel extends Label
{
    protected Tower tower;
    protected int x, y;

    /**
     * Constructor for TowerLabel
     * @param x The x coordinate of the tower label
     * @param y The y coordinate of the tower label
     * @param value The string displayed on the label
     */
    public TowerLabel(int x, int y, String value){
        super(value, 30);
        this.x = x;
        this.y = y;
    }  
    
    /**
     * Called when the TowerLabel is added to the world
     */
    public void addedToWorld(World w) {
        updateLoc();
    }
    
    /**
     * Link the TowerLabel to a tower
     * @param tower The tower to link to.
     */
    public void setTower(Tower tower){
        this.tower = tower;
        updateTower(this.tower);
        updateLoc();
    }
    
    /**
     * Updates the locaion of the TowerLabel based on its width
     */
    private void updateLoc() {
        int xLoc = x + getImage().getWidth() / 2;
        setLocation(xLoc, getY());
    }

    /**
     * Unlink the TowerLabel from a tower.
     * @param tower The tower to unlink from.
     */
    public void unlinkTower(Tower tower){
        if(this.tower == tower){
            this.tower = null;
        }
        updateTower(this.tower);
    }
    
    /**
     * Updates the label with information from a Tower.
     * @param The tower whose information is to be displayed.
     */
    public abstract void updateTower(Tower t);
}
