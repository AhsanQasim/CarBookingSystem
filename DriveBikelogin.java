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

public class DriveBikelogin extends JFrame
{
    private JButton submit;
    private JButton cancel;
    private JLabel email;
    private JLabel phone;
    private JTextField textemail;
    private JTextField textphone;
    
    DriveBikelogin()
    {
        setTitle("Bike Driver LogIn");
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
                {
                    ObjectOutputStream OutputStream=null;
                    try
                    {
                        ArrayList<driverregb> DriverBikeList=readAllData();
                        OutputStream=new ObjectOutputStream(new FileOutputStream("DriverBikeList.ser"));
                        for(int i=0 ; i<DriverBikeList.size(); i++)
                        {
                            OutputStream.writeObject(DriverBikeList.get(i));
                        }
                        boolean verified=false;
                        int doc=0;
                        for(int i=0; i<DriverBikeList.size(); i++)
                        {
                            
                            if(textemail.getText().equals((DriverBikeList.get(i)).getD().getEmail()) && textphone.getText().equals((DriverBikeList.get(i)).getD().getPhone()))
                            {
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
                            driverregb D=DriverBikeList.get(doc);
                             DriverBikeloginPortal DP=new  DriverBikeloginPortal(doc);
                            dispose();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Invalid Email or Password");
                        }
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
                JOptionPane.showMessageDialog(new JFrame(),"Sign In Cancelled");
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
    
}
