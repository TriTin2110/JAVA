package MayTinhInterface;

class Test {
	public static void main(String[] args) {
		MayTinhCasio m1 = new MayTinhCasio();
		MayTinhVinacom m2 = new MayTinhVinacom();

		System.out.println(m1.cong(2, 5));
		System.out.println(m2.tru(10, 8));

		SapXep sx = new SapXep();
		int[] mang = { 2, 7, 1, 8, 3, 1, 2, 6, 10 };
		sx.sapXepTangDan(mang);
		System.out.println();
		sx.sapXepGiamDan(mang);

		MayTinh mt = new MayTinh();
		System.out.println(mt.cong(10, 5));
		mt.sapXepGiamDan(mang);
	}
}
