
import java.io.Serializable;


public class BookingBike implements Serializable
{
    private user a;
    private driverregb g;
    private String location;
    private int bill;
    
    BookingBike()
    {
        a=new user();
        g=new driverregb();
        location="kkjjbk";
        bill=1000;
        
    }
    BookingBike(user s,driverregb g1,String r,int e)
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

    public driverregb getG() {
        return g;
    }

    public void setG(driverregb g) {
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
