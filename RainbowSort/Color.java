package RainbowSort;

import Zen.Square;
import Zen.Zen;
import Zen.ZenSprite;

public class Color extends ZenSprite {
	
	int red, green, blue;
	int order;
	
	public Color(int r, int g, int b) {
		red = r;
		green = g;
		blue = b;
		order = ((red & 0x0ff) << 16) | ((green & 0x0ff) << 8) | (blue & 0x0ff);
		// order = red + green + blue;
		//order = red * 100 + green * 10 + blue;
	}
	
	public int getOrder() {
		return order;
	}
	
	@Override
	public void draw() {
		Zen.setColor(red, green, blue);
		System.out.println("My position: " + getX() + ", " + getY() + " and color: " + red + ", " + green + ", " + blue);
		Zen.fillRect(getX() * RainbowSortRGB.SIZE, getY() * RainbowSortRGB.SIZE, RainbowSortRGB.SIZE, RainbowSortRGB.SIZE);
	}

	@Override
	public void move() {
	}

}
