import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TowerLabel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowerLabel extends Label
{
    protected Tower tower;
    protected int x, y;
    public TowerLabel(int x, int y, String value){
        super(value, 30);
        this.x = x;
        this.y = y;
    }  
    
    public void setTower(Tower tower){
        this.tower = tower;
    }
    
    private void updateLoc() {
        int xLoc = x + getImage().getWidth() / 2;
        setLocation(xLoc, getY());
    }
    
    public void act(){
        updateLoc();
    }
    
    public void unlinkTower(Tower tower){
        if(this.tower == tower){
            this.tower = null;
        }
    }
}
