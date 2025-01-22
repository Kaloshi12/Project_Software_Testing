package Files;

import Model.Bill;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.List;

public class BillFile {
    public static  String FILE_PATH = "src/BinaryFiles/Bills.dat";
    private static final File DATA_FILE = new File(FILE_PATH);
    private final ObservableList<Bill> listOfBills;

    public BillFile() {
        this.listOfBills = FXCollections.observableArrayList();
        loadBillsFromFile();
    }

    public ObservableList<Bill> getAll() {
        return listOfBills;
    }

    private void loadBillsFromFile() {
        listOfBills.clear();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            System.out.println("Reading bills from file...");

            while (true) {
                try {
                    Bill bill = (Bill) inputStream.readObject();
                    listOfBills.add(bill);
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("Reading complete.");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public boolean create(Bill bill) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            listOfBills.add(bill);
            for (Bill savedBill : listOfBills) {
                outputStream.writeObject(savedBill);
            }
            System.out.println("Bill created and added to file.");
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
