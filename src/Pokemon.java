import java.util.ArrayList;
import processing.core.*;

public class Pokemon extends PApplet {
	
	InGame ingame;
	LoadData data;
	BattleScene battlescene;
	
	public static int characterX, characterY;
	public static ArrayList pokemon = new ArrayList();
	public static ArrayList <String> p_name = new ArrayList<String>();
	public static ArrayList p_hp = new ArrayList();
	public static ArrayList p_attack = new ArrayList();
	public static ArrayList p_defense = new ArrayList();
	public static ArrayList p_speed = new ArrayList();
	public static ArrayList p_special = new ArrayList();
	public static ArrayList p_total = new ArrayList();
	public static ArrayList p_average = new ArrayList();
	public static ArrayList p_id = new ArrayList();
	
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
			battlescene.option1();
		}
	}
}