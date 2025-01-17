package View;

import Controller.MenuMenager_Controller;
import javafx.scene.Scene;

public class MenuManagerStage extends OpenStage{
private MenuManagerView view = new MenuManagerView();
private MenuMenager_Controller  ctrl = new MenuMenager_Controller(view);
public MenuMenager_Controller getCtrl() {
	return ctrl;
}

public void setCtrl(MenuMenager_Controller ctrl) {
	this.ctrl = ctrl;
}

@Override
public void open() {
	Scene scene = new Scene(view,600,500);
	view.getMstage().setScene(scene);
	view.getMstage().show();
}

public MenuManagerView getView() {
	return view;
}

public void setView(MenuManagerView view) {
	this.view = view;
}

}
