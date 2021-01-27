import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class ButtonGrid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButtonGrid extends Actor
{
    public void set(Button[] buttons, int width, int height, int gap) {
        int count = 0;
        int max = buttons.length;
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width && count < max; x++, count++) {
                getWorld().addObject(buttons[count], getX() + gap * x, getY() + gap * y);
            }
        }
    }
    
    public void set(Button[] buttons, int width, int height, int gapX, int gapY) {
        int count = 0;
        int max = buttons.length;
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width && count < max; x++, count++) {
                getWorld().addObject(buttons[count], getX() + gapX * x, getY() + gapY * y);
            }
        }
    }
    /**
     * Act - do whatever the ButtonGrid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
