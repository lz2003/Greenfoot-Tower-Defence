import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * A mask used to display the radius around a tower.
 * 
 * @author Ryan Lin
 * @version (a version number or a date)
 */
public class CircleMask extends Sprite
{
    private static final String visiblePath = "images/newcircle32.png";
    private static final String hiddenPath = "images/transparent.png";
    private GreenfootImage hiddenImage;
    private Tower last = null;
    
    /**
     * Creates a Circular Mask
     * @param x The x-coordinate of the tower
     * @param y The y-coordinate of the tower
     * @param radius The radius of the tower
     */
    public CircleMask()
    {
        super(0,0, new GreenfootImage(hiddenPath), 200, 200, 10);
        hiddenImage = new GreenfootImage(hiddenPath);
        Global.getManager().addObject(this);
    }
    
    /**
     * Update the Circular Mask
     * @param delta The time, in seconds, that elapsed since the last update
     */
    public void _update(float delta){
        super._update(delta);
        //update cumulative elapsed time
        Slot selectedSlot = Slot.getSelected();
        
        // Check if the mouse is clicked and mouse is within world (so it doesn't select another tower when upgrading or deleting)
        if(Greenfoot.mouseClicked(null) && selectedSlot != null && 
           !(Global.getManager().mouseX() > Game.canvasWidth || Global.getManager().mouseX() < 0 ||
           Global.getManager().mouseY() > Game.canvasHeight || Global.getManager().mouseY() < 0)
        ){
            //Get x index and y index of the slot that the mouse is covering
            int ix = selectedSlot.getIndex().x;
            int iy = selectedSlot.getIndex().y;
            //Get the list of towers in the world
            ArrayList<Tower>towers = Global.getManager().getTowers();
            //Iterate through towers to find the tower at the x and y index
            Tower selected = null;
            for(Tower t: towers){
                if(t.getIX() == ix && t.getIY() == iy){
                    selected = t;
                }
            }
            //change the location
            if(selected == null){
                if(isVisible() && Greenfoot.getMouseInfo().getX() <= Global.world.canvasWidth && Greenfoot.getMouseInfo().getY() <= Global.world.canvasHeight) hide();
            } else {
                if(isVisible() && selected == last){
                    hide();
                } else {
                    show(selected);
                }
            }
        }
    }
    
    /**
     * Make the Circular Mask Disappear
     */
    public void hide(){
        Global.world.towerDisplay.hide(last);
        last = null;
        setImage(hiddenImage);
    }
    
    /**
     * Make the Circular Mask appear for a tower
     * @param selected The tower whose range is to be displayed
     */
    public void show(Tower selected){
        last = selected;
        GreenfootImage visibleImage = new GreenfootImage(visiblePath);
        visibleImage.scale(Math.max((int)(2*selected.getRange()), 1), Math.max((int)(int)(2*selected.getRange()), 1));
        setImage(visibleImage,false);
        setLocation(selected.getX(), selected.getY());
        Global.world.towerDisplay.show(selected);
    }
    
    /**
     * Checks if the mask is visible
     * @return visible True if the mask is visible, otherwise False
     */
    public boolean isVisible(){
        return last != null;
    }
}
