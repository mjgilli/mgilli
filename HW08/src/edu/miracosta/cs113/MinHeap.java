package edu.miracosta.cs113;

import java.util.Comparator;

@SuppressWarnings("serial")
public class MinHeap<E> extends Heap<E> 
{
	/**
	 * Default Constructor creates priority-based heap. elements ordered
	 *  based on natural ordering
	 */
	public MinHeap()
	{
		super();
	}
	

	/**
	 *  Creates a priority-based heap with the specified initial
	 *  capacity that orders its elements according to the specified
	 *  comparator.
	 *  @param cap The initial capacity for this priority queue
	 *  @param comp The comparator used to order this priority queue
	 */
	public MinHeap(Comparator<E> comp)
	{
		super(comp);
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
	@SuppressWarnings("unchecked")
	public int compare(E left, E right) 
	{
		if (comparator != null) 
		{ // A Comparator is defined.
			return comparator.compare(left, right);
		} 
		else 
		{ // Use left’s compareTo method.
			return ((Comparable<E>) left).compareTo(right);
		}
	}
}
