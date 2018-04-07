//***************************************************************
//Author: Tucker Day and Catey Meador
//File: Item.java
//
//Purpose: Item Class for Lab 8
//Last Changed Date: 3/10/18
//***************************************************************

package Game;

import javax.swing.ImageIcon;

public class Items {

	private int x;
	private int y;
	private ImageIcon itemImage;
	
	public Items(int x, int y, ImageIcon itemImage) {
		this.x = x;
		this.y = y;
		this.itemImage = itemImage;
		
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public ImageIcon getImageIcon() {
		return itemImage;
	}
}
