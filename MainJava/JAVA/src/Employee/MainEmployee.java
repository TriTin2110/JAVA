package Employee;

class MainEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee(1, 1000, "Tín", "Nguyễn");
		Employee e2 = new Employee(2, 7000, "Trí", "Nguyễn");

		System.out.println(e1.fullName());
		System.out.println(e1.getAnnualSalary());
		System.out.println(e1.upToSalary(10));

		System.out.println("\n-----------------------------\n");

		System.out.println(e2.fullName());
		System.out.println(e2.getAnnualSalary());
		System.out.println(e2.upToSalary(20));
	}

}
