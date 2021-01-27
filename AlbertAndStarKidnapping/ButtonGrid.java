import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Flowing grid for buttons
 *
 * @author Young Chen
 * @version 2021-01-26
 */
public class ButtonGrid extends Actor
{
    /**
     * Adds the buttons to world in the grid
     * @param buttons Array of buttons
     * @param width buttons per row
     * @param height buttons per column
     * @param gap gap between buttons
     */
    public void set(Button[] buttons, int width, int height, int gap) {
        int count = 0;
        int max = buttons.length;
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width && count < max; x++, count++) {
                getWorld().addObject(buttons[count], getX() + gap * x, getY() + gap * y);
            }
        }
    }

    /**
     * Adds the buttons to world in the grid
     * @param buttons Array of buttons
     * @param width buttons per row
     * @param height buttons per column
     * @param gapX horizontal gap between buttons
     * @param gapY vertical gap between buttons
     */
    public void set(Button[] buttons, int width, int height, int gapX, int gapY) {
        int count = 0;
        int max = buttons.length;
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width && count < max; x++, count++) {
                getWorld().addObject(buttons[count], getX() + gapX * x, getY() + gapY * y);
            }
        }
    }
}
