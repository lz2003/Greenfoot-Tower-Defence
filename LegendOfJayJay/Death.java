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
    private GreenfootSound deathMusic = new GreenfootSound("sounds/music/sadMusic.mp3");
    /**
     * Creates the Death screen
     */
    public Death()
    {    
       super(Game.worldWidth, Game.worldHeight, 1);
       next = new TextButton(" Return to Home ", 50);
       bg = new Character(new GreenfootImage("images/deathMusic.png"));
       addObject(bg, getWidth() / 2, getHeight() / 2);
       addObject(next, getWidth() / 2, getHeight() - 100);
       deathMusic = new GreenfootSound("sounds/music/sadMusic.mp3");
    }

    /**
     * Actor act method
     */
    public void act() {
        SoundManager.playSound(deathMusic);
        if(Greenfoot.mouseClicked(next)) {
            SoundManager.uiSounds(0);
            SoundManager.stopSound(deathMusic);
            Greenfoot.setWorld(new Start());
        }
    }
}
