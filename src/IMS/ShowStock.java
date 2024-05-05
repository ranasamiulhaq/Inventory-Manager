package IMS;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ShowStock  extends JFrame {
    Container c;
    JLabel welcome_msg;
    JLabel select_choice;
    JButton Show_All_Stock;
    JButton Show_Cables_Stock;
    JButton Show_Adapters_Stock;
    JButton Show_Mobile_Stock;
    JButton Back;
    JButton home;
    JPanel p1;

    public ShowStock() {
        c = this.getContentPane();
        c.setLayout(null);
        setTitle("FlexiFits");
        setSize(650, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        c.setBackground(java.awt.Color.DARK_GRAY);
        welcome_msg = new JLabel("Inventory Regulation System");
        select_choice = new JLabel("Select Stock View Type");
        Show_All_Stock = new JButton("Show All Stock");
        Show_Cables_Stock = new JButton("Show Cables Stock");
        Show_Adapters_Stock = new JButton("Show Adapters Stock");
        Show_Mobile_Stock = new JButton("Show Mobiles Stock");
        Back = new JButton("Back");
        p1 = new JPanel();
        home = new JButton("Home");
        welcome_msg.setBounds(50, 30, 650, 50);
        welcome_msg.setFont(new Font("SansSerif", Font.BOLD, 40));
        welcome_msg.setForeground(java.awt.Color.orange);
        select_choice.setBounds(115, 165, 500, 50);
        select_choice.setFont(new Font("Saif", Font.ROMAN_BASELINE, 40));
        select_choice.setForeground(java.awt.Color.ORANGE);
        Show_All_Stock.setBounds(145, 230, 350, 50);
        Show_All_Stock.setFont(new Font("Saif", Font.BOLD, 30));
        Show_All_Stock.setForeground(java.awt.Color.black);
        Show_All_Stock.setBackground(java.awt.Color.ORANGE);
        Show_Cables_Stock.setBounds(145, 300, 350, 50);
        Show_Cables_Stock.setFont(new Font("Saif", Font.BOLD, 30));
        Show_Cables_Stock.setForeground(java.awt.Color.black);
        Show_Cables_Stock.setBackground(java.awt.Color.ORANGE);
        Show_Adapters_Stock.setBounds(145, 370, 350, 50);
        Show_Adapters_Stock.setFont(new Font("Saif", Font.BOLD, 30));
        Show_Adapters_Stock.setForeground(java.awt.Color.black);
        Show_Adapters_Stock.setBackground(java.awt.Color.ORANGE);
        Show_Mobile_Stock.setBounds(145, 440, 350, 50);
        Show_Mobile_Stock.setFont(new Font("Saif", Font.BOLD, 30));
        Show_Mobile_Stock.setForeground(java.awt.Color.black);
        Show_Mobile_Stock.setBackground(java.awt.Color.ORANGE);
        home.setBounds(50, 550, 100, 50);
        home.setFont(new Font("Saif", Font.PLAIN, 20));
        home.setForeground(java.awt.Color.black);
        home.setBackground(java.awt.Color.LIGHT_GRAY);
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
        c.add(Show_All_Stock);
        c.add(Show_Cables_Stock);
        c.add(Show_Adapters_Stock);
        c.add(Show_Mobile_Stock);
        c.add(home);
        c.add(Back);
        ShowStockWindow c = new ShowStockWindow();
        Back.addActionListener(c);
        Show_All_Stock.addActionListener(c);
        Show_Cables_Stock.addActionListener(c);
        Show_Adapters_Stock.addActionListener(c);
        Show_Mobile_Stock.addActionListener(c);
        home.addActionListener(c);
        setVisible(true);

    }

    class ShowStockWindow implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (e.getActionCommand().equals("Back")) {
                new HomeGUI();
                dispose();
            }
            if (e.getActionCommand().equals("Show All Stock")) {
                new ShowAllStock();
                dispose();
            }
            if (e.getActionCommand().equals("Show Cables Stock")) {
                new CablesStock();
                dispose();
            } 
            if (e.getActionCommand().equals("Show Adapters Stock")) {
                new AdaptersStock();
                dispose();
            } 
            if (e.getActionCommand().equals("Show Mobiles Stock")) {
                new MobileStock();
                dispose();
            } 
            if (e.getActionCommand().equals("Home")){
                new HomeGUI();
                dispose();
            }
        }
    }
}