package LapTrinhMang.ChuongTrinhQuanLySinhVien;

class ModelStudent {
	private String id, name;
	private int age;
	private float gpa;

	public ModelStudent() {
	}

	public ModelStudent(String id) {
		super();
		this.id = id;
	}

	public ModelStudent(String id, String name, int age, float gpa) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gpa = gpa;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

}
