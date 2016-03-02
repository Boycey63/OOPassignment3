import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.io.InputStream;
//import processing.core.*;

public class LoadData {
	Pokemon p5;
	String comma = ",";
	
	int poke_id = 0;
	int poke_name = 1;
	int poke_hp = 2;
	int poke_attack = 3;
	int poke_defense = 4;
	int poke_speed = 5;
	int poke_special = 6;
	int poke_total = 7;
	int poke_average = 8;
	
	LoadData(Pokemon _p5){
		p5 = _p5;
	}
	
	static void loadfile(){
		String pokedex = "Pokedex.csv";
		BufferedReader br = null;
		String line = "";
		String split = ",";
		
		try{
			//InputStream inputStream = getClass().getClassLoader().getResourceAsStream(pokedex)
			br = new BufferedReader(new FileReader(pokedex));
			
			while((line = br.readLine()) != null){
				String[] pokemon = line.split(split);
				
				//System.out.println(pokemon[1]);
			}
		}
		
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			if(br != null){
				try{
					br.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
}