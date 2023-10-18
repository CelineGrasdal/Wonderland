/**
 * title: Actions.java
 * description: An application that stores allowed words
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
 * Actions
 *
 * Purpose and Description
 *
 * An application that stores allowed words
 *
 * This progam stores allowed words in three arraylists
 *
 * Compiling and running instructions assuming JDK 20.0.1 is installed
 * Compile:    javac Wonderland.java
 * Run:        java Wonderland
 */
 
/**
 *
 * Classes
 *
 * public class Actions
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

/** primary (public) class for Actions */
public class Actions extends Game {
	
	/** Intialize and set default ArrayLists*/
	private ArrayList<String> verb = new ArrayList<String>();
	private ArrayList<String> noun = new ArrayList<String>();
	private ArrayList<String> nounVerb = new ArrayList<String>();
	private ArrayList<String> actionDirection = new ArrayList<String>();
	
	/** Method to store allowed words */
	public Actions() {

		Collections.addAll(nounVerb, "n", "s", "e", "w", 
						"north", "south", "east", "west", 
						"northeast", "northwest", "southeast", "southwest", 
						"ne", "nw", "se", "sw", 
						"q", "quit", "san", "sanity", "i", "inventory", 
						"sit", "stand", "drink");
		
		Collections.addAll(verb, "go", "take", "swing", "check", "talk", "eat", "drink", "drop", "use");
		
		Collections.addAll(noun, "sword", "chair", "bottle", "cupcake", "sister", "mother", "rabbit", "hatter", "queen", "shield", "mouse", "duchess", "n", "north", "s", "south", "e", "east", "w", "west", "ne", "northeast", "nw", "northwest", "se", "southeast", "sw", "southwest", "note", "hat", "baby", "cat", "spear", "i", "inventory", "san", "sanity", "key", "mushroomr", "mushrooml", "rose", "gloves", "fan");
		
		Collections.addAll(actionDirection, "n", "s", "e", "w", "north", "south", "east", "west", "northeast", "northwest", "southeast", "southwest", "ne", "nw", "se", "sw");
	}
	
	// Get methods for allowed words
	public ArrayList getVerb() {
		return verb;
	}
	
	public ArrayList getNoun() {
		return noun;
	}
	
	public ArrayList getNounVerb() {
		return nounVerb;
	}
	
	public ArrayList actionDirection() {
		return actionDirection;
	}
} //end of class Actions