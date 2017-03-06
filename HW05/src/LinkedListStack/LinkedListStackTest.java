package LinkedListStack;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListStackTest
{
	@Test
	public void testEmpty()
	{
		LinkedListStack<Integer> testStack = new LinkedListStack<Integer>();
		Assert.assertTrue(testStack.empty() == true);
		testStack.push(1);
		Assert.assertTrue(testStack.empty() == false);
		testStack = new LinkedListStack<Integer>();
		testStack.push(-1);
		Assert.assertTrue(testStack.empty() == false);
		testStack = new LinkedListStack<Integer>();
		testStack.push(0);
		Assert.assertTrue(testStack.empty() == false);
		
	}
	
	@Test
	public void testEmpty1()
	{
		LinkedListStack<String> testStack = new LinkedListStack<String>();
		Assert.assertTrue(testStack.empty() == true);
		testStack.push(null);
		Assert.assertTrue(testStack.empty() == false);
		testStack = new LinkedListStack<String>();
		testStack.push("");
		Assert.assertTrue(testStack.empty() == false);
		testStack = new LinkedListStack<String>();
		testStack.push("a");
		Assert.assertTrue(testStack.empty() == false);
	}
	
	@Test
	public void testEmpty2()
	{
		LinkedListStack<Double> testStack = new LinkedListStack<Double>();
		Assert.assertTrue(testStack.empty() == true);
		testStack.push(0.0);
		Assert.assertTrue(testStack.empty() == false);
		testStack = new LinkedListStack<Double>();
		testStack.push(-1.0);
		Assert.assertTrue(testStack.empty() == false);
		testStack = new LinkedListStack<Double>();
		testStack.push(1.0);
		Assert.assertTrue(testStack.empty() == false);
	}
	
	@Test
	public void testEmpty3()
	{
		LinkedListStack<Character> testStack = new LinkedListStack<Character>();
		Assert.assertTrue(testStack.empty() == true);
		testStack.push('a');
		Assert.assertTrue(testStack.empty() == false);
		testStack = new LinkedListStack<Character>();
		testStack.push('\n');
		Assert.assertTrue(testStack.empty() == false);
		testStack = new LinkedListStack<Character>();
		testStack.push('8');
		Assert.assertTrue(testStack.empty() == false);
	}
	
	@Test
	public void testPeek()
	{
		LinkedListStack<Integer> testStack = new LinkedListStack<Integer>();
		testStack.push(1);
		Assert.assertTrue(testStack.peek() == 1);
		testStack = new LinkedListStack<Integer>();
		testStack.push(-1);
		Assert.assertTrue(testStack.peek() == -1);
		testStack = new LinkedListStack<Integer>();
		testStack.push(0);
		Assert.assertTrue(testStack.peek() == 0);
		
	}
	
	@Test
	public void testPeek1()
	{
		LinkedListStack<String> testStack = new LinkedListStack<String>();
		testStack.push(null);
		Assert.assertTrue(testStack.peek() == null);
		testStack = new LinkedListStack<String>();
		testStack.push("");
		Assert.assertTrue(testStack.peek().equals(""));
		testStack = new LinkedListStack<String>();
		testStack.push("a");
		Assert.assertTrue(testStack.peek().equals("a"));
	}
	
	@Test
	public void testPeek2()
	{
		LinkedListStack<Double> testStack = new LinkedListStack<Double>();
		testStack.push(0.0);
		Assert.assertTrue(testStack.peek() == 0.0);
		testStack = new LinkedListStack<Double>();
		testStack.push(-1.0);
		Assert.assertTrue(testStack.peek() == -1.0);
		testStack = new LinkedListStack<Double>();
		testStack.push(1.0);
		Assert.assertTrue(testStack.peek() == 1.0);
	}
	
	@Test
	public void testPeek3()
	{
		LinkedListStack<Character> testStack = new LinkedListStack<Character>();
		testStack.push('a');
		Assert.assertTrue(testStack.peek() == 'a');
		testStack = new LinkedListStack<Character>();
		testStack.push('\n');
		Assert.assertTrue(testStack.peek() == '\n');
		testStack = new LinkedListStack<Character>();
		testStack.push('8');
		Assert.assertTrue(testStack.peek() == '8');
	}
	
	/**
	@Test
	public void testPop()
	{
		LinkedListStack<Integer> testStack = new LinkedListStack<Integer>();
		testStack.push(1);
		testStack.pop();
		Assert.assertTrue(testStack.empty() == true);
		testStack = new LinkedListStack<Integer>();
		testStack.push(-1);
		testStack.pop();
		Assert.assertTrue(testStack.empty() == true);
		testStack = new LinkedListStack<Integer>();
		testStack.push(0);
		testStack.pop();
		Assert.assertTrue(testStack.empty() == true);
		
	}
	
	@Test
	public void testPop1()
	{
		LinkedListStack<String> testStack = new LinkedListStack<String>();
		testStack.push(null);
		testStack.pop();
		Assert.assertTrue(testStack.empty() == true);
		testStack = new LinkedListStack<String>();
		testStack.push("");
		testStack.pop();
		Assert.assertTrue(testStack.empty() == true);
		testStack = new LinkedListStack<String>();
		testStack.push("a");
		testStack.pop();
		Assert.assertTrue(testStack.empty() == true);
	}
	
	@Test
	public void testPop2()
	{
		LinkedListStack<Double> testStack = new LinkedListStack<Double>();
		testStack.push(0.0);
		testStack.pop();
		Assert.assertTrue(testStack.empty() == true);
		testStack = new LinkedListStack<Double>();
		testStack.push(-1.0);
		testStack.pop();
		Assert.assertTrue(testStack.empty() == true);
		testStack = new LinkedListStack<Double>();
		testStack.push(1.0);
		testStack.pop();
		Assert.assertTrue(testStack.empty() == true);
	}
	
	@Test
	public void testPop3()
	{
		LinkedListStack<Character> testStack = new LinkedListStack<Character>();
		testStack.push('a');
		testStack.pop();
		Assert.assertTrue(testStack.empty() == true);
		testStack = new LinkedListStack<Character>();
		testStack.push('\n');
		testStack.pop();
		Assert.assertTrue(testStack.empty() == true);
		testStack = new LinkedListStack<Character>();
		testStack.push('8');
		testStack.pop();
		Assert.assertTrue(testStack.empty() == true);
	}
	**/
	

	@Test
	public void testPush()
	{
		LinkedListStack<Integer> testStack = new LinkedListStack<Integer>();
		Assert.assertTrue(testStack.push(1) == 1);
		testStack = new LinkedListStack<Integer>();
		Assert.assertTrue(testStack.push(-1) == -1);
		testStack = new LinkedListStack<Integer>();
		Assert.assertTrue(testStack.push(0) == 0);
		
	}
	
	@Test
	public void testPush1()
	{
		LinkedListStack<String> testStack = new LinkedListStack<String>();
		testStack.push(null);
		Assert.assertTrue(testStack.push(null) == null);
		testStack = new LinkedListStack<String>();
		Assert.assertTrue(testStack.push("").equals(""));
		testStack = new LinkedListStack<String>();
		Assert.assertTrue(testStack.push("a").equals("a"));
	}
	
	@Test
	public void testPush2()
	{
		LinkedListStack<Double> testStack = new LinkedListStack<Double>();
		Assert.assertTrue(testStack.push(0.0) == 0.0);
		testStack = new LinkedListStack<Double>();
		Assert.assertTrue(testStack.push(-1.0) == -1.0);
		testStack = new LinkedListStack<Double>();
		Assert.assertTrue(testStack.push(1.0) == 1.0);
	}
	
	@Test
	public void testPush3()
	{
		LinkedListStack<Character> testStack = new LinkedListStack<Character>();
		Assert.assertTrue(testStack.push('a') == 'a');
		testStack = new LinkedListStack<Character>();
		Assert.assertTrue(testStack.push('\n') == '\n');
		testStack = new LinkedListStack<Character>();
		Assert.assertTrue(testStack.push('8') == '8');
	}	
}
