package WhackAMole;

// This line imports the entire Zen library into your game.
import Zen.*;

/**
 * Whack-a-mole is a classic game where you try to, well, whack a mole. Since you shouldn't actually be
 * whacking your computer to play this game, you'll instead be clicking to simulate a whack.
 */
public class WhackMole extends ZenGame {

	Mallet mallet;
	MoleHole hole1;
	MoleHole hole2;
	MoleHole hole3;
	
	// Instructions that should begin when you tell your code to run go in here. The name
	// "public static void main" is a standard one - by the time you look at enough Java code, you'll
	// remember it by heart. Don't worry too much about the code in here yet.
	public static void main(String[] args) {
		// Tells Java to create this game.
		WhackMole game = new WhackMole();
		// Set the size of the game
		game.setSize(500, 500);
		game.setName("Whack-A-Mole");
		// Tell the game to run.
		game.run();
	}
	
	@Override
	public void setup() {
		Mallet m = new Mallet();
		addSprite(m);
		
		addSprite(new MoleHole(100, 450));
		addSprite(new MoleHole(250, 450));
		addSprite(new MoleHole(400, 450));
	}

	@Override
	public void loop() {
		// Every time you draw the screen, set the background color first.
		Zen.setBackground("tan");
	}
	
	
	
}
