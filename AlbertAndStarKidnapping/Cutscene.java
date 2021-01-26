import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This world displays cutscenes. 
 * When the world is created, it takes a scene number and then calls the method to display the corresponding scene. 
 * The textbox along with its corresponding image will appear with a new background. 
 * The scenes are used to tell a story or display any text written by using the addText method in the Textbox class
 * The user can read it visual novel style by pressing the enter key. 
 * 
 * @author Rachel Tong 
 * @version Jan 2020
 */
public class Cutscene extends World
{
    public static final int LEVELS_PER_CUTSCENE = 5;
    public static final int TOTAL_CUTSCENES = 7;
    //Background images
    private static GreenfootImage lightCastle = new GreenfootImage("images/cutscene/lc.jpeg");
    private static GreenfootImage insideCastle = new GreenfootImage("images/cutscene/ic.jpeg");
    private static GreenfootImage darkCastle = new GreenfootImage("images/cutscene/dc.jpeg");
    
    //Character images
    private static GreenfootImage player = new GreenfootImage("images/cutscene/bennet.png");
    private static GreenfootImage iroh = new GreenfootImage("images/cutscene/albedo.png");
    private static GreenfootImage koyen = new GreenfootImage("images/cutscene/childe.png");
    private static GreenfootImage jayjay = new GreenfootImage("images/cutscene/kaeya.png");
    private static GreenfootImage council = new GreenfootImage("images/cutscene/sucrose.png");
    
    //Current scene being displayed
    public int sceneNum;
    
    //Declare textboxes
    private Textbox textBox;
    private Textbox textBox2;
    private Textbox textBox3;
    private Textbox textBox4;
    private Textbox textBox5;
    private Textbox textBox6;
    private Textbox textBox7;
    /**
     * Constructor for world. Creates an AbilityButton to demonstrate how it works.
     * 
     * @param sceneNum      number to determine what scene is being displayed
     */
    public Cutscene(int sceneNum)
    {    
        // Create a new world with 850x600 cells with a cell size of 1x1 pixels.
        super(925, 750, 1); 
        
        //Adds the textbox to the world, sets first text/diaglogue and corresponding first character image
        textBox = new Textbox("*Present Time*", "Courier New", 20, 500, 100, 6, Color.WHITE, Color.BLACK, koyen);
        textBox2 = new Textbox("My spidey senses are tingling. The\nground is shaking. Koyen is coming.", "Courier New", 20, 500, 100, 6, Color.WHITE, Color.BLACK, player);
        textBox3 = new Textbox("*10 Years Ago*", "Courier New", 20, 500, 100, 6, Color.WHITE, Color.BLACK, iroh);
        textBox4 = new Textbox("Let me just cut to the chase", "Courier New", 20, 500, 100, 6, Color.WHITE, Color.BLACK, koyen);
        textBox5 = new Textbox("It’s been 3 months already, why\nhaven’t the council crowned me King.", "Courier New", 20, 500, 100, 6, Color.WHITE, Color.BLACK, koyen);
        textBox6 = new Textbox("*5 Years Ago*", "Courier New", 20, 500, 100, 6, Color.WHITE, Color.BLACK, council);
        textBox7 = new Textbox("Its time to finally get revenge\nfor my father. We pushed the war back\nto your turf.", "Courier New", 20, 500, 100, 6, Color.WHITE, Color.BLACK, player);
        
        //Variable to display chosen scene
        this.sceneNum = sceneNum;
        switch(sceneNum)
        {
                case 1:
                    scene1();
                    break;
                case 2:
                    scene2();
                    break;
                case 3:
                    scene3();
                    break;
                case 4:
                    scene4();
                    break;
                case 5:
                    scene5();
                    break;
                case 6:
                    scene6();
                    break;
                case 7:
                    scene7();
                    break;
        }
        //Ensures that the textbox is in front of the background and character image. 
        setPaintOrder(Textbox.class);
    }
    
    /**
     * Act method to update what the textbox is displaying when the user presses the enter key
     */
    public void act()
    {
        //changes string text
        String key = Greenfoot.getKey();
        
        if ("enter".equals(key) || "space".equals(key) || Greenfoot.mouseClicked(null))
        {
            textBox.updateText();
            textBox2.updateText();
            textBox3.updateText();
            textBox4.updateText();
            textBox5.updateText();
            textBox6.updateText();
            textBox7.updateText();
        }
    }
    
    public void scene1()
    {
        setBackground(darkCastle);
        addObject(textBox, 425, 600);
        textBox.addText("If I am going to get back what truly belongs to \nme, I, the great Firelord and Pope of the church \nof Greenfoot, the mighty Koyen Zordan Klean,", koyen);
        textBox.addText("better act now. After all these years I have \nfinally built a kingdom and a strong enough\narmy to take him down.", koyen);
        textBox.addText("Harnessing the power from the God of\nGreenfoot, the only thing in my way is\nthat dragon of his.", koyen);
        textBox.addText("It’s already getting too strong for my\nliking. General, it's time to prepare\nfor war! Huehuehuehue!", koyen);
    }
    
    public void scene2()
    {
        setBackground(lightCastle);
        addObject(textBox2, 425, 600);
        textBox2.addText("He must be behind all this fighting.", player);
        textBox2.addText("I may be young, but I have prepared\nfor this moment ever since I became\nking.", player);
        textBox2.addText("I’ll never forget the pain he caused\nme.", player);
        textBox2.addText("You’ve raised me well, I’m shall \ndefend this kingdom with my life.\n Jay jay jaaaaaaaay!", jayjay);
    }
    
    public void scene3()
    {
        setBackground(insideCastle);
        addObject(textBox3, 425, 600);
        textBox3.addText("What’s up step bro? It isn’t often that\nyou visit me.", iroh);
        textBox3.addText("Take some advice and speak more\nformally. You are the king after all,\nbut not for long though.", koyen);
        textBox3.addText("What does that mean? Is there\nsomething else you prefer I call you?\nHow about Happyfeet instead.", iroh);
        textBox3.addText("I’ve been thinking. The Fireload and \nPope of Greenfoot has much more\npower than the king.", koyen);
        textBox3.addText("People are more willing to follow religion \nthan some temporary king. Wouldn’t it\nbe easier if I was both.", koyen);
    }
    
    public void scene4()
    {
        setBackground(insideCastle);
        addObject(textBox4, 425, 600);
        textBox4.addText("*BANG*", koyen);
        textBox4.addText("Oof! ahdlhalhruhghjhj! Where did\nyou get a gun? Those weren’t invented\nuntil the 15th century.", iroh);
        textBox4.addText("Foot magic. Now I’m going to evil\nmonologue and tell you how I’ll get\naway with murder. Mwahahaha!", koyen);
        textBox4.addText("I’ll tell the servants that I\njust walked in here and for some reason\nyou were covered in holes like cheese.", koyen);
        textBox4.addText("You’ll never get away with this.", iroh);
        textBox4.addText("I will, scowoby doo doesn’t exist\nin our universe.", koyen);
    }
    
    public void scene5()
    {
        setBackground(insideCastle);
        addObject(textBox5, 425, 600);
        textBox5.addText("Following the death of King Iroh,\nhis son soon became the successor\nand inherited the throne.", council);
        textBox5.addText("What! He doesn’t have a son", koyen);
        textBox5.addText("His highness was going to be\nintroduced him to you the day you visited.", council);
        textBox5.addText("Before he could, he witnessed\nyou kill his father.", council);
        textBox5.addText("*Koyen escapes*", koyen);
    }
    
    public void scene6()
    {
        setBackground(lightCastle);
        addObject(textBox6, 425, 600);
        textBox6.addText("King, a baby dragon was left\non your doorstep", council);
        textBox6.addText("What in the world is this \nabomination?", player);
        textBox6.addText("Jay jay! Jay jay jay! Jay! Jay\njay jay jay!", jayjay);
        textBox6.addText("Ahhhh, I’m just going to assume\nyou’re a pokemon and you can only say\nyour name.", player);
        textBox6.addText("You’re actually kind of cute.\nI guess I can raise you, it isn’t like\nI have any responsibilities hahaha...", player);
    }
    
    public void scene7()
    {
        setBackground(darkCastle);
        addObject(textBox7, 425, 600);
        textBox7.addText("It doesn’t matter, I’ve got the\npower of God and anime on my side!", koyen);
        textBox7.addText("We have THE Jay Jay", player);
        textBox7.addText("Everything changed when the\nGreenfoot nation attacked.", player);
        textBox7.addText("When the world needed him the most,\nhe vanished", player);
        textBox7.addText("But I believe Jay Jay can save\nthe world", player);
        textBox7.addText("Uwu yes daddy. Jay Jay!", jayjay);
    }
}
