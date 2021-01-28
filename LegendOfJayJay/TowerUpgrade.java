import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays the upgrade cost of a tower.
 * 
 * @author Young Chen
 * @version 2021
 */
public class TowerUpgrade extends TowerLabel
{
    /**
     * Constructor for TowerUpgrade class.
     * @param x The x coordinate of the label.
     * @param y The y coordinate of the label.
     */
    public TowerUpgrade(int x, int y){
        super(x, y, "Upgrade Cost: ");
    }
    
    /**
     * Updates the label with information from a Tower.
     * @param tower The tower whose information is to be displayed.
     */
    public void updateTower(Tower tower) {
        if(tower == null){
            setValue("Upgrade Cost: ");
        } else {
            String str = tower.getLevel() < Tower.MAX_LEVEL ? "" + (int)(tower.getCost() * UpgradeTowerButton.UPGRADE_MULTIPLYER + .5f) : "Tower Maxed";
            setValue("Upgrade Cost: "+ str);
        }
    }
}
