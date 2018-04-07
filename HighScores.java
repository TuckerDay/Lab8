package game;

import java.util.ArrayList;
import java.util.Collections;

public class HighScores {

	private ArrayList<Integer> scores = new ArrayList<Integer>();
	
	
	public void addNewScore(int score)
	{
		// this looks to see if we have any scores in the array list before checking and adding
		if(scores.size() > 0)
		{
			Collections.sort(scores, Collections.reverseOrder());
			for(int j = 0; j < scores.size(); j++)
			{
				if(score > scores.get(j))
				{
					scores.add(score);
					j = scores.size();
				}
			}
		}
		else
		{
			// this just adds the first one
			scores.add(score);
			scores.add(0);
			scores.add(0);
		}
		
	}
	
	
	public ArrayList<Integer> getScores()
	{
		return scores;
	}
	
}
