package Controller;

import Files.Files_Book;
import Model.Book;
import View.DeleteBooks;
import javafx.collections.ObservableList;

public class DeleteBook_Controller {
	private final DeleteBooks view;
	private final Files_Book file;

	public DeleteBook_Controller(DeleteBooks view, Files_Book file) {
		this.view = view;
		this.file = file;
		view.getDelete().setOnAction(e -> deleteBook());
	}

	public void deleteBook() {
		Book selectedBook = (Book) view.getList().getSelectionModel().getSelectedItem();

		if (selectedBook != null) {
			if (selectedBook.getQuantity() < 1) {
				file.delete(selectedBook);
			} else {
				file.delete(selectedBook);
				Book book = new Book(
						selectedBook.getiSBN(),
						selectedBook.getTitle(),
						selectedBook.getAuthor(),
						selectedBook.getPages(),
						selectedBook.getQuantity() - 1,
						selectedBook.getGenre(),
						selectedBook.getPrice(),
						selectedBook.getDescription()
				);
				file.create(book);
			}
		}
	}
}
