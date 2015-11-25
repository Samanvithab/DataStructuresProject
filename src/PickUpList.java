
import datastructures.DoublyLinkedList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * List of orders to pick up.
 */
public class PickUpList extends DoublyLinkedList<Order>
{
    ChangeListener listener;
    
    /**
     * Adds order to pick up list.
     * @param order order to add
     */
    public void addOrder(Order order)
    {
        if (order != null)
        {
            insertAtEnd(order);
            update();
        }
    }
    
    /**
     * Removes order from pick up list.
     * @param position location of order in list
     * @return 
     */
    public Order removeOrder(int position)
    {
        if (!isEmpty())
        {
            Order order = remove(position);
            update();
            return order;
        }
        return null;
    }
    
    /**
     * Attaches change listener.
     * @param c listener
     */
    public void attach(ChangeListener c)
    {
        listener = c;
    }
    
    /**
     * Updates change listener.
     */
    public void update()
    {
        listener.stateChanged(new ChangeEvent(this));
    }
}
