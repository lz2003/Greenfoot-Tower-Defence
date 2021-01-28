import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays the name of the Tower.
 * 
 * @author Ryan Lin
 * @version 2021
 */
public class TowerText extends TowerLabel
{
    /**
     * Constructor for TowerText class.
     * @param x The x coordinate of the label.
     * @param y The y coordinate of the label.
     */
    public TowerText(int x, int y){
        super(x, y, "[Select Tower]");
    }
    
    /**
     * Updates the label with information from a Tower.
     * @param tower The tower whose information is to be displayed.
     */
    public void updateTower(Tower tower) {
        if(tower == null){
            setValue("[Select Tower]");
        } else {
            setValue(tower+"");
        }
    }
}
