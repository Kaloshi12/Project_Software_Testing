package View;

import Controller.DeleteBook_Controller;
import javafx.scene.Scene;

public class DeleteBookStage extends OpenStage {
    private DeleteBooks view;
    private DeleteBook_Controller ctrl;

    public DeleteBookStage() {
        view = new DeleteBooks();
        ctrl = new DeleteBook_Controller(view);
    }

    @Override
    public void open() {
        Scene scene = new Scene(view, 600, 700);
        view.getStageBook().setScene(scene);
        view.getStageBook().show();
    }

    public DeleteBooks getView() {
        return view;
    }

    public void setView(DeleteBooks view) {
        this.view = view;
    }

    public DeleteBook_Controller getCtrl() {
        return ctrl;
    }

    public void setCtrl(DeleteBook_Controller ctrl) {
        this.ctrl = ctrl;
    }
}
