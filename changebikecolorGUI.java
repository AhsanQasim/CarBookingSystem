
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

public class changebikecolorGUI extends JFrame
{
    private JButton Submit;
    private JButton cancel;
    
    private JLabel L1;
    private JTextField text;
    
    JPanel p1;
    JPanel p2;
    
    changebikecolorGUI(int a)
    {
        setLayout(new FlowLayout());
        setSize(400,400);
        setVisible(true);
        getContentPane().setBackground(Color.decode("#c6efaa"));
        L1=new JLabel("Enter bike Color: ");
        Submit=new JButton("Submit");
        cancel=new JButton("Cancel");
        text=new JTextField(20);
        p1=new JPanel();
        p1.setLayout(new FlowLayout());
        p1.setBackground(Color.decode("#c6efaa"));
        p2=new JPanel();
        p2.setLayout(new FlowLayout());
        p2.setBackground(Color.decode("#c6efaa"));
        
        MyActionListener ae=new MyActionListener(a);
        Submit.addActionListener(ae);
        cancel.addActionListener(ae);
        
        p1.add(L1);
        p1.add(text);
        
        p2.add(Submit);
        p2.add(cancel);
        
        add(p1,BorderLayout.NORTH);
       
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
                String f1=text.getText();
                ArrayList<driverregb> DriverBikeList=readAllData();
                driverregb f=DriverBikeList.get(k);
                bike d=f.getV();
                f.getV().setColor(f1);
                ObjectOutputStream OutputStream=null;
                {
                    try
                    {
                        DriverBikeList.set(k,f);
                        OutputStream=new ObjectOutputStream(new FileOutputStream("DriverBikeList.ser"));
                        for(int i=0 ; i<DriverBikeList.size(); i++)
                        {
                            OutputStream.writeObject(DriverBikeList.get(i));
                        }
                        JOptionPane.showMessageDialog (null,"Record updated","Information",JOptionPane.INFORMATION_MESSAGE);
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
                JOptionPane.showMessageDialog(new JFrame(),"Cancelled");
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

