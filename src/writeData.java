import java.io.FileWriter;
import java.io.IOException;
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

	public static void updateParty() {
		BufferedWriter bw = null;

		try {
			File file = new File("LoadData" + File.separator + "Party.csv");

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

				// ------------------------------------------------------------------------------
				if (BattleScene.BattleWon == false) {
					createLine.append(LoadData.party_TOThp.get(i) + ",");
					if (BattleScene.FoeTurn == true) {
						if (BattleScene.GameOver == true) {
							createLine.append(LoadData.party_TOThp.get(i) + ",");
						} else {
							createLine.append(BasePokemon.userACThp + ",");
						}
					}
					if (BattleScene.FoeTurn == false) {
						createLine.append(LoadData.party_ACThp.get(i) + ",");
					}
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
					createLine.append(LoadData.party_TOThp.get(i) + ",");
					createLine.append(LoadData.party_ACThp.get(i) + ",");
					createLine.append(LoadData.party_attack.get(i) + ",");
					createLine.append(LoadData.party_defense.get(i) + ",");
					createLine.append(LoadData.party_speed.get(i) + ",");
					createLine.append(LoadData.party_special.get(i) + ",");
					createLine.append(LoadData.party_xpNextLvl.get(i) + ",");
					createLine.append(LoadData.party_TOTxp.get(i) + ",");
					createLine.append(BasePokemon.CuRxp + ",");
					createLine.append(LoadData.party_lvl.get(i) + ",");
				}

				// If LeveLup = true .... update stats + change xp
				if (BattleScene.BattleWon == true && BattleScene.LeveLup == true) {
					createLine.append(BasePokemon.userTotHP + ",");
					createLine.append(BasePokemon.userActHP + ",");
					createLine.append(BasePokemon.userAttack + ",");
					createLine.append(BasePokemon.userDefense + ",");
					createLine.append(BasePokemon.userSpeed + ",");
					createLine.append(BasePokemon.userSpecial + ",");
					createLine.append(BasePokemon.NexTxp + ",");
					createLine.append(BasePokemon.ToTxp + ",");
					createLine.append(BasePokemon.CuRxp + ",");
					createLine.append(BasePokemon.Level + ",");
					BattleScene.LeveLup = false;
				}
				// ------------------------------------------------------------------------------

				createLine.append(LoadData.party_hpIV.get(i) + ",");
				createLine.append(LoadData.party_attackIV.get(i) + ",");
				createLine.append(LoadData.party_defenseIV.get(i) + ",");
				createLine.append(LoadData.party_speedIV.get(i) + ",");
				createLine.append(LoadData.party_specialIV.get(i) + ",");

				// ------------------------------------------------------------------------------
				if (BattleScene.BattleWon == false) {
					createLine.append(LoadData.party_hpEV.get(i) + ",");
					createLine.append(LoadData.party_attackEV.get(i) + ",");
					createLine.append(LoadData.party_defenseEV.get(i) + ",");
					createLine.append(LoadData.party_speedEV.get(i) + ",");
					createLine.append(LoadData.party_specialEV.get(i) + ",");
				}

				// If battle is won....Assigns EVs to user pokemon
				if (BattleScene.BattleWon == true) {
					createLine.append(BasePokemon.partyHPEV + ",");
					createLine.append(BasePokemon.partyAttackEV + ",");
					createLine.append(BasePokemon.partyDefenseEV + ",");
					createLine.append(BasePokemon.partySpeedEV + ",");
					createLine.append(BasePokemon.partySpecialEV + ",");
					BattleScene.BattleWon = false;
				}
				// ------------------------------------------------------------------------------

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
					makeLine.append(LoadData.areaP_name.get(BasePokemon.wildID) + ",");
					makeLine.append(BasePokemon.wildTotHP + ",");
					makeLine.append(BasePokemon.wildActHP + ",");
					makeLine.append(BasePokemon.wildAttack + ",");
					makeLine.append(BasePokemon.wildDefense + ",");
					makeLine.append(BasePokemon.wildSpeed + ",");
					makeLine.append(BasePokemon.wildSpecial + ",");
					makeLine.append(BasePokemon.wildXpNextLvl + ",");
					makeLine.append(BasePokemon.wildTOTXp + ",");
					// Current XP
					makeLine.append(0 + ",");
					makeLine.append(BasePokemon.wildLvL + ",");
					makeLine.append(BasePokemon.wildHPIV + ",");
					makeLine.append(BasePokemon.wildAttackIV + ",");
					makeLine.append(BasePokemon.wildDefenseIV + ",");
					makeLine.append(BasePokemon.wildSpeedIV + ",");
					makeLine.append(BasePokemon.wildSpecialIV + ",");
					makeLine.append(BasePokemon.wildHPEV + ",");
					makeLine.append(BasePokemon.wildAttackEV + ",");
					makeLine.append(BasePokemon.wildDefenseEV + ",");
					makeLine.append(BasePokemon.wildSpeedEV + ",");
					makeLine.append(BasePokemon.wildSpecialEV + ",");
					makeLine.append(BasePokemon.wildBaseXP + ",");
					makeLine.append(BasePokemon.move_name1 + ",");
					makeLine.append(BasePokemon.move_pp1 + ",");
					makeLine.append(BasePokemon.move_attPower1 + ",");
					makeLine.append(BasePokemon.move_name2 + ",");
					makeLine.append(BasePokemon.move_pp2 + ",");
					makeLine.append(BasePokemon.move_attPower2 + ",");
					makeLine.append(BasePokemon.move_name3 + ",");
					makeLine.append(BasePokemon.move_pp3 + ",");
					makeLine.append(BasePokemon.move_attPower3 + ",");
					makeLine.append(BasePokemon.move_name4 + ",");
					makeLine.append(BasePokemon.move_pp4 + ",");
					makeLine.append(BasePokemon.move_attPower4 + "");

					System.out.println("You caught : " + LoadData.areaP_name.get(BasePokemon.wildID));

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
			File file = new File("LoadData" + File.separator + "Party.csv");

			// Checks if file exists and if not creates the file
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			int var1 = LoadData.start_lvl.get(BasePokemon.chosenID);
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			StringBuilder makeLine = new StringBuilder();
			makeLine.append(LoadData.start_id.get(LoadData.partyCounter) + ",");
			makeLine.append(LoadData.start_name.get(BasePokemon.chosenID) + ",");
			makeLine.append(BasePokemon.chosenTotHP + ",");
			makeLine.append(BasePokemon.chosenActHP + ",");
			makeLine.append(BasePokemon.chosenAttack + ",");
			makeLine.append(BasePokemon.chosenDefense + ",");
			makeLine.append(BasePokemon.chosenSpeed + ",");
			makeLine.append(BasePokemon.chosenSpecial + ",");
			// Sets next XP
			makeLine.append(var1 * var1 * var1 + ",");
			// Sets current level XP
			makeLine.append(var1 * var1 + ",");
			// Current XP
			makeLine.append(0 + ",");
			makeLine.append(LoadData.start_lvl.get(BasePokemon.chosenID) + ",");
			makeLine.append(BasePokemon.chosenHPIV + ",");
			makeLine.append(BasePokemon.chosenAttackIV + ",");
			makeLine.append(BasePokemon.chosenDefenseIV + ",");
			makeLine.append(BasePokemon.chosenSpeedIV + ",");
			makeLine.append(BasePokemon.chosenSpecialIV + ",");
			makeLine.append(LoadData.start_hpEV.get(BasePokemon.chosenID) + ",");
			makeLine.append(LoadData.start_attackEV.get(BasePokemon.chosenID) + ",");
			makeLine.append(LoadData.start_defenseEV.get(BasePokemon.chosenID) + ",");
			makeLine.append(LoadData.start_speedEV.get(BasePokemon.chosenID) + ",");
			makeLine.append(LoadData.start_specialEV.get(BasePokemon.chosenID) + ",");
			makeLine.append(LoadData.start_BaseXP.get(BasePokemon.chosenID) + ",");

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
			File file = new File("LoadData" + File.separator + "SavedGame.csv");

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
