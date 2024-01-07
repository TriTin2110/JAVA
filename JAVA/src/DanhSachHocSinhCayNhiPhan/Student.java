package DanhSachHocSinhCayNhiPhan;

public class Student {
	int Student_ID;
	String Student_Name;
	double Student_Result;

	public Student(int student_ID, String student_Name, double student_Result) {
		Student_ID = student_ID;
		Student_Name = student_Name;
		Student_Result = student_Result;
	}

	public int getStudent_ID() {
		return Student_ID;
	}

	public void setStudent_ID(int student_ID) {
		Student_ID = student_ID;
	}

	public String getStudent_Name() {
		return Student_Name;
	}

	public void setStudent_Name(String student_Name) {
		Student_Name = student_Name;
	}

	public double getStudent_Result() {
		return Student_Result;
	}

	public void setStudent_Result(double student_Result) {
		Student_Result = student_Result;
	}

	public void printData() {
		System.out.println("Id: " + this.Student_ID);
		System.out.println("Name: " + this.Student_Name);
		System.out.println("Result: " + this.Student_Result);
	}
}
