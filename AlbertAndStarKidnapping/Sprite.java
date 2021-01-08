
import greenfoot.*;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
/**
 * Write a description of class Sprite here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Sprite extends Updated{
    private static Canvas globalCanvas;
    static void setGlobalCanvas(Canvas c) {
        globalCanvas = c;
    }
    
    private double xLoc, yLoc;
    private int xLocInt, yLocInt;
    private int zIndex = -1;
    private Canvas canvas;
    private BufferedImage image;
    private double rot = 0;
    private int width, height;
    private int apparentWidth, apparentHeight;
    private int layer = 0;
    private double scaleX, scaleY;
    private double alpha;
    private boolean removed = false;
    
    public Sprite(double x, double y, GreenfootImage image) {
        if(globalCanvas == null) throw new Error("Global canvas has not been set. If no global " + 
        "canvas is to be desired, use alternate constructor of new Sprite(canvas, xLoc, yLoc, image)");
        
        xLoc = x;
        yLoc = y;
        xLocInt = (int) (x + .5f);
        yLocInt = (int) (y + .5f);
        this.layer = layer;
        globalCanvas.addSprite(this, layer);
        canvas = globalCanvas;
        initImage(image);
    }
    
    public Sprite(double x, double y, GreenfootImage image, int layer) {
        if(globalCanvas == null) throw new Error("Global canvas has not been set. If no global " + 
        "canvas is to be desired, use alternate constructor of new Sprite(canvas, xLoc, yLoc, image)");
        
        xLoc = x;
        yLoc = y;
        xLocInt = (int) (x + .5f);
        yLocInt = (int) (y + .5f);
        this.layer = layer;
        globalCanvas.addSprite(this, layer);
        canvas = globalCanvas;
        initImage(image);
    }
    
    public Sprite(Canvas c, double x, double y, GreenfootImage image) {
        xLoc = x;
        yLoc = y;
        xLocInt = (int) (x + .5f);
        yLocInt = (int) (y + .5f);
        this.layer = layer;
        c.addSprite(this, layer);
        canvas = c;
        initImage(image);
    }
    
    public Sprite(Canvas c, double x, double y, GreenfootImage image, int layer) {
        xLoc = x;
        yLoc = y;
        xLocInt = (int) (x + .5f);
        yLocInt = (int) (y + .5f);
        this.layer = layer;
        c.addSprite(this, layer);
        canvas = c;
        initImage(image);
    }
    
    public Sprite(Canvas c, double x, double y, GreenfootImage image, int width, int height) {
        xLoc = x;
        yLoc = y;
        xLocInt = (int) (x + .5f);
        yLocInt = (int) (y + .5f);
        this.layer = layer;
        c.addSprite(this, layer);
        canvas = c;
        initImage(image);
        setWidth(width);
        setHeight(height);
    }
    
    public Sprite(Canvas c, double x, double y, GreenfootImage image, int width, int height, int layer) {
        xLoc = x;
        yLoc = y;
        xLocInt = (int) (x + .5f);
        yLocInt = (int) (y + .5f);
        this.layer = layer;
        c.addSprite(this, layer);
        canvas = c;
        initImage(image);
        setWidth(width);
        setHeight(height);
    }
    
    public Sprite(double x, double y, GreenfootImage image, int width, int height) {
        if(globalCanvas == null) throw new Error("Global canvas has not been set. If no global " + 
        "canvas is to be desired, use alternate constructor of new Sprite(canvas, xLoc, yLoc, image)");
        
        xLoc = x;
        yLoc = y;
        xLocInt = (int) (x + .5f);
        yLocInt = (int) (y + .5f);
        canvas = globalCanvas;
        this.layer = layer;
        canvas.addSprite(this, layer);
        initImage(image);
        setWidth(width);
        setHeight(height);
    }
    
    public Sprite(double x, double y, GreenfootImage image, int width, int height, int layer) {
        if(globalCanvas == null) throw new Error("Global canvas has not been set. If no global " + 
        "canvas is to be desired, use alternate constructor of new Sprite(canvas, xLoc, yLoc, image)");
        
        xLoc = x;
        yLoc = y;
        xLocInt = (int) (x + .5f);
        yLocInt = (int) (y + .5f);
        canvas = globalCanvas;
        this.layer = layer;
        canvas.addSprite(this, layer);
        initImage(image);
        setWidth(width);
        setHeight(height);
    }
    
    public void setLocation(double x, double y) {
        canvas.removeSprite(this, layer);
        xLoc = x;
        yLoc = y;
        xLocInt = (int) (x + .5f);
        yLocInt = (int) (y + .5f);
        canvas.addSprite(this, layer);
    }
    
    public void setX(double x) {
        setLocation(x, getY());
    }
    
    public void setY(double y) {
        setLocation(y, getY());
    }
    
    private void initImage(GreenfootImage image) {
        this.image = image.getAwtImage();
        width = image.getWidth();
        height = image.getHeight();
        apparentWidth = width;
        apparentHeight = height;
        scaleX = 1;
        scaleY = 1;
        alpha = 1;
    }
    
    public void setImage(GreenfootImage image) {
        initImage(image);
    }
    
    public void move(double dist) {
        setLocation(getX() + Math.cos(rot) * dist, getY() + Math.sin(rot) * dist);
    }
   
    public double getX() {
        return xLoc;
    }
    
    public double getY() {
        return yLoc;
    }
    
    public int getIntX() {
        return xLocInt;
    }
    
    public int getIntY() {
        return yLocInt;
    }
    
    public BufferedImage getImage() {
        return image;
    }

    public void setZ(int z) {
        zIndex = z;
    }
    
    public int getZ() {
        return zIndex;
    }
    
    public void setRotation(double rot) {
        this.rot = rot;
    }
    
    public double getRotation() {
        return this.rot;
    }
    
    public void turnTowards(double x, double y) {
        this.setRotation(
            Math.atan2((getY() - y), (getX() - x))
        );
    }
    
    public int getWidth() {
        return apparentWidth;
    }
    
    public int getHeight() {
        return apparentHeight;
    }
    
    public void setScale(double scale) {
        this.scaleX = scale;
        this.scaleY = scale;
    }
    
    public void setWidth(int width) {
        scaleX = (double) width / (double) this.width;
        this.apparentWidth = width;
    }
    
    public void setHeight(int height) {
        scaleY = (double) height / (double) this.height;
        this.apparentHeight = height;
    }
    
    public void setDimensions(int width, int height) {
        setWidth(width);
        setHeight(height);
    }
    
    /**
     * For compatability with the Greenfoot Actor class
     */
    public void scale(int width, int height) {
        setDimensions(width, height);
    }
    
    public void changeWidth(int delta) {
        setWidth(getWidth() + delta);
    }
    
    public void changeHeight(int delta) {
        setHeight(getHeight() + delta);
    }
    
    public int getImageWidth() {
        return width;
    }
    
    public int getImageHeight() {
        return height;
    }
    
    public double getScaleX() {
        return scaleX;
    }
    
    public double getScaleY() {
        return scaleY;
    }
    
    public void setTransparency(double alpha) {
        this.alpha = alpha;
    }
    
    public double getTransparency() {
        return alpha; 
    }
    
    public void removeSprite() {
        canvas.removeSprite(this, layer);
        removed = true;
    }
    
    public boolean isRemoved() {
        return removed;
    }
}