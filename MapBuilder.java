package game;
//***************************************************************
//Author: Tucker Day and Catey Meador
//File: MapBuilder.java
//Purpose: This class reads a text file to create a map array
//Last Changed Date: 4/7/18
//***************************************************************

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class MapBuilder {
	
	final int ROWS = 7;
	final int COLUMNS = 11;
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
		
		//populates mapArray
		for (int row = 0; row < 7; row++)
		{
			String line = mapScan.nextLine();		
			Scanner myLineScanner = new Scanner(line);
			myLineScanner.useDelimiter(",");
			for (int col = 0; col < 11; col++)
			{
				mapArray[row][col] = myLineScanner.nextInt();
			}
		}
	}
	
	public int[][] getMapArray() {
		return mapArray;
	}
}