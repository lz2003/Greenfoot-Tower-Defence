import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * The textbox is used to display text and an image. Text is added by the user along with a corresponding image of who/what the text belongs to. 
 * This textbox may have customized colors and able to change the border color. The width and height can be changed to customize the size.
 * The border size can be changed. String can be written on the button, the String, font, and size of the String may be customized.  
 * 
 * @author Rachel Tong  
 * @version Jan 2020
 */
public class Textbox extends Actor
{
    //Coresponding image to be displayed with the text. 
    Character character;
    ArrayList <GreenfootImage> display = new ArrayList<>();
    
    //ArrayList to hold the text and variable to keep track of which text/image is currently being displayed 
    ArrayList<String> dialogue = new ArrayList<>();
    private int currentText = 0;

    //Declare Instance Images
    private GreenfootImage textbox;
    
    //Some constants - can be changed to suit size of related objects
    private int width;
    private int height;
    private int borderThickness;
    
    //Text variables
    private String boxText;
    private Font myFont;
    private int textSize;
    
    //Declare some colour objects
    private Color boxColor;
    private Color borderColor;
    /**
     * 
     * Constructor for Textbox. 
     * Specify a String to be displayed, text font, text size, width and height of textbox, and border thickness.
     * Ability to change color of textbox and border. 
     * Ability to set the corresponding image to be displayed along with the textbox.
     * 
     * @param text              String to be displayed
     * @param fontName          the font of the displayed String
     * @param textSize          the size of the displayed String
     * @param width             the width of the textbox
     * @param height            the height of the textbox
     * @param borderThickness   the thickness of the border. This value should be at least 1. 
     * @param startingColor     the color of the textbox
     * @param borderColor       the color of the border
     * @param image             corresponding character image for the textbox to display who/what the text of the textbox belongs to
     * 
     */
    public Textbox(String text, String fontName, int textSize, int width, int height, int borderThickness, Color boxColor, Color borderColor, GreenfootImage image)
    {
        textbox = new GreenfootImage(width, height);
        
        //sets the starting textbox text and image
        addText(text, image);
        boxText = text;
        
        this.textSize = textSize;
        myFont = new Font(fontName, textSize);
        
        this.width = width;
        this.height = height;
        this.borderThickness = borderThickness;
        
        this.boxColor = boxColor;
        this.borderColor = borderColor;
        
        //draw image
        updateDraw();
        setImage(textbox);
    }
    
    /**
     * Method called when the Textbox is added to the world
     */
    protected void addedToWorld(World world)
    {
        character = new Character(display.get(0));
        getWorld().addObject(character, 425, 400);
    }
    
    /**
     * The purpose of the act method is to make sure the current text and image is displayed
     */
    public void act() 
    {
        updateDraw();
    }
    
    /**
     * Adds text and corresponding image to the end of the arraylist to later be displayed
     * 
     * @param newText   new text to be displayed
     * @param image     corresponding image displayed with added text
     */
    public void addText (String newText, GreenfootImage image)
    {
        dialogue.add(newText);
        display.add(image);
    }
    
    /**
     * Update current displayed String and corresponding image
     */
    public void updateText()
    {
        if(this.getWorld() != null)
        {
            if(currentText < dialogue.size() -1)
            {
                currentText++;
                boxText = dialogue.get(currentText);
                character.updateImage(display.get(currentText));
            }
            else
            {
                character.finish();
                finish();
            }
        }
    }
    
    /**
     * Update current color of textbox
     * 
     * @param newBoxColor replaces textbox color
     */
    public void updateBoxColor (Color newBoxColor)
    {
        boxColor = newBoxColor;
    }
    
    /**
     * Update current Textbox image and text 
     */
    private void updateDraw()
    {
        //set colour of the textbox
        textbox.setColor(boxColor);
        textbox.fill();
        
        //draw border
        textbox.setColor(borderColor);
        for (int i = 0; i < borderThickness; i++)
        {
            textbox.drawRect(i, i, width - 1 - (i * 2), height - 1 - (i * 2));
        }
        
        //draw String to be displayed
        textbox.setFont(myFont);
        textbox.drawString(boxText,(borderThickness * 2), height/2 - (borderThickness * 2) - 5);
    }
    
    /**
     * Removes Textbox from the world 
     */
    private void finish()
    {
        getWorld().removeObject(this);
        Greenfoot.setWorld(new Game(true, true));
    }
}