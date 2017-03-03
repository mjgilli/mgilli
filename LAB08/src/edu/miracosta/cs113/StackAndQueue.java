package edu.miracosta.cs113;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
public class StackAndQueue 
{
	public static void main(String[] args)
	{
		Queue<Integer> numberQueue  = new LinkedList<Integer>();
		Stack<Integer> numberStack1 = new Stack<Integer>();
		Stack<Integer> numberStack2 = new Stack<Integer>();
		
		// add numbers to first stack
		numberStack1.push(-1);
		numberStack1.push(15);
		numberStack1.push(23);
		numberStack1.push(44);
		numberStack1.push(4);
		numberStack1.push(99);
		
		System.out.println(numberStack1.peek() + " is the top of the stack.");
		
		// remove and put in stack2 and queue
		while(!numberStack1.isEmpty())
		{
			numberStack2.push(numberStack1.peek());
			System.out.println("the number added to stack2 is " + numberStack2.peek());
			
			//figure out how to print each
			if(numberQueue.offer(numberStack1.pop()))
			{
				System.out.println("number added to queue is same as stack2");
			}

		}
		
		//output numbers in each stack
		System.out.println("\n\nThe numbers in the data structures are output in this order");
		System.out.printf("%10s", "Stack");
		System.out.printf("%10s", "Queue");
		System.out.println("\n----------------------");
		while(!numberStack2.isEmpty() && !numberQueue.isEmpty())
		{
			System.out.printf("%10d", numberStack2.pop());
			System.out.printf("%10d", numberQueue.poll());
			System.out.println();
		}
	}
}
