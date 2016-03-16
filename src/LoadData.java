import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LoadData {
	Pokemon p5;
	String file;
	
	public static ArrayList<Integer> p_id;
	public static ArrayList<String> p_name;
	public static ArrayList<Integer> p_TOThp;
	public static ArrayList<Integer> p_ACThp;
	public static ArrayList<Integer> p_attack;
	public static ArrayList<Integer> p_defense;
	public static ArrayList<Integer> p_speed;
	public static ArrayList<Integer> p_special;
	public static ArrayList<Integer> p_total;

	public static ArrayList<String> party_name;
	public static ArrayList<Integer> party_TOThp;
	public static ArrayList<Integer> party_ACThp;
	public static ArrayList<Integer> party_attack;
	public static ArrayList<Integer> party_defense;
	public static ArrayList<Integer> party_speed;
	public static ArrayList<Integer> party_special;
	public static ArrayList<Integer> party_total;
	public static ArrayList<Integer> party_id;

	public static int partyCounter;
	public static int areaCounter;
	
	LoadData() {
	}

	void loadParty() {
		file = "Party.csv";
		BufferedReader bs = null;
		String line;
		String split = ",";
		int lineNumber = 0;
		int tokenNumber = 0;
		partyCounter = 0;

		try {
			bs = new BufferedReader(new FileReader(file));

			party_name = new ArrayList<String>();
			party_TOThp = new ArrayList<Integer>();
			party_ACThp = new ArrayList<Integer>();
			party_attack = new ArrayList<Integer>();
			party_defense = new ArrayList<Integer>();
			party_speed = new ArrayList<Integer>();
			party_special = new ArrayList<Integer>();
			party_total = new ArrayList<Integer>();
			party_id = new ArrayList<Integer>();

			// Checks if string is empty
			while ((line = bs.readLine()) != null) {
				// Divides each line into Tokens
				StringTokenizer str = new StringTokenizer(line, split);

				//Converts string values and stores into arraylists
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
					tokenNumber++;
				}
				//Counts how many pokemon in the party
				partyCounter++;
				lineNumber++;
				tokenNumber = 0;
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
			if (bs != null) {
				try {
					bs.close();
				}
				// else throw an exception
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	void loadPokeArea() {
		file = "Area1.csv";
		BufferedReader bs = null;
		String line;
		String split = ",";
		int lineNumber = 0;
		int tokenNumber = 0;
		areaCounter = -1;
		

		try {
			bs = new BufferedReader(new FileReader(file));
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

			// Checks if string is empty
			while ((line = bs.readLine()) != null) {

				// Divides each line into Tokens
				StringTokenizer st = new StringTokenizer(line, split);

				//Converts string values and stores into arraylists
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
					tokenNumber++;
				}
				//Counts how many pokemon in area
				areaCounter++;
				lineNumber++;
				tokenNumber = 0;
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
			if (bs != null) {
				try {
					bs.close();
				}
				// else throw an exception
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}