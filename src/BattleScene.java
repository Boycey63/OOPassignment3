import processing.core.*;

public class BattleScene {
	static Pokemon p5;
	static float Rectangle1X;
	static float Rectangle1Y;
	static float defaultRectangleX;
	static float defaultRectangleY;
	static float Rectangle1W;
	static float Rectangle1H;
	static float defaultRectangleW;
	static float defaultRectangleH;
	public static int wildPokemon;
	public static int wildTotHP, wildActHP, wildAttack, wildDefense, wildSpeed, wildSpecial;
	public static int wildXpNextLvl, wildTOTXp, wildLvL, wildBaseXP;
	public static int wildHPIV, wildAttackIV, wildDefenseIV, wildSpeedIV, wildSpecialIV;
	public static int wildHPEV, wildAttackEV, wildDefenseEV, wildSpeedEV, wildSpecialEV;
	public static int move_pp1, move_attPower1, move_pp2, move_attPower2;
	public static int move_pp3, move_attPower3, move_pp4, move_attPower4;
	public static String move_name1, move_name2, move_name3, move_name4;
	public static boolean BattleWon, BattleLost, BattleCaught, statType, LeveLup, UserTurn, FoeTurn;
	static float textX1, textX2, textY1, textY2;
	static float choicePosX, choicePosY;
	public static double partyHPEV, partyAttackEV, partyDefenseEV, partySpeedEV, partySpecialEV;
	public static int XpGiven, movePPUsed, moveattUsed;
	public static int ToTxp, CuRxp, NexTxp, Level;
	public static int userTotHP, userActHP, userAttack, userDefense, userSpeed, userSpecial, userACThp;
	public static int FoeMoveAtt, lowWildLvl, maxWildLvl;
	boolean stop, GameOver;
	String move = " ";

	static PImage background;
	String moveNameUsed;
	double damage;

	BattleScene(Pokemon _p5) {
		p5 = _p5;
		BattleWon = BattleLost = BattleCaught = statType = LeveLup = FoeTurn = GameOver = false;
		UserTurn = true;
		stop = false;
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
		lowWildLvl = 2;
		maxWildLvl = 4;
	}

	void menu1() {
		Graphics.DrawBattleMenu1();
		keyPressed();

		// When in main battle menu, trigger these options
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
			InGame.swtch = 0;
		}

		// Option 1
		if (p5.key == p5.ENTER && choicePosX == textX1 - 15 && choicePosY == textY1 - 12) {
			if (p5.keyPressed == true && InGame.swtch == 0) {
				InGame.swtch = 1;
				p5.key = 'm';
				p5.keyPressed = false;
			}
			if (p5.keyPressed == true && InGame.swtch == 1) {
				moveNameUsed = LoadData.name_move1.get(0);
				moveattUsed = LoadData.attPower_move1.get(0);
				movePPUsed = LoadData.PP_move1.get(0);
				DamageDone();
				choicePosX = textX1 - 15;
				choicePosY = textY1 - 12;
				FoeTurn = true;
				p5.key = 'm';
				InGame.swtch = 0;
				UserTurn = false;
				p5.keyPressed = false;
			}
		}
		// Option 2
		if (p5.key == p5.ENTER && choicePosX == textX2 - 15 && choicePosY == textY1 - 12) {
			if (p5.keyPressed == true && InGame.swtch == 0) {
				Graphics.DrawPartyMenu();
				p5.key = 'm';
				p5.keyPressed = false;
			}
			if (p5.keyPressed == true && InGame.swtch == 1) {
				moveNameUsed = LoadData.name_move2.get(0);
				moveattUsed = LoadData.attPower_move2.get(0);
				movePPUsed = LoadData.PP_move2.get(0);
				DamageDone();
				choicePosX = textX1 - 15;
				choicePosY = textY1 - 12;
				FoeTurn = true;
				p5.key = 'm';
				InGame.swtch = 0;
				p5.keyPressed = false;
			}
		}
		// Option 3
		if (p5.key == p5.ENTER && choicePosX == textX1 - 15 && choicePosY == textY2 - 12) {
			if (p5.keyPressed == true && InGame.swtch == 0) {
				choicePosX = textX1 - 15;
				choicePosY = textY1 - 12;
				BattleCaught = true;
				writeData.updateParty();
				LoadData.loadParty();
				InGame.resetTimer = true;
				Pokemon.walkingView = true;
				p5.key = 'm';
				p5.keyPressed = false;
			}
			if (p5.keyPressed == true && InGame.swtch == 1) {
				moveNameUsed = LoadData.name_move3.get(0);
				moveattUsed = LoadData.attPower_move3.get(0);
				movePPUsed = LoadData.PP_move3.get(0);
				DamageDone();
				choicePosX = textX1 - 15;
				choicePosY = textY1 - 12;
				FoeTurn = true;
				p5.key = 'm';
				InGame.swtch = 0;
				p5.keyPressed = false;
			}
		}
		// Option 4
		if (p5.key == p5.ENTER && choicePosX == textX2 - 15 && choicePosY == textY2 - 12) {
			if (p5.keyPressed == true && InGame.swtch == 0) {
				choicePosX = textX1 - 15;
				choicePosY = textY1 - 12;
				Pokemon.walkingView = true;
				InGame.resetTimer = true;
				p5.key = 'm';
				p5.keyPressed = false;
			}
			if (p5.keyPressed == true && InGame.swtch == 1) {
				moveNameUsed = LoadData.name_move4.get(0);
				moveattUsed = LoadData.attPower_move4.get(0);
				movePPUsed = LoadData.PP_move4.get(0);
				DamageDone();
				choicePosX = textX1 - 15;
				choicePosY = textY1 - 12;
				FoeTurn = true;
				p5.key = 'm';
				InGame.swtch = 0;
				p5.keyPressed = false;
			}
		}
	}

	void runBattleScene() {
		boolean start = true;

		LoadData.loadParty();
		Graphics.DrawDefaultBattleMenu();

		if (start == true) {
			BattleCaught = false;
			GameOver = false;
			UserTurn = true;
			start = false;
		}

		if (UserTurn == true && GameOver == false) {
			FoeTurn = false;
			runUserTurn();
		}

		if (FoeTurn == true && GameOver == false) {
			UserTurn = false;
			System.out.println(UserTurn);
			RunFoeTurn();
			System.out.println(UserTurn);
			p5.text(LoadData.areaP_name.get(wildPokemon) + " used " + move, 40, (Rectangle1Y + (Rectangle1H / 2)));
			System.out.println(FoeTurn);
			System.out.println(UserTurn);
		}
	}

	void addEVsXP() {
		BattleWon = true;
		partyHPEV = LoadData.party_hpEV.get(0);
		partyAttackEV = LoadData.party_attackEV.get(0);
		partyDefenseEV = LoadData.party_defenseEV.get(0);
		partySpeedEV = LoadData.party_speedEV.get(0);
		partySpecialEV = LoadData.party_specialEV.get(0);
		partyHPEV = calGivingEV(wildTotHP, partyHPEV);
		partyAttackEV = calGivingEV(wildAttack, partyAttackEV);
		partyDefenseEV = calGivingEV(wildDefense, partyDefenseEV);
		partySpeedEV = calGivingEV(wildSpeed, partySpeedEV);
		partySpecialEV = calGivingEV(wildSpecial, partySpecialEV);

		XpGiven = p5.floor((float) calEarnedXP(XpGiven, wildBaseXP, wildLvL));
		CuRxp = CuRxp + XpGiven;
		writeData.updateParty();
	}

	void attackMenu() {
		Graphics.DrawAttackMenu();

		keyPressed();
	}

	void runUserTurn() {
		UserTurn = true;
		FoeTurn = false;
		if (InGame.swtch == 0 && FoeTurn == false) {
			menu1();
		}
		if (InGame.swtch == 1 && FoeTurn == false) {
			attackMenu();
		}

		if (wildActHP <= 0) {
			GameOver = true;
			userTotHP = LoadData.party_TOThp.get(0);
			userActHP = LoadData.party_ACThp.get(0);
			userAttack = LoadData.party_attack.get(0);
			userDefense = LoadData.party_defense.get(0);
			userSpeed = LoadData.party_speed.get(0);
			userSpecial = LoadData.party_special.get(0);
			NexTxp = LoadData.party_xpNextLvl.get(0);
			ToTxp = LoadData.party_TOTxp.get(0);
			CuRxp = LoadData.party_CurXP.get(0);
			Level = LoadData.party_lvl.get(0);

			addEVsXP();

			// When current xp reaches next level xp level up
			if (NexTxp <= (ToTxp + CuRxp)) {
				PokeLevelUP();
			}

			UserTurn = false;
			Pokemon.walkingView = true;
			p5.key = 'm';
		}
	}

	void RunFoeTurn() {
		stop = false;
		FoeTurn = true;
		UserTurn = false;
		int var = p5.floor(p5.random(1, 4));

		if (var == 1) {
			move = move_name1;
			FoeMoveAtt = move_attPower1;
		}
		if (var == 2) {
			move = move_name2;
			FoeMoveAtt = move_attPower2;
		}
		if (var == 3) {
			move = move_name3;
			FoeMoveAtt = move_attPower3;
		}
		if (var == 4) {
			move = move_name4;
			FoeMoveAtt = move_attPower4;
		}

		if (stop == false) {
			DamageDone();
			writeData.updateParty();
			stop = true;
		}
	}

	void DamageDone() {
		// damage = (((2xLEVEL+10)/250) x (ATTACK/DEFENSE) x BASE + 2) x
		// Modifier
		// Base is the base power of the attack move
		if (FoeTurn == true) {
			float part1 = ((2 * wildLvL) + 10);
			float part2 = wildAttack;
			damage = (((part1 / 250) * (part2 / LoadData.party_defense.get(0))) * FoeMoveAtt) + 2;
			userACThp = LoadData.party_ACThp.get(0) - (int) (damage);
			damage = 0;
		}

		if (UserTurn == true) {
			float part1 = ((2 * LoadData.party_lvl.get(0)) + 10);
			float part2 = LoadData.party_attack.get(0);
			damage = (((part1 / 250) * (part2 / wildDefense)) * moveattUsed) + 2;
			wildActHP = wildActHP - (int) (damage);
			damage = 0;
		}
	}

	static void intWildPokemon() {
		// Randomly selects pokemon based on the possible pokemon in area
		// Set base stats of the pokemon
		wildPokemon = p5.floor(p5.random(0, LoadData.areaCounter));
		wildHPIV = p5.floor(p5.random(0, 15));
		wildAttackIV = p5.floor(p5.random(0, 15));
		wildDefenseIV = p5.floor(p5.random(0, 15));
		wildSpeedIV = p5.floor(p5.random(0, 15));
		wildSpecialIV = p5.floor(p5.random(0, 15));
		wildHPEV = wildAttackEV = wildDefenseEV = wildSpeedEV = wildSpecialEV = 0;

		wildLvL = p5.floor(p5.random(lowWildLvl, maxWildLvl));
		wildBaseXP = (LoadData.areaP_BaseXP.get(wildPokemon));
		XpGiven = 0;

		wildActHP = LoadData.areaP_ACThp.get(wildPokemon);
		statType = true;
		wildActHP = calStats(wildActHP, wildActHP, wildHPIV, wildHPEV, wildLvL);
		wildTotHP = wildActHP;
		statType = false;
		wildAttack = LoadData.areaP_attack.get(wildPokemon);
		wildAttack = calStats(wildAttack, wildAttack, wildAttackIV, wildAttackEV, wildLvL);
		wildDefense = LoadData.areaP_defense.get(wildPokemon);
		wildDefense = calStats(wildDefense, wildDefense, wildDefenseIV, wildDefenseEV, wildLvL);
		wildSpeed = LoadData.areaP_speed.get(wildPokemon);
		wildSpeed = calStats(wildSpeed, wildSpeed, wildSpeedIV, wildSpeedEV, wildLvL);
		wildSpecial = LoadData.areaP_special.get(wildPokemon);
		wildSpecial = calStats(wildSpecial, wildSpecial, wildSpecialIV, wildSpecialEV, wildLvL);

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

	static double calGivingEV(int wildVar1, double userVar2) {
		userVar2 = userVar2 + (Math.sqrt(wildVar1)) / 4;
		return userVar2;
	}

	static double calEarnedXP(int EarnedXp, int baseXp, int Level) {
		EarnedXp = (baseXp * Level) / 7;
		return EarnedXp;
	}

	// Calculates stats based on level of Pokemon
	static int calStats(int stat, int Base, int IV, double EV, int Level) {
		int step1, step2, step3;
		float step4;
		step1 = Base + IV;
		step2 = p5.floor(step1 * 2);
		step3 = (step2 + p5.floor((float) EV)) * Level;
		step4 = step3 / 100;

		// If stats isn't hp
		if (statType == false) {
			stat = p5.floor(step4 + 5);
		}
		// If stat is hp
		if (statType == true) {
			stat = p5.floor(step4 + Level + 10);
		}
		return stat;
	}

	static void PokeLevelUP() {
		BattleWon = LeveLup = true;
		Level = Level + 1;
		// Get difference and sets current as difference
		CuRxp = ((ToTxp + CuRxp) - NexTxp);
		NexTxp = Level * Level * Level;
		ToTxp = Level * Level;

		LoadData.loadStartPokemon();

		statType = true;
		userActHP = calStats(userTotHP, userTotHP, LoadData.party_hpIV.get(MainMenu.chosenID),
				LoadData.party_hpEV.get(0), Level);
		statType = false;
		userTotHP = userActHP;
		userAttack = calStats(userAttack, LoadData.start_attack.get(MainMenu.chosenID), LoadData.party_attackIV.get(0),
				LoadData.party_attackEV.get(0), Level);
		userDefense = calStats(userDefense, LoadData.start_defense.get(MainMenu.chosenID),
				LoadData.party_defenseIV.get(0), LoadData.party_defenseEV.get(0), Level);
		userSpeed = calStats(userSpeed, LoadData.start_speed.get(MainMenu.chosenID), LoadData.party_speedIV.get(0),
				LoadData.party_speedEV.get(0), Level);
		userSpecial = calStats(userSpecial, LoadData.start_special.get(MainMenu.chosenID),
				LoadData.party_specialIV.get(0), LoadData.party_specialEV.get(0), Level);

		lowWildLvl++;
		maxWildLvl++;
		writeData.updateParty();
	}
}