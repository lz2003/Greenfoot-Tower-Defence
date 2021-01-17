import greenfoot.*;
import java.util.*;
/**
 * Write a description of class BuildCursor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BuildCursor extends Actor
{
    private static BuildCursor cursor;
    private static int state;
    
    public static void init() {
        cursor = new BuildCursor();
    }
    
    public static void setState(int ID) {
        state = ID;
    }

    private BuildCursor() {
        Global.world.addObject(this, -50, -50);
        getImage().setTransparency(169);
    }

    boolean inWorld = false;
    public void act() {
        // Set location
        if(Global.getManager().mouseX() > Game.canvasWidth || Global.getManager().mouseX() < 0 ||
           Global.getManager().mouseY() > Game.canvasHeight || Global.getManager().mouseY() < 0) {
            setLocation(-100, -100);
            inWorld = false;
            return;
        }
        else if(Slot.getSelected() != null) {
            setLocation((int) Slot.getSelected().getX(), (int) Slot.getSelected().getY());
            inWorld = true;
            setImage(TowerButton.icons[state]);
        } else {
            setLocation(-100, -100);
            inWorld = false;
            return;
        }
        
        // Build towers
        
        // Should also add validation for money tho to please the capitalists
        if(Greenfoot.mouseClicked(this) && inWorld) {
            if(!Slot.getSelected().setBlocked(true)) {
                return;
            }
            switch(state) {
                case TowerButton.ARCH:
                    if(validate(Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y)) {
                         new ArcherTower(getX(), getY(), Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y);
                    }
                    break;
                case TowerButton.ARTY:
                    if(validate(Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y)) {
                         new Artillery(getX(), getY(), Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y);
                    }
                    break;
                case TowerButton.BARA:
                    if(validate(Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y)) {
                         new Barracks(getX(), getY(), Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y);
                    }
                    break;
                case TowerButton.FIRE:
                    if(validate(Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y)) {
                         new FireballTower(getX(), getY(), Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y);
                    }
                    break;
                case TowerButton.ICE:
                    if(validate(Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y)) {
                         new IceballTower(getX(), getY(), Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y);
                    }
                    break;
                case TowerButton.LAZER:
                    if(validate(Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y)) {
                         new LazerTower(getX(), getY(), Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y);
                    }
                    break;
                case TowerButton.MINE:
                    if(validate(Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y)) {
                         new Mines(getX(), getY(), Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y);
                    }
                    break;
                case TowerButton.PILL:
                    if(validate(Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y)) {
                         new Pillbox(getX(), getY(), Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y);
                    }
                    break;
                default:
                    throw new Error("Invalid tower ID passed to BuildCursor");
            }
        }
    }
    
    // Checks if a tower is at the indicated index
    private boolean validate(int iX, int iY) {
        ArrayList<Tower> towers = Global.getManager().getTowers();
        
        for(int i = 0; i < towers.size(); i++) {
            if(towers.get(i).getIX() == iX && towers.get(i).getIY() == iY)
                return false; 
        }
        
        return true;
    }
}
