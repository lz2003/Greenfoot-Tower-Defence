/**
 * Class to handle pathfinding
 * <br>
 * Pathfinding algorithm based off of https://www.youtube.com/watch?v=AKKpPmxx07w
 *
 * @author Young Chen
 * @version 2021-01-26
 */

import java.util.ArrayList;

class PathfindingSimplified {
    private Grid grid;
    private Node start, target;

    /**
     * Create a pathfinding wrapper
     * @param nodes Pathfinding nodes
     * @param start start node
     * @param target end node
     */
    public PathfindingSimplified(Node[][] nodes, Node start, Node target) {
        this.grid = new Grid(nodes);

        for(int x = 0; x < nodes.length; x++) {
            for(int y = 0; y < nodes[0].length; y++) {
                nodes[x][y].setNeighbours(this.grid);
                nodes[x][y].setOnPath(false);
            }
        }

        this.start = start;
        this.target = target;
    }

    /**
     * Get the path
     * @return path
     */
    public Node[] getPath() {
        Pathfinding p = new Pathfinding(this.grid, this.start, this.target);
        p.findPath();
        return p.getPath();
    }
}

/**
 * Class to carry out pathfinding using the A* algorithm
 * <br>
 * Pathfinding algorithm based off of https://www.youtube.com/watch?v=AKKpPmxx07w
 *
 * @author Young Chen
 * @version 2021-01-26
 */
public class Pathfinding {
    private Grid grid;
    private Node target, start;
    private Node[] path;

    /**
     * Creates a pathfinding instance
     * @param grid Node grid
     * @param start start node
     * @param end end node
     */
    public Pathfinding(Grid grid, Node start, Node end) {
        this.grid = grid;
        this.start = start;
        this.target = end;
    }

    /**
     * Sets the start node
     * @param n start node
     */
    public void setStartNode(Node n) {
        this.start = n;
    }

    /**
     * Sets the end node
     * @param n end node
     */
    public void setTargetNode(Node n) {
        this.target = n;
    }

    /**
     * Create the nearest path
     */
    public void findPath() {
        // Define starting and target nodes
        Node start = this.start;
        Node end = this.target;

        // Create opened and closed node arrays
        // The neighbours of the open array will be added to the open array, and the node
        // that the neighbours were checked from will be added to the closed array
        ArrayList<Node> open = new ArrayList<Node>(),
                        closed = new ArrayList<Node>();

        // Add the starting node to the open array
        open.add(start);

        // While there are still unchecked neighbours
        while(open.size() > 0) {
            // Get the first node in the open array
            Node current = open.get(0);

            // Get the node with lowest cost
            for(int i = 0; i < open.size(); i++) {
                if(open.get(i).fCost() < current.fCost() || open.get(i).fCost() == current.fCost() && open.get(i).hCost() < current.hCost()) {
                    current = open.get(i);
                }
            }


            // The lowest cost node will now be checked
            open.remove(current);
            closed.add(current);

            // Check if the current node is the target
            if(current == end) {
                findFinalPath();
                return;
            }

            // Get the current node's neighbours and set their g costs and h costs, as well as set
            // the node's parent to the current node. This parent variable will be used to trace back
            // the path to the starting node
            Node[] neighbours = current.getNeighbours();
            for(int i = 0; i < neighbours.length; i++) {

                // If neighbour has already been checked, don't check it again
                if(closed.contains(neighbours[i])) continue;

                Node neighbour = neighbours[i];

                // Get the f cost of the current node
                float cost = current.gCost() + current.distance(end);

                // Check if the neighbour's node is closer to the target or that it hasn't been checked yet
                if(cost < neighbour.gCost() || !open.contains(neighbour)) {
                    neighbour.setGCost(cost);
                    neighbour.setHCost(neighbour.distance(target));
                    neighbour.setParent(current);

                    if(!open.contains(neighbour)) {
                        open.add(neighbour);
                    }
                }
            }
        }
    }

    // reverse the path for the final path
    private void findFinalPath() {
        ArrayList<Node> path = new ArrayList<Node>();
        Node current = this.target;

        while(current != this.start) {
            path.add(current);
            current.setOnPath(true);
            current = current.getParent();
        }

        Node[] reversed = new Node[path.size()];

        for(int i = 0, j = path.size() - 1; j >= 0; j--, i++) {
            reversed[i] = path.get(j);
        }

        this.path = reversed;
    }

    /**
     * Get created path
     * @return path
     */
    public Node[] getPath() {
        return this.path;
    }
}

/**
 * Class to contain the 2d array of nodes for pathfinding
 *
 * @author Young Chen
 * @version 2021-01-26
 */
class Grid {
    private Node[][] grid;

    /**
     * Set the nodes
     * @param grid nodes
     */
    public Grid(Node[][] grid) {
        this.grid = grid;
    }

    /**
     * Get node at indicated index
     * @param x x index
     * @param y y index
     * @return node at index, or null if index is invalid
     */
    public Node get(int x, int y) {
        try {
            Node n = grid[x][y];
            return n;
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }
}

/**
 * Pathfinding node
 *
 * @author Young Chen
 * @version 2021-01-26
 */
class Node {
    private Point worldLoc;
    private Index2D arrayLoc;

    private Node parent;

    private Node[] neighbours;

    private float distToTarget, distToNeighbour = 0;

    private boolean blocked;
    
    private boolean onPath = false;

    /**
     * Create a node
     * @param worldPos location in world
     * @param arrayPos location in array
     * @param blocked whether or not its blocked
     */
    public Node(Point worldPos, Index2D arrayPos, boolean blocked) {
        this.worldLoc = worldPos;
        this.arrayLoc = arrayPos;

        //this.distToTarget = worldPos.distance(target);
        this.blocked = blocked;
    }

    /**
     * Sets the node's neighbours
     * @param grid grid the node is in
     */
    public void setNeighbours(Grid grid) {
        // Get list of possibly valid neighbours
        Node[] nodes = {
                         grid.get(arrayLoc.x + 1, arrayLoc.y    ),
                         grid.get(arrayLoc.x - 1, arrayLoc.y    ),
                         grid.get(arrayLoc.x    , arrayLoc.y - 1),
                         grid.get(arrayLoc.x    , arrayLoc.y + 1),
                         // Comment below to exclude travelling diagonally
                         //grid.get(arrayLoc.x + 1, arrayLoc.y - 1),
                         //grid.get(arrayLoc.x + 1, arrayLoc.y + 1),
                         //grid.get(arrayLoc.x - 1, arrayLoc.y - 1),
                         //grid.get(arrayLoc.x - 1, arrayLoc.y + 1)
        };

        int length = 0;
        // Add neighbours that are not blocked
        for(int i = 0; i < nodes.length; i++) {
            if(nodes[i] != null)
                if(!nodes[i].isBlocked())
                    length++;
        }

        this.neighbours = new Node[length];

        for(int i = 0, index = 0; i < nodes.length; i++) {
            if(nodes[i] != null)
                if(!nodes[i].isBlocked())
                    this.neighbours[index++] = nodes[i];
        }
    }

    /**
     * Gets the node's neighbours
     * @return neighbours
     */
    public Node[] getNeighbours() {
        return this.neighbours;
    }

    /**
     * Gets the node's parent
     * @return parent
     */
    public Node getParent() {
        return this.parent;
    }

    /**
     * Whether or not the node is blocked
     * @return whether or not it's blocked
     */
    public boolean isBlocked() {
        return blocked;
    }

    /**
     * Set G cost of node
     * @param cost g cost
     */
    public void setGCost(float cost) {
        this.distToNeighbour = cost;
    }

    /**
     * Set H cost of node
     * @param cost h cost
     */
    public void setHCost(float cost) {
        this.distToTarget = cost;
    }

    /**
     * Set the node's parent
     * @param parent parent
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     * Set whether or not the node is blocked
     * @param blocked whether or not its blocked
     */
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    /**
     * Sets whether or not the node is on the created path
     * @param onPath whether or not its on the created path
     */
    public void setOnPath(boolean onPath) {
        this.onPath = onPath;
    }

    /**
     * Get h cost (distance to target)
     * @return
     */
    public float hCost() {
        return this.distToTarget;
    }

    /**
     * Get g cost (distance to neighbours)
     * @return
     */
    public float gCost() {
        return this.distToNeighbour;
    }

    /**
     * Get sum of h cost and g cost
     * @return f cost
     */
    public float fCost() {
        return this.distToTarget + this.distToNeighbour;
    }

    /**
     * Get distance between nodes
     * @param b
     * @return
     */
    public float distance(Node b) {
        return this.worldLoc.distance(b.getWorldLoc());
    }

    /**
     * Get the location in the world
     * @return
     */
    public Point getWorldLoc() {
        return this.worldLoc;
    }

    /**
     * Whether or not node is on the path
     * @return whether or not node is on the created path
     */
    public boolean isOnPath() {
        return this.onPath;
    }
}

/**
 * 2D Index object
 *
 * @author Young Chen
 * @version 2021-01-26
 */
class Index2D {
    public int x, y;

    /**
     * Creates the index object
     * @param x x index
     * @param y y index
     */
    public Index2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
