package View;

import Model.Bill;

import Model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Random;

public class BillView {
    private Stage stageBill;
    private VBox bookDetailsVBox;
    private Label totalPriceLabel;
    private Label dateLabel;
    private Label Id;
    //

    public VBox getBookDetailsVBox() {
		return bookDetailsVBox;
	}

	public void setBookDetailsVBox(VBox bookDetailsVBox) {
		this.bookDetailsVBox = bookDetailsVBox;
	}

	public Label getTotalPriceLabel() {
		return totalPriceLabel;
	}

	public void setTotalPriceLabel(Label totalPriceLabel) {
		this.totalPriceLabel = totalPriceLabel;
	}

	public Label getDateLabel() {
		return dateLabel;
	}

	public void setDateLabel(Label dateLabel) {
		this.dateLabel = dateLabel;
	}

	public Label getId() {
		return Id;
	}

	public void setId(Label id) {
		Id = id;
	}

	public void setStageBill(Stage stageBill) {
		this.stageBill = stageBill;
	}

	public BillView(Bill bill) {
        stageBill = new Stage();
        stageBill.setTitle("Bill Details");
        dateLabel = new Label("Date: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(bill.getDate()));
        dateLabel.setFont(Font.font("Arial", FontWeight.BOLD,14));
        totalPriceLabel = new Label("                          				 Total Price: " + String.format("%.2f", bill.getTotalPrice()));
        totalPriceLabel.setFont(Font.font("Arial",FontWeight.BOLD,14));
        bookDetailsVBox = new VBox(10);
        ObservableList<Book> books = FXCollections.observableArrayList(bill.getBooks());

        for (Book book : books) {
            HBox bookDetailsHBox = new HBox(10);

            Label titleLabel = new Label("   Title: " + book.getTitle());
            Label priceLabel = new Label("                   Price: " + String.format("%.2f", book.getPrice()));
            

            bookDetailsHBox.getChildren().addAll(titleLabel, priceLabel);
            bookDetailsVBox.getChildren().add(bookDetailsHBox);
        }
        
       
        Id = new Label("   ID: " + String.format("%d",bill.getBillID()));
        Id.setFont(Font.font("Arial", FontPosture.ITALIC, 16));
      

        VBox root = new VBox(10);
        root.getChildren().addAll(Id,bookDetailsVBox, totalPriceLabel, dateLabel);

        Scene scene = new Scene(root, 400, 300);
        stageBill.setScene(scene);
    }

    public Stage getStageBill() {
        return stageBill;
    }
}
