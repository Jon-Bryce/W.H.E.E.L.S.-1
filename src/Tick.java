import javafx.animation.AnimationTimer;

public class Tick extends AnimationTimer{

	ObjectList objects;
	long frameNum = 0;
	public Tick (ObjectList objects) {
		this.objects = objects;
	}
	
	@Override
	public void handle(long now) {
		doHandle();		
	}

	private void doHandle() {
		frameNum ++;
		objects.tick(frameNum);
	}
}
