package View;

import Controller.Admin_View_Controller;
import Controller.ButtonAdd_Controller;
import javafx.scene.Scene;

public class StageAddBook extends OpenStage {
    private AddBookView add = new AddBookView();
    private ButtonAdd_Controller ctrl = new ButtonAdd_Controller(add);

    public AddBookView getAdd() {
        return add;
    }

    public void setAdd(AddBookView add) {
        this.add = add;
    }

    public ButtonAdd_Controller getCtrl() {
        return ctrl;
    }
    public void setCtrl(ButtonAdd_Controller ctrl) {
        this.ctrl = ctrl;
    }

    @Override
    public void open() {
    	Scene scene = new Scene(add.getRoot(),1230,500);
    	add.getStage().setScene(scene);
    	add.getStage().show();
    }
}
