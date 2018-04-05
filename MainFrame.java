//***************************************************************
//Author: Tucker Day and Catey Meador
//File: MainFrame.java
//
//Purpose: Frame Class for Lab 8
//Last Changed Date: 3/10/18
//***************************************************************

package game;
import javax.swing.JFrame;

public class MainFrame {

	public static void main(String[] args) {
		
		JFrame myFrame = new JFrame("Game Time");
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MainPanel myPanel = new MainPanel();
		
		myFrame.getContentPane().add(myPanel);
		
		myFrame.pack();
		
		myFrame.setVisible(true);
		

	}

}
