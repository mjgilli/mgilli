package edu.miracosta.cs113;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class Lab13 {

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		/**
		 * solution to problem one programming
		 */
		
		Hashtable<String,Integer> wordCount = new Hashtable<String,Integer>();
		
		

	}
	/**
	 * solution to problem two programming
	 * @param input
	 * @param table
	 * @throws IOException
	 */
	public static void buildWordCount(Scanner input, Hashtable<String, Integer> table) throws IOException 
	{

		String line;
		int i = 0;
		line = input.nextLine();
		while ((input.hasNextLine())) 
		{

			String[] words = line.split(" ");

			for (i = 0; i < words.length; i++) 
			{

				String string = words[i].toLowerCase();

				if (table.containsKey(string)) 
				{

					int count = table.get(string);
					table.put(string, count + 1);
				}
				else 
				{
					table.put(string, 1);
				}
			}
		}
	}
}
