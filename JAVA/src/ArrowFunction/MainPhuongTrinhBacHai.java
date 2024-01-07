package ArrowFunction;

class MainPhuongTrinhBacHai {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhuongTrinhBacHai gpt = (a, b, c) -> {
			double delta = Math.pow(b, 2) - (4 * a * c);
			if (delta < 0) {
				System.out.println("Phương trình vô nghiệm!");
				return;
			} else if (delta == 0) {
				System.out.println("Phương trình có 1 nghiệm kép!");
				System.out.println("x0 = " + ((-b) / (2 * a)));
			} else {
				System.out.println("Phương trình có 2 nghiệm phân biệt!");
				System.out.println("x1 = " + ((-b + Math.sqrt(delta)) / (2 * a)));
				System.out.println("x2 = " + ((-b - Math.sqrt(delta)) / (2 * a)));
			}
		};
		gpt.phuongTrinhBacHai(1, 2, 3);
	}
}
