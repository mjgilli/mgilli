package LinkedListStack;

import java.util.EmptyStackException;

public class LinkedListStack<T> implements StackInterface<T>
{
	SingleLinkedList<T> theData;
	
	/** 
	   constructor for LinkedList stack
	*/
	public LinkedListStack()
	{
		theData = new SingleLinkedList<T>();
	}

	/** returns true or false if stack is empty
    	@returns boolean if empty
	*/
	public boolean empty()
	{
		return (theData.size() == 0);
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
	@SuppressWarnings("unchecked")
	public T pop()
	{
		if(empty())
		{
			throw new EmptyStackException();
		}
		return (T) theData.removeLast();
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
