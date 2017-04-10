package edu.miracosta.cs113;

public interface BinaryTreeInterface<E>
{
	public BinaryTree<E> getLeftSubtree();
	public BinaryTree<E> getRightSubtree();
	public E getData();
	public boolean isLeaf();
	public String toString();
	//private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb);
	//public static BinaryTree<E> readBinaryTree(Scanner scan);
	
	
}
