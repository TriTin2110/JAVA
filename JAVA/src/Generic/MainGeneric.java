package Generic;

class MainGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box<String> b1 = new Box<String>("Nguyễn Trí Tín");
		System.out.println(b1.getGiaTri());

		Box<Integer> b2 = new Box<Integer>(10);
		System.out.println(b2.getGiaTri());
	}

}
