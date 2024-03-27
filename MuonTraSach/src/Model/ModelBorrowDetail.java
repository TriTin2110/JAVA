package Model;

import java.io.Serializable;
import java.sql.Date;

public class ModelBorrowDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String borrowID, bookID, studentID, expiredStatus, returnStatus;
	private Date borrowDay, returnDay;

	public ModelBorrowDetail() {
		super();
	}

	public ModelBorrowDetail(String borrowID) {
		super();
		this.borrowID = borrowID;
	}

	public ModelBorrowDetail(String borrowID, String bookID, String studentID, Date borrowDay) {
		super();
		this.borrowID = borrowID;
		this.bookID = bookID;
		this.studentID = studentID;
		this.borrowDay = borrowDay;
	}

	public ModelBorrowDetail(String borrowID, String bookID, String studentID, String expiredStatus,
			String returnStatus, Date borrowDay, Date returnDay) {
		super();
		this.borrowID = borrowID;
		this.bookID = bookID;
		this.studentID = studentID;
		this.expiredStatus = expiredStatus;
		this.returnStatus = returnStatus;
		this.borrowDay = borrowDay;
		this.returnDay = returnDay;
	}

	public String getBorrowID() {
		return borrowID;
	}

	public void setBorrowID(String borrowID) {
		this.borrowID = borrowID;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getExpiredStatus() {
		return expiredStatus;
	}

	public void setExpiredStatus(String expiredStatus) {
		this.expiredStatus = expiredStatus;
	}

	public String getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}

	public Date getBorrowDay() {
		return borrowDay;
	}

	public void setBorrowDay(Date borrowDay) {
		this.borrowDay = borrowDay;
	}

	public Date getReturnDay() {
		return returnDay;
	}

	public void setReturnDay(Date returnDay) {
		this.returnDay = returnDay;
	}

}