import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class App extends Application
{
	Map<String, Rectangle> cars = new HashMap<String, Rectangle>();
	int numCars;
	Scene scene;
	Group root;
	
	private Tick ticker;
	
	public static void main(String[] args) 
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		ObjectList objects = new ObjectList(80, this);
		root = new Group();
		
		scene = new Scene(root, 1200, 800);
		
		ticker = new Tick(objects);
		ticker.start();
		
		root.getChildren().add(new Rectangle(000, 40, 1200, 100));
		root.getChildren().add(new Rectangle(000, 240, 1200, 100));
		root.getChildren().add(new Rectangle(000, 440, 1200, 100));
		root.getChildren().add(new Rectangle(000, 640, 1200, 100));
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void update(int id, int newX, int newY)
	{
		String key = "car" + id;
		cars.get(key).relocate(newX, newY);
	}
	
	public void spawn(int lane)
	{
		String key = "car" + numCars;
		Rectangle newCar = new Rectangle(400 , 100 * lane , 50, 25);
		newCar.setFill(Color.BLUE);
		root.getChildren().add(newCar);
		cars.put(key, newCar);
		numCars++;
	}
}
