
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
        for(int i = 0; i < enemies.size(); i++) {
            switch(enemies.get(i)) {
                case BP: 
                    manager.addEnemy(new BabyPekka(manager.startPosX - (i + 1)* offset, manager.startPosY));
                    break;
                case GL: 
                    manager.addEnemy(new Golem(manager.startPosX - (i + 1) * offset, manager.startPosY));
                    break;
                case MN: 
                    manager.addEnemy(new Maniac(manager.startPosX - (i + 1) * offset, manager.startPosY));
                    break;
                case PK: 
                    manager.addEnemy(new Pekka(manager.startPosX - (i + 1) * offset, manager.startPosY));
                    break;
                case TR: 
                    manager.addEnemy(new Troll(manager.startPosX - (i + 1) * offset, manager.startPosY));
                    break;
                case WL: 
                    manager.addEnemy(new Warlock(manager.startPosX - (i + 1) * offset, manager.startPosY));
                    break;
            }
        }
    }
}
