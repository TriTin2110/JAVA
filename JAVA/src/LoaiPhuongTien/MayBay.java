package LoaiPhuongTien;

class MayBay extends LoaiPhuongTien {

	public MayBay(NgaySanXuat ngay, HangSanXuat hsx, String tenPhuongTien) {
		super(ngay, hsx, tenPhuongTien);
		// TODO Auto-generated constructor stub
	}

	@Override
	double tinhVanToc(double vanToc) {
		// TODO Auto-generated method stub
		return vanToc;
	}

	@Override
	String inThongTin() {
		// TODO Auto-generated method stub
		return getTenPhuongTien() + "\n" + ngay.toString() + "\n" + hsx.getTenHang() + "\n" + hsx.getQuocGia() + "\n";
	}

}
