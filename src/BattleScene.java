import processing.core.*;

public class BattleScene {
	static Pokemon p5;
	float Rectangle1X, Rectangle1Y, defaultRectangleX, defaultRectangleY;
	float Rectangle1W, Rectangle1H, defaultRectangleW, defaultRectangleH;
	public static int seconds, time, setTime;
	public static int wildPokemon;
	public static int wildTotHP, wildActHP, wildAttack, wildDefense, wildSpeed, wildSpecial, wildTotal, wildXp;
	public static boolean resetTimer;
	public static int swtch;
	String poke;
	PImage background;
	float textX1, textX2, textY1, textY2, choicePosX, choicePosY;

	BattleScene(Pokemon _p5) {
		p5 = _p5;
		resetTimer = true;
		swtch = 0;
		time = seconds = 0;
		defaultRectangleH = 170;
		defaultRectangleX = 0;
		defaultRectangleW = p5.width;
		defaultRectangleY = p5.height - (defaultRectangleH);
		background = p5.loadImage("BattleArena.png");
		Rectangle1H = 150;
		Rectangle1W = 600;
		Rectangle1X = p5.width - (Rectangle1W + 10);
		Rectangle1Y = p5.height - (Rectangle1H + 10);
		textX1 = Rectangle1X + (Rectangle1W / 4) - 60;
		textY1 = Rectangle1Y + (Rectangle1H / 4);
		textX2 = Rectangle1X + (Rectangle1W * 3 / 4) - 60;
		textY2 = Rectangle1Y + (Rectangle1H * 3 / 4);
		choicePosX = textX1 - 15;
		choicePosY = textY1 - 12;
	}

	void defaultDraw() {
		p5.background(180);
		p5.stroke(0);
		p5.fill(0);
		p5.image(background, 0, 0);
		// User Pokemon
		p5.textSize(30);
		p5.text(LoadData.party_name.get(0), 620, 450);
		p5.textSize(25);
		p5.text("Lvl: " + " 1", 620, 480);
		p5.text("HP: " + LoadData.party_ACThp.get(0), 620, 510);
		// Wild Pokemon
		p5.textSize(30);
		p5.text(LoadData.p_name.get(wildPokemon), 40, 40);
		p5.textSize(25);
		p5.text("Lvl: " + " 1", 40, 70);
		p5.text("HP: " + wildActHP, 40, 100);
		// Draw rectangle
		p5.stroke(255, 255, 255);
		p5.fill(100, 100, 100);
		p5.rect(defaultRectangleX, defaultRectangleY, defaultRectangleW, defaultRectangleH, 20, 20, 0, 0);
	}

	void menu1() {
		Rectangle1H = 150;
		Rectangle1W = 600;
		Rectangle1X = p5.width - (Rectangle1W + 10);
		Rectangle1Y = p5.height - (Rectangle1H + 10);

		// Menu rectangle
		p5.fill(150, 150, 150);
		p5.stroke(255, 0, 0);
		p5.rect(Rectangle1X, Rectangle1Y, Rectangle1W, Rectangle1H, 20, 20, 20, 20);
		p5.stroke(255, 0, 0);
		p5.line(Rectangle1X + (Rectangle1W / 2), Rectangle1Y, Rectangle1X + (Rectangle1W / 2), p5.height - 10);
		p5.line(Rectangle1X, Rectangle1Y + (Rectangle1H / 2), p5.width - 10, Rectangle1Y + (Rectangle1H / 2));

		// System.out.println(opt);

		p5.textSize(20);
		p5.fill(0);

		p5.text("Fight", textX1, textY1);
		p5.text("Catch", textX1, textY2);
		p5.text("Pokemon", textX2, textY1);
		p5.text("Run", textX2, textY2);

		keyPressed();

		p5.rect(choicePosX, choicePosY, 10, 10);
	}

	void keyPressed() {
		if (p5.key == 'w') {
			choicePosY = textY1 - 12;
			p5.key = 'm';
		}

		if (p5.key == 's') {
			choicePosY = textY2 - 12;
			p5.key = 'm';
		}

		if (p5.key == 'a') {
			choicePosX = textX1 - 15;
			p5.key = 'm';
		}

		if (p5.key == 'd') {
			choicePosX = textX2 - 15;
			p5.key = 'm';
		}
		if (swtch == 0) {
			// Option 1
			if (p5.key == p5.ENTER && choicePosX == textX1 - 15 && choicePosY == textY1 - 12) {
				swtch = 1;
				p5.key = 'm';
			}
			// Option 2
			if (p5.key == p5.ENTER && choicePosX == textX2 - 15 && choicePosY == textY1 - 12) {
				partyMenu();
				p5.key = 'm';
			}
			// Option 3
			if (p5.key == p5.ENTER && choicePosX == textX1 - 15 && choicePosY == textY2 - 12) {
				throwBall();
				writeData.addToParty();
				LoadData.loadParty();
				BattleScene.resetTimer = true;
				Pokemon.walkingView = true;
				p5.key = 'm';
			}
			// Option 4
			if (p5.key == p5.ENTER && choicePosX == textX2 - 15 && choicePosY == textY2 - 12) {
				Pokemon.walkingView = true;
				resetTimer = true;
				p5.key = 'm';
			}
		}
		if (p5.key == p5.BACKSPACE) {
			swtch = 0;
		}
	}

	void runBattleScene() {
		defaultDraw();
		if (swtch == 0) {
			menu1();
		}
		if (swtch == 1) {
			attackMenu();
		}

	}

	void attackMenu() {
		Rectangle1H = 150;
		Rectangle1W = 600;
		Rectangle1X = p5.width - (Rectangle1W + 10);
		Rectangle1Y = p5.height - (Rectangle1H + 10);

		// Menu rectangle
		p5.fill(150, 150, 150);
		p5.stroke(255, 0, 0);
		p5.rect(Rectangle1X, Rectangle1Y, Rectangle1W, Rectangle1H, 20, 20, 20, 20);
		p5.stroke(255, 0, 0);
		p5.line(Rectangle1X + (Rectangle1W / 2), Rectangle1Y, Rectangle1X + (Rectangle1W / 2), p5.height - 10);
		p5.line(Rectangle1X, Rectangle1Y + (Rectangle1H / 2), p5.width - 10, Rectangle1Y + (Rectangle1H / 2));

		// System.out.println(opt);

		p5.textSize(20);
		p5.fill(0);
		p5.text("Move 1", textX1, textY1);
		p5.text("Move 3", textX1, textY2);
		p5.text("Move 2", textX2, textY1);
		p5.text("Move 4", textX2, textY2);

		keyPressed();

		p5.rect(choicePosX, choicePosY, 10, 10);
	}

	void partyMenu() {

	}

	void throwBall() {

	}

	public static void startTimer() {
		// Resets the timer, battle option and changes the next wild pokemon
		if (resetTimer == true) {
			seconds = time = 0;
			swtch = 0;
			// Randomly selects pokemon based on the possible pokemon in area
			// Set base stats of the pokemon
			wildPokemon = p5.floor(p5.random(0, LoadData.areaCounter));
			wildActHP = (LoadData.p_ACThp.get(BattleScene.wildPokemon) + p5.floor(p5.random(1, 15)));
			wildTotHP = wildActHP;
			wildAttack = (LoadData.p_attack.get(BattleScene.wildPokemon) + p5.floor(p5.random(1, 15)));
			wildDefense = (LoadData.p_defense.get(BattleScene.wildPokemon) + p5.floor(p5.random(1, 15)));
			wildSpeed = (LoadData.p_speed.get(BattleScene.wildPokemon) + p5.floor(p5.random(1, 15)));
			wildSpecial = (LoadData.p_special.get(BattleScene.wildPokemon) + p5.floor(p5.random(1, 15)));
			wildTotal = wildTotHP + wildAttack + wildDefense + wildSpeed + wildSpecial;
			wildXp = 0;
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
}