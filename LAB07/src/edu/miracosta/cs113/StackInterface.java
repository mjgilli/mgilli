package edu.miracosta.cs113;

public interface StackInterface<T>
{
	public boolean empty();

	public T peek();

	public T pop();
	
	public T push(T object);

}
