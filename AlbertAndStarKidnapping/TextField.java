import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A label that displays text and has a value that can be updated.
 * 
 * @author Young Chen 
 * @version 2021
 */
public class TextField extends Label
{
    private int x, y;
    float value = 0;
    String prefix = "";
    
    /**
     * Constructor for class TextField.
     * @param x The x coordinate of the TextField.
     * @param y The y coordinate of the TextField.
     * @param prefix The text to be displayed before the value.
     */
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
    
    /**
     * Keeps actor to the right of coordinates passed through constructor
     */
    protected void updateLoc() {
        int xLoc = x + getImage().getWidth() / 2;
        setLocation(xLoc, getY());
    }
    
    /**
     * Gets the value that needs to be displayed.
     */
    protected float getValue() {
        return 0;
    }
}
