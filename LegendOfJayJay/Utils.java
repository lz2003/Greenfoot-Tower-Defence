import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 * Utility functions
 *
 * @author Young Chen
 * @version 2021-01-26
 */
public class Utils  
{
    /**
     * Read image file
     * @param file
     * @return
     */
    public static BufferedImage read(String file) {
        try {
            return ImageIO.read(new File(file));
        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
