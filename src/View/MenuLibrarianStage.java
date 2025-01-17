package View;

import Controller.MenuLibrarian_Controller;
import javafx.scene.Scene;

public class MenuLibrarianStage extends OpenStage {

    private MenuLibrarianView view;
    private MenuLibrarian_Controller ctrl;

    public MenuLibrarianStage() {
        this.view = new MenuLibrarianView();
        this.ctrl = new MenuLibrarian_Controller(view);
    }

    public MenuLibrarianView getView() {
        return view;
    }

    public void setView(MenuLibrarianView view) {
        this.view = view;
    }

    public MenuLibrarian_Controller getCtrl() {
        return ctrl;
    }

    public void setCtrl(MenuLibrarian_Controller ctrl) {
        this.ctrl = ctrl;
    }

    @Override
    public void open() {
        Scene scene = new Scene(view, 500, 600);
        getLstage().setScene(scene);
        getLstage().show();
    }
}
