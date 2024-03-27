package Model;

import java.io.Serializable;
import java.sql.Date;

public class ModelBook implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idBook, nameBook, kindOfBook, authorID, status;
	private int quantity;
	private Date publicDay;

	public ModelBook() {
		super();
	}

	public ModelBook(String idBook) {
		super();
		this.idBook = idBook;
	}

	public ModelBook(String nameBook, String kindOfBook, String authorID, String status, int quantity, Date publicDay) {
		super();
		this.nameBook = nameBook;
		this.kindOfBook = kindOfBook;
		this.authorID = authorID;
		this.status = status;
		this.quantity = quantity;
		this.publicDay = publicDay;
	}

	public ModelBook(String idBook, String nameBook, String kindOfBook, String authorID, String status, int quantity,
			Date publicDay) {
		super();
		this.idBook = idBook;
		this.nameBook = nameBook;
		this.kindOfBook = kindOfBook;
		this.authorID = authorID;
		this.status = status;
		this.quantity = quantity;
		this.publicDay = publicDay;
	}

	public String getIdBook() {
		return idBook;
	}

	public void setIdBook(String idBook) {
		this.idBook = idBook;
	}

	public String getNameBook() {
		return nameBook;
	}

	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}

	public String getKindOfBook() {
		return kindOfBook;
	}

	public void setKindOfBook(String kindOfBook) {
		this.kindOfBook = kindOfBook;
	}

	public String getAuthorID() {
		return authorID;
	}

	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getPublicDay() {
		return publicDay;
	}

	public void setPublicDay(Date publicDay) {
		this.publicDay = publicDay;
	}

}
