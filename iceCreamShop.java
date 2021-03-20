/* CSE 205:11333 / Tues&Thurs, 4:30-5:45
Assignment 6
Author: Jessica Gertell 1205936026
Description: This is the main method that emulates the iceCreamShop where it encounters sundae, scoop, and iceCream classes. */
import java.util.Scanner;

public class iceCreamShop {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // create a scanner to get user input
		System.out.println("Welcome to Ice cream World");
		System.out.println("Would you like an icecream or sundae?");
		String choice = input.nextLine(); // read if the user wants a sundae or icecream
		iceCream userIceCream;
		if (choice.equalsIgnoreCase("sundae")) {
			userIceCream = new sundae();
			enterScoops(input, userIceCream);
			System.out.println("Do you want toppings?"); // see if the user wants toppings
			if (input.nextLine().equalsIgnoreCase("yes")) // if yes call the method enterToppings
				enterToppings(input, userIceCream);
			System.out.println("Do you want special toppings?"); // see if the user wants special toppings
			if (input.nextLine().equalsIgnoreCase("yes")) // if yes call the method enterSpecialToppings
				enterSpecialToppings(input, userIceCream);
		} else { // if they dont enter sundae default an icecream
			System.out.println("Do you want a cup or cone?"); // see if the user wants a cup or cone
			if (input.nextLine().equalsIgnoreCase("cone")) // if they want a cone use the correct constructor
				userIceCream = new iceCream(true);
			else
				userIceCream = new iceCream(); // if not use the default contructor

			enterScoops(input, userIceCream); // add scoops
			System.out.println("Do you want toppings?"); // ask if the user wants toppings
			if (input.nextLine().equalsIgnoreCase("yes")) // if yes call the enter topings method
				enterToppings(input, userIceCream);
		}
		System.out.println("Your order is: " + userIceCream); // display the order
		System.out.println("The total price of your order is: $" + userIceCream.getTotalPrice()); // display the total

	}

	// holds what to display for entering scoops as well as mixins for the scoops.
	// The created scoops are added onto the ice Cream object
	private static void enterScoops(Scanner input, iceCream userIceCream) {
		System.out.println("How many icecream scoops do you want?(Atleast 1)");
		int scoops = Integer.parseInt(input.nextLine());
		for (int i = 0; i < scoops; i++) {
			System.out.println("Enter the flavor of scoop " + (i + 1));
			String flavor = input.nextLine();
			System.out.println("Enter the size, each size up is $.50 more. Smallest size is 0");
			int size = Integer.parseInt(input.nextLine());
			System.out.println("Do you want a mixin for this scoop?");
			if (input.nextLine().equalsIgnoreCase("yes")) {
				System.out.println("Enter the mix in");
				String mixIn = input.nextLine();
				userIceCream.addScoopAndMixin(flavor, size, mixIn);
			} else {
				userIceCream.addScoop(flavor, size);
			}
		}

	}

	// holds what to display with the user wants normal toppings
	private static void enterToppings(Scanner input, iceCream userIceCream) {
		System.out.println("How many toppings do you want? (Each is $.65)");
		int toppings = Integer.parseInt(input.nextLine());
		for (int i = 0; i < toppings; i++) {
			System.out.println("Enter a topping:");
			userIceCream.addTopping(input.nextLine());
		}
	}

	// holds what to display if the user wants special toppings
	private static void enterSpecialToppings(Scanner input, iceCream userIceCream) {
		System.out.println("How many special toppings? (Each is $.65)");
		int specialToppings = Integer.parseInt(input.nextLine());
		for (int i = 0; i < specialToppings; i++) {
			System.out.println("Enter a special Topping:");
			((sundae) userIceCream).addSpecialTopping(input.nextLine()); // uses the method in sundae
		}
	}

}