package Controller;

import View.Admin_View;
import View.BookListView;
import View.ChangeRoleStage;
import View.DeleteBookStage;
import View.AddLibrarianStage;
import View.AddManager_Stage;
import View.Bill_IdStage;
import View.LoginView;
import View.StageAddBook;

import javafx.application.Platform;
import javafx.stage.Stage;

public class Admin_View_Controller {
    private Admin_View view = new Admin_View(new Stage());
    private BookListView books = new BookListView();
    private StageAddBook addBook = new StageAddBook();
    private AddManager_Stage addManager = new AddManager_Stage();
    private DeleteBookStage deleteStage = new DeleteBookStage();
    private AddLibrarianStage addLibrarian = new AddLibrarianStage();
    private Bill_IdStage bill = new Bill_IdStage();
    private ChangeRoleStage role = new ChangeRoleStage();

    public Admin_View_Controller(Admin_View view) {
        view.getShowBooks().setOnAction(e -> books.open());
        view.getAddBooks().setOnAction(e -> addBook.open());
        view.getRegister_Manager().setOnAction(e -> addManager.open());
        view.getDelete().setOnAction(e -> deleteStage.open());
        view.getRegiser_Librarian().setOnAction(e -> addLibrarian.open());
        view.getCheck_Librarian().setOnAction(e -> bill.open());
        view.getPermission().setOnAction(e -> role.open());
    }

    public BookListView getStage() {
        return books;
    }

    public void setStage(BookListView books) {
        this.books = books;
    }

    public StageAddBook getAddBook() {
        return addBook;
    }

    public void setAddBook(StageAddBook addBook) {
        this.addBook = addBook;
    }

    public AddManager_Stage getAddManager() {
        return addManager;
    }

    public void setAddManager(AddManager_Stage addManager) {
        this.addManager = addManager;
    }

    public Admin_View getView() {
        return view;
    }

    public void setView(Admin_View view) {
        this.view = view;
    }


}
