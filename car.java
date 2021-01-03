
import java.io.Serializable;


public class car extends vehicle implements Serializable
{
    private String carname;
    private String manufacturer;
    private String model;
    
    
    car()
    {
        super();
        carname="jhv";
        model="hbd";
        manufacturer="jhdb";
    }
    car(int b,String c,String a, String d,String e)
    {
        super(b,c);
        carname=a;
        model=d;
        manufacturer=e;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    public void display()
    {
        System.out.println("name of the car: "+carname);
        System.out.println("model of the car is: "+model);
        System.out.println("manufacturer of the vehicle: "+manufacturer);
        super.display();
    }
    
}
