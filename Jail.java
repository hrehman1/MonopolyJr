/**	Project 1 : Monopoly Jr
 * Jail : object representing jail space, sends player to jail space and changes jail bool
 * 
 * @author Hudhaifah Rehman & Gideon Antwi
 * @version 10/5/2021
 */

public class Jail extends BoardSpace
{
	public Jail()
	{
		name = "Jail";
	}
	
	/**
	 * onLanding : sets player position in jail and turns inJail bool to true
	 */
	@Override
	public void onLanding(Player player)
	{
		System.out.println(this);
		player.position = 6;
		player.inJail = true;
	}
	
	@Override
	public String toString()
	{
		return "Go straight to jail! Do not pass GO. "
				+ "Do not collect $2 At the start of your next turn, "
				+ "pay $1 or use the Get Out of Jail Free card if you have it. "
				+ "Then roll and move as normal. You can collect rent while In Jail.";
	}
}
