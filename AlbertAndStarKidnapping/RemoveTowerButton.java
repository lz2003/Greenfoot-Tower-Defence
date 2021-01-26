import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RemoveTowerButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RemoveTowerButton extends ImageButton
{
    private Tower tower;
    public RemoveTowerButton()
    {
        super(new GreenfootImage("images/buttons/delete/deleteUnpressed.png"));
    }
    
    public void setTower(Tower tower)
    {
        this.tower = tower;
    }
    
    public void unlinkTower(Tower tower)
    {
        if(this.tower == tower)
        {
            tower = null;
        }
    }
    
    public void act() 
    {
        if(tower != null && Greenfoot.mouseClicked(this))
        {
            if(tower instanceof Wall) {
                if(!Global.getWorld().isEditor()) return;
            }
            int x = tower.getIX();
            int y = tower.getIY();
            Global.getManager().updatePath(x, y, false);
            tower.destroy();
            Global.getWorld().mask.hide();
        }
    }    
}
