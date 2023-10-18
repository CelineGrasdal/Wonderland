/**
 * title: Game.java
 * description: An application that stores the locations and items of the game
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
 * Game
 *
 * Purpose and Description
 *
 * An application that stores the locations and items of the game
 *
 * This progam stores locations and items of the game in ArrayLists
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
 * public class Game
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
public class Game {
		
		/** Initialize and set default ArrayLists*/
		public ArrayList <Location>map;
		public ArrayList <Item>doorItems;
		public ArrayList <Item>items;
		public ArrayList <Item>outItems;
		public ArrayList <Item>inItems;
		public ArrayList <Item>duchessItems;
		public ArrayList <Item>forestItems;
		public ArrayList <Item>caveItems;
		public ArrayList <Item>partyItems;
		public ArrayList <Item>madItems;
		public ArrayList <Item>redItems;
		static ArrayList <Characters>characterList;
		
		//Method to store Items and Locations
		public Game() {
			
			this.map = new ArrayList<Location>();
			this.doorItems = new ArrayList<Item>();
			this.items = new ArrayList<Item>();
			this.outItems = new ArrayList<Item>();
			this.inItems = new ArrayList<Item>();
			this.duchessItems = new ArrayList<Item>();
			this.forestItems = new ArrayList<Item>();
			this.caveItems = new ArrayList<Item>();
			this.partyItems = new ArrayList<Item>();
			this.redItems = new ArrayList<Item>();
			this.madItems = new ArrayList<Item>();
			this.characterList = new ArrayList<Characters>();
			
			
			//Alice's House
			map.add(new Location("Alice's House", "Alice's House.txt", Direction.NOEXIT, Direction.NOEXIT, 1, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 0, items));
			
			//Field with the stream
			map.add(new Location("Field with Stream", "Field with Stream.txt", Direction.NOEXIT, Direction.NOEXIT, 2, 0, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 1, items ));
			
			//Field with the RabbitHole
			map.add(new Location("Field with Rabbithole", "Field with Rabbit Hole.txt", Direction.NOEXIT, Direction.NOEXIT, 3, 1, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 0, items));
			
			//RabbitHole
			map.add(new Location("Rabbithole", "Rabbit Hole.txt", Direction.NOEXIT, 4, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 0, items));
			
			//Locked Doors Room
			map.add(new Location("Room of Locked Doors", "Door Room.txt", Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 0, doorItems));
			
			//Outside White Rabbit's House
			map.add(new Location("Outside White Rabbit's House", "Outside Rabbit House.txt", 7, 11, 6, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 0, outItems));
			
			//Inside White Rabbit's House
			map.add(new Location("Inside White Rabbit's House", "Inside Rabbit House.txt", Direction.NOEXIT, Direction.NOEXIT, 8, 5, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 0, inItems));
			
			//Duchess House
			map.add(new Location("Duchess's House", "Duchess House.txt", Direction.NOEXIT, 8, 11, 5, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 0, duchessItems));
			
			//Forest
			map.add(new Location("Forest", "Forest.txt", 7, 9, 10, 6, Direction.NOEXIT, Direction.NOEXIT, 11, Direction.NOEXIT, 0, forestItems));
			
			//Cave
			map.add(new Location("Cave", "Cave.txt", 8, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 0, caveItems));
			
			//Tea Party
			map.add(new Location("Tea Party", "Tea Party.txt", Direction.NOEXIT, 11, Direction.NOEXIT, 8, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 0, partyItems));
			
			//Mad Hatter's House
			map.add(new Location("Mad Hatter's House", "Mad Hatter's House.txt", Direction.NOEXIT, 5, 7, Direction.NOEXIT, Direction.NOEXIT, 8, Direction.NOEXIT, Direction.NOEXIT, 0, madItems));
			
			//Red Queen's Garden
			map.add(new Location("Red Queen's Garden", "Queen's Garden.txt", Direction.NOEXIT, Direction.NOEXIT, 4, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 0, redItems));
			
			inItems.add(new Item("gloves", "White Gloves.txt"));
			inItems.add(new Item("fan", "Fan.txt"));
			inItems.add(new Item("bottle", "Fan.txt"));
			doorItems.add(new Item("key", "Key.txt"));
			caveItems.add(new Item("sword", "Sword.txt"));
			caveItems.add(new Item("shield", "Shield.txt"));
			doorItems.add(new Item("cupcake", "Cupcake.txt"));
			doorItems.add(new Item("bottle", "Bottle.txt"));
			duchessItems.add(new Item("baby", "Baby.txt"));
			forestItems.add(new Item("mushroomr", "Mushroom Right Side.txt"));
			forestItems.add(new Item("mushrooml", "Mushroom Left Side.txt"));
			partyItems.add(new Item("hat", "Mad Hatter's Hat.txt"));
			madItems.add(new Item("note", "Note.txt"));
			
			characterList.add(0, (new Characters("hatter", "Mad Hatter.txt", 10, "Mad Hatter Talk.txt", "Mad Hatter's House")));
			characterList.add(1, (new Characters("mouse", "Doormouse.txt", 10, "Doormouse Talk.txt", "Mad Hatter's House")));
			characterList.add(2, (new Characters("mother", "Mother.txt", 0, "Mother Talk.txt", "Alice's House")));
			characterList.add(3, (new Characters("sister", "Sister.txt", 1, "Sister Talk.txt", "Field with Stream")));
			characterList.add(4, (new Characters("cat", "Cat.txt", 8, "Cat Talk.txt", "Forest")));
			characterList.add(5, (new Characters("rabbit", "Rabbit.txt", 5, "White Rabbit Talk C.txt", "Outside White Rabbit's House")));
		}
		
		//Get methods for index storage number of locations, items, and characters.
		public int getRoomItemIndex(String item, Location room) {
		    for (int i = 0; i < room.getItemHolder().size(); i++) {
				if (room.getItemHolder().get(i).getName().equals(item)) {
					return i;
				}
			}
			return -1;
		}
		
		public int getRoomIndex(String wanted) {
			for (int i = 0; i < map.size(); i++) {
				if (map.get(i).getName().equals(wanted)) {
					return i;
				}
			}
			return -1;
		}
		
		public int getCharacterIndex(String character) {
			for (int i = 0; i < characterList.size(); i++) {
				if (characterList.get(i).getName().equals(character)) {
					return i;
				}
			}
			return -1;
		}
		
} // end of class Game