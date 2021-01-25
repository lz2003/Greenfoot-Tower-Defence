import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TowerRemove here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowerRemove extends TowerLabel
{
    public TowerRemove(int x, int y){
        super(x, y, "Remove Tower");
    }
    
    /**
     * Act - do whatever the TowerRemove wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            //remove tower
            
        }
    }    
    
    public void updateTower(Tower t) {}
}
