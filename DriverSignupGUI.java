import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DriverSignupGUI extends JFrame
{
    
    
    JRadioButton b1;
    JRadioButton b2;
    JRadioButton b3;
    JLabel Labe1;
    
    DriverSignupGUI()
    {
        setLayout(new FlowLayout());
        setSize(400,400);
        setVisible(true);
        getContentPane().setBackground(Color.decode("#c6efaa"));
	b1=new JRadioButton("Bike");
        b2=new JRadioButton("Car");
        b3=new JRadioButton("Cancel");
        Labe1=new JLabel("Choose one of the below mentioned option");
        
        CheckBoxHandler handler=new CheckBoxHandler();
        b1.addItemListener(handler);
        b2.addItemListener(handler);
        b3.addItemListener(handler);
        
        add(Labe1);
        add(b1);
        add(b2);
        add(b3);
        
        ButtonGroup SingleButton=new ButtonGroup();
        SingleButton.add(b1);
        SingleButton.add(b2);
        SingleButton.add(b3);
        
        
    }
    class CheckBoxHandler implements ItemListener
    {
        public void itemStateChanged(ItemEvent ie)
        {
            
            if(b1.isSelected())
            {
                DriverBikeSignupGUI b=new DriverBikeSignupGUI();
            }
            else if(b2.isSelected())
            {
                DriverCarSignupGUI a=new DriverCarSignupGUI();
            }
            else if(b3.isSelected())
            {
                System.exit(1);
            }
            
        }
    }
}
