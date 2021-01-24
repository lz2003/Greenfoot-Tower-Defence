import greenfoot.*;

/**
 * Play sounds and music for the game. 
 * 
 * @author Lucy Zhao
 * @version (a version number or a date)
 */
public class SoundManager  
{
    // Projectile sounds
    private static GreenfootSound ARROW = new GreenfootSound("sounds/arrow.wav");
    private static GreenfootSound CANNON = new GreenfootSound("sounds/cannon.wav");
    private static GreenfootSound FIRE = new GreenfootSound("sounds/fire.wav");
    private static GreenfootSound ICE = new GreenfootSound("sounds/ice.wav");
    private static GreenfootSound ZAP = new GreenfootSound("sounds/zap.wav");
    private static GreenfootSound EXPLODE = new GreenfootSound("sounds/explosion.wav");
    
    // Enemy sounds
    private static GreenfootSound MANIAC = new GreenfootSound("sounds/barbarianDeploy.wav");
    private static GreenfootSound WARLOCK = new GreenfootSound("sounds/warlockDeploy.wav");
    private static GreenfootSound PEKKA = new GreenfootSound("sounds/pekka.wav");
    private static GreenfootSound GOLEM = new GreenfootSound("sounds/golem.wav");
    private static GreenfootSound ENEMY_ATK = new GreenfootSound("sounds/swordAttack.wav");

    // Tower sounds
    private static GreenfootSound PLACE = new GreenfootSound("sounds/placeItem.wav");
    private static GreenfootSound UPGRADE = new GreenfootSound("sounds/towerPowerup.wav");
    private static GreenfootSound WALL = new GreenfootSound("sounds/placeWall.wav");
    
    // UI sounds
    private static GreenfootSound BUTTON = new GreenfootSound("sounds/button.wav");
    private static GreenfootSound GOLD = new GreenfootSound("sounds/goldSmall.wav");
    private static GreenfootSound WIN = new GreenfootSound("sounds/completeLevel.wav");
    
    /**
     * Method to adjust all volumes of sound (sound be called once at
     * the beginning)
     */
    public static void adjustVolume() {
        ARROW.setVolume(70);
        CANNON.setVolume(50);
        EXPLODE.setVolume(50);
    }
    
    /**
     * Plays projectile sounds
     */
    public static void projectileSounds(int id) {
        switch (id) {
            case 0:
                playSound(ARROW);
                break;
            case 1:
                playSound(CANNON);
                break;
            case 2:
                playSound(FIRE);
                break;
            case 3:
                playSound(ICE);
                break;
            case 4:
                playSound(ZAP);
                break;
            case 5:
                playSound(EXPLODE);
                break;
        }
    }
    
    /**
     * Plays enemy sounds
     */
    public static void enemySounds(int id) {
        switch (id) {
            case 0:
                playSound(MANIAC);
                break;
            case 1:
                playSound(WARLOCK);
                break;
            case 2:
                playSound(PEKKA);
                break;
            case 3:
                playSound(GOLEM);
                break;
            case 4:
                playSound(ENEMY_ATK);
                break;
        }
    }
    
    /**
     * Plays tower sounds
     */
    public static void towerSounds(int id) {
        switch (id) {
            case 0:
                playSound(PLACE);
                break;
            case 1:
                playSound(UPGRADE);
                break;
            case 2:
                playSound(WALL);
                break;
        }
    }
    
    /**
     * Plays ui/general sounds
     */
    public static void uiSounds(int id) {
        switch (id) {
            case 0:
                playSound(BUTTON);
                break;
            case 1:
                playSound(GOLD);
                break;
            case 2:
                playSound(WIN);
                break;
        }
    }
    
    /**
     * Actually plays the sound
     */
    public static void playSound(GreenfootSound sound) {
        try { 
            if (!sound.isPlaying()) {
                sound.play();
            }
        } catch (Exception e) {
            System.out.println("Sound failed to play");
        }
    }
    
    /**
     * Stops a specified sound (mostly for music)
     */
    public static void stopSound(GreenfootSound sound) {
        try {
            if (sound.isPlaying()) {
                sound.stop();
            }
        } catch (Exception e) {
            System.out.println("Error occured with stopping sound");
        }
    }
}
