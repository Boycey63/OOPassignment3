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
	public static boolean BattleWon, BattleLost, BattleCaught, LeveLup, UserTurn, FoeTurn;
	static float textX1, textX2, textY1, textY2;
	static float choicePosX, choicePosY;
	static boolean stop1;
	static boolean GameOver;
	static boolean intialize;

	static PImage background;
	static double damage;

	BattleScene(Pokemon _p5) {
		p5 = _p5;
		BattleWon = BattleLost = BattleCaught = LeveLup = FoeTurn = GameOver = false;
		UserTurn = true;
		intialize = true;
		stop1 = false;
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

	void runBattleScene() {
		LoadData.loadParty();
		Graphics.DrawDefaultBattleMenu();
		intialize = true;

		if (intialize == true) {
			BasePokemon.userACThp = 10000000;
			BattleCaught = false;
			GameOver = false;
			UserTurn = true;
			intialize = false;
		}

		if (UserTurn == true && GameOver == false) {
			FoeTurn = false;
			runUserTurn();
		}

		if (FoeTurn == true && GameOver == false) {
			UserTurn = false;
			RunFoeTurn();
			p5.text(LoadData.areaP_name.get(BasePokemon.wildID) + " used " + BasePokemon.WildMove, 40,
					(Rectangle1Y + (Rectangle1H / 2)));
		}
	}

	void runUserTurn() {
		UserTurn = true;
		FoeTurn = false;
		if (InGame.swtch == 0 && FoeTurn == false) {
			// Draws main menu text
			Graphics.DrawBattleMenu1();
			keyPressed();
		}
		// View Attack option
		if (InGame.swtch == 1 && FoeTurn == false) {
			// Draws the move menu text + hint text
			Graphics.DrawBattleMenu1();
			keyPressed();
		}

		// View Party option
		if (InGame.swtch == 2 && FoeTurn == false) {
			// Start here...need to draw main battle menu
			Graphics.DrawPartyMenu();
			Graphics.DrawBattleMenu1();
			keyPressed();
		}

		// When foe attack display what move they used
		if (InGame.swtch == 3 && FoeTurn == false) {
			Graphics.DrawBattleMenu1();
			Graphics.BattleResponse();

			if (p5.keyPressed == true && p5.key == p5.BACKSPACE) {
				InGame.swtch = 0;
			}
		}

		// If you lose.. display message to leave
		if (InGame.swtch == 4 && FoeTurn == false) {
			Graphics.DrawBattleMenu1();
			Graphics.BattleResponse();

			if (p5.keyPressed == true && p5.key == p5.BACKSPACE) {
				InGame.swtch = 0;
				FoeTurn = true;
				GameOver = true;
				writeData.updateParty();
				MainMenu.resetLocation();
				Pokemon.walkingView = true;
			}
		}

		if (BasePokemon.wildActHP <= 0 && stop1 == false) {
			BasePokemon.LoadUserStats();
			BasePokemon.addEvXp();

			// When current xp reaches next level xp level up
			if (BasePokemon.NexTxp <= (BasePokemon.ToTxp + BasePokemon.CuRxp)) {
				PokeLevelUP();
				stop1 = true;
			}
			BasePokemon.wildActHP = 0;
			InGame.swtch = 5;
			stop1 = true;
			GameOver = true;
		}

		// If you win
		if (InGame.swtch == 5 && FoeTurn == false) {
			Graphics.DrawBattleMenu1();
			Graphics.BattleResponse();

			if (p5.keyPressed == true && p5.key == p5.BACKSPACE) {
				UserTurn = false;
				stop1 = false;
				Pokemon.walkingView = true;

			}
		}

		// If in party menu and option change is choose
		if (InGame.swtch == 6 && FoeTurn == false) {
			if (stop1 == false) {
				BattleScene.choicePosX = Graphics.rectPosX1;
				BattleScene.choicePosY = Graphics.rectPosY1 + 50;
				stop1 = true;
			}
			p5.background(255, 0, 0);
			Graphics.DrawPartyMenu();
			Graphics.DrawBattleMenu1();
			keyPressed();
		}
	}

	void RunFoeTurn() {
		stop1 = false;
		FoeTurn = true;
		UserTurn = false;
		BasePokemon.SetWildMoves();

		if (stop1 == false) {
			InGame.swtch = 10;
			DamageDone();
			writeData.updateParty();
			InGame.swtch = 3;
			if (BasePokemon.userACThp <= 0) {
				GameOver = true;
				InGame.swtch = 4;
				stop1 = true;
			}
		}
	}

	static void keyPressed() {
		if (p5.keyPressed == true && p5.key == 'w') {
			if (InGame.swtch != 6) {
				choicePosY = textY1 - 12;

			}

			if (InGame.swtch == 6) {
				if (choicePosY == (Graphics.rectPosY1 + 50)) {
					choicePosY = (Graphics.rectPosY1 + 50);
				}

				else if (choicePosY == (Graphics.rectPosY2 + 50)) {
					choicePosY = (Graphics.rectPosY1 + 50);
				}

				else if (choicePosY == (Graphics.rectPosY3 + 50)) {
					choicePosY = (Graphics.rectPosY2 + 50);
				}
			}
			p5.keyPressed = false;
		}

		else if (p5.keyPressed == true && p5.key == 's') {
			if (InGame.swtch != 6) {
				choicePosY = textY2 - 12;
			}

			if (InGame.swtch == 6) {
				if (choicePosY == (Graphics.rectPosY1 + 50)) {
					choicePosY = (Graphics.rectPosY2 + 50);
				}

				else if (choicePosY == (Graphics.rectPosY2 + 50)) {
					choicePosY = (Graphics.rectPosY3 + 50);
				}

				else if (choicePosY == (Graphics.rectPosY3 + 50)) {
					choicePosY = (Graphics.rectPosY3 + 50);
				}
			}
			p5.keyPressed = false;
		}

		else if (p5.keyPressed == true && p5.key == 'a') {
			if (InGame.swtch != 6) {
				choicePosX = textX1 - 15;

			}
			if (InGame.swtch == 6) {
				if (choicePosX == Graphics.rectPosX1) {
					choicePosX = Graphics.rectPosX1;
				}

				else if (choicePosX == Graphics.rectPosX2) {
					choicePosX = Graphics.rectPosX1;
				}
			}
			p5.keyPressed = false;
		}

		else if (p5.keyPressed == true && p5.key == 'd') {
			if (InGame.swtch != 6) {
				choicePosX = textX2 - 15;

			}
			if (InGame.swtch == 6) {
				if (choicePosX == Graphics.rectPosX1) {
					choicePosX = Graphics.rectPosX2;
				}

				else if (choicePosX == Graphics.rectPosX2) {
					choicePosX = Graphics.rectPosX2;
				}
			}
			p5.keyPressed = false;
		}

		else if (p5.key == p5.BACKSPACE) {
			if (InGame.swtch == 6) {
				stop1 = false;
				InGame.swtch = 2;
			}

			if(InGame.swtch != 6){
			InGame.swtch = 0;
			}
		}

		// Option 1
		else if (p5.key == p5.ENTER && choicePosX == textX1 - 15 && choicePosY == textY1 - 12) {
			if (p5.keyPressed == true && InGame.swtch == 0) {
				InGame.swtch = 1;
				p5.keyPressed = false;
			} else if (p5.keyPressed == true && InGame.swtch == 1) {
				BasePokemon.moveNameUsed = LoadData.name_move1.get(0);
				BasePokemon.moveattUsed = LoadData.attPower_move1.get(0);
				BasePokemon.movePPUsed = LoadData.PP_move1.get(0);
				DamageDone();
				choicePosX = textX1 - 15;
				choicePosY = textY1 - 12;
				FoeTurn = true;
				InGame.swtch = 0;
				UserTurn = false;
				p5.keyPressed = false;
			}

			else if (p5.keyPressed == true && InGame.swtch == 2) {
				InGame.swtch = 6;
				p5.keyPressed = false;
			}
		}
		// Option 2
		else if (p5.key == p5.ENTER && choicePosX == textX2 - 15 && choicePosY == textY1 - 12) {
			if (p5.keyPressed == true && InGame.swtch == 0) {
				InGame.swtch = 2;
				Graphics.DrawPartyMenu();
				p5.keyPressed = false;
			}

			else if (p5.keyPressed == true && InGame.swtch == 1) {
				BasePokemon.moveNameUsed = LoadData.name_move2.get(0);
				BasePokemon.moveattUsed = LoadData.attPower_move2.get(0);
				BasePokemon.movePPUsed = LoadData.PP_move2.get(0);
				DamageDone();
				choicePosX = textX1 - 15;
				choicePosY = textY1 - 12;
				FoeTurn = true;
				InGame.swtch = 0;
				p5.keyPressed = false;
			}
		}
		// Option 3
		else if (p5.key == p5.ENTER && choicePosX == textX1 - 15 && choicePosY == textY2 - 12) {
			if (p5.keyPressed == true && InGame.swtch == 0) {
				choicePosX = textX1 - 15;
				choicePosY = textY1 - 12;
				BattleCaught = true;
				writeData.updateParty();
				LoadData.loadParty();
				InGame.resetTimer = true;
				Pokemon.walkingView = true;
				p5.keyPressed = false;
			}

			else if (p5.keyPressed == true && InGame.swtch == 1) {
				BasePokemon.moveNameUsed = LoadData.name_move3.get(0);
				BasePokemon.moveattUsed = LoadData.attPower_move3.get(0);
				BasePokemon.movePPUsed = LoadData.PP_move3.get(0);
				DamageDone();
				choicePosX = textX1 - 15;
				choicePosY = textY1 - 12;
				FoeTurn = true;
				InGame.swtch = 0;
				p5.keyPressed = false;
			}
		}
		// Option 4
		else if (p5.key == p5.ENTER && choicePosX == textX2 - 15 && choicePosY == textY2 - 12) {
			if (p5.keyPressed == true && InGame.swtch == 0) {
				choicePosX = textX1 - 15;
				choicePosY = textY1 - 12;
				Pokemon.walkingView = true;
				InGame.resetTimer = true;
				p5.keyPressed = false;
			} else if (p5.keyPressed == true && InGame.swtch == 1) {
				BasePokemon.moveNameUsed = LoadData.name_move4.get(0);
				BasePokemon.moveattUsed = LoadData.attPower_move4.get(0);
				BasePokemon.movePPUsed = LoadData.PP_move4.get(0);
				DamageDone();
				choicePosX = textX1 - 15;
				choicePosY = textY1 - 12;
				FoeTurn = true;
				InGame.swtch = 0;
				p5.keyPressed = false;
			}
		}

		// Switch pokemon
		else if (InGame.swtch == 6 && p5.keyPressed == true && p5.key == p5.ENTER) {
			// Pokemon 1 slot
			if (BattleScene.choicePosX == Graphics.rectPosX1 && BattleScene.choicePosY == (Graphics.rectPosY1 + 50)) {
				BasePokemon.choiceCounter++;
				int slot = 0;
				
				if (BasePokemon.choiceCounter == 1) {
					BasePokemon.arrayID1 = slot;
				} else if (BasePokemon.choiceCounter == 2) {
					BasePokemon.arrayID2 = slot;
				}
				
				BasePokemon.selectSwapPoke(slot);
				p5.keyPressed = false;
			}

			// Pokemon 2 slot
			else if (BattleScene.choicePosX == Graphics.rectPosX2
					&& BattleScene.choicePosY == (Graphics.rectPosY1 + 50)) {
				BasePokemon.choiceCounter++;
				int slot = 1;
				if (BasePokemon.choiceCounter == 1) {
					BasePokemon.arrayID1 = slot;
				} else if (BasePokemon.choiceCounter == 2) {
					BasePokemon.arrayID2 = slot;
				}
				BasePokemon.selectSwapPoke(slot);	
				p5.keyPressed = false;
			}

			// Pokemon 3 slot
			else if (BattleScene.choicePosX == Graphics.rectPosX1
					&& BattleScene.choicePosY == (Graphics.rectPosY2 + 50)) {
				BasePokemon.choiceCounter++;
				int slot = 2;
				if (BasePokemon.choiceCounter == 1) {
					BasePokemon.arrayID1 = slot;
				} else if (BasePokemon.choiceCounter == 2) {
					BasePokemon.arrayID2 = slot;
				}
				BasePokemon.selectSwapPoke(slot);
				p5.keyPressed = false;
			}

			// Pokemon 4 slot
			else if (BattleScene.choicePosX == Graphics.rectPosX2
					&& BattleScene.choicePosY == (Graphics.rectPosY2 + 50)) {
				BasePokemon.choiceCounter++;
				int slot = 3;
				if (BasePokemon.choiceCounter == 1) {
					BasePokemon.arrayID1 = slot;
				} else if (BasePokemon.choiceCounter == 2) {
					BasePokemon.arrayID2 = slot;
				}
				BasePokemon.selectSwapPoke(slot);
				p5.keyPressed = false;
			}

			// Pokemon 5 slot
			else if (BattleScene.choicePosX == Graphics.rectPosX1
					&& BattleScene.choicePosY == (Graphics.rectPosY3 + 50)) {
				BasePokemon.choiceCounter++;
				int slot = 4;
				if (BasePokemon.choiceCounter == 1) {
					BasePokemon.arrayID1 = slot;
				} else if (BasePokemon.choiceCounter == 2) {
					BasePokemon.arrayID2 = slot;
				}
				BasePokemon.selectSwapPoke(slot);
				p5.keyPressed = false;
			}

			// Pokemon 6 slot
			else if (BattleScene.choicePosX == Graphics.rectPosX2
					&& BattleScene.choicePosY == (Graphics.rectPosY3 + 50)) {
				BasePokemon.choiceCounter++;
				int slot = 5;
				if (BasePokemon.choiceCounter == 1) {
					BasePokemon.arrayID1 = slot;
				} else if (BasePokemon.choiceCounter == 2) {
					BasePokemon.arrayID2 = slot;
				}
				BasePokemon.selectSwapPoke(slot);
				p5.keyPressed = false;
			}
		}
	}

	static void DamageDone() {
		// damage = (((2xLEVEL+10)/250) x (ATTACK/DEFENSE) x BASE + 2) x
		// Modifier
		// Base is the base power of the attack move
		if (FoeTurn == true) {
			float part1 = ((2 * BasePokemon.wildLvL) + 10);
			float part2 = BasePokemon.wildAttack;
			damage = (((part1 / 250) * (part2 / LoadData.party_defense.get(0))) * BasePokemon.FoeMoveAtt) + 2;
			BasePokemon.userACThp = LoadData.party_ACThp.get(0) - (int) (damage);
			damage = 0;
		}

		if (UserTurn == true) {
			float part1 = ((2 * LoadData.party_lvl.get(0)) + 10);
			float part2 = LoadData.party_attack.get(0);
			damage = (((part1 / 250) * (part2 / BasePokemon.wildDefense)) * BasePokemon.moveattUsed) + 2;
			BasePokemon.wildActHP = BasePokemon.wildActHP - (int) (damage);
			damage = 0;
		}
	}

	static double calGivingEV(int wildVar1, double userVar2) {
		userVar2 = userVar2 + (Math.sqrt(wildVar1)) / 4;
		return userVar2;
	}

	static double calEarnedXP(int EarnedXp, int baseXp, int Level) {
		EarnedXp = (baseXp * Level) / 7;
		return EarnedXp;
	}

	static void PokeLevelUP() {
		BattleWon = LeveLup = true;
		BasePokemon.Level = BasePokemon.Level + 1;
		// Get difference and sets current as difference
		BasePokemon.CuRxp = ((BasePokemon.ToTxp + BasePokemon.CuRxp) - BasePokemon.NexTxp);
		BasePokemon.NexTxp = BasePokemon.Level * BasePokemon.Level * BasePokemon.Level;
		BasePokemon.ToTxp = BasePokemon.Level * BasePokemon.Level;

		// Changes needed when switching pokemon
		// Need to pokedex stats
		LoadData.loadStartPokemon();

		BasePokemon.statType = true;
		BasePokemon.userActHP = BasePokemon.calStats(BasePokemon.userTotHP, BasePokemon.userTotHP,
				LoadData.party_hpIV.get(BasePokemon.chosenID), LoadData.party_hpEV.get(0), BasePokemon.Level);
		BasePokemon.statType = false;
		BasePokemon.userTotHP = BasePokemon.userActHP;
		BasePokemon.userAttack = BasePokemon.calStats(BasePokemon.userAttack,
				LoadData.start_attack.get(BasePokemon.chosenID), LoadData.party_attackIV.get(0),
				LoadData.party_attackEV.get(0), BasePokemon.Level);
		BasePokemon.userDefense = BasePokemon.calStats(BasePokemon.userDefense,
				LoadData.start_defense.get(BasePokemon.chosenID), LoadData.party_defenseIV.get(0),
				LoadData.party_defenseEV.get(0), BasePokemon.Level);
		BasePokemon.userSpeed = BasePokemon.calStats(BasePokemon.userSpeed,
				LoadData.start_speed.get(BasePokemon.chosenID), LoadData.party_speedIV.get(0),
				LoadData.party_speedEV.get(0), BasePokemon.Level);
		BasePokemon.userSpecial = BasePokemon.calStats(BasePokemon.userSpecial,
				LoadData.start_special.get(BasePokemon.chosenID), LoadData.party_specialIV.get(0),
				LoadData.party_specialEV.get(0), BasePokemon.Level);

		// Once average levels are calcuated....fix this
		BasePokemon.lowWildLvl++;
		BasePokemon.maxWildLvl++;
		writeData.updateParty();
	}
}