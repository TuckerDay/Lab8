//***************************************************************
//Author: Tucker Day and Catey Meador
//File: MainPanel.java
//
//Purpose: Panel Class for Lab 8
//Last Changed Date: 3/10/18
//***************************************************************

package Game;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JPanel;


public class MainPanel extends JPanel {

	// Variables
	private JButton myButton;
	private JPanel startPanel;
	private Game myGame;
	private int HEIGHT = 700;
	private int WIDTH = 1200;
	
	//Constructor
	public MainPanel() throws FileNotFoundException
	{
		// create my Game object
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
	
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		// print out the player and enemies here
		page.drawImage(myGame.getMyPlayerIcon().getImage(), myGame.getMyPlayer().getX(), myGame.getMyPlayer().getY(), null);
		page.drawImage(myGame.getMyEnemyIcon().getImage(), myGame.getMyEnemy().getX(), myGame.getMyEnemy().getY(), null);
	
		// restart the game if we are done
		if(myGame.getMyPlayer().getRestart())
		{
			myGame.restart();
			myGame.getMyPlayer().setRestart(false);
		}
		
		// check to see if collision is happened to print the end text
		if(myGame.getMyPlayer().hasThePlayerCollidedWithEnemy() || myGame.getMyEnemy().hasTheEnemyCollidedWithPlayer())
		{
			page.setFont(new Font("Arial", Font.BOLD, 45));
			page.drawString("GAME OVER", WIDTH/2-150, HEIGHT/2-100);
			page.drawString("Press R to restart", WIDTH/2-150, HEIGHT/2-50);
			// call the method to print out the high scores
			showHighScores(page);
			
		}
		
		
		// print out the all the items
		for(int i = 0; i < myGame.getItems().length; i++)
		{
		
			if(myGame.getItems()[i] != null)
			{
				page.drawImage(myGame.getItems()[i].getImageIcon().getImage(),
						myGame.getItems()[i].getX(), myGame.getItems()[i].getY(), null);	
			}
			
		}
		
		// print out the score
		page.setFont(new Font("Arial", Font.BOLD, 32));
		page.drawString("Score: " + myGame.getMyPlayer().getCurrentScore(), WIDTH-200, 50);
	
		
		
	}

	// use the ArrayList to print out the high scores
	// use the Collections to sort descending
	public void showHighScores(Graphics page)
	{
		int x = 25;
		page.setFont(new Font("Arial", Font.BOLD, 32));
		page.drawString("High Scores ", 50, x);
		ArrayList<Integer> scores = myGame.getHighScores().getScores();
		Collections.sort(scores, Collections.reverseOrder());
		for(int i = 0; i < 3; i++)
		{	
			page.drawString("Score " + (i+1) + ": " + myGame.getHighScores().getScores().get(i),
					50, ((i+1)*60));
		}
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
