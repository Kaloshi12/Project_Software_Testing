package View;

import Controller.ChangeRole_Controller;
import Files.Files_User;
import javafx.scene.Scene;

public class ChangeRoleStage extends OpenStage{
private ChangeRoleView view = new ChangeRoleView();
private Files_User file = new Files_User();
private ChangeRole_Controller ctrl = new ChangeRole_Controller(view,file);
	@Override
	public void open() {
		Scene scene = new Scene(view,400,300);
		view.getStage().setScene(scene);
		view.getStage().show();
	}

}
