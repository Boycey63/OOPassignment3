import processing.core.*;

public class Graphics {

	static Pokemon p5;

	Graphics(Pokemon _p5) {
		p5 = _p5;
	}

	// Drawings for walk mode
	public static void displayMap() {
		// Bottom
		p5.image(InGame.map2, 0, 0);

		// Top
		p5.image(InGame.map1, 0, 0);
	}

	public static void displayCharacter() {
		p5.image(InGame.character, InGame.characterX, InGame.characterY);
		InGame.topR = InGame.characterX + InGame.character.width;
		InGame.bottomL = InGame.characterY + InGame.character.height;
	}

	// Drawings for battle mode
	//Default battle menu...will be drawn no matter what
	static void DrawDefaultBattleMenu() {
		p5.background(180);
		p5.stroke(0);
		p5.fill(0);
		p5.image(BattleScene.background, 0, 0);
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
		p5.text(LoadData.areaP_name.get(BattleScene.wildPokemon), 40, 40);
		p5.textSize(25);
		p5.text("Lvl: " + BattleScene.wildLvL, 40, 70);
		p5.text("HP: " + BattleScene.wildActHP, 40, 100);
		// Draw rectangle
		p5.stroke(255, 255, 255);
		p5.fill(100, 100, 100);
		p5.rect(BattleScene.defaultRectangleX, BattleScene.defaultRectangleY, BattleScene.defaultRectangleW,
				BattleScene.defaultRectangleH, 20, 20, 0, 0);
	}
	
	//battleMenu1 will be drawn if user hasn't selected a starting choice 
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
		p5.text("Press enter to chose an option: ", 40, (BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)));

		p5.textSize(20);
		p5.fill(0);

		p5.text("Fight", BattleScene.textX1, BattleScene.textY1);
		p5.text("Catch", BattleScene.textX1, BattleScene.textY2);
		p5.text("Pokemon", BattleScene.textX2, BattleScene.textY1);
		p5.text("Run", BattleScene.textX2, BattleScene.textY2);

		p5.rect(BattleScene.choicePosX, BattleScene.choicePosY, 10, 10);
	}
	
	// Will draw if user choses the attack option
	static void DrawAttackMenu(){
		BattleScene.Rectangle1H = 150;
		BattleScene.Rectangle1W = 600;
		BattleScene.Rectangle1X = p5.width - (BattleScene.Rectangle1W + 10);
		BattleScene.Rectangle1Y = p5.height - (BattleScene.Rectangle1H + 10);

		// Menu rectangle
		p5.fill(150, 150, 150);
		p5.stroke(255, 0, 0);
		p5.rect(BattleScene.Rectangle1X, BattleScene.Rectangle1Y, BattleScene.Rectangle1W, BattleScene.Rectangle1H, 20, 20, 20, 20);
		p5.stroke(255, 0, 0);
		p5.line(BattleScene.Rectangle1X + (BattleScene.Rectangle1W / 2), BattleScene.Rectangle1Y, BattleScene.Rectangle1X + (BattleScene.Rectangle1W / 2), p5.height - 10);
		p5.line(BattleScene.Rectangle1X, BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2), p5.width - 10, BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2));

		p5.text("Press enter to chose a move: ", 40, (BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) - 20);
		p5.text("Press backspace to return to option menu: ", 40, (BattleScene.Rectangle1Y + (BattleScene.Rectangle1H / 2)) + 20);

		p5.textSize(20);
		p5.fill(0);
		p5.text(LoadData.name_move1.get(0), BattleScene.textX1, BattleScene.textY1);
		p5.text(LoadData.name_move3.get(0), BattleScene.textX1, BattleScene.textY2);
		p5.text(LoadData.name_move2.get(0), BattleScene.textX2, BattleScene.textY1);
		p5.text(LoadData.name_move4.get(0), BattleScene.textX2, BattleScene.textY2);
		
		p5.rect(BattleScene.choicePosX, BattleScene.choicePosY, 10, 10);
	}
	
	static void DrawPartyMenu() {

	}
}
