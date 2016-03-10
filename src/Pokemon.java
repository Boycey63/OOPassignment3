import java.util.ArrayList;
import processing.core.*;

public class Pokemon extends PApplet {

	InGame ingame;
	LoadData data;
	BattleScene battlescene;
	writeData writedata;

	public static int characterX, characterY;
	public static int wildPokemon;
	public static int partyCounter;

	public static ArrayList<Integer> p_id;
	public static ArrayList<String> p_name;
	public static ArrayList<Integer> p_TOThp;
	public static ArrayList<Integer> p_ACThp;
	public static ArrayList<Integer> p_attack;
	public static ArrayList<Integer> p_defense;
	public static ArrayList<Integer> p_speed;
	public static ArrayList<Integer> p_special;
	public static ArrayList<Integer> p_total;

	public static ArrayList<String> party_name;
	public static ArrayList<Integer> party_TOThp;
	public static ArrayList<Integer> party_ACThp;
	public static ArrayList<Integer> party_attack;
	public static ArrayList<Integer> party_defense;
	public static ArrayList<Integer> party_speed;
	public static ArrayList<Integer> party_special;
	public static ArrayList<Integer> party_total;
	public static ArrayList<Integer> party_id;

	public static int opt;
	public static boolean walkingView;
	public static boolean battleView;

	public static void main(String args[]) {
		PApplet.main(new String[] { "--present", "Pokemon" });
	}

	public void settings() {
		size(1200, 700);
	}

	public void setup() {
		walkingView = false;
		battleView = true;
		opt = 0;
		partyCounter = 0;
		mouseX = 0;
		mouseY = 0;
		ingame = new InGame(this);
		data = new LoadData();
		writedata = new writeData();
		battlescene = new BattleScene(this);
		data.loadParty();
		data.loadPokeArea();
	}

	public void draw() {

		if (walkingView == true) {
			battleView = false;
			ingame.displayMap();
			ingame.displayCharacter();
			ingame.keyPressed();
		}

		if (battleView == true) {
			walkingView = false;
			battlescene.defaultDraw();
			if (opt == 0) {
				// background(255,0,0);
				battlescene.menu1();
			}
			if (opt == 1) {
				battlescene.menu1();
				battlescene.menu2();
			}
			if (opt == 2) {
				battlescene.partyMenu();
			}
			if (opt == 3) {
				battlescene.throwBall();
				writedata.addToParty();
				walkingView = true;
			}
			if (opt == 4) {
				walkingView = true;
			}
		}
	}
}