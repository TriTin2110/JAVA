package Model;

import java.io.Serializable;

public class ModelStudent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String specialized;
	private String id, name;
	private int age;
	private String phone;

	public ModelStudent() {
		super();
	}

	public ModelStudent(String id) {
		super();
		this.id = id;
	}

	public ModelStudent(String name, int age, String phone, String specialized) {
		super();
		this.specialized = specialized;
		this.name = name;
		this.age = age;
		this.phone = phone;
	}

	public ModelStudent(String id, String name, int age, String phone, String specialized) {
		super();
		this.specialized = specialized;
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
	}

	public String getSpecialized() {
		return specialized;
	}

	public void setSpecialized(String specialized) {
		this.specialized = specialized;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
