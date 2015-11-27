/**
 * An item with a name, price and quantity.
 */
public class Item implements Comparable
{
    private String name;
    private double price;
    private int quantity = 0;
    
    /**
     * Creates an item with a name and price.
     * @param name name of the item
     * @param price cost of the item
     */
    public Item(String name, double price) {
    	this.name = name;
    	this.price = price;
    }
    
    /**
     * Increments quantity by one.
     */
    public void increment()
    {
        quantity++;
    }
    
    /**
     * Decrements quantity by one if not zero.
     */
    public void decrement()
    {
        if (quantity != 0)
            quantity--;
    }
    
    /**
     * Get the name of the item.
     * @return name of item
     */    
    public String getName() {
    	return name;
    }
    
    /**
     * Get the price of the item.
     * @return price of item
     */
    public double getPrice() {
    	return price;
    }
    
    /**
     * Get the quantity of the item.
     * @return quantity of item
     */
    public int getQuantity() {
    	return quantity;
    }
    
    /**
     * Set the item's name.
     * @param name name to set
     */
    public void setName(String name) {
    	this.name = name;
    }
    
    /**
     * Set the item's price.
     * @param price price to set 
     */
    public void setPrice(double price) {
    	this.price = price;
    }
    
    /**
     * Set the item's quantity.
     * @param quantity quantity to set
     */
    public void setQuantity(int quantity) {
    	this.quantity = quantity;
    }

    /**
     * Compares an item.
     * @param item item to compare
     * @return 0 if same, 1 if greater, -1 if less
     */
    @Override
    public int compareTo(Object item)
    {
        return name.compareTo(((Item)item).getName());
    }
    
}
