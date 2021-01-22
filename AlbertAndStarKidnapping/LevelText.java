import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelText extends TextField
{
    public LevelText(int x, int y) {
        super(x, y, "Level: ");
    }
    
    protected float getValue() {
        return Global.getManager().getSpawner().getLevel();
    }
}
