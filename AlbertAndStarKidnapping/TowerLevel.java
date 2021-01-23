import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TowerLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowerLevel extends TowerLabel
{
    public TowerLevel(int x, int y){
        super(x, y, "Level: ");
    }
    public void act() 
    {
        super.act();
        if(tower == null){
            setValue("Level: ");
        } else {
            setValue("Level: "+tower.getLevel());
        }
    }    
}
