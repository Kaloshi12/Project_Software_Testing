package Controller;

import View.BookListView;
import View.DeleteBookStage;
import View.MenuManagerStage;
import View.MenuManagerView;
import View.StageAddBook;

public class MenuMenager_Controller {
private MenuManagerView view = new MenuManagerView();
private BookListView stage = new BookListView();
private StageAddBook addBook = new StageAddBook();
private DeleteBookStage deleteStage = new DeleteBookStage();
public MenuMenager_Controller(MenuManagerView view) {
	this.view = view;
	view.getShowBooks().setOnAction(e -> stage.open());
	view.getAddBooks().setOnAction(e -> addBook.open());
	view.getDelete().setOnAction(e -> deleteStage.open());
	
} 

public MenuManagerView getView() {
	return view;
}

public void setView(MenuManagerView view) {
	this.view = view;
}

public BookListView getStage() {
	return stage;
}

public void setStage(BookListView stage) {
	this.stage = stage;
}

public StageAddBook getAddBook() {
	return addBook;
}

public void setAddBook(StageAddBook addBook) {
	this.addBook = addBook;
}

public DeleteBookStage getDeleteStage() {
	return deleteStage;
}

public void setDeleteStage(DeleteBookStage deleteStage) {
	this.deleteStage = deleteStage;
}


}
