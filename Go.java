
public class Go extends BoardSpace
{
	public Go()
	{
		name = "Go";
	}
	
	@Override
	public void onLanding(Player player) 
	{
		System.out.println(this);
		player.cash += 2;
	}

	@Override
	public String toString()
	{
		return "You landed on go, take $2 from the bank";
	}
}
