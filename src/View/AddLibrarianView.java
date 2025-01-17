package View;


import java.time.LocalDate;

import Model.Employee;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


	public class AddLibrarianView extends Parent {
	    private TextField nameField;
	    private TextField surnameField;
	    private DatePicker birthdayPicker;
	    private TextField phoneNumberField;
	    private TextField salaryField;
	    private TextField userIdField;
	    private TextField passwordField;
	    private Button addButton;
	    private Text messageText;
	    private Stage stage;
	    private TableView<Employee> librarianTableView;
	     

		public AddLibrarianView() {
			stage = new Stage();

	        
	        nameField = new TextField();
	        surnameField = new TextField();
	        birthdayPicker = new DatePicker();  
	        phoneNumberField = new TextField();
	        salaryField = new TextField();
	        userIdField = new TextField();
	        passwordField = new TextField();

	        addButton = new Button("Add Manager");

	        messageText = new Text();
	        messageText.setStyle("-fx-fill: red;");

	        librarianTableView = createLibrarianTableView();

	       
		}







		@SuppressWarnings("unchecked")
		public TableView<Employee> createLibrarianTableView() {
		    TableView<Employee> tableView = new TableView<>();
		    TableColumn<Employee, String> nameColumn = new TableColumn<>("Name");
		    nameColumn.setCellValueFactory(cellData ->
		            new SimpleStringProperty(cellData.getValue().getName()));

		    TableColumn<Employee, String> surnameColumn = new TableColumn<>("Surname");
		    surnameColumn.setCellValueFactory(cellData ->
		            new SimpleStringProperty(cellData.getValue().getSurname()));

		    TableColumn<Employee, LocalDate> birthdayColumn = new TableColumn<>("Birthday");
		    birthdayColumn.setCellValueFactory(cellData ->
		            new SimpleObjectProperty<>(cellData.getValue().getBirthday()));

		    birthdayColumn.setCellFactory(column -> new TableCell<Employee, LocalDate>() {
		        @Override
		        protected void updateItem(LocalDate item, boolean empty) {
		            super.updateItem(item, empty);
		            if (item == null || empty) {
		                setText(null);
		            } else {
		                setText(item.toString());
		            }
		        }
		    });

		    TableColumn<Employee, String> phoneNumberColumn = new TableColumn<>("Phone Number");
		    phoneNumberColumn.setCellValueFactory(cellData ->
		            new SimpleStringProperty(cellData.getValue().getPhoneNumber()));

		    TableColumn<Employee, Double> salaryColumn = new TableColumn<>("Salary");
		    salaryColumn.setCellValueFactory(cellData ->
		            new SimpleObjectProperty<>(cellData.getValue().getSalary()));

		    TableColumn<Employee, String> userIdColumn = new TableColumn<>("User ID");
		    userIdColumn.setCellValueFactory(cellData ->
		            new SimpleStringProperty(cellData.getValue().getUserId()));

		    tableView.getColumns().addAll(nameColumn, surnameColumn, birthdayColumn,
		            phoneNumberColumn, salaryColumn, userIdColumn);

		    return tableView;
		}

		
			public TableView<Employee> getLibrarianTableView() {
			return librarianTableView;
		}

		public void setlibrarianTableView(TableView<Employee> librarianTableView) {
			this.librarianTableView = librarianTableView;
		}

			public TextField getNameField() {
				return nameField;
			}


			public void setNameField(TextField nameField) {
				this.nameField = nameField;
			}

			public TextField getSurnameField() {
				return surnameField;
			}

			public void setSurnameField(TextField surnameField) {
				this.surnameField = surnameField;
			}


			 public DatePicker getBirthdayPicker() {
			        return birthdayPicker;
			    }

			    public void setBirthdayPicker(DatePicker birthdayPicker) {
			        this.birthdayPicker = birthdayPicker;
			    }

			public TextField getPhoneNumberField() {
				return phoneNumberField;
			}


			public void setPhoneNumberField(TextField phoneNumberField) {
				this.phoneNumberField = phoneNumberField;
			}
		


			public TextField getSalaryField() {
				return salaryField;
			}

			public void setSalaryField(TextField salaryField) {
				this.salaryField = salaryField;
			}

			public TextField getUserIdField() {
				return userIdField;
			}

			public void setUserIdField(TextField userIdField) {
				this.userIdField = userIdField;
			}

			public TextField getPasswordField() {
				return passwordField;
			}


			public void setPasswordField(TextField passwordField) {
				this.passwordField = passwordField;
			}

			public Button getAddButton() {
				return addButton;
			}


			public void setAddButton(Button addButton) {
				this.addButton = addButton;
			}

			public Text getMessageText() {
				return messageText;
			}


			public void setMessageText(Text messageText) {
				this.messageText = messageText;
			}

			public Stage getStage() {
				return stage;
			}

			public void setStage(Stage stage) {
				this.stage = stage;
			}



	}

