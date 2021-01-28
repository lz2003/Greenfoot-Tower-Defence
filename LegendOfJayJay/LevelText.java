import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays the level of the game.
 * 
 * @author Young Chen
 * @version 2021
 */
public class LevelText extends TextField
{
    /**
     * Constructor for class LevelText.
     * @param x The x coordinate of the label.
     * @param y The y coordinate of the label.
     */
    public LevelText(int x, int y) {
        super(x, y, "Level: ");
    }
    
    /**
     * Gets the level of the game.
     */
    protected float getValue() {
        return Global.getManager().getSpawner().getLevel();
    }
}
