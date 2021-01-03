import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserGUI extends JFrame
{
    JButton but1;
    JButton but2;
    JButton but3;
    
    JPanel p1;
    
    UserGUI()
    {
        setSize(400,400);
        setVisible(true);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.decode("#c6efaa"));
        but1=new JButton("UserLogin");
        but2=new JButton("UserSignup");
        but3=new JButton("Cancel");
        p1=new JPanel();
        p1.setLayout(new FlowLayout());
        p1.setBackground(Color.decode("#c6efaa"));
        MyActionListener al=new MyActionListener();
	but1.addActionListener(al);
	but2.addActionListener(al);
        but3.addActionListener(al);
        
        p1.add(but1);
        p1.add(but2);
        p1.add(but3);
        add(p1,BorderLayout.NORTH);
    }
    class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("Cancel"))
            {
                System.exit(1);
            }
            else if(ae.getActionCommand().equals("UserLogin"))
            {
                userloginGUI t=new userloginGUI();
            }
            else if(ae.getActionCommand().equals("UserSignup"))
            {
                UserSignupGUI a=new UserSignupGUI();
            }
            
        }
    }
}
