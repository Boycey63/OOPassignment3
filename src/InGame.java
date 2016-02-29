import processing.core.*;

class InGame {
	PImage map1;
	PImage map2;
	int x, y;
	int characterX, characterY;
	int radius , step ,location;
	int black, white, green, backColour;
	Pokemon p5;
	String[] background = new String[20];

	InGame(Pokemon _p5){
		p5 = _p5;
		location = x = y = 6;
		characterX = p5.width / 2;
		characterY = p5.height /2;
		radius = 30;
		step = 10;
		black = 0;
		white = -1;
		green = -16712192;
		background[0] = "Pallet Town2B.png";
		background[1] = "Pallet Town2F.png";
		background[2] = "Pallet Town1B.png";
		background[3] = "Pallet Town1F.png";
		background[4] = "part1B.png";
		background[5] = "part1F.png";
		background[6] = "part2B.png";
		background[7] = "part2F.png";
		background[8] = "part3B.png";
		background[9] = "part3F.png";
		background[10] = ".png";
		background[11] = ".png";
		background[12] = ".png";
		map2 = p5.loadImage(background[location]);
		map1 = p5.loadImage(background[location + 1]);
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
		
		if(p5.key == 'd' && map2.get(characterX + (radius /2), characterY) == green){
			characterX = characterX + step;
			p5.key = 'm';
		}
		
		if (p5.key == 'a' && map2.get(characterX - (radius /2), characterY) == white){
			characterX = characterX - step;
			p5.key = 'm';
		}
		
		if(p5.key == 'a' && map2.get(characterX - (radius /2), characterY) == green){
			characterX = characterX - step;
			p5.key = 'm';
		}
		
		if (p5.key == 'w' && map2.get(characterX, characterY - (radius /2)) == white){
			characterY = characterY - step;
			p5.key = 'm';
		}
		
		if(p5.key == 'w' && map2.get(characterX, characterY - (radius /2)) == green){
			characterY = characterY - step;
			p5.key = 'm';
		}

		if (p5.key == 's' && map2.get(characterX, characterY + (radius /2)) == white) {
			characterY = characterY + step;
			p5.key = 'm';
		}
		
		if(p5.key == 's' && map2.get(characterX, characterY + (radius /2)) == green){
			characterY = characterY + step;
			p5.key = 'm';
		}
	}
}