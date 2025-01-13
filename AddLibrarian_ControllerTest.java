package Testing;

import Controller.AddLibrarian_Controller;
import Files.Files_User;
import Model.Employee;
import View.AddLibrarianView;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class AddLibrarian_ControllerTest {

    private AddLibrarianView view;
    private Files_User file;
    private AddLibrarian_Controller controller;

    @BeforeEach
    void setUp() {
        // Manually create mocks
        view = mock(AddLibrarianView.class);
        file = mock(Files_User.class);

        // Mock view components
        TextField nameField = mock(TextField.class);
        TextField surnameField = mock(TextField.class);
        DatePicker birthdayPicker = mock(DatePicker.class);
        TextField phoneNumberField = mock(TextField.class);
        TextField salaryField = mock(TextField.class);
        TextField userIdField = mock(TextField.class);
        TextField passwordField = mock(TextField.class);
        TableView<Employee> tableView = mock(TableView.class);
        Button addButton = mock(Button.class);

        when(view.getNameField()).thenReturn(nameField);
        when(view.getSurnameField()).thenReturn(surnameField);
        when(view.getBirthdayPicker()).thenReturn(birthdayPicker);
        when(view.getPhoneNumberField()).thenReturn(phoneNumberField);
        when(view.getSalaryField()).thenReturn(salaryField);
        when(view.getUserIdField()).thenReturn(userIdField);
        when(view.getPasswordField()).thenReturn(passwordField);
        when(view.getLibrarianTableView()).thenReturn(tableView);
        when(view.getAddButton()).thenReturn(addButton);

        // Initialize controller
        controller = new AddLibrarian_Controller(view);
    }

    @Test
    void testAddLibrarianWithValidInput() {
        // Set up valid mock inputs
        when(view.getNameField().getText()).thenReturn("John");
        when(view.getSurnameField().getText()).thenReturn("Doe");
        when(view.getBirthdayPicker().getValue()).thenReturn(LocalDate.of(1990, 1, 1));
        when(view.getPhoneNumberField().getText()).thenReturn("123456789");
        when(view.getSalaryField().getText()).thenReturn("50000");
        when(view.getUserIdField().getText()).thenReturn("lib123");
        when(view.getPasswordField().getText()).thenReturn("password123");

        // Mock the file behavior to avoid real file operations
        when(file.getAll()).thenReturn(FXCollections.observableArrayList());

        // Call the method to test
        controller.addManager();

        // Verify the librarian was added to the table view
        verify(view.getLibrarianTableView()).getItems().add(any(Employee.class));

        // Verify the fields were cleared
        verify(view.getNameField()).clear();
        verify(view.getSurnameField()).clear();
        verify(view.getBirthdayPicker()).setValue(null);
        verify(view.getPhoneNumberField()).clear();
        verify(view.getSalaryField()).clear();
        verify(view.getUserIdField()).clear();
        verify(view.getPasswordField()).clear();
    }
}
