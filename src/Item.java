public class Item
{
    private String name;
    private double price;
    private int quantity = 0;
    
    //constructor
    public Item(String n, double p, int q) {
    	name = n;
    	price = p;
    	quantity = q;
    }
    
    //getters    
    public String getName() {
    	return this.name;
    }
    
    public double getPrice() {
    	return price;
    }
    
    public int getQuantity() {
    	return quantity;
    }
    
    //setters
    public void setName(String n) {
    	this.name = n;
    }
    
    public void setPrice(double p) {
    	this.price = p;
    }
    
    public void setQuantity(int q) {
    	this.quantity = q;
    }
    
}
