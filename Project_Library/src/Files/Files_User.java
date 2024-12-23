package Files;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.AccessLevel;
import Model.Employee;

public class Files_User {

    public static final String FILE_PATH = "src/BinaryFiles/User.dat";
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
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            System.out.println("Reading employees from file...");

            while (true) {
                try {
                    Employee employee = (Employee) inputStream.readObject();
                    System.out.println(employee);
                    listEmployees.add(employee);
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("Reading complete.");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return listEmployees;
    }

    public boolean create(Employee employee) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE, true))) {
            outputStream.writeObject(employee);
            listEmployees.add(employee);
            updateAll();
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
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public boolean delete(Employee employee) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            for (Employee e : listEmployees) {
                if (!e.equals(employee))
                    outputStream.writeObject(e);
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
                if (!employeesToRemove.contains(e))
                    outputStream.writeObject(e);
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
