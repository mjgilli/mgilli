package shapeTester;
import java.util.Scanner;

import classPackage.Shape;
public class Square extends Shape
{
	private double side;
	
	public Square()
	{
		super("Square");
	}
	
	public Square(double side)
	{
		super("Square");
		this.side = side;
	}
	
	public double getSide()
	{
		return side;
	}
	
	public double computeArea()
	{
		return side * side;
	}
	
	public double computePerimeter()
	{
		return 4 * (side);
	}
	
	public void readShapeData()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the side of the Square");
		side = in.nextDouble();
		in.close();
	}
	
	public String toString()
	{
		return super.toString() + ": side is " + side;
	}
}
