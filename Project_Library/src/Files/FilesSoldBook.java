package Files;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import Model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

public class FilesSoldBook implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FILE_PATH = "src/BinaryFiles/SoldBooks.dat";
    private static final File DATA_FILE = new File(FILE_PATH);
    private transient ObservableMap<Book, Integer> soldBookList = FXCollections.observableHashMap();

    public FilesSoldBook() {
        readSoldBooksFromFile();
    }

    public static String getFilePath() {
        return FILE_PATH;
    }

    public static File getDataFile() {
        return DATA_FILE;
    }

    public ObservableMap<Book, Integer> getAll() {
        return FXCollections.unmodifiableObservableMap(soldBookList);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        soldBookList = FXCollections.observableHashMap();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        Map<Book, Integer> serializableMap = new HashMap<>(soldBookList);
        out.writeObject(serializableMap);
    }

    private void readSoldBooksFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            System.out.println("Reading sold books from file...");
            soldBookList = FXCollections.observableHashMap();
            Map<Book, Integer> deserializedMap = (Map<Book, Integer>) inputStream.readObject();
            soldBookList.putAll(deserializedMap);
            System.out.println("Reading complete.");
        } catch (EOFException e) {
            System.out.println("End of file reached.");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public boolean saveSoldBooksToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            outputStream.writeObject(new HashMap<>(soldBookList));
            System.out.println("Writing sold books to file...");
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void addSoldBook(Book book, int quantity) {
        soldBookList.put(book, quantity);
        saveSoldBooksToFile();
    }
}
