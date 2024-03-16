package ArrowFunction;

class TinhDienTichHinhChuNhat {
	public static void main(String[] args) {
		ChuNhat cn = (a, b) -> {
			return a * b;
		};
		System.out.println(cn.dienTich(5, 10));
	}
}
