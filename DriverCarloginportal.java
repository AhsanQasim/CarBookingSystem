import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DriverCarloginportal extends JFrame
{
    private JButton Myprofile;
    private JButton MyCar;
    private JButton signout;
    private JButton summary;
   
    public DriverCarloginportal(int a)
    {
        this.setTitle("Portal");
        this.setSize(400,400);
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        getContentPane().setBackground(Color.decode("#c6efaa"));
        Myprofile=new JButton("My Profile");
        MyCar=new JButton("My Car");
        signout=new JButton("Sign Out");
        summary=new JButton("Summary");
        
        PortalListener ae=new PortalListener(a); 
        Myprofile.addActionListener(ae);
        MyCar.addActionListener(ae);
        summary.addActionListener(ae);
        
        signout.addActionListener(ae);
        this.add(Myprofile);
        this.add(MyCar);
        this.add(summary);
        
        this.add(signout);
    }
    
    public class PortalListener implements ActionListener
    {
          int k;
          public PortalListener(int x)
          {
              k=x;
          }
        public void actionPerformed(ActionEvent ae) 
        {
            if(ae.getActionCommand().equals("My Profile"))
            {
                MyprofileGUI a=new MyprofileGUI(k);
            }
            if(ae.getActionCommand().equals("My Car"))
            {
                MyCarGUI b=new MyCarGUI(k);
            }
            if(ae.getActionCommand().equals("Summary"))
            {
                String s=null;
                String h;
                ArrayList<driverregc> DriverCarList=readAllData();
                driverregc y=DriverCarList.get(k);
                ArrayList<BookingCar> BookingCarList=readAllData2();
                for(int n=0;n<BookingCarList.size();n=n+1)
                {

                    if(y.getD().getPhone().equals(BookingCarList.get(n).getA().getPhone()))
                    {
                        BookingCar s1=BookingCarList.get(n);
                        driverregc h2=s1.getG();
                        Driver d1=h2.getD();
                        user d2=s1.getA();
                        car c1=h2.getV();

                        h=((d2.getName())+"     "+d2.getEmail()+"     "+(s1.getLocation())+"    "+(s1.getBill())+"\n");
                         s=s+h;

                    }
                   
                }
                JOptionPane.showMessageDialog (null,s,"Information",JOptionPane.INFORMATION_MESSAGE);
       
            }
            
            if(ae.getActionCommand().equals("Signout"))
            {
                dispose();
            }
        }
    }
     public ArrayList<driverregc> readAllData()
        {
        ArrayList<driverregc> DriverCarList1=new ArrayList<driverregc>(0);
        ObjectInputStream inputStream = null;
        try
        {
            inputStream=new ObjectInputStream(new FileInputStream("DriverCarList.ser"));
            boolean EOF=false;
            while(!EOF) 
            {
                try 
                {
                    driverregc myObj=(driverregc) inputStream.readObject();
                    DriverCarList1.add(myObj);
                }
                catch (ClassNotFoundException e) 
                {

                }
                catch (EOFException end) 
                {
                    EOF = true;
                }
            }

        }
        catch(FileNotFoundException e)
        {
            
        }
        catch (IOException e)
        {

        }
        finally 
        {
            try 
            {
                if(inputStream != null)
                {
                    inputStream.close( );
                }
            }
            catch (IOException e)
            {
                System.out.println("IO Exception while closing file");
            }
            return DriverCarList1;
        }
    }
    public ArrayList<BookingCar> readAllData2()
        {
        ArrayList<BookingCar> BookingCarList1=new ArrayList<BookingCar>(0);
        ObjectInputStream inputStream = null;
        try
        {
            inputStream=new ObjectInputStream(new FileInputStream("BookingCarList.ser"));
            boolean EOF=false;
            while(!EOF) 
            {
                try 
                {
                    BookingCar myObj=(BookingCar) inputStream.readObject();
                    BookingCarList1.add(myObj);
                }
                catch (ClassNotFoundException e) 
                {

                }
                catch (EOFException end) 
                {
                    EOF = true;
                }
            }

        }
        catch(FileNotFoundException e)
        {
            
        }
        catch (IOException e)
        {

        }
        finally 
        {
            try 
            {
                if(inputStream != null)
                {
                    inputStream.close( );
                }
            }
            catch (IOException e)
            {
                System.out.println("IO Exception while closing file");
            }
            return BookingCarList1;
        }
    }
}
