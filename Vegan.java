package PlantvsZombie;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Vegan extends Sprite{
	int hp=500,count=20;
	boolean attacked=false;
	
	public int getLane() {
		if(y==85) return 1;
		if(y==180) return 2;
		if(y==275) return 3;
		if(y==370) return 4;
		else return 5;
	}
	public boolean isAttacked() {
		return attacked;
	}
	public void setAttacked(boolean attacked) {
		this.attacked = attacked;
	}

	public Vegan (int x,int y, int w, int h) {
		super(x,y,100,100);
		System.out.println("Vegan");
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void healthAttact(int damageOfZombie) {
	 	   hp = hp - damageOfZombie;
	    }
}
