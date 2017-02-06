package edu.miracosta.cs113;
/********************************************
* AUTHOR: Matthew Gilli
* COURSE: CS 113
* SECTION: MW 15:30-17:20
* HOMEWORK #: 01
* PROJECT #: Project 01
* LAST MODIFIED: 2017-02-05
********************************************/
/*****************************************************************************
* LabFour
*****************************************************************************
* PROGRAM DESCRIPTION:
* This program compares two equations
*****************************************************************************
* ALGORITHM:
* 1.BEGIN
* 2.	FOR(int n = 0 to 100)
* 3.		CALC y1
* 4.		CALC y2
* 5.		OUTPUT n
* 6.		OUTPUT y1
* 7.		OUTPUT y2
* 8.		OUTPUT comparison
* 9.	END FOR
* 10.	OUTPUT reflection message
* 11. END
*****************************************************************************
* ALL IMPORTED PACKAGES NEEDED AND PURPOSE:
*****************************************************************************/
public class LabFour
{
	public static void main(String[] args)
	{
		int y1;
		int y2;
		
		for(int n = 0; n<=100; n = n + 10)
		{
			y1 = 100*n +10;
			y2 = 5 * n * n + 2;
			
			System.out.printf(" n = %8d", n);
			System.out.printf(" y1 = %8d", y1);
			System.out.printf(" y2 = %8d", y2);
			if(y1>y2)
			{
				System.out.printf(" y1 > y2%n");
			}
			else if (y1<y2)
			{
				System.out.printf(" y1 < y2%n");
			}
			else
			{
				System.out.printf(" y1 = y2%n");
			}
		}
		System.out.println("The results do not surprise me because n^2 is bigger than n" +
		 " so the results will get bigger and the n increases" +
		 " The results show that y1 is bigger in the beginning but" +
		 " y2 gets bigger because it has an n^2 in it... as expected");
		/**
		 * The results do not surprise me because n^2 is bigger than n
		 * so the results will get bigger and the n increases
		 * The results show that y1 is bigger in the beginning but
		 * y2 gets bigger because it has an n^2 in it... as expected
		 */
		
	}
}
