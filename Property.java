/**	Project 1 : Monopoly Jr
 * Property : object representing property space, checks for owned property pairs 
 * 
 * @author Hudhaifah Rehman & Gideon Antwi
 * @version 10/5/2021
 */

public class Property extends BoardSpace
{
	public int cost;
	public String color;
	public Property propertyPair;
	public boolean owned;
	public Player owner;
	
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
		System.out.println(this);
		
		if (owned)
		{
			if ((player.cash - cost) >= 0)
			{
				player.cash -= cost;
				owner.cash += cost;
			}
		}
		else
		{
			if (player.hasPropertyChanceCard)
			{
				owned = true;
				owner = player;
			}
			else
			{
				player.cash -= cost;
				owned = true;
				owner = player;
			}
			
			doubleRentCheck();
		}
	}
	
	@Override
	public String toString()
	{
		if (owned)
			return "You landed on " + name + ", pay $" + cost + " to " + owner.name;
		else
			return "You landed on " + name + ", buy it for $" + cost;
	}
	
	/**
	 * doubleRentCheck : checks if propertyPair is owned by same person, if so doubles rent of both
	 */
	public void doubleRentCheck()
	{
		if (propertyPair.owned)
		{
			if (owner.name.equals(propertyPair.owner.name)) 
			{
				cost = cost * 2;
				System.out.println("Properties " + name + " and " + propertyPair.name +
						" are both owned by " + owner.name + ", they have doubled in rent");
			}
		}
	}
}
