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

			for (int i = 0; i < LoadData.partyCounter; i++) {
				StringBuilder createLine = new StringBuilder();
				createLine.append((LoadData.party_id.get(i)) + ",");
				createLine.append(LoadData.party_name.get(i) + ",");
				createLine.append(LoadData.party_TOThp.get(i) + ",");
				createLine.append(LoadData.party_ACThp.get(i) + ",");
				createLine.append(LoadData.party_attack.get(i) + ",");
				createLine.append(LoadData.party_defense.get(i) + ",");
				createLine.append(LoadData.party_speed.get(i) + ",");
				createLine.append(LoadData.party_special.get(i) + ",");
				createLine.append(LoadData.party_total.get(i) + "");

				String finishedLine = createLine.toString();
				bw.write(finishedLine);
				bw.newLine();
			}

			if (LoadData.partyCounter < 6) {
				StringBuilder makeLine = new StringBuilder();
				makeLine.append(LoadData.p_id.get(LoadData.partyCounter) + ",");
				makeLine.append(LoadData.p_name.get(BattleScene.wildPokemon) + ",");
				makeLine.append(LoadData.p_TOThp.get(BattleScene.wildPokemon) + ",");
				makeLine.append(LoadData.p_ACThp.get(BattleScene.wildPokemon) + ",");
				makeLine.append(LoadData.p_attack.get(BattleScene.wildPokemon) + ",");
				makeLine.append(LoadData.p_defense.get(BattleScene.wildPokemon) + ",");
				makeLine.append(LoadData.p_speed.get(BattleScene.wildPokemon) + ",");
				makeLine.append(LoadData.p_special.get(BattleScene.wildPokemon) + ",");
				makeLine.append(LoadData.p_total.get(BattleScene.wildPokemon) + "");

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
