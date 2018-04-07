//***************************************************************
//Author: Tucker Day and Catey Meador
//File: MapBuilder.java
//
//Purpose: This class reads a text file to create a map array
//Last Changed Date: 3/10/18
//***************************************************************

package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class MapBuilder {
	
	final int ROWS = 7;
	final int COLUMNS = 12;
	int[][] mapArray = new int[ROWS][COLUMNS];
	
	public void mapGen() throws FileNotFoundException {	
		
		//Choose a random file from 'maps'
		Random myRand = new Random();
		File mapFile;
		File myDir = new File("./src/maps");
		// get all the files in the directory
		String[] files = myDir.list();
		// choose a random file
		int whichFile = myRand.nextInt(files.length);
		// open that file
		mapFile= new File("./src/maps/" + files[whichFile]);	
	
		// Scanner for File
		Scanner mapScan = new Scanner(mapFile);
		
		while (mapScan.hasNextLine())
		{
			//Set up scanner
			String line = mapScan.nextLine();		
			Scanner myLineScanner = new Scanner(line);
			myLineScanner.useDelimiter(",");
			
			// Initialize counters for navigating array
			int row = 0;
			int col = 0;
			
			// Populate array with values from file
			while(myLineScanner.hasNext())
			{
				mapArray[row][col] = myLineScanner.nextInt();
				col++;
			}
			col = 0;
			row ++;
		}
	}
	
	public int[][] getMapArray() {
		return mapArray;
	}
}