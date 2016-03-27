import processing.core.*;
import java.io.File;

public class MainMenu {
	Pokemon p5;
	PImage pic;
	boolean newGame;
	public static int chosenPok;
	int i;

	MainMenu(Pokemon _p5) {
		p5 = _p5;
		pic = p5.loadImage("menuPic.jpg");
		newGame = false;
		chosenPok = 0;
	}

	void gameMenu() {
		p5.image(pic, 0, 0);
		p5.stroke(255);
		p5.textSize(30);
		p5.text("Press ENTER = saved game", 30, 30);
		p5.text("Press TAB = new game", 30, 60);

		if (p5.key == p5.ENTER) {
			Pokemon.walkingView = true;
			System.out.println(LoadData.party_name.get(0));
			p5.key = 'm';
		}

		if (p5.key == p5.TAB) {
			newGame = true;
		}

		if (newGame == true) {
			LoadData.loadStartPokemon();
			p5.text("Choose a pokemon", 30, 100);
			p5.text("Press 1 for" + LoadData.start_name.get(0), 30, 140);
			p5.text("Press 2 for" + LoadData.start_name.get(1), 30, 170);
			p5.text("Press 3 for" + LoadData.start_name.get(2), 30, 200);
			keyPressed();
		}
	}

	void deleteFile() {
		File file = new File("party.csv");
		if (file.exists()) {
			file.delete();
		}
		System.out.println("File deleted");
	}

	void resetLocation() {
		InGame.location = 2;
		InGame.characterX = 304;
		InGame.characterY = 413;
		InGame.tempMovement = 0;
		InGame.character = p5.loadImage(InGame.movement[InGame.tempMovement]);
	}

	void keyPressed() {
		if (newGame == true) {
			if (p5.key == '1') {
				deleteFile();
				resetLocation();
				chosenPok = 0;
				writeData.newParty();
				LoadData.loadParty();
				System.out.println("CheckPoint");
				Pokemon.walkingView = true;
			}

			if (p5.key == '2') {
				deleteFile();
				resetLocation();
				chosenPok = 1;
				writeData.newParty();
				LoadData.loadParty();
				System.out.println("CheckPoint");
				Pokemon.walkingView = true;
			}

			if (p5.key == '3') {
				deleteFile();
				resetLocation();
				chosenPok = 2;
				writeData.newParty();
				LoadData.loadParty();
				System.out.println("CheckPoint");
				Pokemon.walkingView = true;
			}
		}
	}
}