import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class JayJay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JayJay extends Sprite 
{
    private HPBar hpBar;
    private float hp = 1000;
    private static final Color HPBKG = new Color(255, 0, 0), HPFOR = new Color(0, 255, 0);
    private boolean damaged = false, dying = false, dead = false;
    
    public JayJay(double x, double y) {
        super(x, y, new GreenfootImage("jay.png"), 250, 250, 2);
        hpBar = new HPBar(getX(), getY() - 100, 100, 10, hp, HPBKG, HPFOR);
        setY(getY() - 50);
        setAnimation(idle, 0.07f);
    }
    
    public void damage(float damage) {
        hp -= damage;
        hpBar.setHP(hp);
        setAnimation(JayJay.damage, 0.07f);
        damaged = true;
        if(hp <= 0) {
            Global.getManager().broadcast(Global.manager.BROADCAST_END);
            deathAnimation();
            
            if(!dying) 
                setFrameIndex(0);
            dying = true;
            // or removeSprite();
        }
    }
    
    public void _update(float delta) {
        if(!dead)
            animate(delta);
            
        if(damaged) {
            if(getFrameIndex() >= getFrameCount() - 1) {
                setAnimation(idle, 0.07f);
            }
        }
        if(dying) {
            if(getFrameIndex() >= getFrameCount() - 1) {
                dead = true;
                endGame();
            }
        }
    }
    
    public void destroy() {
        removeSprite();
    }
    
    private void endGame() {
        
    }
    
    private void deathAnimation() {
        setAnimation(die, 0.15f);
    }
    
    private static final Animation idle = new Animation(new GreenfootImage[] {
        new GreenfootImage("images/JayJay/idle/0001.png"),
        new GreenfootImage("images/JayJay/idle/0002.png"),
        new GreenfootImage("images/JayJay/idle/0003.png"),
        new GreenfootImage("images/JayJay/idle/0004.png"),
        new GreenfootImage("images/JayJay/idle/0005.png"),
        new GreenfootImage("images/JayJay/idle/0006.png"),
        new GreenfootImage("images/JayJay/idle/0007.png"),
        new GreenfootImage("images/JayJay/idle/0008.png"),
        new GreenfootImage("images/JayJay/idle/0009.png"),
        new GreenfootImage("images/JayJay/idle/0010.png"),
        new GreenfootImage("images/JayJay/idle/0011.png"),
        new GreenfootImage("images/JayJay/idle/0012.png"),
        new GreenfootImage("images/JayJay/idle/0013.png"),
        new GreenfootImage("images/JayJay/idle/0014.png"),
        new GreenfootImage("images/JayJay/idle/0015.png"),
        new GreenfootImage("images/JayJay/idle/0016.png"),
        new GreenfootImage("images/JayJay/idle/0017.png"),
        new GreenfootImage("images/JayJay/idle/0018.png"),
        new GreenfootImage("images/JayJay/idle/0019.png"),
        new GreenfootImage("images/JayJay/idle/0020.png"),
        new GreenfootImage("images/JayJay/idle/0021.png"),
        new GreenfootImage("images/JayJay/idle/0022.png"),
        new GreenfootImage("images/JayJay/idle/0023.png"),
        new GreenfootImage("images/JayJay/idle/0024.png"),
        new GreenfootImage("images/JayJay/idle/0025.png"),
        new GreenfootImage("images/JayJay/idle/0026.png"),
        new GreenfootImage("images/JayJay/idle/0027.png"),
        new GreenfootImage("images/JayJay/idle/0028.png"),
        new GreenfootImage("images/JayJay/idle/0029.png"),
        new GreenfootImage("images/JayJay/idle/0030.png"),
        new GreenfootImage("images/JayJay/idle/0031.png"),
        new GreenfootImage("images/JayJay/idle/0032.png"),
        new GreenfootImage("images/JayJay/idle/0033.png"),
        new GreenfootImage("images/JayJay/idle/0034.png"),
        new GreenfootImage("images/JayJay/idle/0035.png"),
        new GreenfootImage("images/JayJay/idle/0036.png"),
        new GreenfootImage("images/JayJay/idle/0037.png"),
        new GreenfootImage("images/JayJay/idle/0038.png"),
        new GreenfootImage("images/JayJay/idle/0039.png"),
        new GreenfootImage("images/JayJay/idle/0040.png"),
    });
    
    private static final Animation die = new Animation(new GreenfootImage[] {
        new GreenfootImage("images/JayJay/die/0001.png"),
        new GreenfootImage("images/JayJay/die/0002.png"),
        new GreenfootImage("images/JayJay/die/0003.png"),
        new GreenfootImage("images/JayJay/die/0004.png"),
        new GreenfootImage("images/JayJay/die/0005.png"),
        new GreenfootImage("images/JayJay/die/0006.png"),
        new GreenfootImage("images/JayJay/die/0007.png"),
        new GreenfootImage("images/JayJay/die/0008.png"),
        new GreenfootImage("images/JayJay/die/0009.png"),
        new GreenfootImage("images/JayJay/die/0010.png"),
        new GreenfootImage("images/JayJay/die/0011.png"),
        new GreenfootImage("images/JayJay/die/0012.png"),
        new GreenfootImage("images/JayJay/die/0013.png"),
        new GreenfootImage("images/JayJay/die/0014.png"),
        new GreenfootImage("images/JayJay/die/0015.png"),
        new GreenfootImage("images/JayJay/die/0016.png"),
        new GreenfootImage("images/JayJay/die/0017.png"),
        new GreenfootImage("images/JayJay/die/0018.png"),
        new GreenfootImage("images/JayJay/die/0019.png"),
        new GreenfootImage("images/JayJay/die/0020.png"),
        new GreenfootImage("images/JayJay/die/0021.png"),
        new GreenfootImage("images/JayJay/die/0022.png"),
        new GreenfootImage("images/JayJay/die/0023.png"),
        new GreenfootImage("images/JayJay/die/0024.png"),
        new GreenfootImage("images/JayJay/die/0025.png"),
        new GreenfootImage("images/JayJay/die/0026.png"),
        new GreenfootImage("images/JayJay/die/0027.png"),
        new GreenfootImage("images/JayJay/die/0028.png"),
        new GreenfootImage("images/JayJay/die/0029.png"),
        new GreenfootImage("images/JayJay/die/0030.png"),
        new GreenfootImage("images/JayJay/die/0031.png"),
        new GreenfootImage("images/JayJay/die/0032.png"),
        new GreenfootImage("images/JayJay/die/0033.png"),
        new GreenfootImage("images/JayJay/die/0034.png"),
        new GreenfootImage("images/JayJay/die/0035.png"),
        new GreenfootImage("images/JayJay/die/0036.png"),
        new GreenfootImage("images/JayJay/die/0037.png"),
        new GreenfootImage("images/JayJay/die/0038.png"),
        new GreenfootImage("images/JayJay/die/0039.png"),
        new GreenfootImage("images/JayJay/die/0040.png"),
    });
    
    private static final Animation damage = new Animation(new GreenfootImage[] {
        new GreenfootImage("images/JayJay/damage/0001.png"),
        new GreenfootImage("images/JayJay/damage/0002.png"),
        new GreenfootImage("images/JayJay/damage/0003.png"),
        new GreenfootImage("images/JayJay/damage/0004.png"),
        new GreenfootImage("images/JayJay/damage/0005.png"),
        new GreenfootImage("images/JayJay/damage/0006.png"),
        new GreenfootImage("images/JayJay/damage/0007.png"),
        new GreenfootImage("images/JayJay/damage/0008.png"),
        new GreenfootImage("images/JayJay/damage/0009.png"),
        new GreenfootImage("images/JayJay/damage/0010.png"),
        new GreenfootImage("images/JayJay/damage/0011.png"),
        new GreenfootImage("images/JayJay/damage/0012.png"),
        new GreenfootImage("images/JayJay/damage/0013.png"),
        new GreenfootImage("images/JayJay/damage/0014.png"),
        new GreenfootImage("images/JayJay/damage/0015.png"),
        new GreenfootImage("images/JayJay/damage/0016.png"),
        new GreenfootImage("images/JayJay/damage/0017.png"),
        new GreenfootImage("images/JayJay/damage/0018.png"),
        new GreenfootImage("images/JayJay/damage/0019.png"),
        new GreenfootImage("images/JayJay/damage/0020.png"),
        new GreenfootImage("images/JayJay/damage/0021.png"),
        new GreenfootImage("images/JayJay/damage/0022.png"),
        new GreenfootImage("images/JayJay/damage/0023.png"),
        new GreenfootImage("images/JayJay/damage/0024.png"),
        new GreenfootImage("images/JayJay/damage/0025.png"),
        new GreenfootImage("images/JayJay/damage/0026.png"),
        new GreenfootImage("images/JayJay/damage/0027.png"),
        new GreenfootImage("images/JayJay/damage/0028.png"),
        new GreenfootImage("images/JayJay/damage/0029.png"),
        new GreenfootImage("images/JayJay/damage/0030.png"),
        new GreenfootImage("images/JayJay/damage/0031.png"),
        new GreenfootImage("images/JayJay/damage/0032.png"),
        new GreenfootImage("images/JayJay/damage/0033.png"),
        new GreenfootImage("images/JayJay/damage/0034.png"),
        new GreenfootImage("images/JayJay/damage/0035.png"),
        new GreenfootImage("images/JayJay/damage/0036.png"),
        new GreenfootImage("images/JayJay/damage/0037.png"),
        new GreenfootImage("images/JayJay/damage/0038.png"),
        new GreenfootImage("images/JayJay/damage/0039.png"),
        new GreenfootImage("images/JayJay/damage/0040.png"),
    });
}
