package datastructures;

/**
 * Implementation of Node used in a stack.
 */
public class Node<T>
{
    private T data;
    private Node<T> next;

    /**
     * Creates an empty node.
     */
    Node()
    {
        data = null;
        next = null;
    }

    /**
     * Creates a node with a value.
     * @param entry node's data
     */
    Node(T entry)
    {
        this.data = entry;
    }

    /**
     * Set node's data.
     * @param data node's data
     */
    void setData(T entry)
    {
        data = entry;
    }
    
    /**
     * Set next node.
     * @param nextNode next node
     */
    void setNextNode(Node<T> nextNode)
    {
        next = nextNode;
    }
    
    /**
     * Retrieves data from node.
     * @return node's data
     */
    T getData()
    {
        return data;
    }
    
    /**
     * Retrieves next node.
     * @return next node
     */
    Node<T> getNextNode()
    {
        return next;
    }
}