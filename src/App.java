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
	
	private Main ticker;
	
	public static void main(String[] args) 
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		ticker = new Main(this);
		
		root = new Group();
		
		scene = new Scene(root, 600 ,400);
		
		root.getChildren().add(new Rectangle(100,100,100,100));
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void update(int id, int newX)
	{
		String key = "car" + id;
		cars.get(key).relocate(newX, cars.get(key).getY());
	}
	
	public void spawn()
	{
		String key = "car" + numCars;
		Rectangle newCar = new Rectangle(100, 100, 100, 100);
		newCar.setFill(Color.BLUE);
		//root.getChildren().add(newCar);
		cars.put(key, newCar);
		numCars++;
	}
}
