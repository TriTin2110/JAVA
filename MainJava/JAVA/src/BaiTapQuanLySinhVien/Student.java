package BaiTapQuanLySinhVien;

class Student extends People {
	private double GPA;
	private long tuition;
	private String subject;

	public Student(int id) {
		super(id);
	}

	public Student(String name, int age, int id, double GPA, long tuition, String subject) {
		// Tạo đối tượng ConNguoi
		super(name, age, id);
		this.GPA = GPA;
		this.tuition = tuition;
		this.subject = subject;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double GPA) {
		this.GPA = GPA;
	}

	public long getTuition() {
		return tuition;
	}

	public void setTuition(long tuition) {
		this.tuition = tuition;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "SinhVien [GPA=" + GPA + ", tuition=" + tuition + ", subject=" + subject + ", name=" + getName()
				+ ", age=" + getAge() + ", id=" + getId() + "]";
	}

	// Lấy tên của tất cả sinh viên trong danh sách
	public String getFirstName() {
		String firstName = this.getName();
		return firstName.substring(firstName.lastIndexOf(" ") + 1);
	}
}
