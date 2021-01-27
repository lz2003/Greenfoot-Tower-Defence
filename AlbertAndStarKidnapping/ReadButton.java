import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
/**
 * Write a description of class ReadButton here.
 * 
 * @author Young Chen
 * @version 2021
 */
public class ReadButton extends ImageButton
{
    private static final GreenfootImage image = new GreenfootImage("images/buttons/load/loadUnpressed.png");
    
    /**
     * Constructor for ReadButton class
     */
    public ReadButton() {
        super(image);
    }
    
    /**
     * Action when button is pressed.
     */
    public void onPress() {
        read();
    }
    
    /**
     * Reads a file
     */
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
    
    /**
     * Reads a file
     * @param dir the path to the directory
     */
    public static void read(String dir) {
        try {
            File save = new File(SaveButton.SAVE_DIR);

            Global.getManager().reset();
            SavedInstance.read(dir);
        } catch(IOException e) {
        
        }
    }
    
    /**
     * Asks User for a File and returns the File
     * @return the user-selected file
     */
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