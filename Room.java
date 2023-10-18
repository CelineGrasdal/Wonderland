/**
 * title: Room.java
 * description: An application that takes input from Control class and acts upon it.
 * date: September 30, 2022
 * @author Celine Grasdal
 * @version 1.0
 * AU ID: 3556933
 */
 
/**
 * DOCUMENTATION
 */
  
/**
 * Celine Grasdal
 * AU ID: 3556933
 * September 30, 2022
 *
 * Room
 *
 * Purpose and Description
 *
 * An application that takes input from Control class and acts upon it.
 *
 * This progam takes input from Control class and acts in various ways dependant on the input. 
 * This program uses Java and requires Java Version 17.0.2 or higher to run.
 *
 * Compiling and running instructions
 * Compile:    javac Control.java
 * Compile:    javac DescriptionWriter.java
 * Compile:    javac Location.java
 * Compile:    javac Item.java
 * Compile:    javac Visits.java
 * Compile:    javac Characters.java
 * Compile:    javac Game.java
 * Compile:    javac ItemActions.java
 * Compile:    javac Inventory.java
 * Compile:    javac Describe.java
 * Compile:    javac Player.java
 * Compile:    javac Combat.java
 * Compile:    javac Room.java
 * Compile:    javac TestRoom.java
 * Run:        java TestRoom
 */
 
/**
 *
 * Classes
 *
 * public class Room
 * This the main public class for this application
 *
 */
  
/**
 *
 * Test Plan
 *
 * 1. Run java Wonderland. 
 * EXPECTED: 
 *    Command box should display the following:
 *    text = You are Alice from Alice in Wonderland. You want to be treated like a grown up. 
 *    Your goal is to prove to yourself and others that you are grown up without losing 
 *    sanity along the way. Maybe your sister can tell you how. Try to talk to her. I 
 *    will narrate your story as you go along. I can understand 1 or 2 word commands. 
 *    I will only read the first and second word of your command and act on what I have read. 
 *    To talk to your sister, type "talk sister". You start with 10 sanity points. 
 *    You need 15 sanity points to win the game. If you lose all your sanity points at 
 *    any point in the game, you lose the game. You can check your current sanity by typing
 *    "san", or "sanity". Good Luck!
 *    whitespace for recieving user input
 *    text to display program response to user input
 *
 * ACTUAL:
 *    Command box displays as expected.
 *
 * 2. Good data cases:
 * EXPECTED:
 *    Run the following test cases by typing the input value and pressing enter:
 *    'go n' -> output should be : 
 *	      text = Game class location name 
 *	      text = Game class location description
		  or output should be:
		  text = 'You can't go that way'
 *	  'drop rose' -> output should be :
 *        text = 'You don't have the rose'
 *		  text = whitespace
 *    'eat cupcake' -> output should be:
 *        text = 'You don't have the cupcake'
 *		  or output should be:
 *		  text = 'You bump your head on the ceiling. The white rabbit comes 
 *                out of the smallest door. He screams, drops his gloves, 
 *                and runs back through the smallest door. You start crying. 
 *                A puddle forms at your feet.
 *	  'sit' -> output should be:
 *        text = 'You are sitting on a chair'
 *        or output should be:
 *        text = 'You are already sitting'
 *        or output should be:
 *        text = 'There is nowhere to sit' 
 * ACTUAL:
 *    Command box displays as expected.
 *
 */

 /**
  * CODE
  */
  
/** Java core packages */
import java.util.*;

/** primary (public) class for Game */
public class Room extends Game {
	
	/** Intialize and set default variables */
	public Player alice;
	public ArrayList<Item> aliceItems;
	Describe two = new Describe();
	public int spearCount = 0;
	
	/** Method to accept input from Control and use input to determine results*/
    public void Room() {
		
		//set instance variables and display inital location name and description
		this.aliceItems = new ArrayList<Item>();
		this.alice = new Player("Alice", "Alice.txt", 1, 3, 10, 100, aliceItems, "stand");
		int userExit = 0;
		Location room = map.get(alice.getDirection());
		room.nameDisplay();
		room.descriptionDisplay();
		Combat fight = new Combat();  //create Combat instance
		Inventory allowed = new Inventory(alice);
		ItemActions aliceAction = new ItemActions(alice);
		int open = 0;
		
		// do while loop that runs until game ends
		do {
			//call duchessBaby method from Describe
			two.duchessBaby(room, alice);
			//create Control instance
			Control one = new Control();
			//call Control method
			one.Control();
			String object = one.getObject();
			String action = one.getAction();
			
			/**nested if switch statement to direct game flow*/
			if (one.isNounVerb()) {
				//move player
				if (one.isDirection()) { 
					switch (object) {
						case "n":
						case "north":
							if (room.getN() > -1) {
								alice.setDirection(room.getN());
							}
							else
								System.out.println("You can't go that way.");
							break;
						case "e":
						case "east":
							if (room.getE() > -1) {
								alice.setDirection(room.getE());
							}
							else
								System.out.println("You can't go that way.");
							break;
						case "s":
						case "south":
							if (room.getS() > -1) {
								alice.setDirection(room.getS());
							}
							else
								System.out.println("You can't go that way.");
							break;
						case "w":
						case "west":
							if (room.getW() > -1) {
								alice.setDirection(room.getW());
							}
							else
								System.out.println("You can't go that way.");
							break;
						case "ne":
						case "northeast":
							if (room.getNe() > -1) {
								alice.setDirection(room.getNe());
							}
							else
								System.out.println("You can't go that way.");
							break;
						case "nw":
						case "northwest":
							if (room.getNw ()> -1) {
								alice.setDirection(room.getNw());
							}
							else
								System.out.println("You can't go that way.");
							break;
						case "se":
						case "southeast":
							if (room.getSe() > -1) {
								alice.setDirection(room.getSe());
							}
							else
								System.out.println("You can't go that way.");
							break;
						case "sw":
						case "southwest":
							if (room.getSw() > -1) {
								alice.setDirection(room.getSw());
							}
							else
								System.out.println("You can't go that way.");
							break;
					}
					room = map.get(alice.getDirection());
					
					/**decide if soldier appears*/
					boolean enemy = Characters.meetSoldier();
					System.out.println(enemy);
					if (enemy) {
						if ((alice.getDirection() > 4) && (alice.getDirection() < 12)) {
							//soldier drops spear and runs away
							if (spearCount < 1) {
								System.out.println("A red card soldier has appeared!");
								System.out.println("He is so surprised to see you he drops his spear and runs off!");
								room.getItemHolder().add(new Item("spear", "Spear.txt"));
								spearCount = 1;
							}
							//hat blows soldier away
							if (allowed.hasItem("hat"))
								aliceAction.hatResponse(alice);
							//player battles soldier
							if (spearCount > 0) {
								System.out.println("A red soldier appears! He immediately attacks!");
								System.out.println("You have " + alice.getSanityPoints() + " sanity points");
								fight.spearSuccess(alice);
							}
						}
					}					
					
					//if statement for player leaving tea party while check if player standing
					if (room.getName().equals("Forest")) {
						ItemActions party = new ItemActions(alice);
						int stand = party.canLeaveStand(alice);
						room = map.get(stand);
					}
					
					//if statement for player leaving tea party while check if player sitting
					if (room.getName().equals("Mad Hatter's House")) {
						ItemActions tea = new ItemActions(alice);
						int stand = tea.canLeaveSit(alice);
						room = map.get(stand);
					}
					
					//method to describe room
					two.Describe(room, alice);
					
					//if statement to check for rose and display results while player in queens garden
					if (room.getName().equals("Red Queen's Garden")) {
						ItemActions garden = new ItemActions(alice);
						if (garden.queenResponse(alice))
							room = map.get(4);
				
					}
					
					//if statement to force player through rabbithole
					if (room.getName().equals("Rabbithole")) {
						room = map.get(4);
						two.Describe(room, alice);
						map.get(4).setCounter(1);
					}
					
					//update location counter variable
					(map.get(alice.getDirection())).setCounter((((map.get(alice.getDirection())).getCounter()) + 1));
				}
	
				else {
					switch(object) {
						//player quits game
						case "q":
						case "quit":
							System.out.println("You have exited the game. You will have to start again.");
							userExit = 1;
							break;
						//player calls for inventory
						case "i":
						case "inventory":
							for (int i = 0; i < (alice.getItemHolder().size()); i++) {
								(alice.getItemHolder()).get(i).nameDisplay();
							
							}
							break;
						case "san":
						case "sanity": {
						    System.out.println(alice.getSanityPoints());
						}
							break;
						//player sits or stands
						case "sit":	
						    if (alice.getStand().equals(object))  
							    System.out.println("You are already sitting");
							if ((alice.getStand().equals("stand")) && (room.getName().equals("Tea Party"))) {
								alice.setStand("sit");
								System.out.println("You are sitting on a chair");
							}	
							if (alice.getStand().equals("stand"))
								System.out.println("There is nowhere to sit");
							break;	
						case "stand":
							if (alice.getStand().equals(object))
								System.out.println("You are already standing");
							else
								alice.setStand(object);
							break;
						//player eats or drinks
						case "drink":
						case "eat":
						    System.out.println(object + " what?");
							break;
					}
				}	
			}
			
			else if (one.isVerb() && one.isNoun()) {
				switch (action) {
					//move player
					case "go":
						if (one.isDirection()) {
							switch (object) {
								case "n":
								case "north":
									if (room.getN() > -1) {
										alice.setDirection(room.getN());
									}
									else
										System.out.println("You can't go that way.");
									break;
								case "e":
								case "east":
									if (room.getE() > -1) {
										alice.setDirection(room.getE());
									}
									else
										System.out.println("You can't go that way.");
									break;
								case "s":
								case "south":
									if (room.getS() > -1) {
										alice.setDirection(room.getS());
									}
									else
										System.out.println("You can't go that way.");
									break;
								case "w":
								case "west":
									if (room.getW() > -1) {
										alice.setDirection(room.getW());
									}
									else
										System.out.println("You can't go that way.");
									break;
								case "ne":
								case "northeast":
									if (room.getNe() > -1) {
										alice.setDirection(room.getNe());
									}
									else
										System.out.println("You can't go that way.");
									break;
								case "nw":
								case "northwest":
									if (room.getNw() > -1) {
										alice.setDirection(room.getNw());
									}
									else
										System.out.println("You can't go that way.");
									break;
								case "se":
								case "southeast":
									if (room.getSe() > -1) {
										alice.setDirection(room.getSe());
									}
									else
										System.out.println("You can't go that way.");
									break;
								case "sw":
								case "southwest":
									if (room.getSw() > -1) {
										alice.setDirection(room.getSw());
									}
									else
										System.out.println("You can't go that way.");
									break;
							}
							
							/**decide if soldier appears*/
							boolean enemy = Characters.meetSoldier();
							System.out.println(enemy);
							if (enemy) {
								if ((alice.getDirection() > 4) && (alice.getDirection() < 12)) {
									//soldier drops spear and runs away
									if (spearCount < 1) {
										System.out.println("A red card soldier has appeared!");
										System.out.println("He is so surprised to see you he drops his spear and runs off!");
										room.getItemHolder().add(new Item("spear", "Spear.txt"));
										spearCount = 1;
									}
									//hat blows soldier away
									if (allowed.hasItem("hat"))
										aliceAction.hatResponse(alice);
									
									//player battles soldier
									if (spearCount > 0) {
										System.out.println("A red soldier appears! He immediately attacks!");
										fight.spearSuccess(alice);
									}
								}
							}
							
							//if statement for player leaving tea party while check if player standing
							if (room.getName().equals("Forest")) {
								ItemActions party = new ItemActions(alice);
								int stand = party.canLeaveStand(alice);
								room = map.get(stand);
							}
							
							//if statement for player leaving tea party while check if player sitting
							if (room.getName().equals("Mad Hatter's House")) {
								ItemActions tea = new ItemActions(alice);
								int stand = tea.canLeaveSit(alice);
								room = map.get(stand);
							}
							
							//method to describe location
							two.Describe(room, alice);
							
							//if statement to check for rose and display results while player in queens garden
							if (room.getName().equals("Red Queen's Garden")) {
								ItemActions garden = new ItemActions(alice);
								if (garden.queenResponse(alice))
									room = map.get(4);
				
							}
							
							//if statement to force player through rabbithole
							if (room.getName().equals("Rabbithole")) {
								room = map.get(4);
								alice.setDirection(4);
								room.descriptionDisplay();
								map.get(4).setCounter(1);
							}
							
							room = map.get(alice.getDirection());
							
							//update location counter variable
							(map.get(alice.getDirection())).setCounter((((map.get(alice.getDirection())).getCounter()) + 1));
						
						break;
						}
					
					//method for player to take items if allowed
					case "take":
						switch (object) {
							case "rose":
							case "gloves":
							case "spear":
							case "fan":
							case "key":
							case "sword":
							case "shield":
							case "cupcake":
							case "mushroomr":
							case "bottle":
							case "baby":
							case "mushrooml":
							case "hat":
							case "note":
								int aliceIndex = alice.getItemHolderIndex(object);
							    int roomIndex = getRoomItemIndex(object, room);
								if (aliceIndex > -1) {
									System.out.println("You aleady have the " + object);
								}
								else {
							        if ((roomIndex > -1) && (allowed.allowedToTake(object))) {
									(alice.getItemHolder()).add(room.getItemHolder().get(roomIndex));
									room.getItemHolder().remove(roomIndex);
									}
									else { 
										System.out.println("The " + object + "isn't available to take");
									}
								}
							    break;
						}
					    break;
					//method for player to drop items if allowed	
					case "drop":
						switch (object) {
							case "rose":
							case "gloves":
							case "spear":
							case "fan":
							case "key":
							case "sword":
							case "shield":
							case "cupcake":
							case "mushroom right side":
							case "bottle":
							case "baby":
							case "mushroom left side":
							case "hat":
							case "note":
							    int aliceIndex = alice.getItemHolderIndex(object);
								if (aliceIndex > -1) {
									room.getItemHolder().add(alice.getItemHolder().get(aliceIndex));
									(alice.getItemHolder()).remove(aliceIndex);	
								}
								else {
									System.out.println("You don't have the " + object);
								}
								    break;
						}
						break;
					case "swing":
						//method to fight jabberwocky
					    switch (object) {
							case "sword":
								if (fight.swordSuccess(alice)) {
									TextFileReader win = new TextFileReader("Jabberwocky Defeat.txt");
									System.out.println(win.contents());
									userExit = 1;
								}
								else {
									System.out.println("You've lost. Better luck next time.");
									userExit = 1;
								}
								break;
						}
						break;
					//method to check inventory and sanity points
					case "check":
						switch (object) {
							case "inventory":
							    for (int i = 0; i < (alice.getItemHolder().size()); i++) {
							    (alice.getItemHolder()).get(i).nameDisplay();
						    }
							    break;
							case "sanity":
							case "san":
								System.out.println(alice.getSanityPoints());
								break;
						}
						break;
					//method to talk to characters if allowed
					case "talk":
					    switch (object) {
							case "sister":
							case "mother":
							case "hatter":
							case "mouse":
							case "cat":
							case "rabbit":
								int characterIndex = getCharacterIndex(object);
								Characters character = characterList.get(characterIndex);
								int characterRoom = character.getCharacterLocation();
								character.characterTalk(alice, character);
								break;
							case "queen":
							case "duchess":
								System.out.println(object + " has no interest in talking to the likes of you!");
						}
						break;
					//method for player to drink bottle
					case "drink":
						switch (object) {
							case "bottle":
								if (alice.getItemHolderIndex("bottle") > -1) {
									if (room.getName().equals("Room of Locked Doors")) {
										int aliceSize = alice.getSize();
										if (aliceSize == 3) {
											alice.setSize(1);
											System.out.println("You shrink to very small. There is a cupcake nearby.");
										}
										if (aliceSize == 4) {
											alice.setSize(1);
											room = map.get(5);
											alice.setDirection(5);
											TextFileReader shrink = new TextFileReader("Door Room Shrink Two.txt");
											System.out.println(shrink.contents());
											int keyIndex = alice.getItemHolderIndex("key");
											if (keyIndex > -1) {
												alice.getItemHolder().remove(keyIndex);
											}
											int bottleIndex = alice.getItemHolderIndex("bottle");
											if (bottleIndex > -1) {
												alice.getItemHolder().remove(bottleIndex);
											}
											int cupcakeIndex = alice.getItemHolderIndex("cupcake");
											if (cupcakeIndex > -1) {
												alice.getItemHolder().remove(cupcakeIndex);
											}
											two.Describe(room, alice);
											(map.get(alice.getDirection())).setCounter((((map.get(alice.getDirection())).getCounter()) + 1));
											alice.setSize(3);
											map.get(4).getItemHolder().add(new Item("bottle", "Bottle.txt"));
											map.get(4).getItemHolder().add(new Item("cupcake", "Cupcake.txt"));
										}
									}
									if (room.getName().equals("Inside White Rabbit's House")) {
										alice.setSize(3);
										System.out.println("You are regular size again");
									}
								}
								else
									System.out.println("You don't have a bottle");
							    break;
						}
						break;
					//method for player to eat items
					case "eat":
					    switch (object) {
							case "cupcake":
							    if (allowed.hasItem("cupcake")) {
									alice.setSize(4);
									TextFileReader grow = new TextFileReader("Door Room Grow.txt");
									System.out.println(grow.contents());
								}
								else 
									System.out.println("You don't have the cupcake");
								break;
							case "mushroomr":
								if (allowed.hasItem("mushroomr")) {
									if (alice.getSize() < 4) {
										alice.setSize(alice.getSize() + 1);
										System.out.println("You've grown one size");
									}
									else
										System.out.println("You can't grow in taller");
								}
								else
									System.out.println("You don't have the " + object);
							    break;
							case "mushrooml":
								if (allowed.hasItem("mushrooml")) {
									if (alice.getSize() > 1) {
										alice.setSize(alice.getSize() - 1);
										System.out.println("You've shrunk one size");
									}
									else 
										System.out.println("You can't shrink any smaller");
								}
								else
									System.out.println("You don't have the " + object);
								break;
						}
						break;
					//method for player to use items
					case "use":
						switch (object) {
							case "gloves":
								if (allowed.hasItem("gloves")) {
								room = map.get(4);
								System.out.println("You are back in the locked door room");
								    if(allowed.hasItem("bottle")) {
										int bottleIndex = alice.getItemHolderIndex("bottle");
										alice.getItemHolder().remove(bottleIndex);
										System.out.println("The bottle slips out of your hands and is destroyed.");
									}
								}
								else
									System.out.println("You don't have the " + object);
								break;
							case "key":
								if (allowed.hasItem("key") && room.getName().equals("Room of Locked Doors")) {
									System.out.println("You've unlocked and opened the small door. You see a beautiful garden on the other side");
									open = 1;
								}
								else
									System.out.println("You don't have the " + object);
								break;
							case "fan":
								if (allowed.hasItem("fan")) {
									alice.setSize(4);
									if (room.getName().equals("Inside White Rabbit's House")) 
									System.out.println("You can reach the gloves now");	
								}
								else
									System.out.println("You can't don't have the " + object);
								break;
						}
				}
			
			}
			else
				System.out.println("I don't know what you mean.");
			
			//end game if player loses all sanitypoints
			if (alice.getSanityPoints() < 1) {
				System.out.println("Your fear was too great and you've lost all your sanity points. You have lost the game. Good Luck Next Time.");
				userExit = 1;
			}
			
			//if statements to place sword, shield, and gloves in original positions
			if (map.get(9).getItemHolderIndex("sword") < 0) {
				map.get(9).getItemHolder().add(new Item("sword", "Sword.txt"));
			}
			if (map.get(9).getItemHolderIndex("shield") < 0) {
				map.get(9).getItemHolder().add(new Item("shield", "Shield.txt"));
			}
			if (map.get(4).getItemHolderIndex("gloves") > -1) {
				int glovesIndex = map.get(4).getItemHolderIndex("gloves");
				map.get(4).getItemHolder().remove(glovesIndex);
				System.out.println("The White Rabbit is upset that his gloves are on the ground!");
				System.out.println("He has taken them back!");
			}
			
			//allow player to access queen's garden once key is used
			if (two.doorIsOpen(open))
				map.get(4).setW(12);
			
		} while (userExit != 1);
	}
	
} //end of class Room	