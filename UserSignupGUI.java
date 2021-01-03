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


public class UserSignupGUI extends JFrame
{
    JLabel Label1;
    JLabel Label2;
    JLabel Label3;
    JLabel Label4;
    JLabel Label5;
    JLabel Label6;
    
    
    JTextField Name;
    JTextField Age;
    JTextField DOB;
    JTextField Address;
    JTextField Email;
    JTextField Phone;
   
    
    
    JPanel p1;
    JPanel p2;
    
    JButton submit;
    JButton cancel;
    
     UserSignupGUI()
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
        p2.setBackground(Color.decode("#c6efaa"));
        
        Label1=new JLabel("Name:");
        Label2=new JLabel("Age:");
        Label3=new JLabel("Date of birth:");
        Label4=new JLabel("Address:");
        Label5=new JLabel("Email:");
        Label6=new JLabel("Phone:");
       
        
        Name=new JTextField(15);
        Age=new JTextField(15);
        DOB=new JTextField(15);
        Address=new JTextField(15);
        Email=new JTextField(15);
        Phone=new JTextField(15);
        
        
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
                
                
                user a=new user(f1,f2,f3,f4,f5,f6);
                
                ObjectOutputStream OutputStream=null;
                {
                    try
                    {
                        ArrayList<user> userList=readAllData();
                        userList.add(a);
                        OutputStream=new ObjectOutputStream(new FileOutputStream("userList.ser"));
                        for(int i=0 ; i<userList.size(); i++)
                        {
                            OutputStream.writeObject(userList.get(i));
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
    }
    
}
