import java.util.ArrayList;

/**	Project 1 : Monopoly Jr
 * MonopolyJr : main class with the essential functionality of monopoly
 * 
 * @author Hudhaifah Rehman & Gideon Antwi
 * @version 10/13/2021
 */ 

/** Current fixes
 * add message for free parking [-]
 * different message for free properties and paid properties
 * add get out of jail message
 * some kind of bug not allowing players to pay if they go into negatives, but still letting them continue playing
 * when any player goes bankrupt, unknown error happens in for loop to check bankruptcy
 * more player-program interaction (allowing players to type something to roll, etc)
 * migrate chance cards over to separate classes (not necessary but would help)
 * ^abstract class ChanceCard, children classes : ColorChanceCard, SpaceChanceCard, PaymentChanceCard, ChoiceChanceCard, GiveChanceCard, FreeJailCard (or something like that)
 * change instance variables to private and add getters/setters
 * look for unused variables to get rid of
 */

public class MonopolyJr 
{
	public static Die die = new Die();
	public static GameBoard gameBoard = new GameBoard();
	public static ArrayList<Player> players = new ArrayList<Player>();
	
	public static void main(String[] args)
	{
		// Replaced 4 with size of players array
		int currentPlayer = (int)(Math.random() * players.size());
		Player winner = null;
		
		//initialize players
		players.add(new Player("Toy Boat"));
		players.add(new Player("Toy Car"));
		players.add(new Player("Little Hazel"));
		players.add(new Player("Little Scottie"));
		
		//tests
		//just takes 20 turns for testing purposes
		while (winner == null)
		{
			System.out.println("current Player: " + currentPlayer);
			System.out.println("next Player: " + nextPlayer(currentPlayer));
			currentPlayer = nextPlayer(currentPlayer); 

			turn(players.get(currentPlayer)); // <- Index n out of bounds for length n [FIXED]
			
			System.out.println();
			for (Player player : players)
			{
				System.out.println(player);
			}
			System.out.println();
			
			if (players.size() == 1)
			{
				winner = players.get(0);
			}
			
			// [+] Remove player
			ArrayList<Player> removedPlayers = new ArrayList<Player>();

			for (Player player : players)
			{
				if (player.cash <= 0) 
				{
					// players.remove(player); <- Cannot remove from list while looping, throws ConcurrentModificationException.
					removedPlayers.add(player); // Add player that needs to be removed to another array list called RemovedPlayers
				}
			}

			// [+] Loop through removedPlayer arraylist, remove players from players arraylist
			for (Player player : removedPlayers) {
				players.remove(player);
			} 

			// [+] Clear removedPlayer arraylist for next set.
			removedPlayers.clear();
		}
	}
	
	/** turn(Player) : carries out a full turn and does onLanding code
	 * 
	 * @param player
	 */
	public static void turn(Player player)
	{
		if (player.hasPropertyChanceCard)	//handles chance cards [16 - 19]
		{
			player.position = gameBoard.findNearestProperty(player.position);
			Property landedOn = (Property)gameBoard.board[player.position];
			
			if (landedOn.owned)
			{
				player.cash -= landedOn.cost;
				landedOn.owner.cash += landedOn.cost;
				landedOn.owner = player;
			}
			else
			{
				landedOn.onLanding(player);
			}
			
			player.hasPropertyChanceCard = false;
		}
		else if (player.inJail)	//handles jail
		{
			if (player.hasGetOutOfJailFree)
			{
				player.inJail = false;
				player.hasGetOutOfJailFree = false;
			}
			else
			{
				player.inJail = false;
				player.cash -= 1;
			}
		}
		else
		{
			player.moveForward(die.roll());
			gameBoard.board[player.position].onLanding(player); // <- Cannot assign field "hasPropertyChanceCard" because the return value of "MonopolyJr.findPlayerByName(String)" is null
		}
	}
	
	/** nextPlayer(int) ensures that the currentPlayer iterator wont go out of bounds of the arraylist
	 * 
	 * @param currentPlayer
	 * @return index of next player
	 */
	public static int nextPlayer(int currentPlayer)
	{
		System.out.println("Player size: " + players.size());
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
			if (player.name.equals(name)) return player;
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param player
	 * @param amountToPay
	 */
	public static void bankruptCheck(Player player, int amountToPay)
	{
		if (player.cash - amountToPay < 0)
		{
			
		}
	}
}
