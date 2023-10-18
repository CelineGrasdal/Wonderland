/**
 * title: Visits.java
 * description: An application that stores descriptions for the locations in the game
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
 * Visits
 *
 * Purpose and Description
 *
 * An application that stores descriptions for the locations in the game
 *
 * This progam stores the descriptions for the locations in the game in three array lists
 *
 * Compiling and running instructions assuming JDK 20.0.1 is installed
 * Compile:    javac Wonderland.java
 * Run:        java Wonderland
 */
 
/**
 *
 * Classes
 *
 * public class Visits
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

/** primary (public) class for Visits */
public class Visits {
	
	/** Initialize and set default ArrayLists*/
	public ArrayList <String>firstVisit;
	public ArrayList <String>secondVisit;
	public ArrayList <String>changedVisit;
    
	/** Method to store descriptions */
	public Visits () {
		
		this.firstVisit = new ArrayList<String>();
		this.secondVisit = new ArrayList<String>();
		this.changedVisit = new ArrayList<String>();
	
	Collections.addAll(firstVisit, "Alice's House.txt", "Field with Stream.txt", "Field with Rabbit Hole.txt", "Rabbit Hole.txt", "Door Room.txt", "Outside Rabbit House.txt", "Inside Rabbit House.txt", "Duchess House.txt", "Forest.txt", "Cave.txt", "Tea Party.txt", "Mad Hatter's House.txt", "Queen's Garden.txt");
	
	Collections.addAll(secondVisit, "Alice's House 2.txt", "Field with Stream 2.txt", "Field with Rabbit Hole 2.txt", "Rabbit Hole 2.txt", "Door Room 2.txt", "Outside Rabbit House 2.txt", "White Rabbit's House 2.txt", "Duchess House 2.txt", "Forest 2.txt", "Cave 2.txt", "Tea Party 2.txt", "Mad Hatter's House 2.txt", "Queen's Garden 2.txt");
	
	Collections.addAll(changedVisit, "Duchess House Baby.txt", "Duchess House No Baby.txt", "Forest Pig.txt", "Cave Sword.txt");
	
    }
	
	public ArrayList<String> getSecondVisit() {
		return secondVisit;
	}
	
	//method to return location description for second visit after first visit to location
	public int getVisitsIndex(String wanted) {
		for (int i = 0; i < secondVisit.size(); i++) {
			if (firstVisit.get(i).equals(wanted)) {
				return i;
			}
		}
		 return -1;
	}
} //end of class Visits