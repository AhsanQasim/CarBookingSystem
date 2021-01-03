
import java.io.Serializable;


public class driverregb implements Serializable
{
    private Driver d;
    private bike v;
    
    driverregb()
    {
        d=new Driver();
        v=new bike();
    }
    
    driverregb(Driver a,bike c)
    {
        d=a;
        v=c;
    }

    public Driver getD() {
        return d;
    }

    public void setD(Driver d) {
        this.d = d;
    }

    public bike getV() {
        return v;
    }

    public void setV(bike v) {
        this.v = v;
    }
    public void display()
    {
        d.display();
        v.display();
    }
}
