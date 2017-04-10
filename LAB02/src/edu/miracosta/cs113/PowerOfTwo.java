package edu.miracosta.cs113;

/********************************************
* AUTHOR: Matthew Gilli
* COURSE: CS 113
* SECTION: MW 15:30-17:20
* HOMEWORK #: 01
* PROJECT #: Project 01
* LAST MODIFIED: 2017-01-29
********************************************/
/*****************************************************************************
* PowerOfTwo
*****************************************************************************
* PROGRAM DESCRIPTION:
* Determines if number is power of two
*****************************************************************************
* ALGORITHM:
* 1.BEGIN
* 2.	ASSIGN keyboard
* 3.	OUTPUT message of number in question
* 4.	INPUT  temp
* 5.	CALC   numToTest
* 6.	CALC   isPowerOfTwo
* 7.	IF (isPowerOfTwo)
* 8.		OUTPUT is power of two
* 9.	ELSE
* 10.		OUTPUT is not power of two
* 11.	END IF
* 29. END
*****************************************************************************
* ALL IMPORTED PACKAGES NEEDED AND PURPOSE:
* Scanner= used for console input
*****************************************************************************/
import java.util.Scanner;
public class PowerOfTwo
{
	public static void main(String[] args)
	{
		Scanner keyboard;
		boolean isPowerOfTwo;
		String  temp;
		int     numToTest;
		
		keyboard = new Scanner(System.in);
		
		System.out.print("What number would you like to test to find "
						+"out if it is a power of two? ");
		temp = keyboard.nextLine();
		keyboard.close();
		numToTest = Integer.parseInt(temp);
		
		isPowerOfTwo = isPowerOfTwo(numToTest);
		
		if(isPowerOfTwo)
		{
			System.out.println( numToTest + " is a power of two");
		}
		else
		{
			System.out.println( numToTest + " isn't a power of two");
		}	 
	}
	
	// DESCRIPTION:		Determines if number in question is a power
	//					of two
	// PRE-CONDITION:	The number being passed in must be an integer
	// POST-CONDITION:	Returns true if number in question is a power of 
	//					two else returns false
	static boolean isPowerOfTwo(int numInQuestion)
	{
		boolean isPower;
		int     number;
		
		isPower = false;
		number		 = 1;
		
		while( number*number <= numInQuestion)
		{
			if(number*number == numInQuestion)
			{
				isPower = true;
			}
			number++;
		}
		return isPower;
	}
}

