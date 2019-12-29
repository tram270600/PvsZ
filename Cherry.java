package PlantvsZombie;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Cherry extends Vegan {
	
	BufferedImage cherry,sprite;
	int boom =7,k,initial;
	//Image i1;
	
	ArrayList<Zombie> zombies  = TapVeDemo.getZombieList();
	public Cherry(int x, int y, int w, int h) {
		super(x, y, w, h);
		setWidth(100);
		setHeight(100);
		
		try {
			sprite = ImageIO.read(new File("ImageSource\\PlantImage\\cherry sprite1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Boom() {
		for(int i=0; i<zombies.size(); i++) {
			Zombie tempZombie = zombies.get(i);
//			if(tempZombie.getBound().intersects(this.getBound())) {
			if((tempZombie.getLane() >this.getLane() +1 || tempZombie.getLane() <= this.getLane()-1) && (this.getX() - tempZombie.getX() <=95 || (tempZombie.getX() - this.getX()<=95))  ) {
				TapVeDemo.removeZombie(tempZombie);
			}
		}
	}
	
	public void paint (Graphics g) {
//		g.setColor(Color.DARK_GRAY);
//		g.fillRect(x-95, y-95, 3*95 , 3*95);
		
		cherry = sprite.getSubimage(k, 0, 100,100);
		
		boom--;
		if(boom==0) {
			boom=7;
			k+=100;
		} 
		
		g.drawImage(cherry, x, y, null);
		
		
		if(k==1000) { //boom after 2 seconds
			Boom();
			TapVeDemo.removeCherry(this);
		}
	}
	
	public Rectangle getBound(){
	    return new Rectangle(x-95,y-95,95*3,95*3 );
	  }
	
}
