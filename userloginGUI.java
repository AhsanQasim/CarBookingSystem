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

public class userloginGUI extends JFrame
{
    private JButton submit;
    private JButton cancel;
    private JLabel email;
    private JLabel phone;
    private JTextField textemail;
    private JTextField textphone;
    
    userloginGUI()
    {
        setTitle("User LogIn");
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
                
                    ObjectOutputStream OutputStream=null;
                    try
                    {
                        ArrayList<user> userList=readAllData();
                        OutputStream=new ObjectOutputStream(new FileOutputStream("userList.ser"));
                        for(int i=0 ; i<userList.size(); i++)
                        {
                            OutputStream.writeObject(userList.get(i));
                        }
                        boolean verified=false;
                        int doc=0;
                        for(int i=0; i<userList.size(); i++)
                        {
                            
                            if(textemail.getText().equals((userList.get(i)).getEmail()) && textphone.getText().equals((userList.get(i)).getPhone()))
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
                            user D=userList.get(doc);
                            userloginportalGUI DP=new  userloginportalGUI(doc);
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
                
                dispose();
            }
            if(ae.getActionCommand().equals("Cancel"))
            {
                JOptionPane.showMessageDialog(new JFrame(),"Sign In Cancelled");
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
    


