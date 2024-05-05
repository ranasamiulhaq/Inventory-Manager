
package IMS;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class SellCableWindow extends JFrame implements Serializable {
    Container c;
    JLabel welcome_msg;
    JLabel select_choice;
    JButton Android;
    JButton ThunderBolt;
    JButton TypeC;
    JButton Back;
    JPanel p1;

    public SellCableWindow() {
        c = this.getContentPane();
        c.setLayout(null);
        setTitle("FlexiFits");
        setSize(650, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        c.setBackground(java.awt.Color.DARK_GRAY);
        welcome_msg = new JLabel("Inventory Regulation System");
        select_choice = new JLabel("Select the cable type");
        Android = new JButton("Android");
        ThunderBolt = new JButton("Thunderbolt");
        TypeC = new JButton("Type-C");
        Back= new JButton("Back");
        p1= new JPanel();
        welcome_msg.setBounds(50, 30, 650, 50);
        welcome_msg.setFont(new Font("SansSerif", Font.BOLD, 40));
        welcome_msg.setForeground(java.awt.Color.orange);
        select_choice.setBounds(140, 180, 500, 50);
        select_choice.setFont(new Font("Saif", Font.ROMAN_BASELINE, 40));
        select_choice.setForeground(java.awt.Color.ORANGE);
        Android.setBounds(195, 270, 250, 50);
        Android.setFont(new Font("Saif", Font.BOLD, 30));
        Android.setForeground(java.awt.Color.black);
        Android.setBackground(java.awt.Color.ORANGE);
        ThunderBolt.setBounds(195, 370, 250, 50);
        ThunderBolt.setFont(new Font("Saif", Font.BOLD, 30));
        ThunderBolt.setForeground(java.awt.Color.black);
        ThunderBolt.setBackground(java.awt.Color.ORANGE);
        TypeC.setBounds(195, 470, 250, 50);
        TypeC.setFont(new Font("Saif", Font.BOLD, 30));
        TypeC.setForeground(java.awt.Color.black);
        TypeC.setBackground(java.awt.Color.ORANGE);
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
        c.add(Android);
        c.add(ThunderBolt);
        c.add(TypeC);
        c.add(Back);
        CableType c= new CableType();
        Back.addActionListener(c);
        setVisible(true);
        Android.addActionListener(c);
        ThunderBolt.addActionListener(c);
        TypeC.addActionListener(c);
    }

    class CableType implements ActionListener{

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (e.getActionCommand().equals("Back")){
                new SellProductWindow();
                dispose();
                
            }
            else if (e.getActionCommand().equals("Android")){
                new SellAndroidCables();
                dispose();
            }
            else if (e.getActionCommand().equals("Thunderbolt")){
                //new SellThunderCables();
            dispose();
            }
            
            else if (e.getActionCommand().equals("Type-C")){
                //new SellTypeCCables();
            dispose();
            }
        }
       
    }
}
