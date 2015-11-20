
import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Internal frame to show pick up frame.
 */
public class PickUpFrame extends JInternalFrame implements ChangeListener
{
    private JPanel pickUpPanel;
    private PickUpList pickUpList;
    
    /**
     * Creates an internal pick up frame with specified settings.
     * @param xSize width of frame
     * @param ySize height of frame
     * @param xPos x position of frame
     * @param yPos y position of frame
     * @param rest restaurant to order from
     */
    public PickUpFrame(int xSize, int ySize, int xPos, int yPos, Restaurant rest)
    {
        super("Pick Up", false, false, true, false);
        setSize(xSize, ySize);
        setLocation(xPos, yPos);
        setVisible(true);
        
        pickUpList = rest.getPickUpList();
        createComponents();
    }
    
    /**
     * Creates components in the frame.
     */
    private void createComponents()
    {
        // list of orders to pick up
        pickUpPanel = new JPanel();
        pickUpPanel.setLayout(new BoxLayout(pickUpPanel, BoxLayout.PAGE_AXIS));
        pickUpPanel.add(new JLabel("Nothing to pick up!"));
        JScrollPane pickUpPane = new JScrollPane(pickUpPanel);
        pickUpPane.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        
        add(pickUpPane);
    }
    
    @Override
    public void stateChanged(ChangeEvent ce)
    {
        pickUpPanel.removeAll();
        
        if (!pickUpList.isEmpty())
        {
            for (Order o : pickUpList)
                pickUpPanel.add(new JLabel(o.toString()));
        }
        else
        {
            pickUpPanel.add(new JLabel("No orders!"));
        }
        
        pickUpPanel.revalidate();
        pickUpPanel.repaint();
    }
}