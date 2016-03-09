import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import com.opencsv.*;

public class writeData {
	String file;
	
	writeData(){
		
	}
	
	void addToParty(){
		String line = "";
		String split = ",";
		int lineNumber = 0;
		int tokenNumber = 0;
		BufferedWriter bw = null;
		
		try {
			File file = new File("Party.csv");
			StringBuilder makeLine = new StringBuilder();
			
			makeLine.append(Pokemon.p_id.get(Pokemon.wildPokemon) + ",");
			makeLine.append(Pokemon.p_name.get(Pokemon.wildPokemon) + ",");
			makeLine.append(Pokemon.p_TOThp.get(Pokemon.wildPokemon) + ",");
			makeLine.append(Pokemon.p_ACThp.get(Pokemon.wildPokemon) + ",");
			makeLine.append(Pokemon.p_attack.get(Pokemon.wildPokemon) + ",");
			makeLine.append(Pokemon.p_defense.get(Pokemon.wildPokemon) + ",");
			makeLine.append(Pokemon.p_speed.get(Pokemon.wildPokemon) + ",");
			makeLine.append(Pokemon.p_special.get(Pokemon.wildPokemon) + ",");
			makeLine.append(Pokemon.p_total.get(Pokemon.wildPokemon) + "");
			
			String newLine = makeLine.toString();
			
			if (!file.exists()) {
			     file.createNewFile();
			  }
			
			FileWriter fw = new FileWriter(file);
			
			bw = new BufferedWriter(fw);
			bw.write(newLine);
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{ 
		   try{
		      if(bw!=null)
			 bw.close();
		   }catch(Exception ex){
		       System.out.println("Error in closing the BufferedWriter"+ex);
		    }
		}
	}
}
