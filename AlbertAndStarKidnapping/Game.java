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
    public Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 800, 1, false); 
        
        setPaintOrder(Canvas.class, SlotSprite.class);
        
        Global.setWorld(this);
        
        canvas = new Canvas(20, getWidth(), getHeight());
        
        Sprite.setGlobalCanvas(canvas);
        
        manager = new ObjectManager();
        
        Global.manager = manager;
        
        manager.init();
        
        addObject(canvas, getWidth() / 2, getHeight() / 2);
    }
    
    public void init() {
        
    }
    
    public void act() {
        manager.update();
        //canvas.setLocation(canvas.getX() + 1, canvas.getY());
    }
}
