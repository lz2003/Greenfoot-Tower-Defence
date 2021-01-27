import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Allows the user to fast forward through cutscenes.
 * 
 * @author Young Chen
 * @version 2021
 */
public class FastForwardButton extends ImageButton
{
    private static final GreenfootImage image = new GreenfootImage("images/buttons/fastForward/fastForwardUnpressed.png");
    
    /**
     * Constructor for class FastForwardButton.
     */
    public FastForwardButton() {
        super(image);
    }
    
    /**
     * Fast forward through cutscenes.
     */
    public void onPress() {
        if(!Spawner.hasCutscene(1 + Global.getManager().getSpawner().getLevel()) || !Global.getWorld().isCampaign())
            Global.getManager().getSpawner().nextLevel();
    }   
}
