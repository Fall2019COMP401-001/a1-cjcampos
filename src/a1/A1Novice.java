package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		// declares all variables utilized in the program
		Scanner scan = new Scanner(System.in);
		int numCustomers;
		
		// obtains the number of customers
		numCustomers = scan.nextInt();
		int itemNum;
		int itemQuantity;
		String itemName;
		double itemCost;
		double custCost;
		
		// declares array to hold the names and total costs of the customers.
		double[] totalCosts = new double[numCustomers];
		String[] firstNames = new String[numCustomers];
		String[] lastNames = new String[numCustomers];
		
		// for loop for all the customers.
		for (int i = 0; i < numCustomers; i++)
		{
			// allows user input for the names and total number of items for a customer.
			custCost = 0;
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			itemNum = scan.nextInt();
			// for loop for each individual item bought by a customer
			for (int j = 0; j < itemNum; j++)
			{
				// allows user input for the name, quantity and cost of an item
				itemQuantity = scan.nextInt();
				itemName = scan.next();
				itemCost = scan.nextDouble();
				// adds up the items to the total purchase of a customer.
				custCost += itemQuantity * itemCost;
			}
			// adds the total cost to the index for the specific customer
			totalCosts[i] = custCost;
		}
		
		// closes the scanner
		scan.close();
		
		// prints out the first character in the first name, the last name, and total cost of purchase
		for (int k = 0; k < numCustomers; k++)
		System.out.println(firstNames[k].charAt(0) + ". " + lastNames[k] + ": " 
		+ String.format("%.2f", totalCosts[k]));
		
	}
}
