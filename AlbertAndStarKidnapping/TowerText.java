import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TowerText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowerText extends TowerLabel
{
    public TowerText(int x, int y){
        super(x, y, "[Select Tower]");
    }
    
    public void updateTower(Tower tower) {
        if(tower == null){
            setValue("[Select Tower]");
        } else {
            setValue(tower+"");
        }
    }
}
