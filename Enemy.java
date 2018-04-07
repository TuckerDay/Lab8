//***************************************************************
//Author: Tucker Day and Catey Meador
//File: Enemy.java
//
//Purpose: Enemy Class for Lab 8
//Last Changed Date: 3/10/18
//***************************************************************

package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Enemy {
	private int x;
	private int y;
	private String imagePath;
	private MainPanel myPanel;
	private Player myPlayer;
	private boolean hasCollidedWithPlayer = false;
	
	private Timer myTimer = new Timer(1200, new timerListener());
	public Enemy(int x, int y, String imagePath, MainPanel myPanel)
	{
		this.x = x;
		this.y  = y;
		this.imagePath = imagePath;
		this.myPanel = myPanel;
		myTimer.start();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setPlayer(Player myPlayer)
	{
		this.myPlayer = myPlayer;
	}
	
	public Timer getMyTimer()
	{
		return myTimer;
	}
	public boolean hasTheEnemyCollidedWithPlayer()
	{
		return hasCollidedWithPlayer;
	}
	private class timerListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(myPlayer.hasThePlayerCollidedWithEnemy())
			{
				myTimer.stop();
			}
			// this just looks for where the player is and then moves toward them
			if(x > myPlayer.getX())
			{
				x-=100;
			}
			if(x < myPlayer.getX())
			{
				x+=100;
			}
			if(y > myPlayer.getY())
			{
				y-=100;
			}
			if(y < myPlayer.getY())
			{
				y+=100;
			}

			// notice how we check collision from the enemy and the player
			hasCollidedWithPlayer = areRectsColliding(x,x+100, y, y+100, myPlayer.getX(), 
					myPlayer.getX() + 100, myPlayer.getY(), myPlayer.getY() + 100);
			if(hasCollidedWithPlayer)
			{
				myTimer.stop();
				myPlayer.setThePlayerCollidedWithEnemy(true);
			}
			myPanel.repaint();
		}
		
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
