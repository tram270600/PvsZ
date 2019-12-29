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

public class wallNut extends Vegan {
	
	BufferedImage wallNutImage,brokenNut, broken,trans1,trans2,trans3,sprite,image;
	
	public wallNut(int x, int y,int width, int height) {
		super(x,y,width,height);
		
		setHp(4000);
		setWidth(100);
		setHeight(100);
		try {
			sprite = ImageIO.read(new File("ImageSource\\PlantImage\\walNutSprite.png") );
			wallNutImage = sprite.getSubimage(0,0,74,73);
			trans1 = sprite.getSubimage(74,0,74,73);
			brokenNut = sprite.getSubimage(74*2,0,74,73);
			trans2 = sprite.getSubimage(74*3,0,74,73);
			broken =sprite.getSubimage(74*4,0,74,73);
			trans3 = sprite.getSubimage(74*5,0,74,73);
		} catch (IOException e) {
			e.printStackTrace();}
		
		System.out.println("walnut x = "+x+"\t y = "+y);
	}
	
	public void paint (Graphics g) {
//		g.setColor(Color.black);
//		g.fillRect(x, y, width, height);
		
		if( hp <=1000) {
			image = broken;
			if(attacked) {
				count--;
				image = broken;
				if(count==0) {
					count=20;
					image = trans3;
					attacked=false;
				}
			}
		}
		else if(hp <= 2500) {
			image = brokenNut;
			if(attacked) {
				count--;
				image = brokenNut;
				if(count==0) {
					count=20;
					image = trans2;
					attacked=false;
				}
			}
		}
		else {
			image = wallNutImage;
			if(attacked) {		
				count--;
				image =wallNutImage;
				if(count==0) {
					count=20;
					image = trans1;
					attacked=false;
				}
			}
		}
		g.drawImage(image,x,y,null);
	}
	
}
