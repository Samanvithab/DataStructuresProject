import java.util.ArrayList;

/**
 * A meal order with customer information.
 */
public class Order
{
    private String name;
    private String phoneNumber;
    private ArrayList<Item> itemList;
    
    /**
     * Creates an empty order.
     */
    public Order() {
    	itemList = new ArrayList<Item>();
    }
    
    /**
     * Adds an item to the order.
     * @param item item to add
     */
    public void addItem(Item item) {
    	itemList.add(item);
    }
    
    /**
     * Removes an item from the order.
     * @param item item to remove
     */
    public void removeItem(Item item) {
        itemList.remove(item);
    }
    
    /**
     * Calculates total cost of order.
     * @return total cost of order
     */
    public double calculateBill() {
        int bill = 0;
    	for(Item i: itemList) {
    		bill += i.getQuantity()*i.getPrice();
    	}
    	return bill;
    }
    
    /**
     * Sets the name of the customer.
     * @param name name of customer
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Sets the phone number of the customer.
     * @param number phone number of customer
     */
    public void setPhoneNumber(String number)
    {
        this.phoneNumber = number;
    }
    
    /**
     * Gets the name of the customer.
     * @return name of customer
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Gets the phone number of the customer.
     * @return phone number of customer
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    /**
     * Gets the item list.
     * @return list of items
     */
    public ArrayList<Item> getItemList() {
    	return itemList;
    }
}
