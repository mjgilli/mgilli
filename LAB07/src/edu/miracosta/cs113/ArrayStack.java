package edu.miracosta.cs113;
import java.util.ArrayList;
import java.util.EmptyStackException;
public class ArrayStack<T> implements StackInterface<T>
{
	ArrayList<T> theData;
	
	public ArrayStack()
	{
		theData = new ArrayList<T>();
	}
	
	public boolean empty()
	{
		return theData.isEmpty();
	}
	
	public T peek()
	{
		return theData.get(theData.size() - 1);
	}
	
	public T pop()
	{
		if(empty())
		{
			throw new EmptyStackException();
		}
		return theData.remove(theData.size() - 1);
	}
	
	public T push(T object)
	{
		theData.add(object);
		return object;
	}
}
