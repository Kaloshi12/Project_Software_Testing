package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.time.LocalDate;
import Files.Files_User;
import Model.AccessLevel;
import Model.Employee;
import View.AddLibrarianView;
import View.AddManagerView;

public class AddLibrarian_Controller {
    private  AddLibrarianView view = new AddLibrarianView();
    private Files_User file;
    private ObservableList<Employee> libList = FXCollections.observableArrayList();
    public AddLibrarian_Controller(AddLibrarianView view,Files_User file) {
        this.view = view;
        this.file = file;
        AccessLevel level = AccessLevel.LIBRARIAN;
        for(Employee user : file.getAll()) {
        	AccessLevel userLevel = user.getLevel();
        	if(level.equals(userLevel)) {
        		libList.add(user);
        	}
        }
        view.getLibrarianTableView().setItems(libList);
        view.getAddButton().setOnAction(e -> addManager());
    }

    public boolean addManager() {
    	if (!validateInputs()) {
            return false;
        }
        String name = view.getNameField().getText();
        String surname = view.getSurnameField().getText();
        LocalDate birthday = view.getBirthdayPicker().getValue();  
        String phoneNumber = view.getPhoneNumberField().getText();
        double salary;

        try {
            salary = Double.parseDouble(view.getSalaryField().getText());
        } catch (NumberFormatException e) {
            showWrongAlert("Error", "Invalid salary format. Please enter a valid number.");
            return false;
        }

        String userId = view.getUserIdField().getText();
        String password = view.getPasswordField().getText();
      
        for (Employee existingUser: libList) {
            if (existingUser.getName().equals(name) && existingUser.getSurname().equals(surname)) {
                showWrongAlert("Error", "Manager with the same name and surname already exists. Please choose a different one.");
                return false;
            }
            if (existingUser.getUserId().equals(userId)) {
                showWrongAlert("Error", "User ID already exists. Please choose a different one.");
                return false;
            }
        }

        
        Employee librarian= new Employee(name, surname, birthday, phoneNumber, salary, AccessLevel.MANAGER, userId, password);
        
        	file.create(librarian);
            
        	System.out.println("Saved successfully");
            clearFields();
            
            view.getLibrarianTableView().getItems().add(librarian);
        

        

        clearFields();
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
    private boolean validateInputs() {
        // Validate name and surname inputs
        if (!validInput(view.getNameField().getText().trim(), "Name") || 
            !validInput(view.getSurnameField().getText().trim(), "Surname")) {
            return false;
        }

       

        return true;
    }
    
//    private void showSuccessAlert(String title,String message) {
//        Alert alert = new Alert(AlertType.NONE);
//        alert.setTitle("Success");
//        alert.setHeaderText(title);
//        alert.setContentText(message);
//        alert.showAndWait();
//    }

    public void showWrongAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void setFile(Files_User file) {
        this.file = file;
    }
}
