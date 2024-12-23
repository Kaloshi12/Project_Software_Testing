package View;

import Controller.ChangeRole_Controller;
import javafx.scene.Scene;

public class ChangeRoleStage extends OpenStage{
private ChangeRoleView view = new ChangeRoleView();
private ChangeRole_Controller ctrl = new ChangeRole_Controller(view);
	@Override
	public void open() {
		Scene scene = new Scene(view,400,300);
		view.getStage().setScene(scene);
		view.getStage().show();
	}

}
