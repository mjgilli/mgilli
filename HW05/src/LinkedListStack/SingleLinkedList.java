package LinkedListStack;

public class SingleLinkedList <T>
{
	 private Node<T> head = null;
	 private int     size;
	
	// DESCRIPTION:   Default constructor for SingleLinkedList
	// PRECONDITION:  N/A
	// POSTCONDITION: Head node will be created for linked list with null values 
	public SingleLinkedList() 
    {
        head = new Node<T>();
    } 
	 
	// DESCRIPTION:   Adds a node at the start of the list with the specified data. 
	// PRECONDITION:  All instance variables have valid values
	// POSTCONDITION: The added node will be the first node in the list.
    private void addFirst(T itemData) 
    {
        head = new Node<T>(itemData, head);
        size++;
    }
    
    // DESCRIPTION:   Add a node after given node
	// PRECONDITION:  Must know node before node adding, and node to add
	// POSTCONDITION: Adds node after given node
	private void addAfter(Node<T> node, T itemData)
	{
		node.link = new Node<T>(itemData, node.link);
		size++;
	}
	
	// DESCRIPTION:   Removes the head node 
	// PRECONDITION:  All instance variables have valid values
	// POSTCONDITION: Returns true if the list contains at least one
    //                node. Returns false if the list is empty.
    public T removeFirst() 
    {
		Node<T> temp = head;
		if (head != null) 
        {
			head = head.link;
        }
        
        if(temp != null)
        {
			size--;
			return temp.data;
		}
		else
		{
			return null;
		}
    }
    // DESCRIPTION:   Remove node after given node
	// PRECONDITION:  Node before the node to be removed
	// POSTCONDITION: Returns data from the removed nude, or null
	//				  if there is no node to be removed
    public T removeAfter(Node<T> node)
    {
		Node<T> temp = node.link;
		if(temp != null)
		{
			node.link = temp.link;
			size--;
			return temp.data;
		}
		else
		{
			return null;
		}
	}
	
	// DESCRIPTION:   Removes last node from LinkedList
	// PRECONDITION:  N/a
	// POSTCONDITION: The last node of list will be removed
	public Node<T> removeLast()
	{
		Node<T> current;
		Node<T> previous = null;
		
		if(head != null)
		{
			current = head;
			while(current.link!= null)
			{
				previous = current;
				current = current.link;
			}
			previous.link = null;
			return current;
		}
		return null;
	}
	
	// DESCRIPTION:   Gets node from SingleLinkedList
	// PRECONDITION:  Must have index
	// POSTCONDITION: Return node for SingleLinkedList
	private Node<T> getNode(int index)
	{
		Node<T> node = head;
		int i = 0;
		while(i < index && node != null)
		{
			node = node.link;
			i++;
		}
		return node;
	}
	
	// DESCRIPTION:   Gets node from SingleLinkedList
	// PRECONDITION:  Must have index
	// POSTCONDITION: Return node for SingleLinkedList
	public T get(int index) 
	{
		if(index < 0 || index >= size)
		{
			throw new 
				IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<T> node = getNode(index);
		return node.data;
	}
	
	// DESCRIPTION:   Sets Node to value
	// PRECONDITION:  Must have index
	// POSTCONDITION: Return node and sets value
	public T set(int index, T newValue)
	{
		if(index < 0 || index >= size)
		{
			throw new 
				IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<T> node = getNode(index);
		T result = node.data;
		node.data = newValue;
		return result;
	}
	
	// DESCRIPTION:   Gets size to given LinkedLIst
	// PRECONDITION:  N/A
	// POSTCONDITION: Return integer representing LinkedLIst size
	public int size()
	{
		return size;
	}
	
	// DESCRIPTION:   Adds a node at index
	// PRECONDITION:  index must be given, Item must be known
	// POSTCONDITION: Increases size and adds node to List at index
	public void add(int index, T item)
	{
		if(index < 0 || index > size)
		{
			throw new 
				IndexOutOfBoundsException(Integer.toString(index));
		}
		if(index == 0)
		{
			addFirst(item);
		}
		else
		{
			Node<T> node  = getNode(index - 1);
			addAfter(node, item);
		}
	}
	
	// DESCRIPTION:   Adds a node at end of list
	// PRECONDITION:  Item must be known
	// POSTCONDITION: Increases size and adds node to List at end
	public boolean add(T item)
	{
		add(size, item);
		return true;
	}
	
	// DESCRIPTION:   Converts object to String representation
	// PRECONDITION:  All instance variables have valid values
	// POSTCONDITION: Returns String containing all instance variables	
	public String toString()
	{
		Node<T> nodeRef =  head;
		StringBuilder result = new StringBuilder();
		while(nodeRef.link != null)
		{
			result.append(nodeRef.data);
			if(nodeRef.link.link != null)
			{
				result.append(" ===> ");
			}
			nodeRef = nodeRef.link;
		}
		return result.toString();
	}
	
	private static class Node<T> 
    {
        private T data;
        private Node<T> link;

        public Node() 
        {
            data = null;
            link = null;
        }

        public Node(T newData, Node<T> linkValue) 
        {
            data = newData;
            link = linkValue;
        }
    }// End of Node<T> inner class
	
}
