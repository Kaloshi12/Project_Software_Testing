package View;

import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Files.Files_Book;
import Model.Book;

import java.util.HashMap;
import java.util.Map;

public class SellBookView extends BorderPane {
    private Stage stageBook;
    private final Files_Book file;
    private ListView<Book> list;
    private Button buyButton;
    private Text text;
    private Map<Book, TextField> bookQuantityFields = new HashMap<>();

    public SellBookView() {
        stageBook = new Stage();
        stageBook.setTitle("Books");
        text = new Text("Books");
        file = new Files_Book();
        list = new ListView<>(file.loadBookFromFile());

        list.setCellFactory(param -> new ListCell<Book>() {
            private TextField quantityField = new TextField();

            @Override
            protected void updateItem(Book book, boolean empty) {
                super.updateItem(book, empty);
                if (empty || book == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    Text bookDetails = new Text(String.format("%s by %s - Pages: %d Quantity: %d Price: %.2f",
                            book.getTitle(), book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName(), 
                            book.getPages(), book.getQuantity(), book.getPrice()));
                    quantityField.setPromptText("Qty");
                    quantityField.setPrefWidth(50); // Set the width of the text field

                    HBox hbox = new HBox(bookDetails, quantityField);
                    hbox.setSpacing(10);
                    setGraphic(hbox); // Set the HBox as the graphic of the cell

                    bookQuantityFields.put(book, quantityField); // Store the reference to the TextField
                }
            }
        });

        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        FlowPane pane = new FlowPane();
        pane.getChildren().add(text);
        setCenter(pane);

        HBox hbox = new HBox();
        buyButton = new Button("Buy");
        buyButton.setPrefWidth(120);
        buyButton.setPrefHeight(50);

        hbox.getChildren().addAll(buyButton);
        hbox.setSpacing(50.0);
        setBottom(hbox);
        setCenter(list);
    }

    public TextField getQuantityFieldForBook(Book book) {
        return bookQuantityFields.get(book);
    }

    // Getters and Setters
    public Stage getStageBook() {
        return stageBook;
    }

    public void setStageBook(Stage stageBook) {
        this.stageBook = stageBook;
    }

    public ListView<Book> getList() {
        return list;
    }

    public void setList(ListView<Book> list) {
        this.list = list;
    }

    public Button getBuyButton() {
        return buyButton;
    }

    public void setBuyButton(Button buyButton) {
        this.buyButton = buyButton;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }
}