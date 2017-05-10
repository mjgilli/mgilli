package edu.miracosta.cs113;


import java.io.Serializable;
import java.util.Scanner;

@SuppressWarnings("serial")
public class BinaryTree<E> implements Serializable 

{
	protected Node<E> root;
	
	/**
	 * default constructor
	 */
	public BinaryTree()
	{
		root = null;
	}
	/**
	 * Constructor when root is know
	 * @param root
	 */
	protected BinaryTree(Node<E> root)
	{
		this.root = root;
	}
	
	/**
	 * puts two binary trees together if know root
	 * @param data
	 * @param leftTree
	 * @param rightTree
	 */
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree)
	{
		root = new Node<E>(data);
		if(leftTree != null)
		{
			root.left = leftTree.root;
		}
		else
		{
			root.left = null;
		}
		if(rightTree != null)
		{
			root.right = rightTree.root;
		}
		else
		{
			root.right = null;
		}
	}
	
	/**
	 * separates the left BinaryTree
	 * @return left subtree of BinaryTree
	 */
	public BinaryTree<E> getLeftSubtree()
	{
		if(root != null && root.left != null)
		{
			return new BinaryTree<E>(root.left);
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * separates right binary tree
	 * @return right subtree
	 */
	public BinaryTree<E> getRightSubtree()
	{
		if(root != null && root.right != null)
		{
			return new BinaryTree<E>(root.right);
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * returns data of the root
	 * @return root.data
	 */
	public E getData()
	{
		return root.data;
	}
	
	/**
	 * tells you if node is leaf
	 * @return boolean based on if node is leaf
	 */
	public boolean isLeaf()
	{
		return (root.left == null && root.right == null); 
	}
	
	/**
	 * Constructs a diagram to represent the binary Tree
	 * @return String
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root, 1, sb);
		return sb.toString(); 
	}
	
	/**
	 * Helper method used to traverse BinaryTree
	 * @param node Node<E>
	 * @param depth int
	 * @param sb StringBuilder used to append string
	 */
	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb)
	{
		for(int i = 1; i < depth; i++)
		{
			sb.append("    ");
		}
		if(node == null)
		{
			sb.append("null\n");
		}
		else
		{
			sb.append(node.toString() + "\n");
			preOrderTraverse(node.left, depth + 1, sb);
			preOrderTraverse(node.right, depth + 1, sb);
		}
	}
	
	/**
	 * Constructs a binary tree from a txt file
	 * @param scan Scanner used to read from file
	 * @return
	 */
	public static BinaryTree<String> readBinaryTree(Scanner scan)
	{
		String data = scan.next();
		if(data.equals("null"))
		{
			return null;
		} 
		else
		{
			BinaryTree<String> leftTree  = readBinaryTree(scan);
			BinaryTree<String> rightTree = readBinaryTree(scan);
			return new BinaryTree<String>(data, leftTree, rightTree);
		}
	}

	protected static class Node<E> implements Serializable
	{
		protected E data;
		protected Node<E> left;
		protected Node<E> right;
		
		/**
		 * Node or part of BinaryTree
		 * @param data
		 */
		public Node(E data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		/**
		 * @return String representation of data of node
		 */
		public String toString()
		{
			return this.data.toString();
		}
	}
}
