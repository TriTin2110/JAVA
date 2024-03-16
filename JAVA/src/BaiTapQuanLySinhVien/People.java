package BaiTapQuanLySinhVien;

/* Lớp people là cha của lớp student và teacher
 * Lớp people bao gồm những thuộc tính name, age, id*/
class People {
	private String name;
	private int age, id;

	public People(int id) {
		this.id = id;
	}

	public People(String name, int age, int id) {
		this.name = name;
		this.age = age;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
