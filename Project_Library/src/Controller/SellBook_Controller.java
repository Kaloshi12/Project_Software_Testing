package Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import Files.BillFile;
import Files.FilesSoldBook;
import Files.Files_Book;
import Model.Bill;
import Model.Book;
import View.BillView;
import View.Bill_IdView;
import View.SellBookView;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class SellBook_Controller {
    private SellBookView view;
    private FilesSoldBook soldBookFile = new FilesSoldBook();
    private BillFile billFile = new BillFile();
    private Bill_IdView IDFile = new Bill_IdView();
    private Files_Book bookFile = new Files_Book();
    private ObservableList<Book> selectedBooks;
    public SellBook_Controller(SellBookView view) {
        this.view = view;

        view.getBuyButton().setOnAction(e -> {
        	selectedBooks = view.getList().getSelectionModel().getSelectedItems();
            decrementQuantity(selectedBooks);
            handleBuyButton(selectedBooks);
        });
    }

    private void decrementQuantity(ObservableList<Book> selectedBooks) {

        for (Book selectedBook : selectedBooks) {
        	int cnt = getQuantityFromTextField(selectedBook);
        	bookFile.delete(selectedBook);
            	Book newBook = new Book(selectedBook.getiSBN(), selectedBook.getTitle(), selectedBook.getAuthor(),
                        selectedBook.getPages(), selectedBook.getQuantity() - cnt, selectedBook.getGenre(),
                        selectedBook.getPrice(), selectedBook.getDescription());
                bookFile.create(newBook);
             
        
    }
       
       
        for (Book book : bookFile.getAll()) {
			if(book.getQuantity() == 0) {
				bookFile.delete(book);
			}
		}
    }

    private void handleBuyButton(ObservableList<Book> selectedBooks) {
        checkQuantity(); // Check if selected quantity is larger than book quantity

        for (Book book : selectedBooks) {
            int quantity = getQuantityFromTextField(book);
            soldBookFile.addSoldBook(book, quantity);
        }

        Random random = new Random();
        int Id = 100000 + random.nextInt(900000);
        Bill bill = new Bill(Id, selectedBooks.toArray(new Book[0]), new Date(), calculateTotalPrice(selectedBooks));

        // If checkQuantity didn't show an alert, proceed to create the bill
        if (!checkQuantity()) {
            billFile.create(bill);

            Platform.runLater(() -> {
                IDFile.getBillIds().add(bill.getBillID());
                BillView billView = new BillView(bill);
                billView.getStageBill().show();
            });
        } else {
        	 Platform.runLater(() -> {
                 showWrongAlert("Failed", "Selected quantity is bigger than our stock");
             });
        }
    }

    private double calculateTotalPrice(ObservableList<Book> selectedBooks) {
        double totalPrice = 0.0;
        for (Book book : selectedBooks) {
            int quantity = getQuantityFromTextField(book);
            totalPrice += book.getPrice() * quantity;
        }
        return totalPrice;
    }

    private int getQuantityFromTextField(Book book) {
        TextField quantityField = view.getQuantityFieldForBook(book);
        try {
            return Integer.parseInt(quantityField.getText());
        } catch (NumberFormatException e) {
            return 0; 
        }
        
        
    }
    private boolean checkQuantity() {
        for (Book book : selectedBooks) {
            int quantity = getQuantityFromTextField(book);
            if (quantity > book.getQuantity()) {
                return true; 
            }
        }
        return false; 
    }

    public void showWrongAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}