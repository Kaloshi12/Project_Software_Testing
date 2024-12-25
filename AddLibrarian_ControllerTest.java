package Testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import Controller.AddLibrarian_Controller;
import Files.Files_User;
import Model.AccessLevel;
import Model.Employee;
import View.AddLibrarianView;

class AddLibrarian_ControllerTest {
    AddLibrarianView view;
    AddLibrarian_Controller controller;
    Files_User file;

    @BeforeEach
    void setUp() {
        view = mock(AddLibrarianView.class);
        controller = new AddLibrarian_Controller(view);
        file = mock(Files_User.class);
        controller.setFile(file);
    }

    @ParameterizedTest
    @CsvSource({
        "500, true",      
        "0.1, true",      
        "70000, true",    
        "0, false",       
        "70001, false",   
        "-100, false",    
        "100000, false"   
    })
    void testAddLibrarian(double salary, boolean isValid) {
    	 when(view.getNameField().getText()).thenReturn("Franko");
    	    when(view.getSurnameField().getText()).thenReturn("Kaloshi");
    	    when(view.getBirthdayPicker().getValue()).thenReturn(LocalDate.of(1990, 1, 1));
    	    when(view.getPhoneNumberField().getText()).thenReturn("1234567890");
    	    when(view.getSalaryField().getText()).thenReturn(String.valueOf(salary));
    	    when(view.getUserIdField().getText()).thenReturn("Franko98");
    	    when(view.getPasswordField().getText()).thenReturn("123456789");
    	    boolean result = controller.addLibrarian();
    	    assertEquals(isValid,result);
    	    
    	    verify(file, times(1)).create(argThat(employee -> 
            employee.getName().equals("John") &&
            employee.getSurname().equals("Doe") &&
            employee.getBirthday().equals(LocalDate.of(1990, 1, 1)) &&
            employee.getPhoneNumber().equals("1234567890") &&
            employee.getSalary() == salary &&
            employee.getUserId().equals("johndoe") &&
            employee.getPassword().equals("password")
        ));

    }
    @Test
    void testVaildateInput() {
    	when(view.getNameField().getText()).thenReturn("John");
        when(view.getSurnameField().getText()).thenReturn("Doe");
        assertTrue(controller.validateInputs());

        when(view.getNameField().getText()).thenReturn("J");
        when(view.getSurnameField().getText()).thenReturn("Doe");
        assertFalse(controller.validateInputs());

        when(view.getNameField().getText()).thenReturn("John");
        when(view.getSurnameField().getText()).thenReturn("D");
        assertFalse(controller.validateInputs());
        when(view.getNameField().getText()).thenReturn("J");
        when(view.getSurnameField().getText()).thenReturn("D");
        assertFalse(controller.validateInputs());
    }
}
