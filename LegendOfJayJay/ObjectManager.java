import java.util.ArrayList;
import java.awt.Color;
import greenfoot.*;
/**
 * Class to manage all the game objects and pathfinding
 * 
 * @author Lucy Zhao
 * @author Rachel Tong
 * @author Ryan Lin
 * @author Young Chen
 * @version 2021-01-26
 */
public class ObjectManager  
{
    public static final int 
        BROADCAST_END = -1,
        BROADCAST_REBUILD = 0;
        
    private static final float 
        CAM_SPEED = 3f;
        
    public static final int 
        STATE_BUILD = 0,
        STATE_IDLE = 1,
        STATE_MENU = 2;    

    private int state = 0;
    
    private int maxNodesX, maxNodesY;
    private Node[][] nodes;
    private Slot[][] slots;
    private Node targetNode, startNode;
    
    private Node[] path;
    private PathfindingSimplified pathfinder;
    
    private ArrayList<Updated> objects = new ArrayList<Updated>();
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private ArrayList<Tower> towers = new ArrayList<Tower>();
    private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
    private ArrayList<Minion> minions = new ArrayList<Minion>();
    
    private JayJay jay;
    
    private Mouse mouse;
    
    private Spawner spawner;
    
    public static final int 
        targetIndexX = 15, targetIndexY = 6,
        startIndexX = 0, startIndexY = 5,
        startPosX = startIndexX * Global.SLOT_SIZE + Global.SLOT_SIZE / 2, startPosY = startIndexY * Global.SLOT_SIZE + Global.SLOT_SIZE / 2;
        
    private double
        targetX = 775, targetY = 325;
        
    public static final float START_MONEY = 1000;    
    private float money = START_MONEY;

    /**
     * Instantiates the object manager
     */
    public ObjectManager() {
        mouse = new Mouse();
        spawner = new Spawner(this);
        jay = new JayJay(targetX, targetY);
    }

    /**
     * Instantiates the object manager
     * @param editor Whether or not to make the object manager assume the world is a map editor
     */
    public ObjectManager(boolean editor) {
        mouse = new Mouse();
        
        if(!editor)
            spawner = new Spawner(this);
        else {
            spawner = new DummySpawner(this);
            money = 1000000;
        }
        jay = new JayJay(targetX, targetY);
    }

    /**
     * Clears all the objects being managed
     */
    public void reset() {
        if(!Global.getWorld().isEditor())
            spawner = new Spawner(this);
        else {
            spawner = new DummySpawner(this);
            money = 1000000;
        }
        jay.destroy();
        jay = new JayJay(targetX, targetY);
        
        for(int i = towers.size() - 1; i >= 0; i--) {
            towers.get(i).destroy();
        }
        
        for(int i = enemies.size() - 1; i >= 0; i--) {
            enemies.get(i).die();
        }
        
        for(int i = projectiles.size() - 1; i >= 0; i--) {
            projectiles.get(i).destroy();
        }
        
        for(int i = minions.size() - 1; i >= 0; i--) {
            minions.get(i).destroy();
        }
    }

    /**
     * Updates objects
     */
    public void update() {
        mouse.update();
        updateLoop(getDelta());
    }

    /**
     * Loop and update each object
     * @param delta Change in time since last update in seconds
     */
    private void updateLoop(float delta) {
        for(int i = objects.size() - 1; i >= 0; i--)
            objects.get(i)._update(delta);

        for(int i = enemies.size() - 1; i >= 0; i--)
            enemies.get(i)._update(delta);
        
        for(int i = towers.size() - 1; i >= 0; i--)
            towers.get(i)._update(delta);
        
        for(int i = minions.size() - 1; i >= 0; i--)
            minions.get(i)._update(delta);
            
        for(int i = projectiles.size()-1; i >= 0; i--) {
            Projectile o = projectiles.get(i);
            o._update(delta);
            //if (o.isRemoved()) {
            //    projectiles.remove(i);
            //}
        }

        jay._update(delta);
        spawner._update(delta);
    }

    /**
     * Sends a message to all objects
     * @param ID Magic number of broadcast
     */
    public void broadcast(int ID) {
        for(Updated o: objects) {
            o._receiveBroadcast(ID);
        }
        
        for(Updated o: enemies) {
            o._receiveBroadcast(ID);
        }
        
        for(Updated o: towers) {
            o._receiveBroadcast(ID);
        }
        
        for(Updated o: projectiles) {
            o._receiveBroadcast(ID);
        }
        
        for(Updated o: minions) {
            o._receiveBroadcast(ID);
        }
    }

    /**
     * Adds an enemy
     * @param e enemy to add
     */
    public void addEnemy(Enemy e) {
        enemies.add(e);
    }

    /**
     * Adds a projectile
     * @param p projectile to add
     */
    public void addProjectile(Projectile p) {
        projectiles.add(p);
    }

    /**
     * Adds a tower
     * @param t tower to add
     */
    public void addTower(Tower t) {
        towers.add(t);
    }

    /**
     * Adds a minion
     * @param m minion to add
     */
    public void addMinion(Minion m) {
        minions.add(m);
    }

    /**
     * Removes an enemy
     * @param e enemy to remove
     */
    public void removeEnemy(Enemy e) {
        enemies.remove(e);
    }

    /**
     * Removes a projectile
     * @param p projectile to remove
     */
    public void removeProjectile(Projectile p) {
        projectiles.remove(p);
    }

    /**
     * Removes a tower
     * @param t tower to remove
     */
    public void removeTower(Tower t) {
        towers.remove(t);
    }

    /**
     * Removes a minion
     * @param m minion to remove
     */
    public void removeMinion(Minion m) {
        minions.remove(m);
    }

    /**
     * Removes an updated object
     * @param u object to remove
     */
    public void removeObject(Updated u) {
        objects.remove(u);
    }

    /**
     * Adds an updated object
     * @param u object to add
     */
    public void addObject(Updated u) {
        objects.add(u);
    }
    
    private long last;

    // get change in time since last function call
    private float getDelta() {
        long now = System.nanoTime();
        float delta = (now - last) / 1000000000f;
        last = now;
        return delta;
    }

    /**
     * Initialises the world
     */
    public void init() {
        int widthIndex = 0, heightIndex = 0;
        int width = 850;
        int height = 600;
        
        for(int x = 0; x < width; x += Global.SLOT_SIZE) {
            widthIndex++;
        }
        
        for(int y = 0; y < height; y += Global.SLOT_SIZE) {
            heightIndex++;
        }
            
        nodes = new Node[widthIndex][heightIndex];
        slots = new Slot[widthIndex][heightIndex];
        
        this.maxNodesX = widthIndex;
        this.maxNodesY = heightIndex;
           
        for(int x = 0, index_x = 0; x < width; x += Global.SLOT_SIZE, index_x++) {
            for(int y = 0, index_y = 0; y < height; y += Global.SLOT_SIZE, index_y++) {
                Slot s = new Slot(x + Global.SLOT_SIZE / 2, y  + Global.SLOT_SIZE / 2, index_x, index_y, false);
                nodes[index_x][index_y] = s.getNode();
                slots[index_x][index_y] = s;
            }
        }

        this.targetNode = nodes[targetIndexX][targetIndexY];
        this.startNode = nodes[startIndexX][startIndexY];
        
        pathfinder = new PathfindingSimplified(nodes, this.startNode, this.targetNode);
        path = pathfinder.getPath();
        
        new Background(width, height);
    }

    /**
     * Gets the closest node from indicated location
     * @param loc location
     * @return closest pathfinding node
     */
    public Node getClosestNode(Point loc) {
        int x = (int) (loc.x + .5f);
        int y = (int) (loc.y + .5f);
        
        x /= Global.SLOT_SIZE;
        y /= Global.SLOT_SIZE;
        
        x = Math2D.clamp(x, 0, this.maxNodesX);
        y = Math2D.clamp(y, 0, this.maxNodesY);
        
        return nodes[x][y];
    }

    /**
     * Rebuilds the pathfinding path
     * @return whether or not the path is valid
     */
    public boolean rebuildPath() {
        // Try to find a path
        pathfinder = new PathfindingSimplified(nodes, nodes[startIndexX][startIndexY], nodes[targetIndexX][targetIndexY]);
        Node[] path = pathfinder.getPath();
        
        // If no path found, dont set enemy path to new path
        if(path == null) return false;

        this.path = path;
        broadcast(BROADCAST_REBUILD);
        return true;
    }

    /**
     * Updates one node in the pathfinding path
     * @param x x index of node
     * @param y y index of node
     * @param blocked whether or not to set node as blocked
     * @return whether or not change is valid (still has a valid path after change)
     */
    public boolean updatePath(int x, int y, boolean blocked) {
        if(x == startIndexX && y == startIndexY) return false;
        
        boolean original = nodes[x][y].isBlocked();
        
        nodes[x][y].setBlocked(blocked);
        
        boolean valid = rebuildPath();
        
        if(!valid) {
            nodes[x][y].setBlocked(original);
        }
        
        return valid;
    }

    /**
     * Get the pathfinding path
     * @return path
     */
    public Node[] getPath() {
        return this.path;
    }

    /**
     * Get a pathfinding node
     * @param index index of node
     * @return node
     */
    public Node getPathNode(int index) {
        try {
            return this.path[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    /**
     * Get all pathfinding nodes
     * @return nodes
     */
    public Node[][] getNodes() {
        return this.nodes;
    }

    /**
     * Get end goal node
     * @return end goal node
     */
    public Node getTargetNode() {
        return this.targetNode;
    }

    /**
     * Get x location of mouse
     * @return x location
     */
    public int mouseX() {
        return mouse.getMouseX();
    }

    /**
     * Get y location of mouse
     * @return y location
     */
    public int mouseY() {
        return mouse.getMouseY();
    }

    /**
     * Get whether or not the mouse is down
     * @return whether or not the mouse is down
     */
    public boolean mouseDown() {
        return mouse.isDown();
    }

    /**
     * Get the current state of the object manager
     * @return state
     */
    public int getState() {
        return this.state;
    }

    /**
     * Get all enemies
     * @return enemies
     */
    public ArrayList<Enemy> getEnemies() {
        return this.enemies;
    }

    /**
     * Get all towers
     * @return towers
     */
    public ArrayList<Tower> getTowers() {
        return this.towers;
    }

    /**
     * Get all projectiles
     * @return projectiles
     */
    public ArrayList<Projectile> getProjectiles() {
        return this.projectiles;
    }

    /**
     * Set the pathfinding target location
     * @param x x location of target
     */
    public void setTargetX(double x) {
        targetX = x;
    }

    /**
     * Set the pathfinding target y location
     * @param y y location of target
     */
    public void setTargetY(double y) {
        targetY = y;
    }

    /**
     * Get the pathfinding target x location
     * @return x location
     */
    public double getTargetX() {
        return targetX;
    }

    /**
     * Get the pathfinding target y location
     * @return y location
     */
    public double getTargetY() {
        return targetY;
    }

    /**
     * Deal damage to jay jay
     * @param damage amount of damage
     */
    public void damageJayJay(float damage) {
        jay.damage(damage);
    }

    /**
     * Get amount of money
     * @return amount of money
     */
    public float getMoney() {
        return money;
    }

    /**
     * Add money
     * @param amount amount to add
     */
    public void addMoney(float amount) {
        money += amount;
    }

    /**
     * Set money value
     * @param amount new money amount
     */
    public void setMoney(float amount) {
        money = amount;
    }

    /**
     * Try to reduce the money amount
     * @param amount amount to reduce by
     * @return whether or not the remaining money will be greater than 0
     */
    public boolean requestMoney(float amount) {
        money -= amount;
        
        if(money < 0) {
            money += amount;
            return false;
        }
        
        return true;
    }

    /**
     * Get the spawner
     * @return spawner
     */
    public Spawner getSpawner() {
        return spawner;
    }

    /**
     * Set the level of the game
     * @param level level
     */
    public void setLevel(int level) {
        if(Global.getWorld().isEditor()) return;
        
        spawner = new Spawner(this, level);
    }

    /**
     * Get the jay jay
     * @return jay jay
     */
    public JayJay getJayJay() {
        return jay;
    }
}
