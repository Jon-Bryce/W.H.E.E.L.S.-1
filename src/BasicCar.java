
public class BasicCar 
{
	private float speed, maxSpeed, locationRunoff;
	private int aggressivness, awareness;
	public int x, lane, wrap;
	ObjectList objects;
	
	public BasicCar (float fastness, ObjectList objectList, int Lane)
	{
		speed = fastness;
		x = 50;
		objects = objectList;
		maxSpeed = speed * 15f;
		wrap = 0;
		lane = Lane;
	}
	
	public void calculate()
	{
		float speedChange = 0;
		if (objects.colliderCheck(x + 70, x + 1100, lane, wrap))
		{
			speedChange -= 1.5;
		}
		else
		{
			speedChange += 1.2;
		}
		
		speed += speedChange;
		if (speed <= 0 ) speed = .1f;
	}
	
	public int move()
	{
		if (speed > maxSpeed)
		{
			speed = maxSpeed;
		}
		x+= speed;
		
		if (x > 13000)
		{
			wrap +=1;
			x = -100;
		}
		
		int y = (wrap * 200) + (lane * 50);
		
		return (x/10) + (y*1000);
	}
	
	public int tick()
	{
		calculate();
		return move();
	}
}
