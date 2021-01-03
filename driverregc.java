
import java.io.Serializable;


public class driverregc implements Serializable
{
    private Driver d;
    private car v;
    
    driverregc()
    {
        d=new Driver();
        v=new car();
    }
    
    driverregc(Driver a,car c)
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

    public car getV() {
        return v;
    }

    public void setV(car v) {
        this.v = v;
    }
    public void display()
    {
        d.display();
        v.display();
    }
}
