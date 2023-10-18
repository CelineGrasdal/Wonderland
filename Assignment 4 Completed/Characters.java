/**
 * title: Characters.java
 * description: An constuctor that creates characters
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
 * Characters
 *
 * Purpose and Description
 *
 * A constructor that creates characters
 *
 * This progam is a constructor the creates characters and methods for characters.
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
 * public class Characters
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
  
/** primary (public) class for Characters */
public class Characters extends Item {
	
	// Initialize and set default variables
	static double soldierCount = 0;
	private int characterLocation;
	private String talk;
	static String roomName;
	static double max = 11;
	static double min = 1;
	
	/**Constructor to create characters objects*/
    public Characters(String newName, String newDescription, int newCharacterLocation, String newTalk, String RoomName) {
		
		super(newName, newDescription);
		this.characterLocation = newCharacterLocation;
		this.talk = newTalk;
		roomName = RoomName;
	}
	
	//Get and set methods for Characters
	public int getCharacterLocation() {
		return characterLocation;
	}
	
	public void setCharacterLocation(int newCharacterLocation) {
		characterLocation = newCharacterLocation;
	}
	
	public String getTalk() {
		return talk;
	}
	
	public void setTalk(String newTalk) {
		talk = newTalk;
	}
	
	static String getRoomName() {
		return roomName;
	}
	
	// method to randomize chance of soldier encounter
	static boolean meetSoldier() {
		
		soldierCount = Math.floor(Math.random()*(max-min+1)+min);
		if (soldierCount > 5)
			return true;
		else
			return false;
	}
	
	public void talkDisplay(String object) {
		TextFileReader myFile = new TextFileReader(talk);
		myFile.contents();
		System.out.println(myFile.contents());
	}
	
	//change rabbit position when player reaches tea party
	public void characterTalk(Player alice, Characters object) {

		if (alice.getDirection() == 10) {
			Game.characterList.get(5).setCharacterLocation(10);
			Game.characterList.get(5).setTalk("White Rabbit B.txt");
		}
		
	if (alice.getDirection() == object.getCharacterLocation()) {
			talkDisplay(object.getTalk());
		}
		
	else 
		System.out.println(object.getName() + " isn't here");
	}
	
} //end of Characters class

