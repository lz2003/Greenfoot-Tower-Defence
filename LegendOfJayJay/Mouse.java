import greenfoot.*;
/**
 * MouseInfo wrapper class
 * 
 * @author Young Chen
 * @version 2021-01-26
 */
public class Mouse  
{
    private int x, y;
    private boolean down;

    /**
     * Update the mouse information
     */
    public void update() {
        MouseInfo info = Greenfoot.getMouseInfo();
        if(info == null) return;
        
        x = info.getX();
        y = info.getY();
        
        down = info.getButton() > 0;
    }

    /**
     * Get x location of mouse
     * @return x location
     */
    public int getMouseX() {
        return x;
    }

    /**
     * Get y location of mouse
     * @return y location
     */
    public int getMouseY() {
        return y;
    }

    /**
     * Get whether or not the mouse is down
     * @return Whether or not the mouse is down
     */
    public boolean isDown() {
        return down;
    }
}
