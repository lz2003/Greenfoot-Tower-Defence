import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button that removes the linked tower.
 * 
 * @author Ryan Lin
 * @version 2021
 */
public class RemoveTowerButton extends TowerActionButton
{
    /**
     * Constructor for RemoveTowerButton class.
     */
    public RemoveTowerButton()
    {
        super(new GreenfootImage("images/buttons/delete/deleteUnpressed.png"));
    }
    
    /**
     * Action when the button is pressed.
     */
    public void onPress(){
        if(tower instanceof Wall && !Global.getWorld().isEditor()) return;
        //Get the tower's location in the grid
        int x = tower.getIX();
        int y = tower.getIY();
        //Update the path when the tower is destroyed
        Global.getManager().updatePath(x, y, false);
        //Destroy the tower
        tower.destroy();
        //Hide the mask
        Global.getWorld().mask.hide();
    }
}
