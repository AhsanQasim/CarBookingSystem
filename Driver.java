
import java.io.Serializable;


public class Driver extends person implements Serializable
{
    public String address;
    public String email;
    public String phone;
    public String weakness;
    public String goodat;
    
    Driver()
    {
        super();
        address="mb";
        email="kjkbc";
        phone="mhc";
        weakness="jbc";
        goodat="jbdjk";
    }
    Driver(String a,int b,String c,String d,String e,String f,String g,String h)
    {
        super(a,b,c);
        address=d;
        email=e;
        phone=f;
        weakness=g;
        goodat=h;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public String getGoodat() {
        return goodat;
    }

    public void setGoodat(String goodat) {
        this.goodat = goodat;
    }
    public void display()
    {
        
        super.display();
        System.out.println("Address of driver is: "+address);
        System.out.println("Phonw number of driver is: "+phone);
        System.out.println("Email of driver is: "+email);
        System.out.println("Driver is goood at: "+goodat);
        System.out.println("weakness of the driver is: "+weakness);
        
    
    }
    
}
