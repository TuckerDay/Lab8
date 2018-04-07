package game;

public class Movement {

	private final int distance = 100;
	
	public int moveUp()
	{
		return -distance;
	}
	
	public int moveDown()
	{
		return distance;
	}
	
	public int moveLeft()
	{
		return -distance;
	}
	
	public int moveRight()
	{
		return distance;
	}
	
	
	
}
