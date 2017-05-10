package edu.miracosta.cs113;


public class Lab17<E> 
{
	private static class AVLNode<E> 
	{
		/** Constant to indicate left-heavy */
		public static final int LEFT_HEAVY = -1;

		/** Constant to indicate balanced */
		public static final int BALANCED = 0;

		/** Constant to indicate right-heavy */
		public static final int RIGHT_HEAVY = 1;

		/** balance is right subtree height – left subtree height */
		private int balance;

		// Methods
		/**
		 * Construct a node with the given item as the data field.
		 * 
		 * @param item
		 *            The data field
		 */
		@SuppressWarnings("unused")
		public AVLNode(E item) {
			
			balance = BALANCED;
		}

		/**
		 * Return a string representation of this object. The balance value is
		 * appended to the contents.
		 * 
		 * @return String representation of this object
		 */
		public String toString() {
			return balance + ": " + super.toString();
		}
	}
	private AVLNode<E> rebalanceRight(AVLNode<E> localRoot) 
	{
		// Obtain reference to right child.
		AVLNode<E> rightChild = (AVLNode<E>) localRoot.right;
		// See whether right-left heavy.
		if (rightChild.balance < AVLNode.BALANCED) 
		{
			// Obtain reference to right-left child.
			AVLNode<E> rightLeftChild = (AVLNode<E>) rightChild.left;
			/**
			 * Adjust the balances to be their new values after the rotations
			 * are performed.
			 */
			if (rightLeftChild.balance > AVLNode.BALANCED) 
			{
				rightChild.balance = AVLNode.BALANCED;
				rightLeftChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.LEFT_HEAVY;
			} 
			else 
			{
				rightChild.balance = AVLNode.RIGHT_HEAVY;
				rightLeftChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.BALANCED;
			}
			// Perform right rotation.
			localRoot.right = rotateRight(rightChild);
		} 
		else 
		{ // Right-Right case
			/**
			 * In this case the rightchild (the new root) and the root (new left
			 * child) will both be balanced after the rotation.
			 */
			rightChild.balance = AVLNode.BALANCED;
			localRoot.balance = AVLNode.BALANCED;
		}
		// Now rotate the local root left.
		return (AVLNode<E>) rotateLeft(localRoot);
	}
}
