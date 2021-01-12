import greenfoot.*;
/**
 * Write a description of class JayJay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JayJay extends Sprite 
{
    float hp = 500;
    
    public JayJay(double x, double y) {
        super(x, y, new GreenfootImage("jay.png"), 150, 150, 2);
    }
    
    public void damage(float damage) {
        hp -= damage;
        if(hp <= 0) {
            Global.getManager().broadcast(Global.manager.BROADCAST_END);
            deathAnimation();
            // or removeSprite();
        }
    }
    
    private void deathAnimation() {
    }
}
