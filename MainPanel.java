//***************************************************************
//Author: Tucker Day and Catey Meador
//File: MainPanel.java
//
//Purpose: Panel Class for Lab 8
//Last Changed Date: 3/10/18
//***************************************************************

package game;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	
	private JButton myButton;
	private JPanel startPanel;
	private Game myGame;
	private int HEIGHT = 700;
	private int WIDTH = 1200;
	
	public MainPanel() throws FileNotFoundException
	{
		// Create a game object to hold everything
		myGame = new Game(this);
		
		// Start panel
		startPanel = new JPanel();
		startPanel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
				
		myButton = new JButton("Start Game");
		myButton.setFont(new Font("Arial", Font.BOLD, 64));
		myButton.addActionListener(new buttonListener());
		startPanel.add(myButton);

		setPreferredSize(new Dimension(WIDTH, HEIGHT));
				
		add(startPanel);
	}
	
	// Draw everything to screen
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		
		// Draw player and enemy
		page.drawImage(myGame.getMyPlayerIcon().getImage(), myGame.getMyPlayer().getx(), myGame.getMyPlayer().gety(), null);
		page.drawImage(myGame.getMyEnemyIcon().getImage(), myGame.getMyEnemy().getx(), myGame.getMyEnemy().gety(), null);

		// Draw Walls
		
		// Restart game if we are done
		if(myGame.getMyPlayer().getRestart())
		{
			//myGame.restart();
			myGame.getMyPlayer().setRestart(false);
		}
		
		// check to see if collision is happened to print the end text
		if(myGame.getMyPlayer().hasThePlayerCollidedWithEnemy() || myGame.getMyEnemy().hasTheEnemyCollidedWithPlayer())
		{
			page.setFont(new Font("Arial", Font.BOLD, 45));
			page.drawString("GAME OVER", WIDTH/2-150, HEIGHT/2-100);
			page.drawString("Press R to restart", WIDTH/2-150, HEIGHT/2-50);
			// call the method to print out the high scores
			//showHighScores(page);
		}
		
		// Draw items
		
		
		
	}

private class buttonListener implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource() == myButton)
		{
			// just sets the visibility of the second panel to false
			startPanel.setVisible(false);
		}
	}
}	
}
