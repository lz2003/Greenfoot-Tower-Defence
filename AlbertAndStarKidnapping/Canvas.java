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

        }   
    }
    
    private void createNewLayer(int layer) {
        if(layer >= spriteLayers.size()) {
            initLayer(layer);
            return;
        }
        if(spriteLayers.get(layer) == null) {
            initLayer(layer);
        }
    }
    
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
    
    public void draw() {
        Graphics2D g = vi.createGraphics();
        
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        AffineTransform tf = new AffineTransform();
        
        for(int h = 0; h < spriteLayers.size(); h++) {
            ArrayList<Sprite>[] sprites = spriteLayers.get(h);
            
            if(sprites == null) continue;
            
            for(int i = 0; i < sprites.length; i++) {
                for(int j = 0; j < sprites[i].size(); j++) {
                    Sprite current = sprites[i].get(j);
                    AffineTransform old = g.getTransform();
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
                    if(current.getTransparency() < 1) {
                        float alpha = (float) Math.max(current.getTransparency(), 0);
                        
                        oldC = g.getComposite();
                        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
                    }
                    
                    // draw to canvas
                    
                    // By passing in the AffineTransform object, the transformations applied to it will be applied to the Graphics2D object
                    g.drawImage(current.getImage(), tf, null);
                    
                    g.setTransform(old);
                    if(oldC != null) g.setComposite(oldC);
                }
                
            }
        }
        
        Graphics2D gimg = image.createGraphics();
        gimg.drawImage(vi, 0, 0, width, height, null);
    }

    public GreenfootImage getGreenfootImage() {
        return super.getImage();
    }
    
    public BufferedImage getBufferedImage() {
        return image;
    }
    
    public void addSprite(Sprite s, int layer) {
        int yLoc = (int) s.getY();
        
        int index = yLoc / zWidth;
        
        index = clamp(index, size - 1, 0);
        
        s.setZ(index);
        
        createNewLayer(layer);

        spriteLayers.get(layer)[index].add(s);
    }
    
    public void removeSprite(Sprite s, int layer) {
        int index = s.getZ();

        spriteLayers.get(layer)[index].remove(s);
    }
    
    private int clamp(int num, int max, int min) {
        return Math.max(Math.min(num, max), min);
    }
    
    public void act() {
        draw();
    }
}
