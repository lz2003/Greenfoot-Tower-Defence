import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.core.WorldHandler;  
import java.io.IOException;
import java.io.File;
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends World
{
    public static final int canvasWidth = 850, canvasHeight = 600;
    public static final int worldWidth = 925, worldHeight = 750;
    private ObjectManager manager;
    private Canvas canvas;
    CircleMask mask;
    TowerDisplay towerDisplay;
    private boolean isCampaign;
    private boolean isEditor;
    
    public Game() {    
        this(false, true);
    }
    
    public Game(boolean autoLoad, boolean isCampaign) {
        this(autoLoad, isCampaign, false);
    }
    
    public Game(boolean autoload, boolean isCampaign, boolean editor) {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(worldWidth, worldHeight, 1, false); 
        
        setPaintOrder(DissappearingText.class, BuildCursor.class, Canvas.class);
        
        Global.setWorld(this);
        
        canvas = new Canvas(15, canvasWidth, canvasHeight);
        
        Sprite.setGlobalCanvas(canvas);
        
        manager = new ObjectManager(editor);
        
        Global.manager = manager;
        
        manager.init();
        
        addObject(canvas, 850 / 2, getHeight() / 2 - 75);
        
        int labelY = 620;
        
        addObject(new MoneyText(5, labelY), 5 , labelY);
        
        labelY += 30;
        addObject(new LevelText(5, labelY), 5 , labelY);

        //towerText = new TowerText(400, 620);
        //addObject(towerText, 400, 620);
        //towerLevel = new TowerLevel(400, 650);
        //addObject(towerLevel, 400, 650);
        
        towerDisplay = new TowerDisplay();
        addObject(towerDisplay, 600, 660);
        
        int y = 715;
        
        addObject(new HomeButton(), 45, y);
        addObject(new FastForwardButton(), 45 + 75 + 10, y);
        addObject(new SaveButton(), 45 + 75 + 75 + 20, y);
        addObject(new ReadButton(), 45 + 75 + 75 + + 75 + 30, y);
        
        mask = new CircleMask();
        
        setBackground("bkg.png");
        
        this.isCampaign = isCampaign;
        this.isEditor = editor;
        
        init();
        
        if(autoload) {
            try {
                SavedInstance.read(SavedInstance.AUTO_SAVE_PATH);
                Global.getManager().getSpawner().spawnLevel(Global.getManager().getSpawner().getLevel());
            } catch(IOException e) {
            }
        }
    }
    
    public void init() {
        ButtonGrid b = new ButtonGrid();
        addObject(b, 887, 45);
        
        Button[] buttons;
        
        if(!isEditor)
            buttons = new Button[]{
                new TowerButton(TowerButton.ARCH),
                new TowerButton(TowerButton.ARTY),
                new TowerButton(TowerButton.BARA),
                new TowerButton(TowerButton.FIRE),
                new TowerButton(TowerButton.ICE),
                new TowerButton(TowerButton.LAZER),
                new TowerButton(TowerButton.MINE),
                new TowerButton(TowerButton.PILL),
            };
        else 
            buttons = new Button[]{
                new TowerButton(TowerButton.ARCH),
                new TowerButton(TowerButton.ARTY),
                new TowerButton(TowerButton.BARA),
                new TowerButton(TowerButton.FIRE),
                new TowerButton(TowerButton.ICE),
                new TowerButton(TowerButton.LAZER),
                new TowerButton(TowerButton.MINE),
                new TowerButton(TowerButton.PILL),
                new TowerButton(TowerButton.WALL)
            };

        b.set(
            buttons, 1, 10, 77
        );
        
        BuildCursor.init();
    }

    public void act() {
        manager.update();
    }
    
    public boolean isCampaign() {
        return isCampaign;
    }
    
    public boolean isEditor() {
        return isEditor;
    }
    
   public void updateMask(Tower tower){
        mask.show(tower);
    }
}
