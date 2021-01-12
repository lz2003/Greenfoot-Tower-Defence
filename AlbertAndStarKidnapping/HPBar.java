import greenfoot.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.AlphaComposite;
import java.awt.Component;
import java.awt.Composite;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
/**
 * Write a description of class HPBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HPBar extends Sprite 
{
    private float full, current;
    private Color frg, bkg;
    /**
     * Constructor for objects of class HPBar
     * 
     * @param full Full hitpoint value
     */
    public HPBar(double x, double y, int width, int height, float full, Color background, Color foreground) {
        super(x, y, new GreenfootImage(width, height), 10);
        this.full = full;
        this.current = full;
        frg = foreground;
        bkg = background;
        draw();
    }

    public void setHP(float hp) {
        current = hp;
        draw();
    }
    
    public void remove() {
        removeSprite();
    }
    
    private void draw() {
        Graphics g = getImage().getGraphics();
        g.setColor(bkg);
        g.fillRect(0, 0, getImage().getWidth(), getImage().getHeight());
        g.setColor(frg);
        int width = (int) (getImage().getWidth() * (current / full));
        g.fillRect(0, 0, width, getImage().getHeight());
    }
}
