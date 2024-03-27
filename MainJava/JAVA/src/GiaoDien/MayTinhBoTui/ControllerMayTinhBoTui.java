package GiaoDien.MayTinhBoTui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ControllerMayTinhBoTui implements ActionListener {
	ViewMayTinhBoTui viewMayTinhBoTui;
	String phepTinh = "";

	int index = 0;

	public ControllerMayTinhBoTui(ViewMayTinhBoTui viewMayTinhBoTui) {
		this.viewMayTinhBoTui = viewMayTinhBoTui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean tiepTuc = true;
		String luaChon = e.getActionCommand();
		if (luaChon != "=" && tiepTuc == true) {
			// Xuất phép tính ra màn hình
			this.viewMayTinhBoTui.hienThi(luaChon);
			if (!Character.isDigit(luaChon.charAt(0))) {
				// Xử lý phép tính
				switch (luaChon) {
				case "+":
					phepTinh = "+";
					tiepTuc = false;
					break;
				case "-":
					phepTinh = "-";
					tiepTuc = false;
					break;
				case "*":
					phepTinh = "*";
					tiepTuc = false;
					break;
				case "/":
					phepTinh = "/";
					tiepTuc = false;
					break;
				case "^":
					phepTinh = "^";
					tiepTuc = false;
					break;
				case "√":
					phepTinh = "√";
					tiepTuc = false;
					break;
				case "Ans":
					phepTinh = "Ans";
					tiepTuc = false;
					break;
				case "AC":
					this.viewMayTinhBoTui.resetGiaTri();
					tiepTuc = true;
					phepTinh = "";
					break;
				case "DEL":
					this.viewMayTinhBoTui.xoaGiaTri();
					break;
				}
			}
		} else {
			String hienThi = this.viewMayTinhBoTui.hienThi;
			index = hienThi.indexOf(phepTinh);
			// Nếu phép tính xuất hiện ở đầu
			if (index == 0) {
				// Khi đó sẽ không thể tính toán
				this.viewMayTinhBoTui.phepTinhKhongHopLe();
			} else if (index == hienThi.length() - 1) {
				// Nếu phép tính xuất hiện ở cuối
				// Khi đó sẽ không thể tính toán
				this.viewMayTinhBoTui.phepTinhKhongHopLe();
			}

			else {
				String[] cacPhepTinh = { "+", "-", "*", "/", "^", "√" };
				boolean dieuKienHopLe = false;
				out: for (String string : cacPhepTinh) {
					if (hienThi.contains(string)) {
						this.viewMayTinhBoTui.xuatKetQua();
						// Nếu người dùng đã nhập phép tính
						// Trả về dieuKienHopLe=true
						dieuKienHopLe = true;
						break out;
					}
				}
				if (dieuKienHopLe == false) {
					this.viewMayTinhBoTui.phepTinhKhongHopLe();
				}
			}
			tiepTuc = true;
		}

	}

}
