package RainbowSort;

import Zen.Zen;
import Zen.ZenGame;

public class RainbowSort extends ZenGame {

	public static void main(String[] args) {
		RainbowSort demo = new RainbowSort();
		demo.run();
	}
	
	public static final int SIZE = 25;
	public static final int WIDTH = 32;
	public static final int HEIGHT = 24;
	public static final int RANGE = 25000;
	
	private int[] colors;
	
	public RainbowSort() {
		colors = new int[WIDTH * HEIGHT];
		setSize(WIDTH * SIZE, HEIGHT * SIZE);
		setFPS(20);
	}
	
	@Override
	public void setup() {
		for (int i = 0 ; i < colors.length ; i++)
			colors[i] = Zen.getRandomNumber(RANGE);
	}

	@Override
	public void loop() {
		bubbleSortStep();
		//insertionSortStep();
		
		int i = 0;
		for (int x = 0 ; x < WIDTH ; x++) {
			for (int y = 0 ; y < HEIGHT ; y++) {
				hsbColorize(i);
				Zen.fillRect(x * SIZE, y * SIZE, SIZE, SIZE);
				i++;
			}
		}
	}
	
	public void bubbleSortStep() {
		// Go through the entire array
		for (int i = 0 ; i < colors.length - 1 ; i++) {
			if (colors[i] > colors[i + 1]) {
				int temp = colors[i];
				colors[i] = colors[i + 1];
				colors[i + 1] = temp;
			}
		}
	}
	
	int insertTo = 0;
	public void insertionSortStep() {
		if (insertTo < colors.length) {
			int min = insertTo;
			for (int i = insertTo ; i < colors.length ; i++) {
				if (colors[i] < colors[min]) {
					min = i;
				}
			}
			int temp = colors[insertTo];
			colors[insertTo] = colors[min];
			colors[min] = temp;
			// Insert into the next space
			insertTo++;
		}
	}
	
	public void hsbColorize(int i) {
		Zen.setHSB(((float) (colors[i])) / RANGE, 0.1f, 0.5f);
	}
	
	public void rainbowColorize(int i) {
		if (colors[i] <= 140)
			Zen.setColor("purple");
		else if (colors[i] <= 280)
			Zen.setColor("dark blue");
		else if (colors[i] <= 420)
			Zen.setColor("blue");
		else if (colors[i] <= 560)
			Zen.setColor("green");
		else if (colors[i] <= 700)
			Zen.setColor("yellow");
		else if (colors[i] <= 840)
			Zen.setColor("orange");
		else
			Zen.setColor("red");
	}
	
}