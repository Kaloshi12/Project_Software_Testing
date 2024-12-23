package View;

import Controller.AddManagerController;
import javafx.scene.Scene;

public class AddManager_Stage extends OpenStage{
private AddManagerView view = new AddManagerView();
private AddManagerController  ctrl = new AddManagerController (view);
//private DeleteMenager ctrl1 = new DeleteMenager(view); 
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
