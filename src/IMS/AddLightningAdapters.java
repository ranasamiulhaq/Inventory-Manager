package IMS;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class AddLightningAdapters extends JFrame  {
    Container c;
    JLabel welcome_msg;
    JLabel Enter_Details;
    JPanel p1;
    JButton Back;
    JLabel Enter_ID;
    JButton Ok;
    JButton home;
    JButton Addmore;
    JTextField IdEnterArea;
    JLabel Enter_Price;
    JTextField PriceEnterArea;
    

    public AddLightningAdapters() {
        c = this.getContentPane();
        c.setLayout(null);
        setTitle("FlexiFits");
        setSize(650, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        c.setBackground(java.awt.Color.DARK_GRAY);
        welcome_msg = new JLabel("Inventory Regulation System");
        Enter_Details = new JLabel("Enter Product Details ");
        p1 = new JPanel();
        Back = new JButton("Back");
        Enter_ID = new JLabel("Enter Product ID: ");
        IdEnterArea = new JTextField();
        Ok = new JButton("OK");
        Addmore = new JButton("Add More");
        Enter_Price = new JLabel("Enter Price in RS:");
        PriceEnterArea= new JTextField();
        Enter_Price = new JLabel("Enter Price in RS:");
        PriceEnterArea= new JTextField();
        home= new JButton("Home");
        welcome_msg.setBounds(50, 30, 650, 50);
        welcome_msg.setFont(new Font("SansSerif", Font.BOLD, 40));
        welcome_msg.setForeground(java.awt.Color.orange);

        Enter_Details.setBounds(140, 180, 500, 50);
        Enter_Details.setFont(new Font("Saif", Font.ROMAN_BASELINE, 40));
        Enter_Details.setForeground(java.awt.Color.ORANGE);
        home.setBounds(50, 550, 100, 50);
        home.setFont(new Font("Saif", Font.PLAIN, 20));
        home.setForeground(java.awt.Color.black);
        home.setBackground(java.awt.Color.LIGHT_GRAY);

        Back.setBounds(510, 550, 100, 50);
        Back.setFont(new Font("Saif", Font.PLAIN, 20));
        Back.setForeground(java.awt.Color.black);
        Back.setBackground(java.awt.Color.LIGHT_GRAY);
        Enter_ID.setBounds(120, 240, 230, 50);
        Enter_ID.setFont(new Font("Saif", Font.BOLD, 25));
        Enter_ID.setForeground(java.awt.Color.BLACK);
        IdEnterArea.setBounds(350, 245, 150, 40);
        IdEnterArea.setFont(new Font("Saif", Font.BOLD, 30));
        Enter_Price.setBounds(120, 320, 230, 50);
        Enter_Price.setFont(new Font("Saif", Font.BOLD, 25));
        Enter_Price.setForeground(java.awt.Color.BLACK);
        PriceEnterArea.setBounds(350, 325, 150, 40);
        PriceEnterArea.setFont(new Font("Saif", Font.BOLD, 30));
        Enter_Price.setBounds(120, 320, 230, 50);
        Enter_Price.setFont(new Font("Saif", Font.BOLD, 25));
        Enter_Price.setForeground(java.awt.Color.BLACK);
        PriceEnterArea.setBounds(350, 325, 150, 40);
        PriceEnterArea.setFont(new Font("Saif", Font.BOLD, 30));
        Ok.setBounds(100, 430, 200, 50);
        Ok.setFont(new Font("Saif", Font.BOLD, 30));
        Ok.setForeground(java.awt.Color.black);
        Ok.setBackground(java.awt.Color.ORANGE);

        Addmore.setBounds(350, 430, 200, 50);
        Addmore.setFont(new Font("Saif", Font.BOLD, 30));
        Addmore.setForeground(java.awt.Color.black);
        Addmore.setBackground(java.awt.Color.ORANGE);


        p1.setLayout(null);
        p1.setBackground(java.awt.Color.lightGray);
        p1.setBounds(0, 100, 650, 50);
        c.add(p1);
        c.add(welcome_msg);
        c.add(Enter_Details);
        c.add(home);
        c.add(Back);
        c.add(Enter_ID);
        c.add(IdEnterArea);
        c.add(Enter_Price);
        c.add(PriceEnterArea);
        c.add(Ok);
        c.add(Addmore);
        
        AddLightningActionListener a = new AddLightningActionListener();
        Back.addActionListener(a);
        Ok.addActionListener(a);
        Addmore.addActionListener(a);
        home.addActionListener(a);
        
        setVisible(true);
    }

    class AddLightningActionListener implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (e.getActionCommand().equals("Back")) {
                new AdaptersWindow();
                dispose();

            } else if (e.getActionCommand().equals("OK")) {
                ArrayList<AdaptersRecord> list = FileOperationsAdapters.showallstock();
                String ID = IdEnterArea.getText();
                String Price = PriceEnterArea.getText();
                int ID_Len = ID.length();
                int Price_Length = Price.length();
                boolean allDigitsinID = onlydigits(ID, ID_Len);
                Boolean allDigitsinPrice = onlydigits(Price, Price_Length);

                if (allDigitsinID == true && allDigitsinPrice == false) {
                    System.out.println("Wrong ID or Pass ");
                    JOptionPane.showMessageDialog(c, "Enter Correct Product ID In Numbers or Enter Correct Price");

                } else if (allDigitsinPrice == true && allDigitsinID == false) {
                    System.out.println("Wrong ID or Pass ");
                    JOptionPane.showMessageDialog(c, "Enter Correct Product ID In Numbers or Enter Correct Price");

                } else if (allDigitsinID == true && allDigitsinPrice == true) {
                    int id = Integer.parseInt(ID);
                    Double price = Double.parseDouble(Price);
                    int id_Check = 0;
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getProductID() == id) {
                            JOptionPane.showMessageDialog(c, "Product ID already exists");
                            id_Check = 1;
                        }
                    }
                    if (id_Check == 0) {

                        System.out.println("Yehn file add kro ");
                        AdaptersRecord obj = new AdaptersRecord(id, "Lightning", price);
                        FileOperationsAdapters.writeToFile(obj);
                        JOptionPane.showMessageDialog(c, "Product added successfully");
                    }
                }

            }  else if (e.getActionCommand().equals("Add More")) {
                new AddLightningAdapters();
                dispose();
            }
            else if (e.getActionCommand().equals("Home")){
                new HomeGUI();
                dispose();
            }
        }
    }
    public static boolean onlydigits(String str, int len) {
        for (int i = 0; i < len; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}