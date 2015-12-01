
import datastructures.AVLTree;
import datastructures.HashMap;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Internal frame to show menu and order.
 */
public class MenuFrame extends JInternalFrame
{
    private Restaurant restaurant;
    private Order order;
    
    /**
     * Creates an internal order frame with specified settings.
     * @param xSize width of frame
     * @param ySize height of frame
     * @param xPos x position of frame
     * @param yPos y position of frame
     * @param rest restaurant to order from
     */
    public MenuFrame(int xSize, int ySize, int xPos, int yPos, Restaurant rest)
    {
        super("Order", false, false, true, false);
        setSize(xSize, ySize);
        setLocation(xPos, yPos);
        setLayout(new BorderLayout());
        setVisible(true);
    
        restaurant = rest;
        order = new Order();
        showMenuPanel();
    }
    
    /**
     * Creates components for menu panel.
     */
    private void showMenuPanel()
    {
        getContentPane().removeAll();
        
        JLabel welcomeLabel = new JLabel("Welcome to "
                + restaurant.getName() + "!");
        welcomeLabel.setFont(new Font(Font.SANS_SERIF, 18, 24));
        JButton orderButton = new JButton("Finalize Items");
        
        // go to order panel
        orderButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		showOrderPanel();
        	}
        });
        
        // panel for menu
        JPanel menuPanel = new JPanel();
        menuPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.PAGE_AXIS));
        
        // add each item to menu
        for(HashMap.Entry<String, AVLTree> entry : restaurant.getMenu().getItems())
        { 
            // add category name
            JPanel categoryPanel = new JPanel(new BorderLayout());
            JLabel category = new JLabel(entry.getKey());
            category.setFont(new Font(Font.SANS_SERIF, 18, 18));
            categoryPanel.add(category, BorderLayout.WEST);
            menuPanel.add(categoryPanel);
            
            // add each item under category
            Iterator<Item> iter = entry.getValue().iterator();
            while(iter.hasNext())
            {
                Item item = iter.next();
                JPanel foodPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                JLabel itemLabel = new JLabel(item.getName() + ", $" + item.getPrice());
                JButton more = new JButton("+");
                JButton less = new JButton("-");
                JLabel count = new JLabel(item.getQuantity() + "");
                
                // button listeners
                ActionListener moreAction = new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            // add new item
                            if (item.getQuantity() == 0)
                                order.addItem(item);
                            item.increment();
                            count.setText(String.valueOf(item.getQuantity()));
                        }
                };
                more.addActionListener(moreAction);

                ActionListener lessAction = new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if (item.getQuantity() != 0)
                            {
                                item.decrement();
                                count.setText(String.valueOf(item.getQuantity()));
                                // remove item if quantity is 0
                                if (item.getQuantity() == 0)
                                    order.removeItem(item);
                            }
                        }
                };
                less.addActionListener(lessAction);
                
                foodPanel.add(itemLabel);
                foodPanel.add(more);
                foodPanel.add(less);
                foodPanel.add(count);
                menuPanel.add(foodPanel);
            }
        }

        add(welcomeLabel, BorderLayout.NORTH);
        add(new JScrollPane(menuPanel), BorderLayout.CENTER);
        add(orderButton, BorderLayout.SOUTH);
        
        repaint();
        revalidate();
    }
    
    /**
     * Creates components for order panel.
     */
    private void showOrderPanel()
    {
        getContentPane().removeAll();
        
        // panel and box to hold components
        JPanel orderPanel = new JPanel();
        Box orderBox = Box.createVerticalBox();
        orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.PAGE_AXIS));
        orderPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        // components
        JLabel orderLabel = new JLabel("Order");
        orderLabel.setFont(new Font(Font.SANS_SERIF, 18, 20));
        JLabel infoLabel = new JLabel("Information");
        infoLabel.setFont(new Font(Font.SANS_SERIF, 18, 20));
        JLabel nameLabel = new JLabel("Name");
        JLabel phoneLabel = new JLabel("Phone Number");
        JLabel costLabel = new JLabel();
        JTextField nameField = new JTextField(20);
        JTextField phoneField = new JTextField(20);
        JButton orderButton = new JButton("Place Order");
        JButton backButton = new JButton("Go Back");
        
        // send order to kitchen and start new order
        orderButton.addActionListener(event -> 
        {
            // send order
            order.setName(nameField.getText());
            order.setPhoneNumber(phoneField.getText());
            restaurant.getKitchen().addOrder(order);
            
            // start new order
            order = new Order();
            restaurant.setMenu(Simulator.generateMenu());
            showMenuPanel();
        });
        
        // go back to menu
        backButton.addActionListener(event -> 
        {
            showMenuPanel();
        });
        
        // get list of items in order
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
        for(Item i : order.getItemList())
        {
    		double total = i.getQuantity()*i.getPrice();
    		listPanel.add(new JLabel(i.getName() +  " * " + i.getQuantity() + " = $" + total));
    	} 
        costLabel.setText("Total Cost: $" + order.calculateBill());
        
        nameField.setMaximumSize(new Dimension(500, 25));
        phoneField.setMaximumSize(new Dimension(500, 25));
        
        // add to box
        orderBox.add(orderLabel);
        orderBox.add(Box.createRigidArea(new Dimension(0,10)));
        orderBox.add(listPanel);
        orderBox.add(Box.createRigidArea(new Dimension(0,10)));
        orderBox.add(costLabel);
        orderBox.add(Box.createRigidArea(new Dimension(0,30)));
        orderBox.add(infoLabel);
        orderBox.add(Box.createRigidArea(new Dimension(0,10)));
        orderBox.add(nameLabel);
        orderBox.add(nameField);
        orderBox.add(Box.createRigidArea(new Dimension(0,10)));
        orderBox.add(phoneLabel);
        orderBox.add(phoneField);
        orderBox.add(Box.createRigidArea(new Dimension(0,10)));
        orderBox.add(orderButton);
        orderBox.add(Box.createRigidArea(new Dimension(0,10)));
        orderBox.add(backButton);
        
        orderPanel.add(orderBox);
        add(new JScrollPane(orderPanel), BorderLayout.CENTER);
        
        repaint();
        revalidate();
    }
}
