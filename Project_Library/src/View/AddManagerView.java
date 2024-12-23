package View;

import javafx.beans.property.SimpleObjectProperty; 
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.time.LocalDate;
import Model.Employee;


public class AddManagerView extends GridPane {
    private TextField nameField;
    private TextField surnameField;
    private DatePicker birthdayPicker;  // Changed from TextField to DatePicker
    private TextField phoneNumberField;
    private TextField salaryField;
    private TextField userIdField;
    private TextField passwordField;
    private Button addButton;
    private Button delete;
    private Text messageText;
    private Stage stage;
    private TableView<Employee> managerTableView;

    public AddManagerView() {
        stage = new Stage();

        setPadding(new Insets(10));
        setHgap(10);
        setVgap(10);

        nameField = new TextField();
        surnameField = new TextField();
        birthdayPicker = new DatePicker();  
        phoneNumberField = new TextField();
        salaryField = new TextField();
        userIdField = new TextField();
        passwordField = new TextField();

        addButton = new Button("Add Manager");
        delete = new Button("Delete");
        messageText = new Text();
        messageText.setStyle("-fx-fill: red;");

        managerTableView = createManagerTableView();

        add(new Label("Name:"), 0, 0);
        add(nameField, 1, 0);
        add(new Label("Surname:"), 0, 1);
        add(surnameField, 1, 1);
        add(new Label("Birthday:"), 0, 2);
        add(birthdayPicker, 1, 2);
        add(new Label("Phone Number:"), 0, 3);
        add(phoneNumberField, 1, 3);
        add(new Label("Salary:"), 0, 4);
        add(salaryField, 1, 4);
        add(new Label("User ID:"), 0, 5);
        add(userIdField, 1, 5);
        add(new Label("Password:"), 0, 6);
        add(passwordField, 1, 6);
        add(addButton, 0, 7, 2, 1);
        add(delete , 1,7,2,1);
        add(messageText, 0, 8, 2, 1);
        add(managerTableView, 2, 0, 1, 9);
        setColumnSpan(managerTableView, 2);
    }

    public Button getDelete() {
		return delete;
	}

	public void setDelete(Button delete) {
		this.delete = delete;
	}

	@SuppressWarnings("unchecked")
    private TableView<Employee> createManagerTableView() {
        TableView<Employee> tableView = new TableView<>();
        tableView.setEditable(true);
        TableColumn<Employee, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getName()));

        TableColumn<Employee, String> surnameColumn = new TableColumn<>("Surname");
        surnameColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getSurname()));

        TableColumn<Employee, LocalDate> birthdayColumn = new TableColumn<>("Birthday");
        birthdayColumn.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getBirthday()));

        // Update the cell factory to handle LocalDate
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
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));

        TableColumn<Employee, String> userIdColumn = new TableColumn<>("User ID");
        userIdColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getUserId()));

        tableView.getColumns().addAll(nameColumn, surnameColumn, birthdayColumn,
                phoneNumberColumn, salaryColumn, userIdColumn);

        return tableView;
    }


    public TableView<Employee> getManagerTableView() {
        return managerTableView;
    }

    public void setManagerTableView(TableView<Employee> managerTableView) {
        this.managerTableView = managerTableView;
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