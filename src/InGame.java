import processing.core.*;

class InGame {
	Pokemon p5;
	public static int characterX, characterY;
	public static int topR, bottomL;
	public static PImage map1;
	public static PImage map2;
	public static PImage character;
	int radius, step;
	public static int location;
	int black, white, backColour;
	public static int green;
	public static String[] background = new String[20];
	public static String[] movement = new String[20];
	public static int tempMovement;

	InGame(Pokemon _p5) {
		p5 = _p5;
		location = 2;
		characterX = 304;
		characterY = 413;
		radius = 30;
		step = 7;
		black = 0;
		white = -1;
		green = -16711936;

		// Initializes the image array
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

		// Initializes movement array
		movement[0] = "down1.png";
		movement[1] = "left3.png";
		movement[2] = "right3.png";
		movement[3] = "up3.png";
	}

	void displayMap() {
		// Bottom
		p5.image(map2 , 0, 0);

		// Top
		p5.image(map1, 0, 0);
	}

	void displayCharacter() {
		p5.image(character, characterX, characterY);
		topR = characterX + character.width;
		bottomL = characterY + character.height;
	}

	void keyPressed() {
		// --------------D----------------------
		if (p5.key == 'd' && map2.get(characterX + character.width, characterY) >= white
				&& map2.get(characterX + character.width, characterY + character.height) >= white) {
			characterX = characterX + step;
			tempMovement = 2;
			character = p5.loadImage(movement[2]);
			p5.key = 'm';
		}

		if (p5.key == 'd' && map2.get(characterX + character.width, characterY) >= green
				&& map2.get(characterX + character.width, characterY + character.height) >= green) {
			characterX = characterX + step;
			tempMovement = 2;
			character = p5.loadImage(movement[2]);
			p5.key = 'm';
		}
		// --------------A----------------------
		if (p5.key == 'a' && map2.get(characterX, characterY) >= white
				&& map2.get(characterX, characterY + character.height) >= white) {
			characterX = characterX - step;
			tempMovement = 1;
			character = p5.loadImage(movement[1]);
			p5.key = 'm';
		}

		if (p5.key == 'a' && map2.get(characterX, characterY) >= green
				&& map2.get(characterX, characterY + character.height) >= green) {
			characterX = characterX - step;
			tempMovement = 1;
			character = p5.loadImage(movement[1]);
			p5.key = 'm';
		}
		// --------------W----------------------
		if (p5.key == 'w' && map2.get(characterX, characterY) >= white
				&& map2.get(characterX + character.width, characterY) >= white) {
			if (characterY <= 0) {
				location = location + 2;
				map2 = p5.loadImage(background[location]);
				map1 = p5.loadImage(background[location + 1]);
				characterY = p5.height;
			}
			characterY = characterY - step;
			tempMovement = 3;
			character = p5.loadImage(movement[3]);
			p5.key = 'm';
		}

		else if (p5.key == 'w' && map2.get(characterX, characterY) >= green
				&& map2.get(characterX + character.width, characterY) >= green) {
			if (characterY <= 0) {
				location = location + 2;
				map2 = p5.loadImage(background[location]);
				map1 = p5.loadImage(background[location + 1]);
				characterY = p5.height;
			}
			characterY = characterY - step;
			tempMovement = 3;
			character = p5.loadImage(movement[3]);
			p5.key = 'm';
		}

		// --------------S----------------------
		if (p5.key == 's' && map2.get(characterX, characterY + character.height) >= white
				&& map2.get(characterX + character.width, characterY + character.height) >= white) {
			if (characterY + character.height >= p5.height) {
				location = location - 2;
				map2 = p5.loadImage(background[location]);
				map1 = p5.loadImage(background[location + 1]);
				characterY = 0;
			}
			characterY = characterY + step;
			tempMovement = 0;
			character = p5.loadImage(movement[0]);
			p5.key = 'm';
		}

		else if (p5.key == 's' && map2.get(characterX, characterY + character.height) >= green
				&& map2.get(characterX + character.width, characterY + character.height) >= green) {
			if (characterY + character.height >= p5.height) {
				location = location - 2;
				map2 = p5.loadImage(background[location]);
				map1 = p5.loadImage(background[location + 1]);
				characterY = 0;
			}
			characterY = characterY + step;
			tempMovement = 0;
			character = p5.loadImage(movement[0]);
			p5.key = 'm';
		}
	}
	
	void runInGame(){
		//Saves and exits program
		if (p5.key == 'z') {
			writeData.saveGame();
			System.out.println("Location = " + InGame.location);
			System.out.println("X = " + InGame.characterX);
			System.out.println("Y = " + InGame.characterY);
			System.out.println("Temp move =" + tempMovement);
			p5.exit();
		}

		// Displays map, character and the ability to move
		displayMap();
		displayCharacter();
		keyPressed();

		// If character is inside green start timer
		if (InGame.map2.get(InGame.characterX, InGame.characterY) == InGame.green  || InGame.map2.get(InGame.topR, InGame.characterY) == InGame.green || InGame.map2.get(InGame.characterX, InGame.bottomL) == InGame.green || InGame.map2.get(InGame.topR, InGame.bottomL) == InGame.green) {
			BattleScene.startTimer();
		}
	}
}