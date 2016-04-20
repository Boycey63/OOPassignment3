//Make the low lvl of wild pokemon as average of party pokemon

public class Graphics {

	static Pokemon p5;
	static float rectPosX1, rectPosX2;
	static float rectPosY1, rectPosY2, rectPosY3;
	static float height;
	static float width;
	static float textHeight1, textHeight2, rectHeight;
	static float textX1, textX2, textY1, textY2, textY3;

	Graphics(Pokemon _p5) {
		p5 = _p5;	
		rectHeight = 0;
		height = 100;
		width = p5.width - 300;
		textHeight1 = 150;
		textHeight2 = 200;
		rectHeight = textHeight1;
		rectPosX1 = p5.width / 8 - 20;
		rectPosX2 = p5.width / 8 + 520;
		rectPosY1 = (p5.height - BattleScene.defaultRectangleH) / 10 - 5;
		rectPosY2 = (p5.height - BattleScene.defaultRectangleH) / 10 - 5 + 170;
		rectPosY3 = (p5.height - BattleScene.defaultRectangleH) / 10 - 5 + 340;
		textX1 = rectPosX1 + 60;
		textX2 = rectPosX2 + 60;
		textY1 = rectPosY1 + 60;
		textY2 = rectPosY2 + 60;
		textY3 = rectPosY3 + 60;
	}

	// Drawings for walk mode
	public static void displayMap() {
		// Draws hit detection under image
		p5.image(InGame.map2, 0, 0);

		// Draws top image
		p5.image(InGame.map1, 0, 0);
	}

	public static void displayCharacter() {
		p5.image(InGame.character, InGame.characterX, InGame.characterY);
		InGame.topR = InGame.characterX + InGame.character.width;
		InGame.bottomL = InGame.characterY + InGame.character.height;
	}

	// Drawings for battle mode
	// Default battle menu...will be drawn no matter what
	static void DrawDefaultBattleMenu() {
		if (InGame.swtch != 2 || InGame.swtch != 6) {
			p5.background(180);
			p5.stroke(0);
			p5.fill(0);
			p5.image(BattleScene.background, 0, 0);
			if (InGame.swtch != 4) {
				// User Pokemon Info
				p5.textSize(30);
				p5.text(LoadData.party_name.get(BasePokemon.PartyPos[0]), 620, 430);
				p5.textSize(25);
				p5.text("Lvl: " + LoadData.party_lvl.get(BasePokemon.PartyPos[0]), 620, 460);
				p5.text("HP: " + LoadData.party_ACThp.get(BasePokemon.PartyPos[0]), 620, 490);
				p5.text("Cur XP: " + LoadData.party_CurXP.get(BasePokemon.PartyPos[0]), 620, 520);
				p5.text("Next XP: " + (LoadData.party_xpNextLvl.get(BasePokemon.PartyPos[0])
						- LoadData.party_TOTxp.get(BasePokemon.PartyPos[0])), 900, 520);
				// Wild Pokemon Info
				p5.textSize(30);
				p5.text(LoadData.areaP_name.get(BasePokemon.wildID), 40, 40);
				p5.textSize(25);
				p5.text("Lvl: " + BasePokemon.wildLvL, 40, 70);
				p5.text("HP: " + BasePokemon.wildActHP, 40, 100);
			}
		}
		// Draw rectangle
		p5.stroke(0);
		p5.fill(100, 100, 100);
		p5.rect(BattleScene.defaultRectangleX, BattleScene.defaultRectangleY, BattleScene.defaultRectangleW,
				BattleScene.defaultRectangleH, 20, 20, 0, 0);

		if (InGame.swtch == 2 || InGame.swtch == 6) {
			p5.background(255, 0, 0);
		}
	}

	// battleMenu1 will be drawn if user hasn't selected a starting choice
	static void DrawBattleMenu1() {
		p5.textSize(20);
		p5.stroke(0);
		BattleScene.Rectangle1H = 150;
		BattleScene.Rectangle1W = 600;
		BattleScene.Rectangle1X = p5.width - (BattleScene.Rectangle1W + 10);
		BattleScene.Rectangle1Y = p5.height - (BattleScene.Rectangle1H + 10);

		// Menu rectangle
		p5.fill(150);
		p5.stroke(0);
		if (InGame.swtch != 3 && InGame.swtch != 5 && InGame.swtch != 6) {
			p5.rect(BattleScene.Rectangle1X, BattleScene.Rectangle1Y, BattleScene.Rectangle1W, BattleScene.Rectangle1H,
					20, 20, 20, 20);
			p5.line(BattleScene.Rectangle1X + (BattleScene.Rectangle1W / 2), BattleScene.Rectangle1Y,
					BattleScene.Rectangle1X + (BattleScene.Rectangle1W / 2), p5.height - 10);
			p5.line(BattleScene.Rectangle1X, BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2), p5.width - 10,
					BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2));
		}

		if (InGame.swtch != 3 && InGame.swtch != 5 && InGame.swtch != 6) {
			p5.fill(0);
			p5.rect(BattleScene.choicePosX, BattleScene.choicePosY, 10, 10, 10, 10, 10, 10);
		}

		if (InGame.swtch == 6) {
			p5.fill(0);
			p5.rect(BattleScene.choicePosX + 30, BattleScene.choicePosY - 5, 10, 10, 10, 10, 10, 10);
		}

		if (InGame.swtch == 0 && InGame.partyMenu == false) {
			p5.textSize(20);
			p5.fill(255);
			if (BattleScene.partyFull == false) {
				p5.text("Press enter to chose an option: ", 40,
						(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)));
			}

			if (BattleScene.partyFull == true) {
				p5.text("Your party is too full!!!", 40,
						(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2) + 20));
				p5.text("Press enter to chose an option: ", 40,
						(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) - 20);
			}
			p5.fill(0);
			p5.text("Fight", BattleScene.textX1, BattleScene.textY1);
			p5.text("Catch", BattleScene.textX1, BattleScene.textY2);
			p5.text("Pokemon", BattleScene.textX2, BattleScene.textY1);
			p5.text("Run", BattleScene.textX2, BattleScene.textY2);
		}

		if (InGame.swtch == 1) {
			p5.textSize(20);
			p5.fill(255);
			p5.text("Press enter to chose a move: ", 40,
					(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) - 20);
			p5.text("Press backspace to return to option menu: ", 40,
					(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) + 20);
			p5.fill(0);
			p5.text(LoadData.name_move1.get(BasePokemon.PartyPos[0]), BattleScene.textX1, BattleScene.textY1);
			p5.text(LoadData.name_move3.get(BasePokemon.PartyPos[0]), BattleScene.textX1, BattleScene.textY2);
			p5.text(LoadData.name_move2.get(BasePokemon.PartyPos[0]), BattleScene.textX2, BattleScene.textY1);
			p5.text(LoadData.name_move4.get(BasePokemon.PartyPos[0]), BattleScene.textX2, BattleScene.textY2);
		}

		if (InGame.swtch == 2 || InGame.partyMenu == true) {
			p5.textSize(20);
			p5.fill(255);
			p5.text("Press enter to chose a option: ", 40,
					(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) - 20);
			if (InGame.partyMenu == false) {
				p5.text("Press backspace to return to battle menu: ", 40,
						(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) + 20);
			}
			if (InGame.partyMenu == true) {
				p5.text("Press backspace to return to previous menu: ", 40,
						(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) + 20);
			}
			p5.fill(0);
			p5.text("Change", BattleScene.textX1, BattleScene.textY1);
		}

		if (InGame.swtch == 7) {
			if (BattleScene.BattleCaught == true) {
				p5.textSize(20);
				p5.fill(255);
				p5.text("The wild " + LoadData.areaP_name.get(BasePokemon.wildID) + " was caught", 40,
						(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) - 40);
				p5.text("and added to you party!", 40, (BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)));
				p5.text("Press backspace to leave battle field", 40,
						(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) + 40);
			}

			else {
				p5.textSize(20);
				p5.fill(255);
				p5.text("The wild  " + LoadData.areaP_name.get(BasePokemon.wildID) + " broke free", 40,
						(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) - 40);
				p5.text("Try weaken it and try catch again", 40,
						(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)));
				p5.text("Press backspace to keep battling", 40,
						(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) + 40);
			}
		}
	}

	static void DrawBattlePartyMenu() {
		p5.stroke(0);
		int sideRect = 20;
		BattleScene.Rectangle1H = 170;

		p5.background(255, 0, 0);

		p5.fill(100, 100, 100);
		p5.rect(BattleScene.defaultRectangleX, BattleScene.defaultRectangleY, BattleScene.defaultRectangleW,
				BattleScene.defaultRectangleH, 20, 20, 0, 0);

		p5.fill(0, 0, 255);
		p5.rect(rectPosX1, rectPosY1, 400, 100, sideRect, sideRect, sideRect, sideRect);
		p5.rect(rectPosX1, rectPosY2, 400, 100, sideRect, sideRect, sideRect, sideRect);
		p5.rect(rectPosX1, rectPosY3, 400, 100, sideRect, sideRect, sideRect, sideRect);
		p5.rect(rectPosX2, rectPosY1, 400, 100, sideRect, sideRect, sideRect, sideRect);
		p5.rect(rectPosX2, rectPosY2, 400, 100, sideRect, sideRect, sideRect, sideRect);
		p5.rect(rectPosX2, rectPosY3, 400, 100, sideRect, sideRect, sideRect, sideRect);
		p5.fill(255);

		p5.textSize(32);
		for (int i = 0; i < LoadData.partyCounter; i++) {
			if (i == 0) {
				p5.text(LoadData.party_name.get(BasePokemon.PartyPos[i]), textX1, textY1);
			}
			if (i == 1) {
				p5.text(LoadData.party_name.get(BasePokemon.PartyPos[i]), textX2, textY1);
			}
			if (i == 2) {
				p5.text(LoadData.party_name.get(BasePokemon.PartyPos[i]), textX1, textY2);
			}
			if (i == 3) {
				p5.text(LoadData.party_name.get(BasePokemon.PartyPos[i]), textX2, textY2);
			}
			if (i == 4) {
				p5.text(LoadData.party_name.get(BasePokemon.PartyPos[i]), textX1, textY3);
			}
			if (i == 5) {
				p5.text(LoadData.party_name.get(BasePokemon.PartyPos[i]), textX2, textY3);
			}
		}

		for (int i = LoadData.partyCounter; i < 6; i++) {
			p5.textSize(25);
			p5.fill(255);
			if (i == 0) {
				p5.text("Empty Slot", textX1, textY1);
			}
			if (i == 1) {
				p5.text("Empty Slot", textX2, textY1);
			}
			if (i == 2) {
				p5.text("Empty Slot", textX1, textY2);
			}
			if (i == 3) {
				p5.text("Empty Slot", textX2, textY2);
			}
			if (i == 4) {
				p5.text("Empty Slot", textX1, textY3);
			}
			if (i == 5) {
				p5.text("Empty Slot", textX2, textY3);
			}
		}

		p5.textSize(20);
		if (InGame.swtch == 6) {
			p5.text("1) Press enter to pick first select a pokemon", 40,
					(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) - 40);
			p5.text("2) Press enter again to pick second select a pokemon", 40,
					(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)));
			p5.text("3) Press backspace to return to main menu", 40,
					(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) + 40);
		}
	}

	static void DrawWalkingPartyMenu() {
		p5.stroke(0);
		int sideRect = 20;
		BattleScene.Rectangle1H = 170;
		rectPosX1 = p5.width / 8 - 20;
		rectPosX2 = p5.width / 8 + 520;

		p5.fill(100, 100, 100);
		p5.rect(BattleScene.defaultRectangleX, BattleScene.defaultRectangleY, BattleScene.defaultRectangleW,
				BattleScene.defaultRectangleH, 20, 20, 0, 0);
		p5.rect(100, 20, 1000, 510, sideRect, sideRect, 0, 0);

		p5.fill(0, 0, 255);
		p5.rect(rectPosX1, rectPosY1, 400, 100, sideRect, sideRect, sideRect, sideRect);
		p5.rect(rectPosX1, rectPosY2, 400, 100, sideRect, sideRect, sideRect, sideRect);
		p5.rect(rectPosX1, rectPosY3, 400, 100, sideRect, sideRect, sideRect, sideRect);
		p5.rect(rectPosX2, rectPosY1, 400, 100, sideRect, sideRect, sideRect, sideRect);
		p5.rect(rectPosX2, rectPosY2, 400, 100, sideRect, sideRect, sideRect, sideRect);
		p5.rect(rectPosX2, rectPosY3, 400, 100, sideRect, sideRect, sideRect, sideRect);
		p5.fill(255);

		p5.textSize(32);
		LoadData.loadParty();
		for (int i = 0; i < LoadData.partyCounter; i++) {
			if (i == 0) {
				p5.text(LoadData.party_name.get(BasePokemon.PartyPos[i]), textX1, textY1);
			}
			if (i == 1) {
				p5.text(LoadData.party_name.get(BasePokemon.PartyPos[i]), textX2, textY1);
			}
			if (i == 2) {
				p5.text(LoadData.party_name.get(BasePokemon.PartyPos[i]), textX1, textY2);
			}
			if (i == 3) {
				p5.text(LoadData.party_name.get(BasePokemon.PartyPos[i]), textX2, textY2);
			}
			if (i == 4) {
				p5.text(LoadData.party_name.get(BasePokemon.PartyPos[i]), textX1, textY3);
			}
			if (i == 5) {
				p5.text(LoadData.party_name.get(BasePokemon.PartyPos[i]), textX2, textY3);
			}
		}

		for (int i = LoadData.partyCounter; i < 6; i++) {
			p5.textSize(25);
			p5.fill(255);
			if (i == 0) {
				p5.text("Empty Slot", textX1, textY1);
			}
			if (i == 1) {
				p5.text("Empty Slot", textX2, textY1);
			}
			if (i == 2) {
				p5.text("Empty Slot", textX1, textY2);
			}
			if (i == 3) {
				p5.text("Empty Slot", textX2, textY2);
			}
			if (i == 4) {
				p5.text("Empty Slot", textX1, textY3);
			}
			if (i == 5) {
				p5.text("Empty Slot", textX2, textY3);
			}

			p5.textSize(20);
			p5.text("1) Press enter to pick first select a pokemon", 370,
					(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) - 40);
			p5.text("2) Press enter again to pick second select a pokemon", 370,
					(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)));
			p5.text("3) Press backspace to return to main menu", 370,
					(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) + 40);

			p5.fill(255, 0, 0);
			if (InGame.excute == false) {
				Graphics.resetSquare();
				InGame.excute = true;
			}
			p5.rect(BattleScene.choicePosX, BattleScene.choicePosY, 10, 10, 10, 10, 10, 10);
		}
	}

	static void BattleResponse() {
		p5.stroke(0);
		p5.fill(255);
		if (InGame.swtch == 3) {
			p5.text("The wild " + LoadData.areaP_name.get(BasePokemon.wildID) + " used " + BasePokemon.WildMove, 40,
					(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) - 20);
			p5.text("Press backspace to return to take your turn: ", 40,
					(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) + 20);
		}

		if (InGame.swtch == 4) {
			p5.text("You have lost the battle", 40, (BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) - 20);
			p5.text("Press backspace to leave battle field and run to the hospital ", 40,
					(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) + 20);
		}

		if (InGame.swtch == 5) {
			p5.text("You beat the wild " + LoadData.areaP_name.get(BasePokemon.wildID), 40,
					(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) - 30);
			p5.text("Your " + LoadData.party_name.get(BasePokemon.PartyPos[0]) + " gained " + BasePokemon.XpGiven
					+ " xp", 40, (BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)));
			p5.text("Press backspace to leave battle field", 40,
					(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) + 30);
		}
	}

	static void resetSquare() {
		if (Pokemon.walkingView == true) {
			BattleScene.choicePosX = textX1 - 20;
			BattleScene.choicePosY = textY1 - 15;
		}

		else if (BattleScene.stop1 == false) {
			System.out.println("Done");
			BattleScene.choicePosX = BattleScene.textX1 - 15;
			BattleScene.choicePosY = BattleScene.textY1 - 12;
		}
		
		if (BattleScene.stop1 == false && InGame.swtch == 4) {
			System.out.println("Done");
			BattleScene.choicePosX = -20;
			BattleScene.choicePosY = -20;
		}
	}

	static void InGameMenu() {
		int sideRect = 20;
		p5.fill(150);
		p5.rect(width, height, 300, 400, sideRect, 0, 0, sideRect);

		p5.textSize(30);
		p5.fill(0);
		p5.text("Party", width + 50, textHeight1);
		p5.text("Save", width + 50, textHeight2);

		p5.fill(0);
		p5.rect(width + 30, rectHeight - 15, 10, 10, 10, 10, 10, 10);
	}

	static void DrawstartMenu() {
		int sideRect = 20;
		p5.fill(255);
		p5.rect(width, height, 300, 400, sideRect, 0, 0, sideRect);
		p5.fill(255, 0, 0);
		p5.textSize(20);
		p5.text("Press ENTER", width + 10, height + 50);
		p5.text("Continue saved game", width + 10, height + 70);
		p5.text("Press TAB", width + 10, height + 200);
		p5.text("Start a new game", width + 10, height + 230);

		if (MainMenu.newGame == true) {
			p5.fill(0, 255, 0);
			p5.rect(width - 300, height + 50, 300, 150);
			p5.fill(0, 0, 255);
			p5.text("Choose a starter pokemon:", width - 280, 185);
			p5.text("Press 1 for " + LoadData.start_name.get(0), width - 280, 215);
			p5.text("Press 2 for " + LoadData.start_name.get(1), width - 280, 245);
			p5.text("Press 3 for " + LoadData.start_name.get(2), width - 280, 275);
		}
	}
}