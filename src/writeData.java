import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;

public class writeData {
	String file;
	public static int partySize;

	writeData() {
		partySize = 6;
	}

	public static void addToParty() {
		BufferedWriter bw = null;

		try {
			File file = new File("Party.csv");

			// Checks if file exists and if not creates the file
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			// Writes previous party into new file
			// Goes through arraylists with for loop
			for (int i = 0; i < LoadData.partyCounter; i++) {
				StringBuilder createLine = new StringBuilder();
				createLine.append(LoadData.party_id.get(i) + ",");
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

			// If there is less than six in party will write new pokemon
			if (LoadData.partyCounter < partySize) {
				StringBuilder makeLine = new StringBuilder();
				// wildTotHP, wildActHP, wildAttack, wildDefense, wildSpeed,
				// wildSpecial
				makeLine.append(LoadData.p_id.get(LoadData.partyCounter) + ",");
				makeLine.append(LoadData.p_name.get(BattleScene.wildPokemon) + ",");
				makeLine.append(BattleScene.wildTotHP + ",");
				makeLine.append(BattleScene.wildActHP + ",");
				makeLine.append(BattleScene.wildAttack + ",");
				makeLine.append(BattleScene.wildDefense + ",");
				makeLine.append(BattleScene.wildSpeed + ",");
				makeLine.append(BattleScene.wildSpecial + ",");
				makeLine.append(BattleScene.wildTotal + "");
				System.out.println("You caught : " + LoadData.p_name.get(BattleScene.wildPokemon));

				String newLine = makeLine.toString();

				bw.write(newLine);
			}

			else {
				System.out.println("Your party is full");
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

	public static void newParty() {
		// write pokemon to party
		BufferedWriter bw = null;

		try {
			File file = new File("Party.csv");

			// Checks if file exists and if not creates the file
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			StringBuilder makeLine = new StringBuilder();

			makeLine.append(LoadData.start_id.get(LoadData.partyCounter) + ",");
			makeLine.append(LoadData.start_name.get(MainMenu.chosenPok) + ",");
			makeLine.append(LoadData.start_TOThp.get(MainMenu.chosenPok) + ",");
			makeLine.append(LoadData.start_ACThp.get(MainMenu.chosenPok) + ",");
			makeLine.append(LoadData.start_attack.get(MainMenu.chosenPok) + ",");
			makeLine.append(LoadData.start_defense.get(MainMenu.chosenPok) + ",");
			makeLine.append(LoadData.start_speed.get(MainMenu.chosenPok) + ",");
			makeLine.append(LoadData.start_special.get(MainMenu.chosenPok) + ",");
			makeLine.append(LoadData.start_total.get(MainMenu.chosenPok) + "");

			String newLine = makeLine.toString();

			bw.write(newLine);
		} catch (IOException e) {
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

	public static void saveGame() {
		BufferedWriter bw = null;

		try {
			File file = new File("SavedGame.csv");

			// Checks if file exists and if not creates the file
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			StringBuilder makeLine = new StringBuilder();
			makeLine.append(InGame.location + ",");
			makeLine.append(InGame.characterX + ",");
			makeLine.append(InGame.characterY + ",");
			makeLine.append(InGame.tempMovement);

			String newLine = makeLine.toString();

			bw.write(newLine);
		} catch (IOException e) {
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
