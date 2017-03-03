package edu.miracosta.cs113;
import java.util.ArrayList;
import java.util.EmptyStackException;
public class ArrayStack<T> implements StackInterface<T>
{
	ArrayList<T> theData;
	
	/** 
	   constructor for array stack
	*/
	public ArrayStack()
	{
		theData = new ArrayList<T>();
	}
	
	/** returns true or false if stack is empty
	    @returns boolean if empty
	*/
	public boolean empty()
	{
		return theData.isEmpty();
	}
	
	/** returns object at top of stack
		@return Object at top of stack
	*/
	public T peek()
	{
		return theData.get(theData.size() - 1);
	}
	
	/** removes and returns item at top of stack
		@throws EmptyStackException
		@return Object removed
	*/
	public T pop()
	{
		if(empty())
		{
			throw new EmptyStackException();
		}
		return theData.remove(theData.size() - 1);
	}
	
	/** Adds element to top of stack
    	@param Object to be added to stack
    	@return Object to be added
	*/
	public T push(T object)
	{
		theData.add(object);
		return object;
	}
}
