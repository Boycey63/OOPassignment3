import processing.core.*;

public class BattleScene {
	static Pokemon p5;
	float Rectangle1X, Rectangle1Y, defaultRectangleX, defaultRectangleY;
	float Rectangle1W, Rectangle1H, defaultRectangleW, defaultRectangleH;
	public static int seconds, time, setTime;
	public static int wildPokemon;
	public static int wildTotHP, wildActHP, wildAttack, wildDefense, wildSpeed, wildSpecial, wildXpNextLvl, wildTOTXp,
			wildLvL, wildHPIV, wildAttackIV, wildDefenseIV, wildSpeedIV, wildSpecialIV;
	public static int move_pp1, move_attPower1, move_pp2, move_attPower2, move_pp3, move_attPower3, move_pp4,
			move_attPower4;
	public static String move_name1, move_name2, move_name3, move_name4;
	public static boolean resetTimer;
	public static int swtch;
	PImage background;
	float textX1, textX2, textY1, textY2, choicePosX, choicePosY;
	String moveNameUsed;
	int movePPUsed, moveattUsed;
	double damage;

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
		p5.text("Lvl: " + LoadData.party_lvl.get(0), 620, 480);
		p5.text("HP: " + LoadData.party_ACThp.get(0), 620, 510);
		// Wild Pokemon
		p5.textSize(30);
		p5.text(LoadData.areaP_name.get(wildPokemon), 40, 40);
		p5.textSize(25);
		p5.text("Lvl: " + wildLvL, 40, 70);
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
		p5.text("Press enter to chose an option: ", 40, (Rectangle1Y + (Rectangle1H / 2)));

		p5.textSize(20);
		p5.fill(0);

		p5.text("Fight", textX1, textY1);
		p5.text("Catch", textX1, textY2);
		p5.text("Pokemon", textX2, textY1);
		p5.text("Run", textX2, textY2);

		keyPressed();

		p5.rect(choicePosX, choicePosY, 10, 10);

		// When in main battle menu, trigger these options
		if (swtch == 0) {
			// Option 1
			if (p5.key == p5.ENTER && choicePosX == textX1 - 15 && choicePosY == textY1 - 12) {
				if (p5.keyPressed == true) {
					swtch = 1;
					p5.key = 'm';
				}
			}
			// Option 2
			if (p5.key == p5.ENTER && choicePosX == textX2 - 15 && choicePosY == textY1 - 12) {
				if (p5.keyPressed == true) {
					partyMenu();
					p5.key = 'm';
				}
			}
			// Option 3
			if (p5.key == p5.ENTER && choicePosX == textX1 - 15 && choicePosY == textY2 - 12) {
				if (p5.keyPressed == true) {
					choicePosX = textX1 - 15;
					choicePosY = textY1 - 12;
					throwBall();
					writeData.addToParty();
					LoadData.loadParty();
					BattleScene.resetTimer = true;
					Pokemon.walkingView = true;
					p5.key = 'm';
				}
			}
			// Option 4
			if (p5.key == p5.ENTER && choicePosX == textX2 - 15 && choicePosY == textY2 - 12) {
				if (p5.keyPressed == true) {
					choicePosX = textX1 - 15;
					choicePosY = textY1 - 12;
					Pokemon.walkingView = true;
					resetTimer = true;
					p5.key = 'm';
				}
			}
		}
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

		if (p5.key == p5.BACKSPACE) {
			p5.key = 'm';
			swtch = 0;
		}
	}

	void runBattleScene() {
		LoadData.loadParty();
		defaultDraw();
		// System.out.println(wildDefense);
		if (swtch == 0) {
			menu1();
		}
		if (swtch == 1) {
			attackMenu();
		}

		if (wildActHP <= 0) {
			Pokemon.walkingView = true;
			p5.key = 'm';
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

		p5.text("Press enter to chose a move: ", 40, (Rectangle1Y + (Rectangle1H / 2)) - 20);
		p5.text("Press backspace to return to option menu: ", 40, (Rectangle1Y + (Rectangle1H / 2)) + 20);

		p5.textSize(20);
		p5.fill(0);
		p5.text(LoadData.name_move1.get(0), textX1, textY1);
		p5.text(LoadData.name_move3.get(0), textX1, textY2);
		p5.text(LoadData.name_move2.get(0), textX2, textY1);
		p5.text(LoadData.name_move4.get(0), textX2, textY2);

		keyPressed();

		if (swtch == 1) {
			if (p5.key == p5.ENTER && choicePosX == textX1 - 15 && choicePosY == textY1 - 12) {
				if (p5.keyPressed == true) {
					moveNameUsed = LoadData.name_move1.get(0);
					moveattUsed = LoadData.attPower_move1.get(0);
					movePPUsed = LoadData.PP_move1.get(0);
					userDamageDone();
					choicePosX = textX1 - 15;
					choicePosY = textY1 - 12;
					p5.key = 'm';
					swtch = 0;
				}
			}
			// Option 2
			if (p5.key == p5.ENTER && choicePosX == textX2 - 15 && choicePosY == textY1 - 12) {
				if (p5.keyPressed == true) {
					moveNameUsed = LoadData.name_move2.get(0);
					moveattUsed = LoadData.attPower_move2.get(0);
					movePPUsed = LoadData.PP_move2.get(0);
					userDamageDone();
					choicePosX = textX1 - 15;
					choicePosY = textY1 - 12;
					p5.key = 'm';
					swtch = 0;
				}
			}
			// Option 3
			if (p5.key == p5.ENTER && choicePosX == textX1 - 15 && choicePosY == textY2 - 12) {
				if (p5.keyPressed == true) {
					moveNameUsed = LoadData.name_move3.get(0);
					moveattUsed = LoadData.attPower_move3.get(0);
					movePPUsed = LoadData.PP_move3.get(0);
					userDamageDone();
					choicePosX = textX1 - 15;
					choicePosY = textY1 - 12;
					p5.key = 'm';
					swtch = 0;
				}
			}
			// Option 4
			if (p5.key == p5.ENTER && choicePosX == textX2 - 15 && choicePosY == textY2 - 12) {
				if (p5.keyPressed == true) {
					moveNameUsed = LoadData.name_move4.get(0);
					moveattUsed = LoadData.attPower_move4.get(0);
					movePPUsed = LoadData.PP_move4.get(0);
					userDamageDone();
					choicePosX = textX1 - 15;
					choicePosY = textY1 - 12;
					p5.key = 'm';
					swtch = 0;
				}
			}
		}
		p5.rect(choicePosX, choicePosY, 10, 10);
	}

	void userDamageDone() {
		// damage = (((2xLEVEL+10)/250) x (ATTACK/DEFENSE) x BASE + 2) x
		// Modifier
		// Base is the base power of the attack move
		float part1 = ((2 * LoadData.party_lvl.get(0)) + 10);
		float part2 = LoadData.party_attack.get(0);
		damage = (((part1 / 250) * (part2 / wildDefense)) * moveattUsed) + 2;
		wildActHP = wildActHP - (int) (damage);
		damage = 0;
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
			intWildPokemon();
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

	static void intWildPokemon() {
		// Randomly selects pokemon based on the possible pokemon in area
		// Set base stats of the pokemon
		wildPokemon = p5.floor(p5.random(0, LoadData.areaCounter));
		// wildHPIV, wildAttackIV, wildDefenseIV, wildSpeedIV, wildSpecialIV
		wildHPIV = p5.floor(p5.random(0, 15));
		wildAttackIV = p5.floor(p5.random(0, 15));
		wildDefenseIV = p5.floor(p5.random(0, 15));
		wildSpeedIV = p5.floor(p5.random(0, 15));
		wildSpecialIV = p5.floor(p5.random(0, 15));

		wildActHP = (LoadData.areaP_ACThp.get(wildPokemon) + wildHPIV);
		wildTotHP = wildActHP;
		wildAttack = (LoadData.areaP_attack.get(wildPokemon) + wildAttackIV);
		wildDefense = (LoadData.areaP_defense.get(wildPokemon) + wildDefenseIV);
		wildSpeed = (LoadData.areaP_speed.get(wildPokemon) + wildSpeedIV);
		wildSpecial = (LoadData.areaP_special.get(wildPokemon) + wildSpecialIV);
		wildLvL = p5.floor(p5.random(3, 6));
		
		wildTOTXp = p5.floor(wildLvL * wildLvL);
		wildXpNextLvl = p5.floor(wildLvL * wildLvL * wildLvL);
		int var = p5.floor(p5.random(0, 9));
		move_name1 = LoadData.move_name.get(var);
		move_pp1 = LoadData.move_PP.get(var);
		move_attPower1 = LoadData.move_attPower.get(var);
		var = p5.floor(p5.random(0, 9));
		move_name2 = LoadData.move_name.get(var);
		move_pp2 = LoadData.move_PP.get(var);
		move_attPower2 = LoadData.move_attPower.get(var);
		var = p5.floor(p5.random(0, 9));
		move_name3 = LoadData.move_name.get(var);
		move_pp3 = LoadData.move_PP.get(var);
		move_attPower3 = LoadData.move_attPower.get(var);
		var = p5.floor(p5.random(0, 9));
		move_name4 = LoadData.move_name.get(var);
		move_pp4 = LoadData.move_PP.get(var);
		move_attPower4 = LoadData.move_attPower.get(var);
	}
}