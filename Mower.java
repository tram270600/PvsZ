package PlantvsZombie;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Mower extends JPanel{
	int y,x;
	BufferedImage mowerImage;
	boolean move = false;
	
	ArrayList <Zombie> zombies = TapVeDemo.getZombieList();
	
	public void setMove(boolean move) {
		this.move = move;
	}
	public Mower (int x, int y) {
		this.x = x;
		this.y = y;
		
		try {
			mowerImage = ImageIO.read(new File("ImageSource\\mowerS.png"));
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	public void paint (Graphics g) {
		
		g.drawImage(mowerImage, x,y,null);
		Move();
		collideZombie();
	}
	
	public void Move() {
		if(move == true) {
			x+=3;
			if(x >= 1200) TapVeDemo.removeMower(this);
		}
	}
	
	public Rectangle getBound() {
		return new Rectangle (x,y,100,85);
	}
	
	public void collideZombie() {
		for(int i=0; i < zombies.size(); i++) {
			Zombie tempZombie = zombies.get(i);
			if(tempZombie.getBound().intersects(this.getBound())) {
				setMove(true);
				TapVeDemo.removeZombie(tempZombie);
			}
		}
	}
	
}
