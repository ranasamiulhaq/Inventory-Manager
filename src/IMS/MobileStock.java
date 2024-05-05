package IMS;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MobileStock extends JFrame {
    Container c;
    JLabel welcome_msg;
    JLabel select_choice;
    JLabel Total_Stock_Quantity;
    JPanel p1;
    JButton Back;
    JButton home;
    JTextArea t1;
    JScrollPane scroll;
    JTextArea Quantity_Display;

    MobileStock() {
        c = this.getContentPane();
        c.setLayout(null);
        setTitle("FlexiFits");
        setSize(650, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        c.setBackground(java.awt.Color.DARK_GRAY);
        welcome_msg = new JLabel("Inventory Regulation System");
        select_choice = new JLabel("Viewing All Stock");
        Back = new JButton("Back");
        p1 = new JPanel();
        t1 = new JTextArea(50, 50);
        home= new JButton("Home");
        scroll = new JScrollPane(t1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        Total_Stock_Quantity = new JLabel("Total Stock Quantity:");
        Quantity_Display = new JTextArea();
        scroll.setBounds(120, 220, 400, 300);
        t1.setFont(new Font("Saif", Font.BOLD, 20));
        welcome_msg.setBounds(50, 30, 650, 50);
        welcome_msg.setFont(new Font("SansSerif", Font.BOLD, 40));
        welcome_msg.setForeground(java.awt.Color.orange);
        select_choice.setBounds(165, 165, 500, 50);
        select_choice.setFont(new Font("Saif", Font.ROMAN_BASELINE, 40));
        select_choice.setForeground(java.awt.Color.ORANGE);
        Total_Stock_Quantity.setBounds(135, 523, 650, 50);
        Total_Stock_Quantity.setFont(new Font("SansSerif", Font.ITALIC, 30));
        Total_Stock_Quantity.setForeground(java.awt.Color.BLACK);
        Quantity_Display.setFont(new Font("Saif", Font.BOLD,30 ));
        Quantity_Display.setBounds(420, 525, 50, 40);
        home.setBounds(35, 580, 100, 50);
        home.setFont(new Font("Saif", Font.PLAIN, 20));
        home.setForeground(java.awt.Color.black);
        home.setBackground(java.awt.Color.LIGHT_GRAY);

        Back.setBounds(510, 580, 100, 50);
        Back.setFont(new Font("Saif", Font.PLAIN, 20));
        Back.setForeground(java.awt.Color.black);
        Back.setBackground(java.awt.Color.LIGHT_GRAY);
        
        t1.setText("----------Mobile-----------");
        
        ArrayList<MobileRecord> list3 = FileOperationsMobiles.showallstock();
        int count3=0;
        for (int i = 0; i < list3.size(); i++) {
            
            String str = "The Product ID is: " + list3.get(i).getProductID() + "\n" +
                    "The Cable type is: " + list3.get(i).MobileType + "\n" +"The Price is: Rs " +list3.get(i).getPrice()+"\n"+
                    "-----------------------------------------------";
count3++;
            t1.setText(t1.getText() + "\n" + str);

        }
                
        String quantity= Integer.toString(count3);
        Quantity_Display.setText(quantity);

        t1.setEditable(false);
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(java.awt.Color.lightGray);
        p1.setBounds(0, 100, 650, 50);
        c.add(p1);
        c.add(welcome_msg);
        c.add(select_choice);
        c.add(scroll);
        c.add(Total_Stock_Quantity);
        c.add(Quantity_Display);
        c.add(home);
        c.add(Back);
        
        AllStockWindow a = new AllStockWindow();
        Back.addActionListener(a);
        home.addActionListener(a);
        setVisible(true);
    }

    class AllStockWindow implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (e.getActionCommand().equals("Back")) {
                new ShowStock();
                dispose();
            }
            if (e.getActionCommand().equals("Home")){
                new HomeGUI();
                dispose();
            }
        }
    }
}
