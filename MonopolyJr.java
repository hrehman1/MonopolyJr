import java.util.ArrayList;
import java.util.Scanner;

/**	Project 1 : Monopoly Jr
 * MonopolyJr : main class with the essential functionality of monopoly
 * 
 * @author Hudhaifah Rehman & Gideon Antwi
 * @version 10/13/2021
 */ 

public class MonopolyJr 
{
	private static Die die = new Die();
	private static GameBoard gameBoard = new GameBoard();
	private static ArrayList<Player> players = new ArrayList<Player>();
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		// Replaced 4 with size of players array
		int currentPlayer = (int)(Math.random() * players.size());
		Player lostPlayer = null;
		
		//initialize players
		players.add(new Player("Toy Boat"));
		players.add(new Player("Toy Car"));
		players.add(new Player("Little Hazel"));
		players.add(new Player("Little Scottie"));
		
		//Explains program
		System.out.println("Hi, welcome to Monopoly Jr!");
		
		//Turn loop
		do 
		{
			System.out.print("Input anything to roll the dice:");
			in.nextLine();	//eats next line of input
			
			int roll = die.roll();
			
			System.out.println("You rolled a " + roll + ", move forward " + roll + " spaces\n");
			
			turn(players.get(currentPlayer), roll);
			
			if (players.get(currentPlayer).getCash() < 0) 
			{
				lostPlayer = players.get(currentPlayer);	//gameend check 
			}
			
			System.out.println(players.get(currentPlayer).getName() + ", your bank balance is now $" + players.get(currentPlayer).getCash() + "\n");
			currentPlayer = nextPlayer(currentPlayer);
		} while (lostPlayer == null);
		
		System.out.println("Game Over, " + lostPlayer.getName() + " went bankrupt.");
	}
	
	/** turn(Player) : carries out a full turn and does onLanding code
	 * 
	 * @param player
	 */
	public static void turn(Player player, int roll)
	{
		if (player.getPropertyChanceCard())	//handles chance cards [16 - 19]
		{
			player.setPosition(gameBoard.findNearestProperty(player.getPosition()));
			Property landedOn = (Property)gameBoard.getGameBoard(player.getPosition());
			
			if (landedOn.getOwnedStatus())
			{
				player.setCash(landedOn.getCost(), "remove");
				landedOn.getOwner().setCash(landedOn.getCost(), "add");
				landedOn.setOwner(player);
			}
			else
			{
				landedOn.onLanding(player);
			}
			
			player.setPropertyChanceCard(false);
		}
		else if (player.getJailStatus())	//handles jail
		{
			if (player.getJailFree())
			{
				player.setJailStatus(false);
				player.setJailFree(false);
				System.out.println("You used a get out of jail card, you are now free");
			}
			else
			{
				player.setJailStatus(false);
				player.setCash(1, "remove");			
				System.out.println("You paid $1 to get out of jail");
			}
		}
		else
		{
			player.moveForward(roll);
			gameBoard.getGameBoard(player.getPosition()).onLanding(player); // <- Cannot assign field "hasPropertyChanceCard" because the return value of "MonopolyJr.findPlayerByName(String)" is null
		}
	}
	
	/** nextPlayer(int) ensures that the currentPlayer iterator wont go out of bounds of the arraylist
	 * 
	 * @param currentPlayer
	 * @return index of next player
	 */
	public static int nextPlayer(int currentPlayer)
	{
		if (currentPlayer >= players.size() - 1 || currentPlayer == players.size())
			return 0;
		else
			return currentPlayer + 1;
	}
	
	/** findPlayerByName(String) : searches through players arraylist to return the player object w a matching name
	 * 
	 * @param name
	 * @return the player
	 */
	public static Player findPlayerByName(String name)
	{
		for (Player player : players)
		{
			if (player.getName().equals(name)) return player;
		}
		
		return null;
	}

	/**
	 * Get Monopoly Jr. GameBoard
	 * @return GameBoard
	 */
	public static GameBoard getGameBoard () {
		return gameBoard;
	} 

	// /**
	//  * Get Monopoly Jr. GameBoard Length
	//  * @return GameBoard
	//  */
	// public static int getGameBoardLength () {
	// 	return gameBoard.getGameBoardSize();
	// } 
}
