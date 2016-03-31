import processing.core.*;
import java.io.File;
import java.util.ArrayList;

public class MainMenu {
	Pokemon p5;
	PImage pic;
	boolean newGame;
	public static int chosenID;
	public static int chosenTotHP, chosenActHP, chosenAttack, chosenDefense, chosenSpeed, chosenTotal,
			chosenXp, chosenSpecial;
	int i;

	MainMenu(Pokemon _p5) {
		p5 = _p5;
		pic = p5.loadImage("menuPic.jpg");
		newGame = false;
		chosenID = 0;
	}

	void gameMenu() {
		p5.image(pic, 0, 0);
		p5.fill(255);
		p5.rect(870, 30, 300, 640);
		p5.fill(255, 0, 0);
		p5.textSize(20);
		p5.text("Press ENTER = saved game", 870, 60);
		p5.text("Press TAB = new game", 870, 90);

		if (p5.key == p5.ENTER) {
			LoadData.loadParty();
			System.out.println(LoadData.partyCounter);
			LoadData.loadMoves();	
			Pokemon.walkingView = true;
			p5.key = 'm';
		}

		if (p5.key == p5.TAB) {
			newGame = true;
			LoadData.loadStartPokemon();
			LoadData.loadMoves();
			p5.fill(0, 255, 0);
			p5.rect(570, 50, 300, 150);
			p5.fill(0, 0, 255);
			p5.text("Choose a starter pokemon:", 580, 80);
			p5.text("Press 1 for " + LoadData.start_name.get(0), 580, 120);
			p5.text("Press 2 for " + LoadData.start_name.get(1), 580, 150);
			p5.text("Press 3 for " + LoadData.start_name.get(2), 580, 180);
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

	void resetLocation() {
		InGame.location = 2;
		InGame.characterX = 304;
		InGame.characterY = 413;
		InGame.tempMovement = 0;
		InGame.map2 = p5.loadImage(InGame.background[InGame.location]);
		InGame.map1 = p5.loadImage(InGame.background[InGame.location + 1]);
		InGame.character = p5.loadImage(InGame.movement[InGame.tempMovement]);
		writeData.saveGame();
	}

	void keyPressed() {
		if (newGame == true) {
			if (p5.key == '1') {
				deleteFile();
				resetLocation();
				chosenID = 0;
				intChosen();
				writeData.newParty();
				LoadData.loadParty();
				p5.key = 'm';
				Pokemon.walkingView = true;
			}

			if (p5.key == '2') {
				deleteFile();
				resetLocation();
				chosenID = 1;
				intChosen();
				writeData.newParty();
				LoadData.loadParty();
				p5.key = 'm';
				Pokemon.walkingView = true;
			}

			if (p5.key == '3') {
				deleteFile();
				resetLocation();
				chosenID = 2;
				intChosen();
				writeData.newParty();
				LoadData.loadParty();
				p5.key = 'm';
				Pokemon.walkingView = true;
			}
		}
	}

	void intChosen() {
		chosenActHP = (LoadData.start_ACThp.get(chosenID));
		chosenTotHP = chosenActHP;
		chosenAttack = (LoadData.start_attack.get(chosenID));
		chosenDefense = (LoadData.start_defense.get(chosenID));
		chosenSpeed = (LoadData.start_speed.get(chosenID));
		chosenSpecial = (LoadData.start_special.get(chosenID));
	}
}