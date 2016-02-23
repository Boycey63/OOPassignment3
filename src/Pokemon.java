import processing.core.*;

public class Pokemon extends PApplet
{
	public static void main(String args[]) 
	{
	   PApplet.main(new String[] { "--present", "Pokemon" });
	}
	
	public void settings()
	{
		size(600,600);
	}
	
	public void setup()
	{
		background(255,0,0);
	}
	
	public void draw()
	{
		stroke(255);
		line(0,0,mouseX,mouseY);
	}
}