import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button that performs an action on a tower.
 * 
 * @author Ryan Lin
 * @version 2021
 */
public abstract class TowerActionButton extends ImageButton
{
    protected Tower tower;
    
    /**
     * Creates a TowerActionButton
     * @param image The image of the button.
     */
    public TowerActionButton(GreenfootImage image)
    {
        super(image);
    }
    
    /**
     * Make the button track a tower
     * @param tower the tower to be tracked
     */
    public void setTower(Tower tower)
    {
        this.tower = tower;
    }
    
    /**
     * Stop the button from tracking a tower
     * @param tower the tower to stop tracking.
     */
    public void unlinkTower(Tower tower)
    {
        if(this.tower == tower) this.tower = null;
    }   
    
    /**
     * Check for clicks.
     */
    public void act()
    {
        //If the button is linked to a tower and it is clicked upon
        if(tower != null && Greenfoot.mouseClicked(this)){
            //act on the mouse click
            onPress();
        }
    }
}
