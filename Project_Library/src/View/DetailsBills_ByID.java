package View;

import Model.Bill;
import Model.Book;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

public class DetailsBills_ByID {
    private Bill bill;
    private VBox bookDetailsVBox;
    private Label totalPriceLabel;
    private Label dateLabel;
    private Label titleLabel;
    private Label priceLabel;
    private HBox bookDetailsHBox;
    private Label idLabel;
    private Stage stage;

    public DetailsBills_ByID(Bill bill) {
        this.bill = bill;
        this.stage = new Stage();
        this.bookDetailsVBox = new VBox(10);

        for (Book book : bill.getBooks()) {
            bookDetailsHBox = new HBox(10);
            titleLabel = new Label("Title: " + book.getTitle());
            priceLabel = new Label("Price: " + String.format("%.2f", book.getPrice()));
            bookDetailsHBox.getChildren().addAll(titleLabel, priceLabel);
            bookDetailsVBox.getChildren().add(bookDetailsHBox);
        }

        idLabel = new Label("ID: " + bill.getBillID());
        idLabel.setFont(Font.font("Arial", FontPosture.ITALIC, 16));

        totalPriceLabel = new Label("Total Price: " + String.format("%.2f", bill.getTotalPrice()));
        dateLabel = new Label("Date: " + bill.getDate());
        VBox root = new VBox(10);
        root.getChildren().addAll(idLabel, bookDetailsVBox, totalPriceLabel, dateLabel);
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
    }

    public VBox getBookDetailsVBox() {
        return bookDetailsVBox;
    }

    public Label getTotalPriceLabel() {
        return totalPriceLabel;
    }

    public Label getDateLabel() {
        return dateLabel;
    }

    public Label getIdLabel() {
        return idLabel;
    }

    public Stage getStage() {
        return stage;
    }
}
