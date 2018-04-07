//***************************************************************
//Author: Tucker Day and Catey Meador
//File: Player.java
//
//Purpose: Player class for Lab 8
//Last Changed Date: 3/10/18
//***************************************************************

package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Character implements KeyListener {
	
	private int x;
	private int y;
	private String imagePath;
	private MainPanel myPanel;
	private Enemy myEnemy;
	private boolean hasCollidedWithEnemy = false;
	private int playerMovement = 100;
	private int sizeOfImage = 100;
	private int sizeOfItems = 100;
	private boolean restart = false;
	
	private Items[] myItems;
	private int currentScore = 0;
	private HighScores myHighScores;
	private boolean isGameOver = false;
	private boolean respondToKeys = true;
	private Movement myMove = new Movement();	

	public Player(int x, int y, String imagePath, MainPanel myPanel) {
		super(x, y, imagePath, myPanel);
		myPanel.addKeyListener((KeyListener) this);
		myPanel.setFocusable(true);
	}
	
	public void setEnemy(Enemy myEnemy) {
		this.myEnemy = myEnemy;
	}
	
	public void setItems(Items[] myItems)
	{
		this.myItems = myItems;
		
	}
	public boolean hasThePlayerCollidedWithEnemy()
	{
		return hasCollidedWithEnemy;
	}
	
	public void setThePlayerCollidedWithEnemy(boolean hasCollidedWithEnemy)
	{
		this.hasCollidedWithEnemy = hasCollidedWithEnemy;
	}
	
	public int getCurrentScore()
	{
		return currentScore;
	}
	public void setCurrentScore(int score)
	{
		currentScore = score;
	}
	public void setHighScores(HighScores myHighScores)
	{
		this.myHighScores = myHighScores;
	}
	public boolean getRestart()
	{
		return restart;
	}
	
	public void setRestart(boolean restart)
	{
		this.restart = restart;
	}

	public void setIsGameOver(boolean isGameOver)
	{
		this.isGameOver = isGameOver;
	}
	
	public void setRespondToKeys(boolean respondToKeys)
	{
		this.respondToKeys = respondToKeys;
	}
	
	// Key Listener
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT)
		{
			setx(getx() + myMove.moveLeft());
		}
		
		else if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			setx(getx() + myMove.moveRight());
		}
		
		else if(arg0.getKeyCode() == KeyEvent.VK_UP)
		{
			sety(gety() + myMove.moveUp());
		}
		
		else if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
		{
			sety(gety() + myMove.moveDown());
		}
		else if (arg0.getKeyCode() == KeyEvent.VK_R)
			restart = true;
			myPanel.repaint();
		}
	
		// this check for collision on each movement
		hasCollidedWithEnemy = areRectsColliding(x,x + sizeOfImage,y,y+sizeOfImage,myEnemy.getx(), 
				myEnemy.getx()+sizeOfImage,myEnemy.gety(), myEnemy.gety() + sizeOfImage);
		
		if(hasCollidedWithEnemy)
		{
			isGameOver = true;
		}
		else
		{
			myPanel.repaint();
		}
		
		// this only updates the high score if the game is over and keys are disabled
		if(isGameOver && respondToKeys)
		{
			myHighScores.addNewScore(currentScore);
			respondToKeys = false;
		}
		
		// check collision with items and make sure you look at how many items there
		checkCollisionWithItems();
		if(currentScore == myItems.length && respondToKeys)
		{
			isGameOver = true;
			hasCollidedWithEnemy = true;
			myHighScores.addNewScore(currentScore);
			respondToKeys = false;
		}
		
	}

		// not sure which one collided so we have to test all of them
		public void checkCollisionWithItems()
		{
			for(int i = 0; i < myItems.length; i++)
			{
				// if we do collide, we are making that space null, so we have to make sure we skip the null ones
				if(myItems[i] != null)
				{
					boolean testCollision = areRectsColliding(x, x+sizeOfImage,y,y+sizeOfImage,
							myItems[i].getx(), myItems[i].getx() + sizeOfItems, myItems[i].gety(),
							myItems[i].gety() + sizeOfItems);
					if(testCollision)
					{
						currentScore++;
						myItems[i] = null;
						i = myItems.length;
					}
				}
			}
		}	

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
	
	private boolean areRectsColliding(int r1TopLeftX, int r1BottomRightX, int r1TopLeftY, int r1BottomRightY,
			int r2TopLeftX, int r2BottomRightX, int r2TopLeftY, int r2BottomRightY) {
		if (r1TopLeftX < r2BottomRightX && r1BottomRightX > r2TopLeftX && r1TopLeftY < r2BottomRightY
				&& r1BottomRightY > r2TopLeftY) {
			return true;
		} else {
			return false;
		}
	}	
}
