
import java.util.*;
/**
 * Write a description of class Spawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spawner extends Updated
{
    private static final String 
        BP = "0",
        GL = "1",
        MN = "2",
        PK = "3",
        TR = "4",
        WL = "5"
    ;
    private int level = 0;
    private ObjectManager manager;
    /**
     * Constructor for objects of class Spawner
     */
    public Spawner(ObjectManager manager) {
        this.manager = manager;
    }
    
    public void _update(float delta) {
        if(manager.getEnemies().size() <= 0) {
            nextLevel();
        }
    }
    
    public void nextLevel() {
        spawnLevel(++level);
    }
    
    private void spawnLevel(int level) {

        switch(level) {
            case 1: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 1; i++) {
                    e.add(MN);
                }
                e.add(BP);
                e.add(BP);
                spawn(e);
                break;
            }

            case 2: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                e.add(TR);
                e.add(WL);
                e.add(BP);
                for(i = 0; i < 10; i++) {
                    e.add(MN);
                }
                spawn(e);
                break;
            }

            case 3: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 10; i++) {
                    e.add(MN);
                }
                spawn(e);
                break;
            }

            case 4: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 10; i++) {
                    e.add(MN);
                }
                spawn(e);
                break;
            }

            case 5: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 10; i++) {
                    e.add(MN);
                }
                spawn(e);
                break;
            }

            case 6: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 10; i++) {
                    e.add(MN);
                }
                spawn(e);
                break;
            }

            case 7: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 10; i++) {
                    e.add(MN);
                }
                spawn(e);
                break;
            }

            case 8: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 10; i++) {
                    e.add(MN);
                }
                spawn(e);
                break;
            }

            case 9: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 10; i++) {
                    e.add(MN);
                }
                spawn(e);
                break;
            }

            case 10: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 10; i++) {
                    e.add(MN);
                }
                spawn(e);
                break;
            }

            case 11: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 10; i++) {
                    e.add(MN);
                }
                spawn(e);
                break;
            }

            case 12: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 10; i++) {
                    e.add(MN);
                }
                spawn(e);
                break;
            }

            case 13: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 10; i++) {
                    e.add(MN);
                }
                spawn(e);
                break;
            }

            case 14: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 10; i++) {
                    e.add(MN);
                }
                spawn(e);
                break;
            }
            
            default: {
                endless(level);
            }
        }
    }
    
    private void endless(int level) {
    }
    
    private void spawn(ArrayList<String> e) {
        spawn(e, 50);
    }
    
    // spawn enemies
    private void spawn(ArrayList<String> enemies, double offset) {
        int delay = 2;
        for(int i = 0; i < enemies.size(); i++) {
            switch(enemies.get(i)) {
                case BP: 
                    new BabyPekka(manager.startPosX - (i + delay)* offset, manager.startPosY);
                    break;
                case GL: 
                    new Golem(manager.startPosX - (i + delay) * offset, manager.startPosY);
                    break;
                case MN: 
                    new Maniac(manager.startPosX - (i + delay) * offset, manager.startPosY);
                    break;
                case PK: 
                    new Pekka(manager.startPosX - (i + delay) * offset, manager.startPosY);
                    break;
                case TR: 
                    new Troll(manager.startPosX - (i + delay) * offset, manager.startPosY);
                    break;
                case WL: 
                    new Warlock(manager.startPosX - (i + delay) * offset, manager.startPosY);
                    break;
            }
        }
    }
    
    public int getLevel() {
        return level;
    }
}
