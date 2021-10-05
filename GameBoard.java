/** Project #1 : Monopoly Jr
 * GameBoard : class representing the gameboard, includes space finding methods 
 * 
 * @author Hudhaifah Rehman
 * @version 10/1/2021
 */

import java.util.ArrayList;

public class GameBoard
{
	public BoardSpace[] board;
	
	/**
	 * GameBoard() : initializes gameboard and assigns propertypairs
	 */
	public GameBoard()
	{
		board = new BoardSpace[24];
		Property propertyPair1;
		Property propertyPair2;
		
		//add boardspaces
		board[0] = new Go();
		board[1] = new Property(1, "Brown", "Burger Joint");
		board[2] = new Property(1, "Brown", "Pizza House");
		board[3] = new Chance();
		board[4] = new Property(2, "Light Blue", "Candy Store");
		board[5] = new Property(2, "Light Blue", "Ice Cream Parlor");
		board[6] = new JustVisiting();
		board[7] = new Property(2, "Pink", "Museum");
		board[8] = new Property(2, "Pink", "Library");
		board[9] = new Chance();
		board[10] = new Property(3, "Orange", "Skate Park");
		board[11] = new Property(3, "Orange", "Swimming Pool");
		board[12] = new FreeParking();
		board[13] = new Property(3, "Red", "Video Game Arcade");
		board[14] = new Property(3, "Red", "Movie Theater");
		board[15] = new Chance();
		board[16] = new Property(3, "Yellow", "Toy Store");
		board[17] = new Property(3, "Yellow", "Pet Store");
		board[18] = new Jail();
		board[19] = new Property(4, "Green", "Bowling Alley");
		board[20] = new Property(4, "Green", "The Zoo");
		board[21] = new Chance();
		board[22] = new Property(5, "Dark Blue", "Park Place");
		board[23] = new Property(5, "Dark Blue", "Boardwalk");
		
		//set property pairs
		for (int iterator = 1; iterator < 24; iterator += 3)	//iterates through in increments of 3 to go by each set of properties
		{
			propertyPair1 = (Property)board[iterator];	//assigns properties to casted variable to be able to use Property methods
			propertyPair2 = (Property)board[iterator + 1];
			
			propertyPair1.setPropertyPair(propertyPair2);
			propertyPair2.setPropertyPair(propertyPair1);
		}
	}
	
	//space finding methods
	
	/** findNearestProperty(int) : finds the closest unowned property and rechecks for owned properties if no owned properties are found
	 * 
	 * 
	 * @param startIndex
	 * @return index of nearest property
	 */
	public int findNearestProperty(int startIndex)
	{
		for (int iterator = startIndex; iterator < board.length; iterator++)
		{
			if (iterator >= board.length - 1) iterator = 0;	//resets if reaches end of array

			if (board[iterator] instanceof Property)	//check if its a unowned property
			{
				Property space = (Property)board[iterator];
				
				if (!space.owned) return iterator;
			}
			
			if (iterator == startIndex - 1) // makes sure iterator doesnt double check spaces and starts loop to find the nearest owned one instead
			{
				for (int innerIterator = startIndex; innerIterator < board.length; innerIterator++)
				{
					if (iterator >= board.length - 1) iterator = 0;
					
					if (board[innerIterator] instanceof Property) return innerIterator;
				}
			}
		}
		
		return -1;
	}
	
	public int findSpaceByName(String name)
	{
		for (int iterator = 0; iterator < board.length; iterator++)	//checks every boardspace to see if theres a name match
		{
			if (board[iterator].name.equals(name)) return iterator;
		}
		
		return -1;
	}
	
	public int findPropertyByColor(String color, int startIndex)
	{
		for (int iterator = startIndex; iterator < board.length; iterator++)
		{
			if (iterator >= board.length -1) iterator = 0;
			
			if (board[iterator] instanceof Property)	//makes sure boardspace is property
			{
				Property propertyToCheck = (Property)board[iterator];
				
				if (propertyToCheck.color.equals(color)) return iterator;	//checks if theres a color match
			}
		}
		
		return -1;
	}
	
	public int findPropertyByColor(String color, String color2, int startIndex)
	{
		for (int iterator = startIndex; iterator < board.length; iterator++)
		{
			if (iterator >= board.length - 1) iterator = 0;
			
			if (board[iterator] instanceof Property)
			{
				Property propertyToCheck = (Property)board[iterator];
				
				if (propertyToCheck.color.equals(color) || propertyToCheck.color.equals(color2)) return iterator;
			}
		}
		
		return -1;
	}
	
	public int findPropertyByColor(String color, String color2, String color3, int startIndex)
	{
		for (int iterator = startIndex; iterator < board.length; iterator++)
		{
			if (iterator >= board.length - 1) iterator = 0;
			
			if (board[iterator] instanceof Property)
			{
				Property propertyToCheck = (Property)board[iterator];
				
				if (propertyToCheck.color.equals(color) || propertyToCheck.color.equals(color2) || propertyToCheck.color.equals(color3)) return iterator;
			}
		}
		
		return -1;
	}
}
