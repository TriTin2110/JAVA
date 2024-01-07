package QuanLySinhVienGiaoDien.QuanLySinhVienModel;

import java.io.Serializable;
import java.util.ArrayList;

public class QueQuan implements Serializable {
	private String tenTinhThanh;
	private int maTinhThanh;

	public QueQuan() {
	}

	public QueQuan(String tenTinhThanh, int maTinhThanh) {
		this.tenTinhThanh = tenTinhThanh;
		this.maTinhThanh = maTinhThanh;
	}

	public String getTenTinhThanh() {
		return tenTinhThanh;
	}

	void setTenTinhThanh(String tenTinhThanh) {
		this.tenTinhThanh = tenTinhThanh;
	}

	int getMaTinhThanh() {
		return maTinhThanh;
	}

	void setMaTinhThanh(int maTinhThanh) {
		this.maTinhThanh = maTinhThanh;
	}

	public static ArrayList<QueQuan> getTinh() {
		String[] list = { "", "An Giang", "Bà rịa Vũng Tàu", "Bạc Liêu", "Bắc Giang", "Bắc Kạn", "Bắc Ninh", "Bến Tre",
				"Bình Dương", "Bình Định", "Bình Phước", "Bình Thuận", "Cà Mau", "Cao Bằng", "Cần Thơ", "Đà Nẵng",
				"Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội",
				"Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang",
				"Kon Tum", "Lai Châu", "Lạng Sơn", "Lào Cai", "Lâm Đồng", "Long An", "Nam Định", "Nghệ An", "Ninh Bình",
				"Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị",
				"Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế",
				"Tiền Giang", "TP Hồ Chí Minh", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái" };
		ArrayList<QueQuan> listQueQuan = new ArrayList<QueQuan>();
		int i = 0;
		for (String string : list) {
			QueQuan queQuan = new QueQuan(string, i);
			listQueQuan.add(queQuan);
			i++;
		}
		return listQueQuan;
	}

	public static QueQuan getID(int maTinh) {
		// TODO Auto-generated method stub
		ArrayList<QueQuan> queQuan = getTinh();
		for (QueQuan queQuan2 : queQuan) {
			if (queQuan2.getMaTinhThanh() == maTinh) {
				return queQuan2;
			}
		}
		return null;
	}

	public static QueQuan getID(String tenTinh) {
		// TODO Auto-generated method stub
		ArrayList<QueQuan> queQuan = getTinh();
		for (QueQuan queQuan2 : queQuan) {
			if (queQuan2.getTenTinhThanh() == tenTinh) {
				return queQuan2;
			}
		}
		return null;
	}
}
