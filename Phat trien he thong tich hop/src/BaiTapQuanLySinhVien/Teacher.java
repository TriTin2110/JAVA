package BaiTapQuanLySinhVien;

class Teacher extends Person {
	private double salary;
	private String achievement;

	public Teacher(int id) {
		super(id);
	}

	public Teacher(String name, int age, int id, double salary, String achievement) {
		super(name, age, id);
		this.salary = salary;
		this.achievement = achievement;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getAchievement() {
		return achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}

	@Override
	public String toString() {
		return "Teacher [salary=" + salary + ", achievement=" + achievement + ", getName()=" + getName() + ", getAge()="
				+ getAge() + ", getId()=" + getId() + "]";
	}

}
