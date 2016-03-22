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
			p5.key = 'm';
		}

		if (p5.key == p5.TAB) {
			File file = new File("party.csv");
			if (file.exists()) {
				file.delete();
			}
			System.out.println("File deleted");
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

	void keyPressed() {
		if (newGame == true) {
			if (p5.key == '1') {
				System.out.println("Done");
				chosenPok = 0;
				LoadData.loadStartPokemon();
				writeData.newParty();
				LoadData.loadALL();
				Pokemon.walkingView = true;
			}

			if (p5.key == '2') {
				System.out.println("Done");
				chosenPok = 1;
				LoadData.loadStartPokemon();
				writeData.newParty();
				LoadData.loadALL();
				Pokemon.walkingView = true;
			}

			if (p5.key == '3') {
				System.out.println("Done");
				chosenPok = 2;
				LoadData.loadStartPokemon();
				writeData.newParty();
				LoadData.loadALL();
				Pokemon.walkingView = true;
			}
		}
	}
}
//Reset Position of character

//InGame.location = 2;
//InGame.characterX = 304;
//InGame.characterY = 413;
//InGame.tempMovement = 0;