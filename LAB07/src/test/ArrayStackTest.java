package test;

import edu.miracosta.cs113.ArrayStack;

public class ArrayStackTest 
{

	public static void main(String[] args) 
	{
		ArrayStack<Integer> testStack;
		testStack = new ArrayStack<Integer>();
		
		//test empty
		if(testStack.empty())
		{
			System.out.println("the ArrayStack is empty");
		}
		
		//test push
		testStack.push(2);
		//test peek
		System.out.println("number should be 2, it is: " + testStack.peek());
		
		//test pop
		testStack.push(4);
		System.out.println("number should be 4, it is: " + testStack.peek());
		System.out.println("number popped off should be 4, it is: " + testStack.pop());
		System.out.println("number should be 2, it is: " + testStack.peek());
		
		

	}

}
