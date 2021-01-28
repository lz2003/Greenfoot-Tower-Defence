import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button that allows the user to select a tower to place down on the map.
 * 
 * @author Young Chen
 * @version 2021
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
        
    /**
     * Constructor for TowerButton class
     * @param towerID   The ID of the tower to be displayed
     */
    public TowerButton(int towerID) {
        //set the image of the button to be the icon of the tower with that towerID
        setImage(icons[towerID]);
        //Scale the icon to the correct size
        getImage().scale(SIZE + 6, SIZE + 13);
        //Set the towerID
        this.towerID = towerID;
    }
    
    /**
     * Display the cost upon adding the TowerButton to the world.
     */
    public void addedToWorld(World w) {
        int cost = 0;
        //Assign a cost to the button based on its towerID
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
        //Convert the cost into a String
        String s = Integer.toString((int)cost);
        //Determine the x and y coordinate of the cost string based on the number of digits in the cost
        int x = s.length() == 3 ? getX() - getImage().getWidth() / 2 + 7 : getX() - getImage().getWidth() / 2 - 1;
        x = s.length() == 2 ? getX() - getImage().getWidth() / 2 + 14: x;
        int y = getY() + 32;
        //display the cost
        getWorld().addObject(new TowerTextDisplay(x, y, s), x, y);
    }
    
    /**
     * Update the state of the TowerButton.
     */   
    public void onPress()
    {
        BuildCursor.setState(towerID);
    }
}

/**
 * Displays the cost text.
 * @author Young Chen
 * @version 2021
 */
class TowerTextDisplay extends TextField {
    /**
     * Constructor for TowerTextDisplay class.
     * @param x   The x coordinate of the text.
     * @param y   The y coordinate of the text.
     * @param pre The string to be displayed. 
     */
    public TowerTextDisplay(int x, int y, String pre) {
        super(x, y, pre);
        setValue(pre);
    }
    
    /**
     * Adjust its location when added to world.
     */
    public void addedToWorld(World w) {
        updateLoc();
    }
    
    /**
     * Updates the TowerTextDisplay.
     */
    public void act() {}
}
