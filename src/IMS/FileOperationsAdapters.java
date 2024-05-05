package IMS;

import java.io.*;
import java.util.ArrayList;

public class FileOperationsAdapters {
  
    public static void writeToFile(AdaptersRecord r) {
        // System.out.println("KIa haal ha ostad ");

        try {
            File f = new File("Adapters.txt");

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

    public static ArrayList<AdaptersRecord> readAllData() {
        ArrayList<AdaptersRecord> list = new ArrayList<AdaptersRecord>();
        try {
            ObjectInputStream is = new ObjectInputStream((new FileInputStream("Adapters.txt")));
            while (true) {
                AdaptersRecord s = (AdaptersRecord) is.readObject();
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

    public static ArrayList<AdaptersRecord> showallstock() {
        ArrayList<AdaptersRecord> list = readAllData();
        return list;
    }

    public static void Quantity() {
        ArrayList<AdaptersRecord> list = readAllData();
        int count = 0;
        for(int i = 0; i < list.size(); i++) {
            count++;
        }
        System.out.println("The total quantity of the cables are:  " + count);
    }

    public static void showTypeCAdapters() {
        ArrayList<AdaptersRecord> list = readAllData();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAdapterType().equals("Type-C")) {
                list.get(i).display();
            }
        }
    }

    public static void showAndroidAdapters() {
        ArrayList<AdaptersRecord> list = readAllData();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAdapterType().equals("Android")) {
                list.get(i).display();
            }
        }
    }

    public static void showLightningAdapters() {
        ArrayList<AdaptersRecord> list = readAllData();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAdapterType().equals("Lightning")) {
                list.get(i).display();
            }
        }
    }

}  

