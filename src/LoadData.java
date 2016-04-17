import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LoadData {
	Pokemon p5;
	public static String file;

	public static ArrayList<Integer> areaP_id;
	public static ArrayList<String> areaP_name;
	public static ArrayList<Integer> areaP_TOThp;
	public static ArrayList<Integer> areaP_ACThp;
	public static ArrayList<Integer> areaP_attack;
	public static ArrayList<Integer> areaP_defense;
	public static ArrayList<Integer> areaP_speed;
	public static ArrayList<Integer> areaP_special;
	public static ArrayList<Integer> areaP_hpEV;
	public static ArrayList<Integer> areaP_attackEV;
	public static ArrayList<Integer> areaP_defenseEV;
	public static ArrayList<Integer> areaP_speedEV;
	public static ArrayList<Integer> areaP_specialEV;
	public static ArrayList<Integer> areaP_BaseXP;

	public static ArrayList<Integer> party_id;
	public static ArrayList<String> party_name;
	public static ArrayList<Integer> party_TOThp;
	public static ArrayList<Integer> party_ACThp;
	public static ArrayList<Integer> party_attack;
	public static ArrayList<Integer> party_defense;
	public static ArrayList<Integer> party_speed;
	public static ArrayList<Integer> party_special;
	public static ArrayList<Integer> party_xpNextLvl;
	public static ArrayList<Integer> party_TOTxp;
	public static ArrayList<Integer> party_CurXP;
	public static ArrayList<Integer> party_lvl;
	public static ArrayList<Integer> party_hpIV;
	public static ArrayList<Integer> party_attackIV;
	public static ArrayList<Integer> party_defenseIV;
	public static ArrayList<Integer> party_speedIV;
	public static ArrayList<Integer> party_specialIV;
	public static ArrayList<Double> party_hpEV;
	public static ArrayList<Double> party_attackEV;
	public static ArrayList<Double> party_defenseEV;
	public static ArrayList<Double> party_speedEV;
	public static ArrayList<Double> party_specialEV;
	public static ArrayList<Integer> party_BaseExp;
	public static ArrayList<String> name_move1;
	public static ArrayList<Integer> PP_move1;
	public static ArrayList<Integer> attPower_move1;
	public static ArrayList<String> name_move2;
	public static ArrayList<Integer> PP_move2;
	public static ArrayList<Integer> attPower_move2;
	public static ArrayList<String> name_move3;
	public static ArrayList<Integer> PP_move3;
	public static ArrayList<Integer> attPower_move3;
	public static ArrayList<String> name_move4;
	public static ArrayList<Integer> PP_move4;
	public static ArrayList<Integer> attPower_move4;

	public static ArrayList<Integer> start_id;
	public static ArrayList<String> start_name;
	public static ArrayList<Integer> start_TOThp;
	public static ArrayList<Integer> start_ACThp;
	public static ArrayList<Integer> start_attack;
	public static ArrayList<Integer> start_defense;
	public static ArrayList<Integer> start_speed;
	public static ArrayList<Integer> start_special;
	public static ArrayList<Integer> start_lvl;
	public static ArrayList<Integer> start_hpEV;
	public static ArrayList<Integer> start_attackEV;
	public static ArrayList<Integer> start_defenseEV;
	public static ArrayList<Integer> start_speedEV;
	public static ArrayList<Integer> start_specialEV;
	public static ArrayList<Integer> start_BaseXP;
	
	public static ArrayList<Integer> Dex_id;
	public static ArrayList<String> Dex_name;
	public static ArrayList<Integer> Dex_TOThp;
	public static ArrayList<Integer> Dex_attack;
	public static ArrayList<Integer> Dex_defense;
	public static ArrayList<Integer> Dex_speed;
	public static ArrayList<Integer> Dex_special;
	public static ArrayList<Integer> Dex_BaseXP;

	public static ArrayList<String> move_name;
	public static ArrayList<Integer> move_PP;
	public static ArrayList<Integer> move_attPower;

	public static ArrayList<Integer> party_move_ID;
	public static ArrayList<String> party_move_name;
	public static ArrayList<Integer> party_move_PP;
	public static ArrayList<Integer> party_move_attPower;

	public static int partyCounter;
	public static int areaCounter;

	public static void loadMoves() {
		file = "LoadData" + File.separator + "Moves.csv";
		BufferedReader br = null;
		String line;
		String split = ",";
		partyCounter = 0;

		try {
			br = new BufferedReader(new FileReader(file));

			move_name = new ArrayList<String>();
			move_PP = new ArrayList<Integer>();
			move_attPower = new ArrayList<Integer>();

			// Checks if string is empty
			while ((line = br.readLine()) != null) {
				// Divides each line into Tokens
				StringTokenizer str = new StringTokenizer(line, split);

				// Converts string values and stores into arraylists
				while (str.hasMoreTokens()) {
					move_name.add(str.nextToken());
					move_PP.add(Integer.parseInt(str.nextToken()));
					move_attPower.add(Integer.parseInt(str.nextToken()));
				}

			}
		}

		// If the above doesn't work, show an error
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Once complete if the bufferedreader is not empty close it
		finally {
			if (br != null) {
				try {
					br.close();
				}
				// else throw an exception
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void loadParty() {
		file = "LoadData" + File.separator + "Party.csv";
		BufferedReader br = null;
		String line;
		String split = ",";
		partyCounter = 0;

		try {
			br = new BufferedReader(new FileReader(file));

			party_id = new ArrayList<Integer>();
			party_name = new ArrayList<String>();
			party_TOThp = new ArrayList<Integer>();
			party_ACThp = new ArrayList<Integer>();
			party_attack = new ArrayList<Integer>();
			party_defense = new ArrayList<Integer>();
			party_speed = new ArrayList<Integer>();
			party_special = new ArrayList<Integer>();
			party_xpNextLvl = new ArrayList<Integer>();
			party_TOTxp = new ArrayList<Integer>();
			party_CurXP = new ArrayList<Integer>();
			party_lvl = new ArrayList<Integer>();
			party_hpIV = new ArrayList<Integer>();
			party_attackIV = new ArrayList<Integer>();
			party_defenseIV = new ArrayList<Integer>();
			party_speedIV = new ArrayList<Integer>();
			party_specialIV = new ArrayList<Integer>();
			party_hpEV = new ArrayList<Double>();
			party_attackEV = new ArrayList<Double>();
			party_defenseEV = new ArrayList<Double>();
			party_speedEV = new ArrayList<Double>();
			party_specialEV = new ArrayList<Double>();
			party_BaseExp = new ArrayList<Integer>();
			name_move1 = new ArrayList<String>();
			PP_move1 = new ArrayList<Integer>();
			attPower_move1 = new ArrayList<Integer>();
			name_move2 = new ArrayList<String>();
			PP_move2 = new ArrayList<Integer>();
			attPower_move2 = new ArrayList<Integer>();
			name_move3 = new ArrayList<String>();
			PP_move3 = new ArrayList<Integer>();
			attPower_move3 = new ArrayList<Integer>();
			name_move4 = new ArrayList<String>();
			PP_move4 = new ArrayList<Integer>();
			attPower_move4 = new ArrayList<Integer>();

			// Checks if string is empty
			while ((line = br.readLine()) != null) {
				// Divides each line into Tokens
				StringTokenizer str = new StringTokenizer(line, split);

				// Converts string values and stores into arraylists
				while (str.hasMoreTokens()) {
					party_id.add(Integer.parseInt(str.nextToken()));
					party_name.add(str.nextToken());
					party_TOThp.add(Integer.parseInt(str.nextToken()));
					party_ACThp.add(Integer.parseInt(str.nextToken()));
					party_attack.add(Integer.parseInt(str.nextToken()));
					party_defense.add(Integer.parseInt(str.nextToken()));
					party_speed.add(Integer.parseInt(str.nextToken()));
					party_special.add(Integer.parseInt(str.nextToken()));
					party_xpNextLvl.add(Integer.parseInt(str.nextToken()));
					party_TOTxp.add(Integer.parseInt(str.nextToken()));
					party_CurXP.add(Integer.parseInt(str.nextToken()));
					party_lvl.add(Integer.parseInt(str.nextToken()));
					party_hpIV.add(Integer.parseInt(str.nextToken()));
					party_attackIV.add(Integer.parseInt(str.nextToken()));
					party_defenseIV.add(Integer.parseInt(str.nextToken()));
					party_speedIV.add(Integer.parseInt(str.nextToken()));
					party_specialIV.add(Integer.parseInt(str.nextToken()));
					party_hpEV.add(Double.parseDouble(str.nextToken()));
					party_attackEV.add(Double.parseDouble(str.nextToken()));
					party_defenseEV.add(Double.parseDouble(str.nextToken()));
					party_speedEV.add(Double.parseDouble(str.nextToken()));
					party_specialEV.add(Double.parseDouble(str.nextToken()));
					party_BaseExp.add(Integer.parseInt(str.nextToken()));
					name_move1.add(str.nextToken());
					PP_move1.add(Integer.parseInt(str.nextToken()));
					attPower_move1.add(Integer.parseInt(str.nextToken()));
					name_move2.add(str.nextToken());
					PP_move2.add(Integer.parseInt(str.nextToken()));
					attPower_move2.add(Integer.parseInt(str.nextToken()));
					name_move3.add(str.nextToken());
					PP_move3.add(Integer.parseInt(str.nextToken()));
					attPower_move3.add(Integer.parseInt(str.nextToken()));
					name_move4.add(str.nextToken());
					PP_move4.add(Integer.parseInt(str.nextToken()));
					attPower_move4.add(Integer.parseInt(str.nextToken()));
				}
				// Counts how many pokemon in the party
				partyCounter++;
			}
		}

		// If the above doesn't work, show an error
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Once complete if the bufferedreader is not empty close it
		finally {
			if (br != null) {
				try {
					br.close();
				}
				// else throw an exception
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void loadPokeArea() {
		file = "LoadData" + File.separator + "Area1.csv";
		BufferedReader br = null;
		String line = "";
		String split = ",";
		areaCounter = 0;

		try {
			br = new BufferedReader(new FileReader(file));
			areaP_id = new ArrayList<Integer>();
			areaP_name = new ArrayList<String>();
			areaP_TOThp = new ArrayList<Integer>();
			areaP_ACThp = new ArrayList<Integer>();
			areaP_attack = new ArrayList<Integer>();
			areaP_defense = new ArrayList<Integer>();
			areaP_speed = new ArrayList<Integer>();
			areaP_special = new ArrayList<Integer>();
			areaP_hpEV = new ArrayList<Integer>();
			areaP_attackEV = new ArrayList<Integer>();
			areaP_defenseEV = new ArrayList<Integer>();
			areaP_speedEV = new ArrayList<Integer>();
			areaP_specialEV = new ArrayList<Integer>();
			areaP_BaseXP = new ArrayList<Integer>();

			// Checks if string is empty
			while ((line = br.readLine()) != null) {

				// Divides each line into Tokens
				StringTokenizer st = new StringTokenizer(line, split);
				// Converts string values and stores into arraylists
				while (st.hasMoreTokens()) {
					areaP_id.add(Integer.parseInt(st.nextToken()));
					areaP_name.add(st.nextToken());
					areaP_TOThp.add(Integer.parseInt(st.nextToken()));
					areaP_ACThp.add(Integer.parseInt(st.nextToken()));
					areaP_attack.add(Integer.parseInt(st.nextToken()));
					areaP_defense.add(Integer.parseInt(st.nextToken()));
					areaP_speed.add(Integer.parseInt(st.nextToken()));
					areaP_special.add(Integer.parseInt(st.nextToken()));
					areaP_hpEV.add(Integer.parseInt(st.nextToken()));
					areaP_attackEV.add(Integer.parseInt(st.nextToken()));
					areaP_defenseEV.add(Integer.parseInt(st.nextToken()));
					areaP_speedEV.add(Integer.parseInt(st.nextToken()));
					areaP_specialEV.add(Integer.parseInt(st.nextToken()));
					areaP_BaseXP.add(Integer.parseInt(st.nextToken()));
				}
				// Counts how many pokemon in area
				areaCounter++;
			}
		}

		// If the above doesn't work, show an error
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Once complete if the bufferedreader is not empty close it
		finally {
			if (br != null) {
				try {
					br.close();
				}
				// else throw an exception
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void loadStartPokemon() {
		file = "LoadData" + File.separator + "Starters.csv";
		BufferedReader br = null;
		String line = "";
		String split = ",";

		try {
			br = new BufferedReader(new FileReader(file));
			start_id = new ArrayList<Integer>();
			start_name = new ArrayList<String>();
			start_TOThp = new ArrayList<Integer>();
			start_ACThp = new ArrayList<Integer>();
			start_attack = new ArrayList<Integer>();
			start_defense = new ArrayList<Integer>();
			start_speed = new ArrayList<Integer>();
			start_special = new ArrayList<Integer>();
			start_lvl = new ArrayList<Integer>();
			start_hpEV = new ArrayList<Integer>();
			start_attackEV = new ArrayList<Integer>();
			start_defenseEV = new ArrayList<Integer>();
			start_speedEV = new ArrayList<Integer>();
			start_specialEV = new ArrayList<Integer>();
			start_BaseXP = new ArrayList<Integer>();

			// Checks if string is empty
			while ((line = br.readLine()) != null) {

				// Divides each line into Tokens
				StringTokenizer st = new StringTokenizer(line, split);
				// Converts string values and stores into arraylists
				while (st.hasMoreTokens()) {
					start_id.add(Integer.parseInt(st.nextToken()));
					start_name.add(st.nextToken());
					start_TOThp.add(Integer.parseInt(st.nextToken()));
					start_ACThp.add(Integer.parseInt(st.nextToken()));
					start_attack.add(Integer.parseInt(st.nextToken()));
					start_defense.add(Integer.parseInt(st.nextToken()));
					start_speed.add(Integer.parseInt(st.nextToken()));
					start_special.add(Integer.parseInt(st.nextToken()));
					start_lvl.add(Integer.parseInt(st.nextToken()));
					start_hpEV.add(Integer.parseInt(st.nextToken()));
					start_attackEV.add(Integer.parseInt(st.nextToken()));
					start_defenseEV.add(Integer.parseInt(st.nextToken()));
					start_speedEV.add(Integer.parseInt(st.nextToken()));
					start_specialEV.add(Integer.parseInt(st.nextToken()));
					start_BaseXP.add(Integer.parseInt(st.nextToken()));
				}
			}
		}

		// If the above doesn't work, show an error
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Once complete if the bufferedreader is not empty close it
		finally {
			if (br != null) {
				try {
					br.close();
				}
				// else throw an exception
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void loadPokeDex() {
		file = "LoadData" + File.separator + "Pokedex.csv";
		BufferedReader br = null;
		String line = "";
		String split = ",";

		try {
			br = new BufferedReader(new FileReader(file));
			Dex_id = new ArrayList<Integer>();
			Dex_name = new ArrayList<String>();
			Dex_TOThp = new ArrayList<Integer>();
			Dex_attack = new ArrayList<Integer>();
			Dex_defense = new ArrayList<Integer>();
			Dex_speed = new ArrayList<Integer>();
			Dex_special = new ArrayList<Integer>();
			Dex_BaseXP = new ArrayList<Integer>();

			// Checks if string is empty
			while ((line = br.readLine()) != null) {
				// Divides each line into Tokens
				StringTokenizer st = new StringTokenizer(line, split);
				// Converts string values and stores into arraylists
				while (st.hasMoreTokens()) {
					Dex_id.add(Integer.parseInt(st.nextToken()));
					Dex_name.add(st.nextToken());
					Dex_TOThp.add(Integer.parseInt(st.nextToken()));
					Dex_attack.add(Integer.parseInt(st.nextToken()));
					Dex_defense.add(Integer.parseInt(st.nextToken()));
					Dex_speed.add(Integer.parseInt(st.nextToken()));
					Dex_special.add(Integer.parseInt(st.nextToken()));
					Dex_BaseXP.add(Integer.parseInt(st.nextToken()));
				}
			}
		}

		// If the above doesn't work, show an error
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Once complete if the bufferedreader is not empty close it
		finally {
			if (br != null) {
				try {
					br.close();
				}
				// else throw an exception
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	void loadSaveGame() {
		file = "LoadData" + File.separator + "SavedGame.csv";
		BufferedReader br = null;
		String line;
		String split = ",";

		try {
			br = new BufferedReader(new FileReader(file));

			while ((line = br.readLine()) != null) {

				StringTokenizer st = new StringTokenizer(line, split);

				while (st.hasMoreTokens()) {
					// Sets location of background image + x and y of character
					InGame.location = (Integer.parseInt(st.nextToken()));
					InGame.characterX = (Integer.parseInt(st.nextToken()));
					InGame.characterY = (Integer.parseInt(st.nextToken()));
					InGame.tempMovement = (Integer.parseInt(st.nextToken()));
				}
			}
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			if (br != null) {
				try {
					br.close();
				}
				// else throw an exception
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}