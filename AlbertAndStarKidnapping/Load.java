import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World to load previous game or to create a new game
 *
 * @author Young Chen
 * @version 2021-01-26
 */
public class Load extends World
{
    TextButton load, useNew;
    Character bg;
    private boolean isStory;

    /**
     * Creates load screen
     * @param isStory whether or not game is in story mode
     */
    public Load(boolean isStory)
    {    
        super(Game.worldWidth, Game.worldHeight, 1); 
        
        load = new TextButton(" Load existing game ", 40);
        useNew = new TextButton(" Create new game ", 40);
        bg = new Character(new GreenfootImage("images/start.png"));
        
        addObject(bg, getWidth() / 2, getHeight() / 2);
        addObject(load, 250, getHeight() / 2);
        addObject(useNew, getWidth() - 250, getHeight() / 2);
        this.isStory = isStory;
    }

    /**
     * Actor act method
     */
    public void act() {
        if(Greenfoot.mouseClicked(load)) {
            Greenfoot.setWorld(new Game(false, isStory));
            ReadButton.read();
        }
        
        if(Greenfoot.mouseClicked(useNew)) {
            Greenfoot.setWorld(new Select(isStory));
        }
    }
}
