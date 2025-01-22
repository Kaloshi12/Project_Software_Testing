package View;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import Files.Files_Book;
import Model.Book;
import javafx.collections.FXCollections;
	import javafx.collections.ObservableList;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.ListCell;
	import javafx.scene.control.ListView;
	import javafx.scene.layout.BorderPane;
	import javafx.scene.layout.HBox;
	import javafx.scene.text.Text;
	import javafx.stage.Stage;

	public class ShowAllBooks extends  BorderPane {
	    public Stage stageBook;
	    private ListView<Book> list;
	    private Button descriptionButton;
	    private final Files_Book file;
	    private Text text;

	    public ShowAllBooks() {
	    	
	        stageBook = new Stage();
	        stageBook.setTitle("Books");
	        text = new Text();
	        text.setText("Books");
	        file = new Files_Book();
	        list = new ListView<Book>(file.getAll());
	        list.setCellFactory(param -> new ListCell<Book>() {
	            @Override
	            protected void updateItem(Book book, boolean empty) {
	                super.updateItem(book, empty);

	                if (empty || book == null) {
	                    setText(null);
	                } else {
	                	setText(String.format("%s by %s - Pages: %d Quantity: %d Price: %.2f",
	                		    book.getTitle(), book.getAuthor(), book.getPages(), book.getQuantity(), book.getPrice()));

	                }
	            }
	        });

	        FlowPane pane = new FlowPane();
	        pane.getChildren().add(text);
	        setCenter(pane);
	        
	        
	        HBox hbox = new HBox();
	      
	        descriptionButton = new Button("Description");
	        descriptionButton.setPrefWidth(80);
	        descriptionButton.setPrefHeight(40);
			descriptionButton.setId("desc");
	       
	        hbox.getChildren().addAll(descriptionButton);
	        hbox.setSpacing(50.0);
	        setBottom(hbox);
	        setCenter(list);
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

	   
	    public Button getDescriptionButton() {
			return descriptionButton;
		}

		public void setDescriptionButton(Button descriptionButton) {
			this.descriptionButton = descriptionButton;
		}

		public Text getText() {
			return text;
		}

		public void setText(Text text) {
			this.text = text;
		}

}
