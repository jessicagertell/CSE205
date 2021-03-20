/* CSE 205:11333 / Tues&Thurs, 4:30-5:45
Assignment 6
Author: Jessica Gertell 1205936026
Description: The iceCream class holds the number of scoops, price, toppings, and if you are going to have a cup or cone*/
import java.util.ArrayList;

public class iceCream {
	private ArrayList<scoop> scoops = new ArrayList<scoop>(); // will hold the scoops in the icecream
	private ArrayList<String> toppings = new ArrayList<String>(); // will hold the toppings if any
	private boolean cone; // holds whether the ice cream is on a cone or not
	private double price; // holds the price of the ice cream

	// default constructor : no scoops, no cone, no toppings
	public iceCream() {
		cone = false;
	}

	// constructor with 1 param, used if the user wants a cone
	public iceCream(boolean cone) {
		this.cone = cone;
	}

	// constuctor with 3 params: list of scoops, cone or not, toppings
	public iceCream(ArrayList<scoop> numScoops, boolean cone, ArrayList<String> numToppings) {
		scoops = numScoops;
		this.cone = cone;
		toppings = numToppings;
	}

	// this method uses the helper methods to calculate the price and then returns
	// the price of this icecream
	public double getTotalPrice() {
		calculatePrice();
		return price;
	}

	private void calculatePrice() {
		price = 0; // reset the price to 0 to start fresh
		if (cone) { // if there is a cone add 50 cents
			price += .50;
		}

		price += calculateScoops(0); // use the helper method to see how much scoops cost

		price += .65 * toppings.size(); // multiply # of toppings by .65 to add on topping price

	}

	// recursively calculate scoops
	private double calculateScoops(int n) {
		if (n == scoops.size()) // Base case if you reached the end of the arraylist return 0
			return 0;
		else
			return scoops.get(n).getPrice() + calculateScoops(n + 1); // return that scoops price plus the next

	}

	// this method adds the incoming topping to the array list
	public void addTopping(String topping) {
		toppings.add(topping);
	}

	// this method makes a new scoop and adds it to the scoops arrayList
	public void addScoop(String f, int size) {
		scoops.add(new scoop(f, size));
	}

	// this method makes a scoop with a mixin and adds it to the arrayList
	public void addScoopAndMixin(String f, int size, String m) {
		scoop a = new scoop(f, size);
		a.addMixin(m);
		scoops.add(a);

	}

	// returns the topping arrayList
	public ArrayList<String> getToppings() {
		return toppings;
	}

	// selections sort
	public ArrayList<scoop> sort(ArrayList<scoop> scoops) {
		for (int i = 0; i < scoops.size(); i++) {
			for (int j = i + 1; j < scoops.size(); j++) {
				if (scoops.get(i).getFlavor().compareTo(scoops.get(j).getFlavor()) > 0) {
					scoop temp = scoops.get(i); // store whats in the i index
					scoops.add(i, scoops.get(j)); // adds the j to the i index
					scoops.remove(i + 1); // removes the i+1 index since it moved up
					scoops.add(j, temp); // add temp to the j index
					scoops.remove(j + 1); // remove j+1 since that moves up
				}
			}
		}
		return scoops; // return the sorted arrayList
	}

	// converts the info of this ice cream to a string
	public String toString() {
		scoops = sort(scoops); // sort the scoops
		String iceCream = ""; // create the string to return
		if (cone) // if its a cone add the correct info
			iceCream += "a cone plus a";
		else // if its not a cone add the correct info
			iceCream += "a cup plus a ";
		
		// add each scoops info onto the string
		for (int i = 0; i < scoops.size(); i++) {
			iceCream += "size " + scoops.get(i).getSize() + " " + scoops.get(i).getFlavor() + " scoop";
			if (scoops.get(i).hasMixIn())
				iceCream += " with " + scoops.get(i).getMixIn() + "mixin ";
		}
		// add the topping info onto the string
		if (toppings.size() != 0)
			iceCream += " with ";
		for (int i = 0; i < toppings.size(); i++) {
			iceCream += toppings.get(i) + " ";
		}
		return iceCream; // return the string
	}

}