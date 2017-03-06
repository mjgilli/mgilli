package edu.miracosta.cs113;
/********************************************
* AUTHOR: Matthew Gilli
* COURSE: CS 113
* SECTION: MW 3:30-5:20
* HOMEWORK #: 05
* PROJECT #:  01
* LAST MODIFIED: 2017-03-05
********************************************/
/*****************************************************************************
* PalindromeStack
*****************************************************************************
* PROGRAM DESCRIPTION:
* Determines whether sentence is palindrome
* deletes all special characters and spaces
* observes only lowercase
*****************************************************************************
* ALGORITHM:
* 1. BEGIN
* 2. 	ASSIGN keyboard
* 3.	ASSIGN originalStack
* 4.	ASSIGN compareStack
* 5.	ASSIGN newSentence
* 6.	ASSIGN isPalindrome
* 7.	INPUT  sentence
* 8.	CALC   sentence.toLowerCase()
* 9.	FOR(int i = 0; i < sentence.length(); i++)
* 10.		IF(sentence.charAt(i) >= 'a' && sentence.charAt(i) <= 'z' )
* 11.			CALC newSentence
* 12.		END IF
* 13.	END FOR
* 14.	FOR(int i = 0; i < newSentence.length(); i++)
* 15.		CALC originalStack.push(newSentence.charAt(i))
* 16.	END FOR
* 17.	IF(newSentence.length() % 2 == 0)
* 18.		CALC numberOfPushes
* 20.	ELSE
* 21.		CALC numberOfPushes
* 22.	END IF
* 23.	FOR(int i = 0; i < numberOfPushes; i++)
* 24.		CALC compareStack.push(originalStack.pop())
* 25.	END FOR
* 26.	IF(newSentence.length() % 2 != 0)
* 27.		CALC compareStack.pop()
* 28.	END IF
* 29.	WHILE(!originalStack.empty() && isPalindrome)
* 30.		CALC isPalindrome
* 31.	END WHILE
* 32.	OUTPUT message
* 13. END
*****************************************************************************
* ALL IMPORTED PACKAGES NEEDED AND PURPOSE:
* Scanner for user input
*****************************************************************************/
import java.util.Scanner;
public class PalindromeStack
{
	public static void main(String[] args)
	{
		/****** DECLARATION SECTION *******/
		Scanner 			  keyboard;
		String 				  sentence;
		String				  newSentence;
		ArrayStack<Character> originalStack;
		ArrayStack<Character> compareStack;
		int					  numberOfPushes;
		boolean				  isPalindrome;
		
		
		
		/***** INITIALIZATION SECTION ********/
		keyboard 		= new Scanner(System.in);
		originalStack 	= new ArrayStack<Character>();
		compareStack  	= new ArrayStack<Character>();
		newSentence 	= "";
		isPalindrome	= true;
		
		/***** INPUT SECTION *******/
		System.out.println("Enter sentence/word to check if palindrome?");
		sentence = keyboard.nextLine();
		keyboard.close();  //cleanup
		
		/***** PROCESSING SECTION *****/
		sentence = sentence.toLowerCase();
		
		//to remove all spaces and/or special characters
		for(int i = 0; i < sentence.length(); i++)
		{
			if(sentence.charAt(i) >= 'a' && sentence.charAt(i) <= 'z' )
			{
				newSentence += sentence.charAt(i);
			}
		}
		
		// add newSentence to orignalStack
		for(int i = 0; i < newSentence.length(); i++)
		{
			originalStack.push(newSentence.charAt(i));
		}
		
		/**
		// check if original stack contains palindrome
		while(!originalStack.empty())
		{
			System.out.println(originalStack.pop());
		}
		*/
		
		//Calculate number of pushes
		if(newSentence.length() % 2 == 0)
		{
			numberOfPushes = newSentence.length() / 2;
		}
		else
		{
			numberOfPushes = newSentence.length()/2 + 1;
		}
		
		// add characters until originalStack size == compareStack size
		// OR originalStack size < compareStack size
		for(int i = 0; i < numberOfPushes; i++)
		{
			compareStack.push(originalStack.pop());
		}
		
		/**
		//checking contents in stacks
		System.out.println("originalStack contents:");
		while(!originalStack.empty())
		{
			System.out.println(originalStack.pop());
		}
		
		System.out.println("compareStack contents:");
		while(!compareStack.empty())
		{
			System.out.println(compareStack.pop());
		}
		*/
		if(newSentence.length() % 2 != 0)
		{
			compareStack.pop();
		}
		
		/**
		//checking contents in stacks
		System.out.println("originalStack contents:");
		while(!originalStack.empty())
		{
			System.out.println(originalStack.pop());
		}
		
		System.out.println("compareStack contents:");
		while(!compareStack.empty())
		{
			System.out.println(compareStack.pop());
		}
		*/
		
		//comparing charcters
		while(!originalStack.empty() && isPalindrome)
		{
			isPalindrome = (originalStack.pop() == compareStack.pop());
		}
				
		
		/***** OUTPUT SECTION ********/
		if(isPalindrome)
		{
			System.out.println("The sentence is a palindrome.");
		}
		else
		{
			System.out.println("The sentence isn't a palindrome");
		}

	}
}
