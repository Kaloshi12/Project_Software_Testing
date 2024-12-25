package Testing;

import static org.mockito.Mockito.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Controller.DeleteMenager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.AccessLevel;
import Model.Employee;
import Files.Files_User;
import View.AddManagerView;

class DeleteManagerCoverageTest {

    private DeleteMenager deleteManager;
    private Files_User file;
    private AddManagerView view;

    @BeforeEach
    void setUp() {
        view = mock(AddManagerView.class);
        file = mock(Files_User.class);
        deleteManager = new DeleteMenager(view);
        ObservableList<Employee> managerList = FXCollections.observableArrayList();
        managerList.add(new Employee("John", "Doe", LocalDate.of(1990, 1, 1), "1234567890", 50000, AccessLevel.MANAGER, "johndoe", "password"));
        managerList.add(new Employee("Jane", "Smith", LocalDate.of(1985, 2, 20), "0987654321", 60000, AccessLevel.MANAGER, "janesmith", "password"));
        when(file.getAll()).thenReturn(managerList);
        deleteManager.setManagerList(managerList);
    }

    @Test
    void testRemoveManager_ValidInputs() {
        when(view.getNameField().getText()).thenReturn("John");
        when(view.getSurnameField().getText()).thenReturn("Doe");

        deleteManager.removeManager();

        verify(file, times(1)).delete(any(Employee.class));
        verify(view.getManagerTableView().getItems(), times(1)).remove(any(Employee.class));
    }

    @Test
    void testRemoveManager_InvalidInputs() {
        when(view.getNameField().getText()).thenReturn("J");
        when(view.getSurnameField().getText()).thenReturn("D");

        deleteManager.removeManager();

        verify(file, never()).delete(any(Employee.class));
        verify(view, times(1)).showWrongAlert(eq("Failed"), anyString());
    }

    @Test
    void testRemoveManager_ManagerNotFound() {
        when(view.getNameField().getText()).thenReturn("NonExistent");
        when(view.getSurnameField().getText()).thenReturn("Manager");

        deleteManager.removeManager();

        verify(file, never()).delete(any(Employee.class));
        verify(view.getManagerTableView().getItems(), never()).remove(any(Employee.class));
    }

}
