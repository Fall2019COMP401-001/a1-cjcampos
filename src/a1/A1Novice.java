package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

int numCustomers;
		
		numCustomers = scan.nextInt();
		int itemNum;
		int itemQuantity;
		String itemName;
		double itemCost;
		double custCost;
		double[] totalCosts = new double[numCustomers];
		String[] firstNames = new String[numCustomers];
		String[] lastNames = new String[numCustomers];
		
		for (int i = 0; i < numCustomers; i++)
		{
			custCost = 0;
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			itemNum = scan.nextInt();
			for (int j = 0; j < itemNum; j++)
			{
				itemQuantity = scan.nextInt();
				itemName = scan.next();
				itemCost = scan.nextDouble();
				custCost += itemQuantity * itemCost;
			}
			totalCosts[i] = custCost;
		}
		
		for (int k = 0; k < numCustomers; k++)
		System.out.println(firstNames[k].charAt(0) + ". " + lastNames[k] + ": " 
		+ String.format("%.2f", totalCosts[k]));
		
		scan.close();
		
	}
}
