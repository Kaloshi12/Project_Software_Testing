package View;



import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuLibrarianView extends Pane {
	private Text text;
	private Button showBooks;
	private Button sellBook;
	private Button back;
	private Button bill;
	private Button soldBook;
	private Stage Lstage;

		 public MenuLibrarianView(){
			Lstage = new Stage();
			Lstage.setTitle("Librarian");
			text = new Text();
			text.setText("Welcome Librarian");
			text.setLayoutX(150);
			text.setLayoutY(100);
			text.setFont(Font.font("Arial", FontPosture.ITALIC, 30));
			bill = new Button();
			bill.setText("Bill");
			bill.setLayoutX(20);
			bill.setLayoutY(400);
			bill.setPrefWidth(120);
			bill.setPrefHeight(60);
			bill.setOnMouseEntered(e -> bill.setStyle("-fx-background-color: lightblue;"));
			bill.setOnMouseExited(e -> bill.setStyle(null));
			showBooks = new Button();
	        showBooks.setText("Books");
			showBooks.setLayoutX(160);
			showBooks.setLayoutY(400);
			showBooks.setPrefWidth(120);
			showBooks.setPrefHeight(60);
			showBooks.setOnMouseEntered(e -> showBooks.setStyle("-fx-background-color: lightblue;"));
			showBooks.setOnMouseExited(e -> showBooks.setStyle(null));
			sellBook = new Button();
			sellBook.setText("Sell Books");
			sellBook.setId("sellBook");
			sellBook.setLayoutX(300);
			sellBook.setLayoutY(400);
			sellBook.setPrefWidth(120);
			sellBook.setPrefHeight(60);
			sellBook.setOnMouseEntered(e -> sellBook.setStyle("-fx-background-color: lightblue;"));
			sellBook.setOnMouseExited(e -> sellBook.setStyle(null));

			soldBook = new Button();
			soldBook.setText("Sold Books");
			soldBook.setLayoutX(160);
			soldBook.setLayoutY(300);
			soldBook.setPrefWidth(120);
			soldBook.setPrefHeight(60);
			soldBook.setOnMouseEntered(e -> soldBook.setStyle("-fx-background-color: lightblue;"));
			soldBook.setOnMouseExited(e -> soldBook.setStyle(null));
			
			
			
			getChildren().addAll(text,bill,showBooks,sellBook,soldBook);
			
			
		}


	public Button getSoldBook() {
			return soldBook;
		}


		public void setSoldBook(Button soldBook) {
			this.soldBook = soldBook;
		}


	public Text getText() {
			return text;
		}


		public void setText(Text text) {
			this.text = text;
		}


		public Button getShowBooks() {
			return showBooks;
		}


		public void setShowBooks(Button showBooks) {
			this.showBooks = showBooks;
		}


		


		public Button getBill() {
			return bill;
		}


		public void setBill(Button bill) {
			this.bill = bill;
		}


		


		public Button getSellBook() {
			return sellBook;
		}


		public void setSellBook(Button sellBook) {
			this.sellBook = sellBook;
		}


		public Stage getLstage() {
			return Lstage;
		}


		public void setLstage(Stage lstage) {
			Lstage = lstage;
		}


		

		
		



		public Button getBack() {
			return back;
		}


		public void setBack(Button back) {
			this.back = back;
		}


		
		


}
