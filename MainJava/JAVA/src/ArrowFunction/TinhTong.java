package ArrowFunction;

class TinhTong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 5;
		int b = 10;
		TongInterface tong = () -> {
			return a + b;
		};
		System.out.println(tong.tinhTong());
	}

}
