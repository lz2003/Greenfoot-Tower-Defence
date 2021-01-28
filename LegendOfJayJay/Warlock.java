import greenfoot.*;

/**
 * The warlock is a magical unit that has resistance to magical damage. It can attack from a distance.
 *
 * @author Rachel Tong
 * @author Young Chen
 * @version 2021-01-26
 */
public class Warlock extends Enemy 
{
    static GreenfootImage idle = new GreenfootImage("images/enemy/Warlock/0/0001.png");
    private static int damage = 120;

    private static Animation[] a0 = new Animation[] {
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/enemy/Warlock/0/0001.png"),
        new GreenfootImage("images/enemy/Warlock/0/0002.png"),
        new GreenfootImage("images/enemy/Warlock/0/0003.png"),
        new GreenfootImage("images/enemy/Warlock/0/0004.png"),
        new GreenfootImage("images/enemy/Warlock/0/0005.png"),
        new GreenfootImage("images/enemy/Warlock/0/0006.png"),
        new GreenfootImage("images/enemy/Warlock/0/0007.png"),
        new GreenfootImage("images/enemy/Warlock/0/0008.png"),
        new GreenfootImage("images/enemy/Warlock/0/0009.png"),
        new GreenfootImage("images/enemy/Warlock/0/0010.png"),
        new GreenfootImage("images/enemy/Warlock/0/0011.png"),
        new GreenfootImage("images/enemy/Warlock/0/0012.png"),
        new GreenfootImage("images/enemy/Warlock/0/0013.png"),
        new GreenfootImage("images/enemy/Warlock/0/0014.png"),
        new GreenfootImage("images/enemy/Warlock/0/0015.png"),
        new GreenfootImage("images/enemy/Warlock/0/0016.png"),
        new GreenfootImage("images/enemy/Warlock/0/0017.png"),
        new GreenfootImage("images/enemy/Warlock/0/0018.png"),
        new GreenfootImage("images/enemy/Warlock/0/0019.png"),
        new GreenfootImage("images/enemy/Warlock/0/0020.png")
    }),
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/enemy/Warlock/attack/0/0001.png"),
        new GreenfootImage("images/enemy/Warlock/attack/0/0002.png"),
        new GreenfootImage("images/enemy/Warlock/attack/0/0003.png"),
        new GreenfootImage("images/enemy/Warlock/attack/0/0004.png"),
        new GreenfootImage("images/enemy/Warlock/attack/0/0005.png"),
        new GreenfootImage("images/enemy/Warlock/attack/0/0006.png"),
        new GreenfootImage("images/enemy/Warlock/attack/0/0007.png"),
        new GreenfootImage("images/enemy/Warlock/attack/0/0008.png"),
        new GreenfootImage("images/enemy/Warlock/attack/0/0009.png"),
        new GreenfootImage("images/enemy/Warlock/attack/0/0010.png"),
        new GreenfootImage("images/enemy/Warlock/attack/0/0011.png"),
        new GreenfootImage("images/enemy/Warlock/attack/0/0012.png"),
        new GreenfootImage("images/enemy/Warlock/attack/0/0013.png"),
        new GreenfootImage("images/enemy/Warlock/attack/0/0014.png"),
        new GreenfootImage("images/enemy/Warlock/attack/0/0015.png"),
        new GreenfootImage("images/enemy/Warlock/attack/0/0016.png"),
        new GreenfootImage("images/enemy/Warlock/attack/0/0017.png"),
        new GreenfootImage("images/enemy/Warlock/attack/0/0018.png"),
        new GreenfootImage("images/enemy/Warlock/attack/0/0019.png"),
        new GreenfootImage("images/enemy/Warlock/attack/0/0020.png")
    })}; 
    
    private static Animation[] a90 = new Animation[] {
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/enemy/Warlock/90/0001.png"),
        new GreenfootImage("images/enemy/Warlock/90/0002.png"),
        new GreenfootImage("images/enemy/Warlock/90/0003.png"),
        new GreenfootImage("images/enemy/Warlock/90/0004.png"),
        new GreenfootImage("images/enemy/Warlock/90/0005.png"),
        new GreenfootImage("images/enemy/Warlock/90/0006.png"),
        new GreenfootImage("images/enemy/Warlock/90/0007.png"),
        new GreenfootImage("images/enemy/Warlock/90/0008.png"),
        new GreenfootImage("images/enemy/Warlock/90/0009.png"),
        new GreenfootImage("images/enemy/Warlock/90/0010.png"),
        new GreenfootImage("images/enemy/Warlock/90/0011.png"),
        new GreenfootImage("images/enemy/Warlock/90/0012.png"),
        new GreenfootImage("images/enemy/Warlock/90/0013.png"),
        new GreenfootImage("images/enemy/Warlock/90/0014.png"),
        new GreenfootImage("images/enemy/Warlock/90/0015.png"),
        new GreenfootImage("images/enemy/Warlock/90/0016.png"),
        new GreenfootImage("images/enemy/Warlock/90/0017.png"),
        new GreenfootImage("images/enemy/Warlock/90/0018.png"),
        new GreenfootImage("images/enemy/Warlock/90/0019.png"),
        new GreenfootImage("images/enemy/Warlock/90/0020.png")
    }),
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/enemy/Warlock/attack/90/0001.png"),
        new GreenfootImage("images/enemy/Warlock/attack/90/0002.png"),
        new GreenfootImage("images/enemy/Warlock/attack/90/0003.png"),
        new GreenfootImage("images/enemy/Warlock/attack/90/0004.png"),
        new GreenfootImage("images/enemy/Warlock/attack/90/0005.png"),
        new GreenfootImage("images/enemy/Warlock/attack/90/0006.png"),
        new GreenfootImage("images/enemy/Warlock/attack/90/0007.png"),
        new GreenfootImage("images/enemy/Warlock/attack/90/0008.png"),
        new GreenfootImage("images/enemy/Warlock/attack/90/0009.png"),
        new GreenfootImage("images/enemy/Warlock/attack/90/0010.png"),
        new GreenfootImage("images/enemy/Warlock/attack/90/0011.png"),
        new GreenfootImage("images/enemy/Warlock/attack/90/0012.png"),
        new GreenfootImage("images/enemy/Warlock/attack/90/0013.png"),
        new GreenfootImage("images/enemy/Warlock/attack/90/0014.png"),
        new GreenfootImage("images/enemy/Warlock/attack/90/0015.png"),
        new GreenfootImage("images/enemy/Warlock/attack/90/0016.png"),
        new GreenfootImage("images/enemy/Warlock/attack/90/0017.png"),
        new GreenfootImage("images/enemy/Warlock/attack/90/0018.png"),
        new GreenfootImage("images/enemy/Warlock/attack/90/0019.png"),
        new GreenfootImage("images/enemy/Warlock/attack/90/0020.png")
    })};  
    
    private static Animation[] a180 = new Animation[] {
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/enemy/Warlock/180/0001.png"),
        new GreenfootImage("images/enemy/Warlock/180/0002.png"),
        new GreenfootImage("images/enemy/Warlock/180/0003.png"),
        new GreenfootImage("images/enemy/Warlock/180/0004.png"),
        new GreenfootImage("images/enemy/Warlock/180/0005.png"),
        new GreenfootImage("images/enemy/Warlock/180/0006.png"),
        new GreenfootImage("images/enemy/Warlock/180/0007.png"),
        new GreenfootImage("images/enemy/Warlock/180/0008.png"),
        new GreenfootImage("images/enemy/Warlock/180/0009.png"),
        new GreenfootImage("images/enemy/Warlock/180/0010.png"),
        new GreenfootImage("images/enemy/Warlock/180/0011.png"),
        new GreenfootImage("images/enemy/Warlock/180/0012.png"),
        new GreenfootImage("images/enemy/Warlock/180/0013.png"),
        new GreenfootImage("images/enemy/Warlock/180/0014.png"),
        new GreenfootImage("images/enemy/Warlock/180/0015.png"),
        new GreenfootImage("images/enemy/Warlock/180/0016.png"),
        new GreenfootImage("images/enemy/Warlock/180/0017.png"),
        new GreenfootImage("images/enemy/Warlock/180/0018.png"),
        new GreenfootImage("images/enemy/Warlock/180/0019.png"),
        new GreenfootImage("images/enemy/Warlock/180/0020.png")
    }),
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/enemy/Warlock/attack/180/0001.png"),
        new GreenfootImage("images/enemy/Warlock/attack/180/0002.png"),
        new GreenfootImage("images/enemy/Warlock/attack/180/0003.png"),
        new GreenfootImage("images/enemy/Warlock/attack/180/0004.png"),
        new GreenfootImage("images/enemy/Warlock/attack/180/0005.png"),
        new GreenfootImage("images/enemy/Warlock/attack/180/0006.png"),
        new GreenfootImage("images/enemy/Warlock/attack/180/0007.png"),
        new GreenfootImage("images/enemy/Warlock/attack/180/0008.png"),
        new GreenfootImage("images/enemy/Warlock/attack/180/0009.png"),
        new GreenfootImage("images/enemy/Warlock/attack/180/0010.png"),
        new GreenfootImage("images/enemy/Warlock/attack/180/0011.png"),
        new GreenfootImage("images/enemy/Warlock/attack/180/0012.png"),
        new GreenfootImage("images/enemy/Warlock/attack/180/0013.png"),
        new GreenfootImage("images/enemy/Warlock/attack/180/0014.png"),
        new GreenfootImage("images/enemy/Warlock/attack/180/0015.png"),
        new GreenfootImage("images/enemy/Warlock/attack/180/0016.png"),
        new GreenfootImage("images/enemy/Warlock/attack/180/0017.png"),
        new GreenfootImage("images/enemy/Warlock/attack/180/0018.png"),
        new GreenfootImage("images/enemy/Warlock/attack/180/0019.png"),
        new GreenfootImage("images/enemy/Warlock/attack/180/0020.png")
    })}; 
    
    private static Animation[] a270 = new Animation[] {
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/enemy/Warlock/270/0001.png"),
        new GreenfootImage("images/enemy/Warlock/270/0002.png"),
        new GreenfootImage("images/enemy/Warlock/270/0003.png"),
        new GreenfootImage("images/enemy/Warlock/270/0004.png"),
        new GreenfootImage("images/enemy/Warlock/270/0005.png"),
        new GreenfootImage("images/enemy/Warlock/270/0006.png"),
        new GreenfootImage("images/enemy/Warlock/270/0007.png"),
        new GreenfootImage("images/enemy/Warlock/270/0008.png"),
        new GreenfootImage("images/enemy/Warlock/270/0009.png"),
        new GreenfootImage("images/enemy/Warlock/270/0010.png"),
        new GreenfootImage("images/enemy/Warlock/270/0011.png"),
        new GreenfootImage("images/enemy/Warlock/270/0012.png"),
        new GreenfootImage("images/enemy/Warlock/270/0013.png"),
        new GreenfootImage("images/enemy/Warlock/270/0014.png"),
        new GreenfootImage("images/enemy/Warlock/270/0015.png"),
        new GreenfootImage("images/enemy/Warlock/270/0016.png"),
        new GreenfootImage("images/enemy/Warlock/270/0017.png"),
        new GreenfootImage("images/enemy/Warlock/270/0018.png"),
        new GreenfootImage("images/enemy/Warlock/270/0019.png"),
        new GreenfootImage("images/enemy/Warlock/270/0020.png")
    }),
        new Animation(new GreenfootImage[]{
        new GreenfootImage("images/enemy/Warlock/attack/270/0001.png"),
        new GreenfootImage("images/enemy/Warlock/attack/270/0002.png"),
        new GreenfootImage("images/enemy/Warlock/attack/270/0003.png"),
        new GreenfootImage("images/enemy/Warlock/attack/270/0004.png"),
        new GreenfootImage("images/enemy/Warlock/attack/270/0005.png"),
        new GreenfootImage("images/enemy/Warlock/attack/270/0006.png"),
        new GreenfootImage("images/enemy/Warlock/attack/270/0007.png"),
        new GreenfootImage("images/enemy/Warlock/attack/270/0008.png"),
        new GreenfootImage("images/enemy/Warlock/attack/270/0009.png"),
        new GreenfootImage("images/enemy/Warlock/attack/270/0010.png"),
        new GreenfootImage("images/enemy/Warlock/attack/270/0011.png"),
        new GreenfootImage("images/enemy/Warlock/attack/270/0012.png"),
        new GreenfootImage("images/enemy/Warlock/attack/270/0013.png"),
        new GreenfootImage("images/enemy/Warlock/attack/270/0014.png"),
        new GreenfootImage("images/enemy/Warlock/attack/270/0015.png"),
        new GreenfootImage("images/enemy/Warlock/attack/270/0016.png"),
        new GreenfootImage("images/enemy/Warlock/attack/270/0017.png"),
        new GreenfootImage("images/enemy/Warlock/attack/270/0018.png"),
        new GreenfootImage("images/enemy/Warlock/attack/270/0019.png"),
        new GreenfootImage("images/enemy/Warlock/attack/270/0020.png")
    })}; 
    
    private static double overPi = 180./Math.PI;
    boolean canAttack = false;
    
    /**
     * Creates a warlock
     * 
     * @param x         the x coordinate of Warlock
     * @param y         the y coordinate of Warlock
     */
    public Warlock(double x, double y) {
        super(x, y, idle, 125, 50, 8, 0.15f, true, false);
        range = 550;
        rangeSquared = range * range;
        SoundManager.enemySounds(1);
    }

    /**
     * Warlock update method
     * @param delta Change in time since last update
     */
    public void _update(float delta) {
        if(!canAttack) {
            super._update(delta);
        } else {
            coolDown -= delta;
            checkCanAttack(delta);
            updateHP();
        }
        int angle = (int) (this.angle * overPi);
        angle += 720 + 45;
        angle = angle % 360;
        angle /= 90;

        int index = 0;
        if(coolDown > 0) {
            index = 1;
        }
        
        float dur = canAttack ? coolDownTime / 40f : 0.1f;

        switch(angle) {
            case 0:
                setAnimation(a0[index], dur);
                break;
            case 1:
                setAnimation(a90[index], dur);
                break;
            case 2:
                setAnimation(a180[index], dur);
                break;
            case 3:
                setAnimation(a270[index], dur);
                break;
        }
         
        if(getFrameIndex() == 11 && canAttack) {
            attack();
            setFrameIndex(12);
        }
        animate(delta);
    }

    /**
     * Checks whether or not it can attack
     * @param delta change in time since last update
     */
    protected void checkCanAttack(float delta) {
        coolDown -= delta;
        if(Math2D.distanceSquared(Global.manager.getTargetX(), getX(), Global.manager.getTargetY(), getY()) < rangeSquared) {
            canAttack = true;
            if(coolDown < 0) {
                setFrameIndex(0);
                //attack();
                coolDown = coolDownTime;
            }   
        } else canAttack = false;
    }
    
    /**
     * Attack to damage JayJay the Dragon
     */
    public void attack() {
        Global.getManager().damageJayJay(damage);
        new Explosion(Global.getManager().getJayJay().getX(), Global.getManager().getJayJay().getY());
    }
}
