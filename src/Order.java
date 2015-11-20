public class Order
{
    private String name;
    private String phoneNumber;
    private double bill;
    
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
}