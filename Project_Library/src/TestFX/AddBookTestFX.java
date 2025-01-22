package TestFX;

import Files.Files_Book;

import View.LoginView;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.testfx.api.FxAssert.verifyThat;

public class AddBookTestFX extends ApplicationTest {

    private LoginView loginView;

    private Stage currentStage;
    private Files_Book file ;

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
    public void testAddBook() {
        file = mock(Files_Book.class,CALLS_REAL_METHODS);
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


        clickOn("#addBookA");

        verifyThat("#addBookA", Node::isVisible);
        sleep(1000);

        clickOn("#isbnField").write("978-3-16-148410-0");

        clickOn("#titleField").write("Test Book Title");
        clickOn("#authorFirstNameField").write("John");
        clickOn("#authorLastNameField").write("Doe");
        clickOn("#pagesField").write("350");
        clickOn("#quantityField").write("20");
        clickOn("#priceField").write("19.99");
        clickOn("#descriptionField").write("This is a test description of the book.");
        clickOn("#genre");
        clickOn("#genre").type(KeyCode.DOWN);
        clickOn("#genre").type(KeyCode.ENTER);

        clickOn("#addBookButton");
        verifyThat("#addBookButton",Node::isVisible);
        verifyThat("#bookList", Node::isVisible);
        sleep(1000);

    }
}
