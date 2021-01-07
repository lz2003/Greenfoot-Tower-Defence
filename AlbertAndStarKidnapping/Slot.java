import greenfoot.*;
/**
 * Write a description of class Slot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Slot extends Updated {
    private Point loc;
    private Node node;
    private Index2D arrayLoc;
    private Actor sprite;

    public Slot(int x, int y, int iX, int iY, boolean isBlocked) {
        this.loc = new Point(x, y);
        this.arrayLoc = new Index2D(iX, iY);
        this.node = new Node(this.loc, arrayLoc, isBlocked);
        
        this.sprite = new SlotSprite(this);
        Global.world.addObject(sprite, x, y);
        Global.manager.addObject(this);
    }
    
    public boolean setBlocked(boolean blocked) {
        return Global.manager.updatePath(arrayLoc.x, arrayLoc.y, blocked);
    }
    
    public Actor getSprite() {
        return this.sprite;
    }
    
    public Point getLoc() {
        return this.loc;
    }

    public Node getNode() {
        return this.node;
    }
}
