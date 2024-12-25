package Testing;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Controller.AddLibrarian_Controller;
import Files.Files_User;
import Model.AccessLevel;
import Model.Employee;
import View.AddLibrarianView;

import java.time.LocalDate;
import java.util.concurrent.CountDownLatch;

public class AddLibrarianTest {

    private AddLibrarianView view;
    private Files_User file;
    private AddLibrarian_Controller controller;
    private ObservableList<Employee> employeeList;

    @BeforeEach
    void setUp() throws Exception {
        // Initialize JavaFX runtime
        new JFXPanel(); // This initializes the JavaFX Toolkit

        // Use a CountDownLatch to ensure JavaFX initialization completes
        CountDownLatch latch = new CountDownLatch(1);
        Platform.runLater(() -> {
            try {
                view = new AddLibrarianView();
                file = new Files_User();  // Real implementation of Files_User
                controller = new AddLibrarian_Controller(view);

                // Create a mock employee list
                employeeList = FXCollections.observableArrayList();
                file.setEmployeeList(employeeList);
            } finally {
                latch.countDown();
            }
        });
        latch.await(); // Wait for JavaFX initialization to complete
    }

    @Test
    void testAddManager_Successful() throws Exception {
        Platform.runLater(() -> {
            // Simulate user input using real UI components
            view.getNameField().setText("John");
            view.getSurnameField().setText("Doe");
            view.getBirthdayPicker().setValue(LocalDate.of(1990, 1, 1));
            view.getPhoneNumberField().setText("1234567890");
            view.getSalaryField().setText("50000");
            view.getUserIdField().setText("jdoe");
            view.getPasswordField().setText("password");

            // Call the method to add the librarian
            controller.addLibrarian();

            // Verify that the employee has been added to the employee list and file
            assertEquals(1, employeeList.size(), "One employee should have been added.");
            assertEquals("John", employeeList.get(0).getName(), "The first name should be John.");
            assertEquals("Doe", employeeList.get(0).getSurname(), "The last name should be Doe.");
        });
    }


    @Test
    void testClearFields() throws Exception {
        Platform.runLater(() -> {
            // Set text values to fields to simulate user input
            view.getNameField().setText("John");
            view.getSurnameField().setText("Doe");
            view.getBirthdayPicker().setValue(LocalDate.of(1990, 1, 1));
            view.getPhoneNumberField().setText("1234567890");
            view.getSalaryField().setText("50000");
            view.getUserIdField().setText("jdoe");
            view.getPasswordField().setText("password");

            // Call the method to clear fields
            controller.clearFields();

            // Verify that all fields are cleared
            assertEquals("", view.getNameField().getText(), "Name field should be cleared.");
            assertEquals("", view.getSurnameField().getText(), "Surname field should be cleared.");
            assertNull(view.getBirthdayPicker().getValue(), "Birthday picker should be cleared.");
            assertEquals("", view.getPhoneNumberField().getText(), "Phone number field should be cleared.");
            assertEquals("", view.getSalaryField().getText(), "Salary field should be cleared.");
            assertEquals("", view.getUserIdField().getText(), "User ID field should be cleared.");
            assertEquals("", view.getPasswordField().getText(), "Password field should be cleared.");
        });
    }
}