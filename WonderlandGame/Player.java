/**
 * title: Player.java
 * description: An constuctor that creates the main player
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
 * Player
 *
 * Purpose and Description
 *
 * A constructor that creates characters
 *
 * This progam is a constructor the creates the main player and methods for the player
 *
 * Compiling and running instructions assuming JDK 20.0.1 is installed
 * Compile:    javac Wonderland.java
 * Run:        java Wonderland
 */
 
/**
 *
 * Classes
 *
 * public class Player
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

/** primary (public) class for Player */
public class Player extends Item {
    
	// Initialize and set default variables
	private String stand;
	static int sanityPoints;
	private int direction, size, hitPoints;
	private ArrayList<Item> itemHolder;
	
	/**Constructor to create Player object*/
    public Player(String newName, String newDescription, int newDirection, int newSize, int newSanityPoints, int newHitPoints, ArrayList<Item> newItemHolder, String newStand) {
		
		super(newName, newDescription);
		this.direction = newDirection;
		this.size = newSize;
		this.sanityPoints = newSanityPoints;
		this.hitPoints = newHitPoints;
		this.itemHolder = newItemHolder;
		this.stand = newStand;
	}	
	
	//get and set methods for player
	public int getDirection() {
		return direction;
	}
	
	public void setDirection(int newDirection) {
		this.direction = newDirection;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int newSize) {
		this.size = newSize;
	}
	
	static int getSanityPoints() {
		return sanityPoints;
	}
	
	static void setSanityPoints(int newSanityPoints) {
		sanityPoints = newSanityPoints;
	}
	
	public int getHitPoints() {
		return hitPoints;
	}
	
	public void setHitPoints(int newHitPoints) {
		this.hitPoints = newHitPoints;
	}
	
	public String getStand() {
		return stand;
	}
	
	public void setStand(String newStand) {
		this.stand = newStand;
	}
	
	public ArrayList<Item> getItemHolder() {
		return itemHolder;
	}
	
	//method to search though player inventory
	public int getItemHolderIndex(String wanted){
			for(int i = 0; i< itemHolder.size(); i++){
				if(getItemHolder().get(i).getName().equals(wanted)){
					return i;
				}
			}
			return -1;
		}
	
} //end of Player class