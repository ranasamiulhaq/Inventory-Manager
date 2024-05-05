package IMS;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class AddProdWindow extends JFrame implements Serializable{
     Container c;
    JLabel welcome_msg;
    JLabel select_choice;
    JButton Cables , Adapters , Mobiles , Back , home;
    JPanel p1;

    public AddProdWindow() {
        c = this.getContentPane();
        c.setLayout(null);
        setTitle("FlexiFits");
        setSize(650, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        c.setBackground(java.awt.Color.DARK_GRAY);
        welcome_msg = new JLabel("Inventory Regulation System");
        select_choice = new JLabel("Select the choice");
        Cables = new JButton("Cables");
        Adapters = new JButton("Adapters");
        Mobiles = new JButton("Mobiles");
        Back = new JButton("Back");
        home= new JButton("Home");
        welcome_msg.setBounds(50, 30, 650, 50);
        welcome_msg.setFont(new Font("SansSerif", Font.BOLD, 40));
        welcome_msg.setForeground(java.awt.Color.orange);
        
        select_choice.setBounds(170, 180, 500, 50);
        select_choice.setFont(new Font("Saif", Font.ROMAN_BASELINE, 40));
        select_choice.setForeground(java.awt.Color.ORANGE);
        Cables.setBounds(195, 270, 250, 50);
        Cables.setFont(new Font("Saif", Font.BOLD, 30));
        Cables.setForeground(java.awt.Color.black);
        Cables.setBackground(java.awt.Color.ORANGE);
        Adapters.setBounds(195, 370, 250, 50);
        Adapters.setFont(new Font("Saif", Font.BOLD, 30));
        Adapters.setForeground(java.awt.Color.black);
        Adapters.setBackground(java.awt.Color.ORANGE);
        Mobiles.setBounds(195, 470, 250, 50);
        Mobiles.setFont(new Font("Saif", Font.BOLD, 30));
        Mobiles.setForeground(java.awt.Color.black);
        Mobiles.setBackground(java.awt.Color.ORANGE);

        home.setBounds(50, 550, 100, 50);
        home.setFont(new Font("Saif", Font.PLAIN, 20));
        home.setForeground(java.awt.Color.black);
        home.setBackground(java.awt.Color.LIGHT_GRAY);


        Back.setBounds(510, 550, 100, 50);
        Back.setFont(new Font("Saif", Font.PLAIN, 20));
        Back.setForeground(java.awt.Color.black);
        Back.setBackground(java.awt.Color.LIGHT_GRAY);
        ProductType p= new ProductType();
        
        Back.addActionListener(p);
        Cables.addActionListener(p);
        Adapters.addActionListener(p);
        Mobiles.addActionListener(p);
        home.addActionListener(p);
        
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(java.awt.Color.lightGray);
        p1.setBounds(0, 100, 650, 50);
        c.add(p1);
        c.add(welcome_msg);
        c.add(select_choice);
        c.add(Cables);
        c.add(Adapters);
        c.add(Mobiles);
        c.add(home);
        c.add(Back);
        setVisible(true);

    }
    class ProductType implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (e.getActionCommand().equals("Back")) {
                new HomeGUI();
                dispose();
            }
            
            else if (e.getActionCommand().equals("Cables")){
                new CableWindow();
                dispose();
            }
            
            else if (e.getActionCommand().equals("Adapters")){
                new AdaptersWindow();  // Adaprters Windows
                dispose();
            }
            
            else if (e.getActionCommand().equals("Mobiles")){
                new MobilesWindow();  // Braclets Window
                dispose();
            }
            
            else if (e.getActionCommand().equals("Home")){
                new HomeGUI();
                dispose();
            }
        }
    }
}
