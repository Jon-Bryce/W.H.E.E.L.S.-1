
public class ObjectList 
{
	BasicCar[] cars;
	int maxSize, end = 0;
	App stage;
	int speed = 15;
	
	public ObjectList(int setSize, App theStage)
	{
		maxSize = setSize;
		cars = new BasicCar[maxSize];
		this.stage = theStage;
	}
	
	public void addCar()
	{
		cars[end] = new BasicCar(speed);
		speed += 10;
		end++;
		stage.spawn();
	}
	
	public void tick()
	{
		for(int i=0; i<end; i++)
		{
			stage.update(i,cars[i].tick());
		}
	}
}
