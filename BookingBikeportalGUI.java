
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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

public class BookingBikeportalGUI extends JFrame
{
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JButton Submit;
    private JButton cancel;
    private JButton bb1;
    
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    
    BookingBikeportalGUI(BookingBike g)
    {
        super.setVisible(true);
        setSize(500,800);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.decode("#c6efaa"));
        l1=new JLabel("Your ride is complete");
        l2=new JLabel(((g.getG()).getD()).getName()+"     "+((g.getG()).getV()).getManufacturer()+"     "+g.getLocation());
        l3=new JLabel("Your bill is: "+g.getBill());
        p1=new JPanel();
        p1.setLayout(new FlowLayout());
        p1.setBackground(Color.decode("#c6efaa"));
        p2=new JPanel();
        p2.setLayout(new FlowLayout());
        p2.setBackground(Color.decode("#c6efaa"));
        p3=new JPanel();
        p3.setLayout(new FlowLayout());
        p3.setBackground(Color.decode("#c6efaa"));
        
        Submit=new JButton("View Complete Details");
        cancel=new JButton("Cancel");
        MyActionListener ae=new MyActionListener(g);
        Submit.addActionListener(ae);
        cancel.addActionListener(ae);
        p1.add(l1);
       
        
        p2.add(l2);
        p2.add(l3);
        p3.add(Submit);
        p3.add(cancel);
        
        add(p1,BorderLayout.NORTH);
       
        add(p2,BorderLayout.CENTER);
        
        add(p3,BorderLayout.SOUTH);
    }
    public class MyActionListener implements ActionListener
    {
         BookingBike k;
          public MyActionListener(BookingBike x)
          {
              k=x;
          }
        public void actionPerformed(ActionEvent ae) 
        {
            if(ae.getActionCommand().equals("View Complete Details"))
            {
             Driver d=k.getG().getD();
             bike d1=k.getG().getV();
             JOptionPane.showMessageDialog (null,"Driver: "+"\n"+"name: "+d.getName()+"\n Age: "+d.getAge()+"\n Date of Birth: "+d.getDOB()+"\n Address: "+d.getAddress()+"\n Email: "+d.getEmail()+"\n Phone: "+d.getPhone()+"\n Weakness: "+d.getWeakness()+"\n Good at: "+d.getGoodat()+"Bike: \n"+"\n Bike Manufactureres are: "+d1.getManufacturer()+"\n Bike model is: "+d1.getModel()+"\n Bike Registration no is: "+d1.getRgno()+"\n Bike color is: "+d1.getColor()+"\n location: "+k.getLocation()+"\n Total bill: "+k.getBill(),"\n Information",JOptionPane.INFORMATION_MESSAGE);
             d.display();
                
            }
             if(ae.getActionCommand().equals("Cancel"))
            {
                JOptionPane.showMessageDialog(new JFrame(),"Cancelled");
                dispose();
            }
            
        }
    }
    
    
}
