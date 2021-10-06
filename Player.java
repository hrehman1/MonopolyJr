/**	Project 1 : Monopoly Jr
 * Player : object representing a player, includes state booleans
 * 
 * @author Hudhaifah Rehman & Gideon Antwi
 * @version 10/5/2021
 */

public class Player 
{
	public int cash;
	public String name;
	public int position;	//refers to position on gameboard array
	public boolean inJail;
	public boolean hasGetOutOfJailFree;
	public boolean hasPropertyChanceCard;
	
	public Player(String name)
	{
		cash = 16;
		this.name = name;
		position = 0;
		inJail = false;
		hasGetOutOfJailFree = false;
		hasPropertyChanceCard = false;
	}
	
	@Override
	public String toString()
	{
		return name + ", cash : $" + cash + ", position : " + position;
	}
	
	/** moveForward(int) : moves player forward int number of spaces and resets to 0 when at end of array to prevent index out of bounds error
	 * 
	 * @param spaces
	 */
	public void moveForward(int spaces)
	{
		if (position + spaces >= MonopolyJr.gameBoard.board.length)
		{
			int remainingSpaces = spaces - (MonopolyJr.gameBoard.board.length - position);
			position = 0;
			position += remainingSpaces;
		}
		else
		{
			position += spaces;
		}
	}
}
