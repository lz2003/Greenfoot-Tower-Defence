import greenfoot.*;
/**
 * Write a description of class Effect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Effect extends Sprite 
{
    private Animation animation;
    private float animDuration = 0.1f;
    private float fadeDuration = 0.1f;
    private float fadeCounter = 0;
    private boolean animating = true;

    /**
     * Constructor for objects of class Effect
     * 
     * @param x             the starting x coordinate
     * @param y             the starting y coordinate
     * @param image         the starting sprite
     * @param animation     the animation to be played
     */
    public Effect(double x, double y, GreenfootImage image, Animation animation)
    {
        super(x, y, image, image.getWidth(), image.getHeight(),2);
        setLocation(x, y);
        this.animation = animation;
        setAnimation(animation, animDuration);
    }
    
    /**
     * Constructor for objects of class Effect
     * 
     * @param x             the starting x coordinate
     * @param y             the starting y coordinate
     * @param image         the starting sprite
     * @param animation     the animation to be played
     * @param fadeDuration  how often to update fade
     */
    public Effect(double x, double y, GreenfootImage image, Animation animation, float fadeDuration)
    {
        super(x, y, image, image.getWidth(), image.getHeight(),2);
        setLocation(x, y);
        this.animation = animation;
        this.fadeDuration = fadeDuration;
        setAnimation(animation, animDuration);
    }
    
     /**
     * Constructor for objects of class Effect
     * 
     * @param x             the starting x coordinate
     * @param y             the starting y coordinate
     * @param image         the starting sprite
     * @param animation     the animation to be played
     * @param fadeDuration  how often to update fade
     * @param animDuration  how often to update animation
     */
    public Effect(double x, double y, GreenfootImage image, Animation animation, float fadeDuration, float animDuration)
    {
        super(x, y, image, image.getWidth(), image.getHeight(),2);
        setLocation(x, y);
        this.animation = animation;
        this.fadeDuration = fadeDuration;
        this.animDuration = animDuration;
        setAnimation(animation, animDuration);
    }

    /**
     * Update method
     */
    public void _update(float delta) {
        if (isRemoved()) return;
        if (animating) {
            animate(delta);
            if (getFrameIndex() == animation.getFrameCount()-1) {
                animating = false;
            }
        }
        fade(delta);
    }
    
    /**
     * Causes effect to fade
     */
    private void fade(float delta) {
        fadeCounter += delta;
        if (fadeCounter >= fadeDuration) {
            fadeCounter = 0;
            setTransparency(getTransparency() - 0.1);
        }
        if (getTransparency() <= 0.1) {
            removeSprite();
        }
    }
}
