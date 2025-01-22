package Controller;



import java.util.Iterator;

import Files.Files_User;
import Model.AccessLevel;
import Model.Employee;
import View.ChangeRoleView;

public class ChangeRole_Controller {
    private ChangeRoleView view;
    private Files_User file;

    public ChangeRole_Controller(ChangeRoleView view,Files_User file) {
        this.view = view;
        this.file = file;
        view.getSubmitButton().setOnAction(e -> changeRole());
    }

    public Employee changeRole() {
        String pickedFirstName = view.getFirstNameTextField().getText();
        String pickedLastName = view.getLastNameTextField().getText();
        AccessLevel pickedLevel = getAccessFromText(view.getAccessLevelMenuButton().getText());

        Iterator<Employee> iterator = file.getAll().iterator();
        while (iterator.hasNext()) {
            Employee user = iterator.next();
            if (pickedFirstName.equals(user.getName()) && pickedLastName.equals(user.getSurname())) {
                iterator.remove();  // Remove the element from the collection
                Employee newUser = new Employee(user.getName(), user.getSurname(), user.getBirthday(), user.getPhoneNumber(), user.getSalary(), pickedLevel, user.getUserId(), user.getPassword());
                file.create(newUser);
                // Break the loop once a match is found, assuming there's only one matching user
                return newUser;
            }
        }
        return null;
    }



    private AccessLevel getAccessFromText(String accessText) {
        for (AccessLevel access : AccessLevel.values()) {
            if (access.toString().replace("_", " ").equals(accessText)) {
                return access;
            }
        }
        return null;
    }

    public ChangeRoleView getView() {
        return view;
    }

    public void setView(ChangeRoleView view) {
        this.view = view;
    }
}
