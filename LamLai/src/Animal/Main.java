package Animal;

class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog d = new Dog("Lulu");
		System.out.println(d.getName());
		d.eating();

		Cat c = new Cat("Miu");
		System.out.println(c.getName());
		c.eating();
	}

}
