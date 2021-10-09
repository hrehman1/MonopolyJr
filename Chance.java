import java.util.Scanner;

/**	Project 1 : Monopoly Jr
 * Chance : object representing the chance space on the gameBoard, randomly selects one of 20 cards that affect the player on landing
 * 
 * @author Hudhaifah Rehman
 * @version 9/30/2021
 */

public class Chance extends BoardSpace
{
	public Chance()
	{
		name = "Chance";
	}
	
	@Override
	public void onLanding(Player player) 
	{
		System.out.println(this);
		
		int chance = (int)(Math.random() * 20);
		Scanner in = new Scanner(System.in);
		
		//massive switch statement for chance card handling
		switch (chance)
		{
		case 0:
			System.out.println("Advance to a light blue or red space. If one is unowned, get it for FREE! "
					+ "If none is unowned, advance to the closest light blue or red space and PAY rent to the owner.");
			player.position = MonopolyJr.gameBoard.findPropertyByColor("Light Blue", "Red", player.position);
			chanceProperty(player);
			break;
		case 1:
			System.out.println("Advance to an orange or green space. If one is unowned, get it for FREE! "
					+ "If none is unowned, advance to the closest light blue or red space and PAY rent to the owner.");
			player.position = MonopolyJr.gameBoard.findPropertyByColor("Orange", "Green", player.position);
			chanceProperty(player);
			break;
		case 2:
			System.out.println("Advance to a dark blue or pink space. If one is unowned, get it for FREE! "
					+ "If none is unowned, advance to the closest light blue or red space and PAY rent to the owner.");
			player.position = MonopolyJr.gameBoard.findPropertyByColor("Pink", "Dark Blue", player.position);
			chanceProperty(player);
			break;
		case 3:
			System.out.println("Advance to a red space. If one is unowned, get it for FREE! "
					+ "If none is unowned, advance to the closest light blue or red space and PAY rent to the owner.");
			player.position = MonopolyJr.gameBoard.findPropertyByColor("Red", player.position);
			chanceProperty(player);
			break;
		case 4:
			System.out.println("Advance to a light blue space. If one is unowned, get it for FREE! "
					+ "If none is unowned, advance to the closest light blue or red space and PAY rent to the owner.");
			player.position = MonopolyJr.gameBoard.findPropertyByColor("Light Blue", player.position);
			chanceProperty(player);
			break;
		case 5:
			System.out.println("Advance to an orange space. If one is unowned, get it for FREE! "
					+ "If none is unowned, advance to the closest light blue or red space and PAY rent to the owner.");
			player.position = MonopolyJr.gameBoard.findPropertyByColor("Orange", player.position);
			chanceProperty(player);
			break;
		case 6:
			System.out.println("Advance to a blue or yellow or brown space. If one is unowned, get it for FREE! "
					+ "If none is unowned, advance to the closest light blue or red space and PAY rent to the owner.");
			player.position = MonopolyJr.gameBoard.findPropertyByColor("Brown", "Yellow", "Blue", player.position);
			chanceProperty(player);
			break;
		case 7:
			System.out.println("Advance to Boardwalk.");
			player.position = MonopolyJr.gameBoard.findSpaceByName("Boardwalk");
			break;
		case 8:
			System.out.println("Move forward 5 spaces.");
			player.moveForward(5);
			break;
		case 9:
			int choice = 0;
			
			do
			{
			System.out.println("1 : Move forward 1 space");
			System.out.println("2 : Choose another chance card");
			System.out.print("Enter a choice: ");
			choice = in.nextInt();
			
			if (choice > 2 || choice < 1)
				System.out.println("Invalid Choice");
			} while (choice > 2 || choice < 1);
			
			switch (choice)
			{
			case 1:
				player.moveForward(1);
				break;
			case 2:
				onLanding(player);
				break;
			}
			
			break;
		case 10:
			System.out.println("Advance to GO. Collect $2.");
			player.position = 0;
			MonopolyJr.gameBoard.board[player.position].onLanding(player);
			break;
		case 11:
			System.out.println("Advance to the Skate Park. If no one owns it, get it for FREE! Otherwise, PAY rent to the owner.");
			player.position = MonopolyJr.gameBoard.findSpaceByName("Skate Park");
			chanceProperty(player);
			break;
		case 12:
			System.out.println("Get out of jail free.Keep this card until you need it.");
			player.hasGetOutOfJailFree = true;
			break;
		case 13:
			System.out.println("You did all your homework! Collect $2 from the Bank.");
			player.cash += 2;
			break;
		case 14:
			System.out.println("It�s your birthday! Collect $2 from the Bank. Happy Birthday!");
			player.cash += 2;
			break;
		case 15:
			System.out.println("You ate too many sweets! Pay $2 to the Bank.");
			player.cash -= 2;
			break;
		case 16:
			System.out.println("Give this card to the Toy Boat, and take another Chance Card."
					+ "Toy Boat: on your next turn, sail forward to any unowned property, and buy it. If all are owned, "
					+ "buy the closest property not owned by Toy Boat from the owner! Owner MUST sell.");
			MonopolyJr.findPlayerByName("Toy Boat").hasPropertyChanceCard = true;	//on turn if statement add property chance card resettors in MonopolyJr
			onLanding(player);
			break;
		case 17:
			System.out.println("Give this card to the Toy Car, and take another Chance Card."
					+ "Toy Car: on your next turn, sail forward to any unowned property, and buy it. If all are owned, "
					+ "buy the closest property not owned by Toy Car from the owner! Owner MUST sell.");
			MonopolyJr.findPlayerByName("Toy Car").hasPropertyChanceCard = true;
			onLanding(player);
			break;
		case 18:
			System.out.println("Give this card to the Little Scottie, and take another Chance Card."
					+ "Little Scottie: on your next turn, sail forward to any unowned property, and buy it. If all are owned, "
					+ "buy the closest property not owned by Little Scottie from the owner! Owner MUST sell.");
			MonopolyJr.findPlayerByName("Little Scottie").hasPropertyChanceCard = true;
			onLanding(player);
			break;
		case 19:
			System.out.println("Give this card to the Little Hazel, and take another Chance Card."
					+ "Little Hazel: on your next turn, sail forward to any unowned property, and buy it. If all are owned, "
					+ "buy the closest property not owned by Little Hazel from the owner! Owner MUST sell.");
			MonopolyJr.findPlayerByName("Little Hazel").hasPropertyChanceCard = true;
			onLanding(player);
			break;
		}
	}
	
	@Override
	public String toString()
	{
		return "You landed on chance, pick a chance card";
	}
	
	//handles free properties
	public void chanceProperty(Player player)
	{
		player.hasPropertyChanceCard = true;
		MonopolyJr.gameBoard.board[player.position].onLanding(player);
		player.hasPropertyChanceCard = false;
	}
}
