/**
 * title: ItemsActions.java
 * description: An application that determines the effects of items
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
 * ItemsActions
 *
 * Purpose and Description
 *
 * An application that determines the effects of items
 *
 * This progam has methods that change the status of the game or the player when items are used
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
 * public class ItemActions
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

/** primary (public) class for ItemActions */  
public class ItemActions extends Room {
	
	//default value for class
	public ItemActions(Player alice) {
	
		this.alice = alice;
	
	}
	
	//Method for rose item to allow player to remain in queen's garden or not
	public boolean queenResponse(Player alice) {
		Inventory check = new Inventory(alice);
		
		if (check.hasItem("rose")) {
			TextFileReader rose = new TextFileReader("Queen Rose.txt");
			System.out.println(rose.contents());
			return false;
		}	
		else {
			TextFileReader noRose = new TextFileReader("Queen No Rose.txt");
			System.out.println(noRose.contents());
			return true;
		}
	}
	
	//Method for hat item to deal with soldier
	public void hatResponse(Player alice) {
	    Inventory hatCheck = new Inventory(alice);
		
		if (hatCheck.hasItem("hat")) { 
			System.out.println("The playing card soldiers are blown away by the hat.");
		}
		else {
			System.out.println("You don't have the hat");
		}
	}
	
	//4 Methods for eat and drink items to affect player size
	public void eatCake(Player alice) {
		
		Inventory cakeCheck = new Inventory(alice);
		
		if (cakeCheck.hasItem("cupcake")) {
			alice.setSize(4);
		}
		else {
			System.out.println("You don't have a cupcake");
		}
	}
	
	public void eatRight(Player alice) {
		
		Inventory rightCheck = new Inventory(alice);
		
		if (rightCheck.hasItem("mushroom right side")) {
			alice.setSize(alice.getSize() + 1);
		}
		else {
			System.out.println("You don't have mushroom right side");
		}
	}
	
	public void eatLeft(Player alice) {
		
		Inventory leftCheck = new Inventory(alice);
		
		if (leftCheck.hasItem("mushroom left side")) {
			alice.setSize(alice.getSize() - 1);
		}
		else {
			System.out.println("You don't have the mushroom left side");
		}
	}
	
	public void drink(Player alice) {
		
		this.alice = alice;
		
		Inventory bottleCheck = new Inventory(alice);
		
		if (bottleCheck.hasItem("bottle")) {
			int aliceSize = alice.getSize();
			if (aliceSize == 3) {
			alice.setSize(1);
			System.out.println("You shrink to very small. There is a cake nearby.");
			}
			if (aliceSize == 4) {
			    alice.setSize(1);
				TextFileReader  shrink = new TextFileReader("Door Room Shrink Two.txt");
				int bottleIndex = alice.getItemHolderIndex("bottle");
				int keyIndex = alice.getItemHolderIndex("key");
				alice.getItemHolder().remove(bottleIndex);
				if (keyIndex > -1) {
					alice.getItemHolder().remove(keyIndex);
				}
			}
		}
		else {
			System.out.println("You don't have the bottle");
		}
	}
	
	//method for fan to affect player size
	public void fan(Player alice) {
		
		Inventory fanCheck = new Inventory(alice);
		
		if (fanCheck.hasItem("fan")) {
			alice.setSize(2);
		}
		else {
			System.out.println("You don't have the fan");
		}
	}
	
	//method for player to read note
	public void note(Player alice) {
		
		Inventory noteCheck = new Inventory(alice);
		
		if (noteCheck.hasItem("note")) {
			TextFileReader read = new TextFileReader("Note.txt");
			System.out.println(read.contents());
		}
		else {
			System.out.println("You don't have the note");
		}
	}
	
	//method for key to unlock garden door
	public void key(Player alice) {
		
		Inventory keyCheck = new Inventory(alice);
		
		if (keyCheck.hasItem("key")) {
			System.out.println("You unlock the door");
		}
		else {
			System.out.println("You don't have the key");
		}
	}
	
	// three methods for effects of player standing and sitting
	public boolean isStanding (Player alice) {
		
		if (alice.getStand().equals("stand"))
			return true;
		else
			return false;
	}
	
	public int canLeaveStand(Player alice) {
		
		if (isStanding(alice)) {
			return 8;
		}
		else 
			System.out.println("You can't walk while sitting down!");
			
			return 10;
	}
	
	public int canLeaveSit(Player alice) {
		
		if (isStanding(alice)) {
			System.out.println("You can't use the slide while standing!");
			return 10;
		}
		else
			alice.setStand("stand");
			System.out.println("That was a wild slide! No way can you climb back up that!");
			System.out.println("You stand up and look around.");
			return 11;
	}
} // end of class ItemActions