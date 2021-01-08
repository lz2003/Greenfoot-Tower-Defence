import greenfoot.*;
/**
 * Write a description of class Slot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Slot extends Sprite {
    private static final double
        ALPHA_IDLE = 64. / 255.,
        ALPHA_NEAR = 128. / 255.,
        ALPHA_ACTIVE = 192. / 255.;
        
    private Node node;
    private Index2D arrayLoc;
    private Actor sprite;

    public Slot(int x, int y, int iX, int iY, boolean isBlocked) {
        super(x, y, new GreenfootImage("jay.png"), Global.SLOT_SIZE, Global.SLOT_SIZE);// Global.SLOT_SIZE, Global.SLOT_SIZE);
        setLocation(x, y);
        this.arrayLoc = new Index2D(iX, iY);
        this.node = new Node(new Point((float) getX(), (float) getY()), arrayLoc, isBlocked);
        
        //this.sprite = new SlotSprite(this);
        //Global.world.addObject(sprite, x, y);
        Global.manager.addObject(this);
    }
    
    public boolean setBlocked(boolean blocked) {
        return Global.manager.updatePath(arrayLoc.x, arrayLoc.y, blocked);
    }
    
    public Actor getSprite() {
        return this.sprite;
    }
    
    public Point getLoc() {
        return new Point((float) getX(), (float) getY());
    }

    public Node getNode() {
        return this.node;
    }
    
    boolean selected = false;
    public void _update(float delta) {
        if(getNode().isBlocked()) {
            scale(0, 0);

            return;
        } else {
            setWidth(50);
            //getImage().scale(Global.SLOT_SIZE, Global.SLOT_SIZE);
        }    
        
        if(Global.manager.mouseDown()) {
            if(selected) {
                if(!Greenfoot.isKeyDown("q")) 
                    setBlocked(true);
                else
                    setBlocked(false);
            }
        }
        
        selected = false;
        int half = Global.SLOT_SIZE / 2;
        if(Global.manager.mouseX() > this.getX() - half && Global.manager.mouseX() < this.getX() + half) {
            if(Global.manager.mouseY() > this.getY() - half && Global.manager.mouseY() < this.getY() + half) {
                setTransparency(ALPHA_ACTIVE);
                //setWidth(10);
                selected = true;
            }
            else
                //setWidth(20);
                setTransparency(ALPHA_NEAR);
        } else if(Global.manager.mouseY() > this.getY() - half && Global.manager.mouseY() < this.getY() + half) {
            setTransparency(ALPHA_NEAR);
            //setWidth(20);
        }
        else {
            //setWidth(50);
            setTransparency(ALPHA_IDLE);
        } 
        
        if(getNode().isOnPath()) {
            //setWidth(30);
            setTransparency(255);
        }
    }
}
