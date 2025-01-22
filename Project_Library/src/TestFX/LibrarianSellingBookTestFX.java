package TestFX;

import View.LoginView;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;

public class LibrarianSellingBookTestFX extends ApplicationTest {
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
    public void testLibrarianLoginAndSellBook() {
        // Simulate librarian login
        clickOn("#username").write("Enio");
        clickOn("#password").write("12345678");
        clickOn("#login");

        // Verify success message color
        verifyThat("#success", node -> {
            Text text = (Text) node;
            return text.getFill().equals(Color.GREEN); // Verify text color is green
        });

        sleep(1000);

        // Click on the "Sell Book" button (ensure it's visible)
        clickOn("#sellBook");
        sleep(1000); // Wait for the Sell Book page to open

        // Verify that the Sell Book page has loaded
        clickOn("#listBook .cell");
        // Enter the quantity for the book in the quantity field
        clickOn("#quantity").write("1");

        clickOn("#buyButton");


        verifyThat("#buyButton", Node::isVisible);

        sleep(1000);
    }
}
