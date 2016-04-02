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

				//10------------------------------------------------------------------------------
				if (BattleScene.BattleWon == false) {
					System.out.println("Battle not won:" + LoadData.party_xpNextLvl.get(i));
					createLine.append(LoadData.party_TOThp.get(i) + ",");
					createLine.append(LoadData.party_ACThp.get(i) + ",");
					createLine.append(LoadData.party_attack.get(i) + ",");
					createLine.append(LoadData.party_defense.get(i) + ",");
					createLine.append(LoadData.party_speed.get(i) + ",");
					createLine.append(LoadData.party_special.get(i) + ",");
					createLine.append(LoadData.party_xpNextLvl.get(i) + ",");
					createLine.append(LoadData.party_TOTxp.get(i) + ",");
					createLine.append(LoadData.party_CurXP.get(i) + ",");
					createLine.append(LoadData.party_lvl.get(i) + ",");
				}
				
				if (BattleScene.BattleWon == true && BattleScene.LeveLup == false) {
					System.out.println("Battle won - No level up :" + BattleScene.NexTxp);
					createLine.append(LoadData.party_TOThp.get(i) + ",");
					createLine.append(LoadData.party_ACThp.get(i) + ",");
					createLine.append(LoadData.party_attack.get(i) + ",");
					createLine.append(LoadData.party_defense.get(i) + ",");
					createLine.append(LoadData.party_speed.get(i) + ",");
					createLine.append(LoadData.party_special.get(i) + ",");
					createLine.append(LoadData.party_xpNextLvl.get(i) + ",");
					createLine.append(LoadData.party_TOTxp.get(i) + ",");
					createLine.append(BattleScene.CuRxp + ",");
					createLine.append(LoadData.party_lvl.get(i) + ",");
				}
				
				//If LeveLup = true .... update stats + change xp
				if (BattleScene.BattleWon == true && BattleScene.LeveLup == true) {
					System.out.println("Battle won - Level up :" + BattleScene.NexTxp);
					createLine.append(BattleScene.userTotHP + ",");
					createLine.append(BattleScene.userActHP + ",");
					createLine.append(BattleScene.userAttack + ",");
					createLine.append(BattleScene.userDefense + ",");
					createLine.append(BattleScene.userSpeed + ",");
					createLine.append(BattleScene.userSpecial + ",");
					createLine.append(BattleScene.NexTxp + ",");
					createLine.append(BattleScene.ToTxp + ",");
					createLine.append(BattleScene.CuRxp + ",");
					createLine.append(BattleScene.Level + ",");
					BattleScene.LeveLup = false;
				}
				//5------------------------------------------------------------------------------
				
				createLine.append(LoadData.party_hpIV.get(i) + ",");
				createLine.append(LoadData.party_attackIV.get(i) + ",");
				createLine.append(LoadData.party_defenseIV.get(i) + ",");
				createLine.append(LoadData.party_speedIV.get(i) + ",");
				createLine.append(LoadData.party_specialIV.get(i) + ",");
				
				//5------------------------------------------------------------------------------
				// If pokemon is caught
				if (BattleScene.BattleCaught == true || BattleScene.BattleWon == false) {
					createLine.append(LoadData.party_hpEV.get(i) + ",");
					createLine.append(LoadData.party_attackEV.get(i) + ",");
					createLine.append(LoadData.party_defenseEV.get(i) + ",");
					createLine.append(LoadData.party_speedEV.get(i) + ",");
					createLine.append(LoadData.party_specialEV.get(i) + ",");
				}
				
				//If battle is won....Assigns EVs to user pokemon
				if (BattleScene.BattleWon == true) {
					createLine.append(BattleScene.partyHPEV + ",");
					createLine.append(BattleScene.partyAttackEV + ",");
					createLine.append(BattleScene.partyDefenseEV + ",");
					createLine.append(BattleScene.partySpeedEV + ",");
					createLine.append(BattleScene.partySpecialEV + ",");
					BattleScene.BattleWon = false;
				}
				//------------------------------------------------------------------------------

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
			if (BattleScene.BattleCaught == true) {
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
					makeLine.append(BattleScene.wildXpNextLvl + ",");
					makeLine.append(BattleScene.wildTOTXp + ",");
					// Current XP
					makeLine.append(0 + ",");
					makeLine.append(BattleScene.wildLvL + ",");
					makeLine.append(BattleScene.wildHPIV + ",");
					makeLine.append(BattleScene.wildAttackIV + ",");
					makeLine.append(BattleScene.wildDefenseIV + ",");
					makeLine.append(BattleScene.wildSpeedIV + ",");
					makeLine.append(BattleScene.wildSpecialIV + ",");
					makeLine.append(BattleScene.wildHPEV + ",");
					makeLine.append(BattleScene.wildAttackEV + ",");
					makeLine.append(BattleScene.wildDefenseEV + ",");
					makeLine.append(BattleScene.wildSpeedEV + ",");
					makeLine.append(BattleScene.wildSpecialEV + ",");
					makeLine.append(BattleScene.wildBaseXP + ",");
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

					// System.out.println("You caught : " +
					// LoadData.p_name.get(BattleScene.wildPokemon));

					String newLine = makeLine.toString();

					bw.write(newLine);
				}

				else {
					System.out.println("Your party is full");
				}
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

			int var1 = LoadData.start_lvl.get(MainMenu.chosenID);
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			StringBuilder makeLine = new StringBuilder();
			// MainMenu.chosenTotHP, MainMenu.chosenActHP,
			// MainMenu.chosenAttack, MainMenu.chosenDefense,
			// MainMenu.chosenSpeed, MainMenu.chosenSpecial
			makeLine.append(LoadData.start_id.get(LoadData.partyCounter) + ",");
			makeLine.append(LoadData.start_name.get(MainMenu.chosenID) + ",");
			makeLine.append(MainMenu.chosenTotHP + ",");
			makeLine.append(MainMenu.chosenActHP + ",");
			makeLine.append(MainMenu.chosenAttack + ",");
			makeLine.append(MainMenu.chosenDefense + ",");
			makeLine.append(MainMenu.chosenSpeed + ",");
			makeLine.append(MainMenu.chosenSpecial + ",");
			// Sets next XP
			makeLine.append(var1 * var1 * var1 + ",");
			// Sets current level XP
			makeLine.append(var1 * var1 + ",");
			// Current XP
			makeLine.append(0 + ",");
			makeLine.append(LoadData.start_lvl.get(MainMenu.chosenID) + ",");
			// chosenHPIV, chosenAttackIV, chosenDefenseIV, chosenSpeedIV,
			// chosenSpecialIV
			makeLine.append(MainMenu.chosenHPIV + ",");
			makeLine.append(MainMenu.chosenAttackIV + ",");
			makeLine.append(MainMenu.chosenDefenseIV + ",");
			makeLine.append(MainMenu.chosenSpeedIV + ",");
			makeLine.append(MainMenu.chosenSpecialIV + ",");
			makeLine.append(LoadData.start_hpEV.get(MainMenu.chosenID) + ",");
			makeLine.append(LoadData.start_attackEV.get(MainMenu.chosenID) + ",");
			makeLine.append(LoadData.start_defenseEV.get(MainMenu.chosenID) + ",");
			makeLine.append(LoadData.start_speedEV.get(MainMenu.chosenID) + ",");
			makeLine.append(LoadData.start_specialEV.get(MainMenu.chosenID) + ",");
			makeLine.append(LoadData.start_BaseXP.get(MainMenu.chosenID) + ",");

			int tempvar1 = 10;
			int tempvar2 = 10;
			int tempvar3 = 10;

			// Sets random moves for starter Pokemon
			for (int i = 0; i < 4; i++) {
				int var2 = p5.floor(p5.random(0, 9));
				// Checks if move has been used before and if so picks another
				// random move
				while (var2 == tempvar1 || var2 == tempvar2 || var2 == tempvar3) {
					var2 = p5.floor(p5.random(0, 9));
				}
				makeLine.append(LoadData.move_name.get(var2) + ",");
				makeLine.append(LoadData.move_PP.get(var2) + ",");
				if (i != 3) {
					makeLine.append(LoadData.move_attPower.get(var2) + ",");
				} else {
					makeLine.append(LoadData.move_attPower.get(var2) + "");
				}
				// Stores the previous moves given
				if (i == 0) {
					tempvar1 = var2;
				}
				if (i == 1) {
					tempvar2 = var2;
				}
				if (i == 2) {
					tempvar3 = var2;
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