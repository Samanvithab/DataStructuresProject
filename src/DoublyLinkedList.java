

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Implementation of a doubly linked list
 * 
 * Each node of a list contains two links that are references to the previous and to the next node
 * The previous link of the first node and the next link of the last node points to NULL
 * @author Yanpeng (Sheldon) Li
 *
 * @param <AnyType>
 */
public class DoublyLinkedList<AnyType> implements Iterable<AnyType>
{
    private DoublyLinkedNode<AnyType> head;
    private DoublyLinkedNode<AnyType> tail;
//    private DoublyLinkedListIterator dl;
    /**
     * Construct an empty Doubly Linked List.
     */
    public DoublyLinkedList( )
    {
        doClear( );
    }
    
    /**
     * Empties the tree.
     */
    private void clear( )
    {
        doClear( );
    }
    
    /**
     * Change the size of this collection to zero.
     */
    public void doClear( )
    {
//    	head = new DoublyLinkedNode<AnyType>();
//    	tail = new DoublyLinkedNode<AnyType>();
//    	head.setNextNode(tail);
//    	dl = (DoublyLinkedList<AnyType>.DoublyLinkedListIterator) this.iterator();
    }
   
    /**
     * Returns the number of items in Doubly linked list.
     * @return the number of items in Doubly linked list.
     */
    public int getSize( )
    {
        return getTheSize();
    }
    
    /**
     * Internal method to get the no. of nodes in Doubly linked list
     */
    private int getTheSize()
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
    
    /**
     * Checks if tree is empty
     * @return true if empty, false if not
     */
    public boolean isEmpty( )
    {
        return getSize( ) == 0;
    }
 
    /**
     * Traverse from head
     */
    public void traverseFromHead()
    {
    	traverseFromTheHead();
    }
    
    /**
     * Internal method to traverse from head
     */
    private void traverseFromTheHead()
    {
    	DoublyLinkedNode<AnyType> temp = head;
        while(temp != null)
        {
            System.out.print(temp.getData()+" ");
            temp = temp.getNextNode();
        }
//    	System.out.print(dl.next());
    }
    
    
    /**
     * Traverse from tail
     */
    public void traverseFromTail()
    {
    	traverseFromTheTail();
    }
    
    /**
     * Internal method to traverse from tail
     */
    private void traverseFromTheTail()
    {
    	DoublyLinkedNode<AnyType> temp = tail;
        while(temp != null){
            System.out.print(temp.getData()+" ");
            temp = temp.getPrevNode();
        }
    }
    
    /**
     * Inserts an item to Doubly linked list at the beginning.
     * @param entry entry to insert
     */
    public void insertAtBeg(AnyType data)
    {
    	insertAtTheBeg(data);
    }
    
    
    /**
     * Internal method to insert at the beginning
     * The previous link of the first node and the next link of the last node points to NULL
     * @param data
     */
    private void insertAtTheBeg(AnyType data)
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
    
    
    /**
     * Inserts an item to Doubly linked list at the end.
     * @param entry entry to insert
     */
    public void insertAtEnd(AnyType data)
    {
    	insertAtTheEnd(data);
    }
    
    
    /**
     * Internal method to insert at the end
     * The next link of the last node points to NULL
     * @param data
     */
    private void insertAtTheEnd(AnyType data)
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
    
    
    /**
     * Inserts an item to Doubly linked list at a given position.
     * @param entry entry to insert
     */
    public void insertAtPosition(AnyType data,int position)
    {
    	insertAtGivenPosition(data, position);
    }
    
    /**
     * Internal method to add an item to Doubly linked list, at specified position.
     */
    private void insertAtGivenPosition(AnyType data,int position)
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
    
    /**
     * remove an item from this Doubly linked list.
     * @return deleted node's data
     */
    public AnyType remove()
    {
    	return removal();
    }
    
    /**
     * Internal method to remove an item from this Doubly linked list.
     * @return deleted node's data
     */
    private AnyType removal()
    {
        AnyType data = null;

        data = head.getData();
        head = head.getNextNode();

        return data;
    }   
    
    
    /**
     * Removes an item from this Doubly linked list based on a given position
     * @return deleted node's data
     */
    public AnyType removal(int position)
    {
    	return remove(position);
    }
    
    /**
     * Internal method to remove an item from this Doubly linked list based on a given position
     * @param position
     * @return deleted node's data
     */
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
        return data;
    }   


/**
 * Obtains an Iterator object used to traverse the collection.
 * @return an iterator positioned prior to the first element.
 */
    public Iterator<AnyType> iterator()  
    { 
    	return new DoublyLinkedListIterator(); 
    }
    
    private class DoublyLinkedListIterator implements java.util.Iterator<AnyType> 
    {
        private DoublyLinkedNode<AnyType>  current = head; //.getNext();  // the node that is returned by next()
        private DoublyLinkedNode lastAccessed = null;      // the last node to be returned by next()

        public boolean hasNext()      
        { 
        	return current.getNext()!=null;
        }

        public AnyType next() 
        {
            if (!hasNext()) throw new NoSuchElementException();
            lastAccessed = current;
            AnyType item = current.getData();
            current = current.getNext(); 
            return item;
        }
    }
}
