import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A progress bar.
 * 
 * @author Ryan Lin
 * @version 2021
 */
public class Bar extends Actor
{
    private int width, height, value, maxValue;
    private float pixelPerValue;
    private Color fillColor, bgColor;
    private static final Color TRANSPARENT = new Color(0,0,0,0);
    private boolean displayText;
    
    /**
     * Constructor for class Bar.
     * @param width     The width of the bar.
     * @param height    The height of the bar.
     * @param maxValue  The maximum value of the bar.
     */
    public Bar(int width, int height, int maxValue)
    {
        this(width, height, maxValue, false);
    }
    
    /**
     * Constructor for class Bar that displays numerical text showing the progress.
     * @param width         The width of the bar.
     * @param height        The height of the bar.
     * @param maxValue      The maximum value of the bar.
     * @param displayText   If the bar will display the numerical text. 
     */
    public Bar(int width, int height, int maxValue, boolean displayText)
    {
        this(width, height, 0, maxValue, Color.GREEN, Color.WHITE, displayText);
    }
    
    /**
     * Constructor for class Bar that is color-customizable.
     * @param width         The width of the bar.
     * @param height        The height of the bar.
     * @param maxValue      The maximum value of the bar.
     * @param fillColor     The color of progress.
     * @param bgColor       The background color of the bar.
     * @param displayText   If the bar will display the numerical text. 
     */
    public Bar(int width, int height, int startValue, int maxValue, Color fillColor, Color bgColor, boolean displayText)
    {
        this.width = width;
        this.height = height;
        this.value = startValue;
        this.maxValue = maxValue;
        this.fillColor = fillColor;
        this.bgColor = bgColor;
        this.pixelPerValue = width / (float) maxValue;
        this.displayText = displayText;
    }
    
    /**
     * Called when the Bar is added to the World.
     */
    public void addedToWorld(World world)
    {
        drawImage();
    }
    
    /**
     * Set the value of the progress bar.
     * @param value The value to set the progress bar to.
     */
    public void setValue(int value)
    {
        this.value = value;
        drawImage();
    }
    
    /**
     * Draw the progress bar image.
     */
    public void drawImage()
    {
        //Draw the background of the bar
        GreenfootImage base = new GreenfootImage(width, height);
        base.setColor(bgColor);
        base.fill();
        //Draw the progress rectangle on top of the bar background
        GreenfootImage overlay = new GreenfootImage(Math2D.clamp((int)(pixelPerValue * value), 1, width), height);
        overlay.setColor(fillColor);
        overlay.fill();
        base.drawImage(overlay, 0, 0);
        //if display text is enabled, draw the numerical value over the bar
        if(displayText){
            GreenfootImage text = new GreenfootImage(value+"/"+maxValue, height, Color.BLACK, TRANSPARENT, Color.BLACK);
            base.drawImage(text, base.getWidth()/4, 0);
        }
        //update the progress bar image
        setImage(base);
    } 
}
