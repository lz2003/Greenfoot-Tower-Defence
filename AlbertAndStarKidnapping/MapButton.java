import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MapButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MapButton extends ImageButton
{
    String readPath, imagePath;
    String name;
    public MapButton(String file, String image, String name) {
        super(new GreenfootImage(image));
        getImage().scale((int) (850 * .3),(int) (600 * .3));
        readPath = file;
        this.name = name;
    }
    
    public void addedToWorld(World w) {
        getWorld().addObject(new Label(name, 30), getX(), getY() - 110);
    }
    
    public void onPress() {
        Greenfoot.setWorld(new Game(false, ((Select) getWorld()).isStory()));
        ReadButton.read(readPath);
    }
}
