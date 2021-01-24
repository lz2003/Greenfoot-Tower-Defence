import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.IOException;
import java.time.LocalDateTime;
import java.io.File;
import java.time.format.DateTimeFormatter;

/**
 * Write a description of class HomeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SaveButton extends ImageButton
{
    private static final GreenfootImage image = new GreenfootImage("images/buttons/save/saveUnpressed.png");
    public static final String SAVE_DIR = "save";
    public static final String EXT = "owo";
    
    public SaveButton() {
        super(image);
    }
    
    public void onPress() {
        SavedInstance s = new SavedInstance(Global.getManager());
        try {
            s.save(SAVE_DIR + File.separator + "save-" + getTime() + "." + EXT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String getTime() {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
        LocalDateTime currentDate = LocalDateTime.now();
        return currentDate.format(date);
    }
}
