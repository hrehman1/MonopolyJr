/**	Project 1 : Monopoly Jr
 * MonopolyJr : main class with the essential functionality of monopoly
 * 
 * @author Hudhaifah Rehman & Gideon Antwi
 * @version 10/5/2021
 */ 

public class MonopolyJr 
{
	public static Die die = new Die();
	public static GameBoard gameBoard = new GameBoard();
	public static Player[] players = new Player[] { new Player("Toy Boat"),	//initialize all players
			  new Player("Toy Car"),
			  new Player("Little Hazel"),
			  new Player("Little Scottie") };
	
	public static void main(String[] args)
	{
		int currentPlayer = (int)(Math.random() * 4);
		
		//tests
		//Property boardwalk = (Property)gameBoard.board[gameBoard.findSpaceByName("Boardwalk")]; causing error???
		//System.out.println(boardwalk);
		
		Property pink = (Property)gameBoard.board[gameBoard.findPropertyByColor("Pink", 8)];
		System.out.println(pink);
		
		Property lightBlue = (Property)gameBoard.board[gameBoard.findPropertyByColor("Light Blue", "Pink", "Dark Blue", 0)];
		System.out.println(lightBlue);
		
		//just takes 20 turns for testing purposes
		for (int iterator = 0; iterator < 20; iterator++)
		{
			turn(players[currentPlayer]);
			currentPlayer = nextPlayer(currentPlayer);
			
			System.out.println();
			for (Player player : players)
			{
				System.out.println(player);
			}
			System.out.println();
		}
	}
	
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
			gameBoard.board[player.position].onLanding(player);
		}
	}
	
	public static int nextPlayer(int currentPlayer)
	{
		if (currentPlayer == 3)
			return 0;
		else
			return currentPlayer + 1;
	}
	
	public static Player findPlayerByName(String name)
	{
		for (Player player : players)
		{
			if (player.name.equals(name)) return player;
		}
		
		return null;
	}
}
