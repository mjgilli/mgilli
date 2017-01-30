package edu.miracosta.cs113;
/********************************************
* AUTHOR: Matthew Gilli
* COURSE: CS 113
* SECTION: MW 15:30-17:20
* LAB #: 01
* PROJECT #: Project 01
* LAST MODIFIED: 2017-01-29
********************************************/
/*****************************************************************************
* FizzBuzz
*****************************************************************************
* PROGRAM DESCRIPTION:
* This program outputs fizz for every multiple of 3, buzz for every multiple
* of 5 and Fizzbuzz for every multiple of 3 and 5
*****************************************************************************
* ALGORITHM:
* 1.BEGIN
* 2.	FOR(int i = 1 to 100)
* 3.		IF (i % 3 == 0 && i % 5 == 0)
* 4.			OUTPUT "Fizzbuzz"
* 5.		ELSE IF (i % 3 == 0)
* 6.			OUTPUT "Fizz"
* 7.		ELSE IF (i % 5 == 0)
* 8.			OUTPUT "Buzz"
* 9.		ELSE
* 10			OUTPUT i
* 11.		END IF
* 29. END
*****************************************************************************
* ALL IMPORTED PACKAGES NEEDED AND PURPOSE:
*****************************************************************************/
public class FizzBuzz
{
	public static void main(String[] args)
	{
		for(int i = 1; i < 101; i++)
		{
			if(i % 3 == 0 && i % 5 == 0)
			{
				System.out.println("Fizzbuzz");
			}
			else if (i % 3 == 0)
			{
				System.out.println("Fizz");
			}
			else if (i % 5 == 0)
			{
				System.out.println("Buzz");
			}
			else
			{
				System.out.println(i);
			}
		}
	}
}


