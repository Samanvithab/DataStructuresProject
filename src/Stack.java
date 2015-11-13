package datastructures;

/**
 * Implementation of stack using nodes.
 * FIFO: First in, first out
 */
public class Stack<T>
{
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
        if (isEmpty())
            first = new Node(entry);
        else
        {
            Node temp = first;
            first = new Node(entry);
            first.setNextNode(temp);
        }
    }
    
    /**
     * Removes the top entry on the stack.
     * @return entry on top, or null is stack is empty
     */
    public T pop()
    {
        if (isEmpty())
            return null;
        
        T result = first.getData();
        first = first.getNextNode();
        return result;
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
    
    private Node<T> first;
}
