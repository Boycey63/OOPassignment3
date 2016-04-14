import processing.core.*;
import java.io.File;

public class MainMenu {
	static Pokemon p5;
	PImage pic;
	boolean newGame;

	MainMenu(Pokemon _p5) {
		p5 = _p5;
		pic = p5.loadImage("menuPic.jpg");
		newGame = false;
	}

	void gameMenu() {
		p5.image(pic, 0, 0);
		p5.fill(255);
		p5.rect(700, 40, 400, 120);
		p5.fill(255, 0, 0);
		p5.textSize(20);
		p5.text("Press ENTER = saved game", 725, 70);
		p5.text("Press TAB = new game", 725, 100);
		File file = new File("LoadData" + File.separator + "party.csv");

		if (p5.key == p5.ENTER) {
			if (file.exists()) {
				LoadData.loadParty();
				LoadData.loadMoves();
				Pokemon.walkingView = true;
				p5.key = 'm';
			} else {
				p5.fill(0);
				p5.text("No saved file, Please start new game", 725, 130);
			}
		}

		if (p5.key == p5.TAB) {
			newGame = true;
			LoadData.loadStartPokemon();
			LoadData.loadMoves();
			p5.fill(0, 255, 0);
			p5.rect(750, 160, 300, 150);
			p5.fill(0, 0, 255);
			p5.text("Choose a starter pokemon:", 755, 190);
			p5.text("Press 1 for " + LoadData.start_name.get(0), 755, 220);
			p5.text("Press 2 for " + LoadData.start_name.get(1), 755, 250);
			p5.text("Press 3 for " + LoadData.start_name.get(2), 755, 280);
		}

		if (newGame == true) {
			keyPressed();
		}
	}

	void deleteFile() {
		File file = new File("party.csv");
		if (file.exists()) {
			file.delete();
		}
	}

	static void resetLocation() {
		InGame.location = 2;
		InGame.characterX = 304;
		InGame.characterY = 413;
		InGame.tempMovement = 0;
		InGame.map2 = p5.loadImage(InGame.background[InGame.location]);
		InGame.map1 = p5.loadImage(InGame.background[InGame.location + 1]);
		InGame.character = p5.loadImage(InGame.movement[InGame.tempMovement]);
		if (BattleScene.GameOver == false) {
			writeData.saveGame();
		}
	}

	void keyPressed() {
		if (newGame == true) {
			if (p5.key == '1') {
				deleteFile();
				resetLocation();
				BasePokemon.chosenID = 0;
				BasePokemon.intFirstPoke();
				writeData.newParty();
				LoadData.loadParty();
				p5.key = 'm';
				Pokemon.walkingView = true;
			}

			if (p5.key == '2') {
				deleteFile();
				resetLocation();
				BasePokemon.chosenID = 1;
				BasePokemon.intFirstPoke();
				writeData.newParty();
				LoadData.loadParty();
				p5.key = 'm';
				Pokemon.walkingView = true;
			}

			if (p5.key == '3') {
				deleteFile();
				resetLocation();
				BasePokemon.chosenID = 2;
				BasePokemon.intFirstPoke();
				writeData.newParty();
				LoadData.loadParty();
				p5.key = 'm';
				Pokemon.walkingView = true;
			}
		}
	}
}