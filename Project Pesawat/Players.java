import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Players here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Players extends Characters
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int speed = 10;
    int bulletspeed= 10;
    int cooldown= 20;
    int lastShotTimer= 0;
    public Players(){
        GreenfootImage img = this.getImage();
        img.scale(60, 60);
        this.setImage(img);
    }
    
    private void tembak(){
        World wrld = this.getWorld();
        Bulletss bullet = new Bulletss(bulletspeed);
        bullet.setRotation(this.getRotation());
        wrld.addObject(bullet, this.getX(), this.getY());
    }
    
    public void act()
    {
        this.move(1);
        if(Greenfoot.isKeyDown("up")){
            this.setLocation(this.getX(), this.getY()-speed);
        }
        
        if(Greenfoot.isKeyDown("down")){
            this.setLocation(this.getX(), this.getY()+speed);
        }
        
        if(Greenfoot.isKeyDown("left")){
            this.setLocation(this.getX()-speed, this.getY());
        }
        
        if(Greenfoot.isKeyDown("right")){
            this.setLocation(this.getX()+speed, this.getY());
        }
        
        if(lastShotTimer < cooldown && lastShotTimer > 0){
            lastShotTimer ++;
        }
        
        if(Greenfoot.isKeyDown("space") && lastShotTimer == 0){
            tembak();
            lastShotTimer++;
        }
        
        if(lastShotTimer == cooldown){
            lastShotTimer = 0;
        }
        
        if(this.isTouching(Enemies.class)){
            World wrld = this.getWorld();
            Died d = new Died();
            wrld.addObject(d, this.getX(), this.getY());
            wrld.removeObject(this);
        }
    }
}