package Employee;

class Employee {
	private int id, salary;
	private String firstName, lastName;

	public Employee(int id, int salary, String firstName, String lastName) {
		this.id = id;
		this.salary = salary;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	int getId() {
		return id;
	}

	void setId(int id) {
		this.id = id;
	}

	int getSalary() {
		return salary;
	}

	void setSalary(int salary) {
		this.salary = salary;
	}

	String getFirstName() {
		return firstName;
	}

	void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	String getLastName() {
		return lastName;
	}

	void setLastName(String lastName) {
		this.lastName = lastName;
	}

	String fullName() {
		return firstName + " " + lastName;
	}

	int getAnnualSalary() {
		return salary * 12;
	}

	double upToSalary(double phanTram) {
		return salary + ((salary * phanTram) / 100);
	}

}
