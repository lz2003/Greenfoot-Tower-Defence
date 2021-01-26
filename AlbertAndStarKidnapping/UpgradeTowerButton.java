import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UpgradeTowerButton here.
 * 
 * @author Ryan Lin
 * @version (a version number or a date)
 */
public class UpgradeTowerButton extends ImageButton
{
    private Tower tower;
    public UpgradeTowerButton()
    {
        super(new GreenfootImage("images/buttons/upgrade/upgradeUnpressed.png"));
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
    
    public void onclick() 
    {
        if(tower != null && Greenfoot.mouseClicked(this)){
            float cost = tower.getCost();
            float costAdjusted = cost * 1.3f;
            if(Global.getManager().requestMoney(cost))
                tower.levelup();
        }
    }    
}
