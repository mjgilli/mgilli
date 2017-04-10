package classPackage;

import java.util.Scanner;
public class Circle extends Shape
{
	private double radius;
	
	public Circle()
	{
		super("Circle");
		radius = 0;
	}
	
	public Circle(double radius)
	{
		super("Circle");
		this.radius = radius;
	}
	
	public double getRadius()
	{
		return this.radius;
	}
	
	public double computeArea()
	{
		return 3.14 * (radius * radius);
	}
	
	public double computePerimeter()
	{
		return 3.14 *(2*radius);
	}
	
	public void readShapeData()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the radius of the Circle");
		radius = in.nextDouble();
		in.close();
	}
	
	public String toString()
	{
		return super.toString() + ": radius is " + radius;
	}
}
