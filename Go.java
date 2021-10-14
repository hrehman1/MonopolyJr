/**	Project 1 : Monopoly Jr
 * Go : object representing go space, gives player $2 when passed/landed on
 * 
 * @author Hudhaifah Rehman & Gideon Antwi
 * @version 10/13/2021
 */

public class Go extends BoardSpace
{
	public Go()
	{
		name = "Go";
	}
	
	/**
	 * onLanding : gives player $2 when passed go
	 */
	@Override
	public void onLanding(Player player) 
	{
		System.out.println(this);
		player.setCash(2, "add");

	}

	@Override
	public String toString()
	{
		return "You landed on go, take $2 from the bank";
	}
}
