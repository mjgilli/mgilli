package edu.miracosta.cs113;

public class Term implements Comparable
{
	/********** CONSTANTS *******************/
	public static final int DEFAULT_COEFFICIENT = 0;
	public static final int DEFAULT_EXPONENT    = 0;
	public static final int BEFORE = -1;
	public static final int EQUAL  = 0;
	public static final int AFTER  = 1;
	
	
	/********** INSTANCE VARIABLES **********/
	private int coefficient;
	private int exponent;
	
	/********** CONSTRUCTORS **********/
	// DESCRIPTION:		Default constructor sets Term object to 
	//					default values
	// PRE-CONDITION:	N/A
	// POST-CONDITION:	Sets instance variables to default values.
	public Term()
	{
		this.setAll(DEFAULT_COEFFICIENT, DEFAULT_EXPONENT);
	}
	
	// DESCRIPTION:		Full constructor sets Term object to parameter value
	// PRE-CONDITION:	N/A
	// POST-CONDITION:	Sets instance variables to parameter value
	public Term(int coefficient, int exponent)
	{
		this.setAll(coefficient, exponent);
	}
	
	/***** MUTATOR METHODS (setters) *****/
	
	// DESCRIPTION:   Sets coefficient value of term
	// PRECONDITION:  Assumes coefficient is valid
	// POSTCONDITION: Sets instance variable to parameter value
	public void setCoefficient(int coefficient)
	{
		this.coefficient = coefficient;
	}
	
	// DESCRIPTION:   Sets value of exponent in term
	// PRECONDITION:  Assumes exponent value is valid
	// POSTCONDITION: Sets instance variable to parameter value
	public void setExponent(int exponent)
	{
		this.exponent = exponent;
	}
	
	// DESCRIPTION:   Sets both coefficient and exponent value of term
	// PRECONDITION:  Assumes values are valid
	// POSTCONDITION: Sets instance variable to parameter value
	public void setAll(int coefficient, int exponent)
	{
		this.setCoefficient(coefficient);
		this.setExponent(exponent);
	}
	
	
	/***** ACCESSOR METHODS (getters) *****/
	// DESCRIPTION:   Gets coefficient value of term
	// PRECONDITION:  coefficient variable has valid values
	// POSTCONDITION: Returns integer called coefficient
	public int getCoefficient()
	{
		return this.coefficient;
	}
	
	// DESCRIPTION:   Gets exponent value of term
	// PRECONDITION:  exponent variable has valid values
	// POSTCONDITION: Returns integer called exponent
	public int getExponent()
	{
		return this.exponent;
	}
	
	/******** OTHER REQUIRED ********/
	
	// DESCRIPTION:   Converts object to String representation
	// PRECONDITION:  All instance variables have valid values
	// POSTCONDITION: Returns String containing all instance variables
	public String toString()
	{
		String term;
		if(this.exponent == 0 & this.coefficient == 0)
		{
			term = "";
		} 
		else if(this.exponent == 0)
		{
			term = Integer.toString(this.coefficient);
		}
		else if (this.exponent == 1)
		{
			term = this.coefficient + "x";
		}
		else 
		{
			term = this.coefficient + "x^" + this.exponent;
		}
		return term;
	}
	
	// DESCRIPTION:		Returns boolean is "this" Term is 
	//					equal to parameter
	// PRE-CONDITION:	Instance variables have valid values for both
	//				    Term objects
	// POST-CONDITION:	Returns true if both are exactly the same, 
	//					false otherwise.
	public boolean equals(Object other)
	{
		Term otherTerm;
		
		if(other == null)
		{
			return false;
		}
		else if(! (other instanceof Term))
		{
			return false;
		}
		else
		{
			otherTerm = (Term) other;
			return this.exponent == otherTerm.coefficient;
		}
	}
	
	
	public int compareTo(Object other)
	{
		Term otherTerm;
		
		otherTerm = (Term) other;
		if(this.exponent == otherTerm.exponent)
		{
			return EQUAL;
		}
		else if (this.exponent > otherTerm.exponent)
		{
			return AFTER;
		}
		else
		{
			return BEFORE;
		}
	}
}
