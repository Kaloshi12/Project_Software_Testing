package Model;

import java.io.Serial;
import java.io.Serializable;

public class Book implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String iSBN;
    private String title;
    private Author author;
    private int pages;
    private int quantity;
    private Genres genre;
    private double price;
    private String description;

    public Book(String iSBN, String title, Author author, int pages, int quantity, Genres genre, double price, String description) {
        this.iSBN = iSBN;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.quantity = quantity;
        this.genre = genre;
        this.price = price;
        this.description = description;
    }

  

  



	public String getiSBN() {
		return iSBN;
	}



	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public Author getAuthor() {
		return author;
	}



	public void setAuthor(Author author) {
		this.author = author;
	}



	public int getPages() {
		return pages;
	}



	public void setPages(int pages) {
		this.pages = pages;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public Genres getGenre() {
		return genre;
	}



	public void setGenre(Genres genre) {
		this.genre = genre;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	@Override
    public String toString() {
        return "iSBN: " + iSBN + ", title: " + title + ", author: " + author + ", pages: " + pages +
                ", quantity: " + quantity + ", genre: " + genre + ", price: " + price + ", description: " + description;
    }
}
