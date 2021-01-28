import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.core.WorldHandler;  
import java.io.IOException;
import java.io.File;
import java.util.*;

/**
 * World where the game takes place
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
