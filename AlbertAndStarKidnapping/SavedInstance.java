import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
/**
 * Write a description of class SaveGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SavedInstance 
{
    public static final String
        FIELD_LEVEL = "Level",
        FIELD_MONEY = "Money",
        FIELD_TOWER = "Towers",
        FIELD_LOC = "Location",
        START = "{",
        END = "}",
        SEP = "=",
        LOC_SEP = ",",
        TOWER_SEP = ":",
        FIELD_SEP = ";"
    ;

    public static final String
        ARCHER = "Archer",
        CANNON = "Cannon",
        BARRACKS = "Barracks",
        FIREBALL = "FireballTower",
        ICEBALL = "IceeballTower",
        LASER = "LaserTower",
        MINES = "Mines",
        PILLBOX = "PillBox",
        WALL = "Wall",
        EMPTY = "Empty"
    ;

    int level;
    float money;
    ArrayList<Tower> towers;
    int width, height;
    /**
     * Constructor for objects of class SaveGame
     */
    public SavedInstance(ObjectManager m) {
        Spawner spawner = m.getSpawner();
        int level = spawner.getLevel();
        
        float money = m.getMoney();
        
        ArrayList<Tower> towers = m.getTowers();

        width = m.getNodes().length;
        height = m.getNodes()[0].length;

        this.level = level;
        this.money = money;
        this.towers = towers;
    }

    public void save(String file) throws IOException {
        File f = new File(file);

        if(!f.createNewFile()) {
            //System.out.println("File already exists");
            //return;
        }

        PrintWriter writer = new PrintWriter(f);
        
        writer.println(FIELD_LEVEL + SEP + this.level + END);
        writer.println(FIELD_MONEY + SEP + this.money + END);
        writer.print(FIELD_TOWER + SEP + START);

        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                writer.println();

                Tower t = getTowerAtIndex(towers, x, y);

                // writer.print(FIELD_LOC + SEP + x + LOC_SEP + y + TOWER_SEP);
                writer.print(FIELD_LOC + SEP + x + LOC_SEP + y + FIELD_SEP);
  
                
                if(t == null) {
                    writer.print(FIELD_LEVEL + SEP + 0 + TOWER_SEP);
                    writer.print(EMPTY);
                } else {
                    writer.print(FIELD_LEVEL + SEP + t.getLevel() + TOWER_SEP);
                    if(t instanceof ArcherTower) {
                        writer.print(ARCHER);
                    }
                    else if(t instanceof Artillery) {
                        writer.print(CANNON);
                    }
                    else if(t instanceof Barracks) {
                        writer.print(BARRACKS);
                    }
                    else if(t instanceof FireballTower) {
                        writer.print(FIREBALL);
                    }
                    else if(t instanceof IceballTower) {
                        writer.print(ICEBALL);
                    }
                    else if(t instanceof LazerTower) {
                        writer.print(LASER);
                    }
                    else if(t instanceof Mines) {
                        writer.print(MINES);
                    }
                    else if(t instanceof Pillbox) {
                        writer.print(PILLBOX);
                    }
                    else if(t instanceof Wall) {
                        writer.print(WALL);
                    } 
                    else {
                        writer.print(EMPTY);
                    }
                }
            }
        }
        writer.println();
        writer.println(END);
        writer.close();
    }

    private static final int
        STATE_SINGLE = 0,
        STATE_TOWERS = 1
    ;



    public static void read(String file) throws IOException {
        Scanner scan = new Scanner(new File(file));

        int state = STATE_SINGLE;

        float money = 0;
        int level = 0;

        ArrayList<Tower> towers = new ArrayList<Tower>();

        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            switch(state) {

                case STATE_SINGLE: {
                    String start = line.substring(0, line.indexOf(SEP));
                    switch(start) {
                        case FIELD_LEVEL:
                            try {
                                String num = line.substring(line.indexOf(SEP) + 1, line.indexOf(END));
                                int l = Integer.parseInt(num);
                                level = l;
                            } catch (NumberFormatException e) {}
                            break;
                        case FIELD_MONEY:
                            try {
                                String num = line.substring(line.indexOf(SEP) + 1, line.indexOf(END));
                                float l = Float.parseFloat(num);
                                money = l;
                            } catch (NumberFormatException e) {}
                            break;
                        case FIELD_TOWER:
                            state = STATE_TOWERS;
                            break;
                    }
                    break;
                }

                case STATE_TOWERS: {
                    if(line.equals(END)) {
                        state = STATE_SINGLE;    
                        break;
                    }
                    // writer.print(FIELD_LOC + SEP + x + LOC_SEP + y + TOWER_SEP);
                    String locFull = line.substring(line.indexOf(SEP) + 1, line.indexOf(FIELD_SEP)); // x + LOC_SEP + y

                    String[] split = locFull.split(LOC_SEP);

                    int x = Integer.parseInt(split[0]);
                    int y = Integer.parseInt(split[1]);

                    String levelField = FIELD_LEVEL + SEP;
                    
                    String levelStr = line.substring(line.indexOf(levelField) + levelField.length(), line.indexOf(TOWER_SEP));

                    int towerLevel = Integer.parseInt(levelStr);
                    
                    String tower = line.substring(line.indexOf(TOWER_SEP) + 1);

                    boolean valid = false;

                    switch(tower) {
                        case ARCHER:
                            new ArcherTower(getLoc(x), getLoc(y), x, y, towerLevel);
                            break;
                        case CANNON:
                            new Artillery(getLoc(x), getLoc(y), x, y, towerLevel);
                            break;
                        case BARRACKS:
                            new Barracks(getLoc(x), getLoc(y), x, y, towerLevel);
                            break;
                        case FIREBALL:
                            new FireballTower(getLoc(x), getLoc(y), x, y, towerLevel);
                            break;
                        case ICEBALL:
                            new IceballTower(getLoc(x), getLoc(y), x, y, towerLevel);
                            break;
                        case LASER:
                            new LazerTower(getLoc(x), getLoc(y), x, y, towerLevel);
                            break;
                        case MINES:
                            new Mines(getLoc(x), getLoc(y), x, y, towerLevel);
                            break;
                        case PILLBOX:
                            new Pillbox(getLoc(x), getLoc(y), x, y, towerLevel);
                            break;
                        case WALL:
                            new Wall(getLoc(x), getLoc(y), x, y, towerLevel);
                            break;
                    }
                    break;
                }
            }
        }
        Global.getManager().setLevel(level);
        Global.getManager().setMoney(money);
        scan.close();
    }

    private static int getLoc(int x) {
        return Global.SLOT_SIZE * x + Global.SLOT_SIZE / 2;
    }

    public static Tower getTowerAtIndex(ArrayList<Tower> towers, int x, int y) {
        for(int i = 0; i < towers.size(); i++) {
            Tower tower = towers.get(i);
            if(tower.getIX() == x && tower.getIY() == y) {
                return tower;
            }
        }
        return null;
    }
}
