package Animal;

public class Main {
	public static void main(String[] args) {
		Dog d = new Dog("LuLu");
		Cat c = new Cat("Miu");

		d.eat();
		d.speak();

		System.out.println("\n--------------------\n");

		c.eat();
		c.speak();
	}
}
