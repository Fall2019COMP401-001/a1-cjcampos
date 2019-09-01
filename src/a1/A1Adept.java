package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// declares variables utilized in the program
		int numItems;
		int numCustomers;
		int itemQuantity;
		double custCost = 0;
		int totalItem;
		String currentItem;
		double itemCost;
		
		// allows user to enter the number of items
		numItems = scan.nextInt();
		
		// creates an array for the names and costs of items
		String[] nameItem = new String[numItems];
		double[] costItem = new double[numItems];
		
		// for loop for user input of the names and costs of items
		for (int i = 0; i < numItems; i++)
		{
			nameItem[i] = scan.next();
			costItem[i] = scan.nextDouble();
		}
		
		// allows for user input of the number of customers
		numCustomers = scan.nextInt();
		
		// creates array for the total puchase, first and last names of customers
		double[] totalCosts = new double[numCustomers];
		String[] firstName = new String[numCustomers];
		String[] lastName = new String[numCustomers];
		
		// for loop allows for user input of the names of customers and total items bought by them
		for (int j = 0; j < numCustomers; j++)
		{
			firstName[j] = scan.next();
			lastName[j] = scan.next();
			totalItem = scan.nextInt();
			// for loop allows for user input of the name and quantity of item
			for (int k = 0; k < totalItem; k++)
			{
				itemQuantity = scan.nextInt();
				currentItem = scan.next();
				// utilization of calculate value sum method
				itemCost = calculateValueSum(currentItem, nameItem, costItem);
				// increases the total purchase of the customer based on the item and quantity
				custCost += itemQuantity * itemCost;
			}
			// sets total purchase to appropriate customer index
			totalCosts[j] = custCost;
			// resets total puchase variable
			custCost = 0;
		}
		
		// closes scan
		scan.close();
		
		// utilizes various methods to display biggest, smallest and average cost of purchases.
		biggestSpender(totalCosts, firstName, lastName);
		smallestSpender(totalCosts, firstName, lastName);
		System.out.println("Average: " + String.format("%.2f", average(totalCosts)));
	}
	static double calculateValueSum(String currentItem, String[] nameItem, double[] costItem)
	{
		double itemCost = 0;
		int position = 0;
		while (!currentItem.equalsIgnoreCase(nameItem[position]))
		{
			position++;
		}
		itemCost = costItem[position];
		
		return itemCost;
	}
	
	/* biggestSpender 
	 * Determines the biggest purchase made
	 *
	 * Input: array of double with costs, string arrays with first and last names
	 * 
	 * Output: Displays the name and cost of transaction of the biggest purchaser.
	 * 
	 * Preconditions:
	 * Input arrays must not be null
	 */
	
	static void biggestSpender(double[] costs, String[] firstName, String[] lastName)
	{
		double itemCost = costs[0];
		int position = 0;
		
		for (int i = 1; i < costs.length; i++)
		{
			if (costs[i] > itemCost)
			{
				itemCost = costs[i];
				position = i;
			}
		}
		System.out.println("Biggest: " + firstName[position] + " " + lastName[position] 
				+ " (" + String.format("%.2f", costs[position]) + ")");
	}
	
	/* smallestSpender 
	 * Determines the smallest purchase made
	 *
	 * Input: array of double with costs, string arrays with first and last names
	 * 
	 * Output: Displays the name and cost of transaction of the smallest purchaser.
	 * 
	 * Preconditions:
	 * Input arrays must not be null
	 */
	
	static void smallestSpender(double[] costs, String[] firstName, String[] lastName)
	{
		double itemCost = costs[0];
		int position = 0;
		
		for (int i = 1; i < costs.length; i++)
		{
			if (costs[i] < itemCost)
			{
				itemCost = costs[i];
				position = i;
			}
		}
		System.out.println("Smallest: " + firstName[position] + " " + lastName[position] 
				+ " (" + String.format("%.2f", costs[position]) + ")");
	}
	
	/* average 
	 * Calculates the average cost of all the purchases
	 *
	 * Input: array of double with costs
	 * 
	 * Output: double with the average cost of all purchases
	 * 
	 * Preconditions:
	 * Input array must not be null
	 */
	
	static double average(double[] costs)
	{
		double averageSpent = 0;
		
		for (int i = 0; i < costs.length; i++)
		{
			averageSpent += costs[i];
		}
		
		averageSpent = averageSpent / costs.length;
		return averageSpent;
	}

}
