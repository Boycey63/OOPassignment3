import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LoadData {
	Pokemon p5;
	public static String file;

	public static ArrayList<Integer> p_id;
	public static ArrayList<String> p_name;
	public static ArrayList<Integer> p_TOThp;
	public static ArrayList<Integer> p_ACThp;
	public static ArrayList<Integer> p_attack;
	public static ArrayList<Integer> p_defense;
	public static ArrayList<Integer> p_speed;
	public static ArrayList<Integer> p_special;
	public static ArrayList<Integer> p_total;
	public static ArrayList<Integer> p_xp;

	public static ArrayList<Integer> party_id;
	public static ArrayList<String> party_name;
	public static ArrayList<Integer> party_TOThp;
	public static ArrayList<Integer> party_ACThp;
	public static ArrayList<Integer> party_attack;
	public static ArrayList<Integer> party_defense;
	public static ArrayList<Integer> party_speed;
	public static ArrayList<Integer> party_special;
	public static ArrayList<Integer> party_total;
	public static ArrayList<Integer> party_xp;

	public static ArrayList<Integer> start_id;
	public static ArrayList<String> start_name;
	public static ArrayList<Integer> start_TOThp;
	public static ArrayList<Integer> start_ACThp;
	public static ArrayList<Integer> start_attack;
	public static ArrayList<Integer> start_defense;
	public static ArrayList<Integer> start_speed;
	public static ArrayList<Integer> start_special;
	public static ArrayList<Integer> start_total;
	public static ArrayList<Integer> start_xp;

	public static int partyCounter;
	public static int areaCounter;

	LoadData() {
	}

	public static void loadParty() {
		file = "Party.csv";
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
			party_total = new ArrayList<Integer>();
			party_xp = new ArrayList<Integer>();

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
					party_total.add(Integer.parseInt(str.nextToken()));
					party_xp.add(Integer.parseInt(str.nextToken()));
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
		file = "Area1.csv";
		BufferedReader br = null;
		String line = "";
		String split = ",";
		areaCounter = -1;

		try {
			br = new BufferedReader(new FileReader(file));
			p_name = new ArrayList<String>();
			p_id = new ArrayList<Integer>();
			p_name = new ArrayList<String>();
			p_TOThp = new ArrayList<Integer>();
			p_ACThp = new ArrayList<Integer>();
			p_attack = new ArrayList<Integer>();
			p_defense = new ArrayList<Integer>();
			p_speed = new ArrayList<Integer>();
			p_special = new ArrayList<Integer>();
			p_total = new ArrayList<Integer>();
			p_xp = new ArrayList<Integer>();
			
			// Checks if string is empty
			while ((line = br.readLine()) != null) {

				// Divides each line into Tokens
				StringTokenizer st = new StringTokenizer(line, split);
				// System.out.println(line);
				// Converts string values and stores into arraylists
				while (st.hasMoreTokens()) {
					p_id.add(Integer.parseInt(st.nextToken()));
					p_name.add(st.nextToken());
					p_TOThp.add(Integer.parseInt(st.nextToken()));
					p_ACThp.add(Integer.parseInt(st.nextToken()));
					p_attack.add(Integer.parseInt(st.nextToken()));
					p_defense.add(Integer.parseInt(st.nextToken()));
					p_speed.add(Integer.parseInt(st.nextToken()));
					p_special.add(Integer.parseInt(st.nextToken()));
					p_total.add(Integer.parseInt(st.nextToken()));
					p_xp.add(Integer.parseInt(st.nextToken()));
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
		file = "Starters.csv";
		BufferedReader br = null;
		String line = "";
		String split = ",";

		try {
			br = new BufferedReader(new FileReader(file));
			start_name = new ArrayList<String>();
			start_id = new ArrayList<Integer>();
			start_name = new ArrayList<String>();
			start_TOThp = new ArrayList<Integer>();
			start_ACThp = new ArrayList<Integer>();
			start_attack = new ArrayList<Integer>();
			start_defense = new ArrayList<Integer>();
			start_speed = new ArrayList<Integer>();
			start_special = new ArrayList<Integer>();
			start_total = new ArrayList<Integer>();
			start_xp = new ArrayList<Integer>();

			// Checks if string is empty
			while ((line = br.readLine()) != null) {

				// Divides each line into Tokens
				StringTokenizer st = new StringTokenizer(line, split);
				// System.out.println(line);
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
					start_total.add(Integer.parseInt(st.nextToken()));
					start_xp.add(Integer.parseInt(st.nextToken()));
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
		file = "SavedGame.csv";
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