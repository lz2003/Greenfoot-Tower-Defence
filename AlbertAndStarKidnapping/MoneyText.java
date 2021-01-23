import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MoneyText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MoneyText extends TextField
{
    public MoneyText(int x, int y) {
        super(x, y, "$: ");
    }
    
    protected float getValue() {
        return Global.getManager().getMoney();
    }
}
