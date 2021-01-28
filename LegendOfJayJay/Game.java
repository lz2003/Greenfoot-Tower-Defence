import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.core.WorldHandler;  
import java.io.IOException;
import java.io.File;
import java.util.*;

/**
 * World where the game takes place
 * 
 * Credits for assets: <br>
 * <b>Sounds</b>
 * https://www.youtube.com/watch?v=HoiU2vfJxhA
 * <li>0.06: upgrade</li>
 * <li>0:23: place tower</li>
 * <li>0.24: arrowhit</li>
 * <li>0:32: barbarian deploy</li>
 * <li>0:37 melee attack</li>
 * <li>1:08: upgrade</li>
 * <li>1:10: button click</li>
 * <li>1:11: cannon</li>
 * <li>1:16-19: collect gold</li>
 * <li>1:27: pekka</li>
 * <li>1:39 explosion</li>
 * <li>1:43 freeze spell</li>
 * <li>1:48 tower powerup</li>
 * <li>2:11 healer attack</li>
 * <li>2:30 mage attack</li>
 * <li>2:34 mage deploy</li>
 * <li>2:37 mortar attack</li>
 * <li>2:52 golem</li>
 * <li>2:57-2:59 zap/tesla</li>
 * <li>3:01 spring trap</li>
 * <li>3:16 wall place</li>
 * <li>3:29 complete level</li>
 * <br>
 * <b>Music</b>
 * <li>https://www.youtube.com/watch?v=thbts1Vf948 </li>
 * <li>https://www.youtube.com/watch?v=72PhV7wQr5Y </li>
 * <li>https://www.youtube.com/watch?v=CRIk6Z0lJhE </li>
 * <li>https://www.youtube.com/watch?v=f04N04uFyIM </li>
 * <li>https://www.youtube.com/watch?v=ZBFw6kkh4-M </li>
 * <li>https://www.youtube.com/watch?v=0ELE9Jv-4p4 </li>
 * <li>https://www.youtube.com/watch?v=VWBF0Zonqck </li>
 * <li>https://www.youtube.com/watch?v=ptrUUOxTF8c </li>
 * <br>
 * <b> Images/Sprites </b>
 * <br>
 * <i>Towers + Tower Units</i>
 * 
 * <li>Barracks https://za.pinterest.com/pin/822329213183384106/?amp_client_id=CLIENT_ID(_)&mweb_unauth_id=&simplified=true 
 * <li>Gold Mines https://heavy.com/games/2014/11/clash-of-clans-cheats-top-tips-for-gold-mines/2/ 
 * <br>
 * <i>Projectiles</i>
 * 
 * <li>Fireballs https://www.123rf.com/photo_110800607_stock-vector-fire-ball-animated-flaming-fireball-hot-flying-flame-and-warm-fireballs-2d-animation-frames-for-game.html
 * <li>Cartoon Arrow https://www.istockphoto.com/vector/cartoon-shooting-arrow-gm518203581-49578308
 * <li>Iceball https://www.nicepng.com/ourpic/u2q8i1w7e6t4y3a9_iceball-ice-mario/ 
 * <li>Cannonball/ Mortar shells https://www.subpng.com/png-ns2qkl/ 
 * <li>Explosion https://opengameart.org/content/pixel-art-explosion-animation 
 * <br>
 * <i>Shop</i>
 * 
 * <li>BarbarianHutCard https://clashroyale.fandom.com/wiki/Cards
 * <br>
 * <i>CutScenes + Backgrounds</i>
 * 
 * <li>Player/Bennet, Iroh/Albedo, Koyen/Childe, Council/Sucrose, YajYaj/ Kaeya https://genshin.mihoyo.com/en/character/mondstadt?char=2
 * <li>dark and light castle https://wallpaperaccess.com/anime-castle
 * <li>inside castle https://cutewallpaper.org/21/anime-castle-background/view-page-21.html 
 * <li>war ground https://www.wallpaperflare.com/search?wallpaper=war+zone
 * <br>
 * <i>Background</i>
 * 
 * <li>Grass https://webstockreview.net/images/daisies-clipart-grass-prairie-16.png
 * <li>Sand https://thumbs.dreamstime.com/b/sand-texture-11053497.jpg 
 * <br>
 * <i>Other</i>
 * 
 * <li>greenfoot logo (info screen) https://upload.wikimedia.org/wikipedia/commons/4/43/Greenfoot_Logo.jpg
 * <li> Jay Jay - https://www.youtube.com/watch?v=-51AfyMqnpI&ab_channel=JayJaytheJetPlane-OfficialChannel 
 * 
 * @author Ryan Lin
 * @author Young Chen
 * @version 2021-01-26
 */
public class Game extends World
{
    public static final int canvasWidth = 850, canvasHeight = 600;
    public static final int worldWidth = 925, worldHeight = 750;
    private ObjectManager manager;
    private Canvas canvas;
    CircleMask mask;
    TowerDisplay towerDisplay;
    private boolean isCampaign;
    private boolean isEditor;
    
    private int musicID;
    private boolean musicPlaying = true;
    private GreenfootSound storyMusic = new GreenfootSound("sounds/music/intenseMusic2.mp3");
    private GreenfootSound regularMusic = new GreenfootSound("sounds/music/intenseMusic3.mp3");
    private GreenfootSound mapMusic = new GreenfootSound("sounds/music/calmMusic.mp3");

    /**
     * Creates a default game
     */
    public Game() {    
        this(false, true);
    }

    /**
     * Creates a game with options to load from autosave.owo and whether or not story mode has been selected
     * @param autoLoad whether or not to load from previous session
     * @param isCampaign whether or not story mode is selected
     */
    public Game(boolean autoLoad, boolean isCampaign) {
        this(autoLoad, isCampaign, false);
    }

    /**
     * Creates a game with options to load from autosave.owo, whether or not story mode has been selected,
     * and whether or not the world is a map editor
     *
     * @param autoload whether or not to load from previous session
     * @param isCampaign whether or not story mode is selected
     * @param editor whether or not the world is an editor
     */
    public Game(boolean autoload, boolean isCampaign, boolean editor) {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(worldWidth, worldHeight, 1, false); 
        
        setPaintOrder(DissappearingText.class, BuildCursor.class, Canvas.class);
        
        Global.setWorld(this);
        
        canvas = new Canvas(15, canvasWidth, canvasHeight);
        
        Sprite.setGlobalCanvas(canvas);
        
        manager = new ObjectManager(editor);
        
        Global.manager = manager;
        
        manager.init();
        
        addObject(canvas, 850 / 2, getHeight() / 2 - 75);
        
        int labelY = 620;
        
        addObject(new MoneyText(5, labelY), 5 , labelY);
        
        labelY += 30;
        addObject(new LevelText(5, labelY), 5 , labelY);

        //towerText = new TowerText(400, 620);
        //addObject(towerText, 400, 620);
        //towerLevel = new TowerLevel(400, 650);
        //addObject(towerLevel, 400, 650);
        
        towerDisplay = new TowerDisplay();
        addObject(towerDisplay, 600, 660);
        
        int y = 715;
        
        addObject(new HomeButton(), 45, y);
        addObject(new FastForwardButton(), 45 + 75 + 10, y);
        addObject(new SaveButton(), 45 + 75 + 75 + 20, y);
        addObject(new ReadButton(), 45 + 75 + 75 + + 75 + 30, y);
        
        mask = new CircleMask();
        
        setBackground("bkg.png");
        
        this.isCampaign = isCampaign;
        this.isEditor = editor;
        
        storyMusic = new GreenfootSound("sounds/music/intenseMusic2.mp3");
        regularMusic = new GreenfootSound("sounds/music/intenseMusic3.mp3");
        mapMusic = new GreenfootSound("sounds/music/calmMusic.mp3");

        
        if (isCampaign) musicID = 0;
        else musicID = 1;
        
        if (isEditor) musicID = 2;
        
        storyMusic.setVolume(50);
        regularMusic.setVolume(50);
        mapMusic.setVolume(60);
        
        init();
        
        if(autoload) {
            try {
                SavedInstance.read(SavedInstance.AUTO_SAVE_PATH);
            } catch(IOException e) {}
        }
    }

    /**
     * Initialises UI
     */
    public void init() {
        ButtonGrid b = new ButtonGrid();
        addObject(b, 887, 45);
        
        Button[] buttons;
        
        if(!isEditor)
            buttons = new Button[]{
                new TowerButton(TowerButton.ARCH),
                new TowerButton(TowerButton.ARTY),
                new TowerButton(TowerButton.BARA),
                new TowerButton(TowerButton.FIRE),
                new TowerButton(TowerButton.ICE),
                new TowerButton(TowerButton.LAZER),
                new TowerButton(TowerButton.MINE),
                new TowerButton(TowerButton.PILL),
            };
        else 
            buttons = new Button[]{
                new TowerButton(TowerButton.ARCH),
                new TowerButton(TowerButton.ARTY),
                new TowerButton(TowerButton.BARA),
                new TowerButton(TowerButton.FIRE),
                new TowerButton(TowerButton.ICE),
                new TowerButton(TowerButton.LAZER),
                new TowerButton(TowerButton.MINE),
                new TowerButton(TowerButton.PILL),
                new TowerButton(TowerButton.WALL)
            };

        b.set(
            buttons, 1, 10, 77
        );
        
        BuildCursor.init();
    }

    /**
     * Actor act method
     */
    public void act() {
        manager.update();
        if (musicPlaying) playMusic();
    }
    
    /**
     * Plays music
     */
    public void playMusic() {
        if (musicID == 0) SoundManager.playSound(storyMusic);
        else if (musicID == 1) SoundManager.playSound(regularMusic);
        else SoundManager.playSound(mapMusic);
    }
    
    /**
     * Stops music
     */
    public void stopMusic() {
        if (musicID == 0) SoundManager.stopSound(storyMusic);
        else if (musicID == 1) SoundManager.stopSound(regularMusic);
        else SoundManager.stopSound(mapMusic);
        musicPlaying = false;
    }
    
    /**
     * Whether or not game is in story mode
     * @return Whether or not game is in story mode
     */
    public boolean isCampaign() {
        return isCampaign;
    }

    /**
     * Whether or not world is an editor
     * @return Whether or not world is an editor
     */
    public boolean isEditor() {
        return isEditor;
    }

    /**
     * Updates tower mask
     * @param tower target tower
     */
    public void updateMask(Tower tower){
        mask.show(tower);
    }
}
