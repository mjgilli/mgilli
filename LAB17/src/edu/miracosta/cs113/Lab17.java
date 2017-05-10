package edu.miracosta.cs113;


public class Lab17 
{
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
