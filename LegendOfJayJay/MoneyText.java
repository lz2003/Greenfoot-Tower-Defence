import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays the amount of money the player has.
 * 
 * @author Young Chen
 * @version 2021
 */
public class MoneyText extends TextField
{
    /**
     * Constructor for class MoneyText.
     * @param x The x coordinate of the label.
     * @param y The y coordinate of the label.
     */
    public MoneyText(int x, int y) {
        super(x, y, "$: ");
    }
    
    /**
     * Gets the amount of money.
     */
    protected float getValue() {
        return Global.getManager().getMoney();
    }
}
