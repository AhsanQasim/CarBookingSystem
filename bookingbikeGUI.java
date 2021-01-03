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
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class bookingbikeGUI extends JFrame
{
    JButton but1;
    JButton but2;
    JTextField location;
    JLabel l1;
    
    JPanel p1;
    JPanel p2;
    
    bookingbikeGUI(int a)
    {
        super.setVisible(true);
        setSize(500,800);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.decode("#c6efaa"));
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,2));
        p1.setBackground(Color.decode("#c6efaa"));
        p2=new JPanel();
        p2.setLayout(new FlowLayout());
        p2.setBackground(Color.decode("#c6efaa"));
        
        l1=new JLabel("Enter Your Location: ");
        
        location=new JTextField(15);
        
        MyActionListener al=new MyActionListener(a);
        but1=new JButton("Submit");
        but2=new JButton("Cancel");
        but1.addActionListener(al);
        but2.addActionListener(al);
        
        p1.add(l1);
        p1.add(location);
        
        add(p1,BorderLayout.NORTH);
        p2.add(but1);
        p2.add(but2);
        add(p2);
        add(p2,BorderLayout.SOUTH);
    }
    
     public class MyActionListener implements ActionListener
    {
        int k;
          public MyActionListener(int x)
          {
              k=x;
          }
        public void actionPerformed(ActionEvent ae) 
        {
            if(ae.getActionCommand().equals("Submit"))
            {
                String f1=location.getText();
                ArrayList<user> userList=readAllData1();
                ArrayList<driverregb> driverBikeList=readAllData();
                Random rand = new Random();
                int  n = rand.nextInt(driverBikeList.size()-1) + 0;
                driverregb g=driverBikeList.get(n);
                user f=userList.get(k);
                int length = f1.length( );
                int bill=length*10;
                
                BookingBike b=new BookingBike(f,g,f1,bill);
                
                ObjectOutputStream OutputStream=null;
                {
                    try
                    {
                        ArrayList<BookingBike> BookingbikeList=readAllData2();
                        BookingbikeList.add(b);
                        OutputStream=new ObjectOutputStream(new FileOutputStream("BookingBikeList.ser"));
                        for(int i=0 ; i<BookingbikeList.size(); i++)
                        {
                            OutputStream.writeObject(BookingbikeList.get(i));
                        }
                         
                       
                    } 
                    catch (IOException ex) 
                    {
                       JOptionPane.showMessageDialog(null,"Error");
                    }
                }
                BookingBikeportalGUI b1=new BookingBikeportalGUI(b);
                b.display();
                System.out.println("nnnnn");
            }
        }
     }
     public ArrayList<user> readAllData1()
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
