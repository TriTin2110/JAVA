class Entry {
	public static void main(String[] args) {
		SubClass s = new SubClass();
		s.display();
	}
}

class SuperClass{
	protected void display() {
		System.out.println("Hello from SuperClass");
	}
}

class SubClass extends SuperClass{
	@Override
	void display() {
		System.out.println("Hello from SubClass");
	}
}