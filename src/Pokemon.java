//Set pokemon stats

import processing.core.*;

public class Pokemon extends PApplet {

	InGame ingame;
	LoadData loadData;
	BattleScene battlescene;
	writeData writedata;
	MainMenu mainMenu;

	public static boolean walkingView, battleView, mainmenu;
	public static boolean timerStart;

	public static void main(String args[]) {
		PApplet.main(new String[] { "--present", "Pokemon" });
	}

	public void settings() {
		size(1200, 700);
	}

	public void setup() {
		mainmenu = true;
		walkingView = false;
		battleView = false;
		timerStart = false;
		ingame = new InGame(this);
		loadData = new LoadData();
		writedata = new writeData();
		battlescene = new BattleScene(this);
		mainMenu = new MainMenu(this);
		loadData.loadSaveGame();
		loadData.loadALL();

		// Set saved background image
		InGame.map2 = loadImage(InGame.background[InGame.location]);
		InGame.map1 = loadImage(InGame.background[InGame.location + 1]);
		InGame.character = loadImage(InGame.movement[InGame.tempMovement]);	
	}

	public void draw() {

		if (walkingView == true) {
			battleView = mainmenu = false;
			ingame.runInGame();
		}

		if (battleView == true) {
			walkingView = mainmenu = false;
			battlescene.runBattleScene();
		}
		
		if (mainmenu == true){
			battleView = walkingView = false;
			mainMenu.gameMenu();
		}
	}
}