package testJUnit;
import org.junit.Assert;
import org.junit.Test;

import edu.miracosta.cs113.DoubleLinkedList;

public class DoubleLinkedListTester
{
	@Test
	public <T> void testAddFirst()
	{
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		list.addFirst(new Integer(1));
		Assert.assertTrue(list.getFirst() == 1);
	}
	
	@Test
	public <T> void testAddLast()
	{
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		list.addLast(new Integer(1));
		Assert.assertTrue(list.getLast() == 1);
	}
	
	@Test
	public <T> void testAdd()
	{
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		list.addFirst(new Integer(1));
		list.addLast(new Integer(3));
		list.add(1, new Integer(2));
		Assert.assertTrue(list.get(1) == 2);
	}
	
	@Test
	public <T> void testRemove()
	{
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		list.addFirst(new Integer(1));
		list.addLast(new Integer(3));
		list.add(1, new Integer(2));
		list.remove(0);
		list.remove(0);
		Assert.assertTrue(list.getFirst() == 3);
	}
	
	public <T> void testSize()
	{
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		list.addFirst(new Integer(1));
		list.addLast(new Integer(3));
		list.add(1, new Integer(2));
		Assert.assertTrue(list.size() == 3);
	}
	
	
}
