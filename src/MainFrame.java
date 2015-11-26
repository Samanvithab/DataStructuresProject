
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

/**
 * Main frame to display simulator.
 */
public class MainFrame extends JFrame
{
	private Restaurant r;
    private JDesktopPane desktopPane;
    private OrderFrame orderFrame;
    private MenuFrame menuFrame;
    private KitchenFrame kitchenFrame;
    private PickUpFrame pickUpFrame;
    
    private static int PANE_WIDTH = 900;
    private static int PANE_HEIGHT = 500;
    private Order o = new Order();
    
    /**
     * Creates the main frame holding internal frames.
     * @param restaurant restaurant to simulate
     */
    public MainFrame(Restaurant restaurant)
    {
    	r = restaurant;
        // create desktop pane
        desktopPane = new JDesktopPane();
        desktopPane.addComponentListener(new DesktopPaneListener());
        setContentPane(desktopPane);
        getContentPane().setPreferredSize(
                new Dimension(PANE_WIDTH, PANE_HEIGHT));

        // create internal frames with size and position
      
        menuFrame = new MenuFrame(PANE_WIDTH / 3, PANE_HEIGHT, 0, 0, restaurant, this, o);
        orderFrame = new OrderFrame(PANE_WIDTH / 3, PANE_HEIGHT, 0, 0, restaurant, o);
        kitchenFrame = new KitchenFrame(
                PANE_WIDTH / 3, PANE_HEIGHT, PANE_WIDTH / 3, 0, restaurant);
        pickUpFrame = new PickUpFrame(
                PANE_WIDTH/3, PANE_HEIGHT, PANE_WIDTH/3*2, 0, restaurant);
        
        // attach listeners
        restaurant.getKitchen().attach(kitchenFrame);
        restaurant.getPickUpList().attach(pickUpFrame);
        
        // add internal frames to desktop pane
        //desktopPane.add(orderFrame);
        
        if(menuFrame.getValue()==true) {
        	desktopPane.remove(menuFrame);
        	desktopPane.add(orderFrame);
        }
        
        desktopPane.add(menuFrame);
        desktopPane.add(kitchenFrame);
        desktopPane.add(pickUpFrame);
        
        // set frame settings
        setTitle("Meal Ordering Simulator");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }  
    
    public void refreshMenuFrame() {
    	desktopPane = new JDesktopPane();
        desktopPane.addComponentListener(new DesktopPaneListener());
        setContentPane(desktopPane);
        getContentPane().setPreferredSize(
                new Dimension(PANE_WIDTH, PANE_HEIGHT));

        // create internal frames with size and position
        menuFrame = new MenuFrame(PANE_WIDTH / 3, PANE_HEIGHT, 0, 0, r, this, o);
        orderFrame = new OrderFrame(PANE_WIDTH / 3, PANE_HEIGHT, 0, 0, r, o);
        kitchenFrame = new KitchenFrame(
                PANE_WIDTH / 3, PANE_HEIGHT, PANE_WIDTH / 3, 0, r);
        pickUpFrame = new PickUpFrame(
                PANE_WIDTH/3, PANE_HEIGHT, PANE_WIDTH/3*2, 0, r);
        
        // attach listeners
        r.getKitchen().attach(kitchenFrame);
        r.getPickUpList().attach(pickUpFrame);
        
        // add internal frames to desktop pane
        //desktopPane.add(orderFrame);
        
      
        desktopPane.add(menuFrame);
        desktopPane.add(kitchenFrame);
        desktopPane.add(pickUpFrame);
        
        // set frame settings
        setTitle("Meal Ordering Simulator");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();


        setVisible(true);
    }

    
    public void refreshOrderFrame() {
    	desktopPane = new JDesktopPane();
        desktopPane.addComponentListener(new DesktopPaneListener());
        setContentPane(desktopPane);
        getContentPane().setPreferredSize(
                new Dimension(PANE_WIDTH, PANE_HEIGHT));

        // create internal frames with size and position
        orderFrame = new OrderFrame(
                PANE_WIDTH / 3, PANE_HEIGHT, 0, 0, r, o);
        menuFrame = new MenuFrame(
                PANE_WIDTH / 3, PANE_HEIGHT, 0, 0, r, this, o);
        
        kitchenFrame = new KitchenFrame(
                PANE_WIDTH / 3, PANE_HEIGHT, PANE_WIDTH / 3, 0, r);
        pickUpFrame = new PickUpFrame(
                PANE_WIDTH/3, PANE_HEIGHT, PANE_WIDTH/3*2, 0, r);
        
        // attach listeners
        r.getKitchen().attach(kitchenFrame);
        r.getPickUpList().attach(pickUpFrame);
        
        // add internal frames to desktop pane
        //desktopPane.add(orderFrame);
        
      
        desktopPane.add(orderFrame);
        desktopPane.add(kitchenFrame);
        desktopPane.add(pickUpFrame);
        
        // set frame settings
        setTitle("Meal Ordering Simulator");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    
    
    /**
     * Custom component listener for desktop pane.
     */
    private class DesktopPaneListener implements ComponentListener
    {
        @Override
        public void componentResized(ComponentEvent ce)
        {
            // get new size
            PANE_WIDTH = getContentPane().getWidth();
            PANE_HEIGHT = getContentPane().getHeight();

            // resize internal frames
            orderFrame.setBounds(0, 0, PANE_WIDTH / 3, PANE_HEIGHT);
            menuFrame.setBounds(0, 0, PANE_WIDTH / 3, PANE_HEIGHT);
            
           
            kitchenFrame.setBounds(PANE_WIDTH / 3, 0, PANE_WIDTH / 3, PANE_HEIGHT);
            pickUpFrame.setBounds(PANE_WIDTH/3*2, 0, PANE_WIDTH/3, PANE_HEIGHT);
        }

        @Override
        public void componentMoved(ComponentEvent ce) {}
        @Override
        public void componentShown(ComponentEvent ce) {}

        @Override
        public void componentHidden(ComponentEvent ce) {}
    }
}
