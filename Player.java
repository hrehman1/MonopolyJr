/**	Project 1 : Monopoly Jr
 * Player : object representing a player, includes state booleans
 * 
 * @author Hudhaifah Rehman & Gideon Antwi
 * @version 10/13/2021
 */

public class Player 
{
	// Cash
	private int cash;

	/**
	 * Return player cash
	 * @return cash
	 */
	public int getCash() {
		return cash;
	}

	/**
	 * Add, remove, or set cash to player
	 * @param cash value to add, remove or set
	 * @param method "add" - add to player, "remove" - remove from player, null - set player cash 
	 */
	public void setCash(int cash, String method) {
		switch(method.toLowerCase()) {
			case "add" : this.cash += cash; break;
			case "remove": this.cash -= cash; break;
			default: this.cash = cash;
		}
	}

	// Name
	private String name;

	/**
	 * Get player name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	// Position
	private int position;	//refers to position on gameboard array
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	// In Jail
	private boolean inJail;

	public boolean getJailStatus() {
		return inJail;
	}

	public void setJailStatus(boolean status) {
		this.inJail = status;
	}

	// Has Free Bail
	private boolean hasGetOutOfJailFree;
	
	public boolean getJailFree() {
		return hasGetOutOfJailFree;
	}

	public void setJailFree(boolean status) {
		this.hasGetOutOfJailFree = status;
	}

	// Has Property Chance Card
	private boolean hasPropertyChanceCard;

	public boolean getPropertyChanceCard() {
		return hasPropertyChanceCard;
	}

	public void setPropertyChanceCard(boolean status) {
		this.hasPropertyChanceCard = status;
	}

	// Lost
	private boolean lost;

	public boolean getLostStatus () {
		return lost;
	}

	public void setLostStatus(boolean status) {
		this.lost = status;
	}
	
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
		if (position + spaces >= MonopolyJr.getGameBoard().getGameBoardSize())
		{
			int remainingSpaces = spaces - (MonopolyJr.getGameBoard().getGameBoardSize() - position);
			position = 0;
			position += remainingSpaces;
		}
		else
		{
			position += spaces;
		}
	}
}
