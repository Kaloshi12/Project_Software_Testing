package Files;

import Model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

import java.io.*;
import java.util.HashMap;

public class FilesSoldBook {

    private static final String FILE_PATH = "src/BinaryFiles/SoldBooks.dat";
    private final ObservableMap<Book, Integer> soldBookList;

    public FilesSoldBook() {
        soldBookList = FXCollections.observableHashMap();
        readSoldBooksFromFile();
    }

    private void readSoldBooksFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return; // If the file doesn't exist, simply return without attempting to read
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            HashMap<Book, Integer> loadedData = (HashMap<Book, Integer>) ois.readObject();
            soldBookList.putAll(loadedData);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addSoldBook(Book book, int quantity) {
        soldBookList.put(book, soldBookList.getOrDefault(book, 0) + quantity);
        saveSoldBooksToFile();
    }

    public ObservableMap<Book, Integer> getAll() {
        return FXCollections.unmodifiableObservableMap(soldBookList);
    }

    private void saveSoldBooksToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(new HashMap<>(soldBookList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File getDataFile() {
        return new File(FILE_PATH);
    }
}
