package game;
//***************************************************************
//Author: Tucker Day and Catey Meador
//File: Item.java
//
//Purpose: Item Class for Lab 8
//Last Changed Date: 3/10/18
//***************************************************************

public class Movement {

	private final int distance = 100;
	
	public int moveUp()
	{
		return -distance;
	}
	
	public int moveDown()
	{
		return distance;
	}
	
	public int moveLeft()
	{
		return -distance;
	}
	
	public int moveRight()
	{
		return distance;
	}
}