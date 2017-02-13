package edu.miracosta.cs113;
import java.util.ArrayList;
public class LabFiveDriver
{
	public static void main(String[] args)
	{
		ArrayList<String> stringlist = new ArrayList<String>();
		String string1 = "hi";
		String string2 = "what up";
		String string3 = "yoooo";
		
		stringlist.add(string1);
		stringlist.add(string2);
		stringlist.add(string3);
		stringlist.add(string1);
		
		for(int i = 0; i < stringlist.size(); i++)
		{
			System.out.println(stringlist.get(i));
		}
		
		replace(stringlist, string1, "whhhhaaatttup");
		
		System.out.println();
		System.out.println();
		for(int i = 0; i < stringlist.size(); i++)
		{
			System.out.println(stringlist.get(i));
		}
		
		delete(stringlist, string2);
		System.out.println();
		System.out.println();
		for(int i = 0; i < stringlist.size(); i++)
		{
			System.out.println(stringlist.get(i));
		}
	}
	
	public static void replace (ArrayList<String> aList, String oldItem, String newItem)
	{
		while(aList.indexOf(oldItem) != -1)
		{
			System.out.println(oldItem);
			aList.set(aList.indexOf(oldItem), newItem);
		}
	}
	
	public static void delete(ArrayList<String> aList, String target)
	{
		aList.remove(aList.indexOf(target));
	}
	
}
