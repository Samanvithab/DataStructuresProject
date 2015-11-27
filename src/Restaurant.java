
/**
 * Restaurant holds menu, kitchen and pick up list.
 */
public class Restaurant
{
    private String name;
    private Menu menu;
    private Kitchen kitchen;
    private PickUpList pickUpList;
    
    /**
     * Creates a restaurant with a name.
     * @param name name of the restaurant
     */
    public Restaurant(String name)
    {
        this.name = name;
        menu = new Menu();
        kitchen = new Kitchen();
        pickUpList = new PickUpList();
    }
    
    /**
     * Sends an order to the kitchen
     * @param aOrder the order
     */
    public void sendOrder(Order aOrder)
    {
        kitchen.addOrder(aOrder);
    }
    
    /**
     * Sets the restaurant's menu
     * @param newMenu menu for the restaurant
     */
    public void setMenu(Menu newMenu)
    {
        menu = newMenu;
    }
    
    /**
     * Gets the name of the restaurant.
     * @return name of kitchen
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Gets the menu of the restaurant.
     * @return the menu
     */
    public Menu getMenu()
    {
        return menu;
    }
    
    /**
     * Gets the kitchen of the restaurant.
     * @return the kitchen
     */
    public Kitchen getKitchen()
    {
        return kitchen;
    }
    
    /**
     * Gets the pick up list of the kitchen.
     * @return pick up list
     */
    public PickUpList getPickUpList()
    {
        return pickUpList;
    }
}