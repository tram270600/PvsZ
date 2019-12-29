package PlantvsZombie;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Sun extends JPanel {
	
	private boolean bl = false;
	static boolean start=false;
	private BufferedImage sunImage;
	private int x,y,endY,hp=800,count=2;
	Score scr = new Score();
	
	ArrayList <Sun> suns = TapVeDemo.getSunList();
	
	public Sun (int x, int y,int endY) {
		this.x=x;
		this.y=y;
		this.bl=true;
		this.endY=endY;
//		setLocation(x,y);
	}
	
	public Sun() {
	}

	public boolean isBl() {
		return bl;
	}
	public void setBl(boolean bl) {
		this.bl = bl;
	}
	public int getEndY() {
		return endY;
	}
	public void setEndY(int endY) {
		this.endY = endY;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public void Rand() {
		Random rand = new Random();
		if (bl == false) {
			x = rand.nextInt(770) + 300;
			endY = rand.nextInt(400)+80;
			bl = true;
		}
	}
	
	public void paint(Graphics s) {
		Rand();
		
//		s.setColor(Color.orange);
//		s.fillRoundRect(x, y,25,25,25,25);
		
		try {
			sunImage = ImageIO.read(new File("ImageSource\\sun.png"));
			s.drawImage(sunImage,x,y,null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		tangy();
	}

	public void tangy() {
		if(y<endY) {
			count--;
			if(count==0) {
				count=2;
				y++;
			}
		}
		else {
			//System.out.println("HP:"+hp);
			hp--;
			if(hp<=0)
				TapVeDemo.removeSun(this);
		}
	}

	public void Collect() {
		scr.CollectSun();
		TapVeDemo.removeSun(this);
	}

}
