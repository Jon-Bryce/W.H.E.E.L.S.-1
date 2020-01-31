
public class ObjectList 
{
	BasicCar[] cars;
	int maxSize, end = 0;
	App stage;
	int speed = 2;
	
	public ObjectList(int setSize, App theStage)
	{
		maxSize = setSize;
		cars = new BasicCar[maxSize];
		this.stage = theStage;
	}
	
	public void addCar()
	{
		if(end != maxSize) {
			System.out.println(end);
			cars[end] = new BasicCar(speed);
			speed += 1;
			end++;
			stage.spawn();
		}
	}
	
	public void tick(long frame)
	{
		if (frame % 90 == 0) {
			this.addCar();
		}
		for(int i=0; i<end; i++)
		{
			stage.update(i,cars[i].tick());
		}
	}
}
