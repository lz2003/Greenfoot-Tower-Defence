/**
 * Spawner that spawns nothing for the map editor
 *
 * @author Young Chen
 * @version 2021-01-26
 */
public class DummySpawner extends Spawner 
{
    /**
     * Creates a dummyspawner
     * @param manager Object manager
     */
    public DummySpawner(ObjectManager manager) {
        super(manager);
    }

    /**
     * Overridden update method
     * @param delta Change in time since last update
     */
    public void _update(float delta) {

    }

    /**
     * Overridden next level method
     */
    public void nextLevel() {
    
    }

    /**
     * Overriden spawn level method
     * @param level level
     */
    public void spawnLevel(int level) {
    
    }
}
