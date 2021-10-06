/**	Project 1 : Monopoly Jr
 * BoardSpace : abstract base class to be inherited by different types of spaces
 * 
 * @author Hudhaifah Rehman & Gideon Antwi
 * @version 10/5/2021
 */

public abstract class BoardSpace 
{
	public String name;
	
	public abstract void onLanding(Player player);
}
