
import java.util.LinkedList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PickUpList extends LinkedList<Order>
{
    ChangeListener listener;
        
    public void addOrder(Order order)
    {
        if (order != null)
        {
            add(order);
            update();
        }
    }
    
    public Order removeOrder()
    {
        if (!isEmpty())
        {
            Order order = remove();
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