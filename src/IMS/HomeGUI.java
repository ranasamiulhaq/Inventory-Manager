package IMS;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class HomeGUI extends JFrame implements Serializable{
  Container c;
  JLabel welcome_msg;
  JLabel select_choice;
  JPanel p1;
  JButton AddProduct;
  JButton ShowStock;
  JButton SellProduct;

  public HomeGUI(){

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
    AddProduct = new JButton("Add Product");
    ShowStock = new JButton("Show Stock");
    SellProduct = new JButton("Sell Product");
    welcome_msg.setBounds(50, 30, 650, 50);
    welcome_msg.setFont(new Font("SansSerif", Font.BOLD, 40));
    welcome_msg.setForeground(java.awt.Color.orange);
    select_choice.setBounds(170, 180, 500, 50);
    select_choice.setFont(new Font("Saif", Font.ROMAN_BASELINE, 40));
    select_choice.setForeground(java.awt.Color.ORANGE);
    AddProduct.setBounds(195, 270, 250, 50);
    AddProduct.setFont(new Font("Saif", Font.BOLD, 30));
    AddProduct.setForeground(java.awt.Color.black);
    AddProduct.setBackground(java.awt.Color.ORANGE);
    ShowStock.setBounds(195, 370, 250, 50);
    ShowStock.setFont(new Font("Saif", Font.BOLD, 30));
    ShowStock.setForeground(java.awt.Color.black);
    ShowStock.setBackground(java.awt.Color.ORANGE);
    SellProduct.setBounds(195, 470, 250, 50);
    SellProduct.setFont(new Font("Saif", Font.BOLD, 30));
    SellProduct.setForeground(java.awt.Color.black);
    SellProduct.setBackground(java.awt.Color.ORANGE);
    
    HomeActionListener h= new HomeActionListener();
    AddProduct.addActionListener(h);
    ShowStock.addActionListener(h);
    SellProduct.addActionListener(h);
    
    p1 = new JPanel();
    p1.setLayout(null);
    p1.setBackground(java.awt.Color.lightGray);
    p1.setBounds(0, 100, 650, 50);
    
    c.add(p1);
    c.add(welcome_msg);
    c.add(select_choice);
    c.add(AddProduct);
    c.add(ShowStock);
    c.add(SellProduct);
    
    setVisible(true);

  }

  class HomeActionListener implements ActionListener {
    // @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
      if (e.getActionCommand().equals("Add Product")) {
         new AddProdWindow();
        dispose();
      }
      else if (e.getActionCommand().equals("Show Stock")){
         new ShowStock();
        dispose();
      }
      else if (e.getActionCommand().equals("Sell Product")){
         new SellProductWindow();
        dispose();
      }

    }
  }
}