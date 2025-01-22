package TestFX;

import View.LoginView;
import View.ShowAllBooks;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testfx.api.FxAssert.verifyThat;

public class ShowbookTestFX extends ApplicationTest {

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
    public void testShowBook() {
        // Simulate user input
        clickOn("#username").write("Franko98");
        clickOn("#password").write("12345678");
        clickOn("#login");

        // Verify success message color
        verifyThat("#success", node -> {
            Text text = (Text) node;
            return text.getFill().equals(Color.GREEN); // Verify text color is green
        });

        // Wait for the stage to change to AdminStage
        sleep(1000); // Small delay to allow stage change


        clickOn("#showBooks");

        verifyThat("#showBooks", Node::isVisible);



        clickOn("#desc");
        verifyThat("#desc",Node::isVisible);
        sleep(1000);

    }
}
