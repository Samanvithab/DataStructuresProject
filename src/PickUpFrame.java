
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.border.CompoundBorder;

/**
 * Internal frame to show pick up frame.
 */
public class PickUpFrame extends JInternalFrame implements ChangeListener
{
    private JPanel pickUpPanel;
    private JButton pickUpPanel2;
    private final PickUpList pickUpList;
    
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
    
    /**
     * Perform actions when state is changed
     * @param ce change event
     */
    @Override
    public void stateChanged(ChangeEvent ce)
    {
        pickUpPanel.removeAll();
               
        if (!pickUpList.isEmpty())
        {
            int index = 1; // list starts at 1
            for (Order order : pickUpList)
            {
                // get list of items from order
                String itemList = "";
                for (Item item : order.getItemList())
                {
                    itemList += item.getName() + " * " + item.getQuantity() + "<br>";
                }
        	
                // show order info
                JLabel pickMeUp = new JLabel();
                pickMeUp.setText("<html><body>" + order.getName() + "<br>" + order.getPhoneNumber() + "<br>" +
                                 "Total Cost: $" + order.calculateBill() + "<br><br>"  + itemList + "</body></html>");

                // set styles
                pickMeUp.setOpaque(true);
                pickMeUp.setBackground(new Color(220, 220, 220));
                pickMeUp.setBorder(new CompoundBorder(
                    BorderFactory.createLineBorder(Color.DARK_GRAY, 1), 
                    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
                
            	pickMeUp.addMouseListener(new PickUpMouseListener(index));
                pickUpPanel.add(pickMeUp, BorderLayout.NORTH);
                index++;
            }
        }
        else // no orders
        {
            pickUpPanel.add(new JLabel("No orders!"));
        }
        
        pickUpPanel.revalidate();
        pickUpPanel.repaint();
    }
    
    /**
     * Custom mouse listener for pick up list.
     */
    private class PickUpMouseListener implements MouseListener
    {
        private int index;
        
        /**
         * Creates a pick up mouse listener
         * @param index index of order
         */
        public PickUpMouseListener(int index)
        {
            this.index = index;
        }

        @Override
        public void mouseClicked(MouseEvent me)
        {
            pickUpList.removeOrder(index);
        }

        @Override
        public void mousePressed(MouseEvent me) {}

        @Override
        public void mouseReleased(MouseEvent me) {}

        @Override
        public void mouseEntered(MouseEvent me) {}

        @Override
        public void mouseExited(MouseEvent me) {}
    }
}
