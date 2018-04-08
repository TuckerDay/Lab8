package game;
//***************************************************************
//Author: Tucker Day and Catey Meador
//File: Item.java
//
//Purpose: Item Class for Lab 8
//Last Changed Date: 3/10/18
//***************************************************************

import javax.swing.ImageIcon;

public class Wall extends Character {

	private ImageIcon wallImage;
	
	public Wall(int x, int y, MainPanel myPanel, ImageIcon wallImage) {
		super(x, y, myPanel);
		this.wallImage = wallImage;
		
	}

	public ImageIcon getImageIcon() {
		return wallImage;
	}
}
