package ArrowFunction;

class TestHello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hello h = () -> {
			System.out.println("Hello world!");
		};
		h.hello();
	}

}
