package View;



import java.util.ArrayList;
import java.util.List;

import Files.Files_Book;
import Model.Book;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Admin_View extends Pane {
	private Text text;
	private Text register;
	private Button showBooks;
	private Button addBooks;
	private Button showSoldBooks;
	private Button delete;
	private Button register_Manager;
	private Button regiser_Librarian;
	private Button check_Librarian;
	private Button Permission;
	private Stage Astage;
	private Files_Book file = new Files_Book();
	private BookListView books = new BookListView();
	private Button logOut;

		 public Admin_View(Stage stage){

			Astage = new Stage();
			Astage.setTitle("Administrator");
			Astage.setOnShown(e -> {
		        Message();
		    });
			text = new Text();
			text.setText("Welcome Admin");
			text.setLayoutX(150);
			text.setLayoutY(50);
			text.setFont(Font.font("Arial", FontPosture.ITALIC, 50));
			register = new Text();
			register.setText("Register");
			register.setLayoutX(200);
			register.setLayoutY(180);
			register.setFont(Font.font("Arial",FontWeight.BOLD,50));
			addBooks = new Button();
			addBooks.setText("Add Book");
			addBooks.setId("addBookA");
			addBooks.setLayoutX(20);
			addBooks.setLayoutY(400);
			addBooks.setPrefWidth(120);
			addBooks.setPrefHeight(60);
			addBooks.setOnMouseEntered(e -> addBooks.setStyle("-fx-background-color: lightblue;"));
	        addBooks.setOnMouseExited(e -> addBooks.setStyle(null));
			showBooks = new Button();
	        showBooks.setText("Books");
			showBooks.setId("showBooks");
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
			register_Manager = new Button("Manager");
			register_Manager.setLayoutX(150);
			register_Manager.setLayoutY(200);
			register_Manager.setPrefWidth(120);
			register_Manager.setPrefHeight(60);
			register_Manager.setOnMouseEntered(e -> register_Manager.setStyle("-fx-background-color: lightblue;"));
			register_Manager.setOnMouseExited(e -> register_Manager.setStyle(null));
			regiser_Librarian = new Button("Librarian");
			regiser_Librarian.setLayoutX(310);
			regiser_Librarian.setLayoutY(200);
			regiser_Librarian.setPrefWidth(120);
			regiser_Librarian.setPrefHeight(60);
			regiser_Librarian.setOnMouseEntered(e -> regiser_Librarian.setStyle("-fx-background-color: lightblue;"));
			regiser_Librarian.setOnMouseExited(e -> regiser_Librarian.setStyle(null));
			check_Librarian = new Button("Controll");
			check_Librarian.setLayoutX(310);
			check_Librarian.setLayoutY(300);
			check_Librarian.setPrefWidth(120);
			check_Librarian.setPrefHeight(60);
			check_Librarian.setOnMouseEntered(e -> check_Librarian.setStyle("-fx-background-color: lightblue;"));
			check_Librarian.setOnMouseExited(e -> check_Librarian.setStyle(null));
			Permission = new Button("Change Role");
			Permission.setLayoutX(150);
			Permission.setLayoutY(300);
			Permission.setPrefWidth(120);
			Permission.setPrefHeight(60);
			Permission.setOnMouseEntered(e -> Permission.setStyle("-fx-background-color: lightblue;"));
			Permission.setOnMouseExited(e -> Permission.setStyle(null));
			logOut = new Button("LogOut");
			logOut.setLayoutX(5);
			logOut.setLayoutY(20);
			logOut.setPrefWidth(80);
			logOut.setPrefHeight(20);
			logOut.setOnMouseEntered(e -> logOut.setStyle("-fx-background-color: lightblue;"));
			logOut.setOnMouseExited(e -> logOut.setStyle(null));
			getChildren().addAll(text,register,addBooks,showBooks,showSoldBooks,delete,register_Manager,regiser_Librarian,check_Librarian,Permission,logOut);

		}


		public Files_Book getFile() {
			return file;
		}


		public void setFile(Files_Book file) {
			this.file = file;
		}


		public Button getLogOut() {
			return logOut;
		}


		public void setLogOut(Button logOut) {
			this.logOut = logOut;
		}


		public void Message() {
			List<Book> lowQuantityBooks = new ArrayList<>();

			for (Book book : file.getAll()) {
			    if (book.getQuantity() < 5) {
			        lowQuantityBooks.add(book);
			    }
			}

			if (!lowQuantityBooks.isEmpty()) {
			    showAlert("Low Quantity Warning", getBookInfo(lowQuantityBooks));
			}

		}


		private String getBookInfo(List<Book> books) {
		    StringBuilder info = new StringBuilder("The following books have low quantity:\n\n");

		    for (Book book : books) {
		        info.append("Title: ").append(book.getTitle()).append("\n");
		        info.append("Author: ").append(book.getAuthor()).append("\n\n");
		    }

		    return info.toString();
		}


	public Button getPermission() {
			return Permission;
		}


		public void setPermission(Button permission) {
			Permission = permission;
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


		public Stage getAstage() {
			return Astage;
		}


		public void setAstage(Stage Astage) {
			Astage = Astage;
		}
		public Text getRegister() {
			return register;
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


		public Button getRegister_Manager() {
			return register_Manager;
		}


		public void setRegister_Manager(Button register_Manager) {
			this.register_Manager = register_Manager;
		}


		public Button getRegiser_Librarian() {
			return regiser_Librarian;
		}


		public void setRegiser_Librarian(Button regiser_Librarian) {
			this.regiser_Librarian = regiser_Librarian;
		}


		public Button getCheck_Librarian() {
			return check_Librarian;
		}


		public void setCheck_Librarian(Button check_Librarian) {
			this.check_Librarian = check_Librarian;
		}


		 public void showAlert(String title, String content) {
		        Alert alert = new Alert(AlertType.WARNING);
		        alert.setTitle(title);
		        alert.setHeaderText(null);
		        alert.setContentText(content);
		        alert.showAndWait();
		    }


}
