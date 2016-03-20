
//Save position of character and what map I'm on
//Set pokemon stats

import processing.core.*;

public class Pokemon extends PApplet {

	InGame ingame;
	LoadData loadData;
	BattleScene battlescene;
	writeData writedata;

	public static int opt;
	public static boolean walkingView, battleView;
	public static boolean timerStart;

	int a, lc, z;

	public static void main(String args[]) {
		PApplet.main(new String[] { "--present", "Pokemon" });
	}

	public void settings() {
		size(1200, 700);
	}

	public void setup() {
		walkingView = true;
		battleView = false;
		timerStart = false;
		opt = 0;
		ingame = new InGame(this);
		loadData = new LoadData();
		writedata = new writeData();
		battlescene = new BattleScene(this);
		loadData.loadSaveGame();
		loadData.loadALL();

		// Set saved background image
		InGame.map2 = loadImage(InGame.background[InGame.location]);
		InGame.map1 = loadImage(InGame.background[InGame.location + 1]);
		writedata.saveGame();
	}

	public void draw() {

		if (walkingView == true) {
			battleView = false;
			
			//Saves and exits program
			if (key == 'z') {
				writedata.saveGame();
				System.out.println("Location = " + InGame.location);
				System.out.println("X = " + InGame.characterX);
				System.out.println("Y = " + InGame.characterY);
				exit();
			}

			// Displays map, character and the ability to move
			ingame.displayMap();
			ingame.displayCharacter();
			ingame.keyPressed();

			// If character is inside green start timer
			if (InGame.map2.get(InGame.characterX, InGame.characterY) == InGame.green) {
				battlescene.startTimer();
			}
		}

		if (battleView == true) {
			walkingView = false;

			battlescene.defaultDraw();

			// Displays default battle menu
			if (opt == 0) {
				battlescene.menu1();
			}
			// Opt variable changes the Battle option
			// Displays attack menu
			if (opt == 1) {
				battlescene.menu1();
				battlescene.attackMenu();
			}

			// Displays party menu
			if (opt == 2) {
				battlescene.partyMenu();
			}

			// Possibly catches pokemon and changes to walk mode
			if (opt == 3) {
				battlescene.throwBall();
				writedata.addToParty();
				loadData.loadParty();
				BattleScene.resetTimer = true;
				walkingView = true;
			}
			// Possibly runs from pokemon
			if (opt == 4) {
				walkingView = true;
				BattleScene.resetTimer = true;
			}
		}
	}
}