import processing.core.*;

class InGame {
	static Pokemon p5;
	public static int characterX, characterY;
	public static int topR, bottomL;
	public static PImage map1;
	public static PImage map2;
	public static PImage character;
	int radius, step;
	public static int location;
	int black, white;
	public static int green, blue;
	float tempX, tempY;
	public static String[] background = new String[20];
	public static String[] movement = new String[20];
	public static int tempMovement;
	public static int seconds, time, setTime, swtch;
	public static boolean resetTimer, menu, partyMenu, selectPokemon, excute;

	InGame(Pokemon _p5) {
		p5 = _p5;
		step = 7;
		black = 0;
		tempX = tempY = 0;
		white = -1;
		green = -16711936;
		blue = -16776961;
		resetTimer = true;
		menu = partyMenu = selectPokemon = excute = false;
		time = seconds = swtch = 0;

		// Initializes the image array
		background[0] = "Pallet Town2B.png";
		background[1] = "Pallet Town2F.png";
		background[2] = "Pallet Town1B.png";
		background[3] = "Pallet Town1F.png";
		background[4] = "part1B.png";
		background[5] = "part1F.png";
		background[6] = "part2B.png";
		background[7] = "part2F.png";
		background[8] = "part3B.png";
		background[9] = "part3F.png";

		// Initializes movement array
		movement[0] = "down1.png";
		movement[1] = "left1.png";
		movement[2] = "right3.png";
		movement[3] = "up3.png";
	}

	void keyPressed() {
		// System.out.println(map2.get(characterX + character.width,
		// characterY));

		// --------------D----------------------
		if (menu == false && selectPokemon == false && partyMenu == false) {
			if (p5.key == 'd' && ((map2.get(characterX + character.width, characterY) == white
					|| map2.get(characterX + character.width, characterY + character.height) == white)
					|| (map2.get(characterX + character.width, characterY) == blue
							|| map2.get(characterX + character.width, characterY + character.height) == blue))) {
				characterX = characterX + step;
				tempMovement = 2;
				character = p5.loadImage(movement[2]);
				p5.key = 'm';
			}

			if (p5.key == 'd' && map2.get(characterX + character.width, characterY) == green
					&& map2.get(characterX + character.width, characterY + character.height) == green) {
				characterX = characterX + step;
				tempMovement = 2;
				character = p5.loadImage(movement[2]);
				p5.key = 'm';
			}
			// --------------A----------------------
			if (p5.key == 'a' && ((map2.get(characterX, characterY) == white
					|| map2.get(characterX, characterY + character.height) == white)
					|| (map2.get(characterX, characterY) == blue
							|| map2.get(characterX, characterY + character.height) == blue))) {
				characterX = characterX - step;
				tempMovement = 1;
				character = p5.loadImage(movement[1]);
				p5.key = 'm';
			}

			if (p5.key == 'a' && map2.get(characterX, characterY) == green
					&& map2.get(characterX, characterY + character.height) == green) {
				characterX = characterX - step;
				tempMovement = 1;
				character = p5.loadImage(movement[1]);
				p5.key = 'm';
			}
			// --------------W----------------------
			if (p5.key == 'w' && ((map2.get(characterX, characterY) >= white
					|| map2.get(characterX + character.width, characterY) >= white)
					|| (map2.get(characterX, characterY) == blue
							|| map2.get(characterX + character.width, characterY) == blue))) {
				if (characterY <= 0) {
					location = location + 2;
					map2 = p5.loadImage(background[location]);
					map1 = p5.loadImage(background[location + 1]);
					characterY = p5.height;
				}
				characterY = characterY - step;
				tempMovement = 3;
				character = p5.loadImage(movement[3]);
				p5.key = 'm';
			}

			else if (p5.key == 'w' && map2.get(characterX, characterY) == green
					&& map2.get(characterX + character.width, characterY) == green) {
				if (characterY <= 0) {
					location = location + 2;
					map2 = p5.loadImage(background[location]);
					map1 = p5.loadImage(background[location + 1]);
					characterY = p5.height;
				}
				characterY = characterY - step;
				tempMovement = 3;
				character = p5.loadImage(movement[3]);
				p5.key = 'm';
			}

			// --------------S----------------------
			if (p5.key == 's' && map2.get(characterX, characterY + character.height) >= white
					&& map2.get(characterX + character.width, characterY + character.height) >= white) {
				if (characterY + character.height >= p5.height) {
					location = location - 2;
					map2 = p5.loadImage(background[location]);
					map1 = p5.loadImage(background[location + 1]);
					characterY = 0;
				}
				characterY = characterY + step;
				tempMovement = 0;
				character = p5.loadImage(movement[0]);
				p5.key = 'm';
			}

			else if (p5.key == 's' && map2.get(characterX, characterY + character.height) == green
					&& map2.get(characterX + character.width, characterY + character.height) == green) {
				if (characterY + character.height >= p5.height) {
					location = location - 2;
					map2 = p5.loadImage(background[location]);
					map1 = p5.loadImage(background[location + 1]);
					characterY = 0;
				}
				characterY = characterY + step;
				tempMovement = 0;
				character = p5.loadImage(movement[0]);
				p5.key = 'm';
			}

			if (p5.keyPressed == true && p5.key == p5.ENTER && (map2.get(characterX, characterY) == blue
					|| map2.get(characterX + character.width, characterY) == blue)) {
				BattleScene.GameOver = true;
				writeData.updateParty();
				BattleScene.GameOver = false;
				System.out.println("Your Pokemon were healed");
				p5.keyPressed = false;
			}
		}

		// Switch menu to true
		if (p5.keyPressed == true && p5.key == p5.BACKSPACE && menu == false) {
			menu = true;
			partyMenu = false;
			selectPokemon = false;
			p5.keyPressed = false;
		}

		if (menu == true || selectPokemon == true || partyMenu == true) {
			// Menu up function
			if (p5.keyPressed == true && p5.key == 'w') {
				if (menu == true) {
					Graphics.rectHeight = Graphics.textHeight1;
				}

				if (partyMenu == true) {
					if (BattleScene.choicePosY == Graphics.rectPosY2 + 45) {
						BattleScene.choicePosY = Graphics.rectPosY1 + 45;
					}

					else if (BattleScene.choicePosY == Graphics.rectPosY3 + 45) {
						BattleScene.choicePosY = Graphics.rectPosY2 + 45;
					}
				}
				p5.keyPressed = false;
			}

			// Menu down function
			if (p5.keyPressed == true && p5.key == 's') {
				if (menu == true) {
					Graphics.rectHeight = Graphics.textHeight2;
				}

				if (partyMenu == true) {
					if (BattleScene.choicePosY == Graphics.rectPosY1 + 45) {
						BattleScene.choicePosY = Graphics.rectPosY2 + 45;
					}

					else if (BattleScene.choicePosY == Graphics.rectPosY2 + 45) {
						BattleScene.choicePosY = Graphics.rectPosY3 + 45;
					}
				}
				p5.keyPressed = false;
			}

			// Menu Left function
			if (p5.keyPressed == true && p5.key == 'a' && partyMenu == true) {
				if (partyMenu == true) {
					if (BattleScene.choicePosX == (Graphics.textX2 - 20)) {
						BattleScene.choicePosX = Graphics.textX1 - 20;
					}
				}
				p5.keyPressed = false;
			}

			// Menu right function
			if (p5.keyPressed == true && p5.key == 'd' && partyMenu == true) {
				if (BattleScene.choicePosX == (Graphics.textX1 - 20)) {
					BattleScene.choicePosX = Graphics.textX2 - 20;
				}
				p5.keyPressed = false;
			}

			// If backspace is pressed...
			if (p5.keyPressed == true && p5.key == p5.BACKSPACE) {
				// If party menu = true .... go back to main menu
				if (partyMenu == true) {
					Graphics.resetSquare();
					menu = true;
					excute = false;
					p5.keyPressed = false;
				}

				// If main menu = true .. go back to walking
				if (menu == true) {
					menu = false;
					p5.keyPressed = false;
				}

				// If selectPokemon = true .. go back to party menu
				if (selectPokemon == true) {
					partyMenu = true;
					p5.keyPressed = false;
				}
			}

			// If in menu and shape is same height as text + enter button pushed
			// ... set partyMenu = true
			if (p5.keyPressed == true && p5.key == p5.ENTER && Graphics.rectHeight == Graphics.textHeight1
					&& menu == true) {
				partyMenu = true;
				excute = false;
				p5.keyPressed = false;
			}

			// If in menu and shape is same height as text + enter button pushed
			// ... save game
			if (p5.keyPressed == true && p5.key == p5.ENTER && Graphics.rectHeight == Graphics.textHeight2
					&& menu == true) {
				LoadData.loadParty();
				writeData.saveGame();
				System.out.println("Game Saved");
				p5.exit();
			}

			if (partyMenu == true && p5.keyPressed == true && p5.key == p5.ENTER) {
				// Pokemon 1 slot
				if (BattleScene.choicePosX == (Graphics.textX1 - 20)
						&& BattleScene.choicePosY == (Graphics.textY1 - 15)) {
					if (LoadData.partyCounter > 0) {
						BasePokemon.choiceCounter++;
						int slot = 0;

						if (BasePokemon.choiceCounter == 1) {
							BasePokemon.arrayID1 = slot;
						}

						else if (BasePokemon.choiceCounter == 2) {
							BasePokemon.arrayID2 = slot;
						}

						BasePokemon.selectSwapPoke(slot);
						p5.keyPressed = false;
					}
					else {
						System.out.println("No Pokemon in slot 1");
						p5.keyPressed = false;
					}
				}

				// Pokemon 2 slot
				else if (BattleScene.choicePosX == Graphics.textX2 - 20
						&& BattleScene.choicePosY == (Graphics.textY1 - 15)) {
					if (LoadData.partyCounter > 1) {
						BasePokemon.choiceCounter++;
						int slot = 1;
						if (BasePokemon.choiceCounter == 1) {
							BasePokemon.arrayID1 = slot;
						}

						else if (BasePokemon.choiceCounter == 2) {
							BasePokemon.arrayID2 = slot;
						}
						BasePokemon.selectSwapPoke(slot);
						p5.keyPressed = false;
					}
					else {
						System.out.println("No Pokemon in slot 2");
						p5.keyPressed = false;
					}
				}

				// Pokemon 3 slot
				else if (BattleScene.choicePosX == Graphics.textX1 - 20
						&& BattleScene.choicePosY == (Graphics.textY2 - 15)) {
					if (LoadData.partyCounter > 2) {
						BasePokemon.choiceCounter++;
						int slot = 2;
						if (BasePokemon.choiceCounter == 1) {
							BasePokemon.arrayID1 = slot;
						} else if (BasePokemon.choiceCounter == 2) {
							BasePokemon.arrayID2 = slot;
						}
						BasePokemon.selectSwapPoke(slot);
						p5.keyPressed = false;
					}
					else {
						System.out.println("No Pokemon in slot 3");
						p5.keyPressed = false;
					}
				}

				// Pokemon 4 slot
				else if (BattleScene.choicePosX == Graphics.textX2 - 20
						&& BattleScene.choicePosY == (Graphics.textY2 - 15)) {
					if (LoadData.partyCounter > 3) {
						BasePokemon.choiceCounter++;
						int slot = 3;
						if (BasePokemon.choiceCounter == 1) {
							BasePokemon.arrayID1 = slot;
						} else if (BasePokemon.choiceCounter == 2) {
							BasePokemon.arrayID2 = slot;
						}
						BasePokemon.selectSwapPoke(slot);
						p5.keyPressed = false;
					}
					else {
						System.out.println("No Pokemon in slot 4");
						p5.keyPressed = false;
					}
				}

				// Pokemon 5 slot
				else if (BattleScene.choicePosX == Graphics.textX1 - 20
						&& BattleScene.choicePosY == (Graphics.textY3 - 15)) {
					if (LoadData.partyCounter > 4) {
						BasePokemon.choiceCounter++;
						int slot = 4;
						if (BasePokemon.choiceCounter == 1) {
							BasePokemon.arrayID1 = slot;
						} else if (BasePokemon.choiceCounter == 2) {
							BasePokemon.arrayID2 = slot;
						}
						BasePokemon.selectSwapPoke(slot);
						p5.keyPressed = false;
					}
					else {
						System.out.println("No Pokemon in slot 5");
						p5.keyPressed = false;
					}
				}

				// Pokemon 6 slot
				else if (BattleScene.choicePosX == Graphics.textX2 - 20
						&& BattleScene.choicePosY == (Graphics.textY3 - 15)) {
					if (LoadData.partyCounter > 5) {
						BasePokemon.choiceCounter++;
						int slot = 5;
						if (BasePokemon.choiceCounter == 1) {
							BasePokemon.arrayID1 = slot;
						} else if (BasePokemon.choiceCounter == 2) {
							BasePokemon.arrayID2 = slot;
						}
						BasePokemon.selectSwapPoke(slot);
						p5.keyPressed = false;
					}
					else {
						System.out.println("No Pokemon in slot 6");
						p5.keyPressed = false;
					}
				}
			}
		}
	}

	void runInGame() {
		//System.out.println("location = " + InGame.location);

		//for (int i = 0; i < LoadData.partyCounter; i++) {
			//System.out.println("Position " + i + " = " + BasePokemon.PartyPos[i]);
		//}
		// If main menu = false ... walking view
		if (menu == false) {
			Graphics.displayMap();
			Graphics.displayCharacter();
			keyPressed();
		}

		// If main menu = true ... draw main menu
		if (menu == true) {
			partyMenu = false;
			selectPokemon = false;
			Graphics.InGameMenu();
			keyPressed();
		}

		// If partyMenu = true ... draw party sketch
		if (partyMenu == true) {
			menu = false;
			Graphics.DrawWalkingPartyMenu();
			keyPressed();
		}

		// If character is inside green start timer
		if (InGame.map2.get(InGame.characterX, InGame.characterY) == InGame.green
				|| InGame.map2.get(InGame.topR, InGame.characterY) == InGame.green
				|| InGame.map2.get(InGame.characterX, InGame.bottomL) == InGame.green
				|| InGame.map2.get(InGame.topR, InGame.bottomL) == InGame.green) {
			startTimer();
		}
	}

	public static void startTimer() {
		// Resets the timer, battle option and changes the next wild pokemon
		if (resetTimer == true) {
			LoadData.loadPokeArea();
			seconds = time = 0;
			swtch = 0;
			BasePokemon.intWildPokemon();
			// Randomly set the time till the next battle
			setTime = p5.floor(p5.random(1, 4));
			BattleScene.stop1 = false;
			BattleScene.intialize = true;
			resetTimer = false;
		}
		seconds++;

		// Divides the default amount of frames by 60 to find seconds
		if (seconds == 60) {
			seconds = seconds / 60;
			time++;
		}

		// Once time reaches the next battle time
		if (time == setTime) {
			Pokemon.battleView = true;
			Pokemon.walkingView = false;
			resetTimer = true;
		}
	}
}