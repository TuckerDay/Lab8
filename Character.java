//***************************************************************
//Author: Tucker Day and Catey Meador
//File: Character.java
//
//Purpose: This class will be extended by player, enemy, and item
//Last Changed Date: 3/10/18
//***************************************************************

package game;

import javax.swing.ImageIcon;

public class Character {
	
	// Variables
	protected int x;
	protected int y;
	private String imagePath;
	protected MainPanel myPanel;
	
	// Constructor
	public Character(int x, int y, String imagePath, MainPanel myPanel)
	{
		this.x = x;
		this.y = y;
		this.imagePath = imagePath;
		this.myPanel = myPanel;
	}
	
	// Methods
	public int getx() {
		return x;
	}
	
	public int gety() {
		return y;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
	public void setx(int x) {
		this.x = x;
	}
	
	public void sety(int y) {
		this.y = y;
	}
	
	
	

}
