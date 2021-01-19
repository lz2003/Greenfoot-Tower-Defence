import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 * Write a description of class Utils here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Utils  
{
    public static BufferedImage read(String file) {
        try {
            return ImageIO.read(new File(file));
        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
