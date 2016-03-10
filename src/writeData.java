import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;

public class writeData {
	String file;

	writeData() {

	}

	void addToParty() {
		String line = "";
		String split = ",";
		int lineNumber = 0;
		int tokenNumber = 0;
		BufferedWriter bw = null;

		try {
			File file = new File("Party.csv");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			for (int i = 0; i < Pokemon.partyCounter; i++) {
				StringBuilder createLine = new StringBuilder();
				createLine.append((Pokemon.party_id.get(i)) + ",");
				createLine.append(Pokemon.party_name.get(i) + ",");
				createLine.append(Pokemon.party_TOThp.get(i) + ",");
				createLine.append(Pokemon.party_ACThp.get(i) + ",");
				createLine.append(Pokemon.party_attack.get(i) + ",");
				createLine.append(Pokemon.party_defense.get(i) + ",");
				createLine.append(Pokemon.party_speed.get(i) + ",");
				createLine.append(Pokemon.party_special.get(i) + ",");
				createLine.append(Pokemon.party_total.get(i) + "");

				String finishedLine = createLine.toString();
				bw.write(finishedLine);
				bw.newLine();
			}

			if (Pokemon.partyCounter < 6) {
				StringBuilder makeLine = new StringBuilder();
				makeLine.append(Pokemon.p_id.get(Pokemon.partyCounter) + ",");
				makeLine.append(Pokemon.p_name.get(Pokemon.wildPokemon) + ",");
				makeLine.append(Pokemon.p_TOThp.get(Pokemon.wildPokemon) + ",");
				makeLine.append(Pokemon.p_ACThp.get(Pokemon.wildPokemon) + ",");
				makeLine.append(Pokemon.p_attack.get(Pokemon.wildPokemon) + ",");
				makeLine.append(Pokemon.p_defense.get(Pokemon.wildPokemon) + ",");
				makeLine.append(Pokemon.p_speed.get(Pokemon.wildPokemon) + ",");
				makeLine.append(Pokemon.p_special.get(Pokemon.wildPokemon) + ",");
				makeLine.append(Pokemon.p_total.get(Pokemon.wildPokemon) + "");

				String newLine = makeLine.toString();

				bw.write(newLine);
			}
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error in closing the BufferedWriter" + ex);
			}
		}
	}
}
