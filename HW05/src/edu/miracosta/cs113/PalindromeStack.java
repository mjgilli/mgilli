package edu.miracosta.cs113;

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
