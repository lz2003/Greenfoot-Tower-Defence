import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TowerDisplay here.
 * 
 * @author Ryan Lin
 * @version (Version)
 */
public class TowerDisplay extends Actor
{
    private Tower tower;
    private TowerLevel towerLevel;
    private TowerText towerText;
    private RemoveTowerButton removeTowerButton;
    private UpgradeTowerButton upgradeTowerButton;
    private Bar range;
    private Bar cooldown;
    private Label rangeLabel;
    private Label cooldownLabel;
    private Label defaultLabel;
    
    /**
     * Creates a TowerDisplay
     */
    public TowerDisplay()
    {
        GreenfootImage image = new GreenfootImage(400, 100);
        image.setColor(new Color(3, 248, 252));
        image.fill();
        setImage(image);
    }
    
    /**
     * Initialize widgets
     */
    public void addedToWorld(World world)
    {
        towerText = new TowerText(getX()-200, getY()-40);
        towerLevel = new TowerLevel(getX()-200, getY()-20);
        removeTowerButton = new RemoveTowerButton();
        upgradeTowerButton = new UpgradeTowerButton();
        range = new Bar(150, 20, 0, 400, Color.GREEN, Color.WHITE, true);
        cooldown = new Bar(150, 20, 0, 1000, Color.GREEN, Color.WHITE, true);
        rangeLabel = new Label("Range: ", 20);
        cooldownLabel = new Label("Cooldown: ", 20);
        defaultLabel = new Label("Click on a tower to show stats", 30);
        world.addObject(defaultLabel, getX(), getY());
    }
    
    /**
     * Hides the TowerDisplay for a tower
     * @param tower the tower to be hidden
     */
    public void hide(Tower tower)
    {
        World world = getWorld();
        world.addObject(defaultLabel, getX(), getY());
        world.removeObject(towerText);
        world.removeObject(towerLevel);
        world.removeObject(removeTowerButton);
        world.removeObject(upgradeTowerButton);
        world.removeObject(range);
        world.removeObject(cooldown);
        world.removeObject(rangeLabel);
        world.removeObject(cooldownLabel);
        if(this.tower == tower)tower = null;
        towerText.unlinkTower(tower);
        towerLevel.unlinkTower(tower);
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
        world.removeObject(defaultLabel);
        world.addObject(towerText, getX()-200, getY()-40);
        world.addObject(towerLevel, getX()-200, getY()-20);
        world.addObject(removeTowerButton, getX()-160, getY()+20);
        world.addObject(upgradeTowerButton, getX()-80, getY()+20);
        world.addObject(rangeLabel, getX()+10, getY()-30);
        world.addObject(range, getX() + 120, getY()-30);
        world.addObject(cooldownLabel, getX()+10, getY());
        world.addObject(cooldown, getX() + 120, getY());
        this.tower = tower;
        towerText.setTower(tower);
        towerLevel.setTower(tower);
        removeTowerButton.setTower(tower);
        upgradeTowerButton.setTower(tower);
        range.setValue((int)tower.getRange());
        cooldown.setValue((int)tower.getCooldown());
    }
    
    /**
     * Update the tower
     */
    public void update()
    {
        towerText.updateTower(tower);
        towerLevel.updateTower(tower);
        Global.world.updateMask(tower);
        range.setValue((int)tower.getRange());
        cooldown.setValue((int)tower.getCooldown());
    }
    
    public void act() 
    {
        if(tower!=null && Greenfoot.mouseClicked(upgradeTowerButton)){
            upgradeTowerButton.onclick();
            update();
        }
    }    
}
