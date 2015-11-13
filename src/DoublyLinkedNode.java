
public class DoublyLinkedNode<AnyType> 
{
    private AnyType data;
    private DoublyLinkedNode<AnyType> next;
    private DoublyLinkedNode<AnyType> prev;
    
    DoublyLinkedNode()
    {
        next = null;
        prev = null;
        data = null;
    }
    
    DoublyLinkedNode(AnyType data) 
    {
        this(data, null, null);
    }
    
    DoublyLinkedNode(AnyType data, DoublyLinkedNode<AnyType> next, DoublyLinkedNode<AnyType> prev) 
    {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    AnyType getData() 
    {
        return data;
    }
    public void setData(AnyType data) 
    {
        this.data = data;
    }
    
    public DoublyLinkedNode<AnyType> getPrevNode() 
    {
        return prev;
    }
    public void setPrevNode(DoublyLinkedNode<AnyType> prev) 
    {
        this.prev = prev;
    }
    
    public DoublyLinkedNode<AnyType> getNextNode() 
    {
        return next;
    }
    public void setNextNode(DoublyLinkedNode<AnyType> next) 
    {
        this.next = next;
    }
}
