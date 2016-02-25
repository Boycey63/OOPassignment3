import processing.core.*;

public class Pokemon extends PApplet {
	int x, y, characterX, characterY , step;
	PImage map1;

	public static void main(String args[]) {
		PApplet.main(new String[] { "--present", "Pokemon" });
	}

	public void settings() {
		size(1200,750);
	}

	public void setup() {
		map1 = loadImage("background.jpg");
		characterX = width / 2;
		characterY = height /2;
		step = 5;
	}

	public void draw() {
		x = constrain(x, 0, map1.width - (width));
		y = constrain(y, 0, map1.height - (height));

		image(map1, -x, -y);

		stroke(255, 0, 0);
		fill(0, 255, 0);
		ellipse(characterX, characterY, 30, 30);
	}

	public void keyPressed() {
		if (key == 'd') {
			x = x + step;
			characterX = characterX + step;
		}

		if (key == 'a') {
			x = x - step;
			characterX = characterX - step;
		}

		if (key == 'w') {
			y = y - step;
			characterY = characterY - step;
		}

		if (key == 's') {
			y = y + step;
			characterY = characterY + step;
		}
	}
}
