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
            first.next = temp;
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
        
        T result = first.element;
        first = first.next;
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
        
        return first.element;
    }
    
    private Node<T> first;
    
    /**
     * Implementation of Node used in a stack.
     */
    private static class Node<T>
    {
        private T element;
        private Node<T> next;
        
        /**
         * Creates an empty node.
         */
        Node()
        {
            element = null;
            next = null;
        }
        
        /**
         * Creates a node with a value.
         * @param element the value of the node
         */
        Node(T element)
        {
            this.element = element;
        }
    }
}