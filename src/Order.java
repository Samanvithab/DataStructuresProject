import java.util.ArrayList;

public class Order
{
    private String name;
    private String phoneNumber;
    private double bill;
    private ArrayList<Item> itemList;
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setPhoneNumber(String number)
    {
        this.phoneNumber = number;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    @Override
    public String toString()
    {
        return name + " " + phoneNumber;
    }
    
    public void addItem(Item newItem) {
    	itemList.add(newItem);
    }
    
    public ArrayList<Item> getItemList() {
    	return itemList;
    }
}
