package View;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import Files.Files_Book;
import Model.Book;
import Model.Genres;

public class AddBookView {

    private TextField isbnField;
    private TextField titleField;
    private TextField authorFirstNameField;
    private TextField authorLastNameField;
    private TextField pagesField;
    private TextField quantityField;
    private TextField priceField;
    private TextField descriptionField;
    private Button addBookButton;
    private Stage stage;
    private MenuButton genreMenuButton;
    private TableView<Book> bookTableView;
    private VBox root;
    private Files_Book file;
    
    public AddBookView() {
        Merge();
    }

    private void Merge() {
        stage = new Stage();
        stage.setTitle("Add Books");
        setFile(new Files_Book());
   
        GridPane addBookPane = createAddBookPane();
        bookTableView = createBookTableView();

        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(addBookPane, bookTableView);
        splitPane.setDividerPositions(0.3f);

        root = new VBox(splitPane);
    }

    public GridPane createAddBookPane() {
        GridPane addBookPane = new GridPane();
        addBookPane.setPadding(new Insets(10));
        addBookPane.setHgap(10);
        addBookPane.setVgap(10);

        Label genreLabel = new Label("Genre:");
        genreMenuButton = new MenuButton("Select Genre");
        ObservableList<MenuItem> genreItems = FXCollections.observableArrayList();
        for (Genres genre : Genres.values()) {
            MenuItem genreItem = new MenuItem(genre.toString().replace("_", " "));
            genreItem.setOnAction(event -> genreMenuButton.setText(genre.toString().replace("_", " ")));
            genreItems.add(genreItem);
        }
        genreMenuButton.getItems().addAll(genreItems);

        isbnField = new TextField();
        titleField = new TextField();
        authorFirstNameField = new TextField();
        authorLastNameField = new TextField();
        pagesField = new TextField();
        quantityField = new TextField();
        priceField = new TextField();
        descriptionField = new TextField();
        addBookButton = new Button("Add Book");

        addBookPane.add(new Label("ISBN:"), 0, 0);
        addBookPane.add(isbnField, 1, 0);
        addBookPane.add(new Label("Title:"), 0, 1);
        addBookPane.add(titleField, 1, 1);
        addBookPane.add(new Label("Author First Name:"), 0, 2);
        addBookPane.add(authorFirstNameField, 1, 2);
        addBookPane.add(new Label("Author Last Name:"), 0, 3);
        addBookPane.add(authorLastNameField, 1, 3);
        addBookPane.add(new Label("Number of Pages:"), 0, 4);
        addBookPane.add(pagesField, 1, 4);
        addBookPane.add(new Label("Quantity:"), 0, 5);
        addBookPane.add(quantityField, 1, 5);
        addBookPane.add(new Label("Price"), 0, 6);
        addBookPane.add(priceField, 1, 6);
        addBookPane.add(new Label("Description:"), 0, 7);
        addBookPane.add(descriptionField, 1, 7);
        addBookPane.add(genreLabel, 0, 9);
        addBookPane.add(genreMenuButton, 1, 9);
        addBookPane.add(addBookButton, 0, 9, 2, 1);

      
        

        return addBookPane;
    }

    public TextField getPriceField() {
		return priceField;
	}

	public void setPriceField(TextField priceField) {
		this.priceField = priceField;
	}

	@SuppressWarnings("unchecked")
	public TableView<Book> createBookTableView() {
        TableView<Book> tableView = new TableView<>();
        tableView.setItems(file.getAll());
        tableView.setEditable(true);
        TableColumn<Book, String> iSBNColumn = new TableColumn<>("ISBN");
        iSBNColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getiSBN()));
       iSBNColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Book, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        titleColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Book, String> authorFirstNameColumn = new TableColumn<>("Author First Name");
        authorFirstNameColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getAuthor().getFirstName()));
        authorFirstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Book, String> authorLastNameColumn = new TableColumn<>("Author Last Name");
        authorLastNameColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getAuthor().getLastName()));
        authorLastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Book, Integer> pagesColumn = new TableColumn<>("Number of Pages");
        pagesColumn.setCellValueFactory(new PropertyValueFactory<>("pages"));
        pagesColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        TableColumn<Book, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        
        TableColumn<Book, String> genreColumn = new TableColumn<>("Genre");
        genreColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getGenre().toString()));
        genreColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        TableColumn<Book, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        
        tableView.getColumns().addAll(iSBNColumn, titleColumn, authorFirstNameColumn,
                authorLastNameColumn, pagesColumn, quantityColumn, genreColumn,priceColumn);
        
       

        return tableView;
    }

    

    public TextField getIsbnField() {
		return isbnField;
	}

	public void setIsbnField(TextField isbnField) {
		this.isbnField = isbnField;
	}

	public TextField getTitleField() {
		return titleField;
	}

	public void setTitleField(TextField titleField) {
		this.titleField = titleField;
	}

	public TextField getAuthorFirstNameField() {
		return authorFirstNameField;
	}

	public void setAuthorFirstNameField(TextField authorFirstNameField) {
		this.authorFirstNameField = authorFirstNameField;
	}

	public TextField getAuthorLastNameField() {
		return authorLastNameField;
	}

	public void setAuthorLastNameField(TextField authorLastNameField) {
		this.authorLastNameField = authorLastNameField;
	}

	public TextField getPagesField() {
		return pagesField;
	}

	public void setPagesField(TextField pagesField) {
		this.pagesField = pagesField;
	}

	public TextField getQuantityField() {
		return quantityField;
	}

	public void setQuantityField(TextField quantityField) {
		this.quantityField = quantityField;
	}

	public TextField getDescriptionField() {
		return descriptionField;
	}

	public void setDescriptionField(TextField descriptionField) {
		this.descriptionField = descriptionField;
	}

	public Button getAddBookButton() {
		return addBookButton;
	}

	public void setAddBookButton(Button addBookButton) {
		this.addBookButton = addBookButton;
	}

	public MenuButton getGenreMenuButton() {
		return genreMenuButton;
	}

	public void setGenreMenuButton(MenuButton genreMenuButton) {
		this.genreMenuButton = genreMenuButton;
	}


	

    public TableView<Book> getBookTableView() {
		return bookTableView;
	}

	public void setBookTableView(TableView<Book> bookTableView) {
		this.bookTableView = bookTableView;
	}

	public VBox getRoot() {
        return root;
    }

    public void setRoot(VBox root) {
        this.root = root;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

	public Files_Book getFile() {
		return file;
	}

	public void setFile(Files_Book file) {
		this.file = file;
	}
}
