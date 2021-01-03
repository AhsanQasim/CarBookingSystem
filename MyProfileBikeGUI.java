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

public class MyProfileBikeGUI extends JFrame
{
    JRadioButton b1;
    JRadioButton b2;
    JRadioButton b3;
    JLabel Labe1;
    
    MyProfileBikeGUI(int a)
    {
        setLayout(new FlowLayout());
        setSize(400,400);
        setVisible(true);
        getContentPane().setBackground(Color.decode("#c6efaa"));
	b1=new JRadioButton("View My Information");
        b2=new JRadioButton("Edit My Information");
        b3=new JRadioButton("Cancel");
        Labe1=new JLabel("Choose one of the below mentioned option");
        
        CheckBoxHandler handler=new CheckBoxHandler(a);
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
         int k;
          public CheckBoxHandler(int x)
          {
              k=x;
          }
        public void itemStateChanged(ItemEvent ie)
        {
            
            if(b1.isSelected())
            {
               ViewmyprofileBikeGUI v=new ViewmyprofileBikeGUI(k);
            }
            else if(b2.isSelected())
            {
                EditmyprofileBikeGUI e=new EditmyprofileBikeGUI(k);
            }
            else if(b3.isSelected())
            {
                System.exit(1);
            }
            
        }
    }
}
