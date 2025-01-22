package TestFX;

import View.LoginView;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;

public class AddLibrarianTestFX extends ApplicationTest {
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
    public void testAddBook() {
        // Simulate user input for login
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

        clickOn("#manageLibrarian");

        verifyThat("#manageLibrarian", Node::isVisible);
        sleep(1000);
        clickOn("#nameLibrarian").write("Bosi");
        clickOn("#surnameLibrarian").write("Bosave");

        clickOn("#birthdayLibrarian").write("9/8/2003");

//        Assertions.assertEquals(LocalDate.of(2003, 8, 9),lookup("#birthdayManager"));

        clickOn("#phoneLibrarian").write("0688246852");

        // After clicking and writing in the fields:
        clickOn("#salaryLibrarian").write("5000.0");

        Assertions.assertEquals("5000.0", lookup("#salaryLibrarian").queryTextInputControl().getText());

        clickOn("#userIdLibrarian").write("Bosi");

        Assertions.assertEquals("ledion13", lookup("#userIdLibrarian").queryTextInputControl().getText());

        clickOn("#passLibrarian").write("12345678");

        Assertions.assertEquals("12345678", lookup("#passLibrarian").queryTextInputControl().getText());

        clickOn("#addLibrarian");

        verifyThat("#addLibrarian", Node::isVisible);
        sleep(1000);

    }


}


