package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.Scanner;

public class ChangeRecursion 
{
	public static void main(String[] args)
	{
		Scanner keyboard;
		int changeToCount;
		changeToCount = 0;
		keyboard      = new Scanner(System.in);
	
		System.out.print("Enter an amount of change to find all the combinations possible: ");
		changeToCount = keyboard.nextInt();
		keyboard.nextLine();
		keyboard.close();
		System.out.println("Combinations for " + changeToCount + " cents are as follows:");
		System.out.println("\nQuarters   Dimes    Nickels   Pennies");
		
		combination(changeToCount, 0, 0, 0, changeToCount);
	}
	
	/** 
	 * makes combinations of change using recursion
	 * manipulates change by incrementing and subtracting from coins
	 * @param change: int representing money
	 * @param quarters: int representing quarter of 25 cents
	 * @param dimes: int representing dimes of 10 cents
	 * @param nickles: int representing nickels of 5 cents
	 * @param pennies: int representing pennies of 1 cent
	 */
	public static void combination(double change, int quarters, int dimes, int nickels, int pennies)
	{
		if(quarters * 25 + dimes * 10 + nickels * 5 + pennies > change)
		{
			return;
		}
		else
		{
		    combinationStore(quarters, dimes, nickels, pennies);
		    if (pennies >= 5) 
		    {
		        combination(change, quarters, dimes, nickels + 1, pennies - 5);
		    }
		    if (pennies >= 10) 
		    {
		    	combination(change, quarters, dimes + 1, nickels, pennies - 10);
		    }
		    if (pennies >= 25)
		    {
		    	combination(change, quarters + 1, dimes, nickels, pennies - 25);
		    }
		}
	}
	
	/**
	 * array representing amount of quarter, dimes, nickels, and pennies
	 * @param quarters: int representing quarter of 25 cents
	 * @param dimes: int representing dimes of 10 cents
	 * @param nickles: int representing nickels of 5 cents
	 * @param pennies: int representing pennies of 1 cent
	 */
	public static ArrayList<int[]> combinationStore(int quarters, int dimes, int nickels, int pennies)
	{
		ArrayList<int[]> differentCombos = new ArrayList<int[]>();
		System.out.println();
		int[] tempcombination = new int[4];
		tempcombination[0] = quarters;
		tempcombination[1] = dimes;
		tempcombination[2] = nickels;
		tempcombination[3] = pennies;
		
		differentCombos.add(tempcombination);

		for(int i = 0; i < tempcombination.length; i++)
		{
			System.out.print(tempcombination[i] + "           ");
		}
		System.out.println();
		
		return differentCombos;
	}

}
