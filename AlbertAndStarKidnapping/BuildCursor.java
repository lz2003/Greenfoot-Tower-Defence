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
    private static int state = TowerButton.IDLE; 
    private static int idleX = 1000, idleY = -100;
    
    public static void init() {
        cursor = new BuildCursor();
    }
    
    public static void setState(int ID) {
        state = ID;
    }

    private BuildCursor() {
        Global.world.addObject(this, idleX, idleY);
        getImage().setTransparency(169);
    }

    boolean inWorld = false;
    public void act() {
        // Set location
        if(Global.getManager().mouseX() > Game.canvasWidth || Global.getManager().mouseX() < 0 ||
           Global.getManager().mouseY() > Game.canvasHeight || Global.getManager().mouseY() < 0) {
            setLocation(idleX, idleY);
            inWorld = false;
            return;
        }
        else if(Slot.getSelected() != null && state != TowerButton.IDLE) {
            double targetX =  Slot.getSelected().getX();
            double targetY =  Slot.getSelected().getY();
            
            double diffX = targetX - getX();
            double diffY = targetY - getY();
            
            diffX /= 3; diffY /= 3;
            
            setLocation(getX() + (int) diffX, getY() + (int) diffY);

            inWorld = true;
            setImage(TowerButton.icons[state]);
        } else {
            setLocation(idleX, idleY);
            inWorld = false;
            return;
        }
        
        // Build towers
        
        // Should also add validation for money tho to please the capitalists
        if(Greenfoot.mouseClicked(this) && inWorld) {
            if(!Slot.getSelected().setBlocked(true) || state == TowerButton.IDLE) {
                return;
            }
            setLocation((int)Slot.getSelected().getX(), (int)Slot.getSelected().getY());
            switch(state) {
                case TowerButton.ARCH:
                    if(validate(Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y)) {
                         new ArcherTower(getX(), getY(), Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y);
                    } else {
                        Slot.getSelected().setBlocked(false);
                    }
                    break;
                case TowerButton.ARTY:
                    if(validate(Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y)) {
                         new Artillery(getX(), getY(), Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y);
                    } else {
                        Slot.getSelected().setBlocked(false);
                    }
                    break;
                case TowerButton.BARA:
                    if(validate(Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y)) {
                         new Barracks(getX(), getY(), Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y);
                    } else {
                        Slot.getSelected().setBlocked(false);
                    }
                    break;
                case TowerButton.FIRE:
                    if(validate(Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y)) {
                         new FireballTower(getX(), getY(), Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y);
                    } else {
                        Slot.getSelected().setBlocked(false);
                    }
                    break;
                case TowerButton.ICE:
                    if(validate(Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y)) {
                         new IceballTower(getX(), getY(), Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y);
                    } else {
                        Slot.getSelected().setBlocked(false);
                    }
                    break;
                case TowerButton.LAZER:
                    if(validate(Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y)) {
                         new LazerTower(getX(), getY(), Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y);
                    } else {
                        Slot.getSelected().setBlocked(false);
                    }
                    break;
                case TowerButton.MINE:
                    if(validate(Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y)) {
                         new Mines(getX(), getY(), Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y);
                    } else {
                        Slot.getSelected().setBlocked(false);
                    }
                    break;
                case TowerButton.PILL:
                    if(validate(Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y)) {
                         new Pillbox(getX(), getY(), Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y);
                    } else {
                        Slot.getSelected().setBlocked(false);
                    }
                    break;
                case TowerButton.WALL:
                    if(validate(Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y)) {
                         new Wall(getX(), getY(), Slot.getSelected().getIndex().x, Slot.getSelected().getIndex().y);
                    } else {
                        Slot.getSelected().setBlocked(false);
                    }
                    break;
                default:
                    throw new Error("Invalid tower ID passed to BuildCursor");
            }
            setState(TowerButton.IDLE);
        }
    }
    
    // Checks if a tower is at the indicated index
    private boolean validate(int iX, int iY) {
        ArrayList<Tower> towers = Global.getManager().getTowers();
        
        for(int i = 0; i < towers.size(); i++) {
            if(towers.get(i).getIX() == iX && towers.get(i).getIY() == iY)
                return false; 
        }
        
        switch(state) {
            case TowerButton.ARCH:
                return Global.getManager().requestMoney(Tower.COST_ARCHER);
            case TowerButton.ARTY:
                return Global.getManager().requestMoney(Tower.COST_CANNON);
            case TowerButton.BARA:
                return Global.getManager().requestMoney(Tower.COST_BARRACKS);
            case TowerButton.FIRE:
                return Global.getManager().requestMoney(Tower.COST_FIREBALL);
            case TowerButton.ICE:
                return Global.getManager().requestMoney(Tower.COST_ICEBALL);
            case TowerButton.LAZER:
                return Global.getManager().requestMoney(Tower.COST_LASER);
            case TowerButton.MINE:
                return Global.getManager().requestMoney(Tower.COST_MINES);
            case TowerButton.PILL:
                return Global.getManager().requestMoney(Tower.COST_PILLBOX);
            case TowerButton.WALL:
                return true;
            default:
                return false;
        }
    }
}
