package Controller;

import Files.Files_Book;
import Model.Book;
import View.DeleteBooks;
import javafx.collections.ObservableList;

public class DeleteBook_Controller {
    private DeleteBooks view = new DeleteBooks();
    private final Files_Book file;

    public DeleteBook_Controller(DeleteBooks view){
        file = new Files_Book();
    	view.getDelete().setOnAction(e -> deleteBook());
    }

    private void deleteBook() {
    	 
    	Book selectedBook= (Book) view.getList().getSelectionModel().getSelectedItem();

    	   if(selectedBook.getQuantity()<1) {
    		   file.delete(selectedBook);
    		   
    	   }else {
    		   file.delete(selectedBook);
    		   Book book =new Book(selectedBook.getiSBN(), selectedBook.getTitle(), selectedBook.getAuthor(), selectedBook.getPages(), selectedBook.getQuantity()-1, selectedBook.getGenre(), selectedBook.getPrice(), selectedBook.getDescription());
    		   file.create(book);
    			 
    	   }
	}
    
}

