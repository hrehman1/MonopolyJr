/**	Project 1 : Monopoly Jr
 * FreeParking : object representing free parking space, no real functionality
 * 
 * @author Hudhaifah Rehman & Gideon Antwi
 * @version 10/13/2021
 */

public class FreeParking extends BoardSpace
{
	public FreeParking()
	{
		name = "Free Parking";
	}
	
	@Override
	public void onLanding(Player player)
	{
		System.out.println(player.getName() + ": " +"You landed on Free Parking! Do nothing.");
	}
}
