
import java.io.Serializable;


public class bike extends vehicle implements Serializable
{
    
    private String manufacturer;
    private String model;
    bike()
    {
        super();
       
        model="hbd";
        manufacturer="jhdb";
    }
    bike(int b,String c, String d,String e)
    {
        super(b,c);
        
        model=d;
        manufacturer=e;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    public void display()
    {
        
        
        System.out.println("model of the car is: "+model);
        System.out.println("manufacturer of the vehicle: "+manufacturer);
        super.display();
    
    }
}
