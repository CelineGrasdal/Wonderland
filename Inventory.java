/**
 * title: Inventory.java
 * description: An application that checks for items in the player's inventory
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
 * Inventory
 *
 * Purpose and Description
 *
 * An application that checks for items in the player's inventory
 *
 * This progam checks for items in the player's inventory and determines if player is allowed to take
 * certain items
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
 * Inventory
 *
 * public class Inventory
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

/** primary (public) class for Inventory */
public class Inventory extends Room{
	
	//default value for class
	public Inventory(Player newAlice) {
		
		this.alice = newAlice;
		
	}
	
	//method to check if player has item in their inventory
	public boolean hasItem(String item) {
		int aliceItemIndex = alice.getItemHolderIndex(item);
		if (aliceItemIndex > -1)
			return true;
		else
			return false;
	}
	
	//method to check if player is right size to take certain items
	public boolean allowedToTake(String object) {
		int aliceSize = alice.getSize();
		if (object.equals("gloves") && (aliceSize < 4))
			return false;
		
		if (object.equals("cupcake") && (aliceSize > 1))
			return false;
		
		if (object.equals("key") && (aliceSize != 2)) {
			if (aliceSize > 2) 
				System.out.println("The key is small for you to grab");
			if (aliceSize < 2)
				System.out.println("The key is out of your reach");
			return false;
		}
		else
			return true;
	}

} // end of class Inventory