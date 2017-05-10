package edu.miracosta.cs113;

@SuppressWarnings("serial")
public class BinarySearchTree<E extends Comparable<E>>
         extends BinaryTree<E>
{
    protected boolean addReturn;
    protected E       deleteReturn;

    
    public E find(E target)
    {
        return find(root, target);
    }
    
    public boolean contains(E target)
    {
    	E obj;
    	obj = find(root, target);
    	if(obj == null)
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }

    
    private E find(Node<E> localRoot, E target)
    {
    	int compResult;
        if (localRoot == null) 
        {
            return null;
        }

        compResult = target.compareTo(localRoot.data);
        
        if (compResult == 0) 
        {
            return localRoot.data;
        } 
        else if (compResult < 0) 
        {
            return find(localRoot.left, target);
        } 
        else 
        {
            return find(localRoot.right, target);
        }
    }
    
    public boolean add(E item) 
    {
        root = add(root, item);
        return addReturn;
    }

    
    private Node<E> add(Node<E> localRoot, E item) 
    {
        if (localRoot == null) 
        {
            
            addReturn = true;
            return new Node<E>(item);
        } 
        else if (item.compareTo(localRoot.data) == 0)
        {
            
            addReturn = false;
            return localRoot;
        } 
        else if (item.compareTo(localRoot.data) < 0)
        {
            
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        } 
        else 
        {
            
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }
    
    public E delete(E target) 
    {
        root = delete(root, target);
        return deleteReturn;
    }
    
    public boolean remove(E target) 
    {
        root = delete(root, target);
        if(root == null)
        {
        	return false;
        }
        else
        {
        	return true;
        }
        
    }
    
    private Node<E> delete(Node<E> localRoot, E item) 
    {
    	int compResult;
    	
        if (localRoot == null) 
        {
            
            deleteReturn = null;
            return localRoot;
        }

        
        compResult = item.compareTo(localRoot.data);
        if (compResult < 0) 
        {
            
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        } 
        else if (compResult > 0) 
        {
            
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        } 
        else 
        {
           
            deleteReturn = localRoot.data;
            if (localRoot.left == null) 
            {
                
                return localRoot.right;
            } 
            else if (localRoot.right == null) 
            {
                
                return localRoot.left;
            }
            else 
            {
                
                if (localRoot.left.right == null) 
                {
                   
                    localRoot.data = localRoot.left.data;
                    
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                } 
                else 
                {
            
                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
                }
            }
        }
    }
   
    private E findLargestChild(Node<E> parent) 
    {
        
        if (parent.right.right == null)
        {
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        } 
        else
        {
            return findLargestChild(parent.right);
        }
    }
    
}