import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.AlphaComposite;
import java.awt.Component;
import java.awt.Composite;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.VolatileImage;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
/**
 * Sprite renderer class that draws sprites from lowest y position (closest to top of the screen)
 * to highest y position (closest to bottom of the screen)
 *
 * @author Young Chen
 * @version 2021-01-15
 */
public class Canvas extends Actor
{
    private BufferedImage image;
    ArrayList<ArrayList<Sprite>[]> spriteLayers;
    
    private int 
        zWidth, 
        width, 
        height,
        size;
        
    private GraphicsEnvironment ge;
    private GraphicsDevice gd;
    private GraphicsConfiguration gc;
    private VolatileImage vi;

    /**
     * Creates a canvas
     * @param zWidth Y axis divisions to divide sprites into
     * @param width width of canvas
     * @param height height of canvas
     */
    public Canvas(int zWidth, int width, int height) {
        this.zWidth = zWidth;
        this.width = width;
        this.height = height;
        
        size = height / zWidth;

        
        GreenfootImage img = new GreenfootImage(width, height);
        setImage(img);
        image = getImage().getAwtImage();
        
        spriteLayers = new ArrayList<ArrayList<Sprite>[]>();
        
        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        
        try {
            gd = ge.getDefaultScreenDevice();
            gc = gd.getDefaultConfiguration();
            vi = gc.createCompatibleVolatileImage(width,height);
        } catch (HeadlessException e) {
            throw new Error("Failed to initialise canvas. Please make sure that your device has a display.");
        }   
    }

    /**
     * Creates a new draw layer in indicated y-index
     * @param layer index
     */
    private void createNewLayer(int layer) {
        if(layer >= spriteLayers.size()) {
            initLayer(layer);
            return;
        }
        if(spriteLayers.get(layer) == null) {
            initLayer(layer);
        }
    }

    /**
     * Initialises layer in indicated y index
     * @param layer index
     */
    private void initLayer(int layer) {
        ArrayList<Sprite>[] sprites = (ArrayList<Sprite>[]) new ArrayList[size];
        for(int i = 0; i < size; i++) {
            sprites[i] = new ArrayList<Sprite>();
        }
        
        while(layer >= spriteLayers.size()) {
            
            spriteLayers.add(null);
        }
        
        spriteLayers.set(layer, sprites);
    }

    /**
     * Draws all the sprites currently contained in the canvas from back to front, with the order
     * being determined by the y-location of the sprite
     */
    public void draw() {
        // get graphics context from the volatileimage
        Graphics2D g = vi.createGraphics();

        // clear previously drawn sprites
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // create transformation object for sprite transforms
        AffineTransform tf = new AffineTransform();

        // loop through sprites
        for(int h = 0; h < spriteLayers.size(); h++) {
            ArrayList<Sprite>[] sprites = spriteLayers.get(h);
            
            if(sprites == null) continue;
            
            for(int i = 0; i < sprites.length; i++) {
                for(int j = 0; j < sprites[i].size(); j++) {
                    Sprite current = sprites[i].get(j);
                    // AffineTransform old = g.getTransform();
                    // Create the AffineTransform object:
                    
                    // This will perform transformations on the Graphics2D object so that the image is drawn
                    // in the correct location
                    tf.setToIdentity();
                    //g.setTransform(tf);
                    
                    int halfW = current.getImageWidth() / 2;
                    int halfH =  current.getImageHeight() / 2;
                    
                    // rotate
                    if(current.getRotation() != 0) {
                        tf.rotate(current.getRotation(), current.getX() + current.getImageWidth() / 2, current.getY() + current.getImageHeight() / 2);
                        //g.rotate(current.getRotation(), current.getX() + halfW, current.getY() + halfH);
                    }
    
                    // translate
                    tf.translate(current.getX() - current.getWidth() / 2, current.getY() - current.getHeight() / 2);
    
                    // scale
                    tf.scale(current.getScaleX(), current.getScaleY());

                    Composite oldC = null;

                    // set transparency
                    if(current.getTransparency() < 1) {
                        float alpha = (float) Math.max(current.getTransparency(), 0);
                        
                        oldC = g.getComposite();
                        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
                    }
                    
                    // draw to canvas
                    
                    // By passing in the AffineTransform object, the transformations applied to it will be applied to the Graphics2D object
                    g.drawImage(current.getImage(), tf, null);
                    
                    // reset composite if a new composite was set
                    if(oldC != null) g.setComposite(oldC);
                }
                
            }
        }

        Graphics2D gimg = image.createGraphics();
        gimg.drawImage(vi, 0, 0, width, height, null); 
    }

    /**
     * Gets the greenfootimage of the canvas
     * @return greenfoot image
     */
    public GreenfootImage getGreenfootImage() {
        return super.getImage();
    }

    /**
     * Gets the bufferedimage of the canvas
     * @return image
     */
    public BufferedImage getBufferedImage() {
        return image;
    }

    /**
     * Adds a sprite to the canvas
     * @param s sprite
     * @param layer draw layer of sprite. Must be a positive or zero integer. Sprites are drawn from lowest draw layer to highest draw layer
     */
    public void addSprite(Sprite s, int layer) {
        int yLoc = (int) s.getY();
        
        int index = yLoc / zWidth;
        
        index = clamp(index, size - 1, 0);
        
        s.setZ(index);
        
        createNewLayer(layer);

        spriteLayers.get(layer)[index].add(s);
    }

    /**
     * Removes a sprite from the canvas
     * @param s sprite
     * @param layer layer index of sprite
     */
    public void removeSprite(Sprite s, int layer) {
        int index = s.getZ();

        spriteLayers.get(layer)[index].remove(s);
    }

    /**
     * Clamp method
     * @param num
     * @param max
     * @param min
     * @return
     */
    private int clamp(int num, int max, int min) {
        return Math.max(Math.min(num, max), min);
    }

    /**
     * Canvas act method to draw sprites
     */
    public void act() {
        draw();
    }
}
