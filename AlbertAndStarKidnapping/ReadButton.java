import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
/**
 * Write a description of class HomeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReadButton extends ImageButton
{
    private static final GreenfootImage image = new GreenfootImage("images/buttons/load/loadUnpressed.png");
    
    public ReadButton() {
        super(image);
    }
    
    public void onPress() {
        read();
    }
    
    public static void read() {
        try {
            File save = new File(SaveButton.SAVE_DIR);

            File f = chooseFile(save);
            if(f != null) {
                Global.getManager().reset();
                SavedInstance.read(f.toString());
            }
        } catch(IOException e) {
        
        }
    }
    
    public static File chooseFile(File start) {
        JFileChooser chooser = new JFileChooser(start);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Save File", SaveButton.EXT);
        chooser.setFileFilter(filter);
        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        else{
            return null;
        }
    }
}