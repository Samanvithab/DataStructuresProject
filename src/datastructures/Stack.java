package datastructures;

/**
 * Implementation of stack using nodes.
 * FIFO: First in, first out
 */
public class Stack<T>
{
    private Node<T> first;
    
    /**
     * Creates an empty stack.
     */
    public Stack()
    {
        first = null;
    }
    
    /**
     * Checks if stack is empty.
     * @return true if stack is empty, else false
     */
    public boolean isEmpty()
    {
        return first == null;
    }
    
    /**
     * Adds an entry to the stack.
     * @param entry entry to add
     */
    public void push(T entry)
    {     
        first = push(entry, first);
    }
    
    /**
     * Removes the top entry on the stack.
     * @return data of entry on top
     */
    public T pop()
    {
        return pop(first);
    }
    
    /**
     * Retrieves the entry at the top of the stack.
     * @return entry on the top
     */
    public T peek()
    {
        if (isEmpty())
            return null;
        
        return first.getData();
    }
    
    /**
     * Internal method to add to stack.
     * @param entry new entry
     * @param topNode first node
     * @return new first node
     */
    private Node push(T entry, Node topNode)
    {
        if (isEmpty())
        {
            return new Node(entry);
        }
        else // not empty
        {
            Node temp = new Node(entry);
            temp.setNextNode(topNode);
            return temp;
        }
    }
    
    /**
     * Internal method to remove from stack.
     * @param topNode first node
     * @return data of first node or null if empty
     */
    private T pop(Node topNode)
    {
        if (isEmpty())
        {
            return null;
        }
        else // not empty
        {
            T result = (T) topNode.getData();
            first = topNode.getNextNode();
            return result;
        }
    }
}