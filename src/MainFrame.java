
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

/**
 * Main frame to display simulator.
 */
public class MainFrame extends JFrame
{
    private static final int PANE_WIDTH = 900;
    private static final int PANE_HEIGHT = 500;
    
    /**
     * Creates the main frame holding internal frames.
     * @param restaurant restaurant to simulate
     */
    public MainFrame(Restaurant restaurant)
    {
        // create desktop pane
        JDesktopPane desktopPane = new JDesktopPane();
        setContentPane(desktopPane);
        getContentPane().setPreferredSize(
                new Dimension(PANE_WIDTH, PANE_HEIGHT));

        // create internal frames with size and position
        OrderFrame orderFrame = new OrderFrame(
                PANE_WIDTH / 3, PANE_HEIGHT, 0, 0, restaurant);
        KitchenFrame kitchenFrame = new KitchenFrame(
                PANE_WIDTH / 3, PANE_HEIGHT, PANE_WIDTH / 3, 0, restaurant);
        PickUpFrame pickUpFrame = new PickUpFrame(
                PANE_WIDTH/3, PANE_HEIGHT, PANE_WIDTH/3*2, 0, restaurant);
        
        // attach listeners
        restaurant.getKitchen().attach(kitchenFrame);
        restaurant.getPickUpList().attach(pickUpFrame);
        
        // add internal frames to desktop pane
        desktopPane.add(orderFrame);
        desktopPane.add(kitchenFrame);
        desktopPane.add(pickUpFrame);
        
        // set frame settings
        setTitle("Meal Ordering Simulator");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}