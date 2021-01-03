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

public class DriverBikeloginPortal extends JFrame
{
    private JButton Myprofile;
    private JButton MyCar;
    private JButton signout;
    private JButton summary;
   
    public DriverBikeloginPortal(int a)
    {
        this.setTitle("Portal");
        this.setSize(400,400);
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        getContentPane().setBackground(Color.decode("#c6efaa"));
        Myprofile=new JButton("My Profile");
        MyCar=new JButton("My Bike");
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
                MyProfileBikeGUI t=new MyProfileBikeGUI(k);
            }
            if(ae.getActionCommand().equals("My Bike"))
            {
                MyBikeGUI g5=new MyBikeGUI(k);
            }
            if(ae.getActionCommand().equals("Summary"))
            {
                String s=null;
                String h;
                ArrayList<driverregb> DriverBikeList=readAllData();
                driverregb y=DriverBikeList.get(k);
                ArrayList<BookingBike> BookingBikeList=readAllData2();
                for(int n=0;n<BookingBikeList.size();n=n+1)
                {

                    if(y.getD().getPhone().equals(BookingBikeList.get(n).getA().getPhone()))
                    {
                        BookingBike s1=BookingBikeList.get(n);
                        driverregb h2=s1.getG();
                        Driver d1=h2.getD();
                        user d2=s1.getA();
                        bike c1=h2.getV();

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
    public ArrayList<driverregb> readAllData()
        {
        ArrayList<driverregb> DriverBikeList1=new ArrayList<driverregb>(0);
        ObjectInputStream inputStream = null;
        try
        {
            inputStream=new ObjectInputStream(new FileInputStream("DriverBikeList.ser"));
            boolean EOF=false;
            while(!EOF) 
            {
                try 
                {
                    driverregb myObj=(driverregb) inputStream.readObject();
                    DriverBikeList1.add(myObj);
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
            return DriverBikeList1;
        }
    }
    
     public ArrayList<BookingBike> readAllData2()
        {
        ArrayList<BookingBike> BookingBikeList1=new ArrayList<BookingBike>(0);
        ObjectInputStream inputStream = null;
        try
        {
            inputStream=new ObjectInputStream(new FileInputStream("BookingBikeList.ser"));
            boolean EOF=false;
            while(!EOF) 
            {
                try 
                {
                    BookingBike myObj=(BookingBike) inputStream.readObject();
                    BookingBikeList1.add(myObj);
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
            return BookingBikeList1;
        }
    }
}
