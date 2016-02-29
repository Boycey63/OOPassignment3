import processing.core.*;

class InGame {
	PImage map1;
	PImage map2;
	int x, y;
	int characterX, characterY;
	int radius , step;
	int black, white, backColour;
	Pokemon p5;

	InGame(Pokemon _p5){
		p5 = _p5;
		x = y = 0;
		characterX = p5.width / 2;
		characterY = p5.height /2;
		radius = 30;
		step = 10;
		black = p5.color(0, 0, 0);
		white = p5.color(255, 255, 255);
		map2 = p5.loadImage("Pallet Town1B.png");
		map1 = p5.loadImage("Pallet Town1F.png");
	}
	
	void displayMap(){
		//Bottom
		p5.image(map2,-x, -y);
						
		//Top
		p5.image(map1, -x, -y);
	}
	
	void displayCharacter(){
		p5.stroke(255, 0, 0);
		p5.fill(0, 255, 0);
		p5.ellipse(characterX, characterY, radius, radius);
	}
	
	void keyPressed() {				
		if (p5.key == 'd' && map2.get(characterX + (radius /2), characterY) == white) {
			characterX = characterX + step;
			p5.key = 'm';
		}

		if (p5.key == 'a' && map2.get(characterX - (radius /2), characterY) == white) {
			characterX = characterX - step;
			p5.key = 'm';
		}
		
		if (p5.key == 'w' && map2.get(characterX, characterY - (radius /2)) == white) {
			characterY = characterY - step;
			p5.key = 'm';
		}

		if (p5.key == 's' && map2.get(characterX, characterY + (radius /2)) == white) {
			characterY = characterY + step;
			p5.key = 'm';
		}
	}
}