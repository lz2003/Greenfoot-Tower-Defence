import greenfoot.*;

/**
 * The Troll is decently speedy and has resistance to physical damage. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Troll extends Enemy 
{
    static GreenfootImage idle = new GreenfootImage("images/enemy/Troll/0/0001.png");
    /**
     * Constructor for Troll
     * 
     * @param x         the x coordinate of Troll
     * @param y         the y coordinate of Troll
     * @param image     image representing the Troll
     */
    public Troll(double x, double y) {
        super(x, y, idle, 1500, 50, 2, 0.2f, false, true);
    }
    
    private static Animation a0 = new Animation(new GreenfootImage[]{
        new GreenfootImage("images/enemy/Troll/0/0001.png"),
        new GreenfootImage("images/enemy/Troll/0/0002.png"),
        new GreenfootImage("images/enemy/Troll/0/0003.png"),
        new GreenfootImage("images/enemy/Troll/0/0004.png"),
        new GreenfootImage("images/enemy/Troll/0/0005.png"),
        new GreenfootImage("images/enemy/Troll/0/0006.png"),
        new GreenfootImage("images/enemy/Troll/0/0007.png"),
        new GreenfootImage("images/enemy/Troll/0/0008.png"),
        new GreenfootImage("images/enemy/Troll/0/0009.png"),
        new GreenfootImage("images/enemy/Troll/0/0010.png"),
        new GreenfootImage("images/enemy/Troll/0/0011.png"),
        new GreenfootImage("images/enemy/Troll/0/0012.png"),
        new GreenfootImage("images/enemy/Troll/0/0013.png"),
        new GreenfootImage("images/enemy/Troll/0/0014.png"),
        new GreenfootImage("images/enemy/Troll/0/0015.png"),
        new GreenfootImage("images/enemy/Troll/0/0016.png"),
        new GreenfootImage("images/enemy/Troll/0/0017.png"),
        new GreenfootImage("images/enemy/Troll/0/0018.png"),
        new GreenfootImage("images/enemy/Troll/0/0019.png"),
        new GreenfootImage("images/enemy/Troll/0/0020.png")
    }); 
    
    private static Animation a90 = new Animation(new GreenfootImage[]{
        new GreenfootImage("images/enemy/Troll/90/0001.png"),
        new GreenfootImage("images/enemy/Troll/90/0002.png"),
        new GreenfootImage("images/enemy/Troll/90/0003.png"),
        new GreenfootImage("images/enemy/Troll/90/0004.png"),
        new GreenfootImage("images/enemy/Troll/90/0005.png"),
        new GreenfootImage("images/enemy/Troll/90/0006.png"),
        new GreenfootImage("images/enemy/Troll/90/0007.png"),
        new GreenfootImage("images/enemy/Troll/90/0008.png"),
        new GreenfootImage("images/enemy/Troll/90/0009.png"),
        new GreenfootImage("images/enemy/Troll/90/0010.png"),
        new GreenfootImage("images/enemy/Troll/90/0011.png"),
        new GreenfootImage("images/enemy/Troll/90/0012.png"),
        new GreenfootImage("images/enemy/Troll/90/0013.png"),
        new GreenfootImage("images/enemy/Troll/90/0014.png"),
        new GreenfootImage("images/enemy/Troll/90/0015.png"),
        new GreenfootImage("images/enemy/Troll/90/0016.png"),
        new GreenfootImage("images/enemy/Troll/90/0017.png"),
        new GreenfootImage("images/enemy/Troll/90/0018.png"),
        new GreenfootImage("images/enemy/Troll/90/0019.png"),
        new GreenfootImage("images/enemy/Troll/90/0020.png")
    });
    
    private static Animation a180 = new Animation(new GreenfootImage[]{
        new GreenfootImage("images/enemy/Troll/180/0001.png"),
        new GreenfootImage("images/enemy/Troll/180/0002.png"),
        new GreenfootImage("images/enemy/Troll/180/0003.png"),
        new GreenfootImage("images/enemy/Troll/180/0004.png"),
        new GreenfootImage("images/enemy/Troll/180/0005.png"),
        new GreenfootImage("images/enemy/Troll/180/0006.png"),
        new GreenfootImage("images/enemy/Troll/180/0007.png"),
        new GreenfootImage("images/enemy/Troll/180/0008.png"),
        new GreenfootImage("images/enemy/Troll/180/0009.png"),
        new GreenfootImage("images/enemy/Troll/180/0010.png"),
        new GreenfootImage("images/enemy/Troll/180/0011.png"),
        new GreenfootImage("images/enemy/Troll/180/0012.png"),
        new GreenfootImage("images/enemy/Troll/180/0013.png"),
        new GreenfootImage("images/enemy/Troll/180/0014.png"),
        new GreenfootImage("images/enemy/Troll/180/0015.png"),
        new GreenfootImage("images/enemy/Troll/180/0016.png"),
        new GreenfootImage("images/enemy/Troll/180/0017.png"),
        new GreenfootImage("images/enemy/Troll/180/0018.png"),
        new GreenfootImage("images/enemy/Troll/180/0019.png"),
        new GreenfootImage("images/enemy/Troll/180/0020.png")
    });
    
    private static Animation a270 = new Animation(new GreenfootImage[]{
        new GreenfootImage("images/enemy/Troll/270/0001.png"),
        new GreenfootImage("images/enemy/Troll/270/0002.png"),
        new GreenfootImage("images/enemy/Troll/270/0003.png"),
        new GreenfootImage("images/enemy/Troll/270/0004.png"),
        new GreenfootImage("images/enemy/Troll/270/0005.png"),
        new GreenfootImage("images/enemy/Troll/270/0006.png"),
        new GreenfootImage("images/enemy/Troll/270/0007.png"),
        new GreenfootImage("images/enemy/Troll/270/0008.png"),
        new GreenfootImage("images/enemy/Troll/270/0009.png"),
        new GreenfootImage("images/enemy/Troll/270/0010.png"),
        new GreenfootImage("images/enemy/Troll/270/0011.png"),
        new GreenfootImage("images/enemy/Troll/270/0012.png"),
        new GreenfootImage("images/enemy/Troll/270/0013.png"),
        new GreenfootImage("images/enemy/Troll/270/0014.png"),
        new GreenfootImage("images/enemy/Troll/270/0015.png"),
        new GreenfootImage("images/enemy/Troll/270/0016.png"),
        new GreenfootImage("images/enemy/Troll/270/0017.png"),
        new GreenfootImage("images/enemy/Troll/270/0018.png"),
        new GreenfootImage("images/enemy/Troll/270/0019.png"),
        new GreenfootImage("images/enemy/Troll/270/0020.png")
    });
    
    private static double overPi = 180./Math.PI;
    
    public void _update(float delta) {
        super._update(delta);
        int angle = (int) (this.angle * overPi);
        angle += 720 + 45;
        angle = angle % 360;
        angle /= 90;

        switch(angle) {
            case 0:
                setAnimation(a0, 0.1f);
                break;
            case 1:
                setAnimation(a90, 0.1f);
                break;
            case 2:
                setAnimation(a180, 0.1f);
                break;
            case 3:
                setAnimation(a270, 0.1f);
                break;
        }
         
        animate(delta);
    }
}
