package PlantvsZombie;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Chomper extends Vegan {

	ArrayList<Zombie> zombies = TapVeDemo.getZombieList();
	int initial;
	boolean eat=false, swallow = false;
	ImageIcon icon;
	private ImageIcon imageArray[];
	private int totalFrame = 9, currentFrame = 0, previousFrame = -1;
	
	
	public Chomper(int x, int y, int w, int h) {
		super(x, y, w, h);
		setHp(300);
		System.out.println("Lane chomper = "+getLane());
	}
	
	public Image getChomperImage() {
		//if(eat)          icon = new ImageIcon("ImageSource\\PlantImage\\ChomperEat.png");
		if(eat) {
			 imageArray = new ImageIcon[totalFrame];
		      
	          for (int i = 0; i < imageArray.length; i++) {
	          imageArray[i] = new ImageIcon("C:\\ImageSource\\Chomper\\ChomperEat" + i + ".png");}
	        
	          while(true){ 
	        	if (currentFrame == previousFrame) {currentFrame++;}
	      
	            if (currentFrame >= imageArray.length) {
	              currentFrame = 0;}
	      
	            previousFrame = currentFrame;
	            return imageArray[currentFrame].getImage();
	          }
		}
		if(swallow) icon = new ImageIcon("ImageSource\\PlantImage\\ChomperSwallow.gif");
		else             icon = new ImageIcon("ImageSource\\PlantImage\\Chomper.gif");
		return icon.getImage();
	}
	
	public void paint(Graphics g) {
		g.drawRect(x, y, width, height);
		
		g.drawImage(getChomperImage(), x,y, null);
		checkCollideZombie();}
	
	public void paint1(Graphics g) {
		g.drawImage(getChomperImageAni(), x,y, null);}
	
	public Image getChomperImageAni() {
			 imageArray = new ImageIcon[totalFrame];
		      
	          for (int i = 0; i < imageArray.length; i++) {
	          imageArray[i] = new ImageIcon("D:\\ImageSource\\Chomper\\ChomperEat" + i + ".png");}
	        
	          while(true){ 
	        	if (currentFrame == previousFrame) {currentFrame++;}
	      
	            if (currentFrame >= imageArray.length) {
	              currentFrame = 0;}
	      
	            previousFrame = currentFrame;
	            return imageArray[currentFrame].getImage();
	          }}
	     
	public void checkCollideZombie() {
		int wait=10;
		
		if(!swallow) {
			for(int i=0; i<zombies.size(); i++) {
				Zombie tempZombie = zombies.get(i);
//				if(y > tempZombie.getY() && y < tempZombie.getY()+ tempZombie.getHeight()) System.out.println(tempZombie.getX() - x);
				
				if(this.getLane() == tempZombie.getLane() && (tempZombie.getX() - x ) <=95*2 ) {
					eat = true;
					initial = Timetest.getSecondPassed();
					wait--;
					if(wait<=0) {TapVeDemo.removeZombie(tempZombie);
					swallow=true;}
				}
			}
		}
		
		if(Timetest.getSecondPassed()>=initial+45) swallow=false;
		else if(Timetest.getSecondPassed()>=initial+1) eat=false;
	}
	
	public int getLane() {
		if(y==65) return 1;
		if(y==160) return 2;
		if(y==255) return 3;
		if(y==350) return 4;
		else return 5;
	}
}