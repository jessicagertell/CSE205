/* CSE 205:11333 / Tues&Thurs, 4:30-5:45
Assignment 6
Author: Jessica Gertell 1205936026
Description:This class is a representation of an icecream scoop. It holds the flavor and size if there are any mixins for this scoop, and how much this scoop costs. */

public class scoop {
	private String flavor; // holds the flavor of the scoop
	private int size; // holds the size of the scoop
	private String mixin; // holds a mixin if it has one
	private double price = 1.25; // this is the base price of a scoop

	// default constructor
	public scoop() {
		flavor = "vanilla";
		size = 1; // 1 is small
	}

	// Constructor with 2 parameters
	public scoop(String f, int s) {
		flavor = f;
		size = s;
		price += s * .50;
	}

	// getters
	public String getFlavor() {
		return flavor;
	}

	public int getSize() {
		return size;
	}

	public double getPrice() {
		return price;
	}

	public String getMixIn() {
		return mixin;
	}

	// return true if there is a mixin
	public boolean hasMixIn() {
		if (mixin == null)
			return false;
		return true;
	}

	// setters
	public void setFlavor(String newFlavor) {
		flavor = newFlavor;
	}

	public void setSize(int newSize) {
		size = newSize;
	}

	public void addMixin(String m) {
		mixin = m;
		price += .50; // adds .50 to the price
	}
}	