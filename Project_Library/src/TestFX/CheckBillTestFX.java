package TestFX;

import View.Bill_IdView;
import View.LoginView;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;

public class CheckBillTestFX extends ApplicationTest {
    private LoginView loginView;
    private Bill_IdView billIdView;

    @Override
    public void start(Stage stage) {
        // Initialize views and set up the scene for testing
        loginView = new LoginView();
        Scene scene = new Scene(loginView, 800, 400);
        stage.setScene(scene);
        stage.setTitle("Login Test");
        stage.show();
    }

    @Test
    public void testAddBook() {
        // Simulate user input for login
        clickOn("#username").write("Franko98");
        clickOn("#password").write("12345678");
        clickOn("#login");

        verifyThat("#success", node -> {
            Text text = (Text) node;
            return text.getFill().equals(Color.GREEN);
        });

        // Switch to Bill_IdView for further interaction
        sleep(1000); // Allow time for the stage change
        clickOn("#bill");

        clickOn("#billList"); // Focus the list
        type(KeyCode.DOWN);
        type(KeyCode.DOWN);
        type(KeyCode.DOWN);
        type(KeyCode.DOWN);
        type(KeyCode.DOWN);


        clickOn("#detailsBill");
        sleep(1000);
    }
}
