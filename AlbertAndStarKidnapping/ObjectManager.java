import java.util.ArrayList;
import greenfoot.*;
/**
 * Write a description of class ObjectManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ObjectManager  
{
    public static final int 
        BROADCAST_REBUILD = 0;
        
    private static final float 
        CAM_SPEED = 3f;
        
    public static final int 
        STATE_BUILD = 0;    
        
    //private float camX = 0, camY = 0;
    private int state = 0;
    
    private int maxNodesX, maxNodesY;
    private Node[][] nodes;
    private Slot[][] slots;
    private Node targetNode, startNode;
    
    private Node[] path;
    private PathfindingSimplified pathfinder;
    
    private ArrayList<Updated> objects = new ArrayList<Updated>();
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    
    private Mouse mouse;

    /**
     * Constructor for objects of class ObjectManager
     */
    public ObjectManager() {
        mouse = new Mouse();
    }
    
    public void update() {
        mouse.update();
        updateLoop();
        updateSpriteLocs();
        updateCam();
    }
    
    private void updateCam() {/*
        if(Greenfoot.isKeyDown("w")) {
            camY += CAM_SPEED;
        }
        if(Greenfoot.isKeyDown("a")) {
            camX += CAM_SPEED;
        }
        if(Greenfoot.isKeyDown("s")) {
            camY -= CAM_SPEED;
        }
        if(Greenfoot.isKeyDown("d")) {
            camX -= CAM_SPEED;
        }
        int width = Global.world.getWidth();
        int height = Global.world.getHeight();
        // Clamp camera to within space with background
        camX = camX < -width ? -width : camX > width ? width : camX;
        camY = camY < -width ? -width : camY > width ? width : camY;*/
    }
    
    private void updateLoop() {
        for(Updated o: objects) {
            o._update(1f);
        }
        
        for(Enemy o: enemies) {
            o._update(1f);
        }
        
    }
    
    private void updateSpriteLocs() {
        for(Updated o: objects) {
            updateSpriteLoc(o);
        }
        
        for(Updated o: enemies) {
            updateSpriteLoc(o);
        }
    }
    
    private void updateSpriteLoc(Updated o) {

    }
    
    public void broadcast(int ID) {
        for(Updated o: objects) {
            o._receiveBroadcast(ID);
        }
        
        for(Updated o: enemies) {
            o._receiveBroadcast(ID);
        }
    }
    
    public void addEnemy(int x, int y, int ID) {
        Enemy e = new Enemy(x, y, new GreenfootImage("god.png"));
        
        enemies.add(e);
    }
    
    public void addObject(Updated u) {
        this.objects.add(u);
    }

    public void init() {
        int widthIndex = 0, heightIndex = 0;
        for(int x = 0; x < Global.getWorld().getWidth(); x += Global.SLOT_SIZE) {
            widthIndex++;
        }
        
        for(int y = 0; y < Global.getWorld().getHeight(); y += Global.SLOT_SIZE) {
            heightIndex++;
        }
            
        nodes = new Node[widthIndex][heightIndex];
        slots = new Slot[widthIndex][heightIndex];
        
        this.maxNodesX = widthIndex;
        this.maxNodesY = heightIndex;
            
        for(int x = 0, index_x = 0; x < Global.getWorld().getWidth(); x += Global.SLOT_SIZE, index_x++) {
            for(int y = 0, index_y = 0; y < Global.getWorld().getHeight(); y += Global.SLOT_SIZE, index_y++) {
                Slot s = new Slot(x + Global.SLOT_SIZE / 2, y  + Global.SLOT_SIZE / 2, index_x, index_y, false);
                nodes[index_x][index_y] = s.getNode();
                slots[index_x][index_y] = s;
            }
        }

        this.targetNode = nodes[15][12];
        this.startNode = nodes[0][0];
        
        pathfinder = new PathfindingSimplified(nodes, this.startNode, this.targetNode);
        path = pathfinder.getPath();
        
        for(int i = 0; i < 1; i++)
            addEnemy(20, 20 + i * 5, 2);
    }
    
    public Node getClosestNode(Point loc) {
        int x = (int) (loc.x + .5f);
        int y = (int) (loc.y + .5f);
        
        x /= Global.SLOT_SIZE;
        y /= Global.SLOT_SIZE;
        
        x = Math2D.clamp(x, 0, this.maxNodesX);
        y = Math2D.clamp(y, 0, this.maxNodesY);
        
        /*
        float lowestDist = 999999;
        Node closest = null;
        
        for(int xx =  Math.max(x - 1, 0); xx < Math.min(xx + 2, this.maxNodesX); xx++) {
            for(int yy = Math.max(y - 1, 0); yy < Math.min(yy + 2, this.maxNodesY); yy++) {
                if(nodes[xx][yy].isBlocked()) continue;
                
                Point nodeLoc = nodes[xx][yy].getWorldLoc();
                float dist = Math2D.distanceSquared(loc.x, nodeLoc.x, loc.y, nodeLoc.y);
                if(dist < lowestDist) {
                    lowestDist = dist;
                    closest = nodes[xx][yy];
                }
            }
        }
        */
       
        return nodes[x][y];
    }
    
    public boolean rebuildPath() {
        // Try to find a path
        pathfinder = new PathfindingSimplified(nodes, nodes[0][0], nodes[15][12]);
        Node[] path = pathfinder.getPath();
        
        // If no path found, dont set enemy path to new path
        if(path == null) return false;
        
        this.path = path;
        broadcast(BROADCAST_REBUILD);
        return true;
    }
    
    public boolean updatePath(int x, int y, boolean blocked) {
        boolean original = nodes[x][y].isBlocked();
        
        nodes[x][y].setBlocked(blocked);
        
        boolean valid = rebuildPath();
        
        if(!valid) {
            nodes[x][y].setBlocked(original);
        }
        
        return valid;
    }
    
    public Node[] getPath() {
        return this.path;
    }
    
    public Node getPathNode(int index) {
        try {
            return this.path[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }
    
    public Node[][] getNodes() {
        return this.nodes;
    }
    
    public Node getTargetNode() {
        return this.targetNode;
    }
    
    public int mouseX() {
        return mouse.getMouseX();
    }
    
    public int mouseY() {
        return mouse.getMouseY();
    }
    
    public boolean mouseDown() {
        return mouse.isDown();
    }
    
    public int getState() {
        return this.state;
    }
}
