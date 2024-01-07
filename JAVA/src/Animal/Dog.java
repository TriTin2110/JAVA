package Animal;

public class Dog extends Animal {
	public Dog(String name) {
		super(name);
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Tôi ăn xương!");
	}

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("Gâu Gâu");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("zzz");
	}
}
