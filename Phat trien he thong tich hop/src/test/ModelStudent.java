package test;

class ModelStudent {
	private int id;
	private String name;
	private double GPA;

	public ModelStudent(int id) {
		this.id = id;
	}

	public ModelStudent(int id, String name, double gPA) {
		this.id = id;
		this.name = name;
		GPA = gPA;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
	}

	@Override
	public String toString() {
		return "ModelStudent [id=" + id + ", name=" + name + ", GPA=" + GPA + "]";
	}

}
