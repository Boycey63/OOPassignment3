import processing.core.*;

public class Pokemon extends PApplet {
	int x, y, characterX, characterY, radius , step;
	int black, white;
	PImage map1;
	PImage map2;

	public static void main(String args[]) {
		PApplet.main(new String[] { "--present", "Pokemon" });
	}

	public void settings() {
		size(1200,700);
	}

	public void setup() {
		map2 = loadImage("Pallet Town1B.png");
		map1 = loadImage("Pallet Town1F.png");
		characterX = width / 2;
		characterY = height /2;
		x = y = 0;
		step = 5;
		radius = 30;
		black = color(0, 0, 0);
		white = color(255, 255, 255);
	}

	public void draw() {
		//Bottom
		image(map2,-x, -y);
				
		//Top
		image(map1, -x, -y);
		
		stroke(255, 0, 0);
		fill(0, 255, 0);
		ellipse(characterX, characterY, radius, radius);
	}
	
	public void keyPressed() {
		if (key == 'd' && map2.get(characterX + (radius /2), characterY) == white) {
			characterX = characterX + step;
		}

		if (key == 'a' && map2.get(characterX - (radius /2), characterY) == white) {
			characterX = characterX - step;
		}
		
		if (key == 'w' && map2.get(characterX, characterY - (radius /2)) == white) {
			characterY = characterY - step;
		}

		if (key == 's' && map2.get(characterX, characterY + (radius /2)) == white) {
			characterY = characterY + step;
		}
	}
}