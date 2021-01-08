import greenfoot.*;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Sprite  {
    private float speed = 1;
    private int nodeIndex = 0;
    private boolean stuck, rerouted;
    private Node[] reroutedPath;
    
    public Enemy(double x, double y, GreenfootImage image) {
        super(x, y, image, 100, 100, 1);
        setLocation(x, y);
    }
    
    public void _update(float delta) {
        movement(delta);
    }
    
    public void _receiveBroadcast(int id) {
        if(id == ObjectManager.BROADCAST_REBUILD) {
            resetPath();
        }
    }
    
    private void movement(float delta) {
        if(stuck) return;
        if(isRemoved()) return;


        Node nextNode;
        //if(!rerouted) {
        nextNode = Global.manager.getPathNode(nodeIndex);
        //} else {
        //    if(reroutedPath == null) return;
        //    if(nodeIndex >= reroutedPath.length) nodeIndex = 0;
            
        //    nextNode = reroutedPath[nodeIndex];
        //}
        
        if(nextNode == null) {
            removeSprite();
            return;
        }
        Point next = nextNode.getWorldLoc();
            
        moveTowards(next.x, next.y);
        
        if(Math2D.distance(getX(), next.x, getY(), next.y) < speed + 5f) {
            nodeIndex++;
            
            //if(rerouted) {
            //    if(nodeIndex >= reroutedPath.length) {
            //        resetPath();
            //    }
            //}
        }
    }
    
    public void translate(double x, double y) {
        setLocation(getX() + x, getY() + y);
    }
    
    public void moveTowards(double x, double y) {
        double angle = Math2D.angleTo(getX(), x, getY(), y);
        
        double velX = speed *  Math.cos(angle);
        double velY = speed * Math.sin(angle);
        
        translate(velX, velY);
    }
    
    private void resetPath() {
        Node[] path = Global.manager.getPath();
        
        float smallestDist = 999999999f;
        int index = 0;

        for(int i = 0; i < path.length; i++) {
            Node n = path[i];
            Point loc = n.getWorldLoc();

            float dist = Math2D.distanceSquared(loc.x, (float) getX(), loc.y, (float) getY());
            if(dist < smallestDist) {
                smallestDist = dist;
                index = i;

            }

        }

        if(Math.sqrt(smallestDist) < Global.SLOT_SIZE) {
            this.nodeIndex = index + 1; // + 1 so it doesn't go back whenever the path changes
            //this.rerouted = false;
        } else {
            this.nodeIndex = index;
        }
        // Replace below with above to allow enemies to get stuck and to prevent them from
        // passing through walls by forcing the enemies to find a path towards the
        // nearest node on the main path
        
        // Has high performance costs (frame drops at around 10 - 15 enemies)
        /*
        else {
            Node closest = Global.getManager().getClosestNode(this.loc);

            if(closest == null) {
                this.stuck = true;
                return;
            }
            
            rerouted = true;
            
            PathfindingSimplified pathfinder = 
            new PathfindingSimplified(Global.getManager().getNodes(), closest, path[index]);
            reroutedPath = pathfinder.getPath();
            nodeIndex = 0;
        }
        */
        this.stuck = false;
    }
}
