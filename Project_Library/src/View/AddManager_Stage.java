package View;

import Controller.AddManagerController;
import Files.Files_User;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddManager_Stage extends OpenStage{
private AddManagerView view = new AddManagerView(new Stage());
private Files_User file =  new Files_User();
private AddManagerController  ctrl = new AddManagerController (view,file);

@Override
public void open() {
	Scene scene = new Scene(view,800,500);
	view.getStage().setScene(scene);
	view.getStage().show();
}
public AddManagerController getCtrl() {
	return ctrl;
}
public void setCtrl(AddManagerController ctrl) {
	this.ctrl = ctrl;
}
}
