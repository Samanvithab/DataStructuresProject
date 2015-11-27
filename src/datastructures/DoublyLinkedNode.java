package datastructures;

/**
 * Implementation of doubly linked node.
 * Keeps track of next and previous node.
 */
public class DoublyLinkedNode<AnyType> 
{
    private AnyType data;
    private DoublyLinkedNode<AnyType> next;
    private DoublyLinkedNode<AnyType> prev;
    
    /**
     * Creates an empty node.
     */
    DoublyLinkedNode()
    {
        next = null;
        prev = null;
        data = null;
    }
    
    /**
     * Creates a node with data.
     * @param data node's data
     */
    DoublyLinkedNode(AnyType data) 
    {
        this(data, null, null);
    }
    
    /**
     * Creates a connected node with data.
     * @param data nodes' data
     * @param next next node
     * @param prev previous node
     */
    DoublyLinkedNode(AnyType data, DoublyLinkedNode<AnyType> next, DoublyLinkedNode<AnyType> prev) 
    {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    /**
     * Retrieves data from node.
     * @return node's data
     */
    AnyType getData() 
    {
        return data;
    }
    
    /**
     * Set node's data.
     * @param data node's data
     */
    public void setData(AnyType data) 
    {
        this.data = data;
    }
    
    /**
     * Retrieve the previous node.
     * @return previous node
     */
    public DoublyLinkedNode<AnyType> getPrevNode() 
    {
        return prev;
    }
    
    /**
     * Set previous node.
     * @param prev previous node
     */
    public void setPrevNode(DoublyLinkedNode<AnyType> prev) 
    {
        this.prev = prev;
    }
    
    /**
     * Retrieve the next node.
     * @return next node
     */
    public DoublyLinkedNode<AnyType> getNextNode() 
    {
        return next;
    }
    
    /**
     * Set next node.
     * @param next next node
     */
    public void setNextNode(DoublyLinkedNode<AnyType> next) 
    {
        this.next = next;
    }
}