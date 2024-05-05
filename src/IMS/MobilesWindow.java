
package IMS;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MobilesWindow extends JFrame implements Serializable {
    Container c;
    JLabel welcome_msg;
    JLabel select_choice;
    JButton Samsung;
    JButton Iphone;
    JButton Nokia;
    JButton Back;
    JPanel p1;

    public MobilesWindow() {
        c = this.getContentPane();
        c.setLayout(null);
        setTitle("FlexiFits");
        setSize(650, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        c.setBackground(java.awt.Color.DARK_GRAY);
        welcome_msg = new JLabel("Inventory Regulation System");
        select_choice = new JLabel("Select the Mobile type");
        Samsung = new JButton("Samsung");
        Iphone = new JButton("Iphone");
        Nokia = new JButton("Nokia");
        Back= new JButton("Back");
        p1= new JPanel();
        welcome_msg.setBounds(50, 30, 650, 50);
        welcome_msg.setFont(new Font("SansSerif", Font.BOLD, 40));
        welcome_msg.setForeground(java.awt.Color.orange);
        select_choice.setBounds(140, 180, 500, 50);
        select_choice.setFont(new Font("Saif", Font.ROMAN_BASELINE, 40));
        select_choice.setForeground(java.awt.Color.ORANGE);
        Samsung.setBounds(195, 270, 250, 50);
        Samsung.setFont(new Font("Saif", Font.BOLD, 30));
        Samsung.setForeground(java.awt.Color.black);
        Samsung.setBackground(java.awt.Color.ORANGE);
        Iphone.setBounds(195, 370, 250, 50);
        Iphone.setFont(new Font("Saif", Font.BOLD, 30));
        Iphone.setForeground(java.awt.Color.black);
        Iphone.setBackground(java.awt.Color.ORANGE);
        Nokia.setBounds(195, 470, 250, 50);
        Nokia.setFont(new Font("Saif", Font.BOLD, 30));
        Nokia.setForeground(java.awt.Color.black);
        Nokia.setBackground(java.awt.Color.ORANGE);
        Back.setBounds(510, 550, 100, 50);
        Back.setFont(new Font("Saif", Font.PLAIN, 20));
        Back.setForeground(java.awt.Color.black);
        Back.setBackground(java.awt.Color.LIGHT_GRAY);
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(java.awt.Color.lightGray);
        p1.setBounds(0, 100, 650, 50);
        c.add(p1);
        c.add(welcome_msg);
        c.add(select_choice);
        c.add(Samsung);
        c.add(Iphone);
        c.add(Nokia);
        c.add(Back);
        MobileType c= new MobileType();
        Back.addActionListener(c);
        setVisible(true);
        Samsung.addActionListener(c);
        Iphone.addActionListener(c);
        Nokia.addActionListener(c);
    }

    class MobileType implements ActionListener{

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (e.getActionCommand().equals("Back")){
                new AddProdWindow();
                dispose();
                
            }
            else if (e.getActionCommand().equals("Samsung")){
                new AddSamsungPhone();
                dispose();
            }
            else if (e.getActionCommand().equals("Iphone")){
                new AddIphonePhone();
            dispose();
            }
            
            else if (e.getActionCommand().equals("Nokia")){
                new AddNokiaPhone();
            dispose();
            }
        }
       
    }
}
