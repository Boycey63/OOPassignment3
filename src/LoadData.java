import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LoadData {
	Pokemon p5;
	
	LoadData(Pokemon _p5){
		p5 = _p5;
	}
	
	void loadfile(){
		String pokedex = "Pokedex.csv";
		BufferedReader br = null;
		String line = "";
		String split = ",";
		int lineNumber = 0;
		int tokenNumber = 0;
		int counter = 0;
		
		//Tries to initalise the variables and run loop 
		try{
			br = new BufferedReader(new FileReader(pokedex));
			Pokemon.pokemon = new ArrayList();
			Pokemon.p_name = new ArrayList();
			Pokemon.p_hp = new ArrayList();
			Pokemon.p_attack = new ArrayList();
			Pokemon.p_defense = new ArrayList();
			Pokemon.p_speed = new ArrayList();
			Pokemon.p_special = new ArrayList();
			Pokemon.p_total = new ArrayList();
			Pokemon.p_average = new ArrayList();
			Pokemon.p_id = new ArrayList();
			
			//Checks if string is empty
			while((line = br.readLine()) != null){
				//Divides each line into Tokens
				StringTokenizer st = new StringTokenizer(line,split);
				
				//Inserts each token into a different araylist
				while(st.hasMoreTokens()){
					Pokemon.pokemon.add(st.nextToken());
					Pokemon.p_name.add(st.nextToken());
					Pokemon.p_hp.add(st.nextToken());
					Pokemon.p_attack.add(st.nextToken());
					Pokemon.p_defense.add(st.nextToken());
					Pokemon.p_speed.add(st.nextToken());
					Pokemon.p_special.add(st.nextToken());
					Pokemon.p_total.add(st.nextToken());
					Pokemon.p_average.add(st.nextToken());
					Pokemon.p_id.add(st.nextToken());
					tokenNumber++;
				}
				lineNumber++;
				tokenNumber = 0;
			}
			
			//Displays what is the arraylists
			/*for(counter=0; counter < Pokemon.p_name.size(); counter++){
				System.out.println(Pokemon.p_name.get(counter));
				System.out.println(Pokemon.p_hp.get(counter));
				System.out.println(Pokemon.p_attack.get(counter));
				System.out.println(Pokemon.p_defense.get(counter));
				System.out.println(Pokemon.p_speed.get(counter));
				System.out.println(Pokemon.p_special.get(counter));
				System.out.println(Pokemon.p_total.get(counter));
				System.out.println(Pokemon.p_average.get(counter));
				System.out.println(Pokemon.p_id.get(counter));
			}*/
		}
		
		//If the above doesn't work, show an error
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		//Once complete if the bufferedreader is not empty close it
		finally{
			if(br != null){
				try{
					br.close();
				}
				//else throw an exception
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
}