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
        new GreenfootImage("archericon.png"),
        new GreenfootImage("artyicon.png"),
        new GreenfootImage("barackicon.png"),
        new GreenfootImage("fireicon.png"),
        new GreenfootImage("icyicon.png"),
        new GreenfootImage("lazericon.png"),
        new GreenfootImage("meinicon.png"),
        new GreenfootImage("pillicon.png"),
    };
    
    public static final int SIZE = 70;
    
    public static final int 
        ARCH = 0,
        ARTY = 1,
        BARA = 2,
        FIRE = 3,
        ICE = 4,
        LAZER = 5,
        MINE = 6,
        PILL = 7;
        
    private int towerID;
        
    public TowerButton(int towerID) {
        setImage(icons[towerID]);
        getImage().scale(SIZE, SIZE);
        this.towerID = towerID;
        /*
        switch(towerID) {
            case ARCH:
                setImage(icons[towerID]);
                break;
            case ARTY:
                setImage(icons[towerID]);
                break;
            case BARA:
                setImage(icons[towerID]);
                break;
            case FIRE:
                setImage(icons[towerID]);
                break;
            case ICE:
                setImage(icons[towerID]);
                break;
            case LASER:
                setImage(icons[towerID]);
                break;
            case MINE:
                setImage(icons[towerID]);
                break;
            case PILL:
                setImage(icons[towerID]);
                break;
        }
        */
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
