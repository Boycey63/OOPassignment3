import processing.core.*;
import java.io.File;

public class MainMenu {
	Pokemon p5;
	PImage pic;
	boolean newGame;
	public static int chosenID;
	public static int chosenTotHP, chosenActHP, chosenAttack, chosenDefense, chosenSpeed, chosenSpecial;
	public static int chosenHPIV, chosenAttackIV, chosenDefenseIV, chosenSpeedIV, chosenSpecialIV;

	MainMenu(Pokemon _p5) {
		p5 = _p5;
		pic = p5.loadImage("menuPic.jpg");
		newGame = false;
		chosenID = 0;
	}

	void gameMenu() {
		p5.image(pic, 0, 0);
		p5.fill(255);
		p5.rect(700, 40, 400, 120);
		p5.fill(255, 0, 0);
		p5.textSize(20);
		p5.text("Press ENTER = saved game", 725, 70);
		p5.text("Press TAB = new game", 725, 100);
		File file = new File("party.csv");

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
		chosenHPIV = (p5.floor(p5.random(0, 15)));
		chosenAttackIV = (p5.floor(p5.random(0, 15)));
		chosenDefenseIV = (p5.floor(p5.random(0, 15)));
		chosenSpeedIV = (p5.floor(p5.random(0, 15)));
		chosenSpecialIV = (p5.floor(p5.random(0, 15)));
		chosenActHP = (LoadData.start_ACThp.get(chosenID));
		chosenActHP = BattleScene.calStats(chosenActHP, chosenActHP, chosenHPIV, 0, 5);
		chosenTotHP = chosenActHP;
		chosenAttack = (LoadData.start_attack.get(chosenID));
		chosenAttack = BattleScene.calStats(chosenAttack, chosenAttack, chosenAttackIV, 0, 5);
		chosenDefense = (LoadData.start_defense.get(chosenID));
		chosenDefense = BattleScene.calStats(chosenDefense, chosenDefense, chosenDefenseIV, 0, 5);
		chosenSpeed = (LoadData.start_speed.get(chosenID));
		chosenSpeed = BattleScene.calStats(chosenSpeed, chosenSpeed, chosenSpeedIV, 0, 5);
		chosenSpecial = (LoadData.start_special.get(chosenID));
		chosenSpecial = BattleScene.calStats(chosenSpecial, chosenSpecial, chosenSpecialIV, 0, 5);
	}
}