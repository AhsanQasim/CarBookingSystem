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

public class EditmycarGUI extends JFrame
{
    private JButton name;
    private JButton age;
    private JButton DOB;
    private JButton Address;
    private JButton Email;
    
    
    EditmycarGUI(int a)
    {
        
        setLayout(new FlowLayout());
        setSize(400,400);
        setVisible(true);
        getContentPane().setBackground(Color.decode("#c6efaa"));
        name=new JButton("Change Car Name");
        age=new JButton("Change manufacturer");
        DOB=new JButton("Change model");
        Address=new JButton("Change Registration No");
        Email=new JButton("Change Color");
        
        
        MyActionListener a1=new MyActionListener(a);
        
        name.addActionListener(a1);
        age.addActionListener(a1);
        DOB.addActionListener(a1);
        Address.addActionListener(a1);
        Email.addActionListener(a1);
        
        add(name);
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
            if(ae.getActionCommand().equals("Change Car Name"))
            {
                changecarnameGUI a=new changecarnameGUI(k);
            }
            if(ae.getActionCommand().equals("Change manufacturer"))
            {
                changecarmunafacturerGUI b=new changecarmunafacturerGUI(k);
            }
            if(ae.getActionCommand().equals("Change model"))
            {
                changecarmodelGUI c=new changecarmodelGUI(k);
            }
            if(ae.getActionCommand().equals("Change Registration No"))
            {
                changecarregnoGUI d=new changecarregnoGUI(k);
            }
            if(ae.getActionCommand().equals("Change Color"))
            {
                 changecarcolorGUI d=new changecarcolorGUI(k);
            }
            
        }
    }
    
}
