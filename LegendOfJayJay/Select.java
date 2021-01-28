import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Map selection world
 *
 * @author Young Chen
 * @version 2021-01-26
 */
public class Select extends World
{
    TextButton load, useNew;
    Character bg;
    private boolean isStory;

    /**
     * Creates the map selection screen
     * @param isStory whether or not game is in story mode
     */
    public Select(boolean isStory)
    {    
        super(Game.worldWidth, Game.worldHeight, 1); 
        
        bg = new Character(new GreenfootImage("mapbg.png"));
        addObject(bg, getWidth() / 2, getHeight() / 2);
        
        String dir = SavedInstance.MAP_PATH;
        String ext = "." + SaveButton.EXT;
        String img = ".png";
        
        Button[] buttons = {
            new MapButton(dir + "blank" + ext, dir + "blank" + img, "Blank Slate"),
            new MapButton(dir + "boxy" + ext, dir + "boxy" + img, "Boxy"),
            new MapButton(dir + "columns" + ext, dir + "columns" + img, "Columns"),
            new MapButton(dir + "dawae" + ext, dir + "dawae" + img, "Do yu no da wae?"),
            new MapButton(dir + "funnel" + ext, dir + "funnel" + img, "Funnel"),
            new MapButton(dir + "grid" + ext, dir + "grid" + img, "Grid"),
            new MapButton(dir + "maze" + ext, dir + "maze" + img, "Maze"),
            new MapButton(dir + "jayjay" + ext, dir + "jayjay" + img, "Jay Jay's World"),
            new MapButton(dir + "obstacles" + ext, dir + "obstacles" + img, "Fortress")
        };
        
        ButtonGrid b = new ButtonGrid();
        addObject(b, 165, 160);
        
        b.set(buttons, 3, 4, 300, 240);
        
        addObject(new Label("Map Selection", 40), getWidth() / 2, 18);
        
        this.isStory = isStory;
    }

    /**
     * Whether or not game is in story mode
     * @return whether or not game is in story mode
     */
    public boolean isStory() {
        return isStory;
    }
}
