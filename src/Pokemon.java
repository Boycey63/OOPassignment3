import java.util.ArrayList;
import processing.core.*;

public class Pokemon extends PApplet {
	
	InGame ingame;
	LoadData data;
	BattleScene battlescene;
	
	public static int characterX, characterY;
	public static ArrayList pokemon = new ArrayList();
	public static ArrayList <String> p_name = new ArrayList<String>();
	public static ArrayList <Integer>p_hp = new ArrayList<Integer>();
	public static ArrayList <Integer>p_attack = new ArrayList<Integer>();
	public static ArrayList <Integer>p_defense = new ArrayList<Integer>();
	public static ArrayList <Integer>p_speed = new ArrayList<Integer>();
	public static ArrayList <Integer>p_special = new ArrayList<Integer>();
	public static ArrayList <Integer>p_total = new ArrayList<Integer>();
	public static ArrayList <Float>p_average = new ArrayList<Float>();
	public static ArrayList <Integer>p_id = new ArrayList<Integer>();

	public static boolean walkingView;
	public static boolean battleView;
	
	public static void main(String args[]) {
		PApplet.main(new String[] { "--present", "Pokemon" });
	}

	public void settings() {
		size(1200,700);
		walkingView = false;
		battleView = true;
	}

	public void setup() {
		ingame = new InGame(this);
		data = new LoadData(this);
		battlescene = new BattleScene(this);
	}

	public void draw() {
		data.loadfile();
		
		if(walkingView == true){
			battleView = false;
			ingame.displayMap();
			ingame.displayCharacter();
			ingame.keyPressed();
		}
		
		if(battleView == true){
			walkingView = false;
			battlescene.defaultDraw();
			battlescene.option1();
		}
	}
}