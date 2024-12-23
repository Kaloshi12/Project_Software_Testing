package Model;

import java.io.*;
import java.util.Arrays;
import java.util.Date;

public class Bill implements Serializable {
    private static final long serialVersionUID = 1L;
    private int billID;
    private Book[] books;
    private Date date;
    private double totalPrice;

    public Bill(int billID, Book[] books, Date date, double totalPrice) {
        this.billID = billID;
        this.books = books;
        this.date = date;
        this.totalPrice = totalPrice;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(billID);
        out.writeObject(books);
        out.writeObject(date);
        out.writeDouble(totalPrice);
    }

    public int getBillID() {
		return billID;
	}

	public void setBillID(int billID) {
		this.billID = billID;
	}

	public Book[] getBooks() {
		return books;
	}

	public void setBooks(Book[] books) {
		this.books = books;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        billID = in.readInt();
        books = (Book[]) in.readObject();
        date = (Date) in.readObject();
        totalPrice = in.readDouble();
    }

    @Override
    public String toString() {
        return "Bill [billID=" + billID + ", books=" + Arrays.toString(books) + ", date=" + date + ", totalPrice=" + totalPrice + "]";
    }


}
