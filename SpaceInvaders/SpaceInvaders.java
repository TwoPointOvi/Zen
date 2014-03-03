package SpaceInvaders;

import Zen.*;

public class SpaceInvaders extends ZenGame {
	
	public static void main(String[] args) {
		SpaceInvaders game = new SpaceInvaders();
		game.run();
	}
	
	Player player;
	int level = 0;
	boolean levelUp = true;
	
	public SpaceInvaders() {
		setSize(500, 800);
	}

	@Override
	public void setup() {
		
	}

	@Override
	public void loop() {
		Zen.setBackground("black");
		
		if (levelUp) {
			level++;
			generateLevel(level);
		}
	}

	private void generateLevel(int level) {
		if (level == 1) {
			for (int x = 50 ; x <= 450 ; x += 50) {
				addSprite(new Invader(x, 50));
			}
		}
	}
}
