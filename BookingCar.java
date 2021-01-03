
import java.io.Serializable;


public class BookingCar implements Serializable
{
    private user a;
    private driverregc g;
    private String location;
    private int bill;
    
    BookingCar()
    {
        a=new user();
        g=new driverregc();
        location="kkjjbk";
        bill=1000;
        
    }
    BookingCar(user s,driverregc g1,String r,int e)
    {
        a=s;
        g=g1;
        location=r;
        bill=e;
    }

    public user getA() {
        return a;
    }

    public void setA(user a) {
        this.a = a;
    }

    public driverregc getG() {
        return g;
    }

    public void setG(driverregc g) {
        this.g = g;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }
    
    public void display()
    {
        a.display();
        g.display();
        System.out.println("loction of the ride is: "+location);
        System.out.println("total bill is: "+bill);
    }
    
}
