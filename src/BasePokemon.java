public class BasePokemon {
	static Pokemon p5;
	//Wild Pokemon Stats + info
	public static int wildID, wildTotHP, wildActHP, wildAttack, wildDefense, wildSpeed, wildSpecial;
	public static int wildXpNextLvl, wildTOTXp, wildLvL, wildBaseXP;
	public static int wildHPIV, wildAttackIV, wildDefenseIV, wildSpeedIV, wildSpecialIV;
	public static int wildHPEV, wildAttackEV, wildDefenseEV, wildSpeedEV, wildSpecialEV;
	public static int move_pp1, move_attPower1, move_pp2, move_attPower2;
	public static int move_pp3, move_attPower3, move_pp4, move_attPower4;
	public static String move_name1, move_name2, move_name3, move_name4;
	public static int FoeMoveAtt, lowWildLvl, maxWildLvl;
	static String WildMove = " ";
	//User Pokemon Stats + info
	public static double partyHPEV, partyAttackEV, partyDefenseEV, partySpeedEV, partySpecialEV;
	public static int userTotHP, userActHP, userAttack, userDefense, userSpeed, userSpecial, userACThp;
	public static int ToTxp, CuRxp, NexTxp, Level;
	public static int XpGiven, movePPUsed, moveattUsed;
	static String moveNameUsed;
	static boolean statType;
	//Starter pokemon Stats + info
	public static int chosenID;
	public static int chosenTotHP, chosenActHP, chosenAttack, chosenDefense, chosenSpeed, chosenSpecial;
	public static int chosenHPIV, chosenAttackIV, chosenDefenseIV, chosenSpeedIV, chosenSpecialIV;
	//Selected pokemon
	public static int tempPoke1, tempPoke2;
	public static int arrayID1, arrayID2;
	public static int choiceCounter;
	public static int[] PartyPos;
	
	
	BasePokemon(Pokemon _p5) {
		p5 = _p5;
		tempPoke1 = tempPoke2 = arrayID1 = arrayID2 = 0;
		chosenID = choiceCounter = 0;
		statType = false;
		lowWildLvl = 2;
		maxWildLvl = 4;
		PartyPos = new int[6];
		PartyPos[0] = 0;
		PartyPos[1] = 1;
		PartyPos[2] = 2;
		PartyPos[3] = 3;
		PartyPos[4] = 4;
		PartyPos[5] = 5;
	}

	//When run sets current Pokemon stats into different variables
	static void LoadUserStats() {
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
	}
	
	//When run... sets which pokemon are going to be swapped in the array
	static void selectSwapPoke(int slot){
		BasePokemon.choiceCounter++;
		if(BasePokemon.choiceCounter == 1){
			BasePokemon.tempPoke1 = BasePokemon.PartyPos[slot];
		}
		if(BasePokemon.choiceCounter == 2){
			BasePokemon.tempPoke2 = BasePokemon.PartyPos[slot];
			switchParty();
			BasePokemon.choiceCounter = 0;
		}
	}
	
	//When run... switches the first selected pokemon with the second one
	static void switchParty(){
		PartyPos[arrayID1] = tempPoke2;
		PartyPos[arrayID2] = tempPoke1;
		choiceCounter = 0;
	}
	
	//When run... selects a random move for foe to use
	static void SetWildMoves() {
		int var = p5.floor(p5.random(1, 4));
		if (var == 1) {
			WildMove = move_name1;
			FoeMoveAtt = move_attPower1;
		}
		if (var == 2) {
			WildMove = move_name2;
			FoeMoveAtt = move_attPower2;
		}
		if (var == 3) {
			WildMove = move_name3;
			FoeMoveAtt = move_attPower3;
		}
		if (var == 4) {
			WildMove = move_name4;
			FoeMoveAtt = move_attPower4;
		}
	
	}
	
	//When run adds EVs + XP to current pokemon
	static void addEvXp() {
		BattleScene.BattleWon = true;
		partyHPEV = LoadData.party_hpEV.get(0);
		partyAttackEV = LoadData.party_attackEV.get(0);
		partyDefenseEV = LoadData.party_defenseEV.get(0);
		partySpeedEV = LoadData.party_speedEV.get(0);
		partySpecialEV = LoadData.party_specialEV.get(0);
		partyHPEV = BattleScene.calGivingEV(wildTotHP, partyHPEV);
		partyAttackEV = BattleScene.calGivingEV(wildAttack, partyAttackEV);
		partyDefenseEV = BattleScene.calGivingEV(wildDefense, partyDefenseEV);
		partySpeedEV = BattleScene.calGivingEV(wildSpeed, partySpeedEV);
		partySpecialEV = BattleScene.calGivingEV(wildSpecial, partySpecialEV);

		XpGiven = p5.floor((float) BattleScene.calEarnedXP(XpGiven, wildBaseXP, wildLvL));
		CuRxp = CuRxp + XpGiven;
		writeData.updateParty();
	}

	//When run...initializes wild pokemon base stats based on random number
	static void intWildPokemon() {
		// Randomly selects pokemon based on the possible pokemon in area
		wildID = p5.floor(p5.random(0, LoadData.areaCounter));
		wildHPIV = p5.floor(p5.random(0, 15));
		wildAttackIV = p5.floor(p5.random(0, 15));
		wildDefenseIV = p5.floor(p5.random(0, 15));
		wildSpeedIV = p5.floor(p5.random(0, 15));
		wildSpecialIV = p5.floor(p5.random(0, 15));
		wildHPEV = wildAttackEV = wildDefenseEV = wildSpeedEV = wildSpecialEV = 0;

		wildLvL = p5.floor(p5.random(lowWildLvl, maxWildLvl));
		wildBaseXP = (LoadData.areaP_BaseXP.get(wildID));
		XpGiven = 0;

		wildActHP = LoadData.areaP_ACThp.get(wildID);
		statType = true;
		wildActHP = calStats(wildActHP, wildActHP, wildHPIV, wildHPEV, wildLvL);
		wildTotHP = wildActHP;
		statType = false;
		wildAttack = LoadData.areaP_attack.get(wildID);
		wildAttack = calStats(wildAttack, wildAttack, wildAttackIV, wildAttackEV, wildLvL);
		wildDefense = LoadData.areaP_defense.get(wildID);
		wildDefense = calStats(wildDefense, wildDefense, wildDefenseIV, wildDefenseEV, wildLvL);
		wildSpeed = LoadData.areaP_speed.get(wildID);
		wildSpeed = calStats(wildSpeed, wildSpeed, wildSpeedIV, wildSpeedEV, wildLvL);
		wildSpecial = LoadData.areaP_special.get(wildID);
		wildSpecial = calStats(wildSpecial, wildSpecial, wildSpecialIV, wildSpecialEV, wildLvL);

		wildTOTXp = p5.floor(wildLvL * wildLvL);
		wildXpNextLvl = p5.floor(wildLvL * wildLvL * wildLvL);
		int tempvar1 = 10;
		int tempvar2 = 10;
		int tempvar3 = 10;
		int var = p5.floor(p5.random(0, 9));
		tempvar1 = var;
		move_name1 = LoadData.move_name.get(var);
		move_pp1 = LoadData.move_PP.get(var);
		move_attPower1 = LoadData.move_attPower.get(var);
		var = p5.floor(p5.random(0, 9));

		while (var == tempvar1 || var == tempvar2 || var == tempvar3) {
			var = p5.floor(p5.random(0, 9));
		}

		move_name2 = LoadData.move_name.get(var);
		move_pp2 = LoadData.move_PP.get(var);
		move_attPower2 = LoadData.move_attPower.get(var);
		var = p5.floor(p5.random(0, 9));

		while (var == tempvar1 || var == tempvar2 || var == tempvar3) {
			var = p5.floor(p5.random(0, 9));
		}

		move_name3 = LoadData.move_name.get(var);
		move_pp3 = LoadData.move_PP.get(var);
		move_attPower3 = LoadData.move_attPower.get(var);
		var = p5.floor(p5.random(0, 9));

		while (var == tempvar1 || var == tempvar2 || var == tempvar3) {
			var = p5.floor(p5.random(0, 9));
		}

		move_name4 = LoadData.move_name.get(var);
		move_pp4 = LoadData.move_PP.get(var);
		move_attPower4 = LoadData.move_attPower.get(var);
	}

	// When run... calculates stats based on level of Pokemon
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

	//When run... Initializes starter pokemon 
	static void intFirstPoke() {
		chosenHPIV = (p5.floor(p5.random(0, 15)));
		chosenAttackIV = (p5.floor(p5.random(0, 15)));
		chosenDefenseIV = (p5.floor(p5.random(0, 15)));
		chosenSpeedIV = (p5.floor(p5.random(0, 15)));
		chosenSpecialIV = (p5.floor(p5.random(0, 15)));
		chosenActHP = (LoadData.start_ACThp.get(chosenID));
		statType = true;
		chosenActHP = calStats(chosenActHP, chosenActHP, chosenHPIV, 0, 5);
		chosenTotHP = chosenActHP;
		statType = false;
		chosenAttack = (LoadData.start_attack.get(chosenID));
		chosenAttack = calStats(chosenAttack, chosenAttack, chosenAttackIV, 0, 5);
		chosenDefense = (LoadData.start_defense.get(chosenID));
		chosenDefense = calStats(chosenDefense, chosenDefense, chosenDefenseIV, 0, 5);
		chosenSpeed = (LoadData.start_speed.get(chosenID));
		chosenSpeed = calStats(chosenSpeed, chosenSpeed, chosenSpeedIV, 0, 5);
		chosenSpecial = (LoadData.start_special.get(chosenID));
		chosenSpecial = calStats(chosenSpecial, chosenSpecial, chosenSpecialIV, 0, 5);
	}
}