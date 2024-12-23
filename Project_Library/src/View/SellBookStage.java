package View;

import Controller.SellBook_Controller;
import javafx.scene.Scene;

public class SellBookStage extends OpenStage {
private SellBookView view = new SellBookView();
private SellBook_Controller ctrl = new SellBook_Controller(view);


@Override
public void open() {
	Scene scene = new Scene(view,700,500);
	view.getStageBook().setScene(scene);
	view.getStageBook().show();
	
}



public SellBookView getView() {
	return view;
}
public void setView(SellBookView view) {
	this.view = view;
}
public SellBook_Controller getCtrl() {
	return ctrl;
}
public void setCtrl(SellBook_Controller ctrl) {
	this.ctrl = ctrl;
}

}
