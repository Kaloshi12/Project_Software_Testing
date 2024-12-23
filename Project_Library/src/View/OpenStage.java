package View;
import javafx.stage.Stage;

public abstract class OpenStage {
    private Stage lstage = new Stage();

    public Stage getLstage() {
        return lstage;
    }

    public abstract void open();
}
