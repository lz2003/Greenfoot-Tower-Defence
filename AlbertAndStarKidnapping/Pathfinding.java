/**
 * Based off of https://www.youtube.com/watch?v=AKKpPmxx07w
 */

import java.util.ArrayList;

class PathfindingSimplified {
    private Grid grid;
    private Node start, target;

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

    public Node[] getPath() {
        Pathfinding p = new Pathfinding(this.grid, this.start, this.target);
        p.findPath();
        return p.getPath();
    }
}

public class Pathfinding {
    private Grid grid;
    private Node target, start;
    private Node[] path;

    public Pathfinding(Grid grid, Node start, Node end) {
        this.grid = grid;
        this.start = start;
        this.target = end;
    }

    public void setStartNode(Node n) {
        this.start = n;
    }

    public void setTargetNode(Node n) {
        this.target = n;
    }

    public void findPath() {
        Node start = this.start;
        Node end = this.target;

        ArrayList<Node> open = new ArrayList<Node>(),
                        closed = new ArrayList<Node>();

        open.add(start);

        while(open.size() > 0) {
            Node current = open.get(0);

            for(int i = 0; i < open.size(); i++) {
                if(open.get(i).fCost() < current.fCost() || open.get(i).fCost() == current.fCost() && open.get(i).hCost() < current.hCost()) {
                    current = open.get(i);
                }
            }

            open.remove(current);
            closed.add(current);

            if(current == end) {
                findFinalPath();
                return;
            }

            Node[] neighbours = current.getNeighbours();
            for(int i = 0; i < neighbours.length; i++) {
                if(closed.contains(neighbours[i])) continue;

                Node neighbour = neighbours[i];

                float cost = current.gCost() + current.distance(end);

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
    
    /* Astar pathfinding
    public void findPath() {
        Node start = this.start;
        Node end = this.target;

        ArrayList<Node> open = new ArrayList<Node>(),
                        closed = new ArrayList<Node>();

        open.add(start);

        while(open.size() > 0) {
            Node current = open.get(0);

            for(int i = 0; i < open.size(); i++) {
                if(open.get(i).fCost() < current.fCost() || open.get(i).fCost() == current.fCost() && open.get(i).hCost() < current.hCost()) {
                    current = open.get(i);
                }
            }

            open.remove(current);
            closed.add(current);

            if(current == end) {
                findFinalPath();
                return;
            }

            Node[] neighbours = current.getNeighbours();
            for(int i = 0; i < neighbours.length; i++) {
                if(closed.contains(neighbours[i])) continue;

                Node neighbour = neighbours[i];

                float cost = current.gCost() + current.distance(end);

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
    */

    public Node[] getPath() {
        return this.path;
    }
}

class Grid {
    private Node[][] grid;

    public Grid(Node[][] grid) {
        this.grid = grid;
    }

    public Node get(int x, int y) {
        try {
            Node n = grid[x][y];
            return n;
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }
}

class Node {
    private Point worldLoc;
    private Index2D arrayLoc;

    private Node parent;

    private Node[] neighbours;

    private float distToTarget, distToNeighbour = 0;

    private boolean blocked;
    
    private boolean onPath = false;

    public Node(Point worldPos, Index2D arrayPos, boolean blocked) {
        this.worldLoc = worldPos;
        this.arrayLoc = arrayPos;

        //this.distToTarget = worldPos.distance(target);
        this.blocked = blocked;
    }

    public void setNeighbours(Grid grid) {
        Node[] nodes = {
                         grid.get(arrayLoc.x + 1, arrayLoc.y    ),
                         grid.get(arrayLoc.x - 1, arrayLoc.y    ),
                         grid.get(arrayLoc.x    , arrayLoc.y - 1),
                         grid.get(arrayLoc.x    , arrayLoc.y + 1),
                         // Comment below to exclude travelling through corners
                         grid.get(arrayLoc.x + 1, arrayLoc.y - 1),
                         grid.get(arrayLoc.x + 1, arrayLoc.y + 1),
                         grid.get(arrayLoc.x - 1, arrayLoc.y - 1),
                         grid.get(arrayLoc.x - 1, arrayLoc.y + 1)
        };

        int length = 0;

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

    public Node[] getNeighbours() {
        return this.neighbours;
    }

    public Node getParent() {
        return this.parent;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setGCost(float cost) {
        this.distToNeighbour = cost;
    }

    public void setHCost(float cost) {
        this.distToTarget = cost;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
    
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
    
    public void setOnPath(boolean onPath) {
        this.onPath = onPath;
    }

    public float hCost() {
        return this.distToTarget;
    }

    public float gCost() {
        return this.distToNeighbour;
    }

    public float fCost() {
        return this.distToTarget + this.distToNeighbour;
    }

    public float distance(Node b) {
        return this.worldLoc.distance(b.getWorldLoc());
    }

    public Point getWorldLoc() {
        return this.worldLoc;
    }
    
    public boolean isOnPath() {
        return this.onPath;
    }
}

class Index2D {
    public int x, y;
    public Index2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
