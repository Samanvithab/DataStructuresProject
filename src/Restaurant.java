public class Restaurant
{
    private String name;
    // private Menu menu;
    private Kitchen kitchen;
    private PickUpList pickUpList;
    
    public Restaurant(String name)
    {
        this.name = name;
        kitchen = new Kitchen();
        pickUpList = new PickUpList();
    }
    
    public void sendOrder(Order aOrder)
    {
        kitchen.addOrder(aOrder);
    }
    
    public String getName()
    {
        return name;
    }
    
    public Kitchen getKitchen()
    {
        return kitchen;
    }
    
    public PickUpList getPickUpList()
    {
        return pickUpList;
    }
}