package game;
//***************************************************************
//Author: Tucker Day and Catey Meador
//File: Wall.java
//Purpose: Wall Class for Lab 8
//Last Changed Date: 4/7/18
//***************************************************************

import javax.swing.ImageIcon;

public class Wall extends Character {

	private ImageIcon wallImage;
	
	public Wall(int x, int y, MainPanel myPanel, ImageIcon wallImage) {
		super(x, y, myPanel);
		this.wallImage = wallImage;
		
	}

	public String toString()
	{
		return "x: " + x + "\ny: " + y;
	}
	
	public ImageIcon getImageIcon() {
		return wallImage;
	}
}
