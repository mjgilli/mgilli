/********************************************
* AUTHOR: Matthew Gilli
* COURSE: CS 113
* SECTION: MW 3:30-5:20
* HOMEWORK #: 06
* PROJECT #:  01
* LAST MODIFIED: 2017-03-012
********************************************/
/*****************************************************************************
* PrintSystemTest
*****************************************************************************
* PROGRAM DESCRIPTION:
* An operating system assigns jobs to print queues based on the	
* number of pages	to be printed
*****************************************************************************

*****************************************************************************
* ALL IMPORTED PACKAGES NEEDED AND PURPOSE:
* Scanner for user input
* collection for sorting array list
* array list for storing data
*****************************************************************************/
package edu.miracosta.cs113;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class PrintSystemTest
{
	public static void main(String[] args)
	{
		/***** DECLARATION SECTION ******/
		int[]	 jobArray;
		int		 printToAdd;
		int		 newStart ;
		int		 newStartSmall;
		int		 newStartMedium;
		int		 newStartLarge;
		int      randomNumber;
		char	 choice;
		PrintJob tempJob;
		/******** INSTANTIATION SECTION *******/
		ArrayList<Integer> endTimes = new ArrayList<Integer>();
		Scanner keyboard	 = new Scanner(System.in);
		Printer small 		 = new Printer("small", 0, 10);
		Printer medium 		 = new Printer("medium", 10, 20);
		Printer large        = new Printer("large", 20, 50);
		Printer smallHalf    = new Printer("smallHalf", 0, 25);
		Printer largeHalf    = new Printer("largeHalf",25, 50);
		Printer superPrinter = new Printer("superPrinter", 0, 50);
		newStart	 		 = 0;
		newStartSmall		 = 0;
		newStartMedium		 = 0;
		newStartLarge		 = 0;
		jobArray		     = new int[100];
		
		/****** INPUT SECTION ******/
		System.out.println("Please pick from 3 options.");
		System.out.println("      A: 3 Printers");
		System.out.println("      B: 2 Printers");
		System.out.println("      C: 1 Printers");
		System.out.print("Enter here: ");
		String temp = keyboard.nextLine();
		choice = temp.charAt(0);
		keyboard.close();
		
		for(int i = 0; i < 100; i++)
		{			
			randomNumber = (int )(Math.random() * 50 + 1);
			jobArray[i] = randomNumber;
		}
		
		/******* PROCESSING SECTION ********/
		if(choice == 'A')
		{
			System.out.println("PRINT JOB ORDER RECEIVED:\n");
			
		
			for(int i = 0; i < jobArray.length; i++)
			{
				printToAdd = jobArray[i];		
				
				if(printToAdd > small.getLowerBound() && printToAdd <= small.getUpperBound())
				{
					tempJob       = new PrintJob(printToAdd, newStartSmall);
					small.addToQueue(tempJob);
					newStartSmall = tempJob.getEndTime();
					endTimes.add(tempJob.getEndTime());
					System.out.println(tempJob);
									
				}
				else if(printToAdd > medium.getLowerBound() && printToAdd <= medium.getUpperBound())
				{
					tempJob        = new PrintJob(printToAdd, newStartMedium);
					medium.addToQueue(tempJob);
					newStartMedium = tempJob.getEndTime();
					endTimes.add(tempJob.getEndTime());
					System.out.println(tempJob);
					
				}
				else if(printToAdd > large.getLowerBound() && printToAdd <= large.getUpperBound())
				{
					tempJob       = new PrintJob(printToAdd, newStartLarge);
					large.addToQueue(tempJob);
					newStartLarge = tempJob.getEndTime();
					endTimes.add(tempJob.getEndTime());
					System.out.println(tempJob);
				}
				
			}
			
			
			endTimes = bubbleSort(endTimes);
			
		
			System.out.println("ORDER COMPLETED:\n");
			for(int i= 0; i < endTimes.size(); i++)
			{
				Printer.setCurrentTime(endTimes.get(i));
				if(!small.queueEmpty())
				{
					if(small.checkQueue().getEndTime() == Printer.getCurrentTime())
					{
						System.out.println("Printed on: " + small.getName());
						System.out.println(small.removeQueue());
						
					}
				}
				if(!medium.queueEmpty())
				{
					if(medium.checkQueue().getEndTime() == Printer.getCurrentTime())
					{
						System.out.println("Printed on: " + medium.getName());
						System.out.println(medium.removeQueue());
						
					}
				}
				if(!large.queueEmpty())
				{
					if(large.checkQueue().getEndTime() == Printer.getCurrentTime())
					{
						System.out.println("Printed on: " + large.getName());
						System.out.println(large.removeQueue());
						
					}
				}
			}
			
			System.out.println("\nELAPSED TIME: " + Printer.getCurrentTime() + " minutes");
		}
		else if (choice == 'B')
		{
			System.out.println("PRINT JOB ORDER RECEIVED:\n");
			for(int i = 0; i < jobArray.length; i++)
			{
				printToAdd = jobArray[i];
				
				if(printToAdd > smallHalf.getLowerBound() && printToAdd <= smallHalf.getUpperBound())
				{
					tempJob = new PrintJob(printToAdd, newStartSmall);
					smallHalf.addToQueue(tempJob);
					newStartSmall = tempJob.getEndTime();
					endTimes.add(tempJob.getEndTime());
					System.out.println(tempJob);
				}
				else
				{
					tempJob = new PrintJob(printToAdd, newStartSmall);
					largeHalf.addToQueue(tempJob);
					newStartLarge = tempJob.getEndTime();
					endTimes.add(tempJob.getEndTime());
					System.out.println(tempJob);
				}
			}
			
			
			endTimes = bubbleSort(endTimes);
			
			
			
			System.out.println("ORDER COMPLETED:\n");
			for(int i= 0; i < endTimes.size(); i++)
			{
				Printer.setCurrentTime(endTimes.get(i));
				if(!smallHalf.queueEmpty())
				{
					if(smallHalf.checkQueue().getEndTime() == Printer.getCurrentTime())
					{
						System.out.println("Printed on: " + smallHalf.getName());
						System.out.println(smallHalf.removeQueue());
						
					}
				}
				if(!largeHalf.queueEmpty())
				{
					if(largeHalf.checkQueue().getEndTime() == Printer.getCurrentTime())
					{
						System.out.println("Printed on: " + largeHalf.getName());
						System.out.println(largeHalf.removeQueue());
						
					}
				}
			}
			
			System.out.println("\nELAPSED TIME: " + Printer.getCurrentTime() + " minutes");
		
		}
		else
		{
			System.out.println("PRINT JOB ORDER RECEIVED:\n");
			for(int i = 0; i < jobArray.length; i++)
			{
				printToAdd = jobArray[i];
				tempJob = new PrintJob(printToAdd, newStart);
				newStart = tempJob.getEndTime();
				superPrinter.addToQueue(tempJob);
				endTimes.add(tempJob.getEndTime());
				System.out.println(tempJob);
			}
			
			
			endTimes = bubbleSort(endTimes);
			
			System.out.println("ORDER COMPLETED:\n");
			for(int i= 0; i < endTimes.size(); i++)
			{
				Printer.setCurrentTime(endTimes.get(i));
				if(!superPrinter.queueEmpty())
				{
					if(superPrinter.checkQueue().getEndTime() == Printer.getCurrentTime())
					{
						System.out.println("Printed on: " + superPrinter.getName());
						System.out.println(superPrinter.removeQueue());
						
					}
				}
			}
			
			System.out.println("\nELAPSED TIME: " + Printer.getCurrentTime() + " minutes");
		}
		
	}
	/***
	 * sorts arraylist using bubble sort
	 * @param numbers
	 * @return sorted array of integers
	 */
	public static ArrayList<Integer> bubbleSort(ArrayList<Integer> numbers) 
	{ 
	     Collections.sort(numbers);
	     return numbers;
	}
}
