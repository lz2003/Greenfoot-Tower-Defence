/**
 * Write a description of class Global here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Global  
{  
    public static Game world;
    public static ObjectManager manager;
    
    public static void setWorld(Game world) {
        Global.world = world;
    }
    
    public static Game getWorld() {
        return Global.world;
    }
    
    public static ObjectManager getManager() {
        return Global.manager;
    }
    
    public static final int SLOT_SIZE = 50;
}