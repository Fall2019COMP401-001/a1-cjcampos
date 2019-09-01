package a1;

import java.util.Arrays;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// declares variables used in the program
		int numItems;
		int numCustomers;
		int itemQuantity;
		int totalItem;
		String currentItem;
		
		// user input for the number of items
		numItems = scan.nextInt();
		
		// creates arrays based on the number of items
		int itemsBought[] = new int[numItems];
		String identifiers[] = new String[numItems];
		int uniqueCustomers[] = new int[numItems];
		String[] nameItem = new String[numItems];
		double[] costItem = new double[numItems];
		
		// for loop for user input of the name and cost of each item
		for (int i = 0; i < numItems; i++)
		{
			nameItem[i] = scan.next();
			costItem[i] = scan.nextDouble();
		}
		
		// user input with the number of customers
		numCustomers = scan.nextInt();
		
		// String arrays for the names of customers
		String[] firstName = new String[numCustomers];
		String[] lastName = new String[numCustomers];
		
		// for loop for each customer's name and number of items bought
		for (int j = 0; j < numCustomers; j++)
		{
			firstName[j] = scan.next();
			lastName[j] = scan.next();
			totalItem = scan.nextInt();
			// for loop to determine the quantity of items and unique customer who bought them
			for (int k = 0; k < totalItem; k++)
			{
				itemQuantity = scan.nextInt();
				currentItem = scan.next();
				itemBought(currentItem, nameItem, itemQuantity, itemsBought, identifiers, 
						uniqueCustomers, lastName[j]);
			}
			// resets array of unique identifiers
			Arrays.fill(identifiers, null);
		}
		
		// closes scanner
		scan.close();
		
		// displays the number of unique customers and quantity of items bought
		for (int k = 0; k < itemsBought.length; k++)
		{
			if (uniqueCustomers[k] == 0)
			{
				System.out.println("No customers bought " + nameItem[k]);
			}
			else
			{
				System.out.println(uniqueCustomers[k] + " customers bought " + itemsBought[k] 
						+ " "+ nameItem[k]);
			}
		}
	}
	
	/* itemBought 
	 * Calculates the quantity bought along with the number of unique customers who purchased each item
	 *
	 * Input: string of name, string of arrays with the names of items, int with the quantity of items 
	 * bought, int array with the items available, string array with identifier for unique customers, 
	 * int array with the number of unique customers, and string with customer
	 * 
	 * Output: Calculates the number quantity and number of unique customers of an item
	 * 
	 * Preconditions:
	 * Input arrays must not be null and variables must not be null
	 */
	
	static void itemBought(String currentItem, String[] nameItem, int itemQuantity, int[] itemsBought, 
			String[] identifiers, int[] uniqueCustomers, String customer)
	{
		int position = 0;
		while (!currentItem.equalsIgnoreCase(nameItem[position]))
		{
			position++;
		}
		itemsBought[position] += itemQuantity;
		if (identifiers[position] == null)
		{
			uniqueCustomers[position]++;
			identifiers[position] += customer;
		}
		else if (!identifiers[position].contains(customer))
		{
			uniqueCustomers[position]++;
			identifiers[position] += customer;
		}
	}

}
