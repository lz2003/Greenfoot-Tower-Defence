import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends World
{
    private ObjectManager manager;
    private Canvas canvas;
    TowerText towerText;
    TowerLevel towerLevel;
    public Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(850, 600, 1, false); 
        
        setPaintOrder(Canvas.class);
        
        Global.setWorld(this);
        
        canvas = new Canvas(20, getWidth(), getHeight());
        
        Sprite.setGlobalCanvas(canvas);
        
        manager = new ObjectManager();
        
        Global.manager = manager;
        
        manager.init();
        
<<<<<<< Updated upstream
        addObject(canvas, getWidth() / 2, getHeight() / 2);
=======
        addObject(canvas, 850 / 2, getHeight() / 2 - 75);
        
        int labelY = 620;
        
        addObject(new MoneyText(5, labelY), 5 , labelY);
        
        labelY += 30;
        addObject(new LevelText(5, labelY), 5 , labelY);
        //CircleMask test = new CircleMask(400, 400, 400);
        towerText = new TowerText(400, 620);
        addObject(towerText, 400, 620);
        towerLevel = new TowerLevel(400, 650);
        addObject(towerLevel, 400, 650);
        
        
        init();
>>>>>>> Stashed changes
    }
    
    public void init() {
        
    }
    
    public void act() {
        manager.update();
        //canvas.setLocation(canvas.getX() + 1, canvas.getY());
    }
}
