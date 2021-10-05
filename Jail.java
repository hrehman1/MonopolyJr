
public class Jail extends BoardSpace
{
	public Jail()
	{
		name = "Jail";
	}
	
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
