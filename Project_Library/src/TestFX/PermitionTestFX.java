package TestFX;

import Files.Files_User;
import View.LoginView;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.testfx.api.FxAssert.verifyThat;

public class PermitionTestFX extends ApplicationTest {
    private LoginView loginView;
    private Stage currentStage;

    @Override
    public void start(Stage stage) {
        // Initialize LoginView
        loginView = new LoginView();

        // Set up the primary stage
        Scene scene = new Scene(loginView, 800, 400);
        stage.setScene(scene);
        stage.setTitle("Login Test");
        stage.show();
        currentStage = stage;
    }

    @Test
    public void testPermission() {

        clickOn("#username").write("Franko98");
        clickOn("#password").write("12345678");
        clickOn("#login");

        verifyThat("#success", node -> {
            Text text = (Text) node;
            return text.getFill().equals(Color.GREEN);
        });

        sleep(1000);

        clickOn("#permission");
        verifyThat("#permission", Node::isVisible);

        clickOn("#firstname").write("Enio");

        clickOn("#lastname").write("Bica");


        clickOn("#accLevelBtn");
        type(KeyCode.DOWN);
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);

        clickOn("#submit");
        verifyThat("#submit", Node::isVisible);
    }

}
