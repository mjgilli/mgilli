package edu.miracosta.cs113;

import java.util.LinkedList;
import java.util.Queue;

public class Printer
{
	/******** INSTANCE VARIBALES ********/
	private String name;
	private Queue<PrintJob> jobs;
	private static int currentTime;
	private int lowerBound;
	private int upperBound;
	
	
	/******* CONSTRUCTORS ********/
	public Printer(String name,int lowerBound,int upperBound)
	{
		this.setName(name);
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		jobs  = new LinkedList<PrintJob>();
	}
	
	/******** MUTATOR METHODS *********/
	
	/** change lower bound of printer
		@param lower bound of printer
	 */
	public void setLowerBound(int lower)
	{
		lowerBound = lower;
	}
	
	
	/** change upper bound of printer
		@param upper bound of printer
	 */
	public void setUpperBound(int upper)
	{
		upperBound = upper;
	}
	
	/** set current time belonging to all printers
		@param time tochange
	 */
	public static void setCurrentTime(int newTime)
	{
		currentTime = newTime;
	}
	
	/** adds job to queue
		@param job added to printer
		@return boolean if has been added to queue
	 */
	public boolean addToQueue(PrintJob jobToAdd)
	{
		return jobs.offer(jobToAdd);
	}
	
	/** removes first object from queue
		@return PrintJob that was removed
	 */
	public PrintJob removeQueue()
	{
		return jobs.poll();
	}
	/** checks first element of queue
		@return PrintJob that was checked
	 */
	public PrintJob checkQueue()
	{
		return jobs.element();
	}
	
	/** checks if queue is empty
	 * @return boolean if empty
	 */
	public boolean queueEmpty()
	{
		return jobs.isEmpty();
	}
	/******* ACCESSOR METHODS *********/
	
	/** gets lower bound of printer
	 * 
	 * @return int representing lower bound
	 */
	public int getLowerBound()
	{
		return lowerBound;
	}
	
	/** gets upper bound of printer
	 * 
	 * @return int representing upper boundof printer
	 */
	public int getUpperBound()
	{
		return upperBound;
	}
	
	/** gets current time representing all printers
	 * 
	 * @return int representing all time
	 */
	public static int getCurrentTime()
	{
		return currentTime;
	}

	/** gets name ofPrinter
	 * 
	 * @return name of printer
	 */
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
}
