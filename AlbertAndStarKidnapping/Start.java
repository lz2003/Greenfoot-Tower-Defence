import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Start screen
 *
 * @author Lucy Zhao
 * @author Young Chen
 * @version 2021-01-26
 */
public class Start extends World
{
    TextButton campaign, regular, editor, info;
    Character bg;

    /**
     * Creates the start screen
     */
    public Start()
    {    
        super(Game.worldWidth, Game.worldHeight, 1); 
        
        campaign = new TextButton(" Story Mode ", 50);
        regular = new TextButton(" Regular Game ", 40);
        editor = new TextButton(" Map Editor ", 40);
        info = new TextButton(" Controls & Info ", 40);
        bg = new Character(new GreenfootImage("images/start.png"));

        addObject(bg, getWidth() / 2, getHeight() / 2);
        addObject(campaign, getWidth() / 2, getHeight() / 2);
        addObject(regular, getWidth() / 2, getHeight() / 2 + 70);
        addObject(editor, getWidth() / 2, getHeight() / 2 + 210);
        addObject(info, getWidth() / 2, getHeight() / 2 + 140);
    }

    /**
     * Actor act method
     */
    public void act() { 
        if(Greenfoot.mouseClicked(campaign)) {
            Greenfoot.setWorld(new Load(true));
        }
        
        if(Greenfoot.mouseClicked(regular)) {
            Greenfoot.setWorld(new Load(false));
        }
        
        if(Greenfoot.mouseClicked(editor)) {
            Greenfoot.setWorld(new Game(false, false, true));
        }
        
        if(Greenfoot.mouseClicked(info)) {
            Greenfoot.setWorld(new Info());
        }
    }
}