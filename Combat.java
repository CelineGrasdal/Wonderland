/**
 * title: Combat.java
 * description: An application that intiates a combat sequence when certain conditions are met.
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
 * Combat
 *
 * Purpose and Description
 *
 * An application that initiates a combat sequence when certain conditions are met.
 *
 * This progam initiates a combat sequence when user input = 'swing sword' or at random times 
 * when alice direction varible is greater than 4. The sequence then intiates one of two
 * methods depending on certain conditions. 
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
 * public class Combat
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
 *    Run the following test cases :
 *    Play the game until combat is initiated randomly ->
 *      Output if player has the spear should be : 
 *					text = 'You have the spear'
 *					text = 'The soldier has taken' + enemySpearDamage
 *					text = 'He has ' + enemyHitPoints + ' left'
 *					text = 'You have taken' + aliceSpearDamage
 *					text = 'You have ' + aliceHitPoints + ' left'
 *					text = 'The fight continues..'
 *					text = whitespace
 *					text = whitespace
 *					text = whitespace
 *		Output repeats from 'The soldier has taken' + enemySpearDamage until either alice
 * 		or enemy has 0 hitPoints left.
 *		Output if player doesn't have the spear should be :
 *					text = 'This will be a quick fight. Spear beats hands.'
  *					text = 'He has ' + enemyHitPoints + ' left'
 *					text = 'You have taken' + aliceSpearDamage
 *					text = 'You have ' + aliceHitPoints + ' left'
 *					text = 'The fight continues..'
 *					text = whitespace
 *					text = whitespace
 *					text = whitespace
 *		Output repeats from 'The soldier has taken' + enemySpearDamage until either alice
 *      or enemy has 0 hitPoints left.
 *		If player wins text = 'You have won the battle!'
 *		If player loses text = 'You have lost the battle! And lost a sanity point.'
 *    Play the game until player direction variable = 12 and player has rose. 
 *	  Type swing sword ->
 *      Output if player has sword and shield should be:
 *					text = 'You have the shield. It gives you 50 more hit points!'
 *					text = 'The Jabberwocky has taken' + enemySwordDamage
 *					text = 'He has ' + enemyHitPoints + ' left
 *					text = 'You have taken' + aliceSwordDamage
 *					text = 'You have ' + aliceHitPoints + ' left'
 *					text = 'The fight continues..'
 *					text = whitespace
 *					text = whitespace
 *					text = whitespace
 *       Output repeats from 'The Jabberwocky has taken' + enemySwordDamage until either
 *		 alice or enemy has 0 hitPoints left.
 *		Output if player has sword should be:
 *					text = 'You don't have the shield'
  *					text = 'The Jabberwocky has taken' + enemySwordDamage
 *					text = 'He has ' + enemyHitPoints + ' left
 *					text = 'You have taken' + aliceSwordDamage
 *					text = 'You have ' + aliceHitPoints + ' left'
 *					text = 'The fight continues..'
 *					text = whitespace
 *					text = whitespace
 *					text = whitespace
 *       Output repeats from 'The Jabberwocky has taken' + enemySwordDamage until either
 *		 alice or enemy has 0 hitPoints left.
 *		Output if player doesn't have the sword should be:
 *					text = You don't have the sword. The Jabberwocky ignores you.'
 * ACTUAl:
 *    Command box displays as expected.
 */

 /**
  * CODE
  */
  
/** Java core packages */
import java.util.Random;

/** primary (public) class for Combat */
public class Combat extends Room {
	
	/** Intialize and set default variables */
	private int aliceHitPoints;
	private int enemyHitPoints;
	Random rand = new Random();
	private String object;
	
	/** Combat constructor to call comabat constructor methods */
	// constructor accepts input from Room for Player and String
	public void Combat (Player alice, String object) {
		
		//set instance variables
		this.alice = alice;
		this.object = object;
		
		//if statement to initiate combat method dependant on object variable
		if (object.equals("sword"))
		    swordSuccess(alice);
		
		else if (object.equals("spear"))
		    spearSuccess(alice);
	}
	
	/** Method to handle soldier battle */
	public boolean spearSuccess(Player alice) {
		
		//set method variables
		int min = 50;
		int max = 100;
		int enemyUpperbound;
		int aliceUpperbound;
		int enemySpearDamage;
		//use Math.random() to set random amount of enemy hitPoints
		enemyHitPoints = (int)Math.floor(Math.random()*(max-min+1)+min);
		int aliceHitPoints = 100;
		int aliceIndex = alice.getItemHolderIndex("spear");
		
		//if statement to determime is player has spear
		if (aliceIndex > -1) {
			enemyUpperbound = 25;
			System.out.println();
			System.out.println("You have the spear");
			System.out.println();
		}
		else {
			System.out.println();
			System.out.println("This will be a quick fight. Spear beats hands.");
			enemyUpperbound = 1;
		}
		
		// do while loop to determine and display battle results
		do {
			enemySpearDamage = rand.nextInt(enemyUpperbound);
			enemyHitPoints = enemyHitPoints - enemySpearDamage;
			
			aliceUpperbound = 25;
			int aliceSpearDamage = rand.nextInt(aliceUpperbound);
			aliceHitPoints = aliceHitPoints - aliceSpearDamage;
			
			System.out.println("The soldier has taken" + enemySpearDamage);
			System.out.println("He has " + enemyHitPoints + " left");
			System.out.println("You have taken" + aliceSpearDamage);
			System.out.println("You have " + aliceHitPoints + " left");
			System.out.println("The fight continues..");
			System.out.println();
			System.out.println();
			System.out.println();
			
		} while ((aliceHitPoints > 0) && (enemyHitPoints > 0));
		
		//if statement to set alice sanityPoints
		if (enemyHitPoints < 0) {
			System.out.println("You have won the battle!");
			System.out.println();
			return true;
		}
		else {
			System.out.println("You have lost the battle! And lost a sanity point.");
			alice.setSanityPoints(alice.getSanityPoints() - 1);
			System.out.println();
		}
			return false;
	}
	
	/**Method to handle jabberwocky battle */
	public boolean swordSuccess(Player alice) {
		
		//set method variables
		int swordUpperbound = 50;
		enemyHitPoints = 175;
		int aliceHitPoints;
		int aliceShield;
		int aliceSheildIndex = alice.getItemHolderIndex("shield");
		int aliceSwordIndex = alice.getItemHolderIndex("sword");
		
		//if statement to determine if player has sword and initiate combat sequence
		if (aliceSwordIndex > -1) {
			
			//if statement to determine if player has shield
			if (aliceSheildIndex > -1) {
			    aliceHitPoints = 150;
			    System.out.println("You have the shield. Ir gives you 50 more hit points!");
			}
			else {
				System.out.println("You don't have the shield");
				aliceHitPoints = 100;
			}	
		    
			//do while statement for battle and results
		    do {
			
			    int enemySwordDamage = rand.nextInt(swordUpperbound);
			    enemyHitPoints = enemyHitPoints - enemySwordDamage;
			
			    int aliceSwordDamage = rand.nextInt(swordUpperbound);
			    aliceHitPoints = (aliceHitPoints - aliceSwordDamage);
			
			    System.out.println("The Jabberwocky has taken" + enemySwordDamage);
			    System.out.println("He has " + enemyHitPoints + " left");
			    System.out.println("You have taken" + aliceSwordDamage);
			    System.out.println("You have " + aliceHitPoints + "left");
				System.out.println();
				System.out.println();
				System.out.println();
				
		    } while ((aliceHitPoints > 0) && (enemyHitPoints > 0));
		}
		
		else
			System.out.println ("You don't have the sword. The Jabberwocky ignores you.");
		
		//if statement to return battle results which is called in another class
		if (enemyHitPoints < 0)
			return true;
		else
			return false;
	}
} // end of class Combat