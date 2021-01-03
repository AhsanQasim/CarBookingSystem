
import java.io.Serializable;


public class vehicle implements Serializable
{
    private int rgno;
    private String color;
    
    vehicle()
    {
        rgno=89;
       
        color="hjh";
    }
    vehicle(int b,String c)
    {
        
        rgno=b;
        color=c;
        
    }

    public int getRgno() {
        return rgno;
    }

    public void setRgno(int rgno) {
        this.rgno = rgno;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public void display()
    {
        System.out.println("registration no. is: "+rgno);
        System.out.println("color is: "+color );
    }
    
}
