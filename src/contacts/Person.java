package contacts;

public class Person {
    //Attributes
    private String name;
    private String address;
    private String number;
    //Constructor 
    Person(String name, String address, String number)
    {
    this.name = name;
    this.address = address;
    this.number = number;
    }
    //Get and Set
    
    public void setname(String name)
    {
        this.name = name;
    }
    public String getname()
    {
        return name;
    }
    
    public void setaddress(String address)
    {
        this.address = address;
    }
    public String getaddress()
    {
        return address;
    }
    
    public void setnumber(String number)
    {
        this.number = number;
    }
    public String getnumber()
    {
        return number;
    }
    
}
