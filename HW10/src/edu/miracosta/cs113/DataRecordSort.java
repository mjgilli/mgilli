package edu.miracosta.cs113;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataRecordSort 
{
	public static final String FILE_NAME = "initialData.txt";
	public static void main(String[] args) 
	{
		/***** DECLARATION SECTION *****/
		Scanner inputStream;
		Scanner tempInputStream1;
		Scanner tempInputStream2;
		PrintWriter outputStream;
		PrintWriter outputStreamToTemp;
		int[] sequenceA;
		int[] sequenceB;
		int runs;
		int count;
		int compare1;
		int compare2;
		boolean done;
		int runCount;
		
		/***** INITIALIZATION SECTION *****/
		inputStream = null;
		tempInputStream1 = null;
		tempInputStream2 = null;
		outputStream = null;
		outputStreamToTemp = null;
		runs		= 3;
		count		= 0;
		done = false;
		runCount =1;
	
		
		/****** INPUT SECTION ******/
		try
		{
			inputStream = new Scanner(new FileInputStream(FILE_NAME));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("ERROR: File " + FILE_NAME + " was not found or could not be opened.");
			System.exit(0);
		}
		
		
		/***** PROCESSING SECTION *****/
		while(inputStream.hasNextLine())
		{
			sequenceA = new int[runs];
			sequenceB = new int[runs];
			for(int i = 0; i < runs; i++)
			{
				if(inputStream.hasNextLine())
				{
					sequenceA[i] = Integer.parseInt(inputStream.nextLine());
					count++;
				}
			}
			
			
			
			for(int i = 0; i < runs; i++)
			{
				if(inputStream.hasNextLine())
				{
					sequenceB[i] = Integer.parseInt(inputStream.nextLine());
					count++;
				}
				
			}
			
			
			/***********SORT ARRAY OF RUNS **********/
			radixSort(sequenceA);
			radixSort(sequenceB);
			
			
			//writing to output file1
			try
			{
				outputStream = new PrintWriter(new FileOutputStream("tempOutputFile1.txt"));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("ERROR: File tempOutputFile1.txt could not be written.");
				System.exit(0);
			}
			
			for(int i = 0; i < sequenceA.length; i++)
			{
				outputStream.println(sequenceA[i]);
			}
			
			
			outputStream.close();
			
			// writing to output file 2
			try
			{
				outputStream = new PrintWriter(new FileOutputStream("tempOutputFile2.txt"));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("ERROR: File tempOutputFile2.txt could not be written.");
				System.exit(0);
			}
			
			for(int i = 0; i < sequenceB.length; i++)
			{
				outputStream.println(sequenceB[i]);
			}
			
			outputStream.close();
			
			/********************MERGING FILES********************/
			try
			{
				tempInputStream1 = new Scanner(new FileInputStream("tempOutputFile1.txt"));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("ERROR: File tempOutputFile1.txt was not found or could not be opened.");
				System.exit(0);
			}
			
			try
			{
				tempInputStream2 = new Scanner(new FileInputStream("tempOutputFile2.txt"));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("ERROR: File tempOutputFile2.txt was not found or could not be opened.");
				System.exit(0);
			}
			
			try
			{
				outputStreamToTemp = new PrintWriter(new FileOutputStream("sortedData.txt"));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("ERROR: File sortedData.txt could not be written.");
				System.exit(0);
			}
			
			compare1 = Integer.parseInt(tempInputStream1.nextLine());
			compare2 = Integer.parseInt(tempInputStream2.nextLine());
			while(tempInputStream1.hasNextLine() && tempInputStream2.hasNextLine())
			{
				
				if(compare1 < compare2)
				{
					outputStreamToTemp.println(compare1);
					if(tempInputStream1.hasNextLine())
					{
						compare1 = Integer.parseInt(tempInputStream1.nextLine());
					}
				}
				else
				{
					outputStreamToTemp.println(compare2);
					if(tempInputStream2.hasNextLine())
					{
						compare2 = Integer.parseInt(tempInputStream2.nextLine());
					}
				}
			}
			
			if(compare1 < compare2)
			{
				outputStreamToTemp.println(compare1);
			}
			else
			{
				outputStreamToTemp.println(compare2);
			}
			
			while(tempInputStream1.hasNextLine())
			{
				outputStreamToTemp.println(tempInputStream1.nextLine());
			}
			while(tempInputStream2.hasNextLine())
			{
				outputStreamToTemp.println(tempInputStream2.nextLine());
			}
			
			if(compare1 > compare2)
			{
				outputStreamToTemp.println(compare1);
			}
			else
			{
				outputStreamToTemp.println(compare2);
			}
			
			
			tempInputStream1.close();
			tempInputStream2.close();			
		}
		outputStreamToTemp.close();
		inputStream.close();
		runs = runs * 2;
		
		while(!done)
		{
			try
			{
				inputStream = new Scanner(new FileInputStream("sortedData.txt"));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("ERROR: File sortedData.txt was not found or could not be opened.");
				System.exit(0);
			}
			
			//read to temp output files
			sequenceA = new int[runs];
			sequenceB = new int[runs];
			for(int i = 0; i < runs; i++)
			{
				if(inputStream.hasNextLine())
				{
					sequenceA[i] = Integer.parseInt(inputStream.nextLine());
				}
			}
			
			for(int i = 0; i < runs; i++)
			{
				if(inputStream.hasNextLine())
				{
					sequenceB[i] = Integer.parseInt(inputStream.nextLine());
				}
			}
			
			//writing to output file1
			try
			{
				outputStream = new PrintWriter(new FileOutputStream("tempOutputFile1.txt"));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("ERROR: File tempOutputFile1.txt could not be written.");
				System.exit(0);
			}
			
			for(int i = 0; i < sequenceA.length; i++)
			{
				outputStream.print(sequenceA[i]);
			}
			
			
			outputStream.close();
			
			// writing to output file 2
			try
			{
				outputStream = new PrintWriter(new FileOutputStream("tempOutputFile2.txt"));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("ERROR: File tempOutputFile2.txt could not be written.");
				System.exit(0);
			}
			
			for(int i = 0; i < sequenceB.length; i++)
			{
				outputStream.print(sequenceB[i]);
			}
			
			outputStream.close();
			
			/********************MERGING FILES********************/
			try
			{
				tempInputStream1 = new Scanner(new FileInputStream("tempOutputFile1.txt"));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("ERROR: File tempOutputFile1.txt was not found or could not be opened.");
				System.exit(0);
			}
			
			try
			{
				tempInputStream2 = new Scanner(new FileInputStream("tempOutputFile2.txt"));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("ERROR: File tempOutputFile2.txt was not found or could not be opened.");
				System.exit(0);
			}
			
			try
			{
				outputStreamToTemp = new PrintWriter(new FileOutputStream("sortedData" + runCount +".txt"));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("ERROR: File sortedData.txt could not be written.");
				System.exit(0);
			}
			
			compare1 = Integer.parseInt(tempInputStream1.nextLine());
			compare2 = Integer.parseInt(tempInputStream2.nextLine());
			while(tempInputStream1.hasNextLine() && tempInputStream2.hasNextLine())
			{
				
				if(compare1 < compare2)
				{
					outputStreamToTemp.println(compare1);
					if(tempInputStream1.hasNextLine())
					{
						compare1 = Integer.parseInt(tempInputStream1.nextLine());
					}
				}
				else
				{
					outputStreamToTemp.println(compare2);
					if(tempInputStream2.hasNextLine())
					{
						compare2 = Integer.parseInt(tempInputStream2.nextLine());
					}
				}
			}
			
			if(compare1 < compare2)
			{
				outputStreamToTemp.println(compare1);
			}
			else
			{
				outputStreamToTemp.println(compare2);
			}
			
			while(tempInputStream1.hasNextLine())
			{
				outputStreamToTemp.println(tempInputStream1.nextLine());
			}
			while(tempInputStream2.hasNextLine())
			{
				outputStreamToTemp.println(tempInputStream2.nextLine());
			}
			
			if(compare1 > compare2)
			{
				outputStreamToTemp.println(compare1);
			}
			else
			{
				outputStreamToTemp.println(compare2);
			}
			
			tempInputStream1.close();
			tempInputStream2.close();
			
			
			runs = runs * 2;
			runCount++;
			
			if(runs >= count)
			{
				done = true;
			}
		}
		outputStreamToTemp.close();
		
		
		/***** OUTPUT SECTION *****/

	}
	public static void radixSort( int[] a)
    {
		int max = a[0];
        int exp = 1; 
        int[] b = new int[10];
        
        for (int i = 1; i < a.length; i++)
        {
            if (a[i] > max)
            {
                max = a[i];
            }
        }
        
        while (max / exp > 0)
        {
            int[] bucket = new int[10];
 
            for (int i = 0; i < a.length; i++)
            {
            	bucket[(a[i] / exp) % 10]++;
            }
            for (int i = 1; i < 10; i++)
            {
                bucket[i] += bucket[i - 1];
            }
            for (int i = a.length - 1; i >= 0; i--)
            {
                b[--bucket[(a[i] / exp) % 10]] = a[i];
            }
            for (int i = 0; i < a.length; i++)
            {
                a[i] = b[i];
            }
            exp *= 10;        
        }
    }
        
	
}
