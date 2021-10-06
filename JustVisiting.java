/**	Project 1 : Monopoly Jr
 * JustVisiting : object representing just visiting space, no real functionality
 * 
 * @author Hudhaifah Rehman & Gideon Antwi
 * @version 10/5/2021
 */

public class JustVisiting extends BoardSpace
{
	public JustVisiting()
	{
		
	}
	
	@Override
	public void onLanding(Player player)
	{
		System.out.println(this);
	}
	
	@Override 
	public String toString()
	{
		return "You have landed on just visiting";
	}
}
