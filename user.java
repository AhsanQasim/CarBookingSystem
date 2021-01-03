
import java.io.Serializable;


public class user extends person implements Serializable
{
    public String address;
    public String email;
    public String phone;
    
    user()
    {
        super();
        address="mb";
        email="kjkbc";
        phone="mhc";
        
    }
    user(String a,int b,String c,String d,String e,String f)
    {
        super(a,b,c);
        address=d;
        email=e;
        phone=f;
        
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
    
    public void display()
    {
        
        super.display();
        System.out.println("Address of driver is: "+address);
        System.out.println("Phonw number of driver is: "+phone);
        System.out.println("Email of driver is: "+email);
        
        
    }
}
