package View;

import Controller.AddLibrarian_Controller;

import javafx.scene.Scene;

public class AddLibrarianStage extends OpenStage {
private AddLibrarianView view = new AddLibrarianView();
private AddLibrarian_Controller ctrl = new AddLibrarian_Controller(view);

@Override
public void open() {
    Scene scene = new Scene(view, 800, 500);
    view.getStage().setScene(scene);
    view.getStage().show();
}



public AddLibrarian_Controller getCtrl() {
	return ctrl;
}

public void setCtrl(AddLibrarian_Controller ctrl) {
	this.ctrl = ctrl;
}

public AddLibrarianView getView() {
	return view;
}

public void setView(AddLibrarianView view) {
	this.view = view;
}

}
