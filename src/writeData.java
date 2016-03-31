import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;

public class writeData {
	static Pokemon p5;
	String file;
	public static int partySize;

	writeData(Pokemon _p5) {
		p5 = _p5;
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
				createLine.append(LoadData.party_xpNextLvl.get(i) + ",");
				createLine.append(LoadData.party_TOTxp.get(i) + ",");
				createLine.append(LoadData.party_lvl.get(i) + ",");
				createLine.append(LoadData.party_hpIV.get(i) + ",");
				createLine.append(LoadData.party_attackIV.get(i) + ",");
				createLine.append(LoadData.party_defenseIV.get(i) + ",");
				createLine.append(LoadData.party_speedIV.get(i) + ",");
				createLine.append(LoadData.party_specialIV.get(i) + ",");
				createLine.append(LoadData.party_hpEV.get(i) + ",");
				createLine.append(LoadData.party_attackEV.get(i) + ",");
				createLine.append(LoadData.party_defenseEV.get(i) + ",");
				createLine.append(LoadData.party_speedEV.get(i) + ",");
				createLine.append(LoadData.party_specialEV.get(i) + ",");
				createLine.append(LoadData.party_BaseExp.get(i) + ",");
				createLine.append(LoadData.name_move1.get(i) + ",");
				createLine.append(LoadData.PP_move1.get(i) + ",");
				createLine.append(LoadData.attPower_move1.get(i) + ",");
				createLine.append(LoadData.name_move2.get(i) + ",");
				createLine.append(LoadData.PP_move2.get(i) + ",");
				createLine.append(LoadData.attPower_move2.get(i) + ",");
				createLine.append(LoadData.name_move3.get(i) + ",");
				createLine.append(LoadData.PP_move3.get(i) + ",");
				createLine.append(LoadData.attPower_move3.get(i) + ",");
				createLine.append(LoadData.name_move4.get(i) + ",");
				createLine.append(LoadData.PP_move4.get(i) + ",");
				createLine.append(LoadData.attPower_move4.get(i) + "");

				String finishedLine = createLine.toString();
				bw.write(finishedLine);
				bw.newLine();
			}

			// If there is less than six in party will write new pokemon
			if (LoadData.partyCounter < partySize) {
				StringBuilder makeLine = new StringBuilder();
				makeLine.append(LoadData.areaP_id.get(LoadData.partyCounter) + ",");
				makeLine.append(LoadData.areaP_name.get(BattleScene.wildPokemon) + ",");
				makeLine.append(BattleScene.wildTotHP + ",");
				makeLine.append(BattleScene.wildActHP + ",");
				makeLine.append(BattleScene.wildAttack + ",");
				makeLine.append(BattleScene.wildDefense + ",");
				makeLine.append(BattleScene.wildSpeed + ",");
				makeLine.append(BattleScene.wildSpecial + ",");
				//wildXpNextLvl, wildTOTXp, wildLvL, wildHPIV, wildAttackIV, wildDefenseIV, wildSpeedIV, wildSpecialIV
				makeLine.append(BattleScene.wildXpNextLvl + ",");
				makeLine.append(BattleScene.wildTOTXp + ",");
				makeLine.append(BattleScene.wildLvL + ",");
				makeLine.append(BattleScene.wildHPIV + ",");
				makeLine.append(BattleScene.wildAttackIV + ",");
				makeLine.append(BattleScene.wildDefenseIV + ",");
				makeLine.append(BattleScene.wildSpeedIV + ",");
				makeLine.append(BattleScene.wildSpecialIV + ",");
				makeLine.append(BattleScene.move_name1 + ",");
				makeLine.append(BattleScene.move_pp1 + ",");
				makeLine.append(BattleScene.move_attPower1 + ",");
				makeLine.append(BattleScene.move_name2 + ",");
				makeLine.append(BattleScene.move_pp2 + ",");
				makeLine.append(BattleScene.move_attPower2 + ",");
				makeLine.append(BattleScene.move_name3 + ",");
				makeLine.append(BattleScene.move_pp3 + ",");
				makeLine.append(BattleScene.move_attPower3 + ",");
				makeLine.append(BattleScene.move_name4 + ",");
				makeLine.append(BattleScene.move_pp4 + ",");
				makeLine.append(BattleScene.move_attPower4 + "");
				
				//System.out.println("You caught : " + LoadData.p_name.get(BattleScene.wildPokemon));

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
			makeLine.append(LoadData.start_name.get(MainMenu.chosenID) + ",");
			makeLine.append(LoadData.start_TOThp.get(MainMenu.chosenID) + ",");
			makeLine.append(LoadData.start_ACThp.get(MainMenu.chosenID)+ ",");
			makeLine.append(LoadData.start_attack.get(MainMenu.chosenID) + ",");
			makeLine.append(LoadData.start_defense.get(MainMenu.chosenID) + ",");
			makeLine.append(LoadData.start_speed.get(MainMenu.chosenID) + ",");
			makeLine.append(LoadData.start_special.get(MainMenu.chosenID) + ",");
			makeLine.append(LoadData.start_lvl.get(MainMenu.chosenID) + ",");
			makeLine.append(LoadData.start_hpEV.get(MainMenu.chosenID)+ ",");
			makeLine.append(LoadData.start_attackEV.get(MainMenu.chosenID) + ",");
			makeLine.append(LoadData.start_defenseEV.get(MainMenu.chosenID) + ",");
			makeLine.append(LoadData.start_speedEV.get(MainMenu.chosenID) + ",");
			makeLine.append(LoadData.start_specialEV.get(MainMenu.chosenID) + ",");
			makeLine.append(LoadData.start_BaseXP.get(MainMenu.chosenID) + ",");
			
			int tempvar1 = 10;
			int tempvar2 = 10;
			int tempvar3 = 10;
			
			//Sets random moves for starter Pokemon
			for (int i = 0; i < 4; i++) {
				int var = p5.floor(p5.random(0, 9));
				//Checks if move has been used before and if so picks another random move
				while(var == tempvar1 || var == tempvar2 || var == tempvar3){
					var = p5.floor(p5.random(0, 9));
				}
				makeLine.append(LoadData.move_name.get(var) + ",");
				makeLine.append(LoadData.move_PP.get(var) + ",");
				if (i != 3) {
					makeLine.append(LoadData.move_attPower.get(var) + ",");
				} else {
					makeLine.append(LoadData.move_attPower.get(var) + "");
				}
				//Stores the previous moves given
				if(i == 0){
					tempvar1 = var;
				}
				if(i == 1){
					tempvar2 = var;
				}
				if(i == 2){
					tempvar3 = var;
				}
			}

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