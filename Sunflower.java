package PlantvsZombie;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Sunflower extends Vegan {
	
	static private BufferedImage sunflowerImage,sprite;
	private int i,initial,end;
	ImageIcon icon1 = new ImageIcon("ImageSource\\PlantImage\\sunflower.gif");
	
	
	public Sunflower(int x, int y,int w, int h) {
		super(x,y,50,50);
		
		setHp(300);
		setWidth(100);
		setHeight(100);
		initial = Timetest.getSecondPassed();
	}
	
	public void paint (Graphics g) {
		g.drawRect(x, y, width, height);		
		g.drawImage(icon1.getImage(),x,y,null);
		
		if (Timetest.getSecondPassed()==initial+24) {
			TapVeDemo.addSun(new Sun(this.x , this.y , this.y+30));
			initial = Timetest.getSecondPassed();
		}
	}
	
}