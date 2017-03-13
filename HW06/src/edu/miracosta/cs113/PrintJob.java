package edu.miracosta.cs113;

public class PrintJob
{
	/******** INSTANCE VARIBALES ********/
	private int numPages;
	private int startTime;
	private int endTime;
	
	/******* CONSTRUCTORS ********/
	public PrintJob()
	{
		
	}
	
	public PrintJob(int numPages, int startTime)
	{
		this.numPages = numPages;
		this.startTime = startTime;
		findEndTime();
	}
	
	/******** MUTATOR METHODS *********/
	/** sets number of pages that will be printed
	 * 
	 * @param numPages
	 */
	public void setNumPages(int numPages)
	{
		this.numPages = numPages;
	}
	
	/** sets start time of print job
	 * 
	 * @param startTime
	 */
	public void setStartTime(int startTime)
	{
		this.startTime = startTime;
	}
	
	/** sets end time of print job
	 * 
	 * @param endTime
	 */
	public void setEndTime(int endTime)
	{
		this.endTime = endTime;
	}
	
	/** 
	 *  finds end time of print job and then sets it
	 */
	public void findEndTime()
	{
		setEndTime(getStartTime() + printTime());
	}
	/******* ACCESSOR METHODS *********/
	
	/** gets number of pages of print job
	 * 
	 * @return int representing number of pages
	 */
	public int getNumPages()
	{
		return numPages;
	}
	
	/** gets start time of print job
	 * 
	 * @return int representing start time
	 */
	public int getStartTime()
	{
		return startTime;
	}
	
	/** gets end time of print job
	 * 
	 * @return int representing end time
	 */
	public int getEndTime()
	{
		return endTime;
	}
	/******* OTHER REQUIRED ***********/
	
	/** calculates how long print will take
	 * 
	 * @return total amount of print time
	 */
	public int printTime()
	{
		return (this.numPages/10) + 1;
	}
	
	/** checks if other PrintJob is equal to another object by checking if same instance
	 * or checks variables
	 * @param other
	 * @return boolean representing if equal
	 */
	public boolean equals(Object other)
	{
		PrintJob otherJob;
		if(other == null)
		{
			return false;
		}
		else if(! (other instanceof PrintJob))
		{
			return false;
		}
		else
		{
			otherJob = (PrintJob) other;
			return this.numPages == otherJob.numPages 
					&& this.startTime == otherJob.startTime 
					&& this.endTime == otherJob.endTime;
		}
	}
	
	/** String representation of object
	 * @return string 
	 */
	public String toString()
	{
		return "This print job of " + getNumPages() + " pages starts at minute: " 
				+ getStartTime() + " and ends at minute: " + getEndTime();
	}
}
