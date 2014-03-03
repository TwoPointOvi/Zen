package Zen;

public class Square extends ZenShape {
	private int side;
	
	public Square(int side) {
		this(0, 0, side, null);
	}
	
	public Square(int side, String color) {
		this(0, 0, side, color);
	}
	
	public Square(int x, int y, int side) {
		this(x, y, side, null);
	}
	
	public Square(int x, int y, int side, String color) {
		this.setX(x);
		this.setY(y);
		this.setSize(side);
		this.setColor(color);
	}

	public void draw() {
		Zen.fillRect(getX(), getY(), side, side);
	}
	
	public int getSize() {
		return side;
	}

	public void setSize(int size) {
		this.side = size;
	}
}
