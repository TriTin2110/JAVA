package Animal;

class Animal {
	private String name;

	public Animal(String name) {
		this.name = name;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	void eating() {
		System.out.println("Eating...");
	}

	void sleeping() {
		System.out.println("Sleeping...");
	}
}
