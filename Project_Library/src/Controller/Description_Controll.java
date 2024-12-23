package Controller;

import View.Description;
import View.ShowAllBooks;

public class Description_Controll {
    private ShowAllBooks book = new ShowAllBooks();
    private Description description = new Description();
    public ShowAllBooks getBook() {
		return book;
	}

	public void setBook(ShowAllBooks book) {
		this.book = book;
	}

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	

    public Description_Controll(ShowAllBooks book) {
        book.getDescriptionButton().setOnAction(e -> description.showForBook(book.getList().getSelectionModel().getSelectedItem()));
    }
}
