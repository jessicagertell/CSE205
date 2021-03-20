/* CSE 205:11333 / Tues&Thurs, 4:30-5:45
Assignment 6
Author: Jessica Gertell 1205936026
Description: This class has everything an iceCream class does and it contains specials toppings that only a sundae class can have */
import java.util.ArrayList;

public class sundae extends iceCream { // sundae is a iceCream
	private ArrayList<String> specialToppings = new ArrayList<String>(); // it has special toppings

	// default constructor
	public sundae() {
		super(); // calls the super default constructor
	}

	// constructor with 3 params: numscoop, cone, num topings, st
	public sundae(ArrayList<scoop> numScoop, boolean cone, ArrayList<String> numToppings, ArrayList<String> sT) {
		super(numScoop, cone, numToppings); // pass info to super class
		specialToppings = sT; //
	}

	// this method builds of the super getPrice method by calling the method and
	// then adding onto it the price of any special toppings
	@Override
	public double getTotalPrice() {
		double price = super.getTotalPrice();
		price += .65 * specialToppings.size(); // add .65 for each special topping
		return price;
	}

	// adds the incoming topping onto the specialToppings arrayList
	public void addSpecialTopping(String topping) {
		specialToppings.add(topping);
	}

	// builds on the supers to String method by adding if there are any special
	// toppings
	@Override
	public String toString() {
		String iceCream = super.toString();
		if (specialToppings.size() != 0)
			iceCream += " and as special topping(s) you have ";
		for (int i = 0; i < specialToppings.size(); i++) {
			iceCream += specialToppings.get(i) + " ";
		}
		return iceCream;
	}
}