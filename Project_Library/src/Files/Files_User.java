package Files;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.AccessLevel;
import Model.Employee;

public class Files_User {

    public static  String FILE_PATH = "Project_Library/src/BinaryFiles/User.dat";
    private static final File DATA_FILE = new File(FILE_PATH);
    private ObservableList<Employee> listEmployees = FXCollections.observableArrayList();

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
    private static final LocalDate date = LocalDate.parse("98-08-09", formatter);
    private static final LocalDate date1 = LocalDate.parse("03-08-05", formatter);
    private static final LocalDate date2 = LocalDate.parse("04-08-05", formatter);

    public ObservableList<Employee> getListEmployees() {
        return listEmployees;
    }

    public void setListEmployees(ObservableList<Employee> listEmployees) {
        this.listEmployees = listEmployees;
    }

    public static String getFilePath() {
        return FILE_PATH;
    }

    public static File getDataFile() {
        return DATA_FILE;
    }

    public ObservableList<Employee> getAll() {
        loadEmployeesFromFile();
        return listEmployees;
    }

    public ObservableList<Employee> loadEmployeesFromFile() {
        ObservableList<Employee> employees = FXCollections.observableArrayList();
        File file = new File(Files_User.FILE_PATH); // Ensure this points to the correct file
        if (!file.exists() || file.length() == 0) {
            // Return an empty list if the file doesn't exist or is empty
            return employees;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object readObject = ois.readObject();
            if (readObject instanceof ObservableList) {
                employees = (ObservableList<Employee>) readObject;
            } else {
                System.out.println("Unexpected object type in file: " + readObject.getClass());
            }
        } catch (EOFException e) {
            // Handle end-of-file exception gracefully
            System.out.println("File is empty or corrupted: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }



    public boolean create(Employee employee) {
        // Ensure the directory exists before writing the file
        File directory = new File("src/BinaryFiles");
        if (!directory.exists()) {
            directory.mkdirs();  // Create the directory if it doesn't exist
        }

        // Ensure the file exists before writing to it
        File file = new File(Files_User.FILE_PATH);
        if (!file.exists()) {
            try {
                file.createNewFile();  // Create the file if it doesn't exist
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE, true))) {
            System.out.println("Creating employee: " + employee.getUserId());
            outputStream.writeObject(employee);
            listEmployees.add(employee);
            updateAll();  // Ensure the list is updated after adding the employee
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static void seedData() {
        File file = new File(Files_User.FILE_PATH);
        if (file.length() == 0) {
            Employee[] employees = {
                    new Employee("Enio", "Bica", date2, "+35569845185", 600.0, AccessLevel.LIBRARIAN, "Enio", "12345678"),
                    new Employee("Herion", "Halilaj", date1, "+3558550090", 1000.0, AccessLevel.MANAGER, "Herion03", "12345678"),
                    new Employee("Franko", "Kaloshi", date, "+355688459875", 5000.0, AccessLevel.ADMINISTRATOR, "Franko98", "12345678")
            };

            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
                for (Employee employee : employees) {
                    outputStream.writeObject(employee);
                    System.out.println("Writing employee: " + employee.getUserId()); // Add logging
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }


    public boolean delete(Employee employee) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            for (Employee e : listEmployees) {
                if (!e.equals(employee)) {
                    outputStream.writeObject(e);
                }
            }
            listEmployees.remove(employee);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean deleteAll(List<Employee> employeesToRemove) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            for (Employee e : listEmployees) {
                if (!employeesToRemove.contains(e)) {
                    outputStream.writeObject(e);
                }
            }
            listEmployees.removeAll(employeesToRemove);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean updateAll() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            for (Employee e : listEmployees) {
                outputStream.writeObject(e);
            }
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void setEmployeeList(ObservableList<Employee> employeeList) {
        this.listEmployees = employeeList;
    }
}
