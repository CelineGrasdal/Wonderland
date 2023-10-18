/**
 * title: Control.java
 * description: An application that takes user input and checks it against allowed words.
 * date: September 30, 2022
 * @author Celine Grasdal
 * @version 1.0
 * AU ID: 3556933
 * this code uses code from AdventureGame.java by Huw Collingbourne
 */
 
/**
 * DOCUMENTATION
 */
  
/**
 * Celine Grasdal
 * AU ID: 3556933
 * September 30, 2022
 *
 * Control
 *
 * Purpose and Description
 *
 * An application that takes user input and checks it against against allowed words.
 *
 * This progam takes user input from the command line box, splits it by word, and checks 
 * the first two words against the allowed words in the Actions class.
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
 * public class Control
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
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io. IOException;

/** primary (public) class for Control */
public class Control extends Game {
	
	/** Intialize and set default variables */
	private String action;
	private String object;
	Actions one = new Actions();  // Create new Actions object
	String[] wordList;
	boolean verb;
	boolean noun;
	boolean nounVerb;
	boolean isDirection;
	
	/** Method to handle user input */
	public void Control() {
		
		//method to accept user input
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//method to split user input by word and store in wordList
		try {
			
			wordList = in.readLine().split(" ");
			if (wordList.length > 1) {
				
				object = wordList[1].toLowerCase();
				action = wordList[0].toLowerCase();
			}
			
			else {
				object = wordList[0].toLowerCase();
			}
		}
		//method to catch buffered reader errors
		catch (IOException e) {
			System.out.println ("The buffered reader in Control class has an issue.");
		}
	}
	
	/** Method to call wordList */
	public String[] getWordList() {
		return wordList;
	}
	
	/** Method to call object variable */
	public String getObject() {
		return object;
	}
	
	/** Method to call action variable */
	public String getAction() {
		return action;
	}
	
	/** Method to check action variable against verb list in Actions class */
	public boolean isVerb() {
		if ((wordList.length > 1) &&((one.getVerb()).contains(action))) {
			verb = true;
		}
		return verb;
	}
	
	/** Method to check object variable against noun list in Actions class */
	public boolean isNoun() {
		if ((wordList.length > 1) &&((one.getNoun()).contains(object))) {
		    noun = true;
		}
		return noun;
	}
	
	/** Method to check if user input is one word and is in nounVerb list in Actions class */
	public boolean isNounVerb() {
		if ((wordList.length == 1) &&((one.getNounVerb()).contains(object))) {
		    nounVerb = true;
		}
		return nounVerb;
	}
	
	/** Method to check if object is a direction */
	public boolean isDirection() {
		if ((one.actionDirection()).contains(object)) {
			isDirection = true;
		}
		return isDirection;
	}
}  // end of class Control
