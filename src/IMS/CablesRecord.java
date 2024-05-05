package IMS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class CablesRecord extends Products implements Serializable {
static Scanner input = new Scanner(System.in);
    int ProductID;
    String CableType;
    double price;
    ArrayList<CablesRecord> Record = new ArrayList<>();

    public CablesRecord() {
        ProductID = 123;
        CableType = "xyz";
        price= 0;

    }
    
    public CablesRecord(CablesRecord c) {
        ProductID = c.ProductID;
        CableType = c.CableType;
        price= c.price;

    }

    public CablesRecord(int i, String type, double p) {
        ProductID = i;
        CableType = type;
        price= p;

    }

    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public String getCableType() {
        return CableType;
    }

    public void setCableType(String cableType) {
        CableType = cableType;
    }

    public void display() {
        System.out.println("The Product ID is:  " + ProductID);
        System.out.println("The Cable Type is: " + CableType);
        System.out.println("The price of cable is: Rs "+ price);
    }

    @Override
    public void addProduct() {
        System.out.println("Enter the Product ID of cable ");
        int id = input.nextInt();
        System.out.println("Enter the Cable Type ");
        String type = input.next();
        System.out.println("Enter the price of cable in rupees ");
        double price= input.nextDouble();
        CablesRecord obj = new CablesRecord(id, type,price );
        FileOperationsCables.writeToFile(obj);

    }

    @Override
    public void showStock() {
        System.out.println("Please select your choice and 0 to go to main menu ");
        System.out.println("1. View all stock ");
        System.out.println("2. View stock on the basis of cables type ");
        int choice1 = input.nextInt();
        while (choice1 != 0) {
            if (choice1 == 1) {
                FileOperationsCables.showallstock();

            } else if (choice1 == 2) {

                System.out.println("Select your choice or press 0 to go back ");
                System.out.println("1. View Stock of Type-C cables ");
                System.out.println("2. View stock of Android cables ");
                System.out.println("3. View stock of Thunderbolt cables ");
                int type_choice = input.nextInt();
                while (type_choice != 0) {
                    if (type_choice == 1) {
                        FileOperationsCables.showTypeCCables();
                    } else if (type_choice == 2) {
                        FileOperationsCables.showAndroidCables();
                    } else if (type_choice == 3) {
                        FileOperationsCables.showThunderBoltCables();
                    }
                    System.out.println("Select your choice again to view other type cables or press 0 ");
                    System.out.println("1. View Stock of Type-C cables ");
                    System.out.println("2. View stock of Android cables ");
                    System.out.println("3. View stock of Thunderbolt cables ");
                    type_choice= input.nextInt();
                }

            }
            System.out.println("Select your choice again or go to main menu ");
            System.out.println("1. View all stock ");
            System.out.println("2. View stock on the basis of cables type ");
            choice1 = input.nextInt();

        }

    }

    @Override
    public void stockQuantity() {
        FileOperationsCables.Quantity();

    }

}    

