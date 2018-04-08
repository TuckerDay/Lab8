package game;
//***************************************************************
//Author: Tucker Day and Catey Meador
//File: Game.java
//
//Purpose: Game Class for Lab 8
//Last Changed Date: 3/10/18
//***************************************************************

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;

public class Game {
	private Player myPlayer;
	private Enemy myEnemy;
	private ImageIcon myPlayerIcon, myEnemyIcon;
	private Items[] myItems = new Items[5];
	private HighScores myHighScores;
	private int originalPlayerX = 100;
	private int originalPlayerY = 100;
	private int originalEnemyX = 500;
	private int originalEnemyY = 500;
	private Wall[][] WallArray = new Wall[7][12];
	private MainPanel mainPanel;
	private int xWidth = 700;
	private int yHeight = 700;
	private int sizeOfFood = 100;
	int[][] mapArray;
	Wall myWall;
	
	// Constructor
	public Game(MainPanel mainPanel) throws FileNotFoundException {
		
		this.mainPanel = mainPanel;
		
		// Create Map
		MapBuilder mapBuild = new MapBuilder();
		mapBuild.mapGen();
		mapArray = mapBuild.getMapArray();
		createWalls();
		
		// choose a player from one of two files
		createPlayer();

		myEnemy = new Enemy(500, 600, mainPanel, "./src/images/enemy.jpg");
		
		// notice how I send information about the enemy into the player here (using the setter)
		myPlayer.setEnemy(myEnemy);
		// same thing here for the player and the enemy so that I can access properties if I want
		myEnemy.setPlayer(myPlayer);
		
		
		myPlayerIcon = new ImageIcon(myPlayer.getImagePath());
		myEnemyIcon = new ImageIcon(myEnemy.getImagePath());
		Image newImage = rescaleImage(myPlayerIcon,100, 100);
		myPlayerIcon.setImage(newImage);

		Image newImage2 = rescaleImage(myEnemyIcon,100,100);
		myEnemyIcon.setImage(newImage2);

		// create all the items
		createItems();
		
		myPlayer.setItems(myItems);
		
		// create the high scores - which is just an ArrayList
		myHighScores = new HighScores();
		myPlayer.setHighScores(myHighScores);
		
	}

	public void createPlayer()
	{
		Random myRand = new Random();
		File myFile;
		File myDir = new File("./src/files");
		// get all the files in the directory
		String[] files = myDir.list();
		// choose a random file
		int whichFile = myRand.nextInt(files.length);
		// open that file
		myFile= new File("./src/files/" + files[whichFile]);
		
		Scanner myScanner = null;
		
		try {
			myScanner = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(myScanner.hasNextLine())
		{
			String line = myScanner.nextLine();
			Scanner myLineScanner = new Scanner(line).useDelimiter(",");
			while(myLineScanner.hasNext())
			{
				int x = myLineScanner.nextInt();
				int y = myLineScanner.nextInt();
				String path = myLineScanner.next();
				myPlayer = new Player(x, y, mainPanel, path);
			}
		}
	}
	
	// this allows me to rescale any image
	public Image rescaleImage(ImageIcon icon, int width,int height)
	{
		return icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
	}
	
	// this just setting the items randomly.. they could be anywhere on the screen
	public void createItems()
	{
		Random myRand = new Random();
		for(int i = 0; i < myItems.length; i++)
		{
			int x = myRand.nextInt(12) * 100;
			int y = myRand.nextInt(7) * 100;
			
			ImageIcon itemIcon = new ImageIcon("./src/images/item.jpg");
			
			Image newImage = rescaleImage(itemIcon,sizeOfFood,sizeOfFood);
			itemIcon.setImage(newImage);
			Items myItem = new Items(x,y,mainPanel,itemIcon);
			myItems[i] = myItem;
		}
	}
	
	public void createWalls()
	{
		ImageIcon wallIcon = new ImageIcon("./src/images/wall.jpg");
		Image newImage = rescaleImage(wallIcon,100,100);
		wallIcon.setImage(newImage);
		for(int i = 0; i <mapArray.length; i++)
		{
			for (int j=0; j<mapArray[i].length; j++)
			{
				if (mapArray[i][j] == 1)
				{
					Wall myWall = new Wall(j*100,i*100,mainPanel,wallIcon);
					WallArray[i][j] = myWall;
				}
				else
				{
					WallArray[i][j] = null;
				}
			}
		}
	}
	
	// this just resets everything back to the beginning
	public void restart()
	{
		createItems();
		myPlayer.setThePlayerCollidedWithEnemy(false);
		myPlayer.setX(originalPlayerX);
		myPlayer.setY(originalPlayerY);
		myEnemy.setX(originalEnemyX);
		myEnemy.setY(originalEnemyY);
		myEnemy.getMyTimer().start();
		myPlayer.setCurrentScore(0);
		myPlayer.setIsGameOver(false);
		myPlayer.setRespondToKeys(true);
		
	}
	
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
	
	public Items[] getItems()
	{
		return myItems;
	}
	
	public Wall[][] getWallArray()
	{
		return WallArray;
	}

	public HighScores getHighScores()
	{
		return myHighScores;
	}

}