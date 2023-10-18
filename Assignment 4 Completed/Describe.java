/**
 * title: Describe.java
 * description: An application that displays the descriptions of the locations
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
 * Describe
 *
 * Purpose and Description
 *
 * An application that displays the descriptions of the locations
 *
 * This progam displays the descriptions and room names of the locations.
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
 * Compile:    javac Wonderland.java
 * Run:        java Wonderland
 */
 
/**
 *
 * Classes
 *
 * public class Describe
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
 *    'talk sister' -> output should be : If you want to be treated like a grown-up, you have 
 *    to stop being scared of everything. You could start by exploring the carrot field to the 
 *    1east of here by yourself.
 *    'i' -> output should be a list of items the user currently has.
 *    'quit' -> output should be: You have exited the game. You will have to start again.
 *    'take rose' -> output should be: You aleady have the rose
 *                 or output should be: The rose isn't available to take
 *                 or output should be whitespace
 * ACTUAL:
 *    Results displayed as expected.
 * 3. Bad data cases:
 * EXPECTED:
 *    Run the following test cases by typing the input value and pressing enter:
 *    'run around' -> output should be: I don't know what you mean.
 *    '3' -> output should be: I don't know what you mean.
 *    'go run' -> output should be: I don't know what you mean.
 *    'take rose please' -> output should be: You already have the rose
 *                         or output should be: The rose isn't available to take
 *                         or output should be whitespace
 * ACTUAL:
 *    Results displayed as expected.
 *
 */

 /**
  * CODE
  */
  
/** Java core packages */
import java.util.*;

/**primary (public) class for Game */
public class Describe extends Game{
	 
	//Create Visits instance
	Visits one = new Visits();
	
	//Method to describe locations and rooms
	public void Describe(Location room, Player alice) {
	
		room.nameDisplay();
		System.out.println();
		String wanted = room.getName();
		int i;
			
			//determine which description to use snd display description
			if (room.getCounter() > 0) {
				i = getRoomIndex(wanted);
				TextFileReader repeatVisit  = new TextFileReader(one.secondVisit.get(i));
				repeatVisit.contents();
				System.out.println(repeatVisit.contents());
			}
			
			else
				{
				room.descriptionDisplay();
				} 
			duchessBaby(room,alice);
	}
	
		//change description of two rooms when certain conditons are met
		public void duchessBaby(Location room, Player alice) 	{
		
			if ((room.getName().equals("Duchess's House")) && room.getCounter() > 1) {
				if (getRoomItemIndex("baby", room) > -1) {
					TextFileReader hasBaby = new TextFileReader(one.changedVisit.get(0));
					hasBaby.contents();
					System.out.println(hasBaby.contents());
				}
				else {
					TextFileReader noBaby = new TextFileReader(one.changedVisit.get(1));
					noBaby.contents();
					System.out.println(noBaby.contents());
				}
			}
			
			if ((room.getName().equals("Forest")) && (alice.getItemHolderIndex("baby") > -1)) {
				TextFileReader forestBaby = new TextFileReader(one.changedVisit.get(2));
				System.out.println(forestBaby.contents());
				room.getItemHolder().add(new Item("rose", "Red Rose.txt"));
				alice.getItemHolder().remove(alice.getItemHolderIndex("baby"));	
			}
			
			if (room.getName().equals("Forest")) {
				int hasSword = (alice.getItemHolderIndex("sword"));
				int hasShield = (alice.getItemHolderIndex("shield"));
				if (hasSword > -1 || hasShield > -1) {
					TextFileReader caveSword = new TextFileReader(one.changedVisit.get(3));
					System.out.println(caveSword.contents());
					if (hasSword > -1) {
						room.nameDisplay();
						int aliceIndex = alice.getItemHolderIndex("sword");
						alice.getItemHolder().remove(alice.getItemHolderIndex("sword"));
					}
					if (hasShield > -1) {
						alice.getItemHolder().remove(alice.getItemHolderIndex("shield"));
					}
				}
			
			}
		}
		
		//method to return statis of door to queen's garden
		public boolean doorIsOpen (int open) {
			
			if (open > 0)
				return true;
			return false;
			
		}
	
} // end of Describe class