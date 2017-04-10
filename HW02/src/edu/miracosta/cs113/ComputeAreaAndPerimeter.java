package edu.miracosta.cs113;

import java.util.Scanner;

import classPackage.Circle;
import classPackage.Rectangle;
import classPackage.RtTriangle;
import classPackage.Shape;
/**
	Computes the are and perimeter of selcted figures.
	@author Koffman and WolfGang
	Upgraded by: Matthew Gilli
*/
/********************************************
* AUTHOR: Matthew Gilli
* COURSE: CS 113
* SECTION: MW 15:30-17:20
* HOMEWORK #: 01
* PROJECT #: Project 01
* LAST MODIFIED: 2017-01-29
********************************************/
/*****************************************************************************
* ComputeAreaAndPerimeter
*****************************************************************************
* PROGRAM DESCRIPTION:
* This program computes the perimeter and area for any shape asked for
*****************************************************************************
* ALGORITHM:
* 1.BEGIN
* 2.	ASSIGN myShape
* 3.	CALC   myShape.readShapeData()
* 4.	CALC   perimeter
* 5.	CALC   area
* 6.	CALC   displayResult()
* 7. END
*****************************************************************************
* ALL IMPORTED PACKAGES NEEDED AND PURPOSE:
* Scanner= used for console input
*****************************************************************************/
public class ComputeAreaAndPerimeter
{
	/** The main program performs the following steps.
	    1. It asks the user for the type of figure.
	    2. It asks the user for the characteristics of that figure.
	    3. It computes the perimeter.
	    4. It computes the area.
	    5. It displays the result.
	    @param args The command line arguments -- not used 
	    */
	    
	    public static void main(String[] args)
	    {
			Shape myShape;
			double perimeter;
			double area;
			
			myShape = getShape();     // Ask for figureType
			myShape.readShapeData();  // Read the shape data
			perimeter = myShape.computePerimeter();
			area      = myShape.computeArea();
			displayResult(myShape, area, perimeter);
			System.exit(0);
		}
		
		public static Shape getShape()
		{
			Scanner in = new Scanner(System.in);
			System.out.println("Enter C for Circle");
			System.out.println("Enter R for Rectangle");
			System.out.println("Enter T for Right Triangle");
			System.out.println("Enter E for Equilateral Triangle");
			System.out.println("Enter S for Square");
			String figType = in.next();
			in.close();
			if(figType.equalsIgnoreCase("c"))
			{
				return new Circle();
			}
			else if (figType.equalsIgnoreCase("r"))
			{
				return new Rectangle();
			}
			else if (figType.equalsIgnoreCase("t"))
			{
				return new RtTriangle();
			}
			else if (figType.equalsIgnoreCase("e"))
			{
				return new EquilateralTriangle();
			}
			else if (figType.equalsIgnoreCase("s"))
			{
				return new Square();
			}
			else
			{
				return null;
			}
		}
		
		/** Display the result of the computation.
		    @param area The area of the figure
		    @param perim The perimenter of the figure
		*/
		private static void displayResult(Shape myShape, double area,
										  double perim)
		{
			System.out.println(myShape);
			System.out.printf("The are is %.2f%nThe perimeter is %.2f%n",
							  area, perim);
		}
}
