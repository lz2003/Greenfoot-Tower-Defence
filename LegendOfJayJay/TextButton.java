import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Generic Button to display text that is clickable. Owned by a World, which controls click
 * capturing.
 * 
 * @author Jordan Cohen
 * @author Young Chen
 * @version 2020-12-16
 */
public class TextButton extends Actor
{
    // Declare private variables
    private GreenfootImage myImage;
    private String buttonText;
    private Color textColour = Color.BLACK,
    backgroundColour = new Color(120, 190, 255);
    private int textSize;

    /**
     * Construct a TextButton with a given String at the default size
     * 
     * @param text  String value to display
     * 
     */
    public TextButton (String text)
    {
        this(text, 20);
    }
    
    

    /**
     * Construct a TextButton with a given String and a specified size
     * 
     * @param text  String value to display
     * @param textSize  size of text, as an integer
     * 
     */
    public TextButton (String text, int textSize)
    {
        buttonText = text;
        GreenfootImage tempTextImage = new GreenfootImage (text, textSize, textColour, backgroundColour);
        myImage = new GreenfootImage (tempTextImage.getWidth() + 4, tempTextImage.getHeight() + 4);
        myImage.setColor (new Color(40, 40, 130));
        myImage.fill();
        myImage.drawImage (tempTextImage, 2, 2);
        this.textSize = textSize;
        //myImage.setColor (Color.BLACK);
        //myImage.drawRect (0,0,tempTextImage.getWidth() + 0, tempTextImage.getHeight() + 7);
        setImage(myImage);
    }

    /**
     * Change the text displayed on this Button
     * 
     * @param   text    String to display
     * 
     */
    public void update (String text)
    {
        buttonText = text;
        GreenfootImage tempTextImage = new GreenfootImage (text, textSize, textColour, backgroundColour);
        myImage = new GreenfootImage (tempTextImage.getWidth() + 4, tempTextImage.getHeight() + 4);
        myImage.setColor (new Color(40, 40, 130));
        myImage.fill();
        myImage.drawImage (tempTextImage, 2, 2);


        setImage(myImage);
    }

    /**
     * Change the background colour
     * 
     * @param   fill    New colour
     */
    public void update (Color fill)
    {
        String text = buttonText;
        GreenfootImage tempTextImage = new GreenfootImage (text, textSize, textColour, backgroundColour);
        myImage = new GreenfootImage (tempTextImage.getWidth() + 4, tempTextImage.getHeight() + 4);
        myImage.setColor (new Color(40, 40, 130));
        myImage.fill();
        myImage.drawImage (tempTextImage, 2, 2);

        setImage(myImage);
    }
}