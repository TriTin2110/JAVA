package ArrowFunction;

class TestCong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cong c = (a, b) -> {
			return a + b;
		};
		System.out.println(c.cong(5, 15));
	}

}
