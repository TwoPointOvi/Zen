package WhackAMole;

import Zen.*;

public class Mallet extends ZenSprite {
	
	public Mallet() {
		setLayer(3); 
	}
	
	@Override
	public void draw() {
		Zen.setColor("brown");
		if (Zen.isMouseClicked()) {
			Zen.draw( new Line(getX(), getY(), getX() + 40, getY() - 20, 10) );
			Zen.draw( new Circle(getX() + 40, getY() - 20, 30));
		}
		else {
			Zen.draw( new Line(getX(), getY(), getX(), getY() - 50, 10) );
			Zen.draw( new Circle(getX(), getY() - 50, 30));
		}
	}

	@Override
	public void move() {
		set(Zen.getMouse());
	}

}
