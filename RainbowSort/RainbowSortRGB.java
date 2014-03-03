package RainbowSort;

import java.util.ArrayList;

import Zen.Zen;
import Zen.ZenGame;

public class RainbowSortRGB extends ZenGame {

	public static void main(String[] args) {
		RainbowSortRGB demo = new RainbowSortRGB();
		demo.run();
	}
	
	public static final int SIZE = 25;
	public static final int WIDTH = 32;
	public static final int HEIGHT = 24;
	
	private Color[] colors;
	
	public RainbowSortRGB() {
		colors = new Color[WIDTH * HEIGHT];
		setSize(WIDTH * SIZE, HEIGHT * SIZE);
		setFPS(30);
	}
	
	@Override
	public void setup() {
		int index = 0;
		int count = WIDTH * HEIGHT;
		double scale = 765 / ((double) count);
		for (int blue = 0 ; blue < count / 3 ; blue++) {
			colors[index] = new Color(0, (int) (blue * scale), 255 - (int) (blue * scale));
			index++;
		}
		for (int green = 0 ; green < count / 3 ; green++) {
			colors[index] = new Color((int) (green * scale), 255 - (int) (green * scale), 0);
			index++;
		}
		for (int red = 0 ; red < count / 3 ; red++) {
			colors[index] = new Color(255 - (int) (red * scale), 0, (int) (red * scale));
			index++;
		}
		for (int i = 0 ; i < 10000 ; i++) {
			int a = Zen.getRandomNumber(colors.length - 1), b = Zen.getRandomNumber(colors.length - 1);
			Color temp = colors[a];
			colors[a] = colors[b];
			colors[b] = temp;
		}
	}

	@Override
	public void loop() {
		Zen.setBackground("white");
		int index = 0;
		for (int x = 0 ; x < WIDTH ; x++) {
			for (int y = 0 ; y < HEIGHT ; y++) {
				if (index + 1 < colors.length) {
					Color c1 = colors[index];
					Color c2 = colors[index + 1];
					if (c1.getOrder() < c2.getOrder()) {
						Color temp = colors[index];
						colors[index] = colors[index + 1];
						colors[index + 1] = temp;
					}
				}
				index++;
			}
		}
		index = 0;
		for (int x = 0 ; x < WIDTH ; x++) {
			for (int y = 0 ; y < HEIGHT ; y++) {
				Zen.setColor(colors[index].red, colors[index].green, colors[index].blue);
				Zen.fillRect(x * SIZE, y * SIZE, SIZE, SIZE);
				index++;
			}
		}
	}
	
}
