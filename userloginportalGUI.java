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

public class userloginportalGUI extends JFrame
{
    private JButton Myprofile;
    private JButton MyCar;
    private JButton signout;
    private JButton summary;
    
    userloginportalGUI(int doc)
    {
        this.setTitle("Portal");
        this.setSize(400,400);
        this.setVisible(true);
        getContentPane().setBackground(Color.decode("#c6efaa"));
        this.setLayout(new FlowLayout());
        Myprofile=new JButton("View my Profile ");
        MyCar=new JButton("Edit my Profile");
        signout=new JButton("Book a ride");
        summary=new JButton("Summary");
        
        PortalListener ae=new PortalListener(doc); 
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
            if(ae.getActionCommand().equals("View my Profile "))
            {
                ViewuserProfileGUI h=new ViewuserProfileGUI(k);
            }
            if(ae.getActionCommand().equals("Edit my Profile"))
            {
                edituserprofileGUI f=new edituserprofileGUI(k);
            }
            if(ae.getActionCommand().equals("Summary"))
            {
                String s=null;
                String h;
                ArrayList<user> userList=readAllData();
                user y=userList.get(k);
                ArrayList<BookingCar> BookingCarList=readAllData2();
                for(int n=0;n<BookingCarList.size();n=n+1)
                {

                    if(y.getPhone().equals(BookingCarList.get(n).getA().getPhone()))
                    {
                        BookingCar s1=BookingCarList.get(n);
                        driverregc h2=s1.getG();
                        Driver d1=h2.getD();
                        car c1=h2.getV();

                        h=((d1.getName())+"     "+(c1.getCarname())+"     "+(s1.getLocation())+"    "+(s1.getBill())+"\n");
                         s=s+h;

                    }
                   
                }
                JOptionPane.showMessageDialog (null,s,"Information",JOptionPane.INFORMATION_MESSAGE);
       
            }
            
            if(ae.getActionCommand().equals("Book a ride"))
            {
                BookingGUI w=new BookingGUI(k);
            }
        }
    }
    public ArrayList<user> readAllData()
        {
        ArrayList<user> userList1=new ArrayList<user>(0);
        ObjectInputStream inputStream = null;
        try
        {
            inputStream=new ObjectInputStream(new FileInputStream("userList.ser"));
            boolean EOF=false;
            while(!EOF) 
            {
                try 
                {
                    user myObj=(user) inputStream.readObject();
                    userList1.add(myObj);
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
            return userList1;
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
