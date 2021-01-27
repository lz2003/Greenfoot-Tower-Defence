import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Death screen
 * 
 * @author Lucy Zhao
 * @version 2021-01-26
 */
public class Death extends World
{
    private TextButton next;
    Character bg;

    /**
     * Creates the death screen
     */
    public Death()
    {    
       super(Game.worldWidth, Game.worldHeight, 1);
       next = new TextButton(" Return to Home ", 50);
       bg = new Character(new GreenfootImage("images/death.png"));
       addObject(bg, getWidth() / 2, getHeight() / 2);
       addObject(next, getWidth() / 2, getHeight() - 100);
    }

    /**
     * Actor act method
     */
    public void act() {
        if(Greenfoot.mouseClicked(next)) {
            Greenfoot.setWorld(new Start());
        }
    }
}
