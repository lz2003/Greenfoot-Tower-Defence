import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TowerUpgrade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowerUpgrade extends TowerLabel
{
    public TowerUpgrade(int x, int y){
        super(x, y, "Upgrade Cost: ");
    }
    
    public void updateTower(Tower tower) {
        if(tower == null){
            setValue("Upgrade Cost: ");
        } else {
            String str = tower.getLevel() < Tower.MAX_LEVEL ? "" + (int)(tower.getCost() * UpgradeTowerButton.UPGRADE_MULTIPLYER + .5f) : "Tower Maxed";
            setValue("Upgrade Cost: "+ str);
        }
    }
}
