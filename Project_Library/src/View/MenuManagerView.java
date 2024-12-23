package View;



import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuManagerView extends Pane {
	private Text text;
	private Text register;
	private Button showBooks;
	private Button addBooks;
	private Button showSoldBooks;
	private Button delete;
	private Button back;
	
	private Stage Mstage;

		 public MenuManagerView(){
			Mstage = new Stage();
			Mstage.setTitle("Manager");
			text = new Text();
			text.setText("Welcome Manager");
			text.setLayoutX(150);
			text.setLayoutY(100);
			text.setFont(Font.font("Arial", FontPosture.ITALIC, 50));
			register = new Text();
			
			register.setFont(Font.font("Arial",FontWeight.BOLD,50));
			addBooks = new Button();
			addBooks.setText("Add Book");
			addBooks.setLayoutX(20);
			addBooks.setLayoutY(400);
			addBooks.setPrefWidth(120);
			addBooks.setPrefHeight(60);
			addBooks.setOnMouseEntered(e -> addBooks.setStyle("-fx-background-color: lightblue;"));
	        addBooks.setOnMouseExited(e -> addBooks.setStyle(null));
			showBooks = new Button();
	        showBooks.setText("Books");
			showBooks.setLayoutX(160);
			showBooks.setLayoutY(400);
			showBooks.setPrefWidth(120);
			showBooks.setPrefHeight(60);
			showBooks.setOnMouseEntered(e -> showBooks.setStyle("-fx-background-color: lightblue;"));
			showBooks.setOnMouseExited(e -> showBooks.setStyle(null));
			showSoldBooks = new Button();
			showSoldBooks.setText("Sold Books");
			showSoldBooks.setLayoutX(300);
			showSoldBooks.setLayoutY(400);
			showSoldBooks.setPrefWidth(120);
			showSoldBooks.setPrefHeight(60);
			showSoldBooks.setOnMouseEntered(e -> showSoldBooks.setStyle("-fx-background-color: lightblue;"));
			showSoldBooks.setOnMouseExited(e -> showSoldBooks.setStyle(null));
			delete = new Button();
			delete.setText("Remove Book");
			delete.setLayoutX(440);
			delete.setLayoutY(400);
			delete.setPrefWidth(120);
			delete.setPrefHeight(60);
			delete.setOnMouseEntered(e -> delete.setStyle("-fx-background-color: lightblue;"));
			delete.setOnMouseExited(e -> delete.setStyle(null));
			
			
			getChildren().addAll(text,addBooks,showBooks,showSoldBooks,delete);
			
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


		public Button getAddBooks() {
			return addBooks;
		}


		public void setAddBooks(Button addBooks) {
			this.addBooks = addBooks;
		}


		public Button getShowBorrowedBooks() {
			return showSoldBooks;
		}


		public void setShowBorrowedBooks(Button showSoldBooks) {
			this.showSoldBooks = showSoldBooks;
		}


		public Button getDelete() {
			return delete;
		}


		public void setDelete(Button delete) {
			this.delete = delete;
		}


		
		public Stage getMstage() {
			return Mstage;
		}


		public void setMstage(Stage mstage) {
			Mstage = mstage;
		}


		public Text getRegister() {
			return register;
		}


		public Button getBack() {
			return back;
		}


		public void setBack(Button back) {
			this.back = back;
		}


		public void setRegister(Text register) {
			this.register = register;
		}


		public Button getShowSoldBooks() {
			return showSoldBooks;
		}


		public void setShowSoldBooks(Button showSoldBooks) {
			this.showSoldBooks = showSoldBooks;
		}

		


}
