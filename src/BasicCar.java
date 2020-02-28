
public class BasicCar 
{
	private float speed, maxSpeed, locationRunoff;
	private int aggressivness, awareness;
	public int x, lane, wrap, printx;
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
		//front check
		if (objects.colliderCheck(x + 70, x + 1200, lane))
		{
			int otherLane = (lane == 1) ? 2 : 1;
			if (!objects.colliderCheck(x - 500, x + 1600, otherLane)) {
				this.lane = otherLane;
			}
			else
			{
				speedChange -= .6;
			}
		}
		else
		{
			speedChange += .4;
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
		
		printx = x % 10000;
		
		if (printx < 50)
		{
			wrap +=1;
			x += 20;
		}
		
		int y = (wrap * 200) + (lane * 50);
		
		return (printx/10) + (y*1000);
	}
	
	public int tick()
	{
		calculate();
		return move();
	}
}
