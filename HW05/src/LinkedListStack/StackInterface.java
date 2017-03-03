package LinkedListStack;

import java.util.EmptyStackException;

public interface StackInterface<T>
{
	
	/** returns true or false if stack is empty
    	@returns boolean if empty
	*/
	public boolean empty();
	
	/** returns object at top of stack
		@return Object at top of stack
	*/
	public T peek();

	/** removes and returns item at top of stack
		@throws EmptyStackException
		@return Object removed
	*/
	public T pop();
	
	/** Adds element to top of stack
		@param Object to be added to stack
		@return Object to be added
	*/
	public T push(T object);

}
