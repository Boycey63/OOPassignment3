import processing.core.*;

public class BattleScene {
	Pokemon p5;
	float opt1X, opt1Y;
	float opt1width, opt1height;
	int opt1;
	String poke;

	BattleScene(Pokemon _p5){
		p5 = _p5;
		opt1 = 0;
		opt1width = 600;
		opt1height = 150;
		opt1X = p5.width - opt1width;
		opt1Y = p5.height - opt1height;
	}
	
	void option1(){
		p5.stroke(255, 255, 255);
		p5.fill(255, 255,255);
		p5.rect(opt1X, opt1Y, opt1width, opt1height);
		
		p5.stroke(0);
		p5.line(opt1X + (opt1width/2), opt1Y, opt1X + (opt1width/2), p5.height);
		p5.line(opt1X, opt1Y + (opt1height/2), p5.width, opt1Y + (opt1height/2));
		
		p5.textSize(20);
		p5.fill(0);
		p5.text("Attack", opt1X + (opt1width/4), opt1Y + (opt1height/4));
		p5.text("Pokemon", opt1X + (opt1width*3/4), opt1Y + (opt1height/4));
		p5.text("Run", opt1X + (opt1width*3/4), opt1Y + (opt1height*3/4));
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
}

//Test to print pokemon name
//p5.text(Pokemon.p_name.get(150), 300, 300);