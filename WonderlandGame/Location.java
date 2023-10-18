/**
 * title: Location.java
 * description: A constructor to create Items for the game
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
 * Location
 *
 * Purpose and Description
 *
 * A constructor to create Locations for the game
 *
 * This progam is a constructor that can be used to create Locations for the game
 *
 * Compiling and running instructions assuming JDK 20.0.1 is installed
 * Compile:    javac Wonderland.java
 * Run:        java Wonderland
 */
 
/**
 *
 * Classes
 *
 * public class Location
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

/**primary (public) class for Location */
public class Location extends Item {
	
	// Initialize and set default variables
    private int n, s, e, w, nE, nW, sE, sW, counter;
	private ArrayList<Item> itemHolder;
	
	/*Constructor to create Location object*/
    public Location(String newName, String newDescription, int newN, int newS, int newE, int newW, int newNe, int newNw, int newSe, int newSw, int newCounter, ArrayList<Item> newItemHolder) {
		super(newName, newDescription);
		this.n = newN;
		this.s = newS;
		this.e = newE;
		this.w = newW;
		this.nW = newNw;
		this.nE = newNe;
		this.sW = newSw;
		this.sE = newSe;
		this.counter = newCounter;
		this.itemHolder = newItemHolder;
	}
	
	//get and set methods for location
	public int getCounter() {
		return counter;
	}
	
	public void setCounter(int newCounter) {
		this.counter = newCounter;
	}
	
	public int getN() {
	    return n;
	}
	
	public void setN(int newN) {
	    this.n = newN;
	}
	
	public int getS() {
	    return s;
	}
	
	public void setS(int newS) {
	    this.s = newS;
	}
	
	public int getE() {
	    return e;
	}
	
	public void setE(int newE) {
	    this.e = newE;
	}
	
	public int getW() {
	    return w;
	}
	
	public void setW(int newW) {
	    this.w = newW;
	}
	
	public int getNw() {
		return nW;
	}
	
	public void setNw(int newNw) {
		this.nW = newNw;
	}
	
	public int getNe() {
		return nE;
	}
	
	public void setNe(int newNe) {
		this.nE = newNe;
	}
	
	public int getSw() {
		return sW;
	}
	
	public void setSw(int newSw) {
		this.sW = newSw;
	}
	
	public int getSe() {
		return sE;
	}
	
	public void setSe(int newSe) {
		this.sE = newSe;
	}
	
	public ArrayList<Item> getItemHolder() {
		return itemHolder;
	}
	
	//method to search for item in location inventory
	public int getItemHolderIndex(String wanted){
			for(int i = 0; i< itemHolder.size(); i++){
				if(getItemHolder().get(i).getName().equals(wanted)){
					return i;
				}
			}
			return -1;
		}
} //end of Location class