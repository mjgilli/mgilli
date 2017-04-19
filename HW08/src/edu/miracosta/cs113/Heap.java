package edu.miracosta.cs113;

import java.util.ArrayList; 
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

@SuppressWarnings("serial")
public abstract class Heap<E> extends PriorityQueue<E>
{
	protected ArrayList<E> theData;
	protected Comparator<E> comparator = null;
	
	/**
	 * Default Constructor creates priority-based heap. elements ordered
	 *  based on natural ordering
	 */
	public Heap()
	{
		theData = new ArrayList<E>();
	}
	
	/**
	 *  Creates a priority-based heap with the specified initial
	 *  capacity that orders its elements according to the specified
	 *  comparator.
	 *  @param cap The initial capacity for this priority queue
	 *  @param comp The comparator used to order this priority queue
	 */
	public Heap(Comparator<E> comp)
	{
		theData = new ArrayList<E>();
		comparator = comp;
	}
	
	/** returns true or false if stack is empty
	 * @returns boolean if empty
	 */
	public boolean isEmpty()
	{
		return theData.isEmpty();
	}
	
	/**
	 * Compare two items using either a Comparator object’s compare method or
	 * their natural ordering using method compareTo. 
	 * pre: If comparator is null, left and right implement Comparable<E>.
	 * @param left
	 *        One item
	 * @param right
	 *        The other item
	 * @return Negative int if left less than right, 0 if left equals right,
	 *         positive int if left > right
	 */
	public abstract int compare(E left, E right);
	
	/**
	 * swaps elements i and j in ArrayList called theData
	 * @param i element at index 
	 * @param j element at index
	 */
	private void swap(int i, int j)
	{
		E temp;
		temp = theData.get(i);
		theData.set(i, theData.get(j));
		theData.set(j, temp);
	}
	
	
	/**
	 * Insert an item into the priority queue. pre: The ArrayList theData is in
	 * heap order. post: The item is in the priority queue and theData is in
	 * heap order.
	 * 
	 * @param item
	 *            The item to be inserted
	 * @throws NullPointerException
	 *             if the item to be inserted is null.
	 */
	@Override
	public boolean offer(E item) 
	{		
		// Add the item to the heap.
		theData.add(item);
		// child is newly inserted item.
		int child = theData.size() - 1;
		int parent = (child - 1) / 2; // Find child’s parent.
		// Reheap
		while (parent >= 0 && compare(theData.get(parent), theData.get(child)) > 0) {
			swap(parent, child);
			child = parent;
			parent = (child - 1) / 2;
		}
		return true;
	}
	
	/**
	 * Remove an item from the priority queue pre: The ArrayList theData is in
	 * heap order. post: Removed smallest item, theData is in heap order.
	 * 
	 * @return The item with the smallest priority value or null if empty.
	 */
	@Override
	public E poll() 
	{
		if (isEmpty()) 
		{
			return null;
		}
		// Save the top of the heap.
		E result = theData.get(0);
		// If only one item then remove it.
		if (theData.size() == 1) 
		{
			theData.remove(0);
			return result;
		}
		/*
		 * Remove the last item from the ArrayList and place it into the first
		 * position.
		 */
		theData.set(0, theData.remove(theData.size() - 1));
		// The parent starts at the top.
		int parent = 0;
		int leftChild = 2 * parent + 1;
		while (leftChild < theData.size()) 
		{			
			int rightChild = leftChild + 1;
			int minChild = leftChild; // Assume leftChild is smaller.
			// See whether rightChild is smaller.
			if (rightChild < theData.size() && compare(theData.get(leftChild), theData.get(rightChild)) > 0) 
			{
				minChild = rightChild;
			}
			// assert: minChild is the index of the smaller child.
			// Move smaller child up heap if necessary.
			if (compare(theData.get(parent), theData.get(minChild)) > 0) 
			{
				swap(parent, minChild);
				parent = minChild;
			} 
			leftChild = 2 * parent + 1;			
		}
		return result;
	}
	
	/**
	 * Remove an item from the priority queue pre: The ArrayList theData is in
	 * heap order. post: Removed smallest item, theData is in heap order.
	 * 
	 * @return The item with the smallest priority value or null if empty.
	 * @throws NoSuchElementException() if Heap is empty
	 */
	public E remove()
	{
		if (isEmpty()) 
		{
			throw new NoSuchElementException();
		}
		else
		{
			return poll();
		}
		
	}
	
	/**
	 * Returns the smallest entry without removing it. 
	 * If the Heap is empty, returns null
	 */
	public E peek()
	{
		if (isEmpty()) 
		{
			return null;
		}
		else
		{
			return theData.get(0);
		}
	}
	
	/**
	 * Returns the smallest entry without removing it.
	 * If the queue is empty, throws NoSuchElementException
	 * @throws NoSuchElementException()
	 */
	public E element()
	{
		if (isEmpty()) 
		{
			throw new NoSuchElementException();
		}
		else
		{
			return peek();
		}
	}
	
	
	
}
