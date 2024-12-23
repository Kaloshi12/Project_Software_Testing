package View;

import Controller.ShoWBill_Controller;
import javafx.scene.Scene;

public class Bill_IdStage extends OpenStage {
private Bill_IdView view = new Bill_IdView();
private ShoWBill_Controller ctrl = new ShoWBill_Controller(view);
	public Bill_IdView getView() {
	return view;
}
public void setView(Bill_IdView view) {
	this.view = view;
}
public ShoWBill_Controller getCtrl() {
	return ctrl;
}
public void setCtrl(ShoWBill_Controller ctrl) {
	this.ctrl = ctrl;
}
	@Override
	public void open() {
	Scene scene = new Scene(view,400,600);
	view.getStage().setScene(scene);
	view.getStage().show();
	}

}
