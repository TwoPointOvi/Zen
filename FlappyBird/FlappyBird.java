package FlappyBird;

import java.util.ArrayList;

import Zen.*;

public class FlappyBird extends ZenGame {
	
	/**
	 * The main entry point to our program, tells Java to run this ZenGame.
	 */
	public static void main(String[] args) {
		FlappyBird game = new FlappyBird();
		game.run();
	}
	
	public static final int GRAVITY = 2;
	public static final int THRUST = 15;
	public static final int GROUND = 575;
	public static final int SPEED = 3;
	
	// Variables in the game.
	int step = 0;
	boolean dead = false;
	
	// Objects in the game.
	Bird flappy;
	ScoreBoard scoreboard;

	ArrayList <Pipe> pipes;
	
	public FlappyBird() {
		pipes = new ArrayList <Pipe> ();
		setSize(400, 600);		// Set the size of the window to 400 pixels by 600 pixels.
		setFPS(30);				// Set to 30 FPS (frames per second).
	}
	
	public void setup() {
		flappy = new Bird();
		flappy.set(100, 300);
		addSprite(flappy);
		scoreboard = new ScoreBoard();
		scoreboard.setLayer(3);
		addSprite(scoreboard);
		
		Zen.addColor("pipe green", 69, 201, 45);
		Zen.addColor("pipe dark green", 62, 143, 34);
		Zen.addColor("pipe light green", 109, 230, 79);
	}
	
	public void loop() {
		Zen.setBackground("light blue");
		if (step % 100 == 0) {
			Pipe p = new Pipe();
			pipes.add(p);
			addSprite(p);
		}
		step++;
		
		for (int i = 0 ; i < pipes.size() ; i++) {
			Pipe p = pipes.get(i);
			if ( flappy.getX() >= p.getX() && flappy.getX() <= p.getX() + 50 
					&& flappy.getY() <= p.gap - 75) {
				Zen.sleep(1000);
			}
		}
		
		Zen.setColor("dark green");
		Zen.fillRect(0, 550, 400, 50);
	}
	
}
