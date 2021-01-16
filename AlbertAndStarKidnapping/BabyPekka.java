import greenfoot.*;

/**
 * The Baby Pekka is a small unit that has above average health and damage and is very speedy. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BabyPekka extends Enemy 
{
    private float damage = 20;
    private static GreenfootImage idle = new GreenfootImage("t2.png");

    /**
     * Constructor for BabyPekka
     * 
     * @param x         the x coordinate of BabyPekka
     * @param y         the y coordinate of BabyPekka
     */
    public BabyPekka(double x, double y) {
        super(x, y, idle, 300, 50, 2, 5f, false, false);
    }
    
    /**
     * Attack to damage JayJay the Dragon
     */
    public void attack() {
        Global.manager.damageJayJay(damage);
    }
}
