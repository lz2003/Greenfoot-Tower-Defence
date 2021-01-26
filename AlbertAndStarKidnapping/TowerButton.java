import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TowerButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowerButton extends Button
{
    public static final GreenfootImage[] icons = {
        new GreenfootImage("images/shop/ArcherIcon.png"),
        new GreenfootImage("images/shop/CannonIcon.png"),
        new GreenfootImage("images/shop/BarbarianHutCard.png"),
        new GreenfootImage("images/shop/WizardIcon.png"),
        new GreenfootImage("images/shop/IceWizardIcon.png"),
        new GreenfootImage("images/shop/TeslaIcon.png"),
        new GreenfootImage("images/shop/GoldMineCard.png"),
        new GreenfootImage("images/shop/PillBoxIcon.png"),
        new GreenfootImage("images/shop/WallIcon.png")
    };
    
    public static final int SIZE = 60;
    
    public static final int 
        IDLE = -1,
        ARCH = 0,
        ARTY = 1,
        BARA = 2,
        FIRE = 3,
        ICE = 4,
        LAZER = 5,
        MINE = 6,
        PILL = 7,
        WALL = 8;
        
    private int towerID;
        
    public TowerButton(int towerID) {
        setImage(icons[towerID]);
        getImage().scale(SIZE + 6, SIZE + 13);
        this.towerID = towerID;
    }
    
    public void addedToWorld(World w) {
        int cost = 0;
        /*
         *     public static final int 
        COST_ARCHER = 150,
        COST_CANNON = 100,
        COST_BARRACKS = 800,
        COST_FIREBALL = 500,
        COST_ICEBALL = 450,
        COST_LASER = 650,
        COST_MINES = 100,
        COST_PILLBOX = 900;
        
         */
        switch(towerID) {
            case ARCH:
                cost = Tower.COST_ARCHER;
                break;
            case ARTY:
                cost = Tower.COST_CANNON;
                break;
            case BARA:
                cost = Tower.COST_BARRACKS;
                break;
            case FIRE:
                cost = Tower.COST_FIREBALL;
                break;
            case ICE:
                cost = Tower.COST_ICEBALL;
                break;
            case LAZER:
                cost = Tower.COST_LASER;
                break;
            case MINE:
                cost = Tower.COST_MINES;
                break;
            case PILL:
                cost = Tower.COST_PILLBOX;
                break;
            case WALL:
                cost = 0;
                break;
        }

        String s = Integer.toString((int)cost);

        int x = s.length() == 3 ? getX() - getImage().getWidth() / 2 + 7 : getX() - getImage().getWidth() / 2 - 1;
        int y = getY() + 32;
        
        getWorld().addObject(new TowerTextDisplay(x, y, s), x, y);
    }
    /**
     * Act - do whatever the TowerButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) {
            BuildCursor.setState(towerID);
        }
        /*
        switch(towerID) {
            case ARCH:
               
                break;
            case ARTY:
               
                break;
            case BARA:
                
                break;
            case FIRE:
               
                break;
            case ICE:
                
                break;
            case LAZER:
                
                break;
            case MINE:
                
                break;
            case PILL:
               
                break;
        }
        */
    }    
}

class TowerTextDisplay extends TextField {
    public TowerTextDisplay(int x, int y, String pre) {
        super(x, y, pre);
        setValue(pre);
    }
    
    public void addedToWorld(World w) {
        updateLoc();
    }
    
    public void act() {}
}
