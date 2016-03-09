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
		Pokemon.wildPokemon = p5.floor(p5.random(0,5));
	}
	
	void defaultDraw(){
		//poke_hp = Pokemon.p_ACThp.get(1);
		
		p5.textSize(30);
		p5.stroke(0);
		p5.fill(0);
		//User Pokemon
		p5.text(Pokemon.party_name.get(0), 620, 450);
		//Wild Pokemon
		p5.text(Pokemon.p_name.get(Pokemon.wildPokemon), 40, 40);
		p5.textSize(25);
		p5.text("Lvl: " + " variable", 620, 480);
		p5.text("HP: " + poke_hp, 620, 510);
		p5.text("Lvl: " + " variable", 40, 70);
		p5.text("HP: " + " variable", 40, 100);
		p5.stroke(255, 255, 255);
		p5.fill(255, 255,255);
		p5.rect(defaultRectangleX, defaultRectangleY, defaultRectangleW, defaultRectangleH, 20, 20, 20, 20);
	}
	
	void menu1(){
		Rectangle1H = 150;
		Rectangle1W = 600;
		Rectangle1X = p5.width - (Rectangle1W + 20);
		Rectangle1Y = p5.height - (Rectangle1H + 20);
		
		//Menu rectangle
		p5.fill(150, 150, 150);
		p5.stroke(255, 0, 0);
		p5.rect(Rectangle1X, Rectangle1Y, Rectangle1W, Rectangle1H, 20, 20, 20, 20);
		p5.stroke(255,0, 0);
		p5.line(Rectangle1X + (Rectangle1W/2), Rectangle1Y, Rectangle1X + (Rectangle1W/2), p5.height - 20);
		p5.line(Rectangle1X, Rectangle1Y + (Rectangle1H/2), p5.width - 20, Rectangle1Y + (Rectangle1H/2));
		
		p5.textSize(20);
		p5.fill(0);
		if(Pokemon.opt == 0){
		p5.text("Fight", Rectangle1X + (Rectangle1W/4) - 60, Rectangle1Y + (Rectangle1H/4));
		}
		if(Pokemon.opt == 1){
			p5.text("Back", Rectangle1X + (Rectangle1W/4) - 60, Rectangle1Y + (Rectangle1H/4));
		}
		p5.text("Pokemon", Rectangle1X + (Rectangle1W*3/4) - 60, Rectangle1Y + (Rectangle1H/4));
		p5.text("Run", Rectangle1X + (Rectangle1W*3/4) - 60, Rectangle1Y + (Rectangle1H*3/4));
		
		if(p5.mouseX > (Rectangle1X) && p5.mouseX < (Rectangle1X + (Rectangle1W/2)) && p5.mouseY > (Rectangle1Y) && p5.mouseY < (Rectangle1Y + Rectangle1H)){
			//if(mousePressed)
			if(p5.key == 'e')
			{
				//p5.background(0,0,0);
				Pokemon.opt = 1;
				p5.mouseX = 0;
				p5.mouseY = 0;
				if(p5.mousePressed && Pokemon.opt == 1){
					//p5.background(0,255,0);
					Pokemon.opt = 0;
				}
			}
		}
		if(p5.mouseX > (Rectangle1X + (Rectangle1W/2)) && p5.mouseX < (Rectangle1X + Rectangle1W) && p5.mouseY > (Rectangle1Y) && p5.mouseY < (Rectangle1Y + Rectangle1H)){
			Pokemon.opt = 2;
		}
		
		if(p5.mouseX > Rectangle1X && p5.mouseX < (Rectangle1X + (Rectangle1W/2)) && p5.mouseY > (Rectangle1Y + (Rectangle1H/2)) && p5.mouseY < (Rectangle1Y + Rectangle1H)){
			Pokemon.opt = 3;
		}
		if(p5.mouseX > (Rectangle1X + (Rectangle1W/2)) && p5.mouseX < (Rectangle1X + Rectangle1W) && p5.mouseY > (Rectangle1Y + (Rectangle1H/2)) && p5.mouseY < (Rectangle1Y + Rectangle1H)){
			Pokemon.opt = 4;
		}
	}
	
	void menu2(){
		Rectangle1H = 120;
		Rectangle1W = 350;
		Rectangle1X = p5.width/7 + 59;
		Rectangle1Y = p5.height - (Rectangle1H + 35);
		
		//Menu rectangle
		p5.fill(150, 150, 150);
		p5.stroke(255, 0, 0);
		p5.rect(Rectangle1X, Rectangle1Y, Rectangle1W, Rectangle1H, 20, 0, 0, 20);
		p5.stroke(255,0, 0);
		p5.line(Rectangle1X + (Rectangle1W/2), Rectangle1Y, Rectangle1X + (Rectangle1W/2), p5.height - 35);
		p5.line(Rectangle1X, Rectangle1Y + (Rectangle1H/2), Rectangle1X + (Rectangle1W), Rectangle1Y + (Rectangle1H/2));
		
		p5.fill(0, 0, 0);
		p5.text("Move 1", Rectangle1X + (Rectangle1W/4 - 40), Rectangle1Y + (Rectangle1H/4));
		p5.text("Move 2", Rectangle1X + (Rectangle1W*3/4 - 40), Rectangle1Y + (Rectangle1H/4));
		p5.text("Move 3", Rectangle1X + (Rectangle1W/4 - 40), Rectangle1Y + (Rectangle1H*3/4));
		p5.text("Move 4", Rectangle1X + (Rectangle1W*3/4) -40, Rectangle1Y + (Rectangle1H*3/4));
	}
	
	void partyMenu(){
		
	}
	
	void throwBall(){
		
	}
}