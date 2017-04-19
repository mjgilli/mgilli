package Testing;
import org.junit.Assert;
import org.junit.Test;

import edu.miracosta.cs113.MaxHeap;
import edu.miracosta.cs113.MinHeap;
public class MinAndMaxHeapTests
{
	@Test
	public void testHeapEmpty()
	{
		MinHeap<Integer> minHeap = new MinHeap<Integer>();
		Assert.assertTrue(minHeap.isEmpty());
		minHeap.offer(1);
		Assert.assertFalse(minHeap.isEmpty());
	}
	@Test
	public void testMinOffer()
	{
		MinHeap<Integer> minHeap = new MinHeap<Integer>();
		minHeap.offer(2);
		minHeap.offer(1);
		Assert.assertTrue(minHeap.peek() == 1);
	}
	@Test
	public void testMaxOffer()
	{
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
		maxHeap.offer(1);
		maxHeap.offer(7);
		Assert.assertTrue(maxHeap.peek() == 7);
	}
	@Test
	public void testMinRemove()
	{
		MinHeap<Integer> minHeap = new MinHeap<Integer>();
		minHeap.offer(2);
		minHeap.offer(1);
		Assert.assertTrue(minHeap.remove() == 1);
	}
	@Test
	public void testMaxRemove()
	{
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
		maxHeap.offer(1);
		maxHeap.offer(7);
		Assert.assertTrue(maxHeap.remove() == 7);
	}
	@Test
	public void testMinElement()
	{
		MinHeap<Integer> minHeap = new MinHeap<Integer>();
		minHeap.offer(2);
		minHeap.offer(1);
		Assert.assertTrue(minHeap.element() == 1);
	}
	@Test
	public void testMaxElement()
	{
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
		maxHeap.offer(1);
		maxHeap.offer(7);
		Assert.assertTrue(maxHeap.element() == 7);
	}
	
	
}
