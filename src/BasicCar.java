
public class BasicCar 
{
	private int location, aggressivness, awareness, speed;
	
	public BasicCar (int fastness)
	{
		speed = fastness;
		location = 50;
	}
	
	public void calculate()
	{
		
	}
	
	public int move()
	{
		location+= speed;
		return location;
	}
	
	public void draw()
	{
		
	}
	
	public int tick()
	{
		calculate();
		return move();
	}
}
