
import datastructures.Queue;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Kitchen extends Queue<Order>
{
    ChangeListener listener;
        
    public void addOrder(Order order)
    {
        if (order != null)
        {
            enqueue(order);
            update();
        }
    }
    
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
    
    public void attach(ChangeListener c)
    {
        listener = c;
    }
    
    public void update()
    {
        listener.stateChanged(new ChangeEvent(this));
    }
}