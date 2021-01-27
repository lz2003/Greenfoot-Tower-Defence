import greenfoot.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.AlphaComposite;
import java.awt.Component;
import java.awt.Composite;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
/**
 * Health bar
 *
 * @author Young Chen
 * @version 2021-01-26
 */
public class HPBar extends Sprite 
{
    private float full, current;
    private Color frg, bkg;

    /**
     * Creates a health bar
     * @param x x location
     * @param y y location
     * @param width width
     * @param height height
     * @param full full hitpoint value
     * @param background background colour
     * @param foreground foreground colour
     */
    public HPBar(double x, double y, int width, int height, float full, Color background, Color foreground) {
        super(x, y, new GreenfootImage(width, height), 10);
        this.full = full;
        this.current = full;
        frg = foreground;
        bkg = background;
        draw();
    }

    /**
     * Set hitpoints
     * @param hp new hitpoint value
     */
    public void setHP(float hp) {
        current = hp;
        draw();
    }

    /**
     * Removes healthbar from canvas
     */
    public void remove() {
        removeSprite();
    }

    /**
     * Draw healthbar
     */
    private void draw() {
        Graphics g = getImage().getGraphics();
        g.setColor(bkg);
        g.fillRect(0, 0, getImage().getWidth(), getImage().getHeight());
        g.setColor(frg);
        int width = (int) (getImage().getWidth() * (current / full));
        g.fillRect(0, 0, width, getImage().getHeight());
    }
}
