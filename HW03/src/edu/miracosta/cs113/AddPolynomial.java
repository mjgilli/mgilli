package edu.miracosta.cs113;

/********************************************
* AUTHOR: Matthew Gilli
* COURSE: CS 113
* SECTION: MW 3:30-5:20
* HOMEWORK #: 03
* PROJECT #:  01
* LAST MODIFIED: 2017-02-12
********************************************/
/*****************************************************************************
* AddPolynomial
*****************************************************************************
* PROGRAM DESCRIPTION:
* Adds two polynomials together
*****************************************************************************
* ALGORITHM:
* 1. BEGIN
* 2.  ASSIGN polyOne
* 3.  ASSIGN polyTwo
* 4.  ASSIGN addedPoly
* 5.  CALC polyOne.add
* 6.  CALC polyOne.add
* 7.  CALC polyOne.add
* 8.  CALC polyOne.add
* 8.  CALC polyTwo.add
* 8.  CALC polyTwo.add
* 8.  CALC polyTwo.add
* 9.  ASSIGN lowestExponent
* 10. ASSign polyOneCounter
* 11. ASSIGM polyTwoCounter
* 12. ASSIGN polynomial
* 13. WHILE(polyOneCounter != polyOne.size() && polyTwoCounter != polyTwo.size())
* 14.	ASSIGN termOne
* 15.	ASSIGN termTwo
* 16.	IF(termOne.compareTo(termTwo) == EQUAL)
* 17.		CALC newCoefficient
* 18.		CALC newTerm
* 19.		CALC addedPoly.add
* 20.		CALC polyOneCounter++
* 21.		CALC polyTwoCounter++
* 22.	ELSE IF(termOne.compareTo(termTwo) == AFTER)
* 23.		CALC addedPoly.add
* 24.		CALC polyOneCounter++
* 25.	ELSE 
* 26.		CALC addedPoly.add
* 27.		CALC polyTwoCounter++
* 28.	END IF
* 29. END WHILE
* 30. FOR (int i = 0 to addedPoly.size)
* 31.	CALC polyTerm
* 32.	IF(polyTerm.getExponent() != lowestExponent)
* 33.		CALC polynomial
* 34.	ELSE 
* 35.		CALC polynomial
* 36.	END IF
* 37. OUTPUT polynomial
* 16. END
*****************************************************************************
* ALL IMPORTED PACKAGES NEEDED AND PURPOSE:
* ArrayList for list
*****************************************************************************/
import java.util.ArrayList;
public class AddPolynomial
{
	/***** CONSTANTS SECTION *****/	
	public static final int BEFORE = -1;
	public static final int EQUAL  = 0;
	public static final int AFTER  = 1;
	
	public static void main(String[] args)
	{
		/***** DECLARATION SECTION *****/
		ArrayList<Term> polyOne;
		ArrayList<Term> polyTwo;
		ArrayList<Term> addedPoly;
		int             lowestExponent; 
		int				polyOneCounter;
		int				polyTwoCounter;
		String          polynomial;		
		
		/***** INITIALIZATION SECTION *****/
		polyOne   = new ArrayList<Term>();
		polyTwo   = new ArrayList<Term>();
		addedPoly = new ArrayList<Term>();
		
		polyOne.add(new Term(3,4));
		polyOne.add(new Term(2,2));
		polyOne.add(new Term(3,1));
		polyOne.add(new Term(7,0));
		
		polyTwo.add(new Term(2,3));
		polyTwo.add(new Term(4,1));
		polyTwo.add(new Term(5,0));
		
		lowestExponent = 0;
		
		polyOneCounter = 0;
		polyTwoCounter = 0;	
		
		polynomial = "";
		
		/****** INPUT SECTION ******/
		
		
		/***** PROCESSING SECTION *****/
		
		while(polyOneCounter != polyOne.size() && polyTwoCounter != polyTwo.size())
		{
			Term termOne = null;
			Term termTwo = null;
			Term newTerm;
			int  newCoefficient;
			
			termOne = polyOne.get(polyOneCounter);
			termTwo = polyTwo.get(polyTwoCounter);
			
			if(termOne.compareTo(termTwo) == EQUAL)
			{
				newCoefficient = termOne.getCoefficient() + termTwo.getCoefficient();
				newTerm = new Term(newCoefficient, termOne.getExponent());
				addedPoly.add(newTerm);
				polyOneCounter++;
				polyTwoCounter++;
			}
			else if(termOne.compareTo(termTwo) == AFTER)
			{
				addedPoly.add(termOne);
				polyOneCounter++;
			}
			else 
			{
				addedPoly.add(termTwo);
				polyTwoCounter++;
			}
		}
			
		/***** OUTPUT SECTION *****/
		for(int i = 0; i < addedPoly.size() ; i++)
		{ 
			Term polyTerm;
			
			polyTerm = addedPoly.get(i);
			if(polyTerm.getExponent() != lowestExponent)
			{
				polynomial += polyTerm + "+";
			}
			else
			{
				polynomial += polyTerm;
			}
		}
		System.out.println(polynomial);	
	}
}
