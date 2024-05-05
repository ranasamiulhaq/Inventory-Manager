package IMS;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class AdaptersWindow extends JFrame implements Serializable {
    Container c;
    JLabel welcome_msg;
    JLabel select_choice;
    JButton Android;
    JButton Lightning;
    JButton TypeC;
    JButton Back;
    JPanel p1;

    public AdaptersWindow() {
        c = this.getContentPane();
        c.setLayout(null);
        setTitle("FlexiFits");
        setSize(650, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        c.setBackground(java.awt.Color.DARK_GRAY);
        welcome_msg = new JLabel("Inventory Regulation System");
        select_choice = new JLabel("Select the Adapter type");
        Android = new JButton("Android");
        Lightning = new JButton("Lightning");
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
        Lightning.setBounds(195, 370, 250, 50);
        Lightning.setFont(new Font("Saif", Font.BOLD, 30));
        Lightning.setForeground(java.awt.Color.black);
        Lightning.setBackground(java.awt.Color.ORANGE);
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
        c.add(Lightning);
        c.add(TypeC);
        c.add(Back);
        
        AdaptersType c= new AdaptersType();
        Back.addActionListener(c);
        setVisible(true);
        Android.addActionListener(c);
        Lightning.addActionListener(c);
        TypeC.addActionListener(c);
    }

    class AdaptersType implements ActionListener{
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (e.getActionCommand().equals("Back")){
                new AddProdWindow();
                dispose();
            }
            else if (e.getActionCommand().equals("Android")){
                new AddAndroidAdapters();
                dispose();
            }
            else if (e.getActionCommand().equals("Lightning")){
                new AddLightningAdapters();
                dispose();
            }
            
            else if (e.getActionCommand().equals("Type-C")){
                new AddTypeCAdapters();
            dispose();
            }
        }
       
    }
}
