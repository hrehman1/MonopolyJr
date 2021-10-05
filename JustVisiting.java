
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
