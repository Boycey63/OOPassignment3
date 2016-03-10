import processing.core.*;

class InGame {
	PImage map1;
	PImage map2;
	PImage character;
	int x, y;
	int radius, step, location;
	int black, white, green, backColour;
	Pokemon p5;
	String[] background = new String[20];
	String[] movement = new String[20];

	InGame(Pokemon _p5) {
		p5 = _p5;
		location = 2;
		x = y = 0;
		Pokemon.characterX = p5.width / 2;
		Pokemon.characterY = p5.height * 3 / 4;
		radius = 30;
		step = 10;
		black = 0;
		white = -1;
		green = -16711936;
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

		movement[0] = "down1.png";
		movement[1] = "left3.png";
		movement[2] = "right3.png";
		movement[3] = "up3.png";

		character = p5.loadImage(movement[0]);
	}

	void displayMap() {
		// Bottom
		p5.image(map2, -x, -y);

		// Top
		p5.image(map1, -x, -y);
	}

	void displayCharacter() {
		p5.image(character, Pokemon.characterX, Pokemon.characterY);
	}

	void keyPressed() {
		// --------------D----------------------
		if (p5.key == 'd' && map2.get(Pokemon.characterX + character.width, Pokemon.characterY) >= white
				&& map2.get(Pokemon.characterX + character.width, Pokemon.characterY + character.height) >= white) {
			Pokemon.characterX = Pokemon.characterX + step;
			character = p5.loadImage(movement[2]);
			p5.key = 'm';
		}

		if (p5.key == 'd' && map2.get(Pokemon.characterX + character.width, Pokemon.characterY) >= green
				&& map2.get(Pokemon.characterX + character.width, Pokemon.characterY + character.height) >= green) {
			Pokemon.characterX = Pokemon.characterX + step;
			character = p5.loadImage(movement[2]);
			p5.key = 'm';
		}
		// --------------A----------------------
		if (p5.key == 'a' && map2.get(Pokemon.characterX, Pokemon.characterY) >= white
				&& map2.get(Pokemon.characterX, Pokemon.characterY + character.height) >= white) {
			Pokemon.characterX = Pokemon.characterX - step;
			character = p5.loadImage(movement[1]);
			p5.key = 'm';
		}

		if (p5.key == 'a' && map2.get(Pokemon.characterX, Pokemon.characterY) >= green
				&& map2.get(Pokemon.characterX, Pokemon.characterY + character.height) >= green) {
			Pokemon.characterX = Pokemon.characterX - step;
			character = p5.loadImage(movement[1]);
			p5.key = 'm';
		}
		// --------------W----------------------
		if (p5.key == 'w' && map2.get(Pokemon.characterX, Pokemon.characterY) >= white
				&& map2.get(Pokemon.characterX + character.width, Pokemon.characterY) >= white) {
			if (Pokemon.characterY <= 0) {
				location = location + 2;
				map2 = p5.loadImage(background[location]);
				map1 = p5.loadImage(background[location + 1]);
				Pokemon.characterY = p5.height;
			}
			Pokemon.characterY = Pokemon.characterY - step;
			character = p5.loadImage(movement[3]);
			p5.key = 'm';
		}

		else if (p5.key == 'w' && map2.get(Pokemon.characterX, Pokemon.characterY) >= green
				&& map2.get(Pokemon.characterX + character.width, Pokemon.characterY) >= green) {
			if (Pokemon.characterY <= 0) {
				location = location + 2;
				map2 = p5.loadImage(background[location]);
				map1 = p5.loadImage(background[location + 1]);
				Pokemon.characterY = p5.height;
			}
			Pokemon.characterY = Pokemon.characterY - step;
			character = p5.loadImage(movement[3]);
			p5.key = 'm';
		}

		// --------------S----------------------
		if (p5.key == 's' && map2.get(Pokemon.characterX, Pokemon.characterY + character.height) >= white
				&& map2.get(Pokemon.characterX + character.width, Pokemon.characterY + character.height) >= white) {
			if (Pokemon.characterY + character.height >= p5.height) {
				location = location - 2;
				map2 = p5.loadImage(background[location]);
				map1 = p5.loadImage(background[location + 1]);
				Pokemon.characterY = 0;
			}
			Pokemon.characterY = Pokemon.characterY + step;
			character = p5.loadImage(movement[0]);
			p5.key = 'm';
		}

		else if (p5.key == 's' && map2.get(Pokemon.characterX, Pokemon.characterY + character.height) >= green
				&& map2.get(Pokemon.characterX + character.width, Pokemon.characterY + character.height) >= green) {
			if (Pokemon.characterY + character.height >= p5.height) {
				location = location - 2;
				map2 = p5.loadImage(background[location]);
				map1 = p5.loadImage(background[location + 1]);
				Pokemon.characterY = 0;
			}
			Pokemon.characterY = Pokemon.characterY + step;
			character = p5.loadImage(movement[0]);
			p5.key = 'm';
		}
	}
}