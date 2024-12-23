package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Files.Files_User;
import Model.AccessLevel;
import Model.Employee;

import View.AddManagerView;

public class AddManagerController {
    private AddManagerView view;
    private Files_User file;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
    LocalDate date;
    private ObservableList<Employee> managerList = FXCollections.observableArrayList();

    public AddManagerController(AddManagerView view) {
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
        view.getAddButton().setOnAction(e -> addManager());
    }

    public void addManager() {
        if (!validateInputs()) {
            return;
        }

        String name = view.getNameField().getText().trim();
        String surname = view.getSurnameField().getText().trim();
        LocalDate birthday = view.getBirthdayPicker().getValue();
        String phoneNumber = view.getPhoneNumberField().getText().trim();
        double salary;

        try {
            salary = Double.parseDouble(view.getSalaryField().getText().trim());
        } catch (NumberFormatException e) {
            showWrongAlert("Error", "Invalid salary format. Please enter a valid number.");
            return;
        }

        String userId = view.getUserIdField().getText().trim();

        for (Employee existingUser : managerList) {
            if (existingUser.getName().equalsIgnoreCase(name) && existingUser.getSurname().equalsIgnoreCase(surname)) {
                showWrongAlert("Error", "Manager with the same name and surname already exists. Please choose a different one.");
                return;
            }
            if (existingUser.getUserId().equalsIgnoreCase(userId)) {
                showWrongAlert("Error", "User ID already exists. Please choose a different one.");
                return;
            }
        }

        AccessLevel managerLevel = AccessLevel.MANAGER;
        Employee manager = new Employee(name, surname, birthday, phoneNumber, salary, managerLevel, userId, view.getPasswordField().getText());

        if (!file.getAll().contains(manager)) {
            file.create(manager);
            System.out.println("Manager saved");
        }
  

        managerList.add(manager);
        view.getManagerTableView().getItems().add(manager);
        clearFields();
    }

    private boolean validateInputs() {
        // Validate name and surname inputs
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
