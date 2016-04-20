import processing.core.*;
import java.io.File;

public class MainMenu {
	static Pokemon p5;
	PImage pic;
	public static boolean newGame;

	MainMenu(Pokemon _p5) {
		p5 = _p5;
		pic = p5.loadImage("menuPic.jpg");
		newGame = false;
	}

	void gameMenu() {
		p5.image(pic, 0, 0);
		Graphics.DrawstartMenu();
		File file = new File("LoadData" + File.separator + "party.csv");
		LoadData.loadMoves();
		LoadData.loadParty();
		
		if (p5.key == p5.ENTER) {
			if (file.exists()) {
				LoadData.loadPokeDex();
				LoadData.loadSaveGame();
				LoadData.loadMoves();
				// Set saved background image
				InGame.map2 = p5.loadImage(InGame.background[InGame.location]);
				InGame.map1 = p5.loadImage(InGame.background[InGame.location + 1]);
				InGame.character = p5.loadImage(InGame.movement[InGame.tempMovement]);
				Pokemon.walkingView = true;
				p5.key = 'm';
			} 
			
			else {
				p5.fill(0);
				p5.text("No saved file, Please start new game", 725, 130);
			}
		}

		if (p5.key == p5.TAB) {
			newGame = true;
			LoadData.loadStartPokemon();
			LoadData.loadMoves();
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
				LoadData.loadPokeDex();
				BasePokemon.chosenID = 0;
				BasePokemon.intFirstPoke();
				writeData.newParty();
				LoadData.loadParty();
				LoadData.loadPokeArea();
				p5.key = 'm';
				Pokemon.walkingView = true;
			}

			if (p5.key == '2') {
				deleteFile();
				resetLocation();
				LoadData.loadPokeDex();
				BasePokemon.chosenID = 1;
				BasePokemon.intFirstPoke();
				writeData.newParty();
				LoadData.loadParty();
				LoadData.loadPokeArea();
				p5.key = 'm';
				Pokemon.walkingView = true;
			}

			if (p5.key == '3') {
				deleteFile();
				resetLocation();
				LoadData.loadPokeDex();
				BasePokemon.chosenID = 2;
				BasePokemon.intFirstPoke();
				writeData.newParty();
				LoadData.loadParty();
				LoadData.loadPokeArea();
				p5.key = 'm';
				Pokemon.walkingView = true;
			}
		}
	}
}