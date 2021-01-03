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

public class BookingcarGUI extends JFrame
{
    JButton but1;
    JButton but2;
    JTextField location;
    JLabel l1;
    
    JPanel p1;
    JPanel p2;
    
    BookingcarGUI(int a)
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
                ArrayList<driverregc> drivercarList=readAllData();
                Random rand = new Random();
                int  n = rand.nextInt(drivercarList.size()-1) + 0;
                driverregc g=drivercarList.get(n);
                user f=userList.get(k);
                int length = f1.length( );
                int bill=length*100;
                
                BookingCar b=new BookingCar(f,g,f1,bill);
                
                ObjectOutputStream OutputStream=null;
                {
                    try
                    {
                        ArrayList<BookingCar> BookingCarList=readAllData2();
                        BookingCarList.add(b);
                        OutputStream=new ObjectOutputStream(new FileOutputStream("BookingCarList.ser"));
                        for(int i=0 ; i<BookingCarList.size(); i++)
                        {
                            OutputStream.writeObject(BookingCarList.get(i));
                        }
                         
                       
                    } 
                    catch (IOException ex) 
                    {
                       JOptionPane.showMessageDialog(null,"Error");
                    }
                }
                BookingCarPortalGUI b1=new BookingCarPortalGUI(b);
                b.display();
                System.out.println("gggggggggg");
            
            }
            if(ae.getActionCommand().equals("Cancel"))
            {
                JOptionPane.showMessageDialog(new JFrame(),"Ride Cancelled");
                dispose();
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
    public ArrayList<driverregc> readAllData()
    {
        ArrayList<driverregc> DriverCarList=new ArrayList<driverregc>(0);
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
                    DriverCarList.add(myObj);
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
                    inputStream.close();
                }
            }
            catch (IOException e)
            {
                System.out.println("IO Exception while closing file");
            }
            return DriverCarList;
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
