import java.util.*;
import greenfoot.*;
import java.io.IOException;
/**
 * Class that spawns enemies
 *
 * @author Young Chen
 * @version 2021-01-26
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
     * Creates a spawner that will spawn enemies into the indicated object manager
     * @param manager object manager
     */
    public Spawner(ObjectManager manager) {
        this.manager = manager;
    }

    /**
     * Creates a spawner that will spawn enemies into the indicated object manager
     * @param manager object manager
     * @param level level of spawner
     */
    public Spawner(ObjectManager manager, int level) {
        this.manager = manager;
        this.level = level;
    }

    /**
     * Spawner update method
     * @param delta Change in time since last update
     */
    public void _update(float delta) {
        if(manager.getEnemies().size() <= 0) {
            nextLevel();
        }
    }

    /**
     * Whether or not theres a cutscene
     * @param level level to check
     * @return whether or not theres a cutscene
     */
    public static boolean hasCutscene(int level) {
        int cutscene = level / Cutscene.LEVELS_PER_CUTSCENE;
        int check = level % Cutscene.LEVELS_PER_CUTSCENE;
        
        return check == 0 && cutscene > 0 && cutscene <= Cutscene.TOTAL_CUTSCENES && Global.getWorld().isCampaign();
    }

    /**
     * Spawns next level
     */
    public void nextLevel() {
        int cutscene = ++level / Cutscene.LEVELS_PER_CUTSCENE;
        int check = level % Cutscene.LEVELS_PER_CUTSCENE;
        if(check == 0 && cutscene > 0 && cutscene <= Cutscene.TOTAL_CUTSCENES && Global.getWorld().isCampaign()) {
            try {
                SavedInstance s = new SavedInstance(Global.getManager());
                s.save(SavedInstance.AUTO_SAVE_PATH);
            } catch (IOException e) {
                // Player's progress is worth more than a cutscene
                return;
            }
            Greenfoot.setWorld(new Cutscene(cutscene));
            return;
        }
        
        spawnLevel(level);
    }

    /**
     * Spawns level
     * @param level level
     */
    public void spawnLevel(int level) {
        switch(level) {
            case 0:
                break;
                
            case 1: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                
                for(i = 0; i < 5; i++) {
                    e.add(MN);
                }
                
                spawn(e, 50, 8);
                break;
            }

            case 2: {
                ArrayList<String> e = new ArrayList<String>();
                int i;

                for(i = 0; i < 8; i++) {
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
                spawn(e, 20);
                break;
            }

            case 4: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 20; i++) {
                    e.add(MN);
                }
                spawn(e);
                break;
            }

            case 5: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                e.add(BP);
                for(i = 0; i < 10; i++) {
                    e.add(MN);
                }
                spawn(e);
                break;
            }

            case 6: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                
                for(i = 0; i < 4; i++) {
                    e.add(MN);
                    e.add(BP);
                }
                spawn(e);
                break;
            }

            case 7: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 6; i++) {
                    e.add(MN);
                    e.add(BP);
                    e.add(BP);
                }
                spawn(e);
                break;
            }

            case 8: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 20; i++) {
                    e.add(BP);
                }
                spawn(e, 100);
                break;
            }

            case 9: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 20; i++) {
                    e.add(MN);
                    e.add(BP);
                }
                spawn(e, 25);
                break;
            }

            case 10: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 10; i++) {
                    e.add(BP);
                }
                e.add(TR);
                spawn(e);
                break;
            }

            case 11: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 6; i++) {
                    e.add(MN);
                    e.add(MN);
                    e.add(TR);
                }
                spawn(e, 35);
                break;
            }

            case 12: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 30; i++) {
                    e.add(TR);
                }
                spawn(e, 20);
                break;
            }

            case 13: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 20; i++) {
                    e.add(BP);
                    e.add(TR);
                    e.add(MN);
                }
                spawn(e, 42);
                break;
            }

            case 14: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                e.add(TR);
                e.add(TR);
                for(i = 0; i < 50; i++) {
                    e.add(BP);
                }
                
                spawn(e, 25);
                break;
            }
            
            case 15: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 10; i++) {
                    e.add(BP);
                }
                e.add(WL);
                for(i = 0; i < 10; i++) {
                    e.add(BP);
                }
                
                spawn(e, 40);
                break;
            }
            
            case 16: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 20; i++) {
                    e.add(BP);
                    e.add(TR);
                }
                
                for(i = 0; i < 5; i++) {
                    e.add(WL);
                }
                
                spawn(e);
                break;
            }
            
            case 17: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 30; i++) {
                    e.add(BP);
                    e.add(WL);
                    e.add(MN);
                }
                
                spawn(e);
                break;
            }
            
            case 18: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 10; i++) {
                    e.add(BP);
                }
                
                for(i = 0; i < 10; i++) {
                    e.add(WL);
                }
                
                for(i = 0; i < 10; i++) {
                    e.add(BP);
                    e.add(WL);
                    e.add(TR);
                }
                
                spawn(e, 20);
                break;
            }
            
            case 19: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 20; i++) {
                    e.add(MN);
                    e.add(WL);
                    e.add(TR);
                    e.add(TR); 
                }
                
                spawn(e, 15);
                break;
            }
            
            case 20: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                e.add(BP);
                for(i = 0; i < 3; i++) {
                    e.add(GL);
                }
                
                spawn(e, 100);
                break;
            }
            
            case 21: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 15; i++) {
                    e.add(BP);
                    e.add(WL);
                    e.add(GL);
                }
                
                spawn(e, 30);
                break;
            }
            
            case 22: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 20; i++) {
                    e.add(GL);
                    e.add(WL);
                }
                
                spawn(e, 25);
                break;
            }
            
            case 23: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 100; i++) {
                    e.add(BP);
                }
                
                spawn(e, 8);
                break;
            }
            
            case 24: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 35; i++) {
                    e.add(GL);
                    e.add(WL);
                    e.add(GL);
                }
                
                spawn(e, 28);
                break;
            }
            
            case 25: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                
                e.add(PK);
                for(i = 0; i < 20; i++) {
                    e.add(WL);
                    e.add(MN);
                }
                
                spawn(e, 35);
                break;
            }
            
            case 26: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                
                for(i = 0; i < 3; i++) {
                    e.add(GL);
                }
                
                e.add(WL);
                
                spawn(e, 70);
                break;
            }
            
            case 27: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 3; i++) {
                    for(int j = 0; j < 10; j++) {
                        e.add(GL);
                    }
                    e.add(PK);
                    e.add(WL);
                    e.add(WL);
                    for(int j = 0; j < 10; j++) {
                        e.add(TR);
                    }
                }
                
                spawn(e, 20);
                break;
            }
            
            case 28: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 4; i++) {
                    e.add(PK);
                    e.add(WL);
                    e.add(TR);
                }
                
                spawn(e, 55);
                break;
            }
            
            case 29: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 10; i++) {
                    e.add(PK);
                    e.add(WL);
                }
                
                spawn(e, 100);
                break;
            }
            
            case 30: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                e.add(PK);
                e.add(PK);
                for(i = 0; i < 35; i++) {
                    e.add(TR);
                    e.add(BP);
                    e.add(WL);
                }
                
                spawn(e, 25);
                break;
            }
            
            case 31: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                
                e.add(PK);
                e.add(WL);
                
                spawn(e, 80);
                break;
            }
            
            case 32: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 35; i++) {
                    e.add(GL);
                }
                
                spawn(e, 36);
                break;
            }
            
            case 33: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                e.add(PK);
                for(i = 0; i < 200; i++) {
                    e.add(MN);
                }
                e.add(WL);
                e.add(WL);
                e.add(WL);
                e.add(TR);
                
                spawn(e, 36);
                break;
            }
            
            case 34: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 35; i++) {
                    e.add(PK);
                    e.add(WL);
                    e.add(GL);
                }
                
                spawn(e, 27);
                break;
            }
            
            case 35: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                
                for(i = 0; i < 30; i++) {
                    e.add(PK);
                }
                
                for(i = 0; i < 50; i++) {
                    e.add(WL);
                    e.add(BP);
                    e.add(GL);
                    e.add(PK);
                }
                
                spawn(e, 60);
                break;
            }
            
            case 36: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 20; i++) {
                    e.add(PK);
                }
                e.add(WL);
                e.add(WL);
                e.add(WL);
                
                spawn(e, 5);
                break;
            }
            
            case 37: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                e.add(PK);
                e.add(PK);
                e.add(PK);
                e.add(PK);
                e.add(PK);
                e.add(PK);
                e.add(PK);
                e.add(PK);
                e.add(PK);
                
                for(i = 0; i < 10; i++) {
                    e.add(PK);
                    e.add(GL);
                    e.add(WL);
                    e.add(MN);
                }
                
                spawn(e, 35);
                break;
            }
            
            case 38: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 50; i++) {
                    e.add(PK);
                    e.add(WL);
                }
                
                spawn(e, 27);
                break;
            }
            
            case 39: {
                ArrayList<String> e = new ArrayList<String>();
                int i;
                for(i = 0; i < 65; i++) {
                    e.add(PK);
                    e.add(WL);
                    e.add(TR);
                }
                
                spawn(e, 20);
                break;
            }
            
            default: {
                endless(level);
            }
        }
    }

    /**
     * Endless spawning
     * @param level level
     */
    private void endless(int level) {
        int enemies = level * 7;
        int seed = Math.abs((int)(Math.random() * 203192031) % 40000);
        
        int spawns = enemies;
        
        int i;
        
        int maxMN = seed % enemies / 4;
        int maxBP = seed * 21 % enemies / 4;
        int maxGL = seed * 532 % enemies / 4;
        int maxTR = seed * 95 % enemies / 4;
        int maxWL = seed * 231 % enemies / 4;
        
        spawns = spawns - maxMN - maxBP - maxGL - maxTR - maxWL;
        spawns = spawns % enemies / 3;
       
        ArrayList<String> e = new ArrayList<String>();
 
        for(i = 0; i < spawns; i++) {
            e.add(PK);
            enemies--;
        }
        
        for(i = 0; i < maxGL && enemies > 0; i++, enemies--) {
            e.add(GL);
        }
        
        for(i = 0; i < maxBP && enemies > 0; i++, enemies--) {
            e.add(BP);
        }
        
        for(i = 0; i < maxWL && enemies > 0; i++, enemies--) {
            e.add(WL);
        }
        
        for(i = 0; i < maxTR && enemies > 0; i++, enemies--) {
            e.add(TR);
        }
        
        for(i = 0; i < enemies; i++) {
            e.add(MN);
        }
        
        spawn(e, 10 + seed % 50);
    }

    /**
     * Spawns the arraylist of magic strings
     * @param e arraylist of enemies
     */
    private void spawn(ArrayList<String> e) {
        spawn(e, 50);
    }

    /**
     * Spawns the arraylist of magic strings
     * @param e arraylist of enemies
     * @param offset spawning offset
     */
    private void spawn(ArrayList<String> e, double offset) {
        spawn(e, offset, 2);
    }

    /**
     * Spawns the arraylist of magic strings
     * @param enemies arraylist of enemies
     * @param offset spawning offset
     * @param delay spawning delay
     */
    private void spawn(ArrayList<String> enemies, double offset, int delay) {

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

    /**
     * Get level of world
     * @return level
     */
    public int getLevel() {
        return level;
    }
}
