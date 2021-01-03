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

public class ViewmyprofileBikeGUI extends JFrame
{
     ViewmyprofileBikeGUI(int a)
    {
        setLayout(new FlowLayout());
        setSize(400,400);
        setVisible(true);
        getContentPane().setBackground(Color.decode("#c6efaa"));
        ArrayList<driverregb> DriverBikeList=readAllData();
        
        driverregb f=DriverBikeList.get(a);
        Driver d=f.getD();
        JOptionPane.showMessageDialog (null,"name: "+d.getName()+"\n Age: "+d.getAge()+"\n Date of Birth: "+d.getDOB()+"\n Address: "+d.getAddress()+"\n Email: "+d.getEmail()+"\n Phone: "+d.getPhone()+"\n Weakness: "+d.getWeakness()+"\n Good at: "+d.getGoodat(),"\n Information",JOptionPane.INFORMATION_MESSAGE);
        d.display();
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
