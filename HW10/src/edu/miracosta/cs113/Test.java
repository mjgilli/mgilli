package edu.miracosta.cs113;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner tempInputStream1 = null;
		try
		{
			tempInputStream1 = new Scanner(new FileInputStream("test1.txt"));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("ERROR: File tempOutputFile1.txt was not found or could not be opened.");
			System.exit(0);
		}
		
		Scanner tempInputStream2 = null;
		try
		{
			tempInputStream2 = new Scanner(new FileInputStream("test2.txt"));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("ERROR: File tempOutputFile2.txt was not found or could not be opened.");
			System.exit(0);
		}
		
		
		
		int compare1 = tempInputStream1.nextInt();
		int compare2 = tempInputStream2.nextInt();
		while(tempInputStream1.hasNextInt() && tempInputStream2.hasNextInt())
		{
			
			if(compare1 < compare2)
			{
				System.out.println(compare1);
				if(tempInputStream1.hasNextInt())
				{
					compare1 = tempInputStream1.nextInt();
				}
			}
			else
			{
				System.out.println(compare2);
				if(tempInputStream2.hasNextInt())
				{
					compare2 = tempInputStream2.nextInt();
				}
			}
		}
		if(compare1 < compare2)
		{
			System.out.println(compare1);
		}
		else
		{
			System.out.println(compare2);
		}
		
		while(tempInputStream1.hasNextLine())
		{
			System.out.println(tempInputStream1.nextLine());
		}
		while(tempInputStream2.hasNextLine())
		{
			System.out.println(tempInputStream2.nextLine());
		}
		
		
		/**
		if(compare1 < compare2)
		{
			System.out.println(compare1);
			System.out.println(compare2);
		}
		else
		{
			System.out.println(compare2);
			System.out.println(compare1);
		}
		
		
		while(tempInputStream1.hasNextLine())
		{
			int num = tempInputStream1.nextInt();
			if(num != 0)
			{
				System.out.println(num);
			}
		}
		
		while(tempInputStream2.hasNextLine())
		{
			int num = tempInputStream2.nextInt();
			if(num != 0)
			{
				System.out.println(num);
			}
		}**/
		
		
		
		
		tempInputStream1.close();
		tempInputStream2.close();

	}

}
