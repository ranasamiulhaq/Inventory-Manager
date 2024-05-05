package IMS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class AdaptersRecord extends Products implements Serializable {
static Scanner input = new Scanner(System.in);
    int ProductID;
    String AdapterType;
    double price;
    ArrayList<AdaptersRecord> Record = new ArrayList<>();

    public AdaptersRecord() {
        ProductID = 123;
        AdapterType = "xyz";
        price= 0;
    }

    public AdaptersRecord(int i, String type, double p) {
        ProductID = i;
        AdapterType = type;
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

    public String getAdapterType() {
        return AdapterType;
    }

    public void setAdapterType(String AdapterType) {
        AdapterType = AdapterType;
    }

    public void display() {
        System.out.println("The Product ID is:  " + ProductID);
        System.out.println("The Adapter Type is: " + AdapterType);
        System.out.println("The price of Adapter is: Rs "+ price);
    }

    @Override
    public void addProduct() {
        System.out.println("Enter the Product ID of Adapter ");
        int id = input.nextInt();
        System.out.println("Enter the Adapter Type ");
        String type = input.next();
        System.out.println("Enter the price of Adapter in rupees ");
        double price= input.nextDouble();
        AdaptersRecord obj = new AdaptersRecord(id, type,price );
        FileOperationsAdapters.writeToFile(obj);
    }

    @Override
    public void showStock() {
        System.out.println("Please select your choice and 0 to go to main menu ");
        System.out.println("1. View all stock ");
        System.out.println("2. View stock on the basis of Adapters type ");
        int choice1 = input.nextInt();
        while (choice1 != 0) {
            if (choice1 == 1) {
                FileOperationsCables.showallstock();

            } else if (choice1 == 2) {

                System.out.println("Select your choice or press 0 to go back ");
                System.out.println("1. View Stock of Type-C Adapters ");
                System.out.println("2. View stock of Android Adapters ");
                System.out.println("3. View stock of Thunderbolt Adapters ");
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