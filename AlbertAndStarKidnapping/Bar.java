import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A progress bar.
 * 
 * @author Ryan Lin
 * @version (a version number or a date)
 */
public class Bar extends Actor
{
    private int width, height, value, maxValue;
    private float pixelPerValue;
    private Color fillColor, bgColor;
    private static final Color TRANSPARENT = new Color(0,0,0,0);
    private boolean displayText;
    
    public Bar(int width, int height, int maxValue)
    {
        this(width, height, maxValue, false);
    }
    
    public Bar(int width, int height, int maxValue, boolean displayText)
    {
        this(width, height, 0, maxValue, Color.GREEN, Color.WHITE, displayText);
    }
    
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
    
    public void addedToWorld(World world)
    {
        drawImage();
    }
    
    public void setValue(int value)
    {
        this.value = value;
        drawImage();
    }
    
    public void drawImage()
    {
        GreenfootImage base = new GreenfootImage(width, height);
        base.setColor(bgColor);
        base.fill();
        GreenfootImage overlay = new GreenfootImage(Math2D.clamp((int)(pixelPerValue * value), 1, width), height);
        overlay.setColor(fillColor);
        overlay.fill();
        base.drawImage(overlay, 0, 0);
        if(displayText){
            GreenfootImage text = new GreenfootImage(value+"/"+maxValue, height, Color.BLACK, TRANSPARENT, Color.BLACK);
            base.drawImage(text, base.getWidth()/4, 0);
        }
        setImage(base);
    } 
}
