package edu.miracosta.cs113;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Lab12 
{

	public static void main(String[] args) 
	{
		String[] listA = {"Ann", "Sally", "Jill", "Sally"};
		String[] listB = {"Bob", "Bill", "Ann", "Jill"};
		Set<String> setA = new HashSet<String>();
		Set<String> setACopy = new HashSet<String>();
		Set<String> setB = new HashSet<String>();
		Set<String> setC = new HashSet<String>();
		
		//Load sets from arrays.
		for(int i = 0; i < listA.length; i++)
		{
			setA.add(listA[i]);
			setACopy.add(listA[i]);
		}
		
		for(int i = 0; i < listB.length; i++)
		{
			setB.add(listB[i]);
		}
		
		System.out.println("The 2 sets are: " + "\n" + setA + "\n" + setB);
		// programming part 1
		
		if(setA.addAll(setB))
		{
			setC.addAll(setA); //c = (a U b)
		}
		
		System.out.println("Union: " + setC);
		setA = new HashSet<String>(setACopy);
		setC = new HashSet<String>();
		
		setA.retainAll(setB);
		setC.addAll(setA); // c = (a intersection b)
		
		System.out.println("Intersection: " + setC);
		setA = new HashSet<String>(setACopy);
		setC = new HashSet<String>();
		
		setA.removeAll(setB);
		setC.addAll(setA);
	
		System.out.println("Difference: " + setC);
		setA = new HashSet<String>(setACopy);
		setC = new HashSet<String>();
		
		if(setA.containsAll(setB))
		{
			setC = setA;
		}
		else
		{
			setC = setB;
		}
		
		

	}
	
	//part 2
	public static <E> String toString(Set<E> a)
	{
		String temp;
		@SuppressWarnings("rawtypes")
		Iterator i = a.iterator();
		temp = "[";
		while(i.hasNext())
		{
			temp += (i.next() + ", ");
		}
		temp = temp.substring(0, temp.length() - 2);
		temp += "]";
		return temp;
	}

}
