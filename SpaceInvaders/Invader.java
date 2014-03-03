package SpaceInvaders;

import Zen.*;

public class Invader extends ZenSprite {

	Shape myself;
	
	public Invader(int x, int y) {
		myself = new Shape(
			new Rectangle(0, 7, 20, 10, "yellow green"),
			new Polygon("yellow green", new Point(0, 7), new Point(12, 0), new Point(18, 0), new Point(20, 10))
		);
		set(x, y);
	}
	
	@Override
	public void draw() {
		myself.set(getX(), getY());
		myself.draw();
	}

	@Override
	public void move() {
		
	}

}
