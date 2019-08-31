package a1;

import java.util.Arrays;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int numItems;
		int numCustomers;
		
		int itemQuantity;
		int totalItem;
		String currentItem;
		
		numItems = scan.nextInt();
		
		int itemsBought[] = new int[numItems];
		String identifiers[] = new String[numItems];
		int uniqueCustomers[] = new int[numItems];
		
		String[] nameItem = new String[numItems];
		double[] costItem = new double[numItems];
		
		for (int i = 0; i < numItems; i++)
		{
			nameItem[i] = scan.next();
			costItem[i] = scan.nextDouble();
		}
		
		numCustomers = scan.nextInt();
		
		String[] firstName = new String[numCustomers];
		String[] lastName = new String[numCustomers];
		
		for (int j = 0; j < numCustomers; j++)
		{
			firstName[j] = scan.next();
			lastName[j] = scan.next();
			totalItem = scan.nextInt();
			for (int k = 0; k < totalItem; k++)
			{
				itemQuantity = scan.nextInt();
				currentItem = scan.next();
				itemBought(currentItem, nameItem, itemQuantity, itemsBought, identifiers, 
						uniqueCustomers, lastName[j]);
			}
			Arrays.fill(identifiers, null);
		}
		
		scan.close();
		
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
