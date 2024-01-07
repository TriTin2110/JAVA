
class NoiChuoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Trí";
		String s2 = "Tín";
		String s3 = s1.concat(s2); // s1 sẽ không thay đổi nên tạo 1 biến s3 để lưu giá trị sau đổi
		System.out.println(s3);

//Trim sẽ xóa khoảng trắng ở đầu và cuối chuỗi
		String s4 = "  Trí Tín    ";
		System.out.println(s4.trim());

// chuoi_se_thay.replaceAll(chuoi_muon_thay, chuoi_thay);
		String s5 = "Nguyễn";
		System.out.println(s4.replaceAll("Trí", s5));
//chuoi_se_cat.subSequence(tu_dau, den_dau)
		System.out.println(s5.subSequence(0, 3));
	}

}
