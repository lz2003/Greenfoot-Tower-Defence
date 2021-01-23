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
        
    private static Slot selected;     
    private Node node;
    private Index2D arrayLoc;
    private static final GreenfootImage img = new GreenfootImage("blank.png");
    /**
     * Creates a default slot with jay jay default image
     */
    public Slot(int x, int y, int iX, int iY, boolean isBlocked){
        this(x, y, iX, iY, isBlocked, img);
    }
    
    /**
     * Creates a slot with custom image
     */
    public Slot(int x, int y, int iX, int iY, boolean isBlocked, GreenfootImage image) {
        super(x, y, image, Global.SLOT_SIZE, Global.SLOT_SIZE);// Global.SLOT_SIZE, Global.SLOT_SIZE);
        setLocation(x, y);
        this.arrayLoc = new Index2D(iX, iY);
        this.node = new Node(new Point((float) getX(), (float) getY()), arrayLoc, isBlocked);

        Global.manager.addObject(this);
    }
    
    /**
     * Sets whether or not this node should block the path
     * 
     * @return Whether or not the requested change is valid. (If it will make the path impossible)
     */
    public boolean setBlocked(boolean blocked) {
        return Global.manager.updatePath(arrayLoc.x, arrayLoc.y, blocked);
    }
    
    public Point getLoc() {
        return new Point((float) getX(), (float) getY());
    }

    public Node getNode() {
        return this.node;
    }
    
    public static Slot getSelected() {
        return selected;
    }
    
    public Index2D getIndex() {
        return arrayLoc;
    }
    
    public void _update(float delta) {
        int half = Global.SLOT_SIZE / 2;
        if(Global.manager.mouseX() > this.getX() - half && Global.manager.mouseX() < this.getX() + half) {
            if(Global.manager.mouseY() > this.getY() - half && Global.manager.mouseY() < this.getY() + half) {
                //setTransparency(ALPHA_ACTIVE);
                selected = this;
            }
        } 
        /*
        if(getNode().isBlocked()) {
            setTransparency(0);

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
        */
    }
}
