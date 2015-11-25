
import java.awt.BorderLayout;
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
import java.lang.StringBuilder;
import java.util.ArrayList;

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
            int index = 0;
            for (Order o : pickUpList)
            {
            	
            	StringBuilder orderStr = new StringBuilder();
        	    
        	    ArrayList<String> order = new ArrayList<String>();
        	    
        	    //test
        	    /*
        	    order.add("Burger");
        	    order.add("Fries");
        	    order.add("Coke");
        	    */
        	    
        	    for (int i = 0; i < order.size(); i++) {
        	    	if (i != (order.size() - 1))
        	    		orderStr.append(order.get(i) + ", ");
        	    	if (i == (order.size() - 1))
        	    		orderStr.append(order.get(i));
        	    	
        	    }
        	        	    
            	
            	JButton pickMeUp = new JButton();
            	pickMeUp.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
            	pickMeUp.setBorderPainted(false);
            	pickMeUp.setContentAreaFilled(false);
            	pickMeUp.setText("<html><body>" + o.getName() + "<br>" + o.getPhoneNumber() + "<br>" +
            			o.getBill() + "<br>" + orderStr.toString() + "</body></html>");
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
