import greenfoot.*;
/**
 * Write a description of class BetterMouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mouse  
{
    private int x, y;
    private boolean down;
    
    public Mouse() {
    }
    
    public void update() {
        MouseInfo info = Greenfoot.getMouseInfo();
        if(info == null) return;
        
        x = info.getX();
        y = info.getY();
        
        down = info.getButton() > 0;
    }
    
    public int getMouseX() {
        return x;
    }
    
    public int getMouseY() {
        return y;
    }
    
    public boolean isDown() {
        return down;
    }
}
