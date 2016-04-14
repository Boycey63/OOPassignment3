//Make the low lvl of wild pokemon as average of party pokemon

public class Graphics {

	static Pokemon p5;
	static float rectPosX1, rectPosX2;
	static float rectPosY1, rectPosY2, rectPosY3;

	Graphics(Pokemon _p5) {
		p5 = _p5;
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
		if (InGame.swtch != 2) {
			p5.background(180);
			p5.stroke(0);
			p5.fill(0);
			p5.image(BattleScene.background, 0, 0);
			if (InGame.swtch != 4) {
				// User Pokemon Info
				p5.textSize(30);
				p5.text(LoadData.party_name.get(0), 620, 430);
				p5.textSize(25);
				p5.text("Lvl: " + LoadData.party_lvl.get(0), 620, 460);
				p5.text("HP: " + LoadData.party_ACThp.get(0), 620, 490);
				p5.text("Cur XP: " + LoadData.party_CurXP.get(0), 620, 520);
				p5.text("Next XP: " + (LoadData.party_xpNextLvl.get(0) - LoadData.party_TOTxp.get(0)), 900, 520);
				// Wild Pokemon Info
				p5.textSize(30);
				p5.text(LoadData.areaP_name.get(BasePokemon.wildID), 40, 40);
				p5.textSize(25);
				p5.text("Lvl: " + BasePokemon.wildLvL, 40, 70);
				p5.text("HP: " + BasePokemon.wildActHP, 40, 100);
			}
		}
		// Draw rectangle
		p5.stroke(255, 255, 255);
		p5.fill(100, 100, 100);
		p5.rect(BattleScene.defaultRectangleX, BattleScene.defaultRectangleY, BattleScene.defaultRectangleW,
				BattleScene.defaultRectangleH, 20, 20, 0, 0);
	}

	// battleMenu1 will be drawn if user hasn't selected a starting choice
	static void DrawBattleMenu1() {
		BattleScene.Rectangle1H = 150;
		BattleScene.Rectangle1W = 600;
		BattleScene.Rectangle1X = p5.width - (BattleScene.Rectangle1W + 10);
		BattleScene.Rectangle1Y = p5.height - (BattleScene.Rectangle1H + 10);

		// Menu rectangle
		p5.fill(150, 150, 150);
		p5.stroke(255, 0, 0);
		p5.rect(BattleScene.Rectangle1X, BattleScene.Rectangle1Y, BattleScene.Rectangle1W, BattleScene.Rectangle1H, 20,
				20, 20, 20);
		p5.stroke(255, 0, 0);
		p5.line(BattleScene.Rectangle1X + (BattleScene.Rectangle1W / 2), BattleScene.Rectangle1Y,
				BattleScene.Rectangle1X + (BattleScene.Rectangle1W / 2), p5.height - 10);
		p5.line(BattleScene.Rectangle1X, BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2), p5.width - 10,
				BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2));
		p5.fill(0);

		if (InGame.swtch != 3 && InGame.swtch != 5) {
			p5.rect(BattleScene.choicePosX, BattleScene.choicePosY, 10, 10);
		}

		if (InGame.swtch == 0) {
			p5.text("Press enter to chose an option: ", 40, (BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)));
			p5.textSize(20);
			p5.fill(0);
			p5.text("Fight", BattleScene.textX1, BattleScene.textY1);
			p5.text("Catch", BattleScene.textX1, BattleScene.textY2);
			p5.text("Pokemon", BattleScene.textX2, BattleScene.textY1);
			p5.text("Run", BattleScene.textX2, BattleScene.textY2);
		}

		if (InGame.swtch == 1) {
			p5.text("Press enter to chose a move: ", 40,
					(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) - 20);
			p5.text("Press backspace to return to option menu: ", 40,
					(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) + 20);
			p5.textSize(20);
			p5.fill(0);
			p5.text(LoadData.name_move1.get(0), BattleScene.textX1, BattleScene.textY1);
			p5.text(LoadData.name_move3.get(0), BattleScene.textX1, BattleScene.textY2);
			p5.text(LoadData.name_move2.get(0), BattleScene.textX2, BattleScene.textY1);
			p5.text(LoadData.name_move4.get(0), BattleScene.textX2, BattleScene.textY2);
		}

		if (InGame.swtch == 2) {

		}
	}

	static void DrawPartyMenu() {
		int sideRect = 20;
		BattleScene.Rectangle1H = 170;
		rectPosX1 = p5.width / 8 - 20;
		rectPosX2 = p5.width / 8 + 520;
		rectPosY1 = (p5.height - BattleScene.defaultRectangleH) / 10 - 5;
		rectPosY2 = (p5.height - BattleScene.defaultRectangleH) / 10 - 5 + 170;
		rectPosY3 = (p5.height - BattleScene.defaultRectangleH) / 10 - 5 + 340;

		p5.background(255, 0, 0);
		DrawDefaultBattleMenu();
		p5.text("Press enter to chose an option: ", 40, (BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) - 20);
		p5.text("Press backspace to return to option menu: ", 40,
				(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) + 20);
		p5.textSize(20);
		p5.fill(0);
		p5.text("Op 1", BattleScene.textX1, BattleScene.textY1);
		p5.text("Op 2", BattleScene.textX1, BattleScene.textY2);
		p5.text("Op 3", BattleScene.textX2, BattleScene.textY1);
		p5.text("Op 4", BattleScene.textX2, BattleScene.textY2);
		
		p5.rect(rectPosX1, rectPosY1, 400, 100, sideRect, sideRect, sideRect, sideRect);
		p5.rect(rectPosX1, rectPosY2, 400, 100, sideRect, sideRect, sideRect, sideRect);
		p5.rect(rectPosX1, rectPosY3, 400, 100, sideRect, sideRect, sideRect, sideRect);
		p5.fill(0, 255, 0);
		p5.rect(rectPosX2, rectPosY1, 400, 100, sideRect, sideRect, sideRect, sideRect);
		p5.rect(rectPosX2, rectPosY2, 400, 100, sideRect, sideRect, sideRect, sideRect);
		p5.rect(rectPosX2, rectPosY3, 400, 100, sideRect, sideRect, sideRect, sideRect);
		
		if(InGame.swtch == 6){
			BattleScene.choicePosX  = rectPosX1;
			BattleScene.choicePosY = rectPosY1 + 50;
			p5.rect(BattleScene.choicePosX, BattleScene.choicePosY, 10, 10);
		}
	}

	static void BattleResponse() {
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
			p5.text("Your " + LoadData.party_name.get(0) + " gained " + BasePokemon.XpGiven + " xp", 40,
					(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)));
			p5.text("Press backspace to leave battle field", 40,
					(BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) + 30);
		}
	}

	static void keyPressed() {
		
	}
}