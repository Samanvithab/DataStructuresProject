
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

/**
 * Internal frame to show order frame.
 */
public class MenuFrame extends JInternalFrame
{
    private Restaurant restaurant;
    private Order order;
	private boolean buttonClicked = false;
	private MainFrame mainFrame;
	JPanel inputPanel = new JPanel();
	private int quantity;
    
    /**
     * Creates an internal order frame with specified settings.
     * @param xSize width of frame
     * @param ySize height of frame
     * @param xPos x position of frame
     * @param yPos y position of frame
     * @param rest restaurant to order from
     */
    public MenuFrame(int xSize, int ySize, int xPos, int yPos, Restaurant rest, MainFrame mainFrame, Order o)
    {
        super("Menu", false, false, true, false);
        setSize(xSize, ySize);
        setLocation(xPos, yPos);
        setLayout(new FlowLayout());
        setVisible(true);
        
        restaurant = rest;
        this.mainFrame = mainFrame;
        order = o;
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS));
        createComponents();
    }
    
    /**
     * Creates components in the frame.
     */
    private void createComponents()
    {
        JLabel welcome = new JLabel("Welcome to "
                + restaurant.getName() + "!");
        
        File drinks = new File("src/" + "Drinks.txt");
		JLabel d = new JLabel("Drinks");
		inputPanel.add(d);
		sett(drinks);
			
		File mainCourse = new File("src/" + "MainCourse.txt");
		JLabel m = new JLabel("Main Course");
		inputPanel.add(m);
		sett(mainCourse);
		
        JButton orderButton = new JButton("Finalize items");
        
        orderButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setValue(true);
        		mainFrame.refreshOrderFrame();
        		
        	}
        });
       
        this.setLayout(new BorderLayout());
        add(welcome, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(orderButton, BorderLayout.SOUTH);
        
    }
    
    public boolean getValue() {
    	return buttonClicked;
    }
    
    public void setValue(boolean b) {
    	buttonClicked = b;
    }
    
    public void sett(File food) {
    	try {
			Scanner in = new Scanner(food);
			while(in.hasNextLine()) {
				JPanel foodPanel = new JPanel();
				foodPanel.setLayout(new FlowLayout());
				String st = in.next();
				double price = Double.parseDouble(in.next());
				JLabel item = new JLabel("" + st + " $" + price);
				JButton more = new JButton("+");
				JButton less = new JButton("-");
				JLabel count = new JLabel(quantity + "");
				JButton ok = new JButton("OK");
				foodPanel.add(item);
				foodPanel.add(more);
				foodPanel.add(less);
				foodPanel.add(count);
				foodPanel.add(ok);
				inputPanel.add(foodPanel); 
				
				ActionListener moreAction = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						quantity++;
						count.setText(quantity + "");
					}
				};
				more.addActionListener(moreAction);
				
				ActionListener lessAction = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(quantity != 0) {
							quantity--;
							count.setText(quantity + "");
						}
					}
				};
				less.addActionListener(lessAction);
				
				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//foodPanel.remove(more);
						//foodPanel.remove(less);
						ok.setBackground(Color.red);
						ok.setForeground(Color.white);
						less.setForeground(Color.gray);
						more.setForeground(Color.gray);
						if(quantity != 0) {
							order.addItem(new Item(st, price, quantity));
							double total = price*quantity;
							ok.setText("$"+total);
							more.removeActionListener(moreAction);
							less.removeActionListener(lessAction);
							quantity = 0;
						}
					}
				});
			}
			in.close();
		} 
    	catch (FileNotFoundException e) {
			
			System.out.println("Error found! " + e.getMessage());
			
			if(e instanceof FileNotFoundException)
			{
				System.out.println("Unable to load the file");
			}	
		}	
    }
    
}
