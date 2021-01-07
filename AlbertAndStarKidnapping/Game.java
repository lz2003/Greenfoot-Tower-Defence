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
    
    public Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 800, 1, false); 
        
        setPaintOrder(God.class, SlotSprite.class);
        
        Global.setWorld(this);
        
        manager = new ObjectManager();
        
        Global.manager = manager;
        
        manager.init();
    }
    
    public void init() {
        
    }
    
    public void act() {
        manager.update();
    }
}
