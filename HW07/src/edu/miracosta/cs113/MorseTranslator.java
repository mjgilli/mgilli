/********************************************
* AUTHOR: Matthew Gilli
* COURSE: CS 113
* SECTION: MW 3:30-5:20
* HOMEWORK #: 07
* PROJECT #:  01
* LAST MODIFIED: 2017-04-09
********************************************/
/*****************************************************************************
* MorseTranslator
*****************************************************************************
* PROGRAM DESCRIPTION:
* Menu gives you choices to decode messages from file or input
* and shows translation tree
*****************************************************************************
* ALGORITHM:
* 1. BEGIN
* 2.	ASSIGN morseTree
* 3.	ASSIGN keyboard
* 4.	ASSIGN fileName
* 5.	ASSIGN treeRead
* 6.	ASSIGN translation
* 7.	ASSIGN decoder
* 8.	TRY
* 9.		ASSIGN treeRead
* 10.	CATCH (FileNotFoundException e)
* 11.	CALC morseTree.readBinaryTree();
* 12.	CALC treeRead.close()
* 13.	OUTPUT menu
* 14. 	INPUT choice
* 15.	IF (choice == 'A')
* 16.		OUTPUT morseTree
* 17.	ELSE IF (choice == 'B')
* 18.		CALC fileName
* 19.		TRY
* 20.			ASSIGN decoder
* 21.		CATCH (FileNotFoundException e)
* 22.		ASSIGN tempTree
* 23.		DO
* 24.			CALC temp
* 25.			FOR(int i to temp.length)
* 26.				IF(temp.charAt == *)
* 27.					CALC getLeftSubTree
* 28.				END IF
* 29.				IF(temp.charAt == -)
* 30.					CALC getRightSubTree
* 31.				END IF
* 32.			END FOR
* 33.			CALC translation
* 34.			ASSIGN tempTree
* 35.			WHILE (decoder.hasNext)
* 36.			OUTPUT translation
* 37.	ELSE IF ( choice == 'C')
* 38.		ASSIGN tempTree
* 39.		INPUT temp
* 40.		CALC splited
* 41.		FOR(int j= 0 to temp.length)
* 42.			CALC temp
* 43.			FOR (int i = 0 to temp.length)
* 44.				IF(temp.charAt == *)
* 45.					CALC getLeftSubTree
* 46.				END IF
* 47.				IF(temp.charAt == -)
* 48.					CALC getRightSubTree
* 49.				END IF
* 50.			END FOR	
* 51.			CALC translation
* 52.			ASSIGN tempTree
* 53.		END FOR	
* 54.		OUTPUT translation
* 55.	ELSE
* 56.		OUTPUT message
* 57.	END IF
* 58.	OUTPUT thank you
* 59. END		
*****************************************************************************
* ALL IMPORTED PACKAGES NEEDED AND PURPOSE:
* Scanner for user input
* collection for sorting array list
* array list for storing data
*****************************************************************************/

package edu.miracosta.cs113;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseTranslator
{

	public static void main(String[] args)
	{
		/***** DECLARATION SECTION ******/
		Scanner keyboard;
		Scanner treeRead;
		Scanner decoder;
		char    choice;
		BinaryTree<String> morseTree;
		BinaryTree<String> tempTree;
		String temp;
		String fileName;
		String translation;
		
		/******** INSTANTIATION SECTION *******/
		morseTree = new BinaryTree<String>();
		keyboard = new Scanner(System.in);
		fileName = "Morse.txt";
		treeRead = null;
		translation = "";
		decoder = null;
		
		
		/****** INPUT SECTION ******/
		try
		{
			treeRead = new Scanner(new FileInputStream(fileName));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: File " + fileName + " was not found or could not be opened.");
			System.exit(0);
		}
		morseTree = BinaryTree.readBinaryTree(treeRead);
		treeRead.close();
		
		System.out.println("Please pick from 3 options.");
		System.out.println("      A: Print Morse Code Translation Tree");
		System.out.println("      B: Decode from a file");
		System.out.println("      C: Decode a message to enter");
		System.out.println("      D: To quit");
		System.out.print("Enter here: ");
		temp = keyboard.nextLine();
		choice = temp.charAt(0);
		
		
		temp = "*** --- ***";
		/******* PROCESSING SECTION ********/
		if(choice == 'A')
		{
			System.out.println(morseTree);
		}
		else if (choice == 'B')
		{
			fileName = "DecodeMessage.txt";
			try
			{
				decoder = new Scanner(new FileInputStream(fileName));
			}
			catch (FileNotFoundException e)
			{
				System.out.println("ERROR: File " + fileName + " was not found or could not be opened.");
				System.exit(0);
			}
			
			tempTree = new BinaryTree<String>(morseTree.getData(), morseTree.getLeftSubtree(), morseTree.getRightSubtree());
			do
			{
				temp = decoder.next();
				for(int i = 0; i < temp.length(); i++)
				{
					if(temp.charAt(i) == '*')
					{
						tempTree = tempTree.getLeftSubtree();
						
					}
					if(temp.charAt(i) == '-')
					{
						tempTree = tempTree.getRightSubtree();
						
					}
				}
				
				translation += tempTree.getData().charAt(0);
				
				tempTree = new BinaryTree<String>(morseTree.getData(), morseTree.getLeftSubtree(), morseTree.getRightSubtree());
				
			} while(decoder.hasNext());
			decoder.close();
			System.out.println("The translation from the file = " + translation);
			
		}
		else if (choice == 'C')
		{
			
			tempTree = new BinaryTree<String>(morseTree.getData(), morseTree.getLeftSubtree(), morseTree.getRightSubtree());
			System.out.println("Enter message in morse you wish to decode.");
			System.out.print("Enter here: ");
			temp = keyboard.nextLine();
			keyboard.close();
			String[] splited = temp.split(" ");
			for(int j = 0; j < splited.length; j++)
			{
				temp = splited[j];
				for(int i = 0; i < temp.length(); i++)
				{
					if(temp.charAt(i) == '*')
					{
						tempTree = tempTree.getLeftSubtree();
						
					}
					if(temp.charAt(i) == '-')
					{
						tempTree = tempTree.getRightSubtree();
						
					}
				}
				
				translation += tempTree.getData().charAt(0);
				
				tempTree = new BinaryTree<String>(morseTree.getData(), morseTree.getLeftSubtree(), morseTree.getRightSubtree());
				
			}
			System.out.println("The translation of the message is " + translation);
			
		}
		else
		{
			System.out.println("You have chosen to not use the program.");
		}
		
		/******* OUTPUT SECTION ********/
		System.out.println("Thank you for using the morse tree translator");

	}

}
