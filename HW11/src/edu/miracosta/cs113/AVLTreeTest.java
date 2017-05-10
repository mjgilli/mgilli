package edu.miracosta.cs113;



public class AVLTreeTest 
{
	public static void main(String[] args) 
	{
		/***** DECLARATION SECTION ******/		
		AVLTree<String> stringTree;
		
		
		
		/******** INSTANTIATION SECTION *******/
		stringTree = new AVLTree<String>();
		
		stringTree.add("The");
		stringTree.add("quick");
		stringTree.add("brown");
		stringTree.add("fox");
		stringTree.add("jumps");
		//stringTree.add("over");
	
		System.out.println(stringTree);
		
		
	}
}
