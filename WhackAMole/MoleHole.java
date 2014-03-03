package WhackAMole;

import Zen.*;

public class MoleHole extends ZenSprite {
	
	// A timer to count how many frames we should show the mole for.
	int timer = 0;
	// Whether or not to show a mole.
	boolean showMole = false;
	
	// A mole is a combination of smaller shapes, so we make it a Shape object.
	Shape mole;
	Oval hole;
	
	// Often, a sprite just needs to be set to a certain place.
	public MoleHole(int x, int y) {
		// Here, I'm setting the position of the sprite to the (x, y) coordinate given when I created it.
		set(x, y);
		
		// Create the mole shape.
		// First, make the face, a brown oval centered at (0, 0), which is 40 pixels wide and 30 pixels tall.
		Oval face = new Oval(0, 0, 40, 30, "chocolate");
		Oval leftEye = new Oval(-10, -10, 20, 20, "chocolate");
		Oval rightEye = new Oval(10, -10, 20, 20, "chocolate");
		Circle leftEyeBall = new Circle(-10, -10, 15, "white");
		Circle rightEyeBall = new Circle(10, -10, 15, "white");
		Circle leftEyePupil = new Circle(-10, -10, 10, "black");
		Circle rightEyePupil = new Circle(10, -10, 10, "black");
		Oval mouth = new Oval(0, 10, 20, 6, "brown");
		Line mouthLine = new Line(-6, 10, 6, 10, "black");
		mole = new Shape(face, leftEye, leftEyeBall, leftEyePupil, rightEye, rightEyeBall, rightEyePupil, mouth, mouthLine);
		hole = new Oval(x, y, 80, 30, "black");
		mole.set(x, y);
	}
	
	// Here, we draw the sprite.
	public void draw() {
		// Draw the hole.
		Zen.draw( hole );
		// Draw a mole if we should be drawing a mole.
		if (showMole) {
			// Tell Zen to draw the mole.
			Zen.draw(mole);
		}
	}
	
	// Here, we check if we should randomly display a mole.
	public void move() {
		// If the timer is not counting down already.
		if (timer == 0) {
			showMole = false;
			// Roll a 100 sided dice. If it lands on 1, then do the instructions inside the brackets.
			if(Zen.getRandomNumber(100) == 1) {
				// Start the timer counting down from 50.
				timer = 50;
				showMole = true;
			}
		}
		// If the timer is counting down and hasn't reached zero, reduce it's value by one.
		else if (timer > 0) {
			timer = timer - 1;
		}
	}
	
	// This is a custom function that simulates a "whack" on this mole hole.
	// It returns true if we did whack a mole, and false otherwise.
	public boolean whack() {
		// If this hole is showing a mole.
		if (showMole) {
			// Reset both the variables for showing a mole (showMole and the timer).
			showMole = false;
			timer = 0;
			// Tell whoever whacked this hole that they whacked a mole.
			return true;
		}
		// Otherwise, nothing to whack, so return false.
		else {
			return false;
		}
	}
}
