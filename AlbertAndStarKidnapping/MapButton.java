import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MapButton here.
 * 
 * @author Young Chen
 * @version 2021
 */
public class MapButton extends ImageButton
{
    private String readPath, imagePath;
    private String name;
    
    /**
     * Constructor for MapButton class.
     * @param file  The path to the Map file.
     * @param image The path to the image for the map.
     * @param name  The name of the map.
     */
    public MapButton(String file, String image, String name) {
        super(new GreenfootImage(image));
        getImage().scale((int) (850 * .3),(int) (600 * .3));
        readPath = file;
        this.name = name;
    }
    
    /**
     * Add label displaying name.
     */
    public void addedToWorld(World w) {
        getWorld().addObject(new Label(name, 30), getX(), getY() - 110);
    }
    
    /**
     * Select and read map.
     */
    public void onPress() {
        Greenfoot.setWorld(new Game(false, ((Select) getWorld()).isStory()));
        ReadButton.read(readPath);
    }
}
