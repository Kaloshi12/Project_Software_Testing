package View;

import Controller.Admin_View_Controller;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminStage extends OpenStage{
	private Admin_View view = new Admin_View(new Stage());
	private Admin_View_Controller control = new Admin_View_Controller(view);
	
	public Admin_View_Controller getControl() {
		return control;
	}

	public void setControl(Admin_View_Controller control) {
		this.control = control;
	}

	public Admin_View getView() {
		return view;
	}

	public void setView(Admin_View view) {
		this.view = view;
	}

	@Override
	public void open() {
		Scene scene = new Scene(view,600,500);
		view.getAstage().setScene(scene);
		view.getAstage().setTitle("Admin");
		view.getAstage().show();
	}

}
