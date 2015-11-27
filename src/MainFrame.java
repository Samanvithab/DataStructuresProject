
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
    private JDesktopPane desktopPane;
    private MenuFrame menuFrame;
    private KitchenFrame kitchenFrame;
    private PickUpFrame pickUpFrame;
    
    private static int PANE_WIDTH = 1200;
    private static int PANE_HEIGHT = 600;
    
    /**
     * Creates the main frame holding internal frames.
     * @param restaurant restaurant to simulate
     */
    public MainFrame(Restaurant restaurant)
    {
        // create desktop pane
        desktopPane = new JDesktopPane();
        desktopPane.addComponentListener(new DesktopPaneListener());
        setContentPane(desktopPane);
        getContentPane().setPreferredSize(
                new Dimension(PANE_WIDTH, PANE_HEIGHT));

        // create internal frames with size and position
        menuFrame = new MenuFrame(PANE_WIDTH / 3, PANE_HEIGHT, 0, 0, restaurant);
        kitchenFrame = new KitchenFrame(
                PANE_WIDTH / 3, PANE_HEIGHT, PANE_WIDTH / 3, 0, restaurant);
        pickUpFrame = new PickUpFrame(
                PANE_WIDTH/3, PANE_HEIGHT, PANE_WIDTH/3*2, 0, restaurant);
        
        // attach listeners
        restaurant.getKitchen().attach(kitchenFrame);
        restaurant.getPickUpList().attach(pickUpFrame);
        
        desktopPane.add(menuFrame);
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
     * Custom component listener for desktop pane to allow resizing.
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
