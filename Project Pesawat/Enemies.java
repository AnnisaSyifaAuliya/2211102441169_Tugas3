import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Enemies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemies extends Characters
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Enemies(){
        GreenfootImage img = this.getImage();
        img.scale(60, 60);
        this.setImage(img);
        this.setRotation(90);
    }
    
    public void act(){
        this.move(6);
        World wrld = this.getWorld();
        
        List<Players> pls =this.getNeighbours(300, true, Players.class);
        if(pls.size()>0){
            this.turnTowards(pls.get(0).getX(),pls.get(0).getY());
        }
        
        if(this.isTouching(Bulletss.class)){
            ScoreBoard scoreBoard = wrld.getObjects(ScoreBoard.class).get(0);
            scoreBoard.addScore(1);
            this.removeTouching(Bulletss.class);
            wrld.removeObject(this);
            return;
        }
        if(this.getY() == wrld.getHeight()-1){
            wrld.removeObject(this);
        }
    }
}
