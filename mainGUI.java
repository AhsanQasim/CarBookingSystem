
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class mainGUI extends JFrame
{
    JButton but1;
    JButton but2;
    JButton but3;
    
    JPanel p1;
    JLabel Background;
    
    mainGUI()
    {
        
        setSize(100,100);
        setVisible(true);
        setLayout(new BorderLayout());
        Background=new JLabel(new ImageIcon("Logo.png"));
        Background.setLayout(new BorderLayout());
        add(Background);
        but1=new JButton("Driver");
        but2=new JButton("user");
        but3=new JButton("Cancel");
        p1=new JPanel();
        p1.setOpaque(false);
        p1.setLayout(new FlowLayout());
        MyActionListener al=new MyActionListener();
	but1.addActionListener(al);
	but2.addActionListener(al);
        but3.addActionListener(al);
        
        p1.add(but1);
        p1.add(but2);
        p1.add(but3);
        Background.add(p1,BorderLayout.NORTH);
    }
    class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("Cancel"))
            {
                System.exit(1);
            }
            else if(ae.getActionCommand().equals("Driver"))
            {
                DriverGUI d=new DriverGUI();
            }
            else if(ae.getActionCommand().equals("user"))
            {
                UserGUI u=new UserGUI();
            }
            
        }
    }

    
}
