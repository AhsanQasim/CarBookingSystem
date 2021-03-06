import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DriverBikeSignupGUI extends JFrame
{
    JLabel Label1;
    JLabel Label2;
    JLabel Label3;
    JLabel Label4;
    JLabel Label5;
    JLabel Label6;
    JLabel Label7;
    JLabel Label8;
    JLabel Label9;
    JLabel Label10;
    JLabel Label11;
    JLabel Label12;
    
    
    JTextField Name;
    JTextField Age;
    JTextField DOB;
    JTextField Address;
    JTextField Email;
    JTextField Phone;
    JTextField Weakness;
    JTextField Goodat;
    
    JTextField manufacturer;
    JTextField model;
    JTextField Regno;
    JTextField color;
    
    JPanel p1;
    JPanel p2;
    
    JButton submit;
    JButton cancel;
    
    DriverBikeSignupGUI()
    {
        super.setVisible(true);
        setSize(500,800);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.decode("#c6efaa"));
        p1=new JPanel();
        p1.setLayout(new GridLayout(13,2));
        p1.setBackground(Color.decode("#c6efaa"));
        p2=new JPanel();
        p2.setLayout(new FlowLayout());
        p1.setBackground(Color.decode("#c6efaa"));
        
        Label1=new JLabel("Name:");
        Label2=new JLabel("Age:");
        Label3=new JLabel("Date of birth:");
        Label4=new JLabel("Address:");
        Label5=new JLabel("Email:");
        Label6=new JLabel("Phone:");
        Label7=new JLabel("weakness:");
        Label8=new JLabel("Good at:");
        
        Label9=new JLabel("Manufacturer:");
        Label10=new JLabel("Model:");
        Label11=new JLabel("Reg no:");
        Label12=new JLabel("color:");
        
        Name=new JTextField(15);
        Age=new JTextField(15);
        DOB=new JTextField(15);
        Address=new JTextField(15);
        Email=new JTextField(15);
        Phone=new JTextField(15);
        Weakness=new JTextField(15);
        Goodat=new JTextField(15);
        
        manufacturer=new JTextField(15);
        model=new JTextField(15);
        Regno=new JTextField(15);
        color=new JTextField(15);
        
        MyActionListener al=new MyActionListener();
        submit=new JButton("Submit");
        cancel=new JButton("Cancel");
        submit.addActionListener(al);
        cancel.addActionListener(al);
        
        p1.add(Label1);
        p1.add(Name);
        p1.add(Label2);
        p1.add(Age);
        p1.add(Label3);
        p1.add(DOB);
        p1.add(Label4);
        p1.add(Address);
        p1.add(Label5);
        p1.add(Email);
        p1.add(Label6);
        p1.add(Phone);
        p1.add(Label7);
        p1.add(Weakness);
        p1.add(Label8);
        p1.add(Goodat);
        
        
        p1.add(Label9);
        p1.add(manufacturer);
        p1.add(Label10);
        p1.add(model);
        p1.add(Label11);
        p1.add(Regno);
        p1.add(Label12);
        p1.add(color);
        
        add(p1,BorderLayout.NORTH);
        p2.add(submit);
        p2.add(cancel);
        add(p2);
        add(p2,BorderLayout.SOUTH);


    }
    public class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae) 
        {
            if(ae.getActionCommand().equals("Submit"))
            {
                String f1=Name.getText();
                int f2=Integer.parseInt(Age.getText());
                String f3=DOB.getText();
                String f4=Address.getText();
                String f5=Email.getText();
                String f6=Phone.getText();
                String f7=Weakness.getText();
                String f8=Goodat.getText();
                
                String f10=manufacturer.getText();
                String f11=model.getText();
                int f12=Integer.parseInt(Regno.getText());
                String f13=color.getText();
                
                driverregb a=new driverregb(new Driver(f1,f2,f3,f4,f5,f6,f7,f8),new bike(f12,f13,f10,f11));
                
                ObjectOutputStream OutputStream=null;
                {
                    try
                    {
                        ArrayList<driverregb> DriverBikeList=readAllData();
                        DriverBikeList.add(a);
                        OutputStream=new ObjectOutputStream(new FileOutputStream("DriverBikeList.ser"));
                        for(int i=0 ; i<DriverBikeList.size(); i++)
                        {
                            OutputStream.writeObject(DriverBikeList.get(i));
                        }
                        JOptionPane.showMessageDialog (null,"Record Saved","Information",JOptionPane.INFORMATION_MESSAGE); 
                    } 
                    catch (IOException ex) 
                    {
                       JOptionPane.showMessageDialog(null,"Error");
                    }
                }
                dispose();
            }
            if(ae.getActionCommand().equals("Cancel"))
            {
                JOptionPane.showMessageDialog(new JFrame(),"Sign Up Cancelled");
                dispose();
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
    }
    
}
