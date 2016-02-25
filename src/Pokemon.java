import processing.core.*;

public class Pokemon extends PApplet {
	int x, y, step;
	PImage map1;

	public static void main(String args[]) {
		PApplet.main(new String[] { "--present", "Pokemon" });
	}

	public void settings() {
		size(1200,800);
	}

	public void setup() {
		map1 = loadImage("background.jpg");
		step = 10;
	}

	public void draw() {
		x = constrain(x, 0, map1.width - (width/2));
		y = constrain(y, 0, map1.height - (height/2));

		image(map1, -x, -y);

		stroke(255, 0, 0);
		fill(0, 255, 0);
		ellipse(width / 2, height / 2, 30, 30);
	}

	public void keyPressed() {
		if (key == 'd') {
			x = x + step;
		}

		if (key == 'a') {
			x = x - step;
		}

		if (key == 'w') {
			y = y - step;
		}

		if (key == 's') {
			y = y + step;
		}
	}
}
