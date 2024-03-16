package Animal;

public class Cat extends Animal {
	public Cat(String name) {
		super(name);
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Tôi ăn cá!");
	}

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("Meo Meo");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("zzz");
	}
}
