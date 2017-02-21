package edu.miracosta.cs113;
import java.util.*;

//ToDo comment metthods out addFirst..addLast...getFirst..addLast

public class DoubleLinkedList<T>
{
	private Node<T> head;
	private Node<T> tail;
	private int     size;
	
	
	/** Add an item at the specified index.
	    @param index The index at which the object is to be inserted
	 	@param obj The object to be inserted
	 	@throws IndexOutOfBoundsException
	    		if the index is out of range (i < 0 || i > size())
	*/
	public void add(int index, T obj)
	{
		listIterator(index).add(obj);
	}
	

	public void addFirst(T item) 
	{
		add(0, item);
	}

	public void addLast(T item)
	{
		add(size, item);
	}
	
	/** Get the element at position index.
	    @param index Position of item to be retrieved
	    @return The item at index
	*/
	public T get(int index)
	{
		return listIterator(index).next(); 
	}
	
	public T getFirst() 
	{
		return head.data;
	}

	public T getLast()
	{
		return tail.data;
	}
	
    /** Get the size of the list
        @return The number of objects in the list
    */
	public int getSize()
	{
		return size;
	}
	
	public DoubleListIterator listIterator(int index)
	{
		return new DoubleListIterator(index);
	}
	
	public T remove(int index)
	{
		T object;
		ListIterator<T> removeIt = listIterator(index);
		if(removeIt.hasNext())
		{
			object = (T) removeIt.next();
			removeIt.remove();
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
		return object;
	}
	
	
	
	




	private static class Node<T> 
    {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data)
        {
        	setData(data);
        }

        public void setData(T data) {
			this.data = data;
		}
    }// End of Node<T> inner class
	
	private class DoubleListIterator implements ListIterator<T>
	{
		private Node<T> nextItem;
		private Node<T> lastItemReturned;
		private int     index;
		
		public DoubleListIterator(int i)
		{
			//check index
			if(i < 0 || i > size)
			{
				throw new IndexOutOfBoundsException("Invalid index " + i);
			}
			//no item returned yet
			lastItemReturned = null;
			if(i == size)
			{
				index = size;
			}
			else
			{
				nextItem = head;
				for (index = 0; index < i; index++)
				{
					nextItem = nextItem.next;
				}
			}
		}
		
		public boolean hasNext()
		{
			return nextItem != null;
		}
		
		public T next()
		{
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}
			lastItemReturned = nextItem.next;
			nextItem = nextItem.next;
			index++;
			return lastItemReturned.data;
		}
		
		public boolean hasPrevious()
		{
			return (nextItem == null && size != 0)
			     || nextItem.prev != null;
		}
		
		public T previous()
		{
			if (!hasPrevious())
			{
				throw new NoSuchElementException();
			}
			if (nextItem == null)
			{ // Iterator past the last element
				nextItem = tail;
			}
			else
			{
				nextItem = nextItem.prev;
			}
			lastItemReturned = nextItem;
			index--;
			return lastItemReturned.data;
		}
		
		public void add(T object)
		{
			//add to empty list
			if(head == null)
			{
				head = new Node<T>(object);
				tail = head;
				
			}
			//add to head of list
			if(nextItem == head)
			{
				Node<T> newNode = new Node<T>(object);
				newNode.next = nextItem;
				nextItem.prev = newNode;
				head = newNode;
			}
			//add to tail of list
			else if(nextItem == null)
			{
				Node<T> newNode = new Node<T>(object);
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			}
			else
			{
				Node<T> newNode = new Node<T>(object);
				newNode.prev = nextItem.prev;
				nextItem.prev.next = newNode;
				newNode.next = nextItem;
				nextItem.prev = newNode;
			}
			size++;
			index++;
			lastItemReturned = null;
			
		}

		public int nextIndex() 
		{
			return index;
		}

		public int previousIndex()
		{
			return index - 1;
		}

		public void remove()
		{
			if(lastItemReturned == null)
			{
				throw new IllegalStateException();
			}
			
			if(lastItemReturned.next != null)
			{
				lastItemReturned.next.prev = lastItemReturned.prev;
			}
			else
			{
				tail = lastItemReturned.prev;
				if(tail != null)
				{
					tail.next = null;
				}
				else
				{
					head = null;
				}
			}
			
			if(lastItemReturned.prev != null)
			{
				lastItemReturned.prev.next = lastItemReturned.next;
			}
			else
			{
				head = lastItemReturned.next;
				if(head != null)
				{
					head.prev = null;
				}
				else
				{
					tail = null;
				}
			}
			lastItemReturned = null;
			index--;
			size--;
			
		}

		public void set(T object) 
		{
			if(lastItemReturned == null)
			{
				throw new IllegalStateException();
			}
			lastItemReturned.setData(object);
		}
		
	}// End of DoubleListIterator inner class
	
}
