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
    private Label moneyLabel = new Label("$", 30);
    private Label moneyValueLabel = new Label(0, 30);
    public Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(925, 750, 1, false); 
        
        setPaintOrder(BuildCursor.class, Canvas.class);
        
        Global.setWorld(this);
        
        canvas = new Canvas(15, canvasWidth, canvasHeight);
        
        Sprite.setGlobalCanvas(canvas);
        
        manager = new ObjectManager();
        
        Global.manager = manager;
        
        manager.init();
        
        addObject(canvas, 850 / 2, getHeight() / 2 - 75);
        
        addObject(moneyLabel, 860 , 10);
        addObject(moneyValueLabel, 885 , 10);
        
        init();
    }
    
    public void init() {
        ButtonGrid b = new ButtonGrid();
        addObject(b, 887, 50);
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
            }, 1, 8, 60
        );
        
        BuildCursor.init();
    }
    
    public void act() {
        manager.update();
        moneyValueLabel.setValue((int)ObjectManager.money);
        //canvas.setLocation(canvas.getX() + 1, canvas.getY());
    }
}
