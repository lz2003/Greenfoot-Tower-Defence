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
    
    private static GreenfootSound START = null;

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
        START = null;

        addObject(bg, getWidth() / 2, getHeight() / 2);
        addObject(campaign, getWidth() / 2, getHeight() / 2);
        addObject(regular, getWidth() / 2, getHeight() / 2 + 70);
        addObject(editor, getWidth() / 2, getHeight() / 2 + 210);
        addObject(info, getWidth() / 2, getHeight() / 2 + 140);
    }
    
    /**
     * Make music equal to null in order to prevent javazoom error
     */
    public void started() {
        START = null;
    }
    
    /**
     * Stop music
     */
    public void stopped() {
        SoundManager.stopSound(START);
    }
    
    /**
     * Actor act method
     */
    public void act() { 
        if (START == null) {
            START = new GreenfootSound("sounds/music/start.mp3");
        } else {
            SoundManager.playSound(START);
        }
        if(Greenfoot.mouseClicked(campaign)) {
            SoundManager.uiSounds(0);
            Greenfoot.setWorld(new Load(true, START));
        }
        
        if(Greenfoot.mouseClicked(regular)) {
            SoundManager.uiSounds(0);
            Greenfoot.setWorld(new Load(false, START));
        }
        
        if(Greenfoot.mouseClicked(editor)) {
            SoundManager.uiSounds(0);
            SoundManager.stopSound(START);
            Greenfoot.setWorld(new Game(false, false, true));
        }
        
        if(Greenfoot.mouseClicked(info)) {
            SoundManager.uiSounds(0);
            SoundManager.stopSound(START);
            Greenfoot.setWorld(new Info());
        }
        
    }
}
