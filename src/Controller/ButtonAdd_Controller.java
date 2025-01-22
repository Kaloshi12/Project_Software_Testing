package Controller;

import Files.Files_Book;
import Model.Author;
import Model.Book;
import Model.Genres;
import View.AddBookView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ButtonAdd_Controller {
    private  AddBookView view = new AddBookView(new Stage());
    private final Files_Book file;

    public ButtonAdd_Controller(AddBookView view) {
        this.view = view;
        this.file = new Files_Book();
        
        this.view.getAddBookButton().setOnAction(e -> addBook());
		
		
    }

    public void addBook() {
        
        String isbn = view.getIsbnField().getText();
        if (file.loadBookFromFile().stream().anyMatch(b -> b.getiSBN().equals(isbn))) {
            showWrongAlert("Failed", "A book with the same ISBN already exists");
            return;
        }
        String title = view.getTitleField().getText();
        String authorFirstName = view.getAuthorFirstNameField().getText();
        String authorLastName = view.getAuthorLastNameField().getText();
        int pages, quantity;
        Double price;
        
        try {
            pages = Integer.parseInt(view.getPagesField().getText());
            quantity = Integer.parseInt(view.getQuantityField().getText());
            price = Double.parseDouble(view.getPriceField().getText());
        } catch (NumberFormatException e) {
            showWrongAlert("Failed", "Pages Quantity and Price must be numeric");
            return;
        }
        
        String description = view.getDescriptionField().getText();
        String selectedGenreText = view.getGenreMenuButton().getText();
        Genres genre = getGenreFromText(selectedGenreText);
        if (genre == null) {
            showWrongAlert("Failed", "Please select a genre");
            return;
        }
                
        Author author = new Author(authorFirstName, authorLastName);
        Book newBook = new Book(isbn, title, author, pages, quantity, genre, price, description);
        
        file.create(newBook);
        view.getBookTableView().getItems().add(newBook);
           
        System.out.println("Saved successfully");
            clearFields();
            
            
           
       
        }

    private void showWrongAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    private Genres getGenreFromText(String genreText) {
        for (Genres genre : Genres.values()) {
            if (genre.toString().replace("_", " ").equals(genreText)) {
                return genre;
            }
        }
        return null;
        

    }

   public void clearFields() {
        view.getIsbnField().clear();
        view.getTitleField().clear();
        view.getAuthorFirstNameField().clear();
        view.getAuthorLastNameField().clear();
        view.getPagesField().clear();
        view.getQuantityField().clear();
        view.getPriceField().clear();
        view.getGenreMenuButton().setText("Select Genre");
        view.getDescriptionField().clear();
    }
//   public boolean validInput(String input , String fieldName) {
//	   String regex = "\\b[a-zA-Z]+\\b[a-zA-Z]+.*";
//	   if (!input.matches(regex)) {
//	        showWrongAlert("Failed", fieldName + " must contain 2 or more words.");
//	        return false;
//	    }
//	   return true;
//
//   }
//   private void showSuccessAlert(String title,String message) {
//       Alert alert = new Alert(AlertType.NONE);
//       alert.setTitle("Success");
//       alert.setHeaderText(title);
//       alert.setContentText(message);
//       alert.showAndWait();
//   }
//
  
   
}
