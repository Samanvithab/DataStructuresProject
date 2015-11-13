package datastructures;

public class DoublyLinkedList<AnyType> 
{
    private DoublyLinkedNode<AnyType> head;
    private DoublyLinkedNode<AnyType> tail;
    
    //Returns the no. of nodes in Doubly linked list
    public int getSize()
    {
        int count = 0;
        if(head == null)
            return count;
        else
        {
        	count++;
        	DoublyLinkedNode<AnyType> temp = head;
            do
            {
                temp = temp.getNextNode();
                count++;
            }
            while(temp != tail);
        }
        return count;
    }
    
    //Traverse from head
    public void traverseFromHead()
    {
    	DoublyLinkedNode<AnyType> temp = head;
        while(temp != null)
        {
            System.out.print(temp.getData()+" ");
            temp = temp.getNextNode();
        }
    }
    
    //Traverse from tail
    public void traverseFromTail()
    {
    	DoublyLinkedNode<AnyType> temp = tail;
        while(temp != null){
            System.out.print(temp.getData()+" ");
            temp = temp.getPrevNode();
        }
    }
    
    //insert at the beginning
    public void insertAtBeg(AnyType data)
    {
    	DoublyLinkedNode<AnyType> newnode = new DoublyLinkedNode<AnyType>(data);
        if(head == null)
        {
            head = newnode;
            tail = newnode;
            newnode.setNextNode(null);
            newnode.setPrevNode(null);
        }
        else
        {
             newnode.setNextNode(head);
             head.setPrevNode(newnode);
             head = newnode;
        }
            
    }
    
    //insert at the end
    public void insertAtEnd(AnyType data)
    {
    	DoublyLinkedNode<AnyType> newnode=new DoublyLinkedNode<AnyType>(data);
        if(tail == null)
        {
            head = newnode;
            tail = newnode;
            newnode.setNextNode(null);
            newnode.setPrevNode(null);
        }
        else
        {
            newnode.setPrevNode(tail);
            tail.setNextNode(newnode);
            tail = newnode;
        }
    }
    
    //insert at a given position
    public void insertAtPosition(AnyType data,int position)
    {
        if(position < 0  || position == 0)
        {
            insertAtBeg(data);
        }    
        else if(position > getSize() || position == getSize())
        {
            insertAtEnd(data);
        }
        else
        {
        	DoublyLinkedNode<AnyType>temp = head;
        	DoublyLinkedNode<AnyType> newnode = new DoublyLinkedNode<AnyType>(data);
            for(int i=0; i<position-1; i++)
            {
                temp = temp.getNextNode();
            }
            newnode.setNextNode(temp.getNextNode());
            temp.getNextNode().setPrevNode(newnode);
            temp.setNextNode(newnode);
            newnode.setPrevNode(temp);
        }
    }
    
    public AnyType remove()
    {
        AnyType data = null;

        data = head.getData();
        head = head.getNextNode();

        return data;//Deleted node's data
    }   
    
    //Removal based on a given position
    public AnyType remove(int position)
    {
        AnyType data=null;
        if(position == 1)
        {
            data = head.getData();
            head = head.getNextNode();
        }
        else if(position == getSize())
        {
            data = tail.getData();
            tail = tail.getPrevNode();
            tail.setNextNode(null);
        }
        else
        {
        	DoublyLinkedNode<AnyType> temp = head;
            for(int i = 0; i<position; i++)
            {
                temp = temp.getNextNode();
            }
            DoublyLinkedNode<AnyType> node = temp.getNextNode();
            node.setPrevNode( temp.getPrevNode() );
            temp.getPrevNode().setNextNode(node);
            temp = null;
        }
        return data;//Deleted node's data
    }   
}
