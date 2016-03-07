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
			Pokemon.pokemon = new ArrayList<String>();
			Pokemon.p_name = new ArrayList<String>();
			Pokemon.p_hp = new ArrayList<Integer>();
			Pokemon.p_attack = new ArrayList<Integer>();
			Pokemon.p_defense = new ArrayList<Integer>();
			Pokemon.p_speed = new ArrayList<Integer>();
			Pokemon.p_special = new ArrayList<Integer>();
			Pokemon.p_total = new ArrayList<Integer>();
			Pokemon.p_average = new ArrayList<Float>();
			Pokemon.p_id = new ArrayList<Integer>();
			
			//Checks if string is empty
			while((line = br.readLine()) != null){
				//Divides each line into Tokens
				StringTokenizer st = new StringTokenizer(line,split);
				
				//Inserts each token into a different arraylist
				while(st.hasMoreTokens()){
					Pokemon.pokemon.add(st.nextToken());
					Pokemon.p_name.add(st.nextToken());
					Pokemon.p_hp.add(Integer.parseInt(st.nextToken()));
					Pokemon.p_attack.add(Integer.parseInt(st.nextToken()));
					Pokemon.p_defense.add(Integer.parseInt(st.nextToken()));
					Pokemon.p_speed.add(Integer.parseInt(st.nextToken()));
					Pokemon.p_special.add(Integer.parseInt(st.nextToken()));
					Pokemon.p_total.add(Integer.parseInt(st.nextToken()));
					Pokemon.p_average.add(Float.parseFloat(st.nextToken()));
					Pokemon.p_id.add(Integer.parseInt(st.nextToken()));
					tokenNumber++;
				}
				lineNumber++;
				tokenNumber = 0;
			}
			
			
			//int po = Pokemon.p_speed.get(2);
			//System.out.println(po);
			
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