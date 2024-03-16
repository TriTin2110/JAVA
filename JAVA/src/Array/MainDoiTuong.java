package Array;

class MainDoiTuong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoiTuong sv1 = new DoiTuong("Nguyễn Trí Tín", 9, 100);
		DoiTuong sv2 = new DoiTuong("Nguyễn Ngọc Minh", 9.5, 50);

		System.out.println(sv1.compareTo(sv2));
		System.out.println(sv1.compareToName(sv2));
		System.out.println(sv1.compareToMark(sv2));
	}

}
