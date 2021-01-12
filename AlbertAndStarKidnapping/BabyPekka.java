import greenfoot.*;

/**
 * Write a description of class BabyPekka here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BabyPekka extends Enemy 
{
    private float damage = 20;
    private static GreenfootImage idle = new GreenfootImage("t2.png");

    /**
     * Constructor for objects of class BabyPekka
     */
    public BabyPekka(double x, double y) {
        super(x, y, idle, 300, 50, 2, 5f, false, false);
    }

    public void attack() {
        Global.manager.damageJayJay(damage);
    }
}
