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


public class DriveCarlogin extends JFrame
{
    private JButton submit;
    private JButton cancel;
    private JLabel email;
    private JLabel phone;
    private JTextField textemail;
    private JTextField textphone;
    
    DriveCarlogin()
    {
        setTitle("Car Driver LogIn");
        setSize(400,400);
        setVisible(true);
        setLayout(new FlowLayout());
        getContentPane().setBackground(Color.decode("#c6efaa"));
        submit=new JButton("Submit");
        cancel=new JButton("Cancel");
        email=new JLabel("Email ");
        phone=new JLabel("Phone ");
        textemail=new JTextField(20);
        textphone=new JTextField(20);
        MyActionListener ae=new MyActionListener();
        submit.addActionListener(ae);
        cancel.addActionListener(ae);
        this.add(email);
        this.add(textemail);
        this.add(phone);
        this.add(textphone);
        this.add(submit);
        this.add(cancel);
    }
    
    public class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae) 
        {
            if(ae.getActionCommand().equals("Submit"))
            {
                        ArrayList<driverregc> DriverCarList=readAllData();
                        
                        boolean verified=false;
                        int doc=0;
                        for(int i=0; i<DriverCarList.size(); i++)
                        {
                            
                            if(textemail.getText().equals((DriverCarList.get(i)).getD().getEmail()) && textphone.getText().equals((DriverCarList.get(i)).getD().getPhone()))
                            {
                                System.out.println("hi");
                                verified=true;
                                doc=i;
                                break;
                            }
                            else
                            {
                                verified=false;
                            }
                        }
                        if(verified==true)
                        {
                            driverregc D=DriverCarList.get(doc);
                             DriverCarloginportal DP=new  DriverCarloginportal(doc);
                            dispose();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Invalid Email or Password");
                        }
                    
                    
                
                dispose();
            }
            if(ae.getActionCommand().equals("Cancel"))
            {
                JOptionPane.showMessageDialog(new JFrame(),"Sign In Cancelled");
                dispose();
            }
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
}
