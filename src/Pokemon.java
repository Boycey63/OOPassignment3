import processing.core.*;

public class Pokemon extends PApplet {
	int x, y, x2, y2, characterX, characterY, radius , step;
	int black, white;
	PImage map1;
	PImage map2;

	public static void main(String args[]) {
		PApplet.main(new String[] { "--present", "Pokemon" });
	}

	public void settings() {
		size(1200,750);
	}

	public void setup() {
		map2 = loadImage("underbackground.jpg");
		map1 = loadImage("background.jpg");
		characterX = width / 2;
		characterY = height /2;
		step = 5;
		radius = 30;
		black = color(0, 0, 0);
		white = color(255, 255, 255);
	}

	public void draw() {
		x = constrain(x, 0, map1.width - width);
		y = constrain(y, 0, map1.height - height);
		
		x2 = constrain(x2, 0, map1.width - width);
		y2 = constrain(y2, 0, map1.height - height);

		image(map2,-x,-y);
		image(map1, -x, -y);

		stroke(255, 0, 0);
		fill(0, 255, 0);
		ellipse(characterX, characterY, radius, radius);
	}

	public void keyPressed() {
		if (key == 'd' && map2.get(characterX, characterY) == white) {
			x = x + step;
			x2 = x2 + step;
			characterX = characterX + step;
			}
			
		else if(map2.get(characterX, characterY) == black){
				characterX = characterX - 100;
			}

		if (key == 'a' && map2.get(characterX, characterY) == white) {
			x = x - step;
			x2 = x2 - step;
			characterX = characterX - step;
			}
			
		else if(map2.get(characterX, characterY) == black){
			characterX = characterX + 100;
			}
		
		if (key == 'w' && map2.get(characterX, characterY) == white) {
			y = y - step;
			y2 = y2 - step;
			characterY = characterY - step;
		}
			
			else if(map2.get(characterX, characterY) == black){
				characterY = characterY + 100;
			}

		if (key == 's' && map2.get(characterX, characterY) == white) {
			y = y + step;
			y2 = y2 + step;
			characterY = characterY + step;
			}
			
		else if(map2.get(characterX, characterY) == black){
			characterY = characterY - 100;
			}
		}
}
