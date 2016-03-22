import processing.core.*;

public class MainMenu {
	Pokemon p5;
	PImage pic;
	
	MainMenu(Pokemon _p5){
		p5 = _p5;
		pic = p5.loadImage("menuPic.jpg");
	}
	
	void gameMenu(){
		p5.image(pic, 0, 0);
		
		if(p5.key == p5.ENTER){
			Pokemon.walkingView = true;
			p5.key = 'm';
		}
	}
}
