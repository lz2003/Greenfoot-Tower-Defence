import greenfoot.*;
/**
 * Pathfinding node location, as well as a location to place towers on
 *
 * @author Young Chen
 * @version 2021-01-26
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
     * Creates a slot
     * @param x x location
     * @param y y location
     * @param iX x index in array
     * @param iY y index in array
     * @param isBlocked whether or not its blocked
     */
    public Slot(int x, int y, int iX, int iY, boolean isBlocked){
        this(x, y, iX, iY, isBlocked, img);
    }

    /**
     * Creates a slot
     * @param x x location
     * @param y y location
     * @param iX x index in array
     * @param iY y index in array
     * @param isBlocked whether or not its blocked
     * @param image image of slot
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

    /**
     * Gets the slot's location
     * @return location
     */
    public Point getLoc() {
        return new Point((float) getX(), (float) getY());
    }

    /**
     * Gets the node on the slot
     * @return node
     */
    public Node getNode() {
        return this.node;
    }

    /**
     * Gets the currently selected slot
     * @return selected slot
     */
    public static Slot getSelected() {
        return selected;
    }

    /**
     * Gets the index in the array
     * @return index
     */
    public Index2D getIndex() {
        return arrayLoc;
    }

    /**
     * Sets selected slot
     * @param delta Change in time since last update
     */
    public void _update(float delta) {
        int half = Global.SLOT_SIZE / 2;
        if(Global.manager.mouseX() > this.getX() - half && Global.manager.mouseX() < this.getX() + half) {
            if(Global.manager.mouseY() > this.getY() - half && Global.manager.mouseY() < this.getY() + half) {
                //setTransparency(ALPHA_ACTIVE);
                selected = this;
            }
        } 
    }
}
