
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
