//import java.net.URL;
//import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

@SuppressWarnings("deprecation")
public class Main
{

	public Main(App scene)
	{
		
		ObjectList objects = new ObjectList(2, scene);
		
		objects.addCar();
		objects.addCar();
		
		
		
		
		Timeline tick = TimelineBuilder.create()
				.keyFrames
				(
					new KeyFrame
					(
						//How often the tick updates in milliseconds
						new Duration(10),
						new EventHandler<ActionEvent>()
						{
							public void handle(ActionEvent event)
							{
								//Put code to run every tick in here.
								objects.tick();
							}
						}
					)
				)
				.cycleCount(Timeline.INDEFINITE)
				.build();
			//Starts the Timeline Tick
			tick.play();
	}
}
