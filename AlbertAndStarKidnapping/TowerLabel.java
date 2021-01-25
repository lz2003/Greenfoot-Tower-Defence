import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TowerLabel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class TowerLabel extends Label
{
    protected Tower tower;
    protected int x, y;

    public TowerLabel(int x, int y, String value){
        super(value, 30);
        this.x = x;
        this.y = y;
    }  
    
    public void addedToWorld(World w) {
        updateLoc();
    }
    
    public void setTower(Tower tower){
        this.tower = tower;
        updateTower(this.tower);
        updateLoc();
    }
    
    private void updateLoc() {
        int xLoc = x + getImage().getWidth() / 2;
        setLocation(xLoc, getY());
    }

    public void unlinkTower(Tower tower){
        if(this.tower == tower){
            this.tower = null;
        }
        updateTower(this.tower);
        //updateLoc();
    }
    
    public abstract void updateTower(Tower t);
}
