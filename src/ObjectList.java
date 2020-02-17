
public class ObjectList 
{
	BasicCar[] cars;
	int maxSize, end = 0;
	App stage;
	float speed = 2.5f;
	
	public ObjectList(int setSize, App theStage)
	{
		maxSize = setSize;
		cars = new BasicCar[maxSize];
		this.stage = theStage;
	}
	
	public void addCar()
	{
		if(end != maxSize) {
			int lane = ((Math.random() * 2) > 1) ? 1 : 2;
			cars[end] = new BasicCar(speed, this, lane);
			speed += .1f;
			end++;
			stage.spawn(lane);
		}
	}
	
	public void tick(long frame)
	{
		if (frame % 30 == 0) {
			this.addCar();
		}
		for(int i=0; i<end; i++)
		{
			int loc = cars[i].tick();
			int x = loc % 1000;
			int y = loc / 1000;
			System.out.println(x + " " + y);
			stage.update(i,x,y);
		}
	}
	
	public boolean colliderCheck(int xIn, int xOut, int lane, int wrap) 
	{
		boolean carFound = false;
		for (int i = 0; i < end; i++) 
		{
			BasicCar car = cars[i];
			if ((car.x > xIn && car.x < xOut) && car.lane == lane && car.wrap == wrap)
			{
				carFound = true;
			}
		}
		
		return carFound;
	}
}
