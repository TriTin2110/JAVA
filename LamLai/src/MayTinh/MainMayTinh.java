package MayTinh;

class MainMayTinh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MayTinh mt1 = new MayTinh(5, 6);

		System.out.println(mt1.tinhTong());
		System.out.println(mt1.tinhHieu());
		System.out.println(mt1.tinhTich());
		System.out.println(mt1.tinhThuong());

		for (int i = 0; i < 2; i++) {
			System.out.println(mt1.sapXepGiam()[i]);
		}

		for (int i = 0; i < 2; i++) {
			System.out.println(mt1.sapXepTang()[i]);
		}
	}

}
