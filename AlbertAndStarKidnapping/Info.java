import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Info here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Info extends World
{
    private ArrayList<GreenfootImage> displays;
    private int index = 0;
    private TextButton next;
    private Character currDisplay;
    /**
     * Constructor for objects of class Info.
     * 
     */
    public Info()
    {    
        super(Game.worldWidth, Game.worldHeight, 1); 
        
        next = new TextButton(" Continue ", 30);
        displays = new ArrayList<GreenfootImage>();
        // Placeholders
        displays.add(new GreenfootImage("images/start.png"));
        displays.add(new GreenfootImage("images/god.png"));
        currDisplay = new Character(displays.get(0));
        addObject(currDisplay, getWidth() / 2, getHeight() / 2);
        addObject(next, getWidth() / 2, getHeight() - 100);
        
    }
    
    public void act() {
        if(Greenfoot.mouseClicked(next)) {
            index++;
            if (index > displays.size()-1) {
                Greenfoot.setWorld(new Start());
            } else {
                currDisplay.updateImage(displays.get(index));
            }
        }
    }
}
