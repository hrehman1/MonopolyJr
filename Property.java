/**	Project 1 : Monopoly Jr
 * Property : object representing property space, checks for owned property pairs 
 * 
 * @author Hudhaifah Rehman & Gideon Antwi
 * @version 10/13/2021
 */

public class Property extends BoardSpace
{
	// Cost
	private int cost;

	public int getCost () {
		return cost;
	}

	// Color
	private String color;

	public String getColor () {
		return color;
	}

	private Property propertyPair;

	// Owned
	private boolean owned;

	public void setOwnedStatus (boolean status) {
		this.owned = status;
	}

	public boolean getOwnedStatus () {
		return owned;
	}

	private Player owner;

	public Player getOwner () {
		return owner;
	}

	public void setOwner(Player player) {
		this.owner = player;
	}
	
	public Property(int cost, String color, String name)
	{
		this.cost = cost;
		this.color = color;
		this.name = name;
	}
	
	/** setPropertyPair(Property) : assigns propertyPair to the this.propertyPair variable
	 * 
	 * @param propertyPair
	 */
	public void setPropertyPair(Property propertyPair)
	{
		this.propertyPair = propertyPair;
	}
	
	/**
	 * onLanding : checks for owned status and performs code based on that, also performs double rent check
	 */
	@Override
	public void onLanding(Player player)
	{
		if (owned)
		{
			if ((player.getCash() - cost) >= 0)
			{
				player.setCash(cost, "remove");
				owner.setCash(cost, "add");
				System.out.println("You landed on " + name + ", pay $" + cost + " to " + owner.getName());
			}
		}
		else
		{
			if (player.getPropertyChanceCard())
			{
				owned = true;
				owner = player;
				System.out.println("You landed on " + name + ", buy it for free with chance card");
			}
			else
			{
				player.setCash(cost, "remove");
				owned = true;
				owner = player;
				System.out.println("You landed on " + name + ", buy it for $" + cost);
			}
			
			doubleRentCheck();
		}
	}
	
	/**
	 * doubleRentCheck : checks if propertyPair is owned by same person, if so doubles rent of both
	 */
	public void doubleRentCheck()
	{
		if (propertyPair.owned)
		{
			if (owner.getName().equals(propertyPair.owner.getName())) 
			{
				cost = cost * 2;
				System.out.println("Properties " + name + " and " + propertyPair.name +
						" are both owned by " + owner.getName() + ", they have doubled in rent");
			}
		}
	}
}
