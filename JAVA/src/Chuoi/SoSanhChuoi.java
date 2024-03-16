package Chuoi;

class SoSanhChuoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Nguyễn Trí Tín";
		String s2 = "Nguyễn Trí";
		String s3 = "Nguyễn Trí Tín";
		String s4 = "Trí Tín";
		System.out.println("Chuỗi s1 có bằng với chuỗi s2 không?: " + s1.equals(s2));
		// =
		System.out.println(s1.matches(s3));
		System.out.println(s1.compareTo(s2));
		System.out.println(s1.compareTo(s3));
		System.out.println(s1.compareTo(s4));
		System.out.println(s4.startsWith("Nguyễn"));
	}

}
