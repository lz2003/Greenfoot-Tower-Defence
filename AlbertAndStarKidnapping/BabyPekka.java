import greenfoot.*;

/**
 * The Baby Pekka is a small unit that has above average health and damage and is very speedy. 
 *
 * @author Rachel Tong
 * @author Young Chen
 * @version 2021-01-26
 */
public class BabyPekka extends Enemy 
{
    private float damage = 20;
    static GreenfootImage idle = new GreenfootImage("images/enemy/BabyPekka/0/0001.png");
    /**
     * Creates a baby pekka at the indicated location
     * 
     * @param x         the x coordinate of BabyPekka
     * @param y         the y coordinate of BabyPekka
     */
    public BabyPekka(double x, double y) {
        super(x, y, idle, 2500, 100, 2, 0.35f, true, false);
    }
    
    private static Animation[] a0 = new Animation[] {
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/enemy/BabyPekka/0/0001.png"),
        new GreenfootImage("images/enemy/BabyPekka/0/0002.png"),
        new GreenfootImage("images/enemy/BabyPekka/0/0003.png"),
        new GreenfootImage("images/enemy/BabyPekka/0/0004.png"),
        new GreenfootImage("images/enemy/BabyPekka/0/0005.png"),
        new GreenfootImage("images/enemy/BabyPekka/0/0006.png"),
        new GreenfootImage("images/enemy/BabyPekka/0/0007.png"),
        new GreenfootImage("images/enemy/BabyPekka/0/0008.png"),
        new GreenfootImage("images/enemy/BabyPekka/0/0009.png"),
        new GreenfootImage("images/enemy/BabyPekka/0/0010.png"),
        new GreenfootImage("images/enemy/BabyPekka/0/0011.png"),
        new GreenfootImage("images/enemy/BabyPekka/0/0012.png"),
        new GreenfootImage("images/enemy/BabyPekka/0/0013.png"),
        new GreenfootImage("images/enemy/BabyPekka/0/0014.png"),
        new GreenfootImage("images/enemy/BabyPekka/0/0015.png"),
        new GreenfootImage("images/enemy/BabyPekka/0/0016.png"),
        new GreenfootImage("images/enemy/BabyPekka/0/0017.png"),
        new GreenfootImage("images/enemy/BabyPekka/0/0018.png"),
        new GreenfootImage("images/enemy/BabyPekka/0/0019.png"),
        new GreenfootImage("images/enemy/BabyPekka/0/0020.png")
    }),
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/enemy/BabyPekka/attack/0/0001.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/0/0002.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/0/0003.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/0/0004.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/0/0005.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/0/0006.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/0/0007.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/0/0008.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/0/0009.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/0/0010.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/0/0011.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/0/0012.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/0/0013.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/0/0014.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/0/0015.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/0/0016.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/0/0017.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/0/0018.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/0/0019.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/0/0020.png")
    })}; 
    
    private static Animation[] a90 = new Animation[] {
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/enemy/BabyPekka/90/0001.png"),
        new GreenfootImage("images/enemy/BabyPekka/90/0002.png"),
        new GreenfootImage("images/enemy/BabyPekka/90/0003.png"),
        new GreenfootImage("images/enemy/BabyPekka/90/0004.png"),
        new GreenfootImage("images/enemy/BabyPekka/90/0005.png"),
        new GreenfootImage("images/enemy/BabyPekka/90/0006.png"),
        new GreenfootImage("images/enemy/BabyPekka/90/0007.png"),
        new GreenfootImage("images/enemy/BabyPekka/90/0008.png"),
        new GreenfootImage("images/enemy/BabyPekka/90/0009.png"),
        new GreenfootImage("images/enemy/BabyPekka/90/0010.png"),
        new GreenfootImage("images/enemy/BabyPekka/90/0011.png"),
        new GreenfootImage("images/enemy/BabyPekka/90/0012.png"),
        new GreenfootImage("images/enemy/BabyPekka/90/0013.png"),
        new GreenfootImage("images/enemy/BabyPekka/90/0014.png"),
        new GreenfootImage("images/enemy/BabyPekka/90/0015.png"),
        new GreenfootImage("images/enemy/BabyPekka/90/0016.png"),
        new GreenfootImage("images/enemy/BabyPekka/90/0017.png"),
        new GreenfootImage("images/enemy/BabyPekka/90/0018.png"),
        new GreenfootImage("images/enemy/BabyPekka/90/0019.png"),
        new GreenfootImage("images/enemy/BabyPekka/90/0020.png")
    }),
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/enemy/BabyPekka/attack/90/0001.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/90/0002.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/90/0003.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/90/0004.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/90/0005.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/90/0006.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/90/0007.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/90/0008.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/90/0009.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/90/0010.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/90/0011.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/90/0012.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/90/0013.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/90/0014.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/90/0015.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/90/0016.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/90/0017.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/90/0018.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/90/0019.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/90/0020.png")
    })};  
    
    private static Animation[] a180 = new Animation[] {
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/enemy/BabyPekka/180/0001.png"),
        new GreenfootImage("images/enemy/BabyPekka/180/0002.png"),
        new GreenfootImage("images/enemy/BabyPekka/180/0003.png"),
        new GreenfootImage("images/enemy/BabyPekka/180/0004.png"),
        new GreenfootImage("images/enemy/BabyPekka/180/0005.png"),
        new GreenfootImage("images/enemy/BabyPekka/180/0006.png"),
        new GreenfootImage("images/enemy/BabyPekka/180/0007.png"),
        new GreenfootImage("images/enemy/BabyPekka/180/0008.png"),
        new GreenfootImage("images/enemy/BabyPekka/180/0009.png"),
        new GreenfootImage("images/enemy/BabyPekka/180/0010.png"),
        new GreenfootImage("images/enemy/BabyPekka/180/0011.png"),
        new GreenfootImage("images/enemy/BabyPekka/180/0012.png"),
        new GreenfootImage("images/enemy/BabyPekka/180/0013.png"),
        new GreenfootImage("images/enemy/BabyPekka/180/0014.png"),
        new GreenfootImage("images/enemy/BabyPekka/180/0015.png"),
        new GreenfootImage("images/enemy/BabyPekka/180/0016.png"),
        new GreenfootImage("images/enemy/BabyPekka/180/0017.png"),
        new GreenfootImage("images/enemy/BabyPekka/180/0018.png"),
        new GreenfootImage("images/enemy/BabyPekka/180/0019.png"),
        new GreenfootImage("images/enemy/BabyPekka/180/0020.png")
    }),
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/enemy/BabyPekka/attack/180/0001.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/180/0002.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/180/0003.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/180/0004.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/180/0005.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/180/0006.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/180/0007.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/180/0008.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/180/0009.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/180/0010.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/180/0011.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/180/0012.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/180/0013.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/180/0014.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/180/0015.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/180/0016.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/180/0017.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/180/0018.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/180/0019.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/180/0020.png")
    })}; 
    
    private static Animation[] a270 = new Animation[] {
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/enemy/BabyPekka/270/0001.png"),
        new GreenfootImage("images/enemy/BabyPekka/270/0002.png"),
        new GreenfootImage("images/enemy/BabyPekka/270/0003.png"),
        new GreenfootImage("images/enemy/BabyPekka/270/0004.png"),
        new GreenfootImage("images/enemy/BabyPekka/270/0005.png"),
        new GreenfootImage("images/enemy/BabyPekka/270/0006.png"),
        new GreenfootImage("images/enemy/BabyPekka/270/0007.png"),
        new GreenfootImage("images/enemy/BabyPekka/270/0008.png"),
        new GreenfootImage("images/enemy/BabyPekka/270/0009.png"),
        new GreenfootImage("images/enemy/BabyPekka/270/0010.png"),
        new GreenfootImage("images/enemy/BabyPekka/270/0011.png"),
        new GreenfootImage("images/enemy/BabyPekka/270/0012.png"),
        new GreenfootImage("images/enemy/BabyPekka/270/0013.png"),
        new GreenfootImage("images/enemy/BabyPekka/270/0014.png"),
        new GreenfootImage("images/enemy/BabyPekka/270/0015.png"),
        new GreenfootImage("images/enemy/BabyPekka/270/0016.png"),
        new GreenfootImage("images/enemy/BabyPekka/270/0017.png"),
        new GreenfootImage("images/enemy/BabyPekka/270/0018.png"),
        new GreenfootImage("images/enemy/BabyPekka/270/0019.png"),
        new GreenfootImage("images/enemy/BabyPekka/270/0020.png")
    }),
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/enemy/BabyPekka/attack/270/0001.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/270/0002.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/270/0003.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/270/0004.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/270/0005.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/270/0006.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/270/0007.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/270/0008.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/270/0009.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/270/0010.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/270/0011.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/270/0012.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/270/0013.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/270/0014.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/270/0015.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/270/0016.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/270/0017.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/270/0018.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/270/0019.png"),
        new GreenfootImage("images/enemy/BabyPekka/attack/270/0020.png")
    })}; 
    
    private static double overPi = 180./Math.PI;

    /**
     * Update method
     * @param delta Change in time since last update
     */
    public void _update(float delta) {
        super._update(delta);
        int angle = (int) (this.angle * overPi);
        angle += 720 + 45;
        angle = angle % 360;
        angle /= 90;

        int index = 0;
        if(coolDown > 0) {
            index = 1;
        }
        
        switch(angle) {
            case 0:
                setAnimation(a0[index], 0.1f);
                break;
            case 1:
                setAnimation(a90[index], 0.1f);
                break;
            case 2:
                setAnimation(a180[index], 0.1f);
                break;
            case 3:
                setAnimation(a270[index], 0.1f);
                break;
        }
         
        animate(delta);
    }
    
    /**
     * Attack to damage JayJay the Dragon
     */
    public void attack() {
        Global.getManager().damageJayJay(damage);
    }
}
