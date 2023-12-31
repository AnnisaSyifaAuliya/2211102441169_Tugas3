import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bulletss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bulletss extends Props
{
    
    int speed = 10;
    public Bulletss(){
        GreenfootImage img = this.getImage();
        img.scale(20, 20);
        this.setImage(img);
    }
    
    public Bulletss(int bulletSpeed){
        GreenfootImage img = this.getImage();
        img.scale(30, 20);
        this.setImage(img);
        this.speed= bulletSpeed;
    }
    
    public void act()
    {
        this.move(speed);
    }
    
}
