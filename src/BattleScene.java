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
	static boolean stop1, partyFull;
	static boolean GameOver;
	static boolean intialize, UserXPadd;

	static PImage background;
	static double damage;

	BattleScene(Pokemon _p5) {
		p5 = _p5;
		UserXPadd = BattleWon = BattleLost = BattleCaught = LeveLup = FoeTurn = GameOver = false;
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
		if (intialize == true) {
			Graphics.resetSquare();
			intialize = false;
		}
		BasePokemon.userACThp = 10000000;
		GameOver = false;
		UserTurn = true;
		FoeTurn = false;
		BattleWon = BattleLost = false;
		if (LoadData.partyCounter >= writeData.partySize) {
			partyFull = true;
		}
		intialize = false;
		Graphics.DrawDefaultBattleMenu();

		if (UserTurn == true && GameOver == false) {
			FoeTurn = false;
			runUserTurn();
		}

		if (FoeTurn == true && GameOver == false) {
			UserTurn = false;
			RunFoeTurn();
		}
	}

	static void runUserTurn() {
		UserTurn = true;
		FoeTurn = false;
		if (InGame.swtch == 0 && FoeTurn == false) {
			// Draws main menu text
			stop1 = false;
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
			Graphics.DrawBattlePartyMenu();
			Graphics.DrawBattleMenu1();
			keyPressed();
		}

		// When foe attack display what move they used
		if (InGame.swtch == 3 && FoeTurn == false) {
			Graphics.DrawBattleMenu1();
			Graphics.BattleResponse();
			if (stop1 == false) {
				p5.key = 'm';
				p5.keyPressed = false;
				stop1 = true;
			}
			keyPressed();
		}
		System.out.println(stop1);
		// If you lose.. display message to leave
		if (InGame.swtch == 4 && FoeTurn == false) {
			stop1 = false;
			Graphics.resetSquare();
			Graphics.BattleResponse();
			keyPressed();
		}

		if (BasePokemon.wildActHP <= 0 && stop1 == false) {
			FoeTurn = false;
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
			keyPressed();
		}

		// If in party menu and option change is choose
		if (InGame.swtch == 6 && FoeTurn == false) {
			if (stop1 == false) {
				BattleScene.choicePosX = Graphics.rectPosX1;
				BattleScene.choicePosY = Graphics.rectPosY1 + 50;
				stop1 = true;
			}
			p5.background(255, 0, 0);
			Graphics.DrawBattlePartyMenu();
			Graphics.DrawBattleMenu1();
			keyPressed();
		}

		if (InGame.swtch == 7 && FoeTurn == false) {
			if (BattleCaught == true) {
				Graphics.DrawDefaultBattleMenu();
				Graphics.DrawBattleMenu1();
				keyPressed();
			}

			if (BattleCaught == false) {
				Graphics.DrawDefaultBattleMenu();
				Graphics.DrawBattleMenu1();
				keyPressed();
			}

			if (GameOver == true) {
				partyFull = false;
			}
		}
	}

	static void RunFoeTurn() {
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
		Graphics.resetSquare();
	}

	static void keyPressed() {
		if (p5.keyPressed == true && p5.key == 'w') {
			if (InGame.swtch != 6) {
				choicePosY = textY1 - 12;

			}

			if (InGame.swtch == 6 || InGame.partyMenu == true) {
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

		if (p5.keyPressed == true && p5.key == 's') {
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

		if (p5.keyPressed == true && p5.key == 'a') {
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

		if (p5.keyPressed == true && p5.key == 'd') {
			if (InGame.swtch != 6 || InGame.partyMenu == true) {
				choicePosX = textX2 - 15;

			}
			if (InGame.swtch == 6 || InGame.partyMenu == true) {
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
			if (InGame.swtch == 1 || InGame.swtch == 3 || InGame.swtch == 2) {
				if (InGame.swtch == 3) {
					stop1 = true;
				}
				Graphics.resetSquare();
				InGame.swtch = 0;
				p5.key = 'm';
				p5.keyPressed = false;
			}

			else if (InGame.swtch == 4) {
				InGame.swtch = 0;
				FoeTurn = true;
				GameOver = true;
				writeData.updateParty();
				MainMenu.resetLocation();
				Pokemon.walkingView = true;
				p5.key = 'm';
				p5.keyPressed = false;
			}

			else if (InGame.swtch == 5) {
				UserTurn = false;
				stop1 = false;
				Pokemon.walkingView = true;
				p5.key = 'm';
				p5.keyPressed = false;
			}

			else if (InGame.swtch == 6) {
				stop1 = false;
				InGame.swtch = 2;
				Graphics.resetSquare();
				p5.key = 'm';
				p5.keyPressed = false;
			}

			else if (InGame.swtch == 7) {
				if (BattleCaught == true) {
					writeData.updateParty();
					LoadData.loadParty();
					BattleCaught = false;
					InGame.resetTimer = true;
					Pokemon.walkingView = true;
				}
				if (BattleCaught == false) {
					Graphics.resetSquare();
					RunFoeTurn();
				}

				p5.key = 'm';
				p5.keyPressed = false;
			}
		}

		// Option 1
		else if (p5.key == p5.ENTER && choicePosX == textX1 - 15 && choicePosY == textY1 - 12) {
			if (p5.keyPressed == true && InGame.swtch == 0) {
				InGame.swtch = 1;
				p5.keyPressed = false;
			}

			else if (p5.keyPressed == true && InGame.swtch == 1) {
				BasePokemon.moveNameUsed = LoadData.name_move1.get(0);
				BasePokemon.moveattUsed = LoadData.attPower_move1.get(0);
				BasePokemon.movePPUsed = LoadData.PP_move1.get(0);
				DamageDone();
				Graphics.resetSquare();
				FoeTurn = true;
				InGame.swtch = 0;
				UserTurn = false;
				stop1 = false;
				p5.keyPressed = false;
			}

			else if ((InGame.swtch == 2 || InGame.partyMenu == true) && p5.keyPressed == true) {
				Graphics.resetSquare();
				InGame.swtch = 6;
				Graphics.resetSquare();
				p5.keyPressed = false;
			}
		}
		// Option 2
		else if (p5.key == p5.ENTER && choicePosX == textX2 - 15 && choicePosY == textY1 - 12) {
			if (p5.keyPressed == true && InGame.swtch == 0) {
				InGame.swtch = 2;
				Graphics.resetSquare();
				Graphics.DrawBattlePartyMenu();
				p5.keyPressed = false;
			}

			else if (p5.keyPressed == true && InGame.swtch == 1) {
				BasePokemon.moveNameUsed = LoadData.name_move2.get(0);
				BasePokemon.moveattUsed = LoadData.attPower_move2.get(0);
				BasePokemon.movePPUsed = LoadData.PP_move2.get(0);
				DamageDone();
				Graphics.resetSquare();
				FoeTurn = true;
				stop1 = false;
				InGame.swtch = 0;
				p5.keyPressed = false;
			}
		}
		// Option 3
		else if (p5.key == p5.ENTER && choicePosX == textX1 - 15 && choicePosY == textY2 - 12) {
			if (p5.keyPressed == true && InGame.swtch == 0) {
				Graphics.resetSquare();
				if (LoadData.partyCounter < writeData.partySize) {
					checkCaught();
					InGame.swtch = 7;
					p5.keyPressed = false;
				}
				if (LoadData.partyCounter >= writeData.partySize) {
					InGame.swtch = 0;
					p5.keyPressed = false;
				}
			}

			else if (p5.keyPressed == true && InGame.swtch == 1) {
				BasePokemon.moveNameUsed = LoadData.name_move3.get(0);
				BasePokemon.moveattUsed = LoadData.attPower_move3.get(0);
				BasePokemon.movePPUsed = LoadData.PP_move3.get(0);
				DamageDone();
				Graphics.resetSquare();
				FoeTurn = true;
				stop1 = false;
				InGame.swtch = 0;
				p5.keyPressed = false;
			}
		}
		// Option 4
		else if (p5.key == p5.ENTER && choicePosX == textX2 - 15 && choicePosY == textY2 - 12) {

			if (p5.keyPressed == true && InGame.swtch == 0) {
				Graphics.resetSquare();
				Pokemon.walkingView = true;
				InGame.resetTimer = true;
				p5.keyPressed = false;
			}

			else if (p5.keyPressed == true && InGame.swtch == 1) {
				BasePokemon.moveNameUsed = LoadData.name_move4.get(0);
				BasePokemon.moveattUsed = LoadData.attPower_move4.get(0);
				BasePokemon.movePPUsed = LoadData.PP_move4.get(0);
				DamageDone();
				Graphics.resetSquare();
				FoeTurn = true;
				stop1 = false;
				InGame.swtch = 0;
				p5.keyPressed = false;
			}
		}

		// Switch pokemon
		else if (InGame.swtch == 6 && p5.keyPressed == true && p5.key == p5.ENTER) {
			// Pokemon 1 slot
			if (BattleScene.choicePosX == Graphics.rectPosX1 && BattleScene.choicePosY == (Graphics.rectPosY1 + 50)) {
				if (LoadData.partyCounter > 0) {
					BasePokemon.choiceCounter++;
					int slot = 0;

					if (BasePokemon.choiceCounter == 1) {
						BasePokemon.arrayID1 = slot;
					}

					else if (BasePokemon.choiceCounter == 2) {
						BasePokemon.arrayID2 = slot;
					}

					BasePokemon.selectSwapPoke(slot);
					p5.keyPressed = false;
				} else {
					System.out.println("No Pokemon in slot 1");
					p5.keyPressed = false;
				}
			}

			// Pokemon 2 slot
			else if (BattleScene.choicePosX == Graphics.rectPosX2
					&& BattleScene.choicePosY == (Graphics.rectPosY1 + 50)) {
				if (LoadData.partyCounter > 1) {
					BasePokemon.choiceCounter++;
					int slot = 1;
					if (BasePokemon.choiceCounter == 1) {
						BasePokemon.arrayID1 = slot;
					}

					else if (BasePokemon.choiceCounter == 2) {
						BasePokemon.arrayID2 = slot;
					}
					BasePokemon.selectSwapPoke(slot);
					p5.keyPressed = false;
				} else {
					System.out.println("No Pokemon in slot 2");
					p5.keyPressed = false;
				}
			}

			// Pokemon 3 slot
			else if (BattleScene.choicePosX == Graphics.rectPosX1
					&& BattleScene.choicePosY == (Graphics.rectPosY2 + 50)) {
				if (LoadData.partyCounter > 2) {
					BasePokemon.choiceCounter++;
					int slot = 2;
					if (BasePokemon.choiceCounter == 1) {
						BasePokemon.arrayID1 = slot;
					} else if (BasePokemon.choiceCounter == 2) {
						BasePokemon.arrayID2 = slot;
					}
					BasePokemon.selectSwapPoke(slot);
					p5.keyPressed = false;
				} else {
					System.out.println("No Pokemon in slot 3");
					p5.keyPressed = false;
				}
			}

			// Pokemon 4 slot
			else if (BattleScene.choicePosX == Graphics.rectPosX2
					&& BattleScene.choicePosY == (Graphics.rectPosY2 + 50)) {
				if (LoadData.partyCounter > 3) {
					BasePokemon.choiceCounter++;
					int slot = 3;
					if (BasePokemon.choiceCounter == 1) {
						BasePokemon.arrayID1 = slot;
					} else if (BasePokemon.choiceCounter == 2) {
						BasePokemon.arrayID2 = slot;
					}
					BasePokemon.selectSwapPoke(slot);
					p5.keyPressed = false;
				} else {
					System.out.println("No Pokemon in slot 4");
					p5.keyPressed = false;
				}
			}

			// Pokemon 5 slot
			else if (BattleScene.choicePosX == Graphics.rectPosX1
					&& BattleScene.choicePosY == (Graphics.rectPosY3 + 50)) {
				if (LoadData.partyCounter > 4) {
					BasePokemon.choiceCounter++;
					int slot = 4;
					if (BasePokemon.choiceCounter == 1) {
						BasePokemon.arrayID1 = slot;
					} else if (BasePokemon.choiceCounter == 2) {
						BasePokemon.arrayID2 = slot;
					}
					BasePokemon.selectSwapPoke(slot);
					p5.keyPressed = false;
				} else {
					System.out.println("No Pokemon in slot 5");
					p5.keyPressed = false;
				}
			}

			// Pokemon 6 slot
			else if (BattleScene.choicePosX == Graphics.rectPosX2
					&& BattleScene.choicePosY == (Graphics.rectPosY3 + 50)) {
				if (LoadData.partyCounter > 5) {
					BasePokemon.choiceCounter++;
					int slot = 5;
					if (BasePokemon.choiceCounter == 1) {
						BasePokemon.arrayID1 = slot;
					} else if (BasePokemon.choiceCounter == 2) {
						BasePokemon.arrayID2 = slot;
					}
					BasePokemon.selectSwapPoke(slot);
					p5.keyPressed = false;
				} else {
					System.out.println("No Pokemon in slot 6");
					p5.keyPressed = false;
				}
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
			damage = (((part1 / 250) * (part2 / LoadData.party_defense.get(BasePokemon.PartyPos[0])))
					* BasePokemon.FoeMoveAtt) + 2;
			BasePokemon.userACThp = LoadData.party_ACThp.get(BasePokemon.PartyPos[0]) - (int) (damage);
			damage = 0;
		}

		if (UserTurn == true) {
			float part1 = ((2 * LoadData.party_lvl.get(BasePokemon.PartyPos[0])) + 10);
			float part2 = LoadData.party_attack.get(BasePokemon.PartyPos[0]);
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

		BasePokemon.statType = true;
		BasePokemon.userTotHP = BasePokemon.calStats(
				LoadData.Dex_TOThp.get(LoadData.party_id.get(BasePokemon.PartyPos[0])),
				LoadData.party_hpIV.get(BasePokemon.PartyPos[0]), LoadData.party_hpEV.get(BasePokemon.PartyPos[0]),
				BasePokemon.Level);
		BasePokemon.statType = false;
		BasePokemon.userActHP = BasePokemon.userTotHP;

		BasePokemon.userAttack = BasePokemon.calStats(
				LoadData.Dex_attack.get(LoadData.party_id.get(BasePokemon.PartyPos[0])),
				LoadData.party_attackIV.get(BasePokemon.PartyPos[0]),
				LoadData.party_attackEV.get(BasePokemon.PartyPos[0]), BasePokemon.Level);

		BasePokemon.userDefense = BasePokemon.calStats(
				LoadData.Dex_defense.get(LoadData.party_id.get(BasePokemon.PartyPos[0])),
				LoadData.party_defenseIV.get(BasePokemon.PartyPos[0]),
				LoadData.party_defenseEV.get(BasePokemon.PartyPos[0]), BasePokemon.Level);

		BasePokemon.userSpeed = BasePokemon.calStats(
				LoadData.Dex_speed.get(LoadData.party_id.get(BasePokemon.PartyPos[0])),
				LoadData.party_speedIV.get(BasePokemon.PartyPos[0]),
				LoadData.party_speedEV.get(BasePokemon.PartyPos[0]), BasePokemon.Level);

		BasePokemon.userSpecial = BasePokemon.calStats(
				LoadData.Dex_special.get(LoadData.party_id.get(BasePokemon.PartyPos[0])),
				LoadData.party_specialIV.get(BasePokemon.PartyPos[0]),
				LoadData.party_specialEV.get(BasePokemon.PartyPos[0]), BasePokemon.Level);

		// Once average levels are calcuated....fix this
		BasePokemon.lowWildLvl++;
		BasePokemon.maxWildLvl++;
		writeData.updateParty();
	}

	static void checkCaught() {
		int randVar;
		randVar = p5.floor(p5.random(0, (BasePokemon.wildTotHP)));

		if (randVar >= BasePokemon.wildActHP) {
			BattleCaught = true;
		}
	}
}
