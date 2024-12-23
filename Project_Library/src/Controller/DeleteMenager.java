package Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Files.Files_User;
import Model.AccessLevel;
import Model.Employee;
import View.AddManagerView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DeleteMenager {
	private AddManagerView view;
    private Files_User file;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
    LocalDate date;
    private ObservableList<Employee> managerList = FXCollections.observableArrayList();
    public DeleteMenager(AddManagerView view) {
        this.view = view;
        
        this.file = new Files_User();
        initializeManagerList();
        setupButtonAction();
    }

    private void initializeManagerList() {
        AccessLevel level = AccessLevel.MANAGER;
        managerList.addAll(file.getAll().filtered(user -> level.equals(user.getLevel())));
        view.getManagerTableView().setItems(managerList);
    }

    private void setupButtonAction() {
        view.getDelete().setOnAction(e -> removeManager());
    }

    public void removeManager() {
        if (!validateInputs()) {
            return;
        }

        String name = view.getNameField().getText().trim();
        String surname = view.getSurnameField().getText().trim();
        
        Employee manager;
        for (Employee existingUser : managerList) {
        	if(name.equals(existingUser.getName())&& surname.equals(existingUser.getSurname())) {
        		manager = new Employee(existingUser.getName(),existingUser.getSurname(),existingUser.getBirthday(),existingUser.getPhoneNumber(),existingUser.getSalary(),AccessLevel.MANAGER,existingUser.getUserId(),existingUser.getPassword());
        		file.delete(existingUser);
        		view.getManagerTableView().getItems().remove(existingUser);
        	}
        }
        clearFields();
    }

    private boolean validateInputs() {
        
        if (!validInput(view.getNameField().getText().trim(), "Name") || 
            !validInput(view.getSurnameField().getText().trim(), "Surname")) {
            return false;
        }

       

        return true;
    }

    public void clearFields() {
        view.getNameField().clear();
        view.getSurnameField().clear();
        view.getBirthdayPicker().setValue(null);
        view.getPhoneNumberField().clear();
        view.getSalaryField().clear();
        view.getUserIdField().clear();
        view.getPasswordField().clear();
    }

    public boolean validInput(String input, String fieldName) {
        String regex = "^[a-zA-Z]{2,}$";

        if (!input.matches(regex)) {
            showWrongAlert("Failed", fieldName + " must contain at least two letters.");
            return false;
        }
        return true;
    }

    public void showWrongAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
