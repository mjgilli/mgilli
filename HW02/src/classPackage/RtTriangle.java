import static java.lang.Math.sqrt;
import java.util.Scanner;
public class RtTriangle extends Shape
{
	private double base;
	private double height;
	
	public RtTriangle()
	{
		super("Right Triangle");
		base = 0;
		height = 0;
	}
	
	public RtTriangle( double base, double height)
	{
		super("Right Triangle");
		this.base = base;
		this.height = height;
	}
	
	public double getBase()
	{
		return base;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	public double computeArea()
	{
		return 0.5 * base * height;
	}
	
	public double computePerimeter()
	{
		double c;
		
		c = Math.sqrt((base*base) + (height * height));
		return c + base + height;
	}
	
	public void readShapeData()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the base of the Right Triangle");
		base = in.nextDouble();
		System.out.println("Enter the height of the Right Triangle");
		height = in.nextDouble();
	}
	
	public String toString()
	{
		return super.toString() + ": base is " + base
			   + ", height is " + height;
	}
}
