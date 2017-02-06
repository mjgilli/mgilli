import static java.lang.Math.sqrt;
import java.util.Scanner;
public class EquilateralTriangle extends Shape
{
	private double side;
	
	
	public EquilateralTriangle()
	{
		super("Equilateral Triangle");
		this.side = 0;
	}
	
	public EquilateralTriangle(double side)
	{
		super("Equilateral Triangle");
		this.side = side;
	}
	
	public double getSide()
	{
		return side;
	}
	
	
	public double computeArea()
	{
		double height;
		
		height = Math.sqrt((side*side) - ((0.5*side) * (0.5*side)));
		return 0.5 * (0.5*side) * height;
	}
	
	public double computePerimeter()
	{
		return 3*side;
	}
	
	public void readShapeData()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the side of the Equilateral Triangle");
		side = in.nextDouble();
	}
	
	public String toString()
	{
		return super.toString() + ": side is " + side;
	}
}
