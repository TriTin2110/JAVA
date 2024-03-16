package BaiTapQuanLySinhVien;

class Student extends Person {
	private double GPA;
	private String major;

	public Student(int id) {
		super(id);
	}

	public Student(String name, int age, int id, double gPA, String major) {
		super(name, age, id);
		GPA = gPA;
		this.major = major;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Student [GPA=" + GPA + ", major=" + major + ", getName()=" + getName() + ", getAge()=" + getAge()
				+ ", getId()=" + getId() + "]";
	}

}
