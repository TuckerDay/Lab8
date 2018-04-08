package game;
//***************************************************************
//Author: Tucker Day and Catey Meador
//File: Character.java
//
//Purpose: This class will be extended by player, enemy, and item
//Last Changed Date: 3/10/18
//***************************************************************

import javax.swing.ImageIcon;

public class Character {
	
	// Variables
	protected int x;
	protected int y;
	protected MainPanel myPanel;
	
	// Constructor
	public Character(int x, int y, MainPanel myPanel)
	{
		this.x = x;
		this.y = y;
		this.myPanel = myPanel;
	}
	
	// Methods
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	
	

}