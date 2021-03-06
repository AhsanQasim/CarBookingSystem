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

public class EditmyprofileBikeGUI extends JFrame
{
    private JButton name;
    private JButton age;
    private JButton DOB;
    private JButton Address;
    private JButton Email;
    private JButton phone;
    private JButton weakness;
    private JButton goodat;
    
    
    
    EditmyprofileBikeGUI(int a)
    {
        
        setLayout(new FlowLayout());
        setSize(400,400);
        setVisible(true);
        getContentPane().setBackground(Color.decode("#c6efaa"));
        name=new JButton("Change Name");
        age=new JButton("Change Age");
        DOB=new JButton("Change Date of Birth");
        Address=new JButton("Change Address");
        Email=new JButton("Change Email");
        phone=new JButton("Change Phone");
        weakness=new JButton("Change Weakness");
        goodat=new JButton("Change Good at");
        
        MyActionListener a1=new MyActionListener(a);
        
        name.addActionListener(a1);
        age.addActionListener(a1);
        DOB.addActionListener(a1);
        Address.addActionListener(a1);
        Email.addActionListener(a1);
        phone.addActionListener(a1);
        weakness.addActionListener(a1);
        goodat.addActionListener(a1);
        
        add(name);
        add(age);
        add(DOB);
        add(Address);
        add(Email);
        add(phone);
        add(weakness);
        add(goodat);
        
        
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
            if(ae.getActionCommand().equals("Change Name"))
            {
                changenameGUI2 a=new changenameGUI2(k);
            }
            if(ae.getActionCommand().equals("Change Age"))
            {
                changeageGUI2 b=new changeageGUI2(k);
            }
            if(ae.getActionCommand().equals("Change Date of Birth"))
            {
                changeDOBGUI2 c=new changeDOBGUI2(k);
            }
            if(ae.getActionCommand().equals("Change Address"))
            {
                changeaddressGUI2 d=new changeaddressGUI2(k);
            }
            if(ae.getActionCommand().equals("Change Email"))
            {
                 changeemailGUI2 d=new changeemailGUI2(k);
            }
            if(ae.getActionCommand().equals("Change Phone"))
            {
                 changephoneGUI2 d=new changephoneGUI2(k);
            }
            if(ae.getActionCommand().equals("Change Weakness"))
            {
                 changeweaknessGUI2 d=new changeweaknessGUI2(k);
            }
            if(ae.getActionCommand().equals("Change Good at"))
            {
                 changegoodatGUI2 d=new changegoodatGUI2(k);
            }
        }
    }
}
