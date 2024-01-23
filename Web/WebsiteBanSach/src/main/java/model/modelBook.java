package model;

public class modelBook {
	private String bookId, bookName, language, desciption;
	private modelTypeOfBook typeOfBook;
	private modelAuthor author;
	private int publicYear, quantity;
	private long importPrice, price, outportPrice;

	public modelBook() {
	}


	public modelBook(String bookId, String bookName, String language, String desciption,
			modelTypeOfBook typeOfBook, modelAuthor author, int publicYear, int quantity, long importPrice,
			long price, long outportPrice) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.language = language;
		this.desciption = desciption;
		this.typeOfBook = typeOfBook;
		this.author = author;
		this.publicYear = publicYear;
		this.quantity = quantity;
		this.importPrice = importPrice;
		this.price = price;
		this.outportPrice = outportPrice;
	}

	public String getBookId() {
		return bookId;
	}



	public void setBookId(String bookId) {
		this.bookId = bookId;
	}



	public String getBookName() {
		return bookName;
	}



	public void setBookName(String bookName) {
		this.bookName = bookName;
	}




	public String getLanguage() {
		return language;
	}



	public void setLanguage(String language) {
		this.language = language;
	}



	public String getDesciption() {
		return desciption;
	}



	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}



	public modelAuthor getAuthor() {
		return author;
	}



	public void setAuthor(modelAuthor author) {
		this.author = author;
	}



	public int getPublicYear() {
		return publicYear;
	}



	public void setPublicYear(int publicYear) {
		this.publicYear = publicYear;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public long getImportPrice() {
		return importPrice;
	}



	public void setImportPrice(long importPrice) {
		this.importPrice = importPrice;
	}



	public long getPrice() {
		return price;
	}



	public void setPrice(long price) {
		this.price = price;
	}



	public long getOutportPrice() {
		return outportPrice;
	}



	public void setOutportPrice(long outportPrice) {
		this.outportPrice = outportPrice;
	}


	public modelTypeOfBook getTypeOfBook() {
		return typeOfBook;
	}


	public void setTypeOfBook(modelTypeOfBook typeOfBook) {
		this.typeOfBook = typeOfBook;
	}

	
}
