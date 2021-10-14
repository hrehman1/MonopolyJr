/**	Project 1 : Monopoly Jr
 * Chance : object representing the chance space on the gameBoard, randomly selects one of 20 cards that affect the player on landing
 * 
 * @author Hudhaifah Rehman & Gideon Antwi
 * @version 10/13/2021
 */

import java.util.Scanner;

public class Chance extends BoardSpace
{
	public Chance()
	{
		name = "Chance";
	}
	
	/** 
	 *  onLanding() : randomly selects a chance card and performs that action
	 */
	@Override
	public void onLanding(Player player) 
	{
		GameBoard gameBoard = MonopolyJr.getGameBoard();
		System.out.println(this);
		
		int chance = (int)(Math.random() * 20);
		Scanner in = new Scanner(System.in);
		
		//massive switch statement for chance card handling
		switch (chance)
		{
		case 0:
			System.out.println(player.getName() + ": " + "Advance to a light blue or red space. If one is unowned, get it for FREE! "
					+ "If none is unowned, advance to the closest light blue or red space and PAY rent to the owner.");
			player.setPosition(gameBoard.findPropertyByColor("Light Blue", "Red", player.getPosition()));
			chanceProperty(player);
			break;
		case 1:
			System.out.println(player.getName() + ": " +"Advance to an orange or green space. If one is unowned, get it for FREE! "
					+ "If none is unowned, advance to the closest light blue or red space and PAY rent to the owner.");
			player.setPosition(gameBoard.findPropertyByColor("Orange", "Green", player.getPosition()));
			chanceProperty(player);
			break;
		case 2:
			System.out.println(player.getName() + ": " +"Advance to a dark blue or pink space. If one is unowned, get it for FREE! "
					+ "If none is unowned, advance to the closest light blue or red space and PAY rent to the owner.");
			player.setPosition(gameBoard.findPropertyByColor("Pink", "Dark Blue", player.getPosition()));
			chanceProperty(player);
			break;
		case 3:
			System.out.println(player.getName() + ": " +"Advance to a red space. If one is unowned, get it for FREE! "
					+ "If none is unowned, advance to the closest light blue or red space and PAY rent to the owner.");
			player.setPosition(gameBoard.findPropertyByColor("Red", player.getPosition()));
			chanceProperty(player);
			break;
		case 4:
			System.out.println(player.getName() + ": " +"Advance to a light blue space. If one is unowned, get it for FREE! "
					+ "If none is unowned, advance to the closest light blue or red space and PAY rent to the owner.");
			player.setPosition(gameBoard.findPropertyByColor("Light Blue", player.getPosition()));
			chanceProperty(player);
			break;
		case 5:
			System.out.println(player.getName() + ": " +"Advance to an orange space. If one is unowned, get it for FREE! "
					+ "If none is unowned, advance to the closest light blue or red space and PAY rent to the owner.");
			player.setPosition(gameBoard.findPropertyByColor("Orange", player.getPosition()));
			chanceProperty(player);
			break;
		case 6:
			System.out.println(player.getName() + ": " +"Advance to a blue or yellow or brown space. If one is unowned, get it for FREE! "
					+ "If none is unowned, advance to the closest light blue or red space and PAY rent to the owner.");
			player.setPosition(gameBoard.findPropertyByColor("Brown", "Yellow", "Blue", player.getPosition()));
			chanceProperty(player);
			break;
		case 7:
			System.out.println(player.getName() + ": " +"Advance to Boardwalk.");
			player.setPosition(gameBoard.findSpaceByName("Boardwalk"));
			break;
		case 8:
			System.out.println(player.getName() + ": " +"Move forward 5 spaces.");
			player.moveForward(5);
			break;
		case 9:
			int choice = 0;
			
			do
			{
			System.out.println("1 : Move forward 1 space");
			System.out.println("2 : Choose another chance card");
			System.out.print(player.getName() + ": " +"Enter a choice: ");
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
			System.out.println(player.getName() + ": " +"Advance to GO. Collect $2.");
			player.setPosition(0);
			gameBoard.getGameBoard(player.getPosition()).onLanding(player);
			break;
		case 11:
			System.out.println(player.getName() + ": " +"Advance to the Skate Park. If no one owns it, get it for FREE! Otherwise, PAY rent to the owner.");
			player.setPosition(gameBoard.findSpaceByName("Skate Park"));
			chanceProperty(player);
			break;
		case 12:
			System.out.println(player.getName() + ": " +"Get out of jail free.Keep this card until you need it.");
			player.setJailFree(true);
			break;
		case 13:
			System.out.println(player.getName() + ": " +"You did all your homework! Collect $2 from the Bank.");
			player.setCash(2, "add");
			break;
		case 14:
			System.out.println(player.getName() + ": " +"It's your birthday! Collect $2 from the Bank. Happy Birthday!");
			player.setCash(2, "add");
			break;
		case 15:
			System.out.println(player.getName() + ": " +"You ate too many sweets! Pay $2 to the Bank.");
			player.setCash(2, "remove");
			break;
		case 16:
			if(MonopolyJr.findPlayerByName("Toy Boat") != null) {
				System.out.println(player.getName() + ": " +"Give this card to the Toy Boat, and take another Chance Card."
						+ "Toy Boat: on your next turn, sail forward to any unowned property, and buy it. If all are owned, "
						+ "buy the closest property not owned by Toy Boat from the owner! Owner MUST sell.");
				MonopolyJr.findPlayerByName("Toy Boat").setPropertyChanceCard(true);	//on turn if statement add property chance card resettors in MonopolyJr
				onLanding(player);
			} else {
				System.out.println("Player doesn't exist [16]");
				onLanding(player);
			}
			break;
		case 17:
			if(MonopolyJr.findPlayerByName("Toy Car") != null) {
				System.out.println(player.getName() + ": " +"Give this card to the Toy Car, and take another Chance Card."
						+ "Toy Car: on your next turn, sail forward to any unowned property, and buy it. If all are owned, "
						+ "buy the closest property not owned by Toy Car from the owner! Owner MUST sell.");
				MonopolyJr.findPlayerByName("Toy Car").setPropertyChanceCard(true);
				onLanding(player);
			} else {
				System.out.println("Player doesn't exist [17]");
				onLanding(player);
			}
			break;
		case 18:
			if(MonopolyJr.findPlayerByName("Little Scottie") != null) {
				System.out.println(player.getName() + ": " +"Give this card to the Little Scottie, and take another Chance Card."
						+ "Little Scottie: on your next turn, sail forward to any unowned property, and buy it. If all are owned, "
						+ "buy the closest property not owned by Little Scottie from the owner! Owner MUST sell.");
				MonopolyJr.findPlayerByName("Little Scottie").setPropertyChanceCard(true);
				onLanding(player);		
			} else {
				System.out.println("Player doesn't exist [18]");
				onLanding(player);
			}

			break;
		case 19:
			if(MonopolyJr.findPlayerByName("Little Hazel") != null) {
				System.out.println(player.getName() + ": " +"Give this card to the Little Hazel, and take another Chance Card."
						+ "Little Hazel: on your next turn, sail forward to any unowned property, and buy it. If all are owned, "
						+ "buy the closest property not owned by Little Hazel from the owner! Owner MUST sell.");
				MonopolyJr.findPlayerByName("Little Hazel").setPropertyChanceCard(true);
				onLanding(player);
			} else {
				System.out.println("Player doesn't exist [19]");
				onLanding(player);
			}

			break;
		}
	}
	
	@Override
	public String toString()
	{
		return "You landed on chance, pick a chance card";
	}
	
	/** chanceProperty : gives player free chance property if unowned
	 * 
	 * @param player
	 */
	public void chanceProperty(Player player)
	{
		player.setPropertyChanceCard(true);
		MonopolyJr.getGameBoard().getGameBoard(player.getPosition()).onLanding(player);
		player.setPropertyChanceCard(false);
	}
}
