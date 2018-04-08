package game;
//***************************************************************
//Author: Tucker Day and Catey Meador
//File: Item.java
//Purpose: Item Class for Lab 8
//Last Changed Date: 4/7/18
//***************************************************************

import javax.swing.ImageIcon;

public class Items extends Character {

	private ImageIcon itemImage;
	
	public Items(int x, int y, MainPanel myPanel, ImageIcon itemImage) {
		super(x, y, myPanel);
		this.itemImage = itemImage;
		
	}

	public ImageIcon getImageIcon() {
		return itemImage;
	}
}
