package View;

import Model.Book;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Description extends Pane {
    private Stage desc_stage;
    private Text text;

    public Stage getDesc_stage() {
        return desc_stage;
    }

    public void setDesc_stage(Stage desc_stage) {
        this.desc_stage = desc_stage;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public Description() {
        desc_stage = new Stage();
        desc_stage.setTitle("Description");
        text = new Text();
        getChildren().add(text);
    }

    public void showForBook(Book selectedBook) {
        double maxWidth = 400;
        if (selectedBook != null) {
            text.setText(String.format("Book Title: %s\nAuthor: %s\nDescription: %s",
                    selectedBook.getTitle(), selectedBook.getAuthor().toString(), selectedBook.getDescription()));
        } else {
            text.setText("No book selected.");
        }
        text.setWrappingWidth(maxWidth);
        double textPreferredWidth = text.getLayoutBounds().getWidth();
        double sceneWidth = Math.min(textPreferredWidth + 20, 500); // Add some padding (e.g., 20) to the text width
        Scene scene = new Scene(this, sceneWidth, 500);
        desc_stage.setScene(scene);
        desc_stage.show();
    }
}

