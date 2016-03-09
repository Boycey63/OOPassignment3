import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LoadData {
	Pokemon p5;
	String file;
	
	LoadData(Pokemon _p5){
		p5 = _p5;
	}	
	
	void loadParty(){
		file = "Party.csv";
		BufferedReader bs = null;
		String line;
		String split = ",";
		int lineNumber = 0;
		int tokenNumber = 0;
		
		try{
			bs = new BufferedReader(new FileReader(file));
			
			
			Pokemon.party_name = new ArrayList<String>();
			Pokemon.party_TOThp = new ArrayList<Integer>();
			Pokemon.party_ACThp = new ArrayList<Integer>();
			Pokemon.party_attack = new ArrayList<Integer>();
			Pokemon.party_defense = new ArrayList<Integer>();
			Pokemon.party_speed = new ArrayList<Integer>();
			Pokemon.party_special = new ArrayList<Integer>();
			Pokemon.party_total = new ArrayList<Integer>();
			Pokemon.party_id = new ArrayList<Integer>();
			
			//Checks if string is empty
			while((line = bs.readLine()) != null){
				//Divides each line into Tokens
				StringTokenizer str = new StringTokenizer(line, split);
				
				while(str.hasMoreTokens()){
					Pokemon.party_id.add(Integer.parseInt(str.nextToken()));
					Pokemon.party_name.add(str.nextToken());
					Pokemon.party_TOThp.add(Integer.parseInt(str.nextToken()));
					Pokemon.party_ACThp.add(Integer.parseInt(str.nextToken()));
					Pokemon.party_attack.add(Integer.parseInt(str.nextToken()));
					Pokemon.party_defense.add(Integer.parseInt(str.nextToken()));
					Pokemon.party_speed.add(Integer.parseInt(str.nextToken()));
					Pokemon.party_special.add(Integer.parseInt(str.nextToken()));
					Pokemon.party_total.add(Integer.parseInt(str.nextToken()));
					tokenNumber++;
			}
			
			lineNumber++;
			tokenNumber = 0;
			}
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
			if(bs != null){
				try{
					bs.close();
				}
				//else throw an exception
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	void loadPokeArea(){
		file = "Area1.csv";
		BufferedReader bs = null;
		String line;
		String split = ",";
		int lineNumber = 0;
		int tokenNumber = 0;
		
		try{
			bs = new BufferedReader(new FileReader(file));
			Pokemon.p_name = new ArrayList<String>();
			Pokemon.p_id = new ArrayList<Integer>();
			Pokemon.p_name = new ArrayList<String>();
			Pokemon.p_TOThp = new ArrayList<Integer>();
			Pokemon.p_ACThp = new ArrayList<Integer>();
			Pokemon.p_attack = new ArrayList<Integer>();
			Pokemon.p_defense = new ArrayList<Integer>();
			Pokemon.p_speed = new ArrayList<Integer>();
			Pokemon.p_special = new ArrayList<Integer>();
			Pokemon.p_total = new ArrayList<Integer>();
			
			//Checks if string is empty
			while((line = bs.readLine()) != null){

				//Divides each line into Tokens
				StringTokenizer st = new StringTokenizer(line,split);
				//Pokemon.p_name.add(line);
				
				while(st.hasMoreTokens()){
					Pokemon.p_id.add(Integer.parseInt(st.nextToken()));
					Pokemon.p_name.add(st.nextToken());
					Pokemon.p_TOThp.add(Integer.parseInt(st.nextToken()));
					Pokemon.p_ACThp.add(Integer.parseInt(st.nextToken()));
					Pokemon.p_attack.add(Integer.parseInt(st.nextToken()));
					Pokemon.p_defense.add(Integer.parseInt(st.nextToken()));
					Pokemon.p_speed.add(Integer.parseInt(st.nextToken()));
					Pokemon.p_special.add(Integer.parseInt(st.nextToken()));
					Pokemon.p_total.add(Integer.parseInt(st.nextToken()));
					tokenNumber++;
			}
			lineNumber++;
			tokenNumber = 0;
			}
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
			if(bs != null){
				try{
					bs.close();
				}
				//else throw an exception
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
}