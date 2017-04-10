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
		//keyboard.close();
		
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
