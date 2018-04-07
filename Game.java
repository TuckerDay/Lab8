//***************************************************************
//Author: Tucker Day and Catey Meador
//File: Game.java
//
//Purpose: Game Class for Lab 8
//Last Changed Date: 3/10/18
//***************************************************************

package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;

public class Game {
	
	// Variables
	private MainPanel mainPanel;
	private Player myPlayer;
	private Enemy myEnemy;
	private ImageIcon myPlayerIcon, myEnemyIcon;
	
	private int originalPlayerX = 100;
	private int originalPlayerY = 100;
	private int originalEnemyX = 500;
	private int originalEnemyY = 500;

	//Constructor
	public Game(MainPanel mainPanel) throws FileNotFoundException {
		this.mainPanel = mainPanel;
		
		// Create Map
		MapBuilder mapBuild = new MapBuilder();
		mapBuild.mapGen();
		int[][] mapArray = mapBuild.getMapArray();
		
		// Create player
		myPlayer = new Player(100,100, "./src/Images/player.jpg", mainPanel);
		myPlayerIcon = new ImageIcon(myPlayer.getImagePath());
		
		// Create Enemy
		myEnemy = new Enemy(300,300, "./src/Images/enemy.jpg", mainPanel);
		myEnemyIcon = new ImageIcon(myEnemy.getImagePath());
		
		// Enemy and player see each other
		myPlayer.setEnemy(myEnemy);
		myEnemy.setPlayer(myPlayer);
	}
	
	public void restart()
	{
		//createItems();
		myPlayer.setThePlayerCollidedWithEnemy(false);
		myPlayer.setx(originalPlayerX);
		myPlayer.sety(originalPlayerY);
		myEnemy.setx(originalEnemyX);
		myEnemy.sety(originalEnemyY);
		myEnemy.getMyTimer().start();
		//myPlayer.setCurrentScore(0);
		myPlayer.setIsGameOver(false);
		myPlayer.setRespondToKeys(true);
		
	}	
	
	// This method creates the walls
	/*public void createWalls()
	{
		for()
	}*/
	
	
	public ImageIcon getMyPlayerIcon() {
		return myPlayerIcon;
	}

	public ImageIcon getMyEnemyIcon() {
		return myEnemyIcon;
	}

	public Player getMyPlayer() {
		return myPlayer;
	}

	public Enemy getMyEnemy() {
		return myEnemy;
	}
	
	}

	
