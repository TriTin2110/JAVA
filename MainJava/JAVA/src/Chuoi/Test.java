package Chuoi;

class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "Trí Tín";
		System.out.println(name.length());
		System.out.println(name.charAt(2));

		// Lấy ký tự trong chuỗi và lưu vào trong mảng char
		char[] mang = new char[10];
		name.getChars(0, 3, mang, 0);
		for (char c : mang) {
			System.out.println(c);
		}

		// Lấy mã ACII và lưu vào trong mảng byte
		byte[] bt = new byte[10];
		name.getBytes(0, 7, bt, 0);
		for (byte b : bt) {
			System.out.println(b);
		}
	}

}
