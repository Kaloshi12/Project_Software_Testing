package TestFX;

import View.LoginView;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.time.LocalDate;

import static org.testfx.api.FxAssert.verifyThat;

public class AddManagerTestFX extends ApplicationTest {
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

        clickOn("#addManager");

        verifyThat("#addManager", Node::isVisible);
        sleep(1000);
        clickOn("#nameManager").write("Ledion");
        clickOn("#surnameManager").write("Lamce");

        clickOn("#birthdayManager").write("9/8/2003");

//        Assertions.assertEquals(LocalDate.of(2003, 8, 9),lookup("#birthdayManager"));

        clickOn("#phoneManager").write("0688246852");

        // After clicking and writing in the fields:
        clickOn("#salaryManager").write("5000.0");

        Assertions.assertEquals("5000.0", lookup("#salaryManager").queryTextInputControl().getText());

        clickOn("#userIdManager").write("ledion13");

        Assertions.assertEquals("ledion13", lookup("#userIdManager").queryTextInputControl().getText());

        clickOn("#passManager").write("12345678");

        Assertions.assertEquals("12345678", lookup("#passManager").queryTextInputControl().getText());

        clickOn("#addManager");

        verifyThat("#addManager", Node::isVisible);

    }


}
