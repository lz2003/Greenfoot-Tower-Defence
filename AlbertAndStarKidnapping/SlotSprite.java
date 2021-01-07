import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Debug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SlotSprite extends Actor
{
    private static final int
        ALPHA_IDLE = 64,
        ALPHA_NEAR = 128,
        ALPHA_ACTIVE = 192;
    
    private Slot parent;
    
    private boolean selected;
    
    
    public SlotSprite(Slot p) {
        getImage().scale(Global.SLOT_SIZE, Global.SLOT_SIZE);
        this.parent = p;
    }

    public void act() {
        if(parent.getNode().isBlocked()) {
            getImage().scale(1, 1);
        } else {
            getImage().scale(Global.SLOT_SIZE, Global.SLOT_SIZE);
        }    
        
        if(Global.manager.mouseDown()) {
            if(selected) {
                if(!Greenfoot.isKeyDown("q")) 
                    parent.setBlocked(true);
                else
                    parent.setBlocked(false);
            }
        }
        
        selected = false;
        int half = Global.SLOT_SIZE / 2;
        if(Global.manager.mouseX() > this.getX() - half && Global.manager.mouseX() < this.getX() + half) {
            if(Global.manager.mouseY() > this.getY() - half && Global.manager.mouseY() < this.getY() + half) {
                getImage().setTransparency(ALPHA_ACTIVE);
                selected = true;
            }
            else
                getImage().setTransparency(ALPHA_NEAR);
        } else if(Global.manager.mouseY() > this.getY() - half && Global.manager.mouseY() < this.getY() + half) {
            getImage().setTransparency(ALPHA_NEAR);
        }
        else {
            getImage().setTransparency(ALPHA_IDLE);
        }
        
        if(this.parent.getNode().isOnPath()) {
            getImage().setTransparency(255);
        }
    }
}
