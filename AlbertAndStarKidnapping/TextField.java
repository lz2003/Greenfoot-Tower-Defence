import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MoneyText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextField extends Label
{
    private int x, y;
    float value = 0;
    String prefix = "";
    public TextField(int x, int y, String prefix) {
        super(0, 30);
        this.x = x;
        this.y = y;
        this.prefix = prefix;
    }
    
    /**
     * Act - do whatever the MoneyText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Don't update if money has not changed
        if(value != Global.getManager().getMoney()) {
            float value = getValue();
            setValue(prefix + (int) value);
            this.value = value;
            updateLoc();
        }
    }    
    
    // Keeps actor to the right of coordinates passed through constructor
    protected void updateLoc() {
        int xLoc = x + getImage().getWidth() / 2;
        setLocation(xLoc, getY());
    }
    
    protected float getValue() {
        return 0;
    }
}
