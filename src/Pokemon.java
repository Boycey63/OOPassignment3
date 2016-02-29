import processing.core.*;

public class Pokemon extends PApplet {
	
	InGame ingame;
	
	public static void main(String args[]) {
		PApplet.main(new String[] { "--present", "Pokemon" });
	}

	public void settings() {
		size(1200,700);
	}

	public void setup() {
		ingame = new InGame(this);
	}

	public void draw() {
		ingame.displayMap();
		ingame.displayCharacter();
		ingame.keyPressed();
	}
}