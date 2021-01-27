import greenfoot.*;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
/**
 * Sprites that will be rendered to the canvas
 *
 * @author Young Chen
 * @author Lucy Zhao
 * @version 2021-01-26
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
    private Animation animation;
    private float animationTimer = 0, animationDur = 1;
    private int animFrame = 0;

    /**
     * Creates a sprite
     * @param x x location
     * @param y y location
     * @param image image
     */
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

    /**
     * Creates a sprite
     * @param x x location
     * @param y y location
     * @param image image
     * @param layer draw layer; must be positive or zero integer
     */
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

    /**
     * Creates a sprite in a certain canvas
     * @param c canvas
     * @param x x location
     * @param y y location
     * @param image image
     */
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

    /**
     * Creates a sprite in a certain canvas
     * @param c canvas
     * @param x x location
     * @param y y location
     * @param image image
     * @param layer draw layer
     */
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

    /**
     * Creates a sprite in a certain canvas
     * @param c canvas
     * @param x x location
     * @param y y location
     * @param image image
     * @param height height
     * @param width width
     */
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

    /**
     * Creates a sprite in a certain canvas
     * @param c canvas
     * @param x x location
     * @param y y location
     * @param image image
     * @param height height
     * @param width width
     * @param layer draw layer
     */
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

    /**
     * Creates a sprite
     * @param x x location
     * @param y y location
     * @param image image
     * @param height height
     * @param width width
     */
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

    /**
     * Creates a sprite
     * @param x x location
     * @param y y location
     * @param image image
     * @param height height
     * @param width width
     * @param layer draw layer
     */
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

    /**
     * Creates a sprite
     * @param x x location
     * @param y y location
     * @param image image
     * @param layer draw layer
     */
    public Sprite(double x, double y, BufferedImage image, int layer) {
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

    /**
     * Creates a sprite in a certain canvas
     * @param c canvas
     * @param x x location
     * @param y y location
     * @param image image
     */
    public Sprite(Canvas c, double x, double y, BufferedImage image) {
        xLoc = x;
        yLoc = y;
        xLocInt = (int) (x + .5f);
        yLocInt = (int) (y + .5f);
        this.layer = layer;
        c.addSprite(this, layer);
        canvas = c;
        initImage(image);
    }

    /**
     * Creates a sprite in a certain canvas
     * @param c canvas
     * @param x x location
     * @param y y location
     * @param image image
     * @param layer draw layer
     */
    public Sprite(Canvas c, double x, double y, BufferedImage image, int layer) {
        xLoc = x;
        yLoc = y;
        xLocInt = (int) (x + .5f);
        yLocInt = (int) (y + .5f);
        this.layer = layer;
        c.addSprite(this, layer);
        canvas = c;
        initImage(image);
    }

    /**
     * Creates a sprite in a certain canvas
     * @param c canvas
     * @param x x location
     * @param y y location
     * @param image image
     * @param height height
     * @param width width
     */
    public Sprite(Canvas c, double x, double y, BufferedImage image, int width, int height) {
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

    /**
     * Creates a sprite in a certain canvas
     * @param c canvas
     * @param x x location
     * @param y y location
     * @param image image
     * @param height height
     * @param width width
     * @param layer draw layer
     */
    public Sprite(Canvas c, double x, double y, BufferedImage image, int width, int height, int layer) {
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

    /**
     * Creates a sprite
     * @param x x location
     * @param y y location
     * @param image image
     * @param height height
     * @param width width
     */
    public Sprite(double x, double y, BufferedImage image, int width, int height) {
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

    /**
     * Creates a sprite
     * @param x x location
     * @param y y location
     * @param image image
     * @param height height
     * @param width width
     * @param layer draw layer
     */
    public Sprite(double x, double y, BufferedImage image, int width, int height, int layer) {
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

    /**
     * Sets the sprite's location
     * @param x x location
     * @param y y location
     */
    public void setLocation(double x, double y) {
        canvas.removeSprite(this, layer);
        xLoc = x;
        yLoc = y;
        xLocInt = (int) (x + .5f);
        yLocInt = (int) (y + .5f);
        canvas.addSprite(this, layer);
    }

    /**
     * Sets the sprite's x location
     * @param x x location
     */
    public void setX(double x) {
        setLocation(x, getY());
    }

    /**
     * Sets the sprite's y location
     * @param y y location
     */
    public void setY(double y) {
        setLocation(getX(), y);
    }

    /**
     * Initialise the image
     * @param image image
     */
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

    /**
     * Initialise the image
     * @param image image
     */
    private void initImage(BufferedImage image) {
        this.image = image;
        width = image.getWidth();
        height = image.getHeight();
        apparentWidth = width;
        apparentHeight = height;
        scaleX = 1;
        scaleY = 1;
        alpha = 1;
    }

    /**
     * Move in direction of rotation
     * @param dist distance
     */
    public void move(double dist) {
        setLocation(getX() + Math.cos(rot) * dist, getY() + Math.sin(rot) * dist);
    }

    /**
     * Move forward
     * @param dist distance
     * @param angle angle
     */
    public void move(double dist, double angle) {
        setLocation(getX() + Math.cos(angle) * dist, getY() + Math.sin(angle) * dist);
    }

    /**
     * Get x location
     * @return x location
     */
    public double getX() {
        return xLoc;
    }

    /**
     * Get y location
     * @return y location
     */
    public double getY() {
        return yLoc;
    }

    /**
     * Get x location as an integer
     * @return x location
     */
    public int getIntX() {
        return xLocInt;
    }

    /**
     * Get y location as an integer
     * @return y location
     */
    public int getIntY() {
        return yLocInt;
    }

    /**
     * Get the image of the sprite
     * @return image
     */
    public BufferedImage getImage() {
        return image;
    }
    
    /**
     * Stores the z index value of the sprite. Does not change the layer or order it is drawn in.
     *
     * @param z z index
     */
    public void setZ(int z) {
        zIndex = z;
    }

    /**
     * Get the z index
     * @return z index
     */
    public int getZ() {
        return zIndex;
    }

    /**
     * Sets the rotation
     * @param rot angle
     */
    public void setRotation(double rot) {
        this.rot = rot;
    }

    /**
     * Gets the rotation
     * @return angle
     */
    public double getRotation() {
        return this.rot;
    }

    /**
     * Turn towards a point
     * @param x x location of point
     * @param y y location of point
     */
    public void turnTowards(double x, double y) {
        this.setRotation(
            Math.atan2((y - getY()), (x - getX()))
        );
    }

    /**
     * Move towards a point
     * @param x x location of point
     * @param y y location of point
     * @param step distance to travel
     */
    public void moveTowards(double x, double y, double step) {
        double rotation = (
            Math.atan2((y - getY()), (x - getX()))
        );
        
        move(step, rotation);
    }

    /**
     * Get width of sprite
     * @return width
     */
    public int getWidth() {
        return apparentWidth;
    }

    /**
     * Get height of sprite
     * @return height of sprite
     */
    public int getHeight() {
        return apparentHeight;
    }

    /**
     * Set the scale of the sprite
     * @param scale scale
     */
    public void setScale(double scale) {
        this.scaleX = scale;
        this.scaleY = scale;
    }

    /**
     * Set the width of the sprite
     * @param width width
     */
    public void setWidth(int width) {
        scaleX = (double) width / (double) this.width;
        this.apparentWidth = width;
    }

    /**
     * Set the height of the sprite
     * @param height height
     */
    public void setHeight(int height) {
        scaleY = (double) height / (double) this.height;
        this.apparentHeight = height;
    }

    /**
     * Gets whether or not a point is inside the sprite
     * @param x x location of point
     * @param y y location of point
     * @return whether or not the point intersects
     */
    public boolean isInsideImage(int x, int y){
        return (getX() - apparentWidth/2) <=x && x <= (getX() + apparentWidth/2) && (getY() - apparentHeight/2) <= y && y <= (getY() + apparentHeight/2);
    }

    /**
     * Set the dimensions of the sprite
     * @param width width of sprite
     * @param height height of sprite
     */
    public void setDimensions(int width, int height) {
        setWidth(width);
        setHeight(height);
    }
    
    /**
     * Set the dimensions of the sprite
     * For compatability with the Greenfoot Actor class
     *
     * @param width width of sprite
     * @param height height of sprite
     */
    public void scale(int width, int height) {
        setDimensions(width, height);
    }

    /**
     * Sets the sprite's image
     * @param image new image
     */
    public void setImage(GreenfootImage image) {
        this.image = image.getAwtImage();
        width = image.getWidth();
        height = image.getHeight();
        setDimensions(apparentWidth, apparentHeight);
    }

    /**
     * Sets the sprite's image
     * @param image new image
     * @param keepPreviousState whether to keep previous dimensions
     */
    public void setImage(GreenfootImage image, boolean keepPreviousState) {
        if(keepPreviousState) setImage(image);
        
        else initImage(image);
    }

    /**
     * Set the sprite's image
     * @param image new image
     */
    public void setImage(BufferedImage image) {
        this.image = image;
        width = image.getWidth();
        height = image.getHeight();
        setDimensions(apparentWidth, apparentHeight);
    }

    /**
     * Sets the sprite's image
     * @param image new image
     * @param keepPreviousState whether to keep previous dimensions
     */
    public void setImage(BufferedImage image, boolean keepPreviousState) {
        if(keepPreviousState) setImage(image);
        
        else initImage(image);
    }

    /**
     * Change width
     * @param delta amount to change by
     */
    public void changeWidth(int delta) {
        setWidth(getWidth() + delta);
    }

    /**
     * Change height
     * @param delta amount to change by
     */
    public void changeHeight(int delta) {
        setHeight(getHeight() + delta);
    }

    /**
     * Get width of image
     * @return width
     */
    public int getImageWidth() {
        return width;
    }

    /**
     * Get height of image
     * @return height
     */
    public int getImageHeight() {
        return height;
    }

    /**
     * Get sprite horizontal image scale
     * @return scale
     */
    public double getScaleX() {
        return scaleX;
    }

    /**
     * Get sprite vertical image scale
     * @return scale
     */
    public double getScaleY() {
        return scaleY;
    }

    /**
     * Set the sprite's alpha
     * @param alpha new alpha
     */
    public void setTransparency(double alpha) {
        this.alpha = alpha;
    }

    /**
     * Gets the sprite's alpha
     * @return alpha
     */
    public double getTransparency() {
        return alpha; 
    }

    /**
     * Removes the sprite from the canvas
     */
    public void removeSprite() {
        canvas.removeSprite(this, layer);
        removed = true;
    }

    /**
     * Whether or not the sprite has been removed
     * @return Whether or not the sprite has been removed
     */
    public boolean isRemoved() {
        return removed;
    }

    /**
     * Sets the sprite's animation
     * @param animation animation
     */
    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    /**
     * Sets the sprite's animation
     * @param animation animation
     * @param time time between frames
     */
    public void setAnimation(Animation animation, float time) {
        this.animation = animation;
        setAnimationFrameTime(time);
    }

    /**
     * Sets the time between animation frames
     * @param time time between frames
     */
    public void setAnimationFrameTime(float time) {
        animationDur = time;
    }

    /**
     * Animates the sprite
     * @param delta change in time since last update
     */
    public void animate(float delta) {
        animationTimer += delta;
        
        if(animationTimer > animationDur) {
            animationTimer = 0;
            nextFrameLooped();
        }
    }

    /**
     * Set the current frame's index
     * @param frame index
     */
    public void setFrameIndex(int frame) {
        animFrame = frame;
    }

    /**
     * Get the current frame's index
     * @return index
     */
    public int getFrameIndex() {
        return animFrame;
    }

    /**
     * Get total number of frames
     * @return number of frames
     */
    public int getFrameCount() {
        return animation.getFrameCount();
    }

    /**
     * Change to next frame
     */
    public void nextFrame() {
        setImage(animation.getFrame(++this.animFrame));
    }

    /**
     * Change to next frame and loop back to first frame when it has reached the last frame
     */
    public void nextFrameLooped() {
        if(animation != null) {
            animFrame++;
            if(animFrame >= animation.getFrameCount()) animFrame = 0;
            
            setImage(animation.getFrame(this.animFrame));
        }
    }
}

/**
 * Class to contain animations
 *
 * @author Young Chen
 * @version 2021-01-26
 */
class Animation {
    private BufferedImage[] frames;

    /**
     * Creates an animation object
     * @param frames animation frames
     */
    public Animation(GreenfootImage[] frames) {
        this.frames = new BufferedImage[frames.length];
        for(int i = 0; i < frames.length; i++) {
            this.frames[i] = frames[i].getAwtImage();
        }
    }

    /**
     * Creates an animation object
     * @param frames animation frames
     */
    public Animation(BufferedImage[] frames) {
        this.frames = frames;
    }

    /**
     * Gets a frame at the indicated index
     * @param index index
     * @return frame
     */
    public BufferedImage getFrame(int index) {
        return this.frames[index];
    }

    /**
     * Get total number of frames
     * @return frames
     */
    public int getFrameCount() {
        return frames.length;
    }
}
