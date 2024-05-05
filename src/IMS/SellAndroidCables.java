package IMS;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class SellAndroidCables extends JFrame implements Serializable {

    Container c;
    JLabel welcome_msg;
    JLabel Enter_Quantity;
    JPanel p1;
    JButton Back;
    JButton home;
    JButton sell;
    JTextField quantity;
    JTextField remaining;
    ArrayList<CablesRecord> list = FileOperationsCables.showallstock();
    int androidCount = 0;
    


    public SellAndroidCables() {
        for(int q = 0 ; q< list.size() ; q++){
            if(list.get(q).CableType.equalsIgnoreCase("Android"))
                 androidCount++;
        }
        
        c = this.getContentPane();
        c.setLayout(null);
        setTitle("FlexiFits");
        setSize(650, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        c.setBackground(java.awt.Color.DARK_GRAY);
        welcome_msg = new JLabel("Inventory Regulation System");
        p1 = new JPanel();
        Back = new JButton("Back");
        sell = new JButton("Sell");
        remaining = new JTextField(androidCount);
        remaining.setText(" " + androidCount);
        remaining.setEditable(false);
        home = new JButton("Home");
        welcome_msg.setBounds(50, 30, 650, 50);
        welcome_msg.setFont(new Font("SansSerif", Font.BOLD, 40));
        welcome_msg.setForeground(java.awt.Color.orange);

        Enter_Quantity = new JLabel("Selling Quantity : ");
        Enter_Quantity.setBounds(120, 240, 230, 50);
        Enter_Quantity.setFont(new Font("Saif", Font.BOLD, 25));
        Enter_Quantity.setForeground(java.awt.Color.YELLOW);

        quantity = new JTextField();
        quantity.setBounds(350, 255, 150, 40);
        quantity.setFont(new Font("Saif", Font.BOLD, 30));

        home.setBounds(50, 550, 100, 50);
        home.setFont(new Font("Saif", Font.PLAIN, 20));
        home.setForeground(java.awt.Color.black);
        home.setBackground(java.awt.Color.LIGHT_GRAY);
        Back.setBounds(510, 550, 100, 50);
        Back.setFont(new Font("Saif", Font.PLAIN, 20));
        Back.setForeground(java.awt.Color.black);
        Back.setBackground(java.awt.Color.LIGHT_GRAY);

        sell.setBounds(250, 360, 200, 50);
        sell.setFont(new Font("Saif", Font.BOLD, 30));
        sell.setForeground(java.awt.Color.black);
        sell.setBackground(java.awt.Color.ORANGE);

        remaining.setBounds(250, 430, 200, 50);

        p1.setLayout(null);
        p1.setBackground(java.awt.Color.lightGray);
        p1.setBounds(0, 100, 650, 50);
        c.add(p1);
        c.add(welcome_msg);
        c.add(Enter_Quantity);
        c.add(quantity);
        c.add(Back);
        c.add(home);
        c.add(sell);
        c.add(remaining);

        SellAndroidCablesListener a = new SellAndroidCablesListener();
        Back.addActionListener(a);
        setVisible(true);
        sell.addActionListener(a);
        home.addActionListener(a);
    }

    class SellAndroidCablesListener implements ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (e.getActionCommand().equals("Back")) {
                new SellCableWindow();
                dispose();

            } else if (e.getActionCommand().equals("Sell")) {
                int seell = Integer.parseInt(quantity.getText());
                //remaining.setText(" " + list.size());
               // int indexsell = -1;
                if(androidCount >= seell ){
                    System.out.println("ander a gya");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println("check 1");
                    if (list.get(i).CableType.equalsIgnoreCase("Android")) {
                        System.out.println("check 2");
                        System.out.println("mil gye cable");
                        FileOperationsCablesSold.writeToFile(list.get(i));
                        list.remove(i);
                        System.out.println("check 3");

                        JOptionPane.showMessageDialog(c, "Product Sold successfully");
                        
                        
                        }
                    }
                }

                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Cabless.txt"));
                    for (int i = 0; i < list.size(); i++) {
                        oos.writeObject(list.get(i));

                    }
                } catch (IOException h) {
                    System.out.println("Unable to write after deletion of data ");
                }

                //FileOperationsCables.writeToFile(list,false) ; 
                remaining.setText(" " + androidCount);
             //   JOptionPane.showMessageDialog(c, "Product Not Found");
            } else if (e.getActionCommand().equals("Home")) {
                new HomeGUI();
                dispose();
            }
        }
    }
}
