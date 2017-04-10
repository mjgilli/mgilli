package classPackage;

import java.util.Scanner;
public class Rectangle extends Shape
{
	private double width;
	private double height;
	
	public Rectangle()
	{
		super("Rectangle");
	}
	
	public Rectangle(double width, double height)
	{
		super("Rectangle");
		this.width = width;
		this.height = height;
	}
	
	public double getWidth()
	{
		return width;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	public double computeArea()
	{
		return height * width;
	}
	
	public double computePerimeter()
	{
		return 2 * (height + width);
	}
	
	public void readShapeData()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the width of the Rectangle");
		width = in.nextDouble();
		System.out.println("Enter the height of the Rectangle");
		height = in.nextDouble();
		in.close();
	}
	
	public String toString()
	{
		return super.toString() + ": width is " + width
			   + ", height is " + height;
	}
}
