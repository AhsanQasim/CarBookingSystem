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

public class EditMyBikeGUI extends JFrame
{
   
    private JButton age;
    private JButton DOB;
    private JButton Address;
    private JButton Email;
    
    
    EditMyBikeGUI(int a)
    {
        
        setLayout(new FlowLayout());
        setSize(400,400);
        setVisible(true);
        getContentPane().setBackground(Color.decode("#c6efaa"));
        age=new JButton("Change manufacturer");
        DOB=new JButton("Change model");
        Address=new JButton("Change Registration No");
        Email=new JButton("Change Color");
        
        
        MyActionListener a1=new MyActionListener(a);
        
        
        age.addActionListener(a1);
        DOB.addActionListener(a1);
        Address.addActionListener(a1);
        Email.addActionListener(a1);
        
        
        add(age);
        add(DOB);
        add(Address);
        add(Email);
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
            
            if(ae.getActionCommand().equals("Change manufacturer"))
            {
               changebikeManufacturerGUI y4=new changebikeManufacturerGUI(k);
            }
            if(ae.getActionCommand().equals("Change model"))
            {
                changebikemodelGUI c=new changebikemodelGUI(k);
            }
            if(ae.getActionCommand().equals("Change Registration No"))
            {
                changebikeregGUI m=new changebikeregGUI(k);
            }
            if(ae.getActionCommand().equals("Change Color"))
            {
                 changebikecolorGUI hr=new changebikecolorGUI(k);
            }
            
        }
    }
        
}
