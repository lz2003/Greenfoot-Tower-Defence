import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.core.WorldHandler;  
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
    private ObjectManager manager;
    private Canvas canvas;
    private CircleMask mask;
    TowerText towerText;
    TowerLevel towerLevel;
    public Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(925, 750, 1, false); 
        
        setPaintOrder(DissappearingText.class, BuildCursor.class, Canvas.class);
        
        Global.setWorld(this);
        
        canvas = new Canvas(15, canvasWidth, canvasHeight);
        
        Sprite.setGlobalCanvas(canvas);
        
        manager = new ObjectManager();
        
        Global.manager = manager;
        
        manager.init();
        
        addObject(canvas, 850 / 2, getHeight() / 2 - 75);
        
        int labelY = 620;
        
        addObject(new MoneyText(5, labelY), 5 , labelY);
        
        labelY += 30;
        addObject(new LevelText(5, labelY), 5 , labelY);

        towerText = new TowerText(400, 620);
        addObject(towerText, 400, 620);
        towerLevel = new TowerLevel(400, 650);
        addObject(towerLevel, 400, 650);
        
        addObject(new HomeButton(), 45, 705);
        addObject(new FastForwardButton(), 45 + 75 + 10, 705);
        addObject(new SaveButton(), 45 + 75 + 75 + 20, 705);
        addObject(new ReadButton(), 45 + 75 + 75 + + 75 + 30, 705);
        
        mask = new CircleMask();
        init();
    }
    
    public void init() {
        ButtonGrid b = new ButtonGrid();
        addObject(b, 887, 45);
        b.set(
            new Button[]{
            new TowerButton(TowerButton.ARCH),
            new TowerButton(TowerButton.ARTY),
            new TowerButton(TowerButton.BARA),
            new TowerButton(TowerButton.FIRE),
            new TowerButton(TowerButton.ICE),
            new TowerButton(TowerButton.LAZER),
            new TowerButton(TowerButton.MINE),
            new TowerButton(TowerButton.PILL),
            }, 1, 8, 77
        );
        
        BuildCursor.init();
    }
    
    public void act() {
        manager.update();
    }
}
