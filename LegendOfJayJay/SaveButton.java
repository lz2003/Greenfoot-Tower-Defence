import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.IOException;
import java.time.LocalDateTime;
import java.io.File;
import java.time.format.DateTimeFormatter;

/**
 * Saves the current game.
 * 
 * @author Young Chen 
 * @version 2021
 */
public class SaveButton extends ImageButton
{
    private static final GreenfootImage image = new GreenfootImage("images/buttons/save/saveUnpressed.png");
    public static final String SAVE_DIR = "save";
    public static final String EXT = "owo";
    
    /**
     * Constructor for SaveButton class.
     */
    public SaveButton() {
        super(image);
    }
    
    /**
     * Action when the button is pressed.
     */
    public void onPress() {
        save();
    }
    
    /**
     * Saves the current game.
     */
    public static void save() {
        SavedInstance s = new SavedInstance(Global.getManager());
        try {
            String name = SAVE_DIR + File.separator + "save_" + getTime() + "." + EXT;
            s.save(name);
            new DissappearingText("Saved progress in " + name, 425, 30);
        } catch (IOException e) {
            new DissappearingText("Unable to save progress.", 425, 30);
        }
    }
    
    /**
     * Get the current time in a String format.
     */
    public static String getTime() {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        LocalDateTime currentDate = LocalDateTime.now();
        return currentDate.format(date);
    }
}
