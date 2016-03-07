import processing.core.*;

public class BattleScene {
	Pokemon p5;
	float Rectangle1X, Rectangle1Y, defaultRectangleX, defaultRectangleY;
	float Rectangle1W, Rectangle1H, defaultRectangleW, defaultRectangleH;
	int poke_hp;
	String poke;

	BattleScene(Pokemon _p5){
		p5 = _p5;
		defaultRectangleH = 170;
		defaultRectangleX = 10;
		defaultRectangleW = p5.width - 20;
		defaultRectangleY = p5.height - (defaultRectangleH + 10);
	}
	
	void defaultDraw(){
		poke_hp = Pokemon.p_hp.get(50);
		
		p5.textSize(30);
		p5.stroke(0);
		p5.text(Pokemon.p_name.get(50), 620, 450);
		p5.text(Pokemon.p_name.get(3), 40, 40);
		p5.textSize(25);
		p5.text("Lvl: " + " variable", 620, 480);
		p5.text("HP: " + poke_hp, 620, 510);
		p5.text("Lvl: " + " variable", 40, 70);
		p5.text("HP: " + " variable", 40, 100);
		p5.stroke(255, 255, 255);
		p5.fill(255, 255,255);
		p5.rect(defaultRectangleX, defaultRectangleY, defaultRectangleW, defaultRectangleH, 20, 20, 20, 20);
		
	}
	
	void option1(){
		Rectangle1H = 150;
		Rectangle1W = 600;
		Rectangle1X = p5.width - (Rectangle1W + 20);
		Rectangle1Y = p5.height - (Rectangle1H + 20);
		
		//Menu rectangle
		p5.fill(150, 150, 150);
		p5.stroke(255, 0, 0);
		p5.rect(Rectangle1X, Rectangle1Y, Rectangle1W, Rectangle1H, 20, 20, 20, 20);
		
		p5.stroke(255,0, 0);
		p5.line(Rectangle1X + (Rectangle1W/2), Rectangle1Y, Rectangle1X + (Rectangle1W/2), p5.height - 10);
		p5.line(Rectangle1X, Rectangle1Y + (Rectangle1H/2), p5.width - 20, Rectangle1Y + (Rectangle1H/2));
		
		p5.textSize(20);
		p5.fill(0);
		p5.text("Fight", Rectangle1X + (Rectangle1H/4), Rectangle1Y + (Rectangle1H/4));
		p5.text("Pokemon", Rectangle1X + (Rectangle1W*3/4), Rectangle1Y + (Rectangle1H/4));
		p5.text("Run", Rectangle1X + (Rectangle1W*3/4), Rectangle1Y + (Rectangle1H*3/4));
		
		p5.text("Select an option!!!", defaultRectangleW / 4, defaultRectangleY + (defaultRectangleH/2));
		/*if(){
			opt1 = 1;
		}
		if(){
			opt1 = 2;
		}
		if(){
			opt1 = 3;
		}*/
	}
	
	void healthBar(){
		
	}
}

//Test to print pokemon name
//p5.text(Pokemon.p_name.get(150), 300, 300);