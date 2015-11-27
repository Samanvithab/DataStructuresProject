
import datastructures.Queue;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Kitchen as a queue of orders.
 */
public class Kitchen extends Queue<Order>
{
    ChangeListener listener;
        
    /**
     * Adds an order.
     * @param order order to add
     */
    public void addOrder(Order order)
    {
        if (order != null)
        {
            enqueue(order);
            update();
        }
    }
    
    /**
     * Removes an order
     * @return order removed
     */
    public Order removeOrder()
    {
        if (!isEmpty())
        {
            Order order = dequeue();
            update();
            return order;
        }
        return null;
    }
    
    /**
     * Attaches change listener.
     * @param c the listener
     */
    public void attach(ChangeListener c)
    {
        listener = c;
    }
    
    /**
     * Updates change lister.
     */
    public void update()
    {
        listener.stateChanged(new ChangeEvent(this));
    }
}