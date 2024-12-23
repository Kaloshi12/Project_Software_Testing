package View;

import java.util.List;

import Files.Files_Book;
import Model.Book;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DeleteBooks extends BorderPane{
	 private Stage stageBook;
	 private final Files_Book file;
	    private ListView<Book> list;
	    private Button delete;
	    private Text text;

	    public DeleteBooks() {
	    	
	        stageBook = new Stage();
	        stageBook.setTitle("Delete Books");
	        text = new Text();
	        text.setText("Which book you want to delete");
	        text.setFont(Font.font("Arial", FontWeight.SEMI_BOLD,20));
	        file = new Files_Book(); 
	        list = new ListView<Book>(file.getAll());
	        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	        list.setCellFactory(param -> new ListCell<Book>() {
	            @Override
	            protected void updateItem(Book book, boolean empty) {
	                super.updateItem(book, empty);

	                if (empty || book == null) {
	                    setText(null);
	                } else {
	                    setText(String.format("%s by %s - Pages: %d, Quantity: %d",
	                            book.getTitle(), book.getAuthor(), book.getPages(), book.getQuantity()));
	                }
	            }
	        });

	        FlowPane pane = new FlowPane();
	        pane.getChildren().add(text);
	        setCenter(pane);
	        
	        
	        HBox hbox = new HBox();
	      
	        delete = new Button("Delete");
	        delete.setPrefWidth(80);
	        delete.setPrefHeight(40);
	       
	        hbox.getChildren().addAll(delete);
	        hbox.setSpacing(50.0);
	        setBottom(hbox);
	        setCenter(list);
	    }
	    
	    public void updateBookList() {
	        list.setItems(FXCollections.observableList(file.loadBookFromFile()));
	    }
	    public Stage getStageBook() {
	        return stageBook;
	    }

	    public void setStageBook(Stage stageBook) {
	        this.stageBook = stageBook;
	    }

	    public ListView<Book> getList() {
	        return list;
	    }

	    public void setList(ListView<Book> list) {
	        this.list = list;
	    }

	   
	    public Button getDelete() {
			return delete;
		}

		public void setDelete(Button delete) {
			this.delete = delete;
		}

		public Text getText() {
			return text;
		}

		public void setText(Text text) {
			this.text = text;
		}
}
