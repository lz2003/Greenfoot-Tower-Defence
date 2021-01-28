import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A widget that displays information about a Tower.
 * 
 * @author Ryan Lin
 * @version 2021
 */
public class TowerDisplay extends Actor
{
    private TowerLevel towerLevel;
    private TowerText towerText;
    private TowerUpgrade towerUpgrade;
    private RemoveTowerButton removeTowerButton;
    private UpgradeTowerButton upgradeTowerButton;
    private Bar range;
    private Bar cooldown;
    private Label rangeLabel;
    private Label cooldownLabel;
    private Label defaultLabel;
    private Label upgradeLabel;
    
    /**
     * Creates a TowerDisplay
     */
    public TowerDisplay()
    {
        GreenfootImage image = new GreenfootImage(400, 100);
        setImage(image);
    }
    
    /**
     * Initialize widgets
     */
    public void addedToWorld(World world)
    {
        towerText = new TowerText(getX()-200, getY()-40);
        towerLevel = new TowerLevel(getX()-200, getY()-13);
        towerUpgrade = new TowerUpgrade(getX() - 200, getY() + 60);
        removeTowerButton = new RemoveTowerButton();
        upgradeTowerButton = new UpgradeTowerButton();
        range = new Bar(150, 20, 0, 400, Color.GREEN, Color.WHITE, true);
        cooldown = new Bar(150, 20, 0, 4000, Color.ORANGE, Color.WHITE, true);
        rangeLabel = new Label("Range: ", 20);
        cooldownLabel = new Label("Cooldown: ", 20);
        defaultLabel = new Label("Tower stats", 40);
        world.addObject(defaultLabel, getX() + 20, getY());
    }
    
    /**
     * Hides the TowerDisplay for a tower
     * @param tower the tower to be hidden
     */
    public void hide(Tower tower)
    {
        World world = getWorld();
        //add placeholder text
        world.addObject(defaultLabel, getX(), getY());
        //remove buttons and labels from the world
        world.removeObject(towerText);
        world.removeObject(towerLevel);
        world.removeObject(removeTowerButton);
        world.removeObject(upgradeTowerButton);
        world.removeObject(range);
        world.removeObject(cooldown);
        world.removeObject(rangeLabel);
        world.removeObject(cooldownLabel);
        //unlink the buttons and labels from the current tower
        towerText.unlinkTower(tower);
        towerLevel.unlinkTower(tower);
        towerUpgrade.unlinkTower(tower);
        removeTowerButton.unlinkTower(tower);
        upgradeTowerButton.unlinkTower(tower);
    }
    
    /**
     * Shows the TowerDisplay for a tower
     * @param tower the tower to be shown
     */
    public void show(Tower tower)
    {
        World world = getWorld();
        //remove placeholder text
        world.removeObject(defaultLabel);
        //Add buttons and labels back into the world
        world.addObject(towerText, getX()-200, getY()-40);
        world.addObject(towerLevel, getX()-200, getY()-13);
        world.addObject(towerUpgrade, getX()-200, getY() + 60);
        world.addObject(removeTowerButton, getX()-160, getY()+20);
        world.addObject(upgradeTowerButton, getX()-80, getY()+20);
        world.addObject(rangeLabel, getX()+ 38, getY()-30);
        world.addObject(range, getX() + 150, getY()-30);
        world.addObject(cooldownLabel, getX()+20, getY());
        world.addObject(cooldown, getX() + 150, getY());
        //Link all of the buttons and text to the selected tower
        towerText.setTower(tower);
        towerLevel.setTower(tower);
        towerUpgrade.setTower(tower);
        removeTowerButton.setTower(tower);
        upgradeTowerButton.setTower(tower);
        //Set values for the range and cooldown bars
        range.setValue((int)tower.getRange());
        cooldown.setValue((int)tower.getCooldown());
    }
    
    /**
     * Update the tower
     */
    public void update(Tower tower)
    {
        //Update name, level label, and mask
        towerText.updateTower(tower);
        towerLevel.updateTower(tower);
        Global.world.updateMask(tower);
        //update the tower's range and cooldown bar with new values
        range.setValue((int)tower.getRange());
        cooldown.setValue((int)tower.getCooldown());
    }   
}
