package Array;

import java.util.Arrays;

class SapXepTimKiemMang {

	private String ten;

	public SapXepTimKiemMang(String ten) {
		// TODO Auto-generated constructor stub
		this.ten = ten;
	}

	String layTen() {
		String s = "";
		if (ten.indexOf(" ") > 0) {
			s = ten.substring(ten.lastIndexOf(" ") + 1);
		}
		return s;
	}

	String getTen() {
		return ten;
	}

	void setTen(String ten) {
		this.ten = ten;
	}

	@Override
	public String toString() {
		return "SapXepTimKiemMang [ten=" + ten + "]" + "\n";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] mang = { 2, 10, 5, 12, 9, 8 };
		int[] mang2 = new int[10];

		// Sắp xếp mảng theo thứ tự tăng dần
		Arrays.sort(mang);
		System.out.println(Arrays.toString(mang));

		// Mảng phải được sắp xếp thì ms có thể áp dụng binarySearch
		System.out.println(Arrays.binarySearch(mang, 12));

		Arrays.fill(mang2, 10);
		System.out.println(Arrays.toString(mang2));

		// Tạo ra 3 sinh viên có tên bất kỳ
		// Gọi hàm lấy tên để tiến hành lấy tên của 3 sinh viên
		// Sau đó sắp xếp tên = hàm Arrays.sort(sv)
		SapXepTimKiemMang sv1 = new SapXepTimKiemMang("Nguyễn Trí Tín");
		SapXepTimKiemMang sv2 = new SapXepTimKiemMang("Nguyễn Ngọc Minh");
		SapXepTimKiemMang sv3 = new SapXepTimKiemMang("Nguyễn Văn An");
		String[] sv = { sv1.layTen(), sv2.layTen(), sv3.layTen() };
		Arrays.sort(sv);
		System.out.println(Arrays.toString(sv));
	}

}
