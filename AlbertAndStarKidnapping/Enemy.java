import greenfoot.*;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Updated  {
    private float speed = 1;
    private Point loc;
    private int nodeIndex = 0;
    private Actor sprite;
    private boolean stuck, rerouted;
    private Node[] reroutedPath;
    
    public Enemy(int x, int y) {
        this.loc = new Point(x, y);
        sprite = new God();
        Global.world.addObject(sprite, x, y);
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

        Node nextNode;
        if(!rerouted) {
            nextNode = Global.manager.getPathNode(nodeIndex);
        } else {
            if(reroutedPath == null) return;
            if(nodeIndex >= reroutedPath.length) nodeIndex = 0;
            
            nextNode = reroutedPath[nodeIndex];
        }
        
        if(nextNode == null) return;
        
        Point next = nextNode.getWorldLoc();
            
        moveTowards(next.x, next.y);
        
        if(Math2D.distance(loc.x, next.x, loc.y, next.y) < speed + 5f) {
            nodeIndex++;
            
            if(rerouted) {
                if(nodeIndex >= reroutedPath.length) {
                    resetPath();
                }
            }
        }
    }
    
    public void setX(float x) {
        this.loc.x = x;
    }
    
    public void setY(float y) {
        this.loc.y = y;
    }
    
    public void translate(float x, float y) {
        this.setX(this.loc.x + x);
        this.setY(this.loc.y + y);
    }
    
    public void moveTowards(float x, float y) {
        float angle = Math2D.angleTo(loc.x, x, loc.y, y);
        
        float velX = speed * (float) Math.cos(angle);
        float velY = speed * (float) Math.sin(angle);
        
        translate(velX, velY);
    }
    
    public Actor getSprite() {
        return this.sprite;
    }
    
    public Point getLoc() {
        return this.loc;
    }
    
    private void resetPath() {
        Node[] path = Global.manager.getPath();
        
        float smallestDist = 999999999f;
        int index = 0;
        
        for(int i = 0; i < path.length; i++) {
            Node n = path[i];
            Point loc = n.getWorldLoc();
            
            float dist = Math2D.distanceSquared(loc.x, this.loc.x, loc.y, this.loc.y);
            if(dist < smallestDist) {
                smallestDist = dist;
                index = i;
            }
        }
        
        if(Math.sqrt(smallestDist) < Global.SLOT_SIZE) {
            this.nodeIndex = index + 1; // + 1 so it doesn't go back whenever the path changes
            this.rerouted = false;
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
