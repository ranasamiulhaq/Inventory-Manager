package IMS;

import java.io.*;
import java.util.ArrayList;

public class FileOperationsCablesSold {
  
    public static void writeToFile(CablesRecord r) {
        // System.out.println("KIa haal ha ostad ");

        try {
            File f = new File("CablesSold.txt");

            ObjectOutputStream oos;

            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            }
            else {
                oos = new ObjectOutputStream(new FileOutputStream(f, false));
            }

            oos.writeObject(r);
            oos.close();

            System.out.println("Object successfully written on the file ");
            }
        catch (IOException e) {
            System.out.println("IO Exception in  File operation file");
            }
        catch (Exception e) {
            System.out.println("Exception in File Operation ");
        }

    }

    public static ArrayList<CablesRecord> readAllData() {
        ArrayList<CablesRecord> list = new ArrayList<CablesRecord>();
        try {
            ObjectInputStream is = new ObjectInputStream((new FileInputStream("Cabless.txt")));
            while (true) {
                CablesRecord s = (CablesRecord) is.readObject();
                list.add(s);
            }
        }
        catch (ClassNotFoundException c) {
            System.out.println("Class not Found Error in File Operation Class");
        }
        catch (EOFException e) {
            System.out.println("End Of Line Error in File Operation Class");
        }
        catch (IOException i) {
            System.out.println("Input Output Exception Error in File Operation Class");
        }
        return list;
    }

    public static ArrayList<CablesRecord> showallstock() {

        ArrayList<CablesRecord> list = readAllData();
        return list;
    }

    public static void Quantity() {
        ArrayList<CablesRecord> list = readAllData();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count++;
        }
        System.out.println("The total quantity of the cables are:  " + count);
    }

    public static void showTypeCCables() {
        ArrayList<CablesRecord> list = readAllData();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCableType().equals("Type-C")) {
                list.get(i).display();
            }
        }
    }

    public static void showAndroidCables() {
        ArrayList<CablesRecord> list = readAllData();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCableType().equals("Android")) {
                list.get(i).display();
            }
        }
    }

    public static void showThunderBoltCables() {
        ArrayList<CablesRecord> list = readAllData();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCableType().equals("Thunderbolt")) {
                list.get(i).display();
            }
        }
    }

}  

