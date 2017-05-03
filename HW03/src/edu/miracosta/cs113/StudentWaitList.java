package edu.miracosta.cs113;

/********************************************
* AUTHOR: Matthew Gilli
* COURSE: CS 113
* SECTION: MW 3:30-5:20
* HOMEWORK #: 03
* PROJECT #:  02
* LAST MODIFIED: 2017-02-12
********************************************/
/*****************************************************************************
* StudentWaitList
*****************************************************************************
* PROGRAM DESCRIPTION:
* program manages a wait list of students wanting to enter
* class
* Objective:
* add to beginning
* add to end
* removes front
* removes end
*****************************************************************************
* ALGORITHM:
* 1. BEGIN
* 2. 	ASSIGN waitList
* 3.	CALC waitList.add
* 4.	CALC waitList.add
* 5.	CALC waitList.add
* 6.	OUTPUT waitList
* 7.	CALC waitList.add
* 8.	OUTPUT waitList
* 9.	CALC waitList.removeFirst
* 10.	OUTPUT waitList
* 11.	CALC waitList.removeLast
* 12.	OUTPUT waitList
* 13. END
*****************************************************************************
* ALL IMPORTED PACKAGES NEEDED AND PURPOSE:
* ArrayList for list
*****************************************************************************/
public class StudentWaitList
{
	public static void main(String[] args)
	{
		/***** DECLARATION SECTION *****/
		SingleLinkedList<String> waitList;
		
		/***** INITIALIZATION SECTION *****/
		waitList = new SingleLinkedList<String>();
	
		
		/****** INPUT SECTION ******/
		
		
		/***** PROCESSING SECTION *****/
		//add student to beginning of list
		waitList.add("Matthew");
		waitList.add("John");
		waitList.add("Michael");
		System.out.println(waitList);
		
		//add student to end of list
		waitList.add(0, "Alex");
		System.out.println(waitList);
		
		//remove student at front
		waitList.removeFirst();
		System.out.println(waitList);
		
		//remove student from end of list
		waitList.removeLast();
		System.out.println(waitList);
		
		/***** OUTPUT SECTION *****/
		
	}
}
