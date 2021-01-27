import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button that upgrades a tower.
 * 
 * @author Ryan Lin
 * @version 2021
 */
public class UpgradeTowerButton extends TowerActionButton
{
    public static final float UPGRADE_MULTIPLYER = 1.3f;
    
    /**
     * Constructor for UpgradeTowerButton class.
     */
    public UpgradeTowerButton()
    {
        super(new GreenfootImage("images/buttons/upgrade/upgradeUnpressed.png"));
    }

    /**
     * Action when the button is clicked.
     */
    public void onPress() 
    {
        super.onPress();
        //Do not consider levelling up if the tower is already at the maximum level
        if(tower.getLevel() >= Tower.MAX_LEVEL) return;
        //Get the cost of the tower
        float cost = tower.getCost();
        //Calculate the upgrade cost of the tower
        float costAdjusted = cost * UPGRADE_MULTIPLYER;
        //If the player has enough money, take out the money and level up the tower
        if(Global.getManager().requestMoney(costAdjusted)){
            tower.levelup();
            Global.world.towerDisplay.update(tower);
        }
    }    
}
