/**
 * Class for global variables
 * 
 * @author Young Chen
 * @version 2021-01-26
 */
public class Global  
{  
    public static Game world;
    public static ObjectManager manager;

    /**
     * Set the global world
     * @param world World to set
     */
    public static void setWorld(Game world) {
        Global.world = world;
    }

    /**
     * Get the global world
     * @return global world
     */
    public static Game getWorld() {
        return Global.world;
    }

    /**
     * Get the global object manager
     * @return global object manager
     */
    public static ObjectManager getManager() {
        return Global.manager;
    }
    
    public static final int SLOT_SIZE = 50;
}