package Chuoi;

class TimKiemTrongChuoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Nguyễn Trí Tín";
		String s2 = "Tín";
// Tìm chuỗi s2 trong s1
		System.out.println(s1.indexOf(s2));

// Tìm ký tự n trong chuỗi s1
		char c1 = 'n';
		System.out.println(s1.indexOf(c1));
// Tìm ký tự n bắt đầu từ vị trí thứ 6 trong chuỗi
		System.out.println(s1.indexOf(c1, 6));

//Tìm từ phải qua trái
		System.out.println(s1.lastIndexOf(c1));

		String s3 = "Trí";
		System.out.println(s1.indexOf(s3, 10));
		System.out.println(s1.indexOf(s3, 5));

	}

}
