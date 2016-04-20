import processing.core.*;

public class Pokemon extends PApplet {

	InGame ingame;
	LoadData loadData;
	BattleScene battlescene;
	writeData writedata;
	MainMenu mainMenu;
	Graphics graphics;
	BasePokemon basepokemon;
	
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
		writedata = new writeData(this);
		battlescene = new BattleScene(this);
		mainMenu = new MainMenu(this);
		graphics = new Graphics(this);
		basepokemon = new BasePokemon(this);
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

		if (mainmenu == true) {
			battleView = walkingView = false;
			mainMenu.gameMenu();
		}
	}
}