
import java.awt.*;
import javax.swing.*;

/**
 * Internal frame to show order frame.
 */
public class OrderFrame extends JInternalFrame
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
    public OrderFrame(int xSize, int ySize, int xPos, int yPos, Restaurant rest)
    {
        super("Order", false, false, true, false);
        setSize(xSize, ySize);
        setLocation(xPos, yPos);
        setLayout(new FlowLayout());
        setVisible(true);
        
        restaurant = rest;
        order = new Order();
        createComponents();
    }
    
    /**
     * Creates components in the frame.
     */
    private void createComponents()
    {
        JLabel welcome = new JLabel("Welcome to "
                + restaurant.getName() + "!");
        
        JLabel nameLabel = new JLabel("Name");
        JLabel phoneLabel = new JLabel("Phone Number");
        JTextField nameField = new JTextField(20);
        JTextField phoneField = new JTextField(20);
        JButton orderButton = new JButton("Place Order");
        
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS));
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(phoneLabel);
        inputPanel.add(phoneField);
        
        orderButton.addActionListener(event -> 
        {
            order.setName(nameField.getText());
            order.setPhoneNumber(phoneField.getText());
            restaurant.getKitchen().addOrder(order);
            order = new Order(); // create new order
        });

        add(welcome);
        add(inputPanel);
        add(orderButton);
    }
}