package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int numItems;
		int numCustomers;
		
		
		int itemQuantity;
		double custCost = 0;
		int totalItem;
		String currentItem;
		double itemCost;
		
		numItems = scan.nextInt();
		
		String[] nameItem = new String[numItems];
		double[] costItem = new double[numItems];
		
		for (int i = 0; i < numItems; i++)
		{
			nameItem[i] = scan.next();
			costItem[i] = scan.nextDouble();
		}
		
		numCustomers = scan.nextInt();
		
		double[] totalCosts = new double[numCustomers];
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
				itemCost = calculateValueSum(currentItem, nameItem, costItem);
				custCost += itemQuantity * itemCost;
			}
			totalCosts[j] = custCost;
			custCost = 0;
		}
		
		scan.close();
		
		biggestSpender(totalCosts, firstName, lastName);
		smallestSpender(totalCosts, firstName, lastName);
		System.out.println("Average: " + String.format("%.2f", average(totalCosts)));
	}
	static double calculateValueSum(String currentItem, String[] nameItem, double[] costItem)
	{
		double itemCost = 0;
		
		/*for (int i = 0; i < nameItem.length; i++)
		{
			if (currentItem.equalsIgnoreCase(nameItem[i]))
			{
				itemCost = costItem[i];
			}
		}
		*/
		int position = 0;
		while (!currentItem.equalsIgnoreCase(nameItem[position]))
		{
			position++;
		}
		itemCost = costItem[position];
		
		return itemCost;
	}
	
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
