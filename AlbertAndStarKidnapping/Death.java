import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Death here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Death extends World
{
    private TextButton next;
    Character bg;
    /**
     * Constructor for objects of class Death.
     * 
     */
    public Death()
    {    
       super(Game.worldWidth, Game.worldHeight, 1);
       next = new TextButton(" Return to Home ", 50);
       bg = new Character(new GreenfootImage("images/death.png"));
       addObject(bg, getWidth() / 2, getHeight() / 2);
       addObject(next, getWidth() / 2, getHeight() - 100);
    }
    
    public void act() {
        if(Greenfoot.mouseClicked(next)) {
            Greenfoot.setWorld(new Start());
        }
    }
}
