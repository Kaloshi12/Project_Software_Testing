package View;

import Model.AccessLevel;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChangeRoleView extends GridPane {
private Stage stage;
private Button submitButton;
private TextField firstNameTextField;
private MenuButton accessLevelMenuButton;
private TextField lastNameTextField;

    public Button getSubmitButton() {
	return submitButton;
}
public void setSubmitButton(Button submitButton) {
	this.submitButton = submitButton;
}
public TextField getFirstNameTextField() {
	return firstNameTextField;
}
public void setFirstNameTextField(TextField firstNameTextField) {
	this.firstNameTextField = firstNameTextField;
}
public MenuButton getAccessLevelMenuButton() {
	return accessLevelMenuButton;
}
public void setAccessLevelMenuButton(MenuButton accessLevelMenuButton) {
	this.accessLevelMenuButton = accessLevelMenuButton;
}
public TextField getLastNameTextField() {
	return lastNameTextField;
}
public void setLastNameTextField(TextField lastNameTextField) {
	this.lastNameTextField = lastNameTextField;
}
	public ChangeRoleView() {
    	stage = new Stage();
    	stage.setTitle("Permission");
        this.setVgap(10);
        this.setHgap(10);
        this.setPadding(new Insets(10));

        // Labels and TextFields
        Label firstNameLabel = new Label("First Name:");
        firstNameLabel.setId("firstname");
        firstNameTextField = new TextField();

        Label lastNameLabel = new Label("Last Name:");
        lastNameTextField = new TextField();
        lastNameTextField.setId("lastname");

        // MenuButton for Access Level
        Label accessLevelLabel = new Label("Access Level:");
        accessLevelMenuButton = new MenuButton("Select Access Level");
        accessLevelMenuButton.setId("accLevelBtn");
        for (AccessLevel level : AccessLevel.values()) {
            MenuItem menuItem = new MenuItem(level.toString());
            menuItem.setOnAction(e -> accessLevelMenuButton.setText(menuItem.getText()));
            accessLevelMenuButton.getItems().add(menuItem);
        }

        
        submitButton = new Button("Submit");
        submitButton.setId("submit");
       
        
        this.add(firstNameLabel, 0, 0);
        this.add(firstNameTextField, 1, 0);

        this.add(lastNameLabel, 0, 1);
        this.add(lastNameTextField, 1, 1);

        this.add(accessLevelLabel, 0, 2);
        this.add(accessLevelMenuButton, 1, 2);

        this.add(submitButton, 0, 3, 2, 1);
    }
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}

   
}
