public class BattleScene {
	static Pokemon p5;
	float Rectangle1X, Rectangle1Y, defaultRectangleX, defaultRectangleY;
	float Rectangle1W, Rectangle1H, defaultRectangleW, defaultRectangleH;
	public static int seconds, time, setTime;
	public static int wildPokemon;
	public static int wildTotHP, wildActHP, wildAttack, wildDefense, wildSpeed, wildSpecial, wildTotal;
	public static boolean resetTimer;
	public static int opt;
	int poke_hp;
	String poke;

	BattleScene(Pokemon _p5) {
		p5 = _p5;
		resetTimer = true;
		time = seconds = opt = 0;
		defaultRectangleH = 170;
		defaultRectangleX = 10;
		defaultRectangleW = p5.width - 20;
		defaultRectangleY = p5.height - (defaultRectangleH + 10);
	}

	void defaultDraw() {
		p5.background(180);
		p5.textSize(30);
		p5.stroke(0);
		p5.fill(0);
		// User Pokemon
		p5.text(LoadData.party_name.get(0), 620, 450);
		// Wild Pokemon
		p5.text(LoadData.p_name.get(wildPokemon), 40, 40);
		p5.textSize(25);
		p5.text("Lvl: " + " variable", 620, 480);
		p5.text("HP: " + poke_hp, 620, 510);
		p5.text("Lvl: " + " variable", 40, 70);
		p5.text("HP: " + " variable", 40, 100);
		p5.stroke(255, 255, 255);
		p5.fill(255, 255, 255);
		p5.rect(defaultRectangleX, defaultRectangleY, defaultRectangleW, defaultRectangleH, 20, 20, 20, 20);
	}

	void menu1() {
		Rectangle1H = 150;
		Rectangle1W = 600;
		Rectangle1X = p5.width - (Rectangle1W + 20);
		Rectangle1Y = p5.height - (Rectangle1H + 20);

		// Menu rectangle
		p5.fill(150, 150, 150);
		p5.stroke(255, 0, 0);
		p5.rect(Rectangle1X, Rectangle1Y, Rectangle1W, Rectangle1H, 20, 20, 20, 20);
		p5.stroke(255, 0, 0);
		p5.line(Rectangle1X + (Rectangle1W / 2), Rectangle1Y, Rectangle1X + (Rectangle1W / 2), p5.height - 20);
		p5.line(Rectangle1X, Rectangle1Y + (Rectangle1H / 2), p5.width - 20, Rectangle1Y + (Rectangle1H / 2));

		p5.textSize(20);
		p5.fill(0);
		if (opt == 0) {
			p5.text("Fight", Rectangle1X + (Rectangle1W / 4) - 60, Rectangle1Y + (Rectangle1H / 4));
		}
		if (opt == 1) {
			p5.text("Back", Rectangle1X + (Rectangle1W / 4) - 60, Rectangle1Y + (Rectangle1H / 4));
		}
		p5.text("Pokemon", Rectangle1X + (Rectangle1W * 3 / 4) - 60, Rectangle1Y + (Rectangle1H / 4));
		p5.text("Run", Rectangle1X + (Rectangle1W * 3 / 4) - 60, Rectangle1Y + (Rectangle1H * 3 / 4));

		if (p5.mouseX > (Rectangle1X) && p5.mouseX < (Rectangle1X + (Rectangle1W / 2)) && p5.mouseY > (Rectangle1Y)
				&& p5.mouseY < (Rectangle1Y + Rectangle1H)) {
			// if(mousePressed)
			if (p5.mousePressed == true && opt == 0) {
				opt = 1;
			}
			if (p5.mousePressed == true && opt == 1) {
				opt = 0;
			}
		}
		if (p5.mouseX > (Rectangle1X + (Rectangle1W / 2)) && p5.mouseX < (Rectangle1X + Rectangle1W)
				&& p5.mouseY > (Rectangle1Y) && p5.mouseY < (Rectangle1Y + Rectangle1H)) {
			if (p5.mousePressed == true) {
				opt = 2;
			}
		}

		if (p5.mouseX > Rectangle1X && p5.mouseX < (Rectangle1X + (Rectangle1W / 2))
				&& p5.mouseY > (Rectangle1Y + (Rectangle1H / 2)) && p5.mouseY < (Rectangle1Y + Rectangle1H)) {
			if (p5.mousePressed == true) {
				opt = 3;
			}
		}
		if (p5.mouseX > (Rectangle1X + (Rectangle1W / 2)) && p5.mouseX < (Rectangle1X + Rectangle1W)
				&& p5.mouseY > (Rectangle1Y + (Rectangle1H / 2)) && p5.mouseY < (Rectangle1Y + Rectangle1H)) {
			if (p5.mousePressed == true) {
				opt = 4;
			}
		}
	}

	void attackMenu() {
		Rectangle1H = 120;
		Rectangle1W = 350;
		Rectangle1X = p5.width / 7 + 59;
		Rectangle1Y = p5.height - (Rectangle1H + 35);

		// Menu rectangle
		p5.fill(150, 150, 150);
		p5.stroke(255, 0, 0);
		p5.rect(Rectangle1X, Rectangle1Y, Rectangle1W, Rectangle1H, 20, 0, 0, 20);
		p5.stroke(255, 0, 0);
		p5.line(Rectangle1X + (Rectangle1W / 2), Rectangle1Y, Rectangle1X + (Rectangle1W / 2), p5.height - 35);
		p5.line(Rectangle1X, Rectangle1Y + (Rectangle1H / 2), Rectangle1X + (Rectangle1W),
				Rectangle1Y + (Rectangle1H / 2));

		p5.fill(0, 0, 0);
		p5.text("Move 1", Rectangle1X + (Rectangle1W / 4 - 40), Rectangle1Y + (Rectangle1H / 4));
		p5.text("Move 2", Rectangle1X + (Rectangle1W * 3 / 4 - 40), Rectangle1Y + (Rectangle1H / 4));
		p5.text("Move 3", Rectangle1X + (Rectangle1W / 4 - 40), Rectangle1Y + (Rectangle1H * 3 / 4));
		p5.text("Move 4", Rectangle1X + (Rectangle1W * 3 / 4) - 40, Rectangle1Y + (Rectangle1H * 3 / 4));
	}

	void partyMenu() {

	}

	void throwBall() {

	}

	public static void startTimer() {
		// Resets the timer, battle option and changes the next wild pokemon
		if (resetTimer == true) {
			seconds = time = 0;
			opt = 0;
			// Randomly selects pokemon based on the possible pokemon in area
			// Set base stats of the pokemon
			wildPokemon = p5.floor(p5.random(0, LoadData.areaCounter));
			System.out.println(LoadData.p_name.get(wildPokemon));
			wildActHP = (LoadData.p_ACThp.get(BattleScene.wildPokemon) + p5.floor(p5.random(1, 15)));
			wildTotHP = wildActHP;
			wildAttack = (LoadData.p_attack.get(BattleScene.wildPokemon) + p5.floor(p5.random(1, 15)));
			wildDefense = (LoadData.p_defense.get(BattleScene.wildPokemon) + p5.floor(p5.random(1, 15)));
			wildSpeed = (LoadData.p_speed.get(BattleScene.wildPokemon) + p5.floor(p5.random(1, 15)));
			wildSpecial = (LoadData.p_special.get(BattleScene.wildPokemon) + p5.floor(p5.random(1, 15)));
			wildTotal = wildTotHP + wildAttack + wildDefense + wildSpeed + wildSpecial;
			// Randomly set the time till the next battle
			setTime = p5.floor(p5.random(1, 4));
			resetTimer = false;
		}
		seconds++;

		// Divides the default amount of frames by 60 to find seconds
		if (seconds == 60) {
			seconds = seconds / 60;
			time++;
		}

		// Once time reaches the next battle time
		if (time == setTime) {
			Pokemon.battleView = true;
			Pokemon.walkingView = false;
			resetTimer = true;
		}
	}

	void runBattleScene() {
		defaultDraw();

		// Displays default battle menu
		if (opt == 0) {
			menu1();
		}
		// Opt variable changes the Battle option
		// Displays attack menu
		if (opt == 1) {
			menu1();
			attackMenu();
		}

		// Displays party menu
		if (opt == 2) {
			partyMenu();
		}

		// Possibly catches pokemon and changes to walk mode
		if (opt == 3) {
			throwBall();
			writeData.addToParty();
			LoadData.loadParty();
			BattleScene.resetTimer = true;
			Pokemon.walkingView = true;
		}
		// Possibly runs from pokemon
		if (opt == 4) {
			Pokemon.walkingView = true;
			resetTimer = true;
		}
	}
}