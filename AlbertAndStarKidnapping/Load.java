import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Load here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Load extends World
{
    TextButton load, useNew;
    private boolean useLoad;
    /**
     * Constructor for objects of class Load.
     * 
     */
    public Load(boolean useLoad)
    {    
        super(Game.worldWidth, Game.worldHeight, 1); 
        
        load = new TextButton("Load existing game", 40);
        useNew = new TextButton("Create new game", 40);
        
        addObject(load, 250, getHeight() / 2);
        addObject(useNew, getWidth() - 250, getHeight() / 2);
        this.useLoad = useLoad;
    }
    
    public void act() {
        if(Greenfoot.mouseClicked(load)) {
            Greenfoot.setWorld(new Game(false, useLoad));
            ReadButton.read();
        }
        
        if(Greenfoot.mouseClicked(useNew)) {
            Greenfoot.setWorld(new Game(false, useLoad));
        }
    }
}
